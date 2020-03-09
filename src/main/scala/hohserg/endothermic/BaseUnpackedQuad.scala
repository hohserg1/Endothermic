package hohserg.endothermic

import hohserg.endothermic.BaseUnpackedQuad._
import hohserg.endothermic.format.AttributeRepresentation.{Vertex, _}
import hohserg.endothermic.format.UnpackEvaluations
import hohserg.endothermic.ops.{QuadOps, ReconstructOpsQuad}
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.vertex.VertexFormat

trait BaseUnpackedQuad extends ReconstructOpsQuad with QuadOps {

  def quad: BakedQuad

  def format: VertexFormat

  val evaluations = UnpackEvaluations.getFormatParseRule(format)

  def flatAttributeKey(vfei: Int, vertex: Vertex): Int =
    vfei + vertex.index


  var initFlag1: Int = 0
  var initFlag2: Int = 0
  var initFlag3: Int = 0
  var initFlag4: Int = 0


  private[endothermic] var _v1_x: Float = defaultValue

  def v1_x: Float = {
    if ((initFlag1 & (1 << x)) == 0) {
      initFlag1 |= (1 << x)
      _v1_x = evaluations(flatAttributeKey(x, _1))(quad)
    }
    _v1_x
  }

  private[endothermic] var _v1_y: Float = defaultValue

  def v1_y: Float = {
    if ((initFlag1 & (1 << y)) == 0) {
      initFlag1 |= (1 << y)
      _v1_y = evaluations(flatAttributeKey(y, _1))(quad)
    }
    _v1_y
  }

  private[endothermic] var _v1_z: Float = defaultValue

  def v1_z: Float = {
    if ((initFlag1 & (1 << z)) == 0) {
      initFlag1 |= (1 << z)
      _v1_z = evaluations(flatAttributeKey(z, _1))(quad)
    }
    _v1_z
  }

  private[endothermic] var _v1_r: Float = defaultValue

  def v1_r: Float = {
    if ((initFlag1 & (1 << r)) == 0) {
      initFlag1 |= (1 << r)
      _v1_r = evaluations(flatAttributeKey(r, _1))(quad)
    }
    _v1_r
  }

  private[endothermic] var _v1_g: Float = defaultValue

  def v1_g: Float = {
    if ((initFlag1 & (1 << g)) == 0) {
      initFlag1 |= (1 << g)
      _v1_g = evaluations(flatAttributeKey(g, _1))(quad)
    }
    _v1_g
  }

  private[endothermic] var _v1_b: Float = defaultValue

  def v1_b: Float = {
    if ((initFlag1 & (1 << b)) == 0) {
      initFlag1 |= (1 << b)
      _v1_b = evaluations(flatAttributeKey(b, _1))(quad)
    }
    _v1_b
  }

  private[endothermic] var _v1_a: Float = defaultValue

  def v1_a: Float = {
    if ((initFlag1 & (1 << a)) == 0) {
      initFlag1 |= (1 << a)
      _v1_a = evaluations(flatAttributeKey(a, _1))(quad)
    }
    _v1_a
  }

  private[endothermic] var _v1_u: Float = defaultValue

  def v1_u: Float = {
    if ((initFlag1 & (1 << u)) == 0) {
      initFlag1 |= (1 << u)
      _v1_u = evaluations(flatAttributeKey(u, _1))(quad)
    }
    _v1_u
  }

  private[endothermic] var _v1_v: Float = defaultValue

  def v1_v: Float = {
    if ((initFlag1 & (1 << v)) == 0) {
      initFlag1 |= (1 << v)
      _v1_v = evaluations(flatAttributeKey(v, _1))(quad)
    }
    _v1_v
  }

  private[endothermic] var _v1_lu: Float = defaultValue

  def v1_lu: Float = {
    if ((initFlag1 & (1 << lu)) == 0) {
      initFlag1 |= (1 << lu)
      _v1_lu = evaluations(flatAttributeKey(lu, _1))(quad)
    }
    _v1_lu
  }

