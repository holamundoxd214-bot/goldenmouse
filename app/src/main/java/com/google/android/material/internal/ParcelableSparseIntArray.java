package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    class com.google.android.material.internal.ParcelableSparseIntArray$1 implements Parcelable$Creator {
        com.google.android.material.internal.ParcelableSparseIntArray$1() {
            super();
        }

        public ParcelableSparseIntArray createFromParcel(Parcel arg6) {
            int v5 = arg6.readInt();
            ParcelableSparseIntArray v0 = new ParcelableSparseIntArray(v5);
            int[] v1 = new int[v5];
            int[] v2 = new int[v5];
            arg6.readIntArray(v1);
            arg6.readIntArray(v2);
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                v0.put(v1[v6], v2[v6]);
            }

            return v0;
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public ParcelableSparseIntArray[] newArray(int arg1) {
            return new ParcelableSparseIntArray[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;

    static {
        ParcelableSparseIntArray.CREATOR = new com.google.android.material.internal.ParcelableSparseIntArray$1();
    }

    public ParcelableSparseIntArray() {
        super();
    }

    public ParcelableSparseIntArray(int arg1) {
        super(arg1);
    }

    public ParcelableSparseIntArray(SparseIntArray arg4) {
        super();
        int v0;
        for(v0 = 0; v0 < arg4.size(); ++v0) {
            this.put(arg4.keyAt(v0), arg4.valueAt(v0));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg4, int arg5) {
        int[] v5 = new int[this.size()];
        int[] v0 = new int[this.size()];
        int v1;
        for(v1 = 0; v1 < this.size(); ++v1) {
            v5[v1] = this.keyAt(v1);
            v0[v1] = this.valueAt(v1);
        }

        arg4.writeInt(this.size());
        arg4.writeIntArray(v5);
        arg4.writeIntArray(v0);
    }
}

