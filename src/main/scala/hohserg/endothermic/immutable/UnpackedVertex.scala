package hohserg.endothermic.immutable

import hohserg.endothermic.format.AttributeRepresentation.{COLOR_4UB, NORMAL_3B, PADDING_1B, POSITION_3F, TEX_2F, TEX_2S, Vertex}
import hohserg.endothermic.format.UnpackEvaluations.{pack, unpack}
import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.dynamics

class UnpackedVertex[V <: Vertex]()(implicit quadData: Array[Int], format: VertexFormat, vertex: V) extends Dynamic {

  private var _x: Float = 0

  private var _y: Float = 0

  private var _z: Float = 0

  private var _u: Float = 0

  private var _v: Float = 0

  private var _r: Float = 0

  private var _g: Float = 0

  private var _b: Float = 0

  private var _a: Float = 0

  private var _lx: Float = 0

  private var _ly: Float = 0

  private var _nx: Float = 0

  private var _ny: Float = 0

  private var _nz: Float = 0

  private var _padding: Float = 0

  private[endothermic] var initFlag: Int = 0
  private[endothermic] var changeFlag: Int = 0

  /*
  private def genericLazyVal[A <: VertexAttribute](index: Int, vertexElement: Int, a: A, parser: AttributeParser[A]) = {
    if ((initFlag & (1 << index)) == 0) {
      initFlag |= (1 << index)
      values(index) = unpack[V, A](quadData, vertexElement)(format, vertex, a, parser)
    }
    values(index)
  }*/

  def x: Float = {
    if ((initFlag & (1 << 0)) == 0) {
      initFlag |= (1 << 0)
      _x = unpack[V, POSITION_3F](quadData, 0)
    }
    _x
  }

  def y: Float = {
    if ((initFlag & (1 << 1)) == 0) {
      initFlag |= (1 << 1)
      _y = unpack[V, POSITION_3F](quadData, 1)
    }
    _y
  }

  def z: Float = {
    if ((initFlag & (1 << 2)) == 0) {
      initFlag |= (1 << 2)
      _z = unpack[V, POSITION_3F](quadData, 2)
    }
    _z
  }

  def u: Float = {
    if ((initFlag & (1 << 3)) == 0) {
      initFlag |= (1 << 3)
      _u = unpack[V, TEX_2F](quadData, 0)
    }
    _u
  }

  def v: Float = {
    if ((initFlag & (1 << 4)) == 0) {
      initFlag |= (1 << 4)
      _v = unpack[V, TEX_2F](quadData, 1)
    }
    _v
  }

  def r: Float = {
    if ((initFlag & (1 << 5)) == 0) {
      initFlag |= (1 << 5)
      _r = unpack[V, TEX_2F](quadData, 0)
    }
    _r
  }

  def g: Float = {
    if ((initFlag & (1 << 6)) == 0) {
      initFlag |= (1 << 6)
      _g = unpack[V, TEX_2F](quadData, 1)
    }
    _g
  }

  def b: Float = {
    if ((initFlag & (1 << 7)) == 0) {
      initFlag |= (1 << 7)
      _b = unpack[V, TEX_2F](quadData, 2)
    }
    _b
  }

  def a: Float = {
    if ((initFlag & (1 << 8)) == 0) {
      initFlag |= (1 << 8)
      _a = unpack[V, TEX_2F](quadData, 3)
    }
    _a
  }

  def lx: Float = {
    if ((initFlag & (1 << 9)) == 0) {
      initFlag |= (1 << 9)
      _lx = unpack[V, TEX_2F](quadData, 0)
    }
    _lx
  }

  def ly: Float = {
    if ((initFlag & (1 << 10)) == 0) {
      initFlag |= (1 << 10)
      _ly = unpack[V, TEX_2F](quadData, 1)
    }
    _ly
  }

  def nx: Float = {
    if ((initFlag & (1 << 11)) == 0) {
      initFlag |= (1 << 11)
      _nx = unpack[V, TEX_2F](quadData, 0)
    }
    _nx
  }

  def ny: Float = {
    if ((initFlag & (1 << 12)) == 0) {
      initFlag |= (1 << 12)
      _ny = unpack[V, TEX_2F](quadData, 1)
    }
    _ny
  }

  def nz: Float = {
    if ((initFlag & (1 << 13)) == 0) {
      initFlag |= (1 << 13)
      _nz = unpack[V, TEX_2F](quadData, 2)
    }
    _nz
  }

  def padding: Float = {
    if ((initFlag & (1 << 14)) == 0) {
      initFlag |= (1 << 14)
      _padding = unpack[V, TEX_2F](quadData, 0)
    }
    _padding
  }


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

    /*
    def checkAndUpdateAttributeElement(value: Float, index: Int): Unit = {
      if (value != values(index) || (initFlag & (1 << index)) == 0) {
        result.initFlag |= (1 << index)
        result.changeFlag |= (1 << index)
        result.values(index) = value
      }
    }*/


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

  private[endothermic] def toRawArray(r: Array[Int]) = {
    /*
    def checkChangedAndPack[A <: VertexAttribute](index: Int, vertexElement: Int)(implicit a: A, parser: AttributeParser[A]): Unit = {
      if ((changeFlag & (1 << index)) != 0)
        pack[V, A](values(index), r, vertexElement)
    }*/

    if ((changeFlag & (1 << 0)) != 0)
      pack[V, POSITION_3F](_x, r, 0)
    if ((changeFlag & (1 << 1)) != 0)
      pack[V, POSITION_3F](_y, r, 1)
    if ((changeFlag & (1 << 2)) != 0)
      pack[V, POSITION_3F](_z, r, 2)

    if ((changeFlag & (1 << 3)) != 0)
      pack[V, TEX_2F](_u, r, 0)
    if ((changeFlag & (1 << 4)) != 0)
      pack[V, TEX_2F](_v, r, 1)

    if ((changeFlag & (1 << 5)) != 0)
      pack[V, COLOR_4UB](_r, r, 0)
    if ((changeFlag & (1 << 6)) != 0)
      pack[V, COLOR_4UB](_g, r, 1)
    if ((changeFlag & (1 << 7)) != 0)
      pack[V, COLOR_4UB](_b, r, 2)
    if ((changeFlag & (1 << 8)) != 0)
      pack[V, COLOR_4UB](_a, r, 3)

    if ((changeFlag & (1 << 9)) != 0)
      pack[V, TEX_2S](_lx, r, 0)
    if ((changeFlag & (1 << 10)) != 0)
      pack[V, TEX_2S](_ly, r, 1)

    if ((changeFlag & (1 << 11)) != 0)
      pack[V, NORMAL_3B](_nx, r, 0)
    if ((changeFlag & (1 << 12)) != 0)
      pack[V, NORMAL_3B](_ny, r, 1)
    if ((changeFlag & (1 << 13)) != 0)
      pack[V, NORMAL_3B](_nz, r, 2)

    if ((changeFlag & (1 << 14)) != 0)
      pack[V, PADDING_1B](_padding, r, 0)

  }

}
