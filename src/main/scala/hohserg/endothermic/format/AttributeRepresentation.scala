package hohserg.endothermic.format

import hohserg.endothermic.format.VertexRepr._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormatElement}

object AttributeRepresentation {

  case class AttributeId(_1: VertexFormatElement, _2: Int, _3: VertexRepr) {
    override lazy val hashCode: Int = super.hashCode()
  }

  val x_1 = AttributeId(DefaultVertexFormats.POSITION_3F, 0, _1)
  val x_2 = AttributeId(DefaultVertexFormats.POSITION_3F, 0, _2)
  val x_3 = AttributeId(DefaultVertexFormats.POSITION_3F, 0, _3)
  val x_4 = AttributeId(DefaultVertexFormats.POSITION_3F, 0, _4)

  val y_1 = AttributeId(DefaultVertexFormats.POSITION_3F, 1, _1)
  val y_2 = AttributeId(DefaultVertexFormats.POSITION_3F, 1, _2)
  val y_3 = AttributeId(DefaultVertexFormats.POSITION_3F, 1, _3)
  val y_4 = AttributeId(DefaultVertexFormats.POSITION_3F, 1, _4)

  val z_1 = AttributeId(DefaultVertexFormats.POSITION_3F, 2, _1)
  val z_2 = AttributeId(DefaultVertexFormats.POSITION_3F, 2, _2)
  val z_3 = AttributeId(DefaultVertexFormats.POSITION_3F, 2, _3)
  val z_4 = AttributeId(DefaultVertexFormats.POSITION_3F, 2, _4)

  val r_1 = AttributeId(DefaultVertexFormats.COLOR_4UB, 0, _1)
  val r_2 = AttributeId(DefaultVertexFormats.COLOR_4UB, 0, _2)
  val r_3 = AttributeId(DefaultVertexFormats.COLOR_4UB, 0, _3)
  val r_4 = AttributeId(DefaultVertexFormats.COLOR_4UB, 0, _4)

  val g_1 = AttributeId(DefaultVertexFormats.COLOR_4UB, 1, _1)
  val g_2 = AttributeId(DefaultVertexFormats.COLOR_4UB, 1, _2)
  val g_3 = AttributeId(DefaultVertexFormats.COLOR_4UB, 1, _3)
  val g_4 = AttributeId(DefaultVertexFormats.COLOR_4UB, 1, _4)

  val b_1 = AttributeId(DefaultVertexFormats.COLOR_4UB, 2, _1)
  val b_2 = AttributeId(DefaultVertexFormats.COLOR_4UB, 2, _2)
  val b_3 = AttributeId(DefaultVertexFormats.COLOR_4UB, 2, _3)
  val b_4 = AttributeId(DefaultVertexFormats.COLOR_4UB, 2, _4)

  val a_1 = AttributeId(DefaultVertexFormats.COLOR_4UB, 3, _1)
  val a_2 = AttributeId(DefaultVertexFormats.COLOR_4UB, 3, _2)
  val a_3 = AttributeId(DefaultVertexFormats.COLOR_4UB, 3, _3)
  val a_4 = AttributeId(DefaultVertexFormats.COLOR_4UB, 3, _4)

  val u_1 = AttributeId(DefaultVertexFormats.TEX_2F, 0, _1)
  val u_2 = AttributeId(DefaultVertexFormats.TEX_2F, 0, _2)
  val u_3 = AttributeId(DefaultVertexFormats.TEX_2F, 0, _3)
  val u_4 = AttributeId(DefaultVertexFormats.TEX_2F, 0, _4)

  val v_1 = AttributeId(DefaultVertexFormats.TEX_2F, 1, _1)
  val v_2 = AttributeId(DefaultVertexFormats.TEX_2F, 1, _2)
  val v_3 = AttributeId(DefaultVertexFormats.TEX_2F, 1, _3)
  val v_4 = AttributeId(DefaultVertexFormats.TEX_2F, 1, _4)

  val lu_1 = AttributeId(DefaultVertexFormats.TEX_2S, 0, _1)
  val lu_2 = AttributeId(DefaultVertexFormats.TEX_2S, 0, _2)
  val lu_3 = AttributeId(DefaultVertexFormats.TEX_2S, 0, _3)
  val lu_4 = AttributeId(DefaultVertexFormats.TEX_2S, 0, _4)

  val lv_1 = AttributeId(DefaultVertexFormats.TEX_2S, 1, _1)
  val lv_2 = AttributeId(DefaultVertexFormats.TEX_2S, 1, _2)
  val lv_3 = AttributeId(DefaultVertexFormats.TEX_2S, 1, _3)
  val lv_4 = AttributeId(DefaultVertexFormats.TEX_2S, 1, _4)

  val nx_1 = AttributeId(DefaultVertexFormats.NORMAL_3B, 0, _1)
  val nx_2 = AttributeId(DefaultVertexFormats.NORMAL_3B, 0, _2)
  val nx_3 = AttributeId(DefaultVertexFormats.NORMAL_3B, 0, _3)
  val nx_4 = AttributeId(DefaultVertexFormats.NORMAL_3B, 0, _4)

  val ny_1 = AttributeId(DefaultVertexFormats.NORMAL_3B, 1, _1)
  val ny_2 = AttributeId(DefaultVertexFormats.NORMAL_3B, 1, _2)
  val ny_3 = AttributeId(DefaultVertexFormats.NORMAL_3B, 1, _3)
  val ny_4 = AttributeId(DefaultVertexFormats.NORMAL_3B, 1, _4)

  val nz_1 = AttributeId(DefaultVertexFormats.NORMAL_3B, 2, _1)
  val nz_2 = AttributeId(DefaultVertexFormats.NORMAL_3B, 2, _2)
  val nz_3 = AttributeId(DefaultVertexFormats.NORMAL_3B, 2, _3)
  val nz_4 = AttributeId(DefaultVertexFormats.NORMAL_3B, 2, _4)

  val p_1 = AttributeId(DefaultVertexFormats.PADDING_1B, 0, _1)
  val p_2 = AttributeId(DefaultVertexFormats.PADDING_1B, 0, _2)
  val p_3 = AttributeId(DefaultVertexFormats.PADDING_1B, 0, _3)
  val p_4 = AttributeId(DefaultVertexFormats.PADDING_1B, 0, _4)


}
