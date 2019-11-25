package hohserg.endothermic

trait BaseVertex {
  type SelfVertex <: BaseVertex

  def reconstruct(): SelfVertex = ???

}
