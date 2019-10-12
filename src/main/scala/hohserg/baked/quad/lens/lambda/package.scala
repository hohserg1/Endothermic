package hohserg.baked.quad.lens
/*
import hohserg.baked.quad.lens.lambda.Combiners._

package object lambda {

  implicit def func2Combiner3f[A](f: (Float, Float, Float) => A): PosCombiner[A] =
    new PosCombiner[A] {
      override def apply(x: Float, y: Float, z: Float): A = f(x, y, z)
    }

  implicit def func2Combiner4f[A](f: (Float, Float, Float, Float) => A): Float4Combiner[A] =
    new Float4Combiner[A] {
      override def apply(r: Float, g: Float, b: Float, a: Float): A = f(r, g, b, a)
    }

  implicit def func2Combiner2f[A](f: (Float, Float) => A): Float2Combiner[A] =
    new Float2Combiner[A] {
      override def apply(u: Float, v: Float): A = f(u, v)
    }

  implicit def func2Combiner3b[A](f: (Byte, Byte, Byte) => A): Byte3Combiner[A] =
    new Byte3Combiner[A] {
      override def apply(x: Byte, y: Byte, z: Byte): A = f(x, y, z)
    }

  implicit def func2Combiner2s[A](f: (Short, Short) => A): Short2Combiner[A] =
    new Short2Combiner[A] {
      override def apply(x: Short, y: Short): A = f(x, y)
    }

}
*/