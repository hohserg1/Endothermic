package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.Requirement._
import hohserg.baked.quad.lens.immutable.VertexLens._
import hohserg.baked.quad.lens.lambda.Combiners._
import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.higherKinds

object RelevantCombinerProvider {

  /*//todo: check if this work?
  def relevantCombinerBuilder[R, C0[_]](f: (Array[Int], VertexFormat, C0[_]) => Any): RelevantCombiner.Aux[R, C0] = {
    new RelevantCombiner[R] {
      override type C[Result] = C0[Result]

      override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result =
        f(quadData, format, combiner).asInstanceOf[Result]
    }
  }

  implicit val colorCombiner2 = relevantCombinerBuilder[COLOR_4UB.type :: HNil, ColorCombiner](
    (quadData: Array[Int], format: VertexFormat, combiner: ColorCombiner[_]) => {
      implicit val format1: VertexFormat = format

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
  )*/

  def colorCombinerFactory[V <: Vertex](implicit v: V): RelevantCombiner.Aux[Color[V], ColorCombiner] = new RelevantCombiner[Color[V]] {
    override type C[Result] = ColorCombiner[Result]

    override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

      implicit lazy val ei1: ElementIndex[POSITION_3F] = indexOfElement

      implicit lazy val es1: ElementSize[POSITION_3F] = elementSize

      implicit lazy val et1: ElementEnumType[POSITION_3F] = elementType
      ???
      /*
      combiner(
        unpack[V, COLOR_4UB](0),
        unpack[V, COLOR_4UB](1),
        unpack[V, COLOR_4UB](2),
        unpack[V, COLOR_4UB](3)
      )*/
    }
  }

  def posCombinerFactory[V <: Vertex](implicit v: V): RelevantCombiner.Aux[Pos[V], PosCombiner] = new RelevantCombiner[Pos[V]] {
    override type C[Result] = PosCombiner[Result]

    override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

      implicit lazy val ei1: ElementIndex[POSITION_3F] = indexOfElement

      implicit lazy val es1: ElementSize[POSITION_3F] = elementSize

      implicit lazy val et1: ElementEnumType[POSITION_3F] = elementType
      ???
      /*
      combiner(
        unpack[V, POSITION_3F](0),
        unpack[V, POSITION_3F](1),
        unpack[V, POSITION_3F](2)
      )*/
    }
  }


  implicit val pos1Combiner: RelevantCombiner.Aux[Pos[_1], PosCombiner] = posCombinerFactory[_1]
  implicit val pos2Combiner: RelevantCombiner.Aux[Pos[_2], PosCombiner] = posCombinerFactory[_2]
  implicit val pos3Combiner: RelevantCombiner.Aux[Pos[_3], PosCombiner] = posCombinerFactory[_3]
  implicit val pos4Combiner: RelevantCombiner.Aux[Pos[_4], PosCombiner] = posCombinerFactory[_4]

  /*
    implicit val allCombiner: RelevantCombiner.Aux[All, AllCombiner] = new RelevantCombiner[All] {
      override type C[Result] = AllCombiner[Result]

      override def apply[Result](implicit quadData: Array[Int], format: VertexFormat, combiner: C[Result]): Result = {

        implicit lazy val eip: ElementIndex[POSITION_3F] = indexOfElement
        implicit lazy val eic: ElementIndex[COLOR_4UB] = indexOfElement
        implicit lazy val eiuv: ElementIndex[TEX_2F] = indexOfElement
        implicit lazy val ein: ElementIndex[NORMAL_3B] = indexOfElement
        implicit lazy val eil: ElementIndex[TEX_2S] = indexOfElement

        implicit lazy val esp: ElementSize[POSITION_3F] = elementSize
        implicit lazy val esc: ElementSize[COLOR_4UB] = elementSize
        implicit lazy val esuv: ElementSize[TEX_2F] = elementSize
        implicit lazy val esn: ElementSize[NORMAL_3B] = elementSize
        implicit lazy val esl: ElementSize[TEX_2S] = elementSize

        implicit lazy val etp: ElementEnumType[POSITION_3F] = elementType
        implicit lazy val etc: ElementEnumType[COLOR_4UB] = elementType
        implicit lazy val etuv: ElementEnumType[TEX_2F] = elementType
        implicit lazy val etn: ElementEnumType[NORMAL_3B] = elementType
        implicit lazy val etl: ElementEnumType[TEX_2S] = elementType

        implicit lazy val emp: ElementMask[POSITION_3F] = elementMask
        implicit lazy val emc: ElementMask[COLOR_4UB] = elementMask
        implicit lazy val emuv: ElementMask[TEX_2F] = elementMask
        implicit lazy val emn: ElementMask[NORMAL_3B] = elementMask
        implicit lazy val eml: ElementMask[TEX_2S] = elementMask


        combiner(
          unpack[_1, POSITION_3F](quadData, 0),
          unpack[_1, POSITION_3F](quadData, 1),
          unpack[_1, POSITION_3F](quadData, 2),

          unpack[_1, COLOR_4UB](quadData, 0),
          unpack[_1, COLOR_4UB](quadData, 1),
          unpack[_1, COLOR_4UB](quadData, 2),
          unpack[_1, COLOR_4UB](quadData, 3),

          unpack[_1, TEX_2F](quadData, 0),
          unpack[_1, TEX_2F](quadData, 1),

          unpack[_1, NORMAL_3B](quadData, 0),
          unpack[_1, NORMAL_3B](quadData, 1),
          unpack[_1, NORMAL_3B](quadData, 2),

          unpack[_1, TEX_2S](quadData, 0),
          unpack[_1, TEX_2S](quadData, 1),


          unpack[_2, POSITION_3F](quadData, 0),
          unpack[_2, POSITION_3F](quadData, 1),
          unpack[_2, POSITION_3F](quadData, 2),

          unpack[_2, COLOR_4UB](quadData, 0),
          unpack[_2, COLOR_4UB](quadData, 1),
          unpack[_2, COLOR_4UB](quadData, 2),
          unpack[_2, COLOR_4UB](quadData, 3),

          unpack[_2, TEX_2F](quadData, 0),
          unpack[_2, TEX_2F](quadData, 1),

          unpack[_2, NORMAL_3B](quadData, 0),
          unpack[_2, NORMAL_3B](quadData, 1),
          unpack[_2, NORMAL_3B](quadData, 2),

          unpack[_2, TEX_2S](quadData, 0),
          unpack[_2, TEX_2S](quadData, 1),


          unpack[_3, POSITION_3F](quadData, 0),
          unpack[_3, POSITION_3F](quadData, 1),
          unpack[_3, POSITION_3F](quadData, 2),

          unpack[_3, COLOR_4UB](quadData, 0),
          unpack[_3, COLOR_4UB](quadData, 1),
          unpack[_3, COLOR_4UB](quadData, 2),
          unpack[_3, COLOR_4UB](quadData, 3),

          unpack[_3, TEX_2F](quadData, 0),
          unpack[_3, TEX_2F](quadData, 1),

          unpack[_3, NORMAL_3B](quadData, 0),
          unpack[_3, NORMAL_3B](quadData, 1),
          unpack[_3, NORMAL_3B](quadData, 2),

          unpack[_3, TEX_2S](quadData, 0),
          unpack[_3, TEX_2S](quadData, 1),


          unpack[_4, POSITION_3F](quadData, 0),
          unpack[_4, POSITION_3F](quadData, 1),
          unpack[_4, POSITION_3F](quadData, 2),

          unpack[_4, COLOR_4UB](quadData, 0),
          unpack[_4, COLOR_4UB](quadData, 1),
          unpack[_4, COLOR_4UB](quadData, 2),
          unpack[_4, COLOR_4UB](quadData, 3),

          unpack[_4, TEX_2F](quadData, 0),
          unpack[_4, TEX_2F](quadData, 1),

          unpack[_4, NORMAL_3B](quadData, 0),
          unpack[_4, NORMAL_3B](quadData, 1),
          unpack[_4, NORMAL_3B](quadData, 2),

          unpack[_4, TEX_2S](quadData, 0),
          unpack[_4, TEX_2S](quadData, 1)


        )
      }
    }*/


}
