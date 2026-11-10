package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class ByteBufferUtil {
    public ByteBufferUtil() {
        super();
    }

    public static int getSizePrefix(ByteBuffer arg1) {
        return arg1.getInt(arg1.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer arg1) {
        arg1 = arg1.duplicate();
        arg1.position(arg1.position() + 4);
        return arg1;
    }
}

