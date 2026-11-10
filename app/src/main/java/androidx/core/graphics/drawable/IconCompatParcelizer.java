package androidx.core.graphics.drawable;

import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public IconCompatParcelizer() {
        super();
    }

    public static IconCompat read(VersionedParcel arg3) {
        IconCompat v0 = new IconCompat();
        v0.mType = arg3.readInt(v0.mType, 1);
        v0.mData = arg3.readByteArray(v0.mData, 2);
        v0.mParcelable = arg3.readParcelable(v0.mParcelable, 3);
        v0.mInt1 = arg3.readInt(v0.mInt1, 4);
        v0.mInt2 = arg3.readInt(v0.mInt2, 5);
        v0.mTintList = arg3.readParcelable(v0.mTintList, 6);
        v0.mTintModeStr = arg3.readString(v0.mTintModeStr, 7);
        v0.mString1 = arg3.readString(v0.mString1, 8);
        v0.onPostParceling();
        return v0;
    }

    public static void write(IconCompat arg3, VersionedParcel arg4) {
        arg4.setSerializationFlags(true, true);
        arg3.onPreParceling(arg4.isStream());
        if(-1 != arg3.mType) {
            arg4.writeInt(arg3.mType, 1);
        }

        if(arg3.mData != null) {
            arg4.writeByteArray(arg3.mData, 2);
        }

        if(arg3.mParcelable != null) {
            arg4.writeParcelable(arg3.mParcelable, 3);
        }

        if(arg3.mInt1 != 0) {
            arg4.writeInt(arg3.mInt1, 4);
        }

        if(arg3.mInt2 != 0) {
            arg4.writeInt(arg3.mInt2, 5);
        }

        if(arg3.mTintList != null) {
            arg4.writeParcelable(arg3.mTintList, 6);
        }

        if(arg3.mTintModeStr != null) {
            arg4.writeString(arg3.mTintModeStr, 7);
        }

        if(arg3.mString1 != null) {
            arg4.writeString(arg3.mString1, 8);
        }
    }
}

