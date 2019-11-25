package hohserg.endothermic

trait BaseQuad {

  type SelfQuad <: BaseQuad
  type LocalVertex <: BaseVertex[LocalVertex]

  def v1: LocalVertex

  def v2: LocalVertex

  def v3: LocalVertex

  def v4: LocalVertex

  def reconstruct(v1: LocalVertex = v1,
                  v2: LocalVertex = v2,
                  v3: LocalVertex = v3,
                  v4: LocalVertex = v4): SelfQuad = ???


  def translate(x: Float, y: Float, z: Float): SelfQuad =
    reconstruct(
      v1.reconstruct(v1.x + x, v1.y + y, v1.z + z),
      v2.reconstruct(v2.x + x, v2.y + y, v2.z + z),
      v3.reconstruct(v3.x + x, v3.y + y, v3.z + z),
      v4.reconstruct(v4.x + x, v4.y + y, v4.z + z)
    )

}
