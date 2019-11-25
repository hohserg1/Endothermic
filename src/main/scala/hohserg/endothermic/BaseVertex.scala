package hohserg.endothermic

import hohserg.endothermic.BaseVertex._
import hohserg.endothermic.format.AttributeRepresentation.{COLOR_4UB, NORMAL_3B, PADDING_1B, POSITION_3F, TEX_2F, TEX_2S, Vertex}
import hohserg.endothermic.format.UnpackEvaluations.unpack
import net.minecraft.client.renderer.vertex.VertexFormat

trait BaseVertex[SelfVertex <: BaseVertex[SelfVertex]] {
  def reconstruct(
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
                 ): SelfVertex = {
    val result = getUpdateDestination

    if (x != _x || ((initFlag & (1 << 0)) == 0 && x != defaultValue)) {
      result.initFlag |= (1 << 0)
      result.changeFlag |= (1 << 0)
      result._x = x
    }


    if (y != _y || ((initFlag & (1 << 1)) == 0 && y != defaultValue)) {
      result.initFlag |= (1 << 1)
      result.changeFlag |= (1 << 1)
      result._y = y
    }


    if (z != _z || ((initFlag & (1 << 2)) == 0 && z != defaultValue)) {
      result.initFlag |= (1 << 2)
      result.changeFlag |= (1 << 2)
      result._z = z
    }


    if (u != _u || ((initFlag & (1 << 3)) == 0 && u != defaultValue)) {
      result.initFlag |= (1 << 3)
      result.changeFlag |= (1 << 3)
      result._u = u
    }


    if (v != _v || ((initFlag & (1 << 4)) == 0 && v != defaultValue)) {
      result.initFlag |= (1 << 4)
      result.changeFlag |= (1 << 4)
      result._v = v
    }


    if (r != _r || ((initFlag & (1 << 5)) == 0 && r != defaultValue)) {
      result.initFlag |= (1 << 5)
      result.changeFlag |= (1 << 5)
      result._r = r
    }


    if (g != _g || ((initFlag & (1 << 6)) == 0 && g != defaultValue)) {
      result.initFlag |= (1 << 6)
      result.changeFlag |= (1 << 6)
      result._g = g
    }


    if (b != _b || ((initFlag & (1 << 7)) == 0 && b != defaultValue)) {
      result.initFlag |= (1 << 7)
      result.changeFlag |= (1 << 7)
      result._b = b
    }


    if (a != _a || ((initFlag & (1 << 8)) == 0 && a != defaultValue)) {
      result.initFlag |= (1 << 8)
      result.changeFlag |= (1 << 8)
      result._a = a
    }


    if (lx != _lx || ((initFlag & (1 << 9)) == 0 && lx != defaultValue)) {
      result.initFlag |= (1 << 9)
      result.changeFlag |= (1 << 9)
      result._lx = lx
    }


    if (ly != _ly || ((initFlag & (1 << 10)) == 0 && ly != defaultValue)) {
      result.initFlag |= (1 << 10)
      result.changeFlag |= (1 << 10)
      result._ly = ly
    }


    if (nx != _nx || ((initFlag & (1 << 11)) == 0 && nx != defaultValue)) {
      result.initFlag |= (1 << 11)
      result.changeFlag |= (1 << 11)
      result._nx = nx
    }


    if (ny != _ny || ((initFlag & (1 << 12)) == 0 && ny != defaultValue)) {
      result.initFlag |= (1 << 12)
      result.changeFlag |= (1 << 12)
      result._ny = ny
    }


    if (nz != _nz || ((initFlag & (1 << 13)) == 0 && nz != defaultValue)) {
      result.initFlag |= (1 << 13)
      result.changeFlag |= (1 << 13)
      result._nz = nz
    }


    if (padding != _padding || ((initFlag & (1 << 14)) == 0 && padding != defaultValue)) {
      result.initFlag |= (1 << 14)
      result.changeFlag |= (1 << 14)
      result._padding = padding
    }

    result
  }

  protected def quadData: Array[Int]