  private[endothermic] var _v1_lv: Float = defaultValue

  def v1_lv: Float = {
    if ((initFlag1 & (1 << lv)) == 0) {
      initFlag1 |= (1 << lv)
      _v1_lv = evaluations(flatAttributeKey(lv, _1))(quad)
    }
    _v1_lv
  }

  private[endothermic] var _v1_nx: Float = defaultValue

  def v1_nx: Float = {
    if ((initFlag1 & (1 << nx)) == 0) {
      initFlag1 |= (1 << nx)
      _v1_nx = evaluations(flatAttributeKey(nx, _1))(quad)
    }
    _v1_nx
  }

  private[endothermic] var _v1_ny: Float = defaultValue

  def v1_ny: Float = {
    if ((initFlag1 & (1 << ny)) == 0) {
      initFlag1 |= (1 << ny)
      _v1_ny = evaluations(flatAttributeKey(ny, _1))(quad)
    }
    _v1_ny
  }

  private[endothermic] var _v1_nz: Float = defaultValue

  def v1_nz: Float = {
    if ((initFlag1 & (1 << nz)) == 0) {
      initFlag1 |= (1 << nz)
      _v1_nz = evaluations(flatAttributeKey(nz, _1))(quad)
    }
    _v1_nz
  }

  private[endothermic] var _v1_p: Float = defaultValue

  def v1_p: Float = {
    if ((initFlag1 & (1 << p)) == 0) {
      initFlag1 |= (1 << p)
      _v1_p = evaluations(flatAttributeKey(p, _1))(quad)
    }
    _v1_p
  }


  private[endothermic] var _v2_x: Float = defaultValue

  def v2_x: Float = {
    if ((initFlag2 & (1 << x)) == 0) {
      initFlag2 |= (1 << x)
      _v2_x = evaluations(flatAttributeKey(x, _2))(quad)
    }
    _v2_x
  }

  private[endothermic] var _v2_y: Float = defaultValue

  def v2_y: Float = {
    if ((initFlag2 & (1 << y)) == 0) {
      initFlag2 |= (1 << y)
      _v2_y = evaluations(flatAttributeKey(y, _2))(quad)
    }
    _v2_y
  }

  private[endothermic] var _v2_z: Float = defaultValue

  def v2_z: Float = {
    if ((initFlag2 & (1 << z)) == 0) {
      initFlag2 |= (1 << z)
      _v2_z = evaluations(flatAttributeKey(z, _2))(quad)
    }
    _v2_z
  }

  private[endothermic] var _v2_r: Float = defaultValue

  def v2_r: Float = {
    if ((initFlag2 & (1 << r)) == 0) {
      initFlag2 |= (1 << r)
      _v2_r = evaluations(flatAttributeKey(r, _2))(quad)
    }
    _v2_r
  }

  private[endothermic] var _v2_g: Float = defaultValue

  def v2_g: Float = {
    if ((initFlag2 & (1 << g)) == 0) {
      initFlag2 |= (1 << g)
      _v2_g = evaluations(flatAttributeKey(g, _2))(quad)
    }
    _v2_g
  }

  private[endothermic] var _v2_b: Float = defaultValue

  def v2_b: Float = {
    if ((initFlag2 & (1 << b)) == 0) {
      initFlag2 |= (1 << b)
      _v2_b = evaluations(flatAttributeKey(b, _2))(quad)
    }
    _v2_b
  }

  private[endothermic] var _v2_a: Float = defaultValue

  def v2_a: Float = {
    if ((initFlag2 & (1 << a)) == 0) {
      initFlag2 |= (1 << a)
      _v2_a = evaluations(flatAttributeKey(a, _2))(quad)
    }
    _v2_a
  }

  private[endothermic] var _v2_u: Float = defaultValue

  def v2_u: Float = {
    if ((initFlag2 & (1 << u)) == 0) {
      initFlag2 |= (1 << u)
      _v2_u = evaluations(flatAttributeKey(u, _2))(quad)
    }
    _v2_u
  }

