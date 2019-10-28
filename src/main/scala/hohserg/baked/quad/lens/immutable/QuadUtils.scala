package hohserg.baked.quad.lens.immutable

import net.minecraft.client.renderer.vertex.VertexFormat

object QuadUtils {

  def slice(vertexData: Array[Int], px1: Float, py1: Float, px2: Float, py2: Float)(implicit format: VertexFormat): Array[Int] = {
   null
  }

  //{{0,v1,v2,v3,v4},{x,0,1,1,0},{y,0,0,1,1},{xy,0,0,1,0},{1,1,1,1,1}}


  //-a v1 + a v2 - a v3 + a v4 + v1 x + v1 y - v1 - v2 x - v4 y

}
