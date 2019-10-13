package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat, VertexFormatElement}

trait VertexLens {

  protected implicit def elementMask[A <: VertexAttribute](implicit size: ElementSize[A]): ElementMask[A] =
    ElementMask((256 << (8 * (size.v - 1))) - 1)

  protected implicit def elementSize[A <: VertexAttribute](implicit `type`: ElementEnumType[A]): ElementSize[A] =
    ElementSize(`type`.v.getSize)

  protected implicit def elementType[A <: VertexAttribute](implicit format: VertexFormat, e: ElementIndex[A]): ElementEnumType[A] =
    ElementEnumType(format.getElement(e.v).getType)

  protected implicit def vertexStart[V <: Vertex, A <: VertexAttribute](implicit vertex: V, format: VertexFormat, e: ElementIndex[A]): VertexStart[V, A] =
    VertexStart(vertex.index * format.getNextOffset + format.getOffset(e.v))

  protected implicit def indexOfElement[A <: VertexAttribute](implicit format: VertexFormat, attribute: A): ElementIndex[A] =
    ElementIndex(format.getElements.indexOf(attribute.element))

}

object VertexLens {

  sealed trait VertexAttribute {
    def element: VertexFormatElement
  }

  sealed trait POSITION_3F extends VertexAttribute

  implicit case object POSITION_3F extends POSITION_3F {
    override val element: VertexFormatElement = DefaultVertexFormats.POSITION_3F
  }

  sealed trait COLOR_4UB extends VertexAttribute

  implicit case object COLOR_4UB extends COLOR_4UB {
    override val element: VertexFormatElement = DefaultVertexFormats.COLOR_4UB
  }

  sealed trait TEX_2F extends VertexAttribute

  implicit case object TEX_2F extends TEX_2F {
    override val element: VertexFormatElement = DefaultVertexFormats.TEX_2F
  }

  sealed trait TEX_2S extends VertexAttribute

  implicit case object TEX_2S extends TEX_2S {
    override val element: VertexFormatElement = DefaultVertexFormats.TEX_2S
  }

  sealed trait NORMAL_3B extends VertexAttribute

  implicit case object NORMAL_3B extends NORMAL_3B {
    override val element: VertexFormatElement = DefaultVertexFormats.NORMAL_3B
  }

  sealed trait PADDING_1B extends VertexAttribute

  implicit case object PADDING_1B extends PADDING_1B {
    override val element: VertexFormatElement = DefaultVertexFormats.PADDING_1B
  }


  sealed trait Vertex {
    def index: Int
  }

  sealed trait _1 extends Vertex

  implicit case object _1 extends _1 {
    override val index: Int = 0
  }

  sealed trait _2 extends Vertex

  implicit case object _2 extends _2 {
    override val index: Int = 1
  }

  sealed trait _3 extends Vertex

  implicit case object _3 extends _3 {
    override val index: Int = 2
  }

  sealed trait _4 extends Vertex

  implicit case object _4 extends _4 {
    override val index: Int = 3
  }

  case class ElementIndex[A <: VertexAttribute](v: Int) extends AnyVal

  case class VertexStart[V <: Vertex, A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementSize[A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementMask[A <: VertexAttribute](v: Int) extends AnyVal

  case class ElementEnumType[A <: VertexAttribute](v: VertexFormatElement.EnumType) extends AnyVal

}
