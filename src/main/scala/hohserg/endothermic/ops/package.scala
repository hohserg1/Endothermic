package hohserg.endothermic

package object ops {

  implicit class Syntax[Quad <: ReconstructOpsQuad](q: Quad) {
    def translate(x: Float, y: Float, z: Float): Quad = Translation(q, x, y, z)
  }

}
