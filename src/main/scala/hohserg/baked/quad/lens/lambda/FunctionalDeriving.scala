package hohserg.baked.quad.lens.lambda

import shapeless.ops.function.FnFromProduct
import shapeless.{HList, HNil}

import scala.language.higherKinds

object FunctionalDeriving {
  type SomeList = Int :: Float :: HNil

  type someFunc = (Int, Float) => Unit

  def test[A <: HList, F1 <: A => Unit, F2](implicit e: FnFromProduct.Aux[F1, F2]): F2 = {
    ???
  }

  val a = test[Int :: Float :: HNil, Int :: Float :: HNil => Unit, Int => Float => Unit]

  /*

  type ListArgs = Int :: Float :: HNil
  type RequiredFunctional = Int => Float => Unit

  trait GenericFunction[H, T <: HList, Result] {
    type Next

  }

  trait NextHead[T] {
    type Out
  }

  object NextHead {
    type Aux[T, O0] = NextHead[T] {type Out = O0}
  }

  implicit def hlist[H, T <: HList, O](implicit nextHead: NextHead.Aux[T, O]): NextHead.Aux[H :: T, H => O] = new NextHead[H :: T] {
    override type Out = H => O
  }

  implicit val hnil: NextHead.Aux[HNil, Unit] = new NextHead[HNil] {
    override type Out = Unit
  }

  def test[L <: HList, O](list: L, f: O)(implicit next: NextHead.Aux[L, O]): O = f

  val a: Int => Float => Unit = test(1 :: 1f :: HNil, (x: Int) => (z: Float) => ())
  //implicitly[RequiredFunctional =:= GenericFunction[ListArgs, Unit]#Out]*/


}
