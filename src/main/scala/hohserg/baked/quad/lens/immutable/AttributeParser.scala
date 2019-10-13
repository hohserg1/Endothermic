package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens._

trait AttributeParser[A] {
  def parse(bits: Int, mask: ElementMask[A]): Float

}

object AttributeParser {

  implicit case object positionParser extends AttributeParser[POSITION_3F] {
    override def parse(bits: Int, mask: ElementMask[POSITION_3F]): Float = java.lang.Float.intBitsToFloat(bits)
  }


  implicit case object colorParser extends AttributeParser[COLOR_4UB] {
    override def parse(bits: Int, mask: ElementMask[COLOR_4UB]): Float = bits.toFloat / mask.v
  }


  implicit case object tex2fParser extends AttributeParser[TEX_2F] {
    override def parse(bits: Int, mask: ElementMask[TEX_2F]): Float = java.lang.Float.intBitsToFloat(bits)
  }


  implicit case object tex2sParser extends AttributeParser[TEX_2S] {
    override def parse(bits: Int, mask: ElementMask[TEX_2S]): Float = bits.toShort.toFloat / (mask.v >> 1)
  }


  implicit case object normalParser extends AttributeParser[NORMAL_3B] {
    override def parse(bits: Int, mask: ElementMask[NORMAL_3B]): Float = bits.toByte.toFloat / (mask.v >> 1)
  }


  implicit case object paddingParser extends AttributeParser[PADDING_1B] {
    override def parse(bits: Int, mask: ElementMask[PADDING_1B]): Float = bits.toByte.toFloat / (mask.v >> 1)
  }

}
