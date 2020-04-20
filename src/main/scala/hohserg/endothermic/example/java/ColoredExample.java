package hohserg.endothermic.example.java;

import hohserg.endothermic.quad.immutable.UnpackedQuad;
import net.minecraft.client.renderer.block.model.BakedQuad;

import java.util.function.Function;

public class ColoredExample implements Function<BakedQuad, BakedQuad> {

    @Override
    public BakedQuad apply(BakedQuad quad) {
        return UnpackedQuad.apply(quad)
                .reconstructBuilder()
                .v1_r(255)//colored first vertex to red
                .v2_g(255)//colored second vertex to green
                .v3_b(255)//colored third vertex to blue
                .build()
                .toBakedQuad();
    }
}