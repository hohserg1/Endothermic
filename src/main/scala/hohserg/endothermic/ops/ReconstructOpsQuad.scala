package hohserg.endothermic.ops

import hohserg.endothermic.BaseUnpackedVertex
import hohserg.endothermic.format.AttributeRepresentation.{Vertex, _1, _2, _3, _4}

import scala.language.higherKinds

trait ReconstructOpsQuad {
  type Self <: ReconstructOpsQuad
  type VertexType[+V <: Vertex] <: BaseUnpackedVertex[V]

  def v1: VertexType[_1]

  def v2: VertexType[_2]

  def v3: VertexType[_3]

  def v4: VertexType[_4]

  def reconstruct(v1: VertexType[_1],
                  v2: VertexType[_2],
                  v3: VertexType[_3],
                  v4: VertexType[_4]): Self


  def foreachVertex(f: VertexType[Vertex] => VertexType[Vertex]): Self =
    reconstruct(
      f(v1).asInstanceOf[VertexType[_1]],
      f(v2).asInstanceOf[VertexType[_2]],
      f(v3).asInstanceOf[VertexType[_3]],
      f(v4).asInstanceOf[VertexType[_4]]
    )
}