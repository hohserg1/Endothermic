package hohserg.baked.quad.lens.lambda

import net.minecraft.client.renderer.block.model.BakedQuad
import shapeless.{::, Generic, HList, HNil}

object UniversalCombineUsecases {

  def sliceCombiner(
                     x1: Float, y1: Float, z1: Float, u1: Float, v1: Float,
                     x2: Float, y2: Float, z2: Float, u2: Float, v2: Float,
                     x3: Float, y3: Float, z3: Float, u3: Float, v3: Float,
                     x4: Float, y4: Float, z4: Float, u4: Float, v4: Float
                   ): BakedQuad = ???

  def centerOfQuad(
                    x1: Float, y1: Float, z1: Float,
                    x2: Float, y2: Float, z2: Float,
                    x3: Float, y3: Float, z3: Float,
                    x4: Float, y4: Float, z4: Float
                  ): (Float, Float, Float) = ???


  def testLens1[A, R <: HList, RV](requirements: R, combiner: RV => A)
                                  (implicit exist: AttributeValue.Aux[R, RV]): A = {
    combiner(exist.calc())
  }

  trait AttributeValue[R] {
    type Value

    def calc(): Value
  }

  object AttributeValue {

    type Aux[R0, V0] = AttributeValue[R0] {type Value = V0}

    implicit def apply[R](implicit inst: AttributeValue[R]): Aux[R, inst.Value] =
      inst

  }


  implicit val hnilEncoder = new AttributeValue[HNil] {
    override type Value = HNil

    override def calc(): Value = HNil
  }

  implicit def hconsValue[H, T <: HList, VH, VT <: HList](
                                                           implicit
                                                           hEncoder: AttributeValue.Aux[H, VH],
                                                           tEncoder: AttributeValue.Aux[T, VT]
                                                         ): AttributeValue.Aux[H :: T, VH :: VT] =
    new AttributeValue[H :: T] {
      override type Value = VH :: VT

      override def calc(): Value = hEncoder.calc() :: tEncoder.calc()
    }

  implicit val posValue = new AttributeValue[POSITION_3F.type] {
    override type Value = Float :: Float :: Float :: HNil

    override def calc(): Value = 1f :: 1f :: 1f :: HNil
  }

  implicit val colorValue = new AttributeValue[COLOR_4UB.type] {
    override type Value = Float :: Float :: Float :: Float :: HNil

    override def calc(): Value = 1f :: 1f :: 1f :: 1f :: HNil
  }


  val a: Int = testLens1(
    POSITION_3F :: COLOR_4UB :: HNil,
    (v: (Float :: Float :: Float :: HNil) :: (Float :: Float :: Float :: Float :: HNil) :: HNil) => 0)


  sealed trait VertexAttribute

  case object POSITION_3F extends VertexAttribute

  case object COLOR_4UB extends VertexAttribute

  case object TEX_2F extends VertexAttribute

  case object TEX_2S extends VertexAttribute

  case object NORMAL_3B extends VertexAttribute

  case object PADDING_1B extends VertexAttribute

}
