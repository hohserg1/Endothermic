package hohserg.endothermic

trait BaseQuad {

  type SelfQuad <: BaseQuad
  type LocalVertex <: BaseVertex

  def v1: LocalVertex
  def v2: LocalVertex
  def v3: LocalVertex
  def v4: LocalVertex

  def reconstruct(v1: LocalVertex=v1,
                  v2: LocalVertex=v2,
                  v3: LocalVertex=v3,
                  v4: LocalVertex=v4): SelfQuad = ???

}