  private[endothermic] var _v2_v: Float = defaultValue

  def v2_v: Float = {
    if ((initFlag2 & (1 << v)) == 0) {
      initFlag2 |= (1 << v)
      _v2_v = evaluations(flatAttributeKey(v, _2))(quad)
    }
    _v2_v
  }

  private[endothermic] var _v2_lu: Float = defaultValue

  def v2_lu: Float = {
    if ((initFlag2 & (1 << lu)) == 0) {
      initFlag2 |= (1 << lu)
      _v2_lu = evaluations(flatAttributeKey(lu, _2))(quad)
    }
    _v2_lu
  }

  private[endothermic] var _v2_lv: Float = defaultValue

  def v2_lv: Float = {
    if ((initFlag2 & (1 << lv)) == 0) {
      initFlag2 |= (1 << lv)
      _v2_lv = evaluations(flatAttributeKey(lv, _2))(quad)
    }
    _v2_lv
  }

  private[endothermic] var _v2_nx: Float = defaultValue

  def v2_nx: Float = {
    if ((initFlag2 & (1 << nx)) == 0) {
      initFlag2 |= (1 << nx)
      _v2_nx = evaluations(flatAttributeKey(nx, _2))(quad)
    }
    _v2_nx
  }

  private[endothermic] var _v2_ny: Float = defaultValue

  def v2_ny: Float = {
    if ((initFlag2 & (1 << ny)) == 0) {
      initFlag2 |= (1 << ny)
      _v2_ny = evaluations(flatAttributeKey(ny, _2))(quad)
    }
    _v2_ny
  }

  private[endothermic] var _v2_nz: Float = defaultValue

  def v2_nz: Float = {
    if ((initFlag2 & (1 << nz)) == 0) {
      initFlag2 |= (1 << nz)
      _v2_nz = evaluations(flatAttributeKey(nz, _2))(quad)
    }
    _v2_nz
  }

  private[endothermic] var _v2_p: Float = defaultValue

  def v2_p: Float = {
    if ((initFlag2 & (1 << p)) == 0) {
      initFlag2 |= (1 << p)
      _v2_p = evaluations(flatAttributeKey(p, _2))(quad)
    }
    _v2_p
  }


  private[endothermic] var _v3_x: Float = defaultValue

  def v3_x: Float = {
    if ((initFlag3 & (1 << x)) == 0) {
      initFlag3 |= (1 << x)
      _v3_x = evaluations(flatAttributeKey(x, _3))(quad)
    }
    _v3_x
  }

  private[endothermic] var _v3_y: Float = defaultValue

  def v3_y: Float = {
    if ((initFlag3 & (1 << y)) == 0) {
      initFlag3 |= (1 << y)
      _v3_y = evaluations(flatAttributeKey(y, _3))(quad)
    }
    _v3_y
  }

  private[endothermic] var _v3_z: Float = defaultValue

  def v3_z: Float = {
    if ((initFlag3 & (1 << z)) == 0) {
      initFlag3 |= (1 << z)
      _v3_z = evaluations(flatAttributeKey(z, _3))(quad)
    }
    _v3_z
  }

  private[endothermic] var _v3_r: Float = defaultValue

  def v3_r: Float = {
    if ((initFlag3 & (1 << r)) == 0) {
      initFlag3 |= (1 << r)
      _v3_r = evaluations(flatAttributeKey(r, _3))(quad)
    }
    _v3_r
  }

  private[endothermic] var _v3_g: Float = defaultValue

  def v3_g: Float = {
    if ((initFlag3 & (1 << g)) == 0) {
      initFlag3 |= (1 << g)
      _v3_g = evaluations(flatAttributeKey(g, _3))(quad)
    }
    _v3_g
  }

  private[endothermic] var _v3_b: Float = defaultValue

