package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector() {
        super();
    }

    public LongVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 8, arg3);
        return this;
    }

    public long get(int arg2) {
        return this.bb.getLong(this.__element(arg2));
    }
}

