package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;

class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    VersionedParcelParcel(Parcel arg9) {
        this(arg9, arg9.dataPosition(), arg9.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelParcel(Parcel arg1, int arg2, int arg3, String arg4, ArrayMap arg5, ArrayMap arg6, ArrayMap arg7) {
        super(arg5, arg6, arg7);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = arg1;
        this.mOffset = arg2;
        this.mEnd = arg3;
        this.mNextRead = arg2;
        this.mPrefix = arg4;
    }

    public void closeField() {
        int v0 = this.mCurrentField;
        if(v0 >= 0) {
            v0 = this.mPositionLookup.get(v0);
            int v1 = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(v0);
            this.mParcel.writeInt(v1 - v0);
            this.mParcel.setDataPosition(v1);
        }
    }

    protected VersionedParcel createSubParcel() {
        Parcel v1 = this.mParcel;
        int v2 = v1.dataPosition();
        int v3 = this.mNextRead;
        if(v3 == this.mOffset) {
            v3 = this.mEnd;
        }

        return new VersionedParcelParcel(v1, v2, v3, this.mPrefix + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean readBoolean() {
        if(this.mParcel.readInt() != 0) {
            return 1;
        }

        return 0;
    }

    public Bundle readBundle() {
        return this.mParcel.readBundle(this.getClass().getClassLoader());
    }

    public byte[] readByteArray() {
        int v0 = this.mParcel.readInt();
        if(v0 < 0) {
            return null;
        }

        byte[] v0_1 = new byte[v0];
        this.mParcel.readByteArray(v0_1);
        return v0_1;
    }

    protected CharSequence readCharSequence() {
        return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public boolean readField(int arg6) {
        while(true) {
            int v0 = this.mNextRead;
            int v1 = this.mEnd;
            int v2 = this.mFieldId;
            if(v0 >= v1) {
                break;
            }

            if(v2 == arg6) {
                return 1;
            }

            if(String.valueOf(v2).compareTo(String.valueOf(arg6)) > 0) {
                return 0;
            }

            this.mParcel.setDataPosition(this.mNextRead);
            v0 = this.mParcel.readInt();
            this.mFieldId = this.mParcel.readInt();
            this.mNextRead += v0;
        }

        if(v2 == arg6) {
            return 1;
        }

        return 0;
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public Parcelable readParcelable() {
        return this.mParcel.readParcelable(this.getClass().getClassLoader());
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public void setOutputField(int arg3) {
        this.closeField();
        this.mCurrentField = arg3;
        this.mPositionLookup.put(arg3, this.mParcel.dataPosition());
        this.writeInt(0);
        this.writeInt(arg3);
    }

    public void writeBoolean(boolean arg1) {
        this.mParcel.writeInt(((int)arg1));
    }

    public void writeBundle(Bundle arg1) {
        this.mParcel.writeBundle(arg1);
    }

    public void writeByteArray(byte[] arg3) {
        Parcel v0 = this.mParcel;
        if(arg3 != null) {
            v0.writeInt(arg3.length);
            this.mParcel.writeByteArray(arg3);
            return;
        }

        v0.writeInt(-1);
    }

    public void writeByteArray(byte[] arg3, int arg4, int arg5) {
        Parcel v0 = this.mParcel;
        if(arg3 != null) {
            v0.writeInt(arg3.length);
            this.mParcel.writeByteArray(arg3, arg4, arg5);
            return;
        }

        v0.writeInt(-1);
    }

    protected void writeCharSequence(CharSequence arg2) {
        TextUtils.writeToParcel(arg2, this.mParcel, 0);
    }

    public void writeDouble(double arg1) {
        this.mParcel.writeDouble(arg1);
    }

    public void writeFloat(float arg1) {
        this.mParcel.writeFloat(arg1);
    }

    public void writeInt(int arg1) {
        this.mParcel.writeInt(arg1);
    }

    public void writeLong(long arg1) {
        this.mParcel.writeLong(arg1);
    }

    public void writeParcelable(Parcelable arg2) {
        this.mParcel.writeParcelable(arg2, 0);
    }

    public void writeString(String arg1) {
        this.mParcel.writeString(arg1);
    }

    public void writeStrongBinder(IBinder arg1) {
        this.mParcel.writeStrongBinder(arg1);
    }

    public void writeStrongInterface(IInterface arg1) {
        this.mParcel.writeStrongInterface(arg1);
    }
}

