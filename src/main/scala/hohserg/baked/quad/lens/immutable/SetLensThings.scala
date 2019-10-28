package hohserg.baked.quad.lens.immutable

import hohserg.baked.quad.lens.immutable.VertexLens.{ElementMask, ElementSize, Vertex, VertexAttribute, VertexStart}
import net.minecraft.client.renderer.vertex.VertexFormatElement

trait SetLensThings {

  def withCopyOfArray(quadData: Array[Int])(actions: Array[Int] => Unit*): Array[Int] = {
    val r = quadData.clone()
    actions.foreach(_ (r))
    r
  }

  def pack[V <: Vertex, A <: VertexAttribute](value: Float, to: Array[Int], i: Int)(implicit element: VertexFormatElement, vertexStart: VertexStart[V, A], `type`: VertexFormatElement.EnumType, size: ElementSize[A], mask: ElementMask[A]): Unit = {
    val pos = vertexStart.v + size.v * i
    val index = pos >> 2
    val offset = pos & 3
    var bits = 0
    if (`type` eq VertexFormatElement.EnumType.FLOAT)
      bits = java.lang.Float.floatToRawIntBits(value)
    else if ((`type` eq VertexFormatElement.EnumType.UBYTE) || (`type` eq VertexFormatElement.EnumType.USHORT) || (`type` eq VertexFormatElement.EnumType.UINT))
      bits = (value * mask.v).round
    else
      bits = (value * (mask.v >> 1)).round

    to(index) &= ~mask.v << (offset * 8)
    to(index) |= (bits & mask.v) << (offset * 8)
    // TODO handle overflow into to[index + 1]
  }

}
