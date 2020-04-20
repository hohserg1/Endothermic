package hohserg.endothermic.example.java;

import net.minecraft.client.renderer.block.model.BakedQuad;

import hohserg.endothermic.quad.immutable.UnpackedQuad;

import java.util.function.Function;

public class TranslationExample implements Function<BakedQuad, BakedQuad> {

    @Override
    public BakedQuad apply(BakedQuad quad) {
        return UnpackedQuad.apply(quad)
                .translate(1,0,0)
                .toBakedQuad();
    }
}
