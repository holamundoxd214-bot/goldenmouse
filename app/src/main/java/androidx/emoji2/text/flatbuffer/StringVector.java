package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {
    private Utf8 utf8;

    public StringVector() {
        super();
        this.utf8 = Utf8.getDefault();
    }

    public StringVector __assign(int arg1, int arg2, ByteBuffer arg3) {
        this.__reset(arg1, arg2, arg3);
        return this;
    }

    public String get(int arg2) {
        return Table.__string(this.__element(arg2), this.bb, this.utf8);
    }
}

