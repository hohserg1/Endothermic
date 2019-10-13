package hohserg.baked.quad.lens.immutable

import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.higherKinds

trait RelevantCombiner[R] {
  type C[_]

  def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result
}

object RelevantCombiner {
  type Aux[R, C0[_]] = RelevantCombiner[R] {type C[Result] = C0[Result]}
}
