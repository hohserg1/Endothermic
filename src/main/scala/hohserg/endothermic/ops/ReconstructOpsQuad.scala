package hohserg.endothermic.ops

import hohserg.endothermic.BaseUnpackedVertex
import hohserg.endothermic.format.AttributeRepresentation.{Vertex, _1, _2, _3, _4}

import scala.language.higherKinds

trait ReconstructOpsQuad {
  type VertexType[V<:Vertex] <: BaseUnpackedVertex[V]
  type Self <: ReconstructOpsQuad

  def v1: VertexType[_1]

  def v2: VertexType[_2]

  def v3: VertexType[_3]

  def v4: VertexType[_4]

  def reconstruct(v1: VertexType[_1]#Self,
                  v2: VertexType[_2]#Self,
                  v3: VertexType[_3]#Self,
                  v4: VertexType[_4]#Self): Self
}