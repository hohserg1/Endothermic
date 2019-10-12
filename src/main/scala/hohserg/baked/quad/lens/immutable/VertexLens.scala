package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens._
import net.minecraft.client.renderer.vertex.{VertexFormat, VertexFormatElement}

trait VertexLens {


  protected implicit def elementMask[V <: Vertex](implicit size: ElementSize[V]): ElementMask[V] =
    ElementMask((256 << (8 * (size.v - 1))) - 1)

  protected implicit def elementSize[V <: Vertex](implicit `type`: VertexFormatElement.EnumType): ElementSize[V] =
    ElementSize(`type`.getSize)

  protected implicit def elementType[V <: Vertex](implicit format: VertexFormat, e: ElementIndex[V]): VertexFormatElement.EnumType =
    format.getElement(e.v).getType

  protected implicit def vertexStart[V <: Vertex](implicit vertex: V, format: VertexFormat, e: ElementIndex[V]): VertexStart[V] =
    VertexStart(vertex.index * format.getNextOffset + format.getOffset(e.v))

  protected implicit def indexOfElement[V <: Vertex](implicit format: VertexFormat, element: VertexFormatElement): ElementIndex[V] =
    ElementIndex(format.getElements.indexOf(element))

}

object VertexLens {

  implicit val v1: _1 = _1
  implicit val v2: _2 = _2
  implicit val v3: _3 = _3
  implicit val v4: _4 = _4

  sealed trait Vertex {
    def index: Int
  }

  sealed trait _1 extends Vertex

  case object _1 extends _1 {
    override val index: Int = 0
  }

  sealed trait _2 extends Vertex

  case object _2 extends _2 {
    override val index: Int = 1
  }

  sealed trait _3 extends Vertex

  case object _3 extends _3 {
    override val index: Int = 2
  }

  sealed trait _4 extends Vertex

  case object _4 extends _4 {
    override val index: Int = 3
  }

  case class ElementIndex[V <: Vertex](v: Int) extends AnyVal

  case class VertexStart[V <: Vertex](v: Int) extends AnyVal

  case class ElementSize[V <: Vertex](v: Int) extends AnyVal

  case class ElementMask[V <: Vertex](v: Int) extends AnyVal

}