  def v3_b: Float = {
    if ((initFlag3 & (1 << b)) == 0) {
      initFlag3 |= (1 << b)
      _v3_b = evaluations(flatAttributeKey(b, _3))(quad)
    }
    _v3_b
  }

  private[endothermic] var _v3_a: Float = defaultValue

  def v3_a: Float = {
    if ((initFlag3 & (1 << a)) == 0) {
      initFlag3 |= (1 << a)
      _v3_a = evaluations(flatAttributeKey(a, _3))(quad)
    }
    _v3_a
  }

  private[endothermic] var _v3_u: Float = defaultValue

  def v3_u: Float = {
    if ((initFlag3 & (1 << u)) == 0) {
      initFlag3 |= (1 << u)
      _v3_u = evaluations(flatAttributeKey(u, _3))(quad)
    }
    _v3_u
  }

  private[endothermic] var _v3_v: Float = defaultValue

  def v3_v: Float = {
    if ((initFlag3 & (1 << v)) == 0) {
      initFlag3 |= (1 << v)
      _v3_v = evaluations(flatAttributeKey(v, _3))(quad)
    }
    _v3_v
  }

  private[endothermic] var _v3_lu: Float = defaultValue

  def v3_lu: Float = {
    if ((initFlag3 & (1 << lu)) == 0) {
      initFlag3 |= (1 << lu)
      _v3_lu = evaluations(flatAttributeKey(lu, _3))(quad)
    }
    _v3_lu
  }

  private[endothermic] var _v3_lv: Float = defaultValue

  def v3_lv: Float = {
    if ((initFlag3 & (1 << lv)) == 0) {
      initFlag3 |= (1 << lv)
      _v3_lv = evaluations(flatAttributeKey(lv, _3))(quad)
    }
    _v3_lv
  }

  private[endothermic] var _v3_nx: Float = defaultValue

  def v3_nx: Float = {
    if ((initFlag3 & (1 << nx)) == 0) {
      initFlag3 |= (1 << nx)
      _v3_nx = evaluations(flatAttributeKey(nx, _3))(quad)
    }
    _v3_nx
  }

  private[endothermic] var _v3_ny: Float = defaultValue

  def v3_ny: Float = {
    if ((initFlag3 & (1 << ny)) == 0) {
      initFlag3 |= (1 << ny)
      _v3_ny = evaluations(flatAttributeKey(ny, _3))(quad)
    }
    _v3_ny
  }

  private[endothermic] var _v3_nz: Float = defaultValue

  def v3_nz: Float = {
    if ((initFlag3 & (1 << nz)) == 0) {
      initFlag3 |= (1 << nz)
      _v3_nz = evaluations(flatAttributeKey(nz, _3))(quad)
    }
    _v3_nz
  }

  private[endothermic] var _v3_p: Float = defaultValue

  def v3_p: Float = {
    if ((initFlag3 & (1 << p)) == 0) {
      initFlag3 |= (1 << p)
      _v3_p = evaluations(flatAttributeKey(p, _3))(quad)
    }
    _v3_p
  }


  private[endothermic] var _v4_x: Float = defaultValue

  def v4_x: Float = {
    if ((initFlag4 & (1 << x)) == 0) {
      initFlag4 |= (1 << x)
      _v4_x = evaluations(flatAttributeKey(x, _4))(quad)
    }
    _v4_x
  }

  private[endothermic] var _v4_y: Float = defaultValue

  def v4_y: Float = {
    if ((initFlag4 & (1 << y)) == 0) {
      initFlag4 |= (1 << y)
      _v4_y = evaluations(flatAttributeKey(y, _4))(quad)
    }
    _v4_y
  }

  private[endothermic] var _v4_z: Float = defaultValue

  def v4_z: Float = {
    if ((initFlag4 & (1 << z)) == 0) {
      initFlag4 |= (1 << z)
      _v4_z = evaluations(flatAttributeKey(z, _4))(quad)
    }
    _v4_z
  }

  private[endothermic] var _v4_r: Float = defaultValue

