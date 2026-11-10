package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int arg1) {
        this(new byte[arg1]);
    }

    public ArrayReadWriteBuf(byte[] arg1) {
        super();
        this.buffer = arg1;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] arg1, int arg2) {
        super();
        this.buffer = arg1;
        this.writePos = arg2;
    }

    public byte[] data() {
        return this.buffer;
    }

    public byte get(int arg1) {
        return this.buffer[arg1];
    }

    public boolean getBoolean(int arg1) {
        if(this.buffer[arg1] != 0) {
            return 1;
        }

        return 0;
    }

    public double getDouble(int arg1) {
        return Double.longBitsToDouble(this.getLong(arg1));
    }

    public float getFloat(int arg1) {
        return Float.intBitsToFloat(this.getInt(arg1));
    }

    public int getInt(int arg3) {
        return this.buffer[arg3] & 0xFF | (this.buffer[arg3 + 3] << 24 | (this.buffer[arg3 + 2] & 0xFF) << 16 | (this.buffer[arg3 + 1] & 0xFF) << 8);
    }

    public long getLong(int arg9) {
        return (((long)this.buffer[arg9 + 7])) << 56 | ((((long)this.buffer[arg9])) & 0xFF | ((((long)this.buffer[arg9 + 1])) & 0xFF) << 8 | ((((long)this.buffer[arg9 + 2])) & 0xFF) << 16 | ((((long)this.buffer[arg9 + 3])) & 0xFF) << 24 | ((((long)this.buffer[arg9 + 4])) & 0xFF) << 0x20 | ((((long)this.buffer[arg9 + 5])) & 0xFF) << 40 | ((((long)this.buffer[arg9 + 6])) & 0xFF) << 0x30);
    }

    public short getShort(int arg2) {
        return ((short)(this.buffer[arg2] & 0xFF | this.buffer[arg2 + 1] << 8));
    }

    public String getString(int arg1, int arg2) {
        return Utf8Safe.decodeUtf8Array(this.buffer, arg1, arg2);
    }

    public int limit() {
        return this.writePos;
    }

    public void put(byte arg2) {
        this.set(this.writePos, arg2);
        ++this.writePos;
    }

    public void put(byte[] arg2, int arg3, int arg4) {
        this.set(this.writePos, arg2, arg3, arg4);
        this.writePos += arg4;
    }

    public void putBoolean(boolean arg2) {
        this.setBoolean(this.writePos, arg2);
        ++this.writePos;
    }

    public void putDouble(double arg2) {
        this.setDouble(this.writePos, arg2);
        this.writePos += 8;
    }

    public void putFloat(float arg2) {
        this.setFloat(this.writePos, arg2);
        this.writePos += 4;
    }

    public void putInt(int arg2) {
        this.setInt(this.writePos, arg2);
        this.writePos += 4;
    }

    public void putLong(long arg2) {
        this.setLong(this.writePos, arg2);
        this.writePos += 8;
    }

    public void putShort(short arg2) {
        this.setShort(this.writePos, arg2);
        this.writePos += 2;
    }

    public boolean requestCapacity(int arg4) {
        byte[] v0 = this.buffer;
        if(v0.length > arg4) {
            return 1;
        }

        this.buffer = Arrays.copyOf(v0, v0.length + (v0.length >> 1));
        return 1;
    }

    public void set(int arg2, byte arg3) {
        this.requestCapacity(arg2 + 1);
        this.buffer[arg2] = arg3;
    }

    public void set(int arg2, byte[] arg3, int arg4, int arg5) {
        this.requestCapacity(arg5 - arg4 + arg2);
        System.arraycopy(arg3, arg4, this.buffer, arg2, arg5);
    }

    public void setBoolean(int arg1, boolean arg2) {
        this.set(arg1, ((byte)arg2));
    }

    public void setDouble(int arg5, double arg6) {
        this.requestCapacity(arg5 + 8);
        long v6 = Double.doubleToRawLongBits(arg6);
        int v0 = ((int)v6);
        byte[] v4 = this.buffer;
        v4[arg5] = ((byte)(v0 & 0xFF));
        v4[arg5 + 1] = ((byte)(v0 >> 8 & 0xFF));
        v4[arg5 + 2] = ((byte)(v0 >> 16 & 0xFF));
        v4[arg5 + 3] = ((byte)(v0 >> 24 & 0xFF));
        int v6_1 = ((int)(v6 >> 0x20));
        v4[arg5 + 4] = ((byte)(v6_1 & 0xFF));
        v4[arg5 + 5] = ((byte)(v6_1 >> 8 & 0xFF));
        v4[arg5 + 6] = ((byte)(v6_1 >> 16 & 0xFF));
        v4[arg5 + 7] = ((byte)(v6_1 >> 24 & 0xFF));
    }

    public void setFloat(int arg4, float arg5) {
        this.requestCapacity(arg4 + 4);
        int v5 = Float.floatToRawIntBits(arg5);
        byte[] v3 = this.buffer;
        v3[arg4] = ((byte)(v5 & 0xFF));
        v3[arg4 + 1] = ((byte)(v5 >> 8 & 0xFF));
        v3[arg4 + 2] = ((byte)(v5 >> 16 & 0xFF));
        v3[arg4 + 3] = ((byte)(v5 >> 24 & 0xFF));
    }

    public void setInt(int arg4, int arg5) {
        this.requestCapacity(arg4 + 4);
        byte[] v3 = this.buffer;
        v3[arg4] = ((byte)(arg5 & 0xFF));
        v3[arg4 + 1] = ((byte)(arg5 >> 8 & 0xFF));
        v3[arg4 + 2] = ((byte)(arg5 >> 16 & 0xFF));
        v3[arg4 + 3] = ((byte)(arg5 >> 24 & 0xFF));
    }

    public void setLong(int arg5, long arg6) {
        this.requestCapacity(arg5 + 8);
        int v0 = ((int)arg6);
        byte[] v4 = this.buffer;
        v4[arg5] = ((byte)(v0 & 0xFF));
        v4[arg5 + 1] = ((byte)(v0 >> 8 & 0xFF));
        v4[arg5 + 2] = ((byte)(v0 >> 16 & 0xFF));
        v4[arg5 + 3] = ((byte)(v0 >> 24 & 0xFF));
        int v6 = ((int)(arg6 >> 0x20));
        v4[arg5 + 4] = ((byte)(v6 & 0xFF));
        v4[arg5 + 5] = ((byte)(v6 >> 8 & 0xFF));
        v4[arg5 + 6] = ((byte)(v6 >> 16 & 0xFF));
        v4[arg5 + 7] = ((byte)(v6 >> 24 & 0xFF));
    }

    public void setShort(int arg3, short arg4) {
        this.requestCapacity(arg3 + 2);
        byte[] v2 = this.buffer;
        v2[arg3] = ((byte)(arg4 & 0xFF));
        v2[arg3 + 1] = ((byte)(arg4 >> 8 & 0xFF));
    }

    public int writePosition() {
        return this.writePos;
    }
}

