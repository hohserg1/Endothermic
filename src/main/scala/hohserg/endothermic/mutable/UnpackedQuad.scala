package hohserg.endothermic.mutable

import hohserg.endothermic.BaseUnpackedQuad
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.util.EnumFacing


class UnpackedQuad(
                    val quad: BakedQuad,
                    face: EnumFacing,
                    atlas: TextureAtlasSprite,
                    tint: Int,
                    applyDiffuseLighting: Boolean
                  ) extends BaseUnpackedQuad {

  def toBakedQuad: BakedQuad =
    new BakedQuad(toRawArray, tint, face, atlas, applyDiffuseLighting, format)

  override type Self = UnpackedQuad

  override def reconstructResult(): UnpackedQuad = this
}

object UnpackedQuad {

  def apply(quad: BakedQuad): UnpackedQuad =
    new UnpackedQuad(quad, quad.getFace, quad.getSprite, quad.getTintIndex, quad.shouldApplyDiffuseLighting())


  private val unpackedQuad = UnpackedQuad(???)
  //unpackedQuad.v2_x += 1
  unpackedQuad.toRawArray
}
