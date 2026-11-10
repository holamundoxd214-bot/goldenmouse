package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class IntVector extends BaseVector {
    public IntVector() {
        super();
    }

    public IntVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 4, arg3);
        return this;
    }

    public int get(int arg2) {
        return this.bb.getInt(this.__element(arg2));
    }

    public long getAsUnsigned(int arg3) {
        return (((long)this.get(arg3))) & 0xFFFFFFFFL;
    }
}

