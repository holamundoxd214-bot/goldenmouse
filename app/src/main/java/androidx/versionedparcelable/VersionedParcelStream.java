package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

class VersionedParcelStream extends VersionedParcel {
    class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        FieldBuffer(int arg3, DataOutputStream arg4) {
            super();
            ByteArrayOutputStream v0 = new ByteArrayOutputStream();
            this.mOutput = v0;
            this.mDataStream = new DataOutputStream(((OutputStream)v0));
            this.mFieldId = arg3;
            this.mTarget = arg4;
        }

        void flushField() throws IOException {
            this.mDataStream.flush();
            int v0 = this.mOutput.size();
            int v1 = this.mFieldId << 16;
            int v2 = 0xFFFF;
            int v3 = v0 >= v2 ? v2 : v0;
            this.mTarget.writeInt(v1 | v3);
            if(v0 >= v2) {
                this.mTarget.writeInt(v0);
            }

            this.mOutput.writeTo(this.mTarget);
        }
    }

    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16;
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    static {
        VersionedParcelStream.UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream arg7, OutputStream arg8) {
        this(arg7, arg8, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelStream(InputStream arg1, OutputStream arg2, ArrayMap arg3, ArrayMap arg4, ArrayMap arg5) {
        super(arg3, arg4, arg5);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream v3 = null;
        DataInputStream v4 = arg1 != null ? new DataInputStream(new FilterInputStream(arg1) {
            public int read() throws IOException {
                if(VersionedParcelStream.this.mFieldSize != -1) {
                    if(VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
                    }
                    else {
                        throw new IOException();
                    }
                }

                int v0 = super.read();
                ++VersionedParcelStream.this.mCount;
                return v0;
            }

            public int read(byte[] arg3, int arg4, int arg5) throws IOException {
                if(VersionedParcelStream.this.mFieldSize != -1) {
                    if(VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
                    }
                    else {
                        throw new IOException();
                    }
                }

                int v3 = super.read(arg3, arg4, arg5);
                if(v3 > 0) {
                    VersionedParcelStream.this.mCount += v3;
                }

                return v3;
            }

            public long skip(long arg3) throws IOException {
                if(VersionedParcelStream.this.mFieldSize != -1) {
                    if(VersionedParcelStream.this.mCount < VersionedParcelStream.this.mFieldSize) {
                    }
                    else {
                        throw new IOException();
                    }
                }

                arg3 = super.skip(arg3);
                if(arg3 > 0) {
                    VersionedParcelStream.this.mCount += ((int)arg3);
                }

                return arg3;
            }
        }) : ((DataInputStream)v3);
        this.mMasterInput = v4;
        if(arg2 != null) {
            v3 = new DataOutputStream(arg2);
        }

        this.mMasterOutput = v3;
        this.mCurrentInput = v4;
        this.mCurrentOutput = v3;
    }

    public void closeField() {
        FieldBuffer v0 = this.mFieldBuffer;
        if(v0 != null) {
            try {
                if(v0.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
            }
            catch(IOException v1) {
                throw new ParcelException(((Throwable)v1));
            }

            this.mFieldBuffer = null;
            return;
        }
    }

    protected VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean isStream() {
        return 1;
    }

    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        }
        catch(IOException v1) {
            throw new ParcelException(((Throwable)v1));
        }
    }

    public Bundle readBundle() {
        int v0 = this.readInt();
        if(v0 < 0) {
            return null;
        }

        Bundle v1 = new Bundle();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            this.readObject(this.readInt(), this.readString(), v1);
        }

        return v1;
    }

    public byte[] readByteArray() {
        try {
            int v0 = this.mCurrentInput.readInt();
            if(v0 <= 0) {
                return null;
            }

            byte[] v0_1 = new byte[v0];
            this.mCurrentInput.readFully(v0_1);
            return v0_1;
        }
        catch(IOException v1) {
            throw new ParcelException(((Throwable)v1));
        }

        return null;
    }

    protected CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        }
        catch(IOException v2) {
            throw new ParcelException(((Throwable)v2));
        }
    }

    public boolean readField(int arg5) {
        try {
            while(true) {
                int v1 = this.mFieldId;
                if(v1 == arg5) {
                    return 1;
                }

                if(String.valueOf(v1).compareTo(String.valueOf(arg5)) > 0) {
                    return 0;
                }

                v1 = this.mCount;
                int v2 = this.mFieldSize;
                if(v1 < v2) {
                    this.mMasterInput.skip(((long)(v2 - v1)));
                }

                this.mFieldSize = -1;
                v1 = this.mMasterInput.readInt();
                this.mCount = 0;
                v2 = 0xFFFF;
                int v3 = v1 & v2;
                if(v3 == v2) {
                    v3 = this.mMasterInput.readInt();
                }

                this.mFieldId = v1 >> 16 & v2;
                this.mFieldSize = v3;
            }
        }
        catch(IOException ) {
            return 0;
        }
    }

    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        }
        catch(IOException v1) {
            throw new ParcelException(((Throwable)v1));
        }
    }

    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        }
        catch(IOException v1) {
            throw new ParcelException(((Throwable)v1));
        }
    }

    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        }
        catch(IOException v2) {
            throw new ParcelException(((Throwable)v2));
        }
    }

    private void readObject(int arg1, String arg2, Bundle arg3) {
        switch(arg1) {
            case 0: {
                goto label_53;
            }
            case 1: {
                goto label_50;
            }
            case 2: {
                goto label_47;
            }
            case 3: {
                goto label_44;
            }
            case 4: {
                goto label_39;
            }
            case 5: {
                goto label_36;
            }
            case 6: {
                goto label_33;
            }
            case 7: {
                goto label_30;
            }
            case 8: {
                goto label_27;
            }
            case 9: {
                goto label_24;
            }
            case 10: {
                goto label_21;
            }
            case 11: {
                goto label_18;
            }
            case 12: {
                goto label_15;
            }
            case 13: {
                goto label_12;
            }
            case 14: {
                goto label_9;
            }
        }

        throw new RuntimeException("Unknown type " + arg1);
    label_33:
        arg3.putBooleanArray(arg2, this.readBooleanArray());
        return;
    label_36:
        arg3.putBoolean(arg2, this.readBoolean());
        return;
    label_39:
        arg3.putStringArray(arg2, this.readArray(new String[0]));
        return;
    label_9:
        arg3.putFloatArray(arg2, this.readFloatArray());
        return;
    label_44:
        arg3.putString(arg2, this.readString());
        return;
    label_12:
        arg3.putFloat(arg2, this.readFloat());
        return;
    label_47:
        arg3.putBundle(arg2, this.readBundle());
        return;
    label_15:
        arg3.putLongArray(arg2, this.readLongArray());
        return;
    label_50:
        arg3.putBundle(arg2, this.readBundle());
        return;
    label_18:
        arg3.putLong(arg2, this.readLong());
        return;
    label_53:
        arg3.putParcelable(arg2, null);
        return;
    label_21:
        arg3.putIntArray(arg2, this.readIntArray());
        return;
    label_24:
        arg3.putInt(arg2, this.readInt());
        return;
    label_27:
        arg3.putDoubleArray(arg2, this.readDoubleArray());
        return;
    label_30:
        arg3.putDouble(arg2, this.readDouble());
    }

    public Parcelable readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int v0 = this.mCurrentInput.readInt();
            if(v0 <= 0) {
                return null;
            }

            byte[] v0_1 = new byte[v0];
            this.mCurrentInput.readFully(v0_1);
            return new String(v0_1, VersionedParcelStream.UTF_16);
        }
        catch(IOException v2) {
            throw new ParcelException(((Throwable)v2));
        }

        return null;
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int arg3) {
        this.closeField();
        FieldBuffer v0 = new FieldBuffer(arg3, this.mMasterOutput);
        this.mFieldBuffer = v0;
        this.mCurrentOutput = v0.mDataStream;
    }

    public void setSerializationFlags(boolean arg1, boolean arg2) {
        if(arg1) {
            this.mIgnoreParcelables = arg2;
            return;
        }

        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void writeBoolean(boolean arg1) {
        try {
            this.mCurrentOutput.writeBoolean(arg1);
            return;
        }
        catch(IOException v0) {
            throw new ParcelException(((Throwable)v0));
        }
    }

    public void writeBundle(Bundle arg4) {
        if(arg4 == null) {
            goto label_14;
        }

        try {
            Set v0 = arg4.keySet();
            this.mCurrentOutput.writeInt(v0.size());
            Iterator v0_1 = v0.iterator();
            while(v0_1.hasNext()) {
                Object v1 = v0_1.next();
                this.writeString(((String)v1));
                this.writeObject(arg4.get(((String)v1)));
            }

            return;
        label_14:
            this.mCurrentOutput.writeInt(-1);
            return;
        }
        catch(IOException v3) {
            throw new ParcelException(((Throwable)v3));
        }
    }

    public void writeByteArray(byte[] arg3) {
        DataOutputStream v0 = this.mCurrentOutput;
        if(arg3 == null) {
            goto label_7;
        }

        try {
            v0.writeInt(arg3.length);
            this.mCurrentOutput.write(arg3);
            return;
        label_7:
            v0.writeInt(-1);
            return;
        }
        catch(IOException v2) {
            throw new ParcelException(((Throwable)v2));
        }
    }

    public void writeByteArray(byte[] arg2, int arg3, int arg4) {
        DataOutputStream v0 = this.mCurrentOutput;
        if(arg2 == null) {
            goto label_6;
        }

        try {
            v0.writeInt(arg4);
            this.mCurrentOutput.write(arg2, arg3, arg4);
            return;
        label_6:
            v0.writeInt(-1);
            return;
        }
        catch(IOException v1) {
            throw new ParcelException(((Throwable)v1));
        }
    }

    protected void writeCharSequence(CharSequence arg1) {
        if(this.mIgnoreParcelables) {
            return;
        }

        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    public void writeDouble(double arg1) {
        try {
            this.mCurrentOutput.writeDouble(arg1);
            return;
        }
        catch(IOException v0) {
            throw new ParcelException(((Throwable)v0));
        }
    }

    public void writeFloat(float arg1) {
        try {
            this.mCurrentOutput.writeFloat(arg1);
            return;
        }
        catch(IOException v0) {
            throw new ParcelException(((Throwable)v0));
        }
    }

    public void writeInt(int arg1) {
        try {
            this.mCurrentOutput.writeInt(arg1);
            return;
        }
        catch(IOException v0) {
            throw new ParcelException(((Throwable)v0));
        }
    }

    public void writeLong(long arg1) {
        try {
            this.mCurrentOutput.writeLong(arg1);
            return;
        }
        catch(IOException v0) {
            throw new ParcelException(((Throwable)v0));
        }
    }

    private void writeObject(Object arg3) {
        if(arg3 == null) {
            this.writeInt(0);
            return;
        }

        if((arg3 instanceof Bundle)) {
            this.writeInt(1);
            this.writeBundle(((Bundle)arg3));
            return;
        }

        if((arg3 instanceof String)) {
            this.writeInt(3);
            this.writeString(((String)arg3));
            return;
        }

        if((arg3 instanceof String[])) {
            this.writeInt(4);
            this.writeArray(((Object[])arg3));
            return;
        }

        if((arg3 instanceof Boolean)) {
            this.writeInt(5);
            this.writeBoolean(((Boolean)arg3).booleanValue());
            return;
        }

        if((arg3 instanceof boolean[])) {
            this.writeInt(6);
            this.writeBooleanArray(((boolean[])arg3));
            return;
        }

        if((arg3 instanceof Double)) {
            this.writeInt(7);
            this.writeDouble(((Double)arg3).doubleValue());
            return;
        }

        if((arg3 instanceof double[])) {
            this.writeInt(8);
            this.writeDoubleArray(((double[])arg3));
            return;
        }

        if((arg3 instanceof Integer)) {
            this.writeInt(9);
            this.writeInt(((Integer)arg3).intValue());
            return;
        }

        if((arg3 instanceof int[])) {
            this.writeInt(10);
            this.writeIntArray(((int[])arg3));
            return;
        }

        if((arg3 instanceof Long)) {
            this.writeInt(11);
            this.writeLong(((Long)arg3).longValue());
            return;
        }

        if((arg3 instanceof long[])) {
            this.writeInt(12);
            this.writeLongArray(((long[])arg3));
            return;
        }

        if((arg3 instanceof Float)) {
            this.writeInt(13);
            this.writeFloat(((Float)arg3).floatValue());
            return;
        }

        if((arg3 instanceof float[])) {
            this.writeInt(14);
            this.writeFloatArray(((float[])arg3));
            return;
        }

        throw new IllegalArgumentException("Unsupported type " + arg3.getClass());
    }

    public void writeParcelable(Parcelable arg1) {
        if(this.mIgnoreParcelables) {
            return;
        }

        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    public void writeString(String arg3) {
        if(arg3 == null) {
            goto label_9;
        }

        try {
            byte[] v3 = arg3.getBytes(VersionedParcelStream.UTF_16);
            this.mCurrentOutput.writeInt(v3.length);
            this.mCurrentOutput.write(v3);
            return;
        label_9:
            this.mCurrentOutput.writeInt(-1);
            return;
        }
        catch(IOException v2) {
            throw new ParcelException(((Throwable)v2));
        }
    }

    public void writeStrongBinder(IBinder arg1) {
        if(this.mIgnoreParcelables) {
            return;
        }

        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    public void writeStrongInterface(IInterface arg1) {
        if(this.mIgnoreParcelables) {
            return;
        }

        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
}

