package hohserg.endothermic.ops

object Translation {
  def apply[Quad <: ReconstructOpsQuad](quad: Quad, x: Float, y: Float, z: Float): quad.Self =
    quad.reconstruct(
      quad.v1.reconstruct(quad.v1.x + x, quad.v1.y + y, quad.v1.z + z),
      quad.v2.reconstruct(quad.v2.x + x, quad.v2.y + y, quad.v2.z + z),
      quad.v3.reconstruct(quad.v3.x + x, quad.v3.y + y, quad.v3.z + z),
      quad.v4.reconstruct(quad.v4.x + x, quad.v4.y + y, quad.v4.z + z)
    )
}
