package hohserg.endothermic.format

import hohserg.endothermic.format.AttributeRepresentation.Vertex
import hohserg.endothermic.format.EvaluationPool.memoize
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.vertex.{VertexFormat, VertexFormatElement}

import scala.collection.JavaConverters._

object UnpackEvaluations {


  val getFormatParseRule = memoize(getFormatParseRule1)

  private def getFormatParseRule1(format: VertexFormat): Seq[(BakedQuad => Float, (VertexFormatElement, Int, Vertex))] = {
    //Map[(VertexFormatElement, Int, Vertex), BakedQuad => Float]
    for (vfe <- format.getElements.asScala.toList.toSeq; i <- 0 until vfe.getElementCount; vertex <- Vertex.vertices) yield {
      /*
      Position
        x
          1 0
          2 1
          3 2
          4 3
        y
          1 4
          2 5
          3 6
          4 7
        z
          1 8
          2 9
          3 10
          4 11
      Color
        r
          1 12
          2 13
          3 14
          4 15
        g
          1 16
          2 17
          3 18
          4 19
        b
          1 20
          2 21
          3 22
          4 23
        a
          1 24
          2 25
          3 26
          4 27
       */

      val element = vfe
      val v = vertex.index
      val formatFrom = format
      val vertexStart = v * formatFrom.getNextOffset + formatFrom.getOffset(formatFrom.getElements.indexOf(element))
      val count = element.getElementCount
      val elementType = element.getType
      val size = elementType.getSize
      val mask = (256 << (8 * (size - 1))) - 1
      val pos = vertexStart + size * i
      val index = pos >> 2
      val offset = pos & 3

      val evaluation: BakedQuad => Int = if ((pos + size - 1) / 4 != index) {
        quad: BakedQuad => {
          val from = quad.getVertexData
          var bits = from(index)
          bits = bits >>> (offset * 8)

          bits |= from(index + 1) << ((4 - offset) * 8)

          bits &= mask
          bits
        }
      } else {

        quad: BakedQuad => {
          val from = quad.getVertexData
          var bits = from(index)
          bits = bits >>> (offset * 8)

          bits &= mask
          bits
        }

      }

      (if (elementType == VertexFormatElement.EnumType.FLOAT) {
        evaluation andThen java.lang.Float.intBitsToFloat
      }
      else if (elementType == VertexFormatElement.EnumType.UBYTE || elementType == VertexFormatElement.EnumType.USHORT) {
        evaluation andThen (_.toFloat / mask)
      }
      else if (elementType == VertexFormatElement.EnumType.UINT) {
        evaluation andThen (bits => ((bits & 0xFFFFFFFFL).toDouble / 0xFFFFFFFFL).toFloat)
      }
      else if (elementType == VertexFormatElement.EnumType.BYTE) {
        evaluation andThen (bits => bits.toByte.toFloat / (mask >> 1))
      }
      else if (elementType == VertexFormatElement.EnumType.SHORT) {
        evaluation andThen (bits => bits.toShort.toFloat / (mask >> 1))
      }
      else if (elementType == VertexFormatElement.EnumType.INT) {
        evaluation andThen (bits => ((bits & 0xFFFFFFFFL).toDouble / (0xFFFFFFFFL >> 1)).toFloat)
      } else
        (_: BakedQuad) => 0f)->(vfe,i,vertex)
    }
  }
}
