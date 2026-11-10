package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray implements Parcelable {
    class com.google.android.material.internal.ParcelableSparseArray$1 implements Parcelable$ClassLoaderCreator {
        com.google.android.material.internal.ParcelableSparseArray$1() {
            super();
        }

        public ParcelableSparseArray createFromParcel(Parcel arg2) {
            return new ParcelableSparseArray(arg2, null);
        }

        public ParcelableSparseArray createFromParcel(Parcel arg1, ClassLoader arg2) {
            return new ParcelableSparseArray(arg1, arg2);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
            return this.createFromParcel(arg1, arg2);
        }

        public ParcelableSparseArray[] newArray(int arg1) {
            return new ParcelableSparseArray[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;

    static {
        ParcelableSparseArray.CREATOR = new com.google.android.material.internal.ParcelableSparseArray$1();
    }

    public ParcelableSparseArray() {
        super();
    }

    public ParcelableSparseArray(Parcel arg5, ClassLoader arg6) {
        super();
        int v0 = arg5.readInt();
        int[] v1 = new int[v0];
        arg5.readIntArray(v1);
        Parcelable[] v5 = arg5.readParcelableArray(arg6);
        int v6;
        for(v6 = 0; v6 < v0; ++v6) {
            this.put(v1[v6], v5[v6]);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg6, int arg7) {
        int v0 = this.size();
        int[] v1 = new int[v0];
        Parcelable[] v2 = new Parcelable[v0];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = this.keyAt(v3);
            v2[v3] = this.valueAt(v3);
        }

        arg6.writeInt(v0);
        arg6.writeIntArray(v1);
        arg6.writeParcelableArray(v2, arg7);
    }
}

