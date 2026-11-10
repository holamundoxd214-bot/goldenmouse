package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    class com.google.android.material.stateful.ExtendableSavedState$1 implements Parcelable$ClassLoaderCreator {
        com.google.android.material.stateful.ExtendableSavedState$1() {
            super();
        }

        public ExtendableSavedState createFromParcel(Parcel arg2) {
            return new ExtendableSavedState(arg2, null, null);
        }

        public ExtendableSavedState createFromParcel(Parcel arg2, ClassLoader arg3) {
            return new ExtendableSavedState(arg2, arg3, null);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
            return this.createFromParcel(arg1, arg2);
        }

        public ExtendableSavedState[] newArray(int arg1) {
            return new ExtendableSavedState[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    public final SimpleArrayMap extendableStates;

    static {
        ExtendableSavedState.CREATOR = new com.google.android.material.stateful.ExtendableSavedState$1();
    }

    public ExtendableSavedState(Parcelable arg1) {
        super(arg1);
        this.extendableStates = new SimpleArrayMap();
    }

    private ExtendableSavedState(Parcel arg6, ClassLoader arg7) {
        super(arg6, arg7);
        int v7 = arg6.readInt();
        String[] v0 = new String[v7];
        arg6.readStringArray(v0);
        Bundle[] v1 = new Bundle[v7];
        arg6.readTypedArray(((Object[])v1), Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(v7);
        int v6;
        for(v6 = 0; v6 < v7; ++v6) {
            this.extendableStates.put(v0[v6], v1[v6]);
        }
    }

    ExtendableSavedState(Parcel arg1, ClassLoader arg2, com.google.android.material.stateful.ExtendableSavedState$1 arg3) {
        this(arg1, arg2);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    public void writeToParcel(Parcel arg6, int arg7) {
        super.writeToParcel(arg6, arg7);
        arg7 = this.extendableStates.size();
        arg6.writeInt(arg7);
        String[] v0 = new String[arg7];
        Bundle[] v1 = new Bundle[arg7];
        int v3;
        for(v3 = 0; v3 < arg7; ++v3) {
            v0[v3] = this.extendableStates.keyAt(v3);
            v1[v3] = this.extendableStates.valueAt(v3);
        }

        arg6.writeStringArray(v0);
        arg6.writeTypedArray(((Parcelable[])v1), 0);
    }
}

