package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class BooleanVector extends BaseVector {
    public BooleanVector() {
        super();
    }

    public BooleanVector __assign(int arg2, ByteBuffer arg3) {
        this.__reset(arg2, 1, arg3);
        return this;
    }

    public boolean get(int arg2) {
        if(this.bb.get(this.__element(arg2)) != 0) {
            return 1;
        }

        return 0;
    }
}

