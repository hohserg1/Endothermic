# BakedQuadLens
Library for minecraft forge for baked quad manipulating

Example usage

```java
//Getting values of quad vertices
Vector3f positionOfFourthVertex = VertexGetLens.getPos(someQuad.getVertexData(), someQuad.getFormat(), 3, Vector3f::new);

Color colorOfFirstVertex = VertexGetLens.getColor(someQuad.getVertexData(), someQuad.getFormat(), 0, Color::new);

//Setting values to quad vertices
int[] newSecondVertexData = VertexSetLens.setNormal(someQuad.getVertexData(), x,y,z,someQuad.getFormat(), 1);
```
