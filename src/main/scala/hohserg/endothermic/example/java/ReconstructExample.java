package hohserg.endothermic.example.java;

import hohserg.endothermic.quad.immutable.UnpackedQuad;
import net.minecraft.client.renderer.block.model.BakedQuad;

import java.util.function.Function;

public class ReconstructExample implements Function<BakedQuad, BakedQuad> {

    @Override
    public BakedQuad apply(BakedQuad quad) {
        return UnpackedQuad.apply(quad)
                .reconstructBuilder()//no allocation
                .v1_x(0.5f)//updated x of first vertex
                .build()
                .toBakedQuad();
    }
}