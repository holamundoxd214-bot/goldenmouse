package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8;
    private int vtable_size;
    private int vtable_start;

    public Table() {
        super();
        this.utf8 = Utf8.getDefault();
    }

    protected static boolean __has_identifier(ByteBuffer arg5, String arg6) {
        int v1 = 4;
        if(arg6.length() == v1) {
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                if(arg6.charAt(v2) != (((char)arg5.get(arg5.position() + v1 + v2)))) {
                    return 0;
                }
            }

            return 1;
        }

        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    protected static int __indirect(int arg0, ByteBuffer arg1) {
        return arg0 + arg1.getInt(arg0);
    }

    protected int __indirect(int arg1) {
        return arg1 + this.bb.getInt(arg1);
    }

    protected int __offset(int arg2) {
        if(arg2 < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + arg2);
        }

        return 0;
    }

    protected static int __offset(int arg1, int arg2, ByteBuffer arg3) {
        int v0 = arg3.capacity() - arg2;
        return arg3.getShort(arg1 + v0 - arg3.getInt(v0)) + v0;
    }

    protected void __reset(int arg1, ByteBuffer arg2) {
        this.bb = arg2;
        if(arg2 != null) {
            this.bb_pos = arg1;
            arg1 -= arg2.getInt(arg1);
            this.vtable_start = arg1;
            this.vtable_size = this.bb.getShort(arg1);
            return;
        }

        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public void __reset() {
        this.__reset(0, null);
    }

    protected static String __string(int arg1, ByteBuffer arg2, Utf8 arg3) {
        arg1 += arg2.getInt(arg1);
        return arg3.decodeUtf8(arg2, arg1 + 4, arg2.getInt(arg1));
    }

    protected String __string(int arg2) {
        return Table.__string(arg2, this.bb, this.utf8);
    }

    protected static Table __union(Table arg0, int arg1, ByteBuffer arg2) {
        arg0.__reset(Table.__indirect(arg1, arg2), arg2);
        return arg0;
    }

    protected Table __union(Table arg1, int arg2) {
        return Table.__union(arg1, arg2, this.bb);
    }

    protected int __vector(int arg2) {
        arg2 += this.bb_pos;
        return arg2 + this.bb.getInt(arg2) + 4;
    }

    protected ByteBuffer __vector_as_bytebuffer(int arg3, int arg4) {
        arg3 = this.__offset(arg3);
        if(arg3 == 0) {
            return null;
        }

        ByteBuffer v0 = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int v1 = this.__vector(arg3);
        v0.position(v1);
        v0.limit(v1 + this.__vector_len(arg3) * arg4);
        return v0;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer arg2, int arg3, int arg4) {
        arg3 = this.__offset(arg3);
        if(arg3 == 0) {
            return null;
        }

        int v0 = this.__vector(arg3);
        arg2.rewind();
        arg2.limit(this.__vector_len(arg3) * arg4 + v0);
        arg2.position(v0);
        return arg2;
    }

    protected int __vector_len(int arg2) {
        arg2 += this.bb_pos;
        return this.bb.getInt(arg2 + this.bb.getInt(arg2));
    }

    protected static int compareStrings(int arg8, int arg9, ByteBuffer arg10) {
        arg8 += arg10.getInt(arg8);
        arg9 += arg10.getInt(arg9);
        int v0 = arg10.getInt(arg8);
        int v1 = arg10.getInt(arg9);
        arg8 += 4;
        arg9 += 4;
        int v2 = Math.min(v0, v1);
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            int v4 = v3 + arg8;
            int v6 = v3 + arg9;
            if(arg10.get(v4) != arg10.get(v6)) {
                return arg10.get(v4) - arg10.get(v6);
            }
        }

        return v0 - v1;
    }

    protected static int compareStrings(int arg7, byte[] arg8, ByteBuffer arg9) {
        arg7 += arg9.getInt(arg7);
        int v0 = arg9.getInt(arg7);
        int v1 = arg8.length;
        arg7 += 4;
        int v2 = Math.min(v0, v1);
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            int v4 = v3 + arg7;
            if(arg9.get(v4) != arg8[v3]) {
                return arg9.get(v4) - arg8[v3];
            }
        }

        return v0 - v1;
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    protected int keysCompare(Integer arg1, Integer arg2, ByteBuffer arg3) {
        return 0;
    }

    protected void sortTables(int[] arg5, ByteBuffer arg6) {
        Integer[] v0 = new Integer[arg5.length];
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < arg5.length; ++v2) {
            v0[v2] = Integer.valueOf(arg5[v2]);
        }

        Arrays.sort(((Object[])v0), new Comparator(arg6) {
            public int compare(Integer arg2, Integer arg3) {
                return Table.this.keysCompare(arg2, arg3, this.val$bb);
            }

            public int compare(Object arg1, Object arg2) {
                return this.compare(((Integer)arg1), ((Integer)arg2));
            }
        });
        while(v1 < arg5.length) {
            arg5[v1] = v0[v1].intValue();
            ++v1;
        }
    }
}

