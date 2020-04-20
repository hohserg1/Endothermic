package hohserg.endothermic.lense

import hohserg.endothermic.format.AttributeRepresentation.AttributeId
import hohserg.endothermic.format.UnpackEvaluations
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.vertex.VertexFormat

object QuadAttributeLens {

  def get(attributeId: AttributeId, quad: BakedQuad): Float =
    UnpackEvaluations.getFormatParseRule(quad.getFormat).get(attributeId).map(_.unpack(quad.getVertexData)).getOrElse(0)


  def set(attributeId: AttributeId, quad: BakedQuad, value: Float): Unit =
    UnpackEvaluations.getFormatParseRule(quad.getFormat).get(attributeId).foreach(_.pack(value, quad.getVertexData))

  def get(attributeId: AttributeId, format:VertexFormat,vertexData:Array[Int]): Float =
    UnpackEvaluations.getFormatParseRule(format).get(attributeId).map(_.unpack(vertexData)).getOrElse(0)


  def set(attributeId: AttributeId, format:VertexFormat,vertexData:Array[Int], value: Float): Unit =
    UnpackEvaluations.getFormatParseRule(format).get(attributeId).foreach(_.pack(value, vertexData))



}
