package hohserg.endothermic.mutable

import hohserg.endothermic.BaseUnpackedQuad
import hohserg.endothermic.format.AttributeRepresentation._
import net.minecraft.client.renderer.vertex.VertexFormat


class UnpackedQuad(
                    quadData: Array[Int], val format: VertexFormat,
                    val v1: UnpackedVertex[_1],
                    val v2: UnpackedVertex[_2],
                    val v3: UnpackedVertex[_3],
                    val v4: UnpackedVertex[_4]
                  ) extends BaseUnpackedQuad {
  lazy val toRawArray: Array[Int] = {
    val r = quadData.clone()

    v1.toRawArray(r)
    v2.toRawArray(r)
    v3.toRawArray(r)
    v4.toRawArray(r)

    r
  }

  override type Self = UnpackedQuad

  override type VertexType[V <: Vertex] = UnpackedVertex[V]

  override def reconstruct(v1: VertexType[_1], v2: VertexType[_2], v3: VertexType[_3], v4: VertexType[_4]): Self = this
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
