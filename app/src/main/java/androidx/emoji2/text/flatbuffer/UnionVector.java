package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector() {
        super();
    }

    public UnionVector __assign(int arg1, int arg2, ByteBuffer arg3) {
        this.__reset(arg1, arg2, arg3);
        return this;
    }

    public Table get(Table arg1, int arg2) {
        return Table.__union(arg1, this.__element(arg2), this.bb);
    }
}

