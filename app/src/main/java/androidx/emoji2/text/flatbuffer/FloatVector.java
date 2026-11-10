package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class FloatVector extends BaseVector {
    public FloatVector() {
        super();
    }

    public FloatVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 4, arg3);
        return this;
    }

    public float get(int arg2) {
        return this.bb.getFloat(this.__element(arg2));
    }
}

