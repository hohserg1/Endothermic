package hohserg.endothermic.ops

import hohserg.endothermic.BaseUnpackedVertex
import hohserg.endothermic.format.AttributeRepresentation.Vertex

trait VertexOps[+V <: Vertex] {
  this: BaseUnpackedVertex[V] =>

  def +(c: Float): this.type =
    reconstruct(x + c, y + c, z + c, u + c, v + c, r + c, g + c, b + c, a + c, lx + c, ly + c, nx + c, ny + c, nz + c, padding + c)

  def +[A <: Vertex](c: BaseUnpackedVertex[_])(implicit newVertex: A): Self[A] =
    reconstruct(x + c.x, y + c.y, z + c.z, u + c.u, v + c.v, r + c.r, g + c.g, b + c.b, a + c.a, lx + c.lx, ly + c.ly, nx + c.nx, ny + c.ny, nz + c.nz, padding + c.padding)

  def -[A <: Vertex](c: BaseUnpackedVertex[_])(implicit newVertex: A): Self[A] =
    reconstruct(x - c.x, y - c.y, z - c.z, u - c.u, v - c.v, r - c.r, g - c.g, b - c.b, a - c.a, lx - c.lx, ly - c.ly, nx - c.nx, ny - c.ny, nz - c.nz, padding - c.padding)

  def *(c: Float): this.type =
    reconstruct(x * c, y * c, z * c, u * c, v * c, r * c, g * c, b * c, a * c, lx * c, ly * c, nx * c, ny * c, nz * c, padding * c)

}
