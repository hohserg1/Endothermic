package hohserg.endothermic.immutable

import hohserg.endothermic.BaseUnpackedQuad
import hohserg.endothermic.format.AttributeRepresentation._
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.renderer.vertex.VertexFormat
import net.minecraft.util.EnumFacing


case class UnpackedQuad(
                         quadData: Array[Int],
                         format: VertexFormat,
                         face: EnumFacing,
                         atlas: TextureAtlasSprite,
                         tint: Int,
                         applyDiffuseLighting: Boolean
                       ) extends BaseUnpackedQuad {

  override type Self = UnpackedQuad

  override def reconstruct(v1: VertexType, v2: VertexType, v3: VertexType, v4: VertexType): Self =
    UnpackedQuad(quadData, format, face, atlas, tint, applyDiffuseLighting, v1, v2, v3, v4)

  def updated(
               v1f: VertexType => VertexType = identity,
               v2f: VertexType => VertexType = identity,
               v3f: VertexType => VertexType = identity,
               v4f: VertexType => VertexType = identity
             ): UnpackedQuad =
    UnpackedQuad(quadData, format, face, atlas, tint, applyDiffuseLighting,
      v1f(v1),
      v2f(v2),
      v3f(v3),
      v4f(v4)
    )

  lazy val toRawArray: Array[Int] = {
    val r = quadData.clone()

    v1.toRawArray(r)
    v2.toRawArray(r)
    v3.toRawArray(r)
    v4.toRawArray(r)

    r
  }
  lazy val toBakedQuad: BakedQuad =
    new BakedQuad(toRawArray, tint, face, atlas, applyDiffuseLighting, format)

  override type VertexType = UnpackedVertex
}

object UnpackedQuad {

  def apply(quad: BakedQuad): UnpackedQuad =
    apply(quad.getVertexData, quad.getFormat, quad.getFace, quad.getSprite, quad.getTintIndex, quad.shouldApplyDiffuseLighting())


  def apply(implicit quadData: Array[Int], format: VertexFormat, face: EnumFacing, atlas: TextureAtlasSprite, tint: Int, applyDiffuseLighting: Boolean): UnpackedQuad =
    UnpackedQuad(
      quadData, format,
      face, atlas, tint, applyDiffuseLighting,
      new UnpackedVertex(_1),
      new UnpackedVertex(_2),
      new UnpackedVertex(_3),
      new UnpackedVertex(_4)
    )


  //UnpackedQuad(???).updated(v2f = v => v.reconstruct(x = v.x + 1)).toRawArray
}
