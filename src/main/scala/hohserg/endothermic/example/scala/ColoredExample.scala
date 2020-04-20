package hohserg.endothermic.example.scala

import hohserg.endothermic.quad.immutable.UnpackedQuad
import net.minecraft.client.renderer.block.model.BakedQuad

class ColoredExample extends (BakedQuad => BakedQuad) {
  override def apply(v1: BakedQuad): BakedQuad =
    UnpackedQuad(v1)
      .reconstruct(
        v1_r = 255, //colored first vertex to red
        v2_g = 255, //colored second vertex to green
        v3_b = 255 //colored third vertex to blue
      )
      .toBakedQuad
}