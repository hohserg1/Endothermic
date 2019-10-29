package hohserg.endothermic.immutable

import hohserg.baked.quad.lens.immutable.AttributeParser
import hohserg.baked.quad.lens.immutable.VertexLens._
import net.minecraft.client.renderer.vertex.VertexFormat

class UnpackedVertex[V <: Vertex]()(implicit quadData: Array[Int], format: VertexFormat, vertex: V) {

  private val values: Array[Float] = new Array[Float](5)

  private[quad] var initFlag: Int = _
  private[quad] var changeFlag: Int = _

  private def genericLazyVal[A <: VertexAttribute](index: Int, vertexElement: Int)(implicit a: A, parser: AttributeParser[A]) = {
    if ((initFlag & (1 << index)) == 0) {
      initFlag |= (1 << index)
      values(index) = unpack[V, A](vertexElement)
    }
    values(index)
  }

  def x: Float = genericLazyVal[POSITION_3F](0, 0)


  def y: Float = genericLazyVal[POSITION_3F](1, 1)


  def z: Float = genericLazyVal[POSITION_3F](2, 2)


  def u: Float = genericLazyVal[TEX_2F](3, 0)


  def v: Float = genericLazyVal[TEX_2F](4, 1)


  def copy(
            x: Float = values(0),
            y: Float = values(1),
            z: Float = values(2),
            u: Float = values(3),
            v: Float = values(4)
          ): UnpackedVertex[V] = {
    val r = new UnpackedVertex[V]()(quadData, format, vertex)

    def checkAndUpdateAttributeElement(value: Float, index: Int): Unit = {
      if (value != values(index) || (initFlag & (1 << index)) == 0) {
        r.initFlag |= (1 << index)
        r.changeFlag |= (1 << index)
        r.values(index) = value
      }
    }

    checkAndUpdateAttributeElement(x, 0)
    checkAndUpdateAttributeElement(y, 1)
    checkAndUpdateAttributeElement(z, 2)
    checkAndUpdateAttributeElement(u, 3)
    checkAndUpdateAttributeElement(v, 4)

    r
  }

  private[quad] def toRawArray(r: Array[Int]) = {
    def checkChangedAndPack[A <: VertexAttribute](index: Int, vertexElement: Int)(implicit a: A, parser: AttributeParser[A]): Unit = {
      if ((changeFlag & (1 << index)) != 0)
        pack[V, A](values(index), r, vertexElement)
    }

    checkChangedAndPack[POSITION_3F](0, 0)
    checkChangedAndPack[POSITION_3F](1, 1)
    checkChangedAndPack[POSITION_3F](2, 2)
    checkChangedAndPack[TEX_2F](3, 0)
    checkChangedAndPack[TEX_2F](4, 1)

  }

}

case class UnpackedQuad(
                         quadData: Array[Int], format: VertexFormat,
                         v1: UnpackedVertex[_1],
                         v2: UnpackedVertex[_2],
                         v3: UnpackedVertex[_3],
                         v4: UnpackedVertex[_4]
                       ) {

  def updated(
               v1f: UnpackedVertex[_1] => UnpackedVertex[_1] = null,
               v2f: UnpackedVertex[_2] => UnpackedVertex[_2] = null,
               v3f: UnpackedVertex[_3] => UnpackedVertex[_3] = null,
               v4f: UnpackedVertex[_4] => UnpackedVertex[_4] = null
             ): UnpackedQuad = {
    UnpackedQuad(quadData, format,
      if (v1f == null)
        v1
      else
        v1f(v1)
      ,
      if (v2f == null)
        v2
      else
        v2f(v2)
      ,
      if (v3f == null)
        v3
      else
        v3f(v3)
      ,
      if (v4f == null)
        v4
      else
        v4f(v4)
    )

  }

  lazy val toRawArray: Array[Int] = {
    val r = quadData.clone()

    v1.toRawArray(r)
    v2.toRawArray(r)
    v3.toRawArray(r)
    v4.toRawArray(r)

    r
  }
}

object UnpackedQuad {


  def apply(implicit quadData: Array[Int], format: VertexFormat): UnpackedQuad = {
    UnpackedQuad(
      quadData, format,
      new UnpackedVertex[_1](),
      new UnpackedVertex[_2](),
      new UnpackedVertex[_3](),
      new UnpackedVertex[_4]()
    )
  }

  UnpackedQuad(???, ???).updated(v2f = v => v.copy(x = v.x + 1)).toRawArray
}
