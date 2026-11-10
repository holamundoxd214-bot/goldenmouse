package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector() {
        super();
    }

    public ByteVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 1, arg3);
        return this;
    }

    public byte get(int arg2) {
        return this.bb.get(this.__element(arg2));
    }

    public int getAsUnsigned(int arg1) {
        return this.get(arg1) & 0xFF;
    }
}

