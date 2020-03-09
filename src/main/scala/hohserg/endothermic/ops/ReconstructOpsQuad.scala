package hohserg.endothermic.ops

import hohserg.endothermic.BaseUnpackedVertex

import scala.language.higherKinds

trait ReconstructOpsQuad {
  type Self <: ReconstructOpsQuad
  type VertexType <: BaseUnpackedVertex[VertexType]

  def reconstruct(v1_x: Float,
                  v1_y: Float,
                  v1_z: Float,
                  v1_r: Float,
                  v1_g: Float,
                  v1_b: Float,
                  v1_a: Float,
                  v1_u: Float,
                  v1_v: Float,
                  v1_lu: Float,
                  v1_lv: Float,
                  v1_nx: Float,
                  v1_ny: Float,
                  v1_nz: Float,
                  v1_p: Float,

                  v2_x: Float,
                  v2_y: Float,
                  v2_z: Float,
                  v2_r: Float,
                  v2_g: Float,
                  v2_b: Float,
                  v2_a: Float,
                  v2_u: Float,
                  v2_v: Float,
                  v2_lu: Float,
                  v2_lv: Float,
                  v2_nx: Float,
                  v2_ny: Float,
                  v2_nz: Float,
                  v2_p: Float,

                  v3_x: Float,
                  v3_y: Float,
                  v3_z: Float,
                  v3_r: Float,
                  v3_g: Float,
                  v3_b: Float,
                  v3_a: Float,
                  v3_u: Float,
                  v3_v: Float,
                  v3_lu: Float,
                  v3_lv: Float,
                  v3_nx: Float,
                  v3_ny: Float,
                  v3_nz: Float,
                  v3_p: Float,

                  v4_x: Float,
                  v4_y: Float,
                  v4_z: Float,
                  v4_r: Float,
                  v4_g: Float,
                  v4_b: Float,
                  v4_a: Float,
                  v4_u: Float,
                  v4_v: Float,
                  v4_lu: Float,
                  v4_lv: Float,
                  v4_nx: Float,
                  v4_ny: Float,
                  v4_nz: Float,
                  v4_p: Float): Self
}