package hohserg.endothermic

import hohserg.endothermic.BaseUnpackedVertex._
import hohserg.endothermic.format.AttributeRepresentation.{COLOR_4UB, NORMAL_3B, PADDING_1B, POSITION_3F, TEX_2F, TEX_2S, Vertex}
import hohserg.endothermic.format.UnpackEvaluations.{pack, unpack}
import net.minecraft.client.renderer.vertex.VertexFormat

import scala.language.higherKinds

trait BaseUnpackedVertex[Self <: BaseUnpackedVertex[Self]] {

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

  private[endothermic] def toRawArray[VF <: VertexFormat](implicit r: Array[Int], newFormat: VF = format) = {
    if ((changeFlag & (1 << 0)) != 0)
      pack[POSITION_3F](_x, r, 0)
    if ((changeFlag & (1 << 1)) != 0)
      pack[POSITION_3F](_y, r, 1)
    if ((changeFlag & (1 << 2)) != 0)
      pack[POSITION_3F](_z, r, 2)

    if ((changeFlag & (1 << 3)) != 0)
      pack[TEX_2F](_u, r, 0)
    if ((changeFlag & (1 << 4)) != 0)
      pack[TEX_2F](_v, r, 1)

    if ((changeFlag & (1 << 5)) != 0)
      pack[COLOR_4UB](_r, r, 0)
    if ((changeFlag & (1 << 6)) != 0)
      pack[COLOR_4UB](_g, r, 1)
    if ((changeFlag & (1 << 7)) != 0)
      pack[COLOR_4UB](_b, r, 2)
    if ((changeFlag & (1 << 8)) != 0)
      pack[COLOR_4UB](_a, r, 3)

    if ((changeFlag & (1 << 9)) != 0)
      pack[TEX_2S](_lx, r, 0)
    if ((changeFlag & (1 << 10)) != 0)
      pack[TEX_2S](_ly, r, 1)

    if ((changeFlag & (1 << 11)) != 0)
      pack[NORMAL_3B](_nx, r, 0)
    if ((changeFlag & (1 << 12)) != 0)
      pack[NORMAL_3B](_ny, r, 1)
    if ((changeFlag & (1 << 13)) != 0)
      pack[NORMAL_3B](_nz, r, 2)

    if ((changeFlag & (1 << 14)) != 0)
      pack[PADDING_1B](_padding, r, 0)

  }

}

object BaseUnpackedVertex {

}
