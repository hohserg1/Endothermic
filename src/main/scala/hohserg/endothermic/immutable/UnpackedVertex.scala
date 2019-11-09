package hohserg.endothermic.immutable

import hohserg.endothermic.BaseUnpackedVertex
import hohserg.endothermic.format.AttributeRepresentation.Vertex
import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.dynamics

class UnpackedVertex[V <: Vertex]()(implicit protected val quadData: Array[Int], protected val format: VertexFormat, protected val vertex: V) extends BaseUnpackedVertex[V] {
  override type Self = UnpackedVertex[V]

  override def getUpdateDestination(): UnpackedVertex[V] = new UnpackedVertex[V]()(quadData, format, vertex)
}
