package hohserg.endothermic.mutable

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

  def updateAttributeElement(value: Float, index: Int): Unit = {
    initFlag |= (1 << index)
    changeFlag |= (1 << index)
    values(index) = value
  }

  def x_=(v: Float): Unit = updateAttributeElement(v, 0)

  def y_=(v: Float): Unit = updateAttributeElement(v, 1)

  def z_=(v: Float): Unit = updateAttributeElement(v, 2)

  def u_=(v: Float): Unit = updateAttributeElement(v, 3)

  def v_=(v: Float): Unit = updateAttributeElement(v, 4)

  private[quad] def toRawArray(r: Array[Int]): Unit = {
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

class UnpackedQuad(
                    quadData: Array[Int], val format: VertexFormat,
                    val v1: UnpackedVertex[_1],
                    val v2: UnpackedVertex[_2],
                    val v3: UnpackedVertex[_3],
                    val v4: UnpackedVertex[_4]
                  ) {

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
    new UnpackedQuad(
      quadData, format,
      new UnpackedVertex[_1](),
      new UnpackedVertex[_2](),
      new UnpackedVertex[_3](),
      new UnpackedVertex[_4]()
    )
  }

  private val unpackedQuad = UnpackedQuad(???, ???)
  unpackedQuad.v2.x += 1
  unpackedQuad.toRawArray
}
