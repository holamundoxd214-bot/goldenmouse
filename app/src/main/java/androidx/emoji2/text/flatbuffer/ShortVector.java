package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ShortVector extends BaseVector {
    public ShortVector() {
        super();
    }

    public ShortVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 2, arg3);
        return this;
    }

    public short get(int arg2) {
        return this.bb.getShort(this.__element(arg2));
    }

    public int getAsUnsigned(int arg1) {
        return this.get(arg1) & 0xFFFF;
    }
}

