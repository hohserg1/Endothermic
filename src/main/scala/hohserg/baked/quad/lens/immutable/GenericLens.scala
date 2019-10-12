package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens._
import hohserg.baked.quad.lens.lambda.Combiners.{AllPosCombiner, PosCombiner}
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat, VertexFormatElement}
import shapeless.{::, HList, HNil}

import scala.language.higherKinds

object GenericLens extends App with VertexLens {

  def get[R <: HList, C, Result](quadData: Array[Int], format: VertexFormat, requirements: R, combiner: C)
                                (implicit
                                 relevantCombiner: RelevantCombiner.Aux[R, C]): Result = {
    relevantCombiner.apply(quadData, format, combiner).asInstanceOf[Result]
  }


  val test: Float = get(Array(), DefaultVertexFormats.ITEM, POSITION_3F :: HNil, PosCombiner((x: Float, y: Float, z: Float) => 0f))
  println(test)


  def unpack[V <: Vertex, A <: VertexAttribute](quadData: Array[Int], i: Int)(implicit vertexStart: VertexStart[V, A], `type`: ElementEnumType[V, A],
                                                                              size: ElementSize[V, A], mask: ElementMask[V, A]): Float = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits = quadData(index)
    bits = bits >>> (offset * 8)
    if ((pos + size.v - 1) / 4 != index) bits |= quadData(index + 1) << ((4 - offset) * 8)
    bits &= mask.v

    `type`.v match {
      case FLOAT => java.lang.Float.intBitsToFloat(bits)
      case UBYTE | USHORT => bits.toFloat / mask.v
      case UINT => ((bits & 0xFFFFFFFFL).toDouble / 0xFFFFFFFFL).toFloat
      case BYTE => bits.toByte.toFloat / (mask.v >> 1)
      case SHORT => bits.toShort.toFloat / (mask.v >> 1)
      case INT => ((bits & 0xFFFFFFFFL).toDouble / (0xFFFFFFFFL >> 1)).toFloat
    }
  }


  implicit val allPosCombiner: RelevantCombiner.Aux[POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: HNil, AllPosCombiner] = new RelevantCombiner[POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: POSITION_3F.type :: HNil] {
    override type C = AllPosCombiner

    override def apply(implicit quadData: Array[Int], format: VertexFormat, combiner: C): Any = {

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
    override type C = PosCombiner

    override def apply(implicit quadData: Array[Int], format: VertexFormat, combiner: C): Any = {
      implicit val element: VertexFormatElement = DefaultVertexFormats.POSITION_3F

      combiner(
        unpack[_1, POSITION_3F](quadData, 0),
        unpack[_1, POSITION_3F](quadData, 1),
        unpack[_1, POSITION_3F](quadData, 2)
      )
    }
  }

}
