package hohserg.endothermic.immutable

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
                  ) extends BaseUnpackedQuad with Cloneable {

  override type Self = UnpackedQuad

  lazy val toBakedQuad: BakedQuad =
    new BakedQuad(toRawArray, tint, face, atlas, applyDiffuseLighting, format)

  override def reconstructResult(): UnpackedQuad =
    this.clone().asInstanceOf[UnpackedQuad]

}

object UnpackedQuad {

  def apply(quad: BakedQuad): UnpackedQuad =
    new UnpackedQuad(quad, quad.getFace, quad.getSprite, quad.getTintIndex, quad.shouldApplyDiffuseLighting())



  //UnpackedQuad(???).updated(v2f = v => v.reconstruct(x = v.x + 1)).toRawArray
}
