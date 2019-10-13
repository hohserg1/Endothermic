package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens._
import hohserg.baked.quad.lens.lambda.Combiners._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat}
import shapeless.{::, HList, HNil}

import scala.language.higherKinds

object GenericLens extends App with VertexLens {

  def get[R <: HList, C[_], Result](quadData: Array[Int], format: VertexFormat, requirements: R, combiner: C[Result])
                                   (implicit
                                    relevantCombiner: RelevantCombiner.Aux[R, C]): Result = {
    relevantCombiner.apply(quadData, format, combiner)
  }

  implicit val colorCombiner: RelevantCombiner.Aux[COLOR_4UB.type :: HNil, ColorCombiner] = new RelevantCombiner[COLOR_4UB.type :: HNil] {
    override type C[Result] = ColorCombiner[Result]

    override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

      implicit lazy val ei1: ElementIndex[COLOR_4UB] = indexOfElement

      implicit lazy val et1: ElementEnumType[COLOR_4UB] = elementType

      implicit lazy val es1: ElementSize[COLOR_4UB] = elementSize


      combiner(
        unpack[_1, COLOR_4UB](quadData, 0),
        unpack[_1, COLOR_4UB](quadData, 1),
        unpack[_1, COLOR_4UB](quadData, 2),
        unpack[_1, COLOR_4UB](quadData, 3)
      )
    }
  }


  implicit val allPosCombiner: RelevantCombiner.Aux[POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: HNil, AllPosCombiner] = new RelevantCombiner[POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: HNil] {
    override type C[Result] = AllPosCombiner[Result]

    override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

      implicit lazy val ei1: ElementIndex[POSITION_3F] = indexOfElement

      implicit lazy val es1: ElementSize[POSITION_3F] = elementSize

      implicit lazy val et1: ElementEnumType[POSITION_3F] = elementType


      combiner(
        unpack[_1, POSITION_3F](quadData, 0),
        unpack[_1, POSITION_3F](quadData, 1),
        unpack[_1, POSITION_3F](quadData, 2),

        unpack[_2, POSITION_3F](quadData, 0),
        unpack[_2, POSITION_3F](quadData, 1),
        unpack[_2, POSITION_3F](quadData, 2),

        unpack[_3, POSITION_3F](quadData, 0),
        unpack[_3, POSITION_3F](quadData, 1),
        unpack[_3, POSITION_3F](quadData, 2),

        unpack[_4, POSITION_3F](quadData, 0),
        unpack[_4, POSITION_3F](quadData, 1),
        unpack[_4, POSITION_3F](quadData, 2)
      )
    }
  }


  implicit val posCombiner: RelevantCombiner.Aux[POSITION_3F.type :: HNil, PosCombiner] = new RelevantCombiner[POSITION_3F.type :: HNil] {
    override type C[Result] = PosCombiner[Result]

    override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

      implicit lazy val ei1: ElementIndex[POSITION_3F] = indexOfElement

      implicit lazy val es1: ElementSize[POSITION_3F] = elementSize

      implicit lazy val et1: ElementEnumType[POSITION_3F] = elementType

      combiner(
        unpack[_1, POSITION_3F](quadData, 0),
        unpack[_1, POSITION_3F](quadData, 1),
        unpack[_1, POSITION_3F](quadData, 2)
      )
    }
  }


  def unpack[V <: Vertex, A <: VertexAttribute](quadData: Array[Int], i: Int)(implicit
                                                                              vertexStart: VertexStart[V, A],
                                                                              `type`: ElementEnumType[A],
                                                                              size: ElementSize[A],
                                                                              mask: ElementMask[A],
                                                                              parser: AttributeParser[A]
  ): Float = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits: Int = quadData(index)
    bits = bits >>> (offset * 8)
    if ((pos + size.v - 1) / 4 != index) bits |= quadData(index + 1) << ((4 - offset) * 8)
    bits &= mask.v

    parser.parse(bits, mask)
  }


  val test: Float = get(Array(), DefaultVertexFormats.ITEM, POSITION_3F :: HNil, PosCombiner((x: Float, y: Float, z: Float) => 0f))
  println(test)

}
