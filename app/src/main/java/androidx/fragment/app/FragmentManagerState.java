package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.ArrayList;

final class FragmentManagerState implements Parcelable {
    class androidx.fragment.app.FragmentManagerState$1 implements Parcelable$Creator {
        androidx.fragment.app.FragmentManagerState$1() {
            super();
        }

        public FragmentManagerState createFromParcel(Parcel arg1) {
            return new FragmentManagerState(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public FragmentManagerState[] newArray(int arg1) {
            return new FragmentManagerState[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    ArrayList mActive;
    ArrayList mAdded;
    BackStackState[] mBackStack;
    int mBackStackIndex;
    ArrayList mLaunchedFragments;
    String mPrimaryNavActiveWho;
    ArrayList mResultKeys;
    ArrayList mResults;

    static {
        FragmentManagerState.CREATOR = new androidx.fragment.app.FragmentManagerState$1();
    }

    public FragmentManagerState() {
        super();
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
    }

    public FragmentManagerState(Parcel arg2) {
        super();
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
        this.mActive = arg2.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = arg2.createStringArrayList();
        this.mBackStack = arg2.createTypedArray(BackStackState.CREATOR);
        this.mBackStackIndex = arg2.readInt();
        this.mPrimaryNavActiveWho = arg2.readString();
        this.mResultKeys = arg2.createStringArrayList();
        this.mResults = arg2.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = arg2.createTypedArrayList(LaunchedFragmentInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeTypedList(this.mActive);
        arg2.writeStringList(this.mAdded);
        arg2.writeTypedArray(this.mBackStack, arg3);
        arg2.writeInt(this.mBackStackIndex);
        arg2.writeString(this.mPrimaryNavActiveWho);
        arg2.writeStringList(this.mResultKeys);
        arg2.writeTypedList(this.mResults);
        arg2.writeTypedList(this.mLaunchedFragments);
    }
}

