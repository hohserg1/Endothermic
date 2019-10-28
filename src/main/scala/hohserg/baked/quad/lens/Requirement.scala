package hohserg.baked.quad.lens

import hohserg.baked.quad.lens.immutable.VertexLens._
import shapeless._

object Requirement {

  case class RequirementEntry[V <: Vertex, H <: HList](v: V, attributes: H) {
    def ##[A <: VertexAttribute](attribute: A): RequirementEntry[V, H ## A] = RequirementEntry(v, attribute :: attributes)

    def ::[RE](re: RE): RE :: RequirementEntry[V, H] :: HNil = re :: this :: HNil
  }

  type ##[A<:HList, T] = T :: A


  implicit def vectorOps[V <: Vertex](v: V) =
    new {
      def #>[A <: VertexAttribute](attribute: A): RequirementEntry[V, A :: HNil] = RequirementEntry(v, attribute :: HNil)
    }

  implicit def re[V <: Vertex, H <: HList](implicit v: V, h: H): RequirementEntry[V, H] = RequirementEntry(v, h)

  implicit val hnil: HNil = HNil

  implicit def hlist[H, T <: HList](implicit h: H, t: T): H :: T = h :: t

  type All =
    RequirementEntry[_1, HNil ## POSITION_3F ## COLOR_4UB ## TEX_2F ## NORMAL_3B ## TEX_2S] ::
      RequirementEntry[_2, HNil ## POSITION_3F ## COLOR_4UB ## TEX_2F ## NORMAL_3B ## TEX_2S] ::
      RequirementEntry[_3, HNil ## POSITION_3F ## COLOR_4UB ## TEX_2F ## NORMAL_3B ## TEX_2S] ::
      RequirementEntry[_4, HNil ## POSITION_3F ## COLOR_4UB ## TEX_2F ## NORMAL_3B ## TEX_2S] :: HNil

  val All: All = implicitly

  type Pos[V <: Vertex] = RequirementEntry[V, POSITION_3F :: HNil]
  type Pos1 = Pos[_1]
  type Pos2 = Pos[_2]
  type Pos3 = Pos[_3]
  type Pos4 = Pos[_4]

  val Pos1: Pos1 = implicitly
  val Pos2: Pos2 = implicitly
  val Pos3: Pos3 = implicitly
  val Pos4: Pos4 = implicitly

  type Color[V <: Vertex] = RequirementEntry[V, COLOR_4UB :: HNil]
  type Color1 = Color[_1]
  type Color2 = Color[_2]
  type Color3 = Color[_3]
  type Color4 = Color[_4]

  val Color1: Color1 = implicitly
  val Color2: Color2 = implicitly
  val Color3: Color3 = implicitly
  val Color4: Color4 = implicitly

}
