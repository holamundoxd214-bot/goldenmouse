package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    class androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1 implements Comparator {
        androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1(FlexBuffersBuilder arg1) {
            FlexBuffersBuilder.this = arg1;
            super();
        }

        public int compare(Value arg3, Value arg4) {
            int v1;
            int v0;
            int v3 = arg3.key;
            int v4 = arg4.key;
            do {
                v0 = FlexBuffersBuilder.this.bb.get(v3);
                v1 = FlexBuffersBuilder.this.bb.get(v4);
                if(v0 == 0) {
                    goto label_9;
                }

                ++v3;
                ++v4;
            }
            while(v0 == v1);

            return v0 - v1;
        label_9:
            return v0 - v1;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((Value)arg1), ((Value)arg2));
        }
    }

    class Value {
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        static {
        }

        Value(int arg1, int arg2, int arg3, long arg4) {
            super();
            this.key = arg1;
            this.type = arg2;
            this.minBitWidth = arg3;
            this.iValue = arg4;
            this.dValue = 4.900000E-324;
        }

        Value(int arg1, int arg2, int arg3, double arg4) {
            super();
            this.key = arg1;
            this.type = arg2;
            this.minBitWidth = arg3;
            this.dValue = arg4;
            this.iValue = -9223372036854775808L;
        }

        static int access$100(int arg0, int arg1) {
            return Value.paddingBytes(arg0, arg1);
        }

        static int access$200(Value arg0, int arg1, int arg2) {
            return arg0.elemWidth(arg1, arg2);
        }

        static byte access$300(Value arg0) {
            return arg0.storedPackedType();
        }

        static byte access$400(Value arg0, int arg1) {
            return arg0.storedPackedType(arg1);
        }

        static int access$500(int arg0, int arg1, long arg2, int arg4, int arg5) {
            return Value.elemWidth(arg0, arg1, arg2, arg4, arg5);
        }

        static Value blob(int arg6, int arg7, int arg8, int arg9) {
            return new Value(arg6, arg8, arg9, ((long)arg7));
        }

        static Value bool(int arg6, boolean arg7) {
            long v1 = arg7 ? 1 : 0;
            return new Value(arg6, 26, 0, v1);
        }

        private int elemWidth(int arg7, int arg8) {
            return Value.elemWidth(this.type, this.minBitWidth, this.iValue, arg7, arg8);
        }

        private static int elemWidth(int arg4, int arg5, long arg6, int arg8, int arg9) {
            if(FlexBuffers.isTypeInline(arg4)) {
                return arg5;
            }

            for(arg4 = 1; arg4 <= 0x20; arg4 *= 2) {
                arg5 = FlexBuffersBuilder.widthUInBits(((long)(((int)((((long)(Value.paddingBytes(arg8, arg4) + arg8 + arg9 * arg4))) - arg6)))));
                if(1 << arg5 == (((long)arg4))) {
                    return arg5;
                }
            }

            return 3;
        }

        static Value float32(int arg6, float arg7) {
            return new Value(arg6, 3, 2, ((double)arg7));
        }

        static Value float64(int arg6, double arg7) {
            return new Value(arg6, 3, 3, arg7);
        }

        static Value int16(int arg6, int arg7) {
            return new Value(arg6, 1, 1, ((long)arg7));
        }

        static Value int32(int arg6, int arg7) {
            return new Value(arg6, 1, 2, ((long)arg7));
        }

        static Value int64(int arg6, long arg7) {
            return new Value(arg6, 1, 3, arg7);
        }

        static Value int8(int arg6, int arg7) {
            return new Value(arg6, 1, 0, ((long)arg7));
        }

        private static byte packedType(int arg0, int arg1) {
            return ((byte)(arg0 | arg1 << 2));
        }

        private static int paddingBytes(int arg0, int arg1) {
            return ~arg0 + 1 & arg1 - 1;
        }

        private byte storedPackedType() {
            return this.storedPackedType(0);
        }

        private byte storedPackedType(int arg1) {
            return Value.packedType(this.storedWidth(arg1), this.type);
        }

        private int storedWidth(int arg2) {
            boolean v0 = FlexBuffers.isTypeInline(this.type);
            int v1 = this.minBitWidth;
            if(v0) {
                v1 = Math.max(v1, arg2);
            }

            return v1;
        }

        static Value uInt16(int arg6, int arg7) {
            return new Value(arg6, 2, 1, ((long)arg7));
        }

        static Value uInt32(int arg6, int arg7) {
            return new Value(arg6, 2, 2, ((long)arg7));
        }

        static Value uInt64(int arg6, long arg7) {
            return new Value(arg6, 2, 3, arg7);
        }

        static Value uInt8(int arg6, int arg7) {
            return new Value(arg6, 2, 0, ((long)arg7));
        }
    }

    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator keyComparator;
    private final HashMap keyPool;
    private final ArrayList stack;
    private final HashMap stringPool;

    static {
    }

    public FlexBuffersBuilder() {
        this(0x100);
    }

    public FlexBuffersBuilder(int arg2) {
        this(new ArrayReadWriteBuf(arg2), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf arg2, int arg3) {
        super();
        this.stack = new ArrayList();
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.finished = false;
        this.keyComparator = new androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1(this);
        this.bb = arg2;
        this.flags = arg3;
    }

    public FlexBuffersBuilder(ByteBuffer arg2) {
        this(arg2, 1);
    }

    @Deprecated public FlexBuffersBuilder(ByteBuffer arg2, int arg3) {
        this(new ArrayReadWriteBuf(arg2.array()), arg3);
    }

    static ReadWriteBuf access$000(FlexBuffersBuilder arg0) {
        return arg0.bb;
    }

    private int align(int arg4) {
        arg4 = 1 << arg4;
        int v0;
        for(v0 = Value.access$100(this.bb.writePosition(), arg4); true; v0 = v1) {
            int v1 = v0 - 1;
            if(v0 == 0) {
                return arg4;
            }

            this.bb.put(0);
        }

        return arg4;
    }

    private Value createKeyVector(int arg14, int arg15) {
        long v0 = ((long)arg15);
        int v6 = Math.max(0, FlexBuffersBuilder.widthUInBits(v0));
        for(arg15 = arg14; arg15 < this.stack.size(); arg15 = v12) {
            int v12 = arg15 + 1;
            v6 = Math.max(v6, Value.access$500(4, 0, ((long)this.stack.get(arg15).key), this.bb.writePosition(), v12));
        }

        arg15 = this.align(v6);
        this.writeInt(v0, arg15);
        int v0_1 = this.bb.writePosition();
        while(arg14 < this.stack.size()) {
            this.stack.get(arg14);
            this.writeOffset(((long)this.stack.get(arg14).key), arg15);
            ++arg14;
        }

        return new Value(-1, FlexBuffers.toTypedVector(4, 0), v6, ((long)v0_1));
    }

    private Value createVector(int arg15, int arg16, int arg17, boolean arg18, boolean arg19, Value arg20) {
        int v14;
        int v8;
        int v6;
        int v0 = arg17;
        Value v1 = arg20;
        long v2 = ((long)v0);
        int v4 = Math.max(0, FlexBuffersBuilder.widthUInBits(v2));
        if(v1 != null) {
            v4 = Math.max(v4, Value.access$200(v1, this.bb.writePosition(), 0));
            v6 = 3;
        }
        else {
            v6 = 1;
        }

        int v7 = 4;
        int v11 = v4;
        for(v4 = arg16; v4 < this.stack.size(); ++v4) {
            v11 = Math.max(v11, Value.access$200(this.stack.get(v4), this.bb.writePosition(), v4 + v6));
            v8 = arg16;
            if((arg18) && v4 == v8) {
                v7 = this.stack.get(v4).type;
                if(FlexBuffers.isTypedVectorElementType(v7)) {
                }
                else {
                    throw new FlexBufferException("TypedVector does not support this element type");
                }
            }
        }

        v8 = arg16;
        v4 = this.align(v11);
        if(v1 != null) {
            this.writeOffset(v1.iValue, v4);
            this.writeInt(1 << v1.minBitWidth, v4);
        }

        if(!arg19) {
            this.writeInt(v2, v4);
        }

        int v2_1 = this.bb.writePosition();
        int v3;
        for(v3 = v8; v3 < this.stack.size(); ++v3) {
            this.writeAny(this.stack.get(v3), v4);
        }

        if(!arg18) {
            while(v8 < this.stack.size()) {
                this.bb.put(Value.access$400(this.stack.get(v8), v11));
                ++v8;
            }
        }

        if(v1 != null) {
            v14 = 9;
        }
        else if(arg18) {
            if(arg19) {
            }
            else {
                v0 = 0;
            }

            v14 = FlexBuffers.toTypedVector(v7, v0);
        }
        else {
            v14 = 10;
        }

        int v10 = v14;
        return new Value(arg15, v10, v11, ((long)v2_1));
    }

    public int endMap(String arg8, int arg9) {
        ArrayList v9;
        int v1 = this.putKey(arg8);
        Collections.sort(this.stack.subList(arg9, this.stack.size()), this.keyComparator);
        FlexBuffersBuilder v0 = this;
        int v2 = arg9;
        Value v7 = v0.createVector(v1, v2, this.stack.size() - arg9, false, false, this.createKeyVector(arg9, this.stack.size() - arg9));
        while(true) {
            int v8 = v0.stack.size();
            v9 = v0.stack;
            if(v8 <= v2) {
                break;
            }

            v9.remove(v9.size() - 1);
        }

        v9.add(v7);
        return ((int)v7.iValue);
    }

    public int endVector(String arg8, int arg9, boolean arg10, boolean arg11) {
        ArrayList v9;
        FlexBuffersBuilder v0 = this;
        int v2 = arg9;
        Value v7 = v0.createVector(this.putKey(arg8), v2, this.stack.size() - arg9, arg10, arg11, null);
        while(true) {
            int v8 = v0.stack.size();
            v9 = v0.stack;
            if(v8 <= v2) {
                break;
            }

            v9.remove(v9.size() - 1);
        }

        v9.add(v7);
        return ((int)v7.iValue);
    }

    public ByteBuffer finish() {
        int v0 = this.align(Value.access$200(this.stack.get(0), this.bb.writePosition(), 0));
        this.writeAny(this.stack.get(0), v0);
        this.bb.put(Value.access$300(this.stack.get(0)));
        this.bb.put(((byte)v0));
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(String arg3, byte[] arg4) {
        Value v3 = this.writeBlob(this.putKey(arg3), arg4, 25, false);
        this.stack.add(v3);
        return ((int)v3.iValue);
    }

    public int putBlob(byte[] arg2) {
        return this.putBlob(null, arg2);
    }

    public void putBoolean(String arg2, boolean arg3) {
        this.stack.add(Value.bool(this.putKey(arg2), arg3));
    }

    public void putBoolean(boolean arg2) {
        this.putBoolean(null, arg2);
    }

    public void putFloat(double arg2) {
        this.putFloat(null, arg2);
    }

    public void putFloat(String arg2, double arg3) {
        this.stack.add(Value.float64(this.putKey(arg2), arg3));
    }

    public void putFloat(float arg2) {
        this.putFloat(null, arg2);
    }

    public void putFloat(String arg2, float arg3) {
        this.stack.add(Value.float32(this.putKey(arg2), arg3));
    }

    public void putInt(int arg2) {
        this.putInt(null, arg2);
    }

    public void putInt(String arg3, int arg4) {
        this.putInt(arg3, ((long)arg4));
    }

    public void putInt(long arg2) {
        this.putInt(null, arg2);
    }

    public void putInt(String arg3, long arg4) {
        int v3 = this.putKey(arg3);
        if(-128 <= arg4 && arg4 <= 0x7F) {
            this.stack.add(Value.int8(v3, ((int)arg4)));
            return;
        }

        if(-32768 <= arg4 && arg4 <= 0x7FFF) {
            this.stack.add(Value.int16(v3, ((int)arg4)));
            return;
        }

        if(-2147483648 <= arg4 && arg4 <= 0x7FFFFFFF) {
            this.stack.add(Value.int32(v3, ((int)arg4)));
            return;
        }

        this.stack.add(Value.int64(v3, arg4));
    }

    private int putKey(String arg6) {
        byte[] v1_1;
        if(arg6 == null) {
            return -1;
        }

        int v0 = this.bb.writePosition();
        if((this.flags & 1) != 0) {
            Object v1 = this.keyPool.get(arg6);
            if(v1 == null) {
                v1_1 = arg6.getBytes(StandardCharsets.UTF_8);
                this.bb.put(v1_1, 0, v1_1.length);
                this.bb.put(0);
                this.keyPool.put(arg6, Integer.valueOf(v0));
                return v0;
            }

            return ((Integer)v1).intValue();
        }

        v1_1 = arg6.getBytes(StandardCharsets.UTF_8);
        this.bb.put(v1_1, 0, v1_1.length);
        this.bb.put(0);
        this.keyPool.put(arg6, Integer.valueOf(v0));
        return v0;
    }

    public int putString(String arg2) {
        return this.putString(null, arg2);
    }

    public int putString(String arg4, String arg5) {
        Value v4_1;
        int v4 = this.putKey(arg4);
        if((this.flags & 2) != 0) {
            Object v0 = this.stringPool.get(arg5);
            if(v0 == null) {
                v4_1 = this.writeString(v4, arg5);
                this.stringPool.put(arg5, Integer.valueOf(((int)v4_1.iValue)));
                this.stack.add(v4_1);
                return ((int)v4_1.iValue);
            }

            this.stack.add(Value.blob(v4, ((Integer)v0).intValue(), 5, FlexBuffersBuilder.widthUInBits(((long)arg5.length()))));
            return ((Integer)v0).intValue();
        }

        v4_1 = this.writeString(v4, arg5);
        this.stack.add(v4_1);
        return ((int)v4_1.iValue);
    }

    private void putUInt(String arg3, long arg4) {
        Value v3_1;
        int v3 = this.putKey(arg3);
        int v0 = FlexBuffersBuilder.widthUInBits(arg4);
        if(v0 == 0) {
            v3_1 = Value.uInt8(v3, ((int)arg4));
        }
        else if(v0 == 1) {
            v3_1 = Value.uInt16(v3, ((int)arg4));
        }
        else if(v0 == 2) {
            v3_1 = Value.uInt32(v3, ((int)arg4));
        }
        else {
            v3_1 = Value.uInt64(v3, arg4);
        }

        this.stack.add(v3_1);
    }

    public void putUInt(int arg4) {
        this.putUInt(null, ((long)arg4));
    }

    public void putUInt(long arg2) {
        this.putUInt(null, arg2);
    }

    private void putUInt64(String arg2, long arg3) {
        this.stack.add(Value.uInt64(this.putKey(arg2), arg3));
    }

    public void putUInt64(BigInteger arg4) {
        this.putUInt64(null, arg4.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    static int widthUInBits(long arg3) {
        byte v0 = -1;
        if(arg3 <= (((long)Unsigned.byteToUnsignedInt(v0)))) {
            return 0;
        }

        if(arg3 <= (((long)Unsigned.shortToUnsignedInt(((short)v0))))) {
            return 1;
        }

        if(arg3 <= Unsigned.intToUnsignedLong(v0)) {
            return 2;
        }

        return 3;
    }

    private void writeAny(Value arg3, int arg4) {
        int v0 = arg3.type;
        if(v0 != 0 && v0 != 1 && v0 != 2) {
            if(v0 == 3) {
                this.writeDouble(arg3.dValue, arg4);
                return;
            }
            else if(v0 != 26) {
                this.writeOffset(arg3.iValue, arg4);
                return;
            }
        }

        this.writeInt(arg3.iValue, arg4);
    }

    private Value writeBlob(int arg6, byte[] arg7, int arg8, boolean arg9) {
        int v0 = FlexBuffersBuilder.widthUInBits(((long)arg7.length));
        this.writeInt(((long)arg7.length), this.align(v0));
        int v1 = this.bb.writePosition();
        this.bb.put(arg7, 0, arg7.length);
        if(arg9) {
            this.bb.put(0);
        }

        return Value.blob(arg6, v1, arg8, v0);
    }

    private void writeDouble(double arg2, int arg4) {
        if(arg4 == 4) {
            this.bb.putFloat(((float)arg2));
            return;
        }

        if(arg4 == 8) {
            this.bb.putDouble(arg2);
        }
    }

    private void writeInt(long arg2, int arg4) {
        if(arg4 != 1) {
            if(arg4 != 2) {
                if(arg4 != 4) {
                    if(arg4 != 8) {
                        return;
                    }

                    this.bb.putLong(arg2);
                    return;
                }

                this.bb.putInt(((int)arg2));
                return;
            }

            this.bb.putShort(((short)(((int)arg2))));
            return;
        }

        this.bb.put(((byte)(((int)arg2))));
    }

    private void writeOffset(long arg3, int arg5) {
        this.writeInt(((long)(((int)((((long)this.bb.writePosition())) - arg3)))), arg5);
    }

    private Value writeString(int arg3, String arg4) {
        return this.writeBlob(arg3, arg4.getBytes(StandardCharsets.UTF_8), 5, true);
    }
}

