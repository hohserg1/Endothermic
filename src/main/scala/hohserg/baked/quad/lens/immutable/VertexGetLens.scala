package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.lambda.Combiners._

import hohserg.baked.quad.lens.immutable.VertexLens._
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormat, VertexFormatElement}

object VertexGetLens extends VertexLens {

  def getPos[A](implicit quadData: Array[Int], format: VertexFormat, vertex: Int, combine: Float3Combiner[A]): A = {
    implicit val element: VertexFormatElement = DefaultVertexFormats.POSITION_3F

    combine(
      unpack(quadData, 0),
      unpack(quadData, 1),
      unpack(quadData, 2)
    )
  }

  def getColor[A](implicit quadData: Array[Int], format: VertexFormat, vertex: Int, combine: Float4Combiner[A]): A = {
    implicit val element: VertexFormatElement = DefaultVertexFormats.COLOR_4UB

    combine(
      unpack(quadData, 0),
      unpack(quadData, 1),
      unpack(quadData, 2),
      unpack(quadData, 3)
    )
  }

  def getUV[A](implicit quadData: Array[Int], format: VertexFormat, vertex: Int, combine: Float2Combiner[A]): A = {
    implicit val element: VertexFormatElement = DefaultVertexFormats.TEX_2F

    combine(
      unpack(quadData, 0),
      unpack(quadData, 1)
    )
  }

  def getNormal[A](implicit quadData: Array[Int], format: VertexFormat, vertex: Int, combine: Byte3Combiner[A]): A = {
    implicit val element: VertexFormatElement = DefaultVertexFormats.NORMAL_3B

    combine(
      unpack(quadData, 0).toByte,
      unpack(quadData, 1).toByte,
      unpack(quadData, 2).toByte
    )
  }

  def getLightmap[A](implicit quadData: Array[Int], format: VertexFormat, vertex: Int, combine: Short2Combiner[A]): A = {
    implicit val element: VertexFormatElement = DefaultVertexFormats.TEX_2S

    combine(
      unpack(quadData, 0).toShort,
      unpack(quadData, 1).toShort
    )
  }

  def unpack(quadData: Array[Int], i: Int)(implicit vertexStart: VertexStart, `type`: VertexFormatElement.EnumType, size: ElementSize, mask: ElementMask): Float = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits = quadData(index)
    bits = bits >>> (offset * 8)
    if ((pos + size.v - 1) / 4 != index) bits |= quadData(index + 1) << ((4 - offset) * 8)
    bits &= mask.v

    `type` match {
      case FLOAT => java.lang.Float.intBitsToFloat(bits)
      case UBYTE | USHORT => bits.toFloat / mask.v
      case UINT => ((bits & 0xFFFFFFFFL).toDouble / 0xFFFFFFFFL).toFloat
      case BYTE => bits.toByte.toFloat / (mask.v >> 1)
      case SHORT => bits.toShort.toFloat / (mask.v >> 1)
      case INT => ((bits & 0xFFFFFFFFL).toDouble / (0xFFFFFFFFL >> 1)).toFloat
    }
  }
}
