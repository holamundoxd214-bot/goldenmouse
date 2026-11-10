package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    public BaseVector() {
        super();
    }

    protected int __element(int arg2) {
        return this.vector + arg2 * this.element_size;
    }

    protected void __reset(int arg1, int arg2, ByteBuffer arg3) {
        this.bb = arg3;
        if(arg3 != null) {
            this.vector = arg1;
            this.length = arg3.getInt(arg1 - 4);
            this.element_size = arg2;
            return;
        }

        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        this.__reset(0, 0, null);
    }
}

