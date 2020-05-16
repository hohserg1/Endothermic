package hohserg.endothermic.lense

import hohserg.endothermic.format.AttributeRepresentation._

object LensOps {

  val allX = Seq(x_1, x_2, x_3, x_4)
  val allY = Seq(y_1, y_2, y_3, y_4)
  val allZ = Seq(z_1, z_2, z_3, z_4)

  def translate(lense: QuadAttributeLens, vertexData: Array[Int], x: Float, y: Float, z: Float): Unit = {
    import lense._
    allX.foreach(a => set(a, vertexData, get(a, vertexData) + x))
    allY.foreach(a => set(a, vertexData, get(a, vertexData) + y))
    allZ.foreach(a => set(a, vertexData, get(a, vertexData) + z))
  }

  def scale(lense: QuadAttributeLens, vertexData: Array[Int], x: Float, y: Float, z: Float): Unit = {
    import lense._
    allX.foreach(a => set(a, vertexData, get(a, vertexData) * x))
    allY.foreach(a => set(a, vertexData, get(a, vertexData) * y))
    allZ.foreach(a => set(a, vertexData, get(a, vertexData) * z))
  }

}
