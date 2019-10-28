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

  abstract class AllCombiner[A] {
    def apply(
               x1: Float, y1: Float, z1: Float, r1: Float, g1: Float, b1: Float, a1: Float, u1: Float, v1: Float, nx1: Byte, ny1: Byte, nz1: Byte, lx1: Short, ly1: Short,
               x2: Float, y2: Float, z2: Float, r2: Float, g2: Float, b2: Float, a2: Float, u2: Float, v2: Float, nx2: Byte, ny2: Byte, nz2: Byte, lx2: Short, ly2: Short,
               x3: Float, y3: Float, z3: Float, r3: Float, g3: Float, b3: Float, a3: Float, u3: Float, v3: Float, nx3: Byte, ny3: Byte, nz3: Byte, lx3: Short, ly3: Short,
               x4: Float, y4: Float, z4: Float, r4: Float, g4: Float, b4: Float, a4: Float, u4: Float, v4: Float, nx4: Byte, ny4: Byte, nz4: Byte, lx4: Short, ly4: Short
             ): A
  }

}
