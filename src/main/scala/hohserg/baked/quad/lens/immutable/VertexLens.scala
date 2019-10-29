package hohserg.baked.quad.lens.immutable

import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat, VertexFormatElement}

import scala.language.higherKinds

object VertexLens {

  def pack[V <: Vertex, A <: VertexAttribute](value: Float, to: Array[Int], i: Int)(implicit
                                                                                    vertexStart: VertexStart[V, A],
                                                                                    `type`: ElementEnumType[A],
                                                                                    size: ElementSize[A],
                                                                                    mask: ElementMask[A]): Unit = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits = 0
    if (`type`.v eq VertexFormatElement.EnumType.FLOAT)
      bits = java.lang.Float.floatToRawIntBits(value)
    else if ((`type`.v eq VertexFormatElement.EnumType.UBYTE) || (`type`.v eq VertexFormatElement.EnumType.USHORT) || (`type`.v eq VertexFormatElement.EnumType.UINT))
      bits = (value * mask.v).round
    else
      bits = (value * (mask.v >> 1)).round

    to(index) &= ~mask.v << (offset * 8)
    to(index) |= (bits & mask.v) << (offset * 8)
    // TODO handle overflow into to[index + 1]
  }

  sealed abstract class AttributeElementValue[V <: Vertex, A <: VertexAttribute] {
    type T

    def apply(s: Float): T

    def unwrap(lbl: T): Float
  }

  type AEV[V <: Vertex, A <: VertexAttribute] = AttributeElementValue[V, A]#T

  implicit def attributeElementValue[V <: Vertex, A <: VertexAttribute]: AttributeElementValue[V, A] = new AttributeElementValue[V, A] {
    type T = Float

    override def apply(s: Float): T = s

    override def unwrap(lbl: T): Float = lbl
  }

  def unpack[V <: Vertex, A <: VertexAttribute](i: Int)(implicit
                                                        quadData: Array[Int],
                                                        vertexStart: VertexStart[V, A],
                                                        `type`: ElementEnumType[A],
                                                        size: ElementSize[A],
                                                        mask: ElementMask[A],
                                                        parser: AttributeParser[A],
                                                        valuePacker: AttributeElementValue[V, A]
  ): Float = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits: Int = quadData(index)
    bits = bits >>> (offset * 8)
    if ((pos + size.v - 1) / 4 != index) bits |= quadData(index + 1) << ((4 - offset) * 8)
    bits &= mask.v

    //valuePacker(
    parser.parse(bits, mask)
    //)
  }

  implicit def elementMask[A <: VertexAttribute](implicit size: ElementSize[A]): ElementMask[A] =
    ElementMask((256 << (8 * (size.v - 1))) - 1)

  implicit def elementSize[A <: VertexAttribute](implicit `type`: ElementEnumType[A]): ElementSize[A] =
    ElementSize(`type`.v.getSize)

  implicit def elementType[A <: VertexAttribute](implicit format: VertexFormat, e: ElementIndex[A]): ElementEnumType[A] =
    ElementEnumType(format.getElement(e.v).getType)

  implicit def vertexStart[V <: Vertex, A <: VertexAttribute](implicit vertex: V, format: VertexFormat, e: ElementIndex[A]): VertexStart[V, A] =
    VertexStart(vertex.index * format.getNextOffset + format.getOffset(e.v))

  implicit def indexOfElement[A <: VertexAttribute](implicit format: VertexFormat, attribute: A): ElementIndex[A] =
    ElementIndex(format.getElements.indexOf(attribute.element))

  sealed trait VertexAttribute {
    def element: VertexFormatElement
  }

  sealed trait POSITION_3F extends VertexAttribute

  implicit val POSITION_3F: POSITION_3F = new POSITION_3F {
    override val element: VertexFormatElement = DefaultVertexFormats.POSITION_3F
  }

  sealed trait COLOR_4UB extends VertexAttribute

  implicit val COLOR_4UB: COLOR_4UB = new COLOR_4UB {
    override val element: VertexFormatElement = DefaultVertexFormats.COLOR_4UB
  }

  sealed trait TEX_2F extends VertexAttribute

  implicit val TEX_2F: TEX_2F = new TEX_2F {
    override val element: VertexFormatElement = DefaultVertexFormats.TEX_2F
  }

  sealed trait TEX_2S extends VertexAttribute

  implicit val TEX_2S: TEX_2S = new TEX_2S {
    override val element: VertexFormatElement = DefaultVertexFormats.TEX_2S
  }

  sealed trait NORMAL_3B extends VertexAttribute

  implicit val NORMAL_3B: NORMAL_3B = new NORMAL_3B {
    override val element: VertexFormatElement = DefaultVertexFormats.NORMAL_3B
  }

  sealed trait PADDING_1B extends VertexAttribute

  implicit val PADDING_1B: PADDING_1B = new PADDING_1B {
    override val element: VertexFormatElement = DefaultVertexFormats.PADDING_1B
  }


  sealed trait Vertex {
    def index: Int
  }

  sealed trait _1 extends Vertex

  implicit val _1: _1 = new _1 {
    override val index: Int = 0
  }

  sealed trait _2 extends Vertex

  implicit val _2: _2 = new _2 {
    override val index: Int = 1
  }

  sealed trait _3 extends Vertex

  implicit val _3: _3 = new _3 {
    override val index: Int = 2
  }

  sealed trait _4 extends Vertex

  implicit val _4: _4 = new _4 {
    override val index: Int = 3
  }

  case class ElementIndex[A <: VertexAttribute](v: Int) extends AnyVal

  case class VertexStart[V <: Vertex, A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementSize[A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementMask[A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementEnumType[A <: VertexAttribute](v: VertexFormatElement.EnumType) extends AnyVal

}
