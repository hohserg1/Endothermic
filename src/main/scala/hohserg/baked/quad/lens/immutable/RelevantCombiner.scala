package hohserg.baked.quad.lens.immutable

import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.higherKinds

trait RelevantCombiner[R] {
  type C

  def apply(quadData: Array[Int], format: VertexFormat, combiner: C): Any
}

object RelevantCombiner {
  type Aux[R, C0] = RelevantCombiner[R] {type C = C0}
}
