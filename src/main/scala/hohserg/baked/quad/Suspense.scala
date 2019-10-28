package hohserg.baked.quad

class Suspense[A](_v: => A) {
  @volatile var eval = false
  private var __v: A = _

  def v = {
    if (!eval) {
      __v = _v
      eval = true
    }
    __v
  }

}
