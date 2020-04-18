package hohserg.endothermic.lense

import hohserg.endothermic.format.AttributeRepresentation.AttributeId
import hohserg.endothermic.format.UnpackEvaluations
import net.minecraft.client.renderer.block.model.BakedQuad

object QuadAttributeLens {

  def get(attributeId: AttributeId, quad: BakedQuad): Float = {
    UnpackEvaluations.getFormatParseRule(quad.getFormat).get(attributeId).map(_.unpack(quad)).getOrElse(0)
  }

  def set(attributeId: AttributeId, quad: BakedQuad, value: Float): Unit = {
    UnpackEvaluations.getFormatParseRule(quad.getFormat).get(attributeId).foreach(_.pack(value, quad.getVertexData))
  }


}
