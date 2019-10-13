package hohserg.baked.quad.lens.lambda

object Combiners {

  abstract class UVCombiner[A] {
    def apply(u: Float, v: Float): A
  }

  abstract class ColorCombiner[A] {
    def apply(r: Float, g: Float, b: Float, a: Float): A
  }

  abstract class PosCombiner[A] {
    def apply(x: Float, y: Float, z: Float): A
  }

  abstract class LightmapCombiner[A] {
    def apply(x: Short, y: Short): A
  }

  abstract class NormalCombiner[A] {
    def apply(x: Byte, y: Byte, z: Byte): A
  }

  object PosCombiner {
    def apply[A](f: (Float, Float, Float) => A): PosCombiner[A] = new PosCombiner[A] {
      override def apply(x: Float, y: Float, z: Float): A = f(x, y, z)
    }
  }

  abstract class AllPosCombiner[A] {
    def apply(
               x1: Float, y1: Float, z1: Float,
               x2: Float, y2: Float, z2: Float,
               x3: Float, y3: Float, z3: Float,
               x4: Float, y4: Float, z4: Float
             ): A
  }

  object AllPosCombiner {
    def apply[A](f: (Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float) => A): AllPosCombiner[A] = new AllPosCombiner[A] {
      override def apply(x1: Float, y1: Float, z1: Float, x2: Float, y2: Float, z2: Float, x3: Float, y3: Float, z3: Float, x4: Float, y4: Float, z4: Float): A =
        f(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4)
    }
  }

}
