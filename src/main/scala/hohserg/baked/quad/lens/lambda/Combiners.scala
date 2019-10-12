package hohserg.baked.quad.lens.lambda

object Combiners {

  abstract class PosCombiner {
    def apply(x: Float, y: Float, z: Float): Any
  }

  object PosCombiner {
    def apply[A](f: (Float, Float, Float) => A): PosCombiner = new PosCombiner {
      override def apply(x: Float, y: Float, z: Float): Any = f(x, y, z)
    }
  }

  abstract class AllPosCombiner {
    def apply(
               x1: Float, y1: Float, z1: Float,
               x2: Float, y2: Float, z2: Float,
               x3: Float, y3: Float, z3: Float,
               x4: Float, y4: Float, z4: Float
             ): Any
  }

  object AllPosCombiner {
    def apply[A](f: (Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float) => A): AllPosCombiner = new AllPosCombiner {
      override def apply(x1: Float, y1: Float, z1: Float, x2: Float, y2: Float, z2: Float, x3: Float, y3: Float, z3: Float, x4: Float, y4: Float, z4: Float): Any =
        f(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4)
    }
  }

}
