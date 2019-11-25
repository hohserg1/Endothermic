package hohserg.endothermic.immutable

import hohserg.endothermic.BaseUnpackedQuad
import hohserg.endothermic.format.AttributeRepresentation._
import net.minecraft.client.renderer.vertex.VertexFormat


case class UnpackedQuad(
                         quadData: Array[Int],
                         v1: UnpackedVertex[_1],
                         v2: UnpackedVertex[_2],
                         v3: UnpackedVertex[_3],
                         v4: UnpackedVertex[_4]
                       ) extends BaseUnpackedQuad {

  override type Self = UnpackedQuad

  override def reconstruct(v1: VertexType[_1], v2: VertexType[_2], v3: VertexType[_3], v4: VertexType[_4]): Self =
    UnpackedQuad(quadData, v1, v2, v3, v4)

  def updated(
               v1f: VertexType[_1] => VertexType[_1] = identity,
               v2f: VertexType[_2] => VertexType[_2] = identity,
               v3f: VertexType[_3] => VertexType[_3] = identity,
               v4f: VertexType[_4] => VertexType[_4] = identity
             ): UnpackedQuad = {
    UnpackedQuad(quadData,
      v1f(v1),
      v2f(v2),
      v3f(v3),
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

  override type VertexType[V <: Vertex] = UnpackedVertex[V]
}

object UnpackedQuad {


  def apply(implicit quadData: Array[Int], format: VertexFormat): UnpackedQuad = {
    UnpackedQuad(
      quadData,
      new UnpackedVertex[_1](),
      new UnpackedVertex[_2](),
      new UnpackedVertex[_3](),
      new UnpackedVertex[_4]()
    )
  }

  UnpackedQuad(???, ???).updated(v2f = v => v.reconstruct[_2](x = v.x + 1)).toRawArray
}
