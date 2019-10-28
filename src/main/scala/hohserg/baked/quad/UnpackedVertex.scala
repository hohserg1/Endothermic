package hohserg.baked.quad

import hohserg.baked.quad.lens.immutable.VertexLens._
import net.minecraft.client.renderer.vertex.VertexFormat

case class UnpackedVertex[V <: Vertex](
                                        x: AEV[V, POSITION_3F],
                                        y: AEV[V, POSITION_3F],
                                        z: AEV[V, POSITION_3F],
                                        u: AEV[V, TEX_2F],
                                        v: AEV[V, TEX_2F]) {

}

case class UnpackedQuad(
                         v1: UnpackedVertex[_1],
                         v2: UnpackedVertex[_2],
                         v3: UnpackedVertex[_3],
                         v4: UnpackedVertex[_4]
                       )

object UnpackedQuad {


  def apply(quadData: Array[Int], format: VertexFormat): UnpackedQuad = {
    implicit val format1 = format
    implicit val quadData1 = quadData

    val value1: UnpackedVertex[_2] = UnpackedVertex[_2](
      unpack[_2, POSITION_3F](0),
      unpack[_2, POSITION_3F](1),
      unpack[_2, POSITION_3F](2),

      unpack[_2, TEX_2F](0),
      unpack[_2, TEX_2F](1)
    )

    UnpackedQuad(
      UnpackedVertex(
        unpack[_1, POSITION_3F](0),
        unpack[_1, POSITION_3F](1),
        unpack[_1, POSITION_3F](2),

        unpack[_1, TEX_2F](0),
        unpack[_1, TEX_2F](1)
      ),
      value1,
      ???, ???
    )
  }
}
