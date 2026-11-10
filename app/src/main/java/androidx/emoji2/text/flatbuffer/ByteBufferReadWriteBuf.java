package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer arg1) {
        super();
        this.buffer = arg1;
        arg1.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte[] data() {
        return this.buffer.array();
    }

    public byte get(int arg1) {
        return this.buffer.get(arg1);
    }

    public boolean getBoolean(int arg1) {
        if(this.get(arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public double getDouble(int arg1) {
        return this.buffer.getDouble(arg1);
    }

    public float getFloat(int arg1) {
        return this.buffer.getFloat(arg1);
    }

    public int getInt(int arg1) {
        return this.buffer.getInt(arg1);
    }

    public long getLong(int arg1) {
        return this.buffer.getLong(arg1);
    }

    public short getShort(int arg1) {
        return this.buffer.getShort(arg1);
    }

    public String getString(int arg1, int arg2) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, arg1, arg2);
    }

    public int limit() {
        return this.buffer.limit();
    }

    public void put(byte arg1) {
        this.buffer.put(arg1);
    }

    public void put(byte[] arg1, int arg2, int arg3) {
        this.buffer.put(arg1, arg2, arg3);
    }

    public void putBoolean(boolean arg1) {
        this.buffer.put(((byte)arg1));
    }

    public void putDouble(double arg1) {
        this.buffer.putDouble(arg1);
    }

    public void putFloat(float arg1) {
        this.buffer.putFloat(arg1);
    }

    public void putInt(int arg1) {
        this.buffer.putInt(arg1);
    }

    public void putLong(long arg1) {
        this.buffer.putLong(arg1);
    }

    public void putShort(short arg1) {
        this.buffer.putShort(arg1);
    }

    public boolean requestCapacity(int arg1) {
        if(arg1 <= this.buffer.limit()) {
            return 1;
        }

        return 0;
    }

    public void set(int arg2, byte arg3) {
        this.requestCapacity(arg2 + 1);
        this.buffer.put(arg2, arg3);
    }

    public void set(int arg3, byte[] arg4, int arg5, int arg6) {
        this.requestCapacity(arg6 - arg5 + arg3);
        int v0 = this.buffer.position();
        this.buffer.position(arg3);
        this.buffer.put(arg4, arg5, arg6);
        this.buffer.position(v0);
    }

    public void setBoolean(int arg1, boolean arg2) {
        this.set(arg1, ((byte)arg2));
    }

    public void setDouble(int arg2, double arg3) {
        this.requestCapacity(arg2 + 8);
        this.buffer.putDouble(arg2, arg3);
    }

    public void setFloat(int arg2, float arg3) {
        this.requestCapacity(arg2 + 4);
        this.buffer.putFloat(arg2, arg3);
    }

    public void setInt(int arg2, int arg3) {
        this.requestCapacity(arg2 + 4);
        this.buffer.putInt(arg2, arg3);
    }

    public void setLong(int arg2, long arg3) {
        this.requestCapacity(arg2 + 8);
        this.buffer.putLong(arg2, arg3);
    }

    public void setShort(int arg2, short arg3) {
        this.requestCapacity(arg2 + 2);
        this.buffer.putShort(arg2, arg3);
    }

    public int writePosition() {
        return this.buffer.position();
    }
}

