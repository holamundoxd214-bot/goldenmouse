package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {
    class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer arg1) {
            super();
            this.buf = arg1;
        }

        public int read() throws IOException {
            try {
                return this.buf.get() & 0xFF;
            }
            catch(BufferUnderflowException ) {
                return -1;
            }
        }
    }

    public abstract class ByteBufferFactory {
        public ByteBufferFactory() {
            super();
        }

        public abstract ByteBuffer newByteBuffer(int arg1);

        public void releaseByteBuffer(ByteBuffer arg1) {
        }
    }

    public final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE;

        static {
            HeapByteBufferFactory.INSTANCE = new HeapByteBufferFactory();
        }

        public HeapByteBufferFactory() {
            super();
        }

        public ByteBuffer newByteBuffer(int arg1) {
            return ByteBuffer.allocate(arg1).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    static {
    }

    public FlatBufferBuilder() {
        this(0x400);
    }

    public FlatBufferBuilder(int arg4) {
        this(arg4, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int arg4, ByteBufferFactory arg5, ByteBuffer arg6, Utf8 arg7) {
        super();
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        this.bb_factory = arg5;
        if(arg6 != null) {
            this.bb = arg6;
            arg6.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        }
        else {
            this.bb = arg5.newByteBuffer(1);
        }

        this.utf8 = arg7;
        this.space = this.bb.capacity();
    }

    public FlatBufferBuilder(int arg3, ByteBufferFactory arg4) {
        this(arg3, arg4, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer arg2) {
        this(arg2, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer arg3, ByteBufferFactory arg4) {
        this(arg3.capacity(), arg4, arg3, Utf8.getDefault());
    }

    public void Nested(int arg1) {
        if(arg1 == this.offset()) {
            return;
        }

        throw new AssertionError("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(int arg2, boolean arg3, boolean arg4) {
        if(!this.force_defaults) {
            if(arg3 != arg4) {
            }
            else {
                return;
            }
        }

        this.addBoolean(arg3);
        this.slot(arg2);
    }

    public void addBoolean(boolean arg3) {
        this.prep(1, 0);
        this.putBoolean(arg3);
    }

    public void addByte(byte arg3) {
        this.prep(1, 0);
        this.putByte(arg3);
    }

    public void addByte(int arg2, byte arg3, int arg4) {
        if(!this.force_defaults) {
            if(arg3 != arg4) {
            }
            else {
                return;
            }
        }

        this.addByte(arg3);
        this.slot(arg2);
    }

    public void addDouble(double arg3) {
        this.prep(8, 0);
        this.putDouble(arg3);
    }

    public void addDouble(int arg2, double arg3, double arg5) {
        if(!this.force_defaults) {
            if(arg3 != arg5) {
            }
            else {
                return;
            }
        }

        this.addDouble(arg3);
        this.slot(arg2);
    }

    public void addFloat(float arg3) {
        this.prep(4, 0);
        this.putFloat(arg3);
    }

    public void addFloat(int arg3, float arg4, double arg5) {
        if(!this.force_defaults) {
            if((((double)arg4)) != arg5) {
            }
            else {
                return;
            }
        }

        this.addFloat(arg4);
        this.slot(arg3);
    }

    public void addInt(int arg3) {
        this.prep(4, 0);
        this.putInt(arg3);
    }

    public void addInt(int arg2, int arg3, int arg4) {
        if(!this.force_defaults) {
            if(arg3 != arg4) {
            }
            else {
                return;
            }
        }

        this.addInt(arg3);
        this.slot(arg2);
    }

    public void addLong(int arg2, long arg3, long arg5) {
        if(!this.force_defaults) {
            if(arg3 != arg5) {
            }
            else {
                return;
            }
        }

        this.addLong(arg3);
        this.slot(arg2);
    }

    public void addLong(long arg3) {
        this.prep(8, 0);
        this.putLong(arg3);
    }

    public void addOffset(int arg3) {
        this.prep(4, 0);
        this.putInt(this.offset() - arg3 + 4);
    }

    public void addOffset(int arg2, int arg3, int arg4) {
        if(!this.force_defaults) {
            if(arg3 != arg4) {
            }
            else {
                return;
            }
        }

        this.addOffset(arg3);
        this.slot(arg2);
    }

    public void addShort(int arg2, short arg3, int arg4) {
        if(!this.force_defaults) {
            if(arg3 != arg4) {
            }
            else {
                return;
            }
        }

        this.addShort(arg3);
        this.slot(arg2);
    }

    public void addShort(short arg3) {
        this.prep(2, 0);
        this.putShort(arg3);
    }

    public void addStruct(int arg1, int arg2, int arg3) {
        if(arg2 != arg3) {
            this.Nested(arg2);
            this.slot(arg1);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while(true) {
            int v0 = this.vtable_in_use;
            if(v0 <= 0) {
                break;
            }

            int[] v2 = this.vtable;
            --v0;
            this.vtable_in_use = v0;
            v2[v0] = 0;
        }

        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int createByteVector(ByteBuffer arg4) {
        int v0 = arg4.remaining();
        this.startVector(1, v0, 1);
        ByteBuffer v1 = this.bb;
        int v2 = this.space - v0;
        this.space = v2;
        v1.position(v2);
        this.bb.put(arg4);
        return this.endVector();
    }

    public int createByteVector(byte[] arg4) {
        int v0 = arg4.length;
        this.startVector(1, v0, 1);
        ByteBuffer v1 = this.bb;
        int v2 = this.space - v0;
        this.space = v2;
        v1.position(v2);
        this.bb.put(arg4);
        return this.endVector();
    }

    public int createByteVector(byte[] arg3, int arg4, int arg5) {
        this.startVector(1, arg5, 1);
        ByteBuffer v0 = this.bb;
        int v1 = this.space - arg5;
        this.space = v1;
        v0.position(v1);
        this.bb.put(arg3, arg4, arg5);
        return this.endVector();
    }

    public int createSortedVectorOfTables(Table arg2, int[] arg3) {
        arg2.sortTables(arg3, this.bb);
        return this.createVectorOfTables(arg3);
    }

    public int createString(CharSequence arg4) {
        int v0 = this.utf8.encodedLength(arg4);
        this.addByte(0);
        this.startVector(1, v0, 1);
        ByteBuffer v1 = this.bb;
        int v2 = this.space - v0;
        this.space = v2;
        v1.position(v2);
        this.utf8.encodeUtf8(arg4, this.bb);
        return this.endVector();
    }

    public int createString(ByteBuffer arg4) {
        int v0 = arg4.remaining();
        this.addByte(0);
        this.startVector(1, v0, 1);
        ByteBuffer v1 = this.bb;
        int v2 = this.space - v0;
        this.space = v2;
        v1.position(v2);
        this.bb.put(arg4);
        return this.endVector();
    }

    public ByteBuffer createUnintializedVector(int arg2, int arg3, int arg4) {
        int v0 = arg2 * arg3;
        this.startVector(arg2, arg3, arg4);
        ByteBuffer v2 = this.bb;
        arg3 = this.space - v0;
        this.space = arg3;
        v2.position(arg3);
        ByteBuffer v1 = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        v1.limit(v0);
        return v1;
    }

    public int createVectorOfTables(int[] arg3) {
        this.notNested();
        this.startVector(4, arg3.length, 4);
        int v0;
        for(v0 = arg3.length - 1; v0 >= 0; --v0) {
            this.addOffset(arg3[v0]);
        }

        return this.endVector();
    }

    public ByteBuffer dataBuffer() {
        this.finished();
        return this.bb;
    }

    @Deprecated private int dataStart() {
        this.finished();
        return this.space;
    }

    public int endTable() {
        int v4;
        if(this.vtable != null && (this.nested)) {
            this.addInt(0);
            int v1 = this.offset();
            int v2;
            for(v2 = this.vtable_in_use - 1; v2 >= 0; --v2) {
                if(this.vtable[v2] != 0) {
                    break;
                }
            }

            int v3;
            for(v3 = v2; v3 >= 0; --v3) {
                v4 = this.vtable[v3];
                v4 = v4 != 0 ? v1 - v4 : 0;
                this.addShort(((short)v4));
            }

            this.addShort(((short)(v1 - this.object_start)));
            v3 = 2;
            this.addShort(((short)((v2 + 3) * v3)));
            for(v2 = 0; v2 < this.num_vtables; ++v2) {
                v4 = this.bb.capacity() - this.vtables[v2];
                int v5 = this.space;
                int v6 = this.bb.getShort(v4);
                if(v6 == this.bb.getShort(v5)) {
                    int v7 = v3;
                    while(true) {
                        if(v7 >= v6) {
                            break;
                        }
                        else if(this.bb.getShort(v4 + v7) != this.bb.getShort(v5 + v7)) {
                        }
                        else {
                            v7 += 2;
                            continue;
                        }

                        goto label_65;
                    }

                    v2 = this.vtables[v2];
                    goto label_68;
                }

            label_65:
            }

            v2 = 0;
        label_68:
            if(v2 != 0) {
                v3 = this.bb.capacity() - v1;
                this.space = v3;
                this.bb.putInt(v3, v2 - v1);
            }
            else {
                v2 = this.num_vtables;
                int[] v4_1 = this.vtables;
                if(v2 == v4_1.length) {
                    v4_1 = Arrays.copyOf(v4_1, v2 * v3);
                    this.vtables = v4_1;
                }

                v2 = this.num_vtables;
                this.num_vtables = v2 + 1;
                v4_1[v2] = this.offset();
                this.bb.putInt(this.bb.capacity() - v1, this.offset() - v1);
            }

            this.nested = false;
            return v1;
        }

        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if(this.nested) {
            this.nested = false;
            this.putInt(this.vector_num_elems);
            return this.offset();
        }

        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int arg2) {
        this.finish(arg2, false);
    }

    protected void finish(int arg4, boolean arg5) {
        int v0 = this.minalign;
        int v1 = 4;
        int v2 = arg5 ? v1 : 0;
        this.prep(v0, v2 + v1);
        this.addOffset(arg4);
        if(arg5) {
            this.addInt(this.bb.capacity() - this.space);
        }

        this.bb.position(this.space);
        this.finished = true;
    }

    public void finish(int arg2, String arg3) {
        this.finish(arg2, arg3, false);
    }

    protected void finish(int arg4, String arg5, boolean arg6) {
        int v0 = this.minalign;
        int v1 = 4;
        int v2 = arg6 ? v1 : 0;
        this.prep(v0, v2 + 8);
        if(arg5.length() == v1) {
            for(v0 = 3; v0 >= 0; --v0) {
                this.addByte(((byte)arg5.charAt(v0)));
            }

            this.finish(arg4, arg6);
            return;
        }

        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public void finishSizePrefixed(int arg2) {
        this.finish(arg2, true);
    }

    public void finishSizePrefixed(int arg2, String arg3) {
        this.finish(arg2, arg3, true);
    }

    public void finished() {
        if(this.finished) {
            return;
        }

        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean arg1) {
        this.force_defaults = arg1;
        return this;
    }

    static ByteBuffer growByteBuffer(ByteBuffer arg3, ByteBufferFactory arg4) {
        int v0 = arg3.capacity();
        if((0xC0000000 & v0) == 0) {
            int v1 = v0 == 0 ? 1 : v0 << 1;
            arg3.position(0);
            ByteBuffer v4 = arg4.newByteBuffer(v1);
            v4.position(v4.clear().capacity() - v0);
            v4.put(arg3);
            return v4;
        }

        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public FlatBufferBuilder init(ByteBuffer arg1, ByteBufferFactory arg2) {
        this.bb_factory = arg2;
        this.bb = arg1;
        arg1.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public static boolean isFieldPresent(Table arg0, int arg1) {
        if(arg0.__offset(arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public void notNested() {
        if(!this.nested) {
            return;
        }

        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int arg5) {
        int v1;
        for(v1 = 0; v1 < arg5; ++v1) {
            ByteBuffer v2 = this.bb;
            int v3 = this.space - 1;
            this.space = v3;
            v2.put(v3, 0);
        }
    }

    public void prep(int arg5, int arg6) {
        if(arg5 > this.minalign) {
            this.minalign = arg5;
        }

        int v0 = ~(this.bb.capacity() - this.space + arg6) + 1 & arg5 - 1;
        while(this.space < v0 + arg5 + arg6) {
            int v1 = this.bb.capacity();
            ByteBuffer v2 = this.bb;
            ByteBuffer v3 = FlatBufferBuilder.growByteBuffer(v2, this.bb_factory);
            this.bb = v3;
            if(v2 != v3) {
                this.bb_factory.releaseByteBuffer(v2);
            }

            this.space += this.bb.capacity() - v1;
        }

        this.pad(v0);
    }

    public void putBoolean(boolean arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 1;
        this.space = v1;
        v0.put(v1, ((byte)(((int)arg3))));
    }

    public void putByte(byte arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 1;
        this.space = v1;
        v0.put(v1, arg3);
    }

    public void putDouble(double arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 8;
        this.space = v1;
        v0.putDouble(v1, arg3);
    }

    public void putFloat(float arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 4;
        this.space = v1;
        v0.putFloat(v1, arg3);
    }

    public void putInt(int arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 4;
        this.space = v1;
        v0.putInt(v1, arg3);
    }

    public void putLong(long arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 8;
        this.space = v1;
        v0.putLong(v1, arg3);
    }

    public void putShort(short arg3) {
        ByteBuffer v0 = this.bb;
        int v1 = this.space - 2;
        this.space = v1;
        v0.putShort(v1, arg3);
    }

    public void required(int arg2, int arg3) {
        int v0 = this.bb.capacity() - arg2;
        if(this.bb.getShort(v0 - this.bb.getInt(v0) + arg3) != 0) {
            return;
        }

        throw new AssertionError("FlatBuffers: field " + arg3 + " must be set");
    }

    public byte[] sizedByteArray() {
        return this.sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public byte[] sizedByteArray(int arg2, int arg3) {
        this.finished();
        byte[] v3 = new byte[arg3];
        this.bb.position(arg2);
        this.bb.get(v3);
        return v3;
    }

    public InputStream sizedInputStream() {
        this.finished();
        ByteBuffer v0 = this.bb.duplicate();
        v0.position(this.space);
        v0.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(v0);
    }

    public void slot(int arg2) {
        this.vtable[arg2] = this.offset();
    }

    public void startTable(int arg3) {
        this.notNested();
        int[] v0 = this.vtable;
        if(v0 == null || v0.length < arg3) {
            v0 = new int[arg3];
            this.vtable = v0;
        }

        this.vtable_in_use = arg3;
        Arrays.fill(v0, 0, arg3, 0);
        this.nested = true;
        this.object_start = this.offset();
    }

    public void startVector(int arg1, int arg2, int arg3) {
        this.notNested();
        this.vector_num_elems = arg2;
        arg1 *= arg2;
        this.prep(4, arg1);
        this.prep(arg3, arg1);
        this.nested = true;
    }
}

