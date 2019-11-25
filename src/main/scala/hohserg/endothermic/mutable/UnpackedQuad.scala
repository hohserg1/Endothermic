package hohserg.endothermic.mutable

import hohserg.endothermic.BaseQuad

case class UnpackedQuad(
                         v1: UnpackedVertex,
                         v2: UnpackedVertex,
                         v3: UnpackedVertex,
                         v4: UnpackedVertex
                       ) extends BaseQuad {
  override type LocalVertex = UnpackedVertex

}
