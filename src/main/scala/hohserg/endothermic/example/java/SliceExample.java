package hohserg.endothermic.example.java;

import hohserg.endothermic.quad.immutable.UnpackedQuad;
import net.minecraft.client.renderer.block.model.BakedQuad;

import java.util.function.Function;

public class SliceExample implements Function<BakedQuad, BakedQuad> {

    @Override
    public BakedQuad apply(BakedQuad quad) {
        return UnpackedQuad.apply(quad)
                .slice(
                        0, 0,
                        0.5f, 0,
                        0.5f, 0.5f,
                        0, 0.5f)
                .toBakedQuad();
    }
}