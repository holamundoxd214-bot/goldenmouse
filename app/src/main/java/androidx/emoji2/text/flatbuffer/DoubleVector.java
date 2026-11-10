package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class DoubleVector extends BaseVector {
    public DoubleVector() {
        super();
    }

    public DoubleVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 8, arg3);
        return this;
    }

    public double get(int arg2) {
        return this.bb.getDouble(this.__element(arg2));
    }
}

