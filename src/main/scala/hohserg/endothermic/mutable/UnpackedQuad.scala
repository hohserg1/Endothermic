package hohserg.endothermic.mutable

import hohserg.endothermic.BaseUnpackedQuad
import hohserg.endothermic.format.AttributeRepresentation.{_1, _2, _3, _4}
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.renderer.vertex.VertexFormat
import net.minecraft.util.EnumFacing


class UnpackedQuad(
                    quadData: Array[Int], val format: VertexFormat,
                    face: EnumFacing,
                    atlas: TextureAtlasSprite,
                    tint: Int,
                    applyDiffuseLighting: Boolean,
                    val v1: UnpackedVertex,
                    val v2: UnpackedVertex,
                    val v3: UnpackedVertex,
                    val v4: UnpackedVertex
                  ) extends BaseUnpackedQuad {
  def toRawArray: Array[Int] = {
    val r = quadData.clone()

    v1.toRawArray(r)
    v2.toRawArray(r)
    v3.toRawArray(r)
    v4.toRawArray(r)

    r
  }

  def toBakedQuad: BakedQuad =
    new BakedQuad(toRawArray, tint, face, atlas, applyDiffuseLighting, format)

  override type Self = UnpackedQuad

  override type VertexType = UnpackedVertex

  override def reconstruct(v1: VertexType, v2: VertexType, v3: VertexType, v4: VertexType): Self = this
}

object UnpackedQuad {

  def apply(quad: BakedQuad): UnpackedQuad =
    apply(quad.getVertexData, quad.getFormat, quad.getFace, quad.getSprite, quad.getTintIndex, quad.shouldApplyDiffuseLighting())


  def apply(implicit quadData: Array[Int], format: VertexFormat, face: EnumFacing, atlas: TextureAtlasSprite, tint: Int, applyDiffuseLighting: Boolean): UnpackedQuad = {
    new UnpackedQuad(
      quadData, format,
      face, atlas, tint, applyDiffuseLighting,
      new UnpackedVertex(_1),
      new UnpackedVertex(_2),
      new UnpackedVertex(_3),
      new UnpackedVertex(_4)
    )
  }

  private val unpackedQuad = UnpackedQuad(???)
  unpackedQuad.v2.x += 1
  unpackedQuad.toRawArray
}
