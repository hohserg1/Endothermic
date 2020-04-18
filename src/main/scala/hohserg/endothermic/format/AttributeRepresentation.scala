package hohserg.endothermic.format

import hohserg.endothermic.format.VertexRepr._
import net.minecraft.client.renderer.vertex.{DefaultVertexFormats, VertexFormatElement}

object AttributeRepresentation {

  type AttributeId = (VertexFormatElement, Int, VertexRepr)

  val x_1 = (DefaultVertexFormats.POSITION_3F, 0, _1)
  val x_2 = (DefaultVertexFormats.POSITION_3F, 0, _2)
  val x_3 = (DefaultVertexFormats.POSITION_3F, 0, _3)
  val x_4 = (DefaultVertexFormats.POSITION_3F, 0, _4)

  val y_1 = (DefaultVertexFormats.POSITION_3F, 1, _1)
  val y_2 = (DefaultVertexFormats.POSITION_3F, 1, _2)
  val y_3 = (DefaultVertexFormats.POSITION_3F, 1, _3)
  val y_4 = (DefaultVertexFormats.POSITION_3F, 1, _4)

  val z_1 = (DefaultVertexFormats.POSITION_3F, 2, _1)
  val z_2 = (DefaultVertexFormats.POSITION_3F, 2, _2)
  val z_3 = (DefaultVertexFormats.POSITION_3F, 2, _3)
  val z_4 = (DefaultVertexFormats.POSITION_3F, 2, _4)

  val r_1 = (DefaultVertexFormats.COLOR_4UB, 0, _1)
  val r_2 = (DefaultVertexFormats.COLOR_4UB, 0, _2)
  val r_3 = (DefaultVertexFormats.COLOR_4UB, 0, _3)
  val r_4 = (DefaultVertexFormats.COLOR_4UB, 0, _4)

  val g_1 = (DefaultVertexFormats.COLOR_4UB, 1, _1)
  val g_2 = (DefaultVertexFormats.COLOR_4UB, 1, _2)
  val g_3 = (DefaultVertexFormats.COLOR_4UB, 1, _3)
  val g_4 = (DefaultVertexFormats.COLOR_4UB, 1, _4)

  val b_1 = (DefaultVertexFormats.COLOR_4UB, 2, _1)
  val b_2 = (DefaultVertexFormats.COLOR_4UB, 2, _2)
  val b_3 = (DefaultVertexFormats.COLOR_4UB, 2, _3)
  val b_4 = (DefaultVertexFormats.COLOR_4UB, 2, _4)

  val a_1 = (DefaultVertexFormats.COLOR_4UB, 3, _1)
  val a_2 = (DefaultVertexFormats.COLOR_4UB, 3, _2)
  val a_3 = (DefaultVertexFormats.COLOR_4UB, 3, _3)
  val a_4 = (DefaultVertexFormats.COLOR_4UB, 3, _4)

  val u_1 = (DefaultVertexFormats.TEX_2F, 0, _1)
  val u_2 = (DefaultVertexFormats.TEX_2F, 0, _2)
  val u_3 = (DefaultVertexFormats.TEX_2F, 0, _3)
  val u_4 = (DefaultVertexFormats.TEX_2F, 0, _4)

  val v_1 = (DefaultVertexFormats.TEX_2F, 1, _1)
  val v_2 = (DefaultVertexFormats.TEX_2F, 1, _2)
  val v_3 = (DefaultVertexFormats.TEX_2F, 1, _3)
  val v_4 = (DefaultVertexFormats.TEX_2F, 1, _4)

  val lu_1 = (DefaultVertexFormats.TEX_2S, 0, _1)
  val lu_2 = (DefaultVertexFormats.TEX_2S, 0, _2)
  val lu_3 = (DefaultVertexFormats.TEX_2S, 0, _3)
  val lu_4 = (DefaultVertexFormats.TEX_2S, 0, _4)

  val lv_1 = (DefaultVertexFormats.TEX_2S, 1, _1)
  val lv_2 = (DefaultVertexFormats.TEX_2S, 1, _2)
  val lv_3 = (DefaultVertexFormats.TEX_2S, 1, _3)
  val lv_4 = (DefaultVertexFormats.TEX_2S, 1, _4)

  val nx_1 = (DefaultVertexFormats.NORMAL_3B, 0, _1)
  val nx_2 = (DefaultVertexFormats.NORMAL_3B, 0, _2)
  val nx_3 = (DefaultVertexFormats.NORMAL_3B, 0, _3)
  val nx_4 = (DefaultVertexFormats.NORMAL_3B, 0, _4)

  val ny_1 = (DefaultVertexFormats.NORMAL_3B, 1, _1)
  val ny_2 = (DefaultVertexFormats.NORMAL_3B, 1, _2)
  val ny_3 = (DefaultVertexFormats.NORMAL_3B, 1, _3)
  val ny_4 = (DefaultVertexFormats.NORMAL_3B, 1, _4)

  val nz_1 = (DefaultVertexFormats.NORMAL_3B, 2, _1)
  val nz_2 = (DefaultVertexFormats.NORMAL_3B, 2, _2)
  val nz_3 = (DefaultVertexFormats.NORMAL_3B, 2, _3)
  val nz_4 = (DefaultVertexFormats.NORMAL_3B, 2, _4)

  val p_1 = (DefaultVertexFormats.PADDING_1B, 0, _1)
  val p_2 = (DefaultVertexFormats.PADDING_1B, 0, _2)
  val p_3 = (DefaultVertexFormats.PADDING_1B, 0, _3)
  val p_4 = (DefaultVertexFormats.PADDING_1B, 0, _4)


}
