package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentState implements Parcelable {
    class androidx.fragment.app.FragmentState$1 implements Parcelable$Creator {
        androidx.fragment.app.FragmentState$1() {
            super();
        }

        public FragmentState createFromParcel(Parcel arg1) {
            return new FragmentState(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public FragmentState[] newArray(int arg1) {
            return new FragmentState[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;
    final String mWho;

    static {
        FragmentState.CREATOR = new androidx.fragment.app.FragmentState$1();
    }

    FragmentState(Parcel arg4) {
        super();
        this.mClassName = arg4.readString();
        this.mWho = arg4.readString();
        boolean v1 = true;
        boolean v0 = arg4.readInt() != 0 ? true : false;
        this.mFromLayout = v0;
        this.mFragmentId = arg4.readInt();
        this.mContainerId = arg4.readInt();
        this.mTag = arg4.readString();
        v0 = arg4.readInt() != 0 ? true : false;
        this.mRetainInstance = v0;
        v0 = arg4.readInt() != 0 ? true : false;
        this.mRemoving = v0;
        v0 = arg4.readInt() != 0 ? true : false;
        this.mDetached = v0;
        this.mArguments = arg4.readBundle();
        if(arg4.readInt() != 0) {
        }
        else {
            v1 = false;
        }

        this.mHidden = v1;
        this.mSavedFragmentState = arg4.readBundle();
        this.mMaxLifecycleState = arg4.readInt();
    }

    FragmentState(Fragment arg2) {
        super();
        this.mClassName = arg2.getClass().getName();
        this.mWho = arg2.mWho;
        this.mFromLayout = arg2.mFromLayout;
        this.mFragmentId = arg2.mFragmentId;
        this.mContainerId = arg2.mContainerId;
        this.mTag = arg2.mTag;
        this.mRetainInstance = arg2.mRetainInstance;
        this.mRemoving = arg2.mRemoving;
        this.mDetached = arg2.mDetached;
        this.mArguments = arg2.mArguments;
        this.mHidden = arg2.mHidden;
        this.mMaxLifecycleState = arg2.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("FragmentState{");
        v0.append(this.mClassName);
        v0.append(" (");
        v0.append(this.mWho);
        v0.append(")}:");
        if(this.mFromLayout) {
            v0.append(" fromLayout");
        }

        if(this.mContainerId != 0) {
            v0.append(" id=0x");
            v0.append(Integer.toHexString(this.mContainerId));
        }

        String v1 = this.mTag;
        if(v1 != null && !v1.isEmpty()) {
            v0.append(" tag=");
            v0.append(this.mTag);
        }

        if(this.mRetainInstance) {
            v0.append(" retainInstance");
        }

        if(this.mRemoving) {
            v0.append(" removing");
        }

        if(this.mDetached) {
            v0.append(" detached");
        }

        if(this.mHidden) {
            v0.append(" hidden");
        }

        return v0.toString();
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeString(this.mClassName);
        arg1.writeString(this.mWho);
        arg1.writeInt(this.mFromLayout);
        arg1.writeInt(this.mFragmentId);
        arg1.writeInt(this.mContainerId);
        arg1.writeString(this.mTag);
        arg1.writeInt(this.mRetainInstance);
        arg1.writeInt(this.mRemoving);
        arg1.writeInt(this.mDetached);
        arg1.writeBundle(this.mArguments);
        arg1.writeInt(this.mHidden);
        arg1.writeBundle(this.mSavedFragmentState);
        arg1.writeInt(this.mMaxLifecycleState);
    }
}

