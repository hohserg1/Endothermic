package hohserg.baked.quad.lens.immutable

import RelevantCombinerProvider._

import hohserg.baked.quad.lens.Requirement
import hohserg.baked.quad.lens.lambda.Combiners._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat}

import scala.language.higherKinds

object GenericLens extends App with SetLensThings {

  def get[R, C[_], Result](quadData: Array[Int], format: VertexFormat, requirements: R, combiner: C[Result])
                          (implicit
                           relevantCombiner: RelevantCombiner.Aux[R, C]): Result = {
    relevantCombiner.apply(quadData, format, combiner)
  }

  //def setAll(format: VertexFormat,)


  private val test: Float = get(Array(), DefaultVertexFormats.ITEM, Requirement.Pos1, PosCombiner((x: Float, y: Float, z: Float) => 0f))
  println(test)

}
