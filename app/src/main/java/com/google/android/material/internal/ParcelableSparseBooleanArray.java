package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    class com.google.android.material.internal.ParcelableSparseBooleanArray$1 implements Parcelable$Creator {
        com.google.android.material.internal.ParcelableSparseBooleanArray$1() {
            super();
        }

        public ParcelableSparseBooleanArray createFromParcel(Parcel arg6) {
            int v5 = arg6.readInt();
            ParcelableSparseBooleanArray v0 = new ParcelableSparseBooleanArray(v5);
            int[] v1 = new int[v5];
            boolean[] v2 = new boolean[v5];
            arg6.readIntArray(v1);
            arg6.readBooleanArray(v2);
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                v0.put(v1[v6], v2[v6]);
            }

            return v0;
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public ParcelableSparseBooleanArray[] newArray(int arg1) {
            return new ParcelableSparseBooleanArray[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;

    static {
        ParcelableSparseBooleanArray.CREATOR = new com.google.android.material.internal.ParcelableSparseBooleanArray$1();
    }

    public ParcelableSparseBooleanArray() {
        super();
    }

    public ParcelableSparseBooleanArray(int arg1) {
        super(arg1);
    }

    public ParcelableSparseBooleanArray(SparseBooleanArray arg4) {
        super(arg4.size());
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
        boolean[] v0 = new boolean[this.size()];
        int v1;
        for(v1 = 0; v1 < this.size(); ++v1) {
            v5[v1] = this.keyAt(v1);
            v0[v1] = this.valueAt(v1);
        }

        arg4.writeInt(this.size());
        arg4.writeIntArray(v5);
        arg4.writeBooleanArray(v0);
    }
}

