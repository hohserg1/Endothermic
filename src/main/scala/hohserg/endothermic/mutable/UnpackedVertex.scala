package hohserg.endothermic.mutable

import hohserg.endothermic.format.AttributeParser
import hohserg.endothermic.format.AttributeRepresentation.{POSITION_3F, TEX_2F, Vertex, VertexAttribute}
import hohserg.endothermic.format.UnpackEvaluations.{pack, unpack}
import net.minecraft.client.renderer.vertex.VertexFormat

class UnpackedVertex[V <: Vertex]()(implicit quadData: Array[Int], format: VertexFormat, vertex: V) {

  private val values: Array[Float] = new Array[Float](5)

  private[endothermic] var initFlag: Int = _
  private[endothermic] var changeFlag: Int = _

  private def genericLazyVal[A <: VertexAttribute](index: Int, vertexElement: Int)(implicit a: A, parser: AttributeParser[A]) = {
    if ((initFlag & (1 << index)) == 0) {
      initFlag |= (1 << index)
      values(index) = unpack[V, A](quadData,vertexElement)
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

  private[endothermic] def toRawArray(r: Array[Int]): Unit = {
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
