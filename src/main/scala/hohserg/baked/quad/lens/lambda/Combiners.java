package hohserg.baked.quad.lens.lambda;

public class Combiners {
    public interface Float3Combiner<A> {
        A apply(float x, float y, float z);
    }

    public interface Float4Combiner<A> {
        A apply(float r, float g, float b, float a);
    }

    public interface Float2Combiner<A> {
        A apply(float u, float v);
    }

    public interface Byte3Combiner<A> {
        A apply(byte x, byte y, byte z);
    }

    public interface Short2Combiner<A> {
        A apply(short x, short y);
    }
}
