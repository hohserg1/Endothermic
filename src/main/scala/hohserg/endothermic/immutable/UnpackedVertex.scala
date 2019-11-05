package hohserg.endothermic.immutable

import hohserg.endothermic.BaseUnpackedVertex
import hohserg.endothermic.format.AttributeRepresentation.Vertex
import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.dynamics

class UnpackedVertex[V <: Vertex]()(implicit protected val quadData: Array[Int], protected val format: VertexFormat, protected val vertex: V) extends BaseUnpackedVertex[V] {

  def copy(
            x: Float = _x,
            y: Float = _y,
            z: Float = _z,
            u: Float = _u,
            v: Float = _v,
            r: Float = _r,
            g: Float = _g,
            b: Float = _b,
            a: Float = _a,
            lx: Float = _lx,
            ly: Float = _ly,
            nx: Float = _nx,
            ny: Float = _ny,
            nz: Float = _nz,
            padding: Float = _padding
          ): UnpackedVertex[V] = {
    val result = new UnpackedVertex[V]()(quadData, format, vertex)

    if (x != _x || (initFlag & (1 << 0)) == 0) {
      result.initFlag |= (1 << 0)
      result.changeFlag |= (1 << 0)
      result._x = x
    }


    if (y != _y || (initFlag & (1 << 1)) == 0) {
      result.initFlag |= (1 << 1)
      result.changeFlag |= (1 << 1)
      result._y = y
    }


    if (z != _z || (initFlag & (1 << 2)) == 0) {
      result.initFlag |= (1 << 2)
      result.changeFlag |= (1 << 2)
      result._z = z
    }


    if (u != _u || (initFlag & (1 << 3)) == 0) {
      result.initFlag |= (1 << 3)
      result.changeFlag |= (1 << 3)
      result._u = u
    }


    if (v != _v || (initFlag & (1 << 4)) == 0) {
      result.initFlag |= (1 << 4)
      result.changeFlag |= (1 << 4)
      result._v = v
    }


    if (r != _r || (initFlag & (1 << 5)) == 0) {
      result.initFlag |= (1 << 5)
      result.changeFlag |= (1 << 5)
      result._r = r
    }


    if (g != _g || (initFlag & (1 << 6)) == 0) {
      result.initFlag |= (1 << 6)
      result.changeFlag |= (1 << 6)
      result._g = g
    }


    if (b != _b || (initFlag & (1 << 7)) == 0) {
      result.initFlag |= (1 << 7)
      result.changeFlag |= (1 << 7)
      result._b = b
    }


    if (a != _a || (initFlag & (1 << 8)) == 0) {
      result.initFlag |= (1 << 8)
      result.changeFlag |= (1 << 8)
      result._a = a
    }


    if (lx != _lx || (initFlag & (1 << 9)) == 0) {
      result.initFlag |= (1 << 9)
      result.changeFlag |= (1 << 9)
      result._lx = lx
    }


    if (ly != _ly || (initFlag & (1 << 10)) == 0) {
      result.initFlag |= (1 << 10)
      result.changeFlag |= (1 << 10)
      result._ly = ly
    }


    if (nx != _nx || (initFlag & (1 << 11)) == 0) {
      result.initFlag |= (1 << 11)
      result.changeFlag |= (1 << 11)
      result._nx = nx
    }


    if (ny != _ny || (initFlag & (1 << 12)) == 0) {
      result.initFlag |= (1 << 12)
      result.changeFlag |= (1 << 12)
      result._ny = ny
    }


    if (nz != _nz || (initFlag & (1 << 13)) == 0) {
      result.initFlag |= (1 << 13)
      result.changeFlag |= (1 << 13)
      result._nz = nz
    }


    if (padding != _padding || (initFlag & (1 << 14)) == 0) {
      result.initFlag |= (1 << 14)
      result.changeFlag |= (1 << 14)
      result._padding = padding
    }


    result
  }

}