  implicit protected def format: VertexFormat

  implicit protected def vertex: Vertex

  def getUpdateDestination: SelfVertex


  protected var _x: Float = defaultValue

  protected var _y: Float = defaultValue

  protected var _z: Float = defaultValue

  protected var _u: Float = defaultValue

  protected var _v: Float = defaultValue

  protected var _r: Float = defaultValue

  protected var _g: Float = defaultValue

  protected var _b: Float = defaultValue

  protected var _a: Float = defaultValue

  protected var _lx: Float = defaultValue

  protected var _ly: Float = defaultValue

  protected var _nx: Float = defaultValue

  protected var _ny: Float = defaultValue

  protected var _nz: Float = defaultValue

  protected var _padding: Float = defaultValue

  private[endothermic] var initFlag: Int = 0
  private[endothermic] var changeFlag: Int = 0

  def x: Float = {
    if ((initFlag & (1 << 0)) == 0) {
      initFlag |= (1 << 0)
      _x = unpack[POSITION_3F](quadData, 0)
    }
    _x
  }

  def y: Float = {
    if ((initFlag & (1 << 1)) == 0) {
      initFlag |= (1 << 1)
      _y = unpack[POSITION_3F](quadData, 1)
    }
    _y
  }

  def z: Float = {
    if ((initFlag & (1 << 2)) == 0) {
      initFlag |= (1 << 2)
      _z = unpack[POSITION_3F](quadData, 2)
    }
    _z
  }

  def u: Float = {
    if ((initFlag & (1 << 3)) == 0) {
      initFlag |= (1 << 3)
      _u = unpack[TEX_2F](quadData, 0)
    }
    _u
  }

  def v: Float = {
    if ((initFlag & (1 << 4)) == 0) {
      initFlag |= (1 << 4)
      _v = unpack[TEX_2F](quadData, 1)
    }
    _v
  }

  def r: Float = {
    if ((initFlag & (1 << 5)) == 0) {
      initFlag |= (1 << 5)
      _r = unpack[COLOR_4UB](quadData, 0)
    }
    _r
  }

  def g: Float = {
    if ((initFlag & (1 << 6)) == 0) {
      initFlag |= (1 << 6)
      _g = unpack[COLOR_4UB](quadData, 1)
    }
    _g
  }

  def b: Float = {
    if ((initFlag & (1 << 7)) == 0) {
      initFlag |= (1 << 7)
      _b = unpack[COLOR_4UB](quadData, 2)
    }
    _b
  }

  def a: Float = {
    if ((initFlag & (1 << 8)) == 0) {
      initFlag |= (1 << 8)
      _a = unpack[COLOR_4UB](quadData, 3)
    }
    _a
  }

  def lx: Float = {
    if ((initFlag & (1 << 9)) == 0) {
      initFlag |= (1 << 9)
      _lx = unpack[TEX_2S](quadData, 0)
    }
    _lx
  }

  def ly: Float = {
    if ((initFlag & (1 << 10)) == 0) {
      initFlag |= (1 << 10)
      _ly = unpack[TEX_2S](quadData, 1)
    }
    _ly
  }

  def nx: Float = {
    if ((initFlag & (1 << 11)) == 0) {
      initFlag |= (1 << 11)
      _nx = unpack[NORMAL_3B](quadData, 0)
    }
    _nx
  }

  def ny: Float = {
    if ((initFlag & (1 << 12)) == 0) {
      initFlag |= (1 << 12)
      _ny = unpack[NORMAL_3B](quadData, 1)
    }
    _ny
  }

  def nz: Float = {
    if ((initFlag & (1 << 13)) == 0) {
      initFlag |= (1 << 13)
      _nz = unpack[NORMAL_3B](quadData, 2)
    }
    _nz
  }

  def padding: Float = {
    if ((initFlag & (1 << 14)) == 0) {
      initFlag |= (1 << 14)
      _padding = unpack[PADDING_1B](quadData, 0)
    }
    _padding
  }

}

object BaseVertex {
  val defaultValue = Float.MinValue + 11
}