  def v4_r: Float = {
    if ((initFlag4 & (1 << r)) == 0) {
      initFlag4 |= (1 << r)
      _v4_r = evaluations(flatAttributeKey(r, _4))(quad)
    }
    _v4_r
  }

  private[endothermic] var _v4_g: Float = defaultValue

  def v4_g: Float = {
    if ((initFlag4 & (1 << g)) == 0) {
      initFlag4 |= (1 << g)
      _v4_g = evaluations(flatAttributeKey(g, _4))(quad)
    }
    _v4_g
  }

  private[endothermic] var _v4_b: Float = defaultValue

  def v4_b: Float = {
    if ((initFlag4 & (1 << b)) == 0) {
      initFlag4 |= (1 << b)
      _v4_b = evaluations(flatAttributeKey(b, _4))(quad)
    }
    _v4_b
  }

  private[endothermic] var _v4_a: Float = defaultValue

  def v4_a: Float = {
    if ((initFlag4 & (1 << a)) == 0) {
      initFlag4 |= (1 << a)
      _v4_a = evaluations(flatAttributeKey(a, _4))(quad)
    }
    _v4_a
  }

  private[endothermic] var _v4_u: Float = defaultValue

  def v4_u: Float = {
    if ((initFlag4 & (1 << u)) == 0) {
      initFlag4 |= (1 << u)
      _v4_u = evaluations(flatAttributeKey(u, _4))(quad)
    }
    _v4_u
  }

  private[endothermic] var _v4_v: Float = defaultValue

  def v4_v: Float = {
    if ((initFlag4 & (1 << v)) == 0) {
      initFlag4 |= (1 << v)
      _v4_v = evaluations(flatAttributeKey(v, _4))(quad)
    }
    _v4_v
  }

  private[endothermic] var _v4_lu: Float = defaultValue

  def v4_lu: Float = {
    if ((initFlag4 & (1 << lu)) == 0) {
      initFlag4 |= (1 << lu)
      _v4_lu = evaluations(flatAttributeKey(lu, _4))(quad)
    }
    _v4_lu
  }

  private[endothermic] var _v4_lv: Float = defaultValue

  def v4_lv: Float = {
    if ((initFlag4 & (1 << lv)) == 0) {
      initFlag4 |= (1 << lv)
      _v4_lv = evaluations(flatAttributeKey(lv, _4))(quad)
    }
    _v4_lv
  }

  private[endothermic] var _v4_nx: Float = defaultValue

  def v4_nx: Float = {
    if ((initFlag4 & (1 << nx)) == 0) {
      initFlag4 |= (1 << nx)
      _v4_nx = evaluations(flatAttributeKey(nx, _4))(quad)
    }
    _v4_nx
  }

  private[endothermic] var _v4_ny: Float = defaultValue

  def v4_ny: Float = {
    if ((initFlag4 & (1 << ny)) == 0) {
      initFlag4 |= (1 << ny)
      _v4_ny = evaluations(flatAttributeKey(ny, _4))(quad)
    }
    _v4_ny
  }

  private[endothermic] var _v4_nz: Float = defaultValue

  def v4_nz: Float = {
    if ((initFlag4 & (1 << nz)) == 0) {
      initFlag4 |= (1 << nz)
      _v4_nz = evaluations(flatAttributeKey(nz, _4))(quad)
    }
    _v4_nz
  }

  private[endothermic] var _v4_p: Float = defaultValue

  def v4_p: Float = {
    if ((initFlag4 & (1 << p)) == 0) {
      initFlag4 |= (1 << p)
      _v4_p = evaluations(flatAttributeKey(p, _4))(quad)
    }
    _v4_p
  }

}

object BaseUnpackedQuad {

  val defaultValue = Float.MinValue + 11

  val x = 0
  val y = 4
  val z = 8
  val r = 12
  val g = 16
  val b = 20
  val a = 24
  val u = 28
  val v = 32
  val lu = 36
  val lv = 40
  val nx = 44
  val ny = 48
  val nz = 52
  val p = 56

}