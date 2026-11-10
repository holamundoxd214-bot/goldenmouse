package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    public Struct() {
        super();
    }

    public void __reset() {
        this.__reset(0, null);
    }

    protected void __reset(int arg1, ByteBuffer arg2) {
        this.bb = arg2;
        if(arg2 != null) {
            this.bb_pos = arg1;
            return;
        }

        this.bb_pos = 0;
    }
}

