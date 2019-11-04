package hohserg.endothermic.immutable

import hohserg.endothermic.format.AttributeRepresentation._
import net.minecraft.client.renderer.vertex.VertexFormat


case class UnpackedQuad(
                         quadData: Array[Int],
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
    UnpackedQuad(quadData,
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
      quadData,
      new UnpackedVertex[_1](),
      new UnpackedVertex[_2](),
      new UnpackedVertex[_3](),
      new UnpackedVertex[_4]()
    )
  }

  UnpackedQuad(???, ???).updated(v2f = v => v.copy(x = v.x + 1)).toRawArray
}
