package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle$State;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    class androidx.fragment.app.BackStackState$1 implements Parcelable$Creator {
        androidx.fragment.app.BackStackState$1() {
            super();
        }

        public BackStackState createFromParcel(Parcel arg1) {
            return new BackStackState(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public BackStackState[] newArray(int arg1) {
            return new BackStackState[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR = null;
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList mSharedElementSourceNames;
    final ArrayList mSharedElementTargetNames;
    final int mTransition;

    static {
        BackStackState.CREATOR = new androidx.fragment.app.BackStackState$1();
    }

    public BackStackState(Parcel arg2) {
        super();
        this.mOps = arg2.createIntArray();
        this.mFragmentWhos = arg2.createStringArrayList();
        this.mOldMaxLifecycleStates = arg2.createIntArray();
        this.mCurrentMaxLifecycleStates = arg2.createIntArray();
        this.mTransition = arg2.readInt();
        this.mName = arg2.readString();
        this.mIndex = arg2.readInt();
        this.mBreadCrumbTitleRes = arg2.readInt();
        this.mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.mBreadCrumbShortTitleRes = arg2.readInt();
        this.mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(arg2);
        this.mSharedElementSourceNames = arg2.createStringArrayList();
        this.mSharedElementTargetNames = arg2.createStringArrayList();
        boolean v2 = arg2.readInt() != 0 ? true : false;
        this.mReorderingAllowed = v2;
    }

    public BackStackState(BackStackRecord arg9) {
        Object v6_1;
        super();
        int v0 = arg9.mOps.size();
        this.mOps = new int[v0 * 5];
        if(arg9.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList(v0);
            this.mOldMaxLifecycleStates = new int[v0];
            this.mCurrentMaxLifecycleStates = new int[v0];
            int v1 = 0;
            int v2 = 0;
            while(v1 < v0) {
                Object v3 = arg9.mOps.get(v1);
                int v5 = v2 + 1;
                this.mOps[v2] = ((Op)v3).mCmd;
                ArrayList v4 = this.mFragmentWhos;
                if(((Op)v3).mFragment != null) {
                    String v6 = ((Op)v3).mFragment.mWho;
                }
                else {
                    v6_1 = null;
                }

                v4.add(v6_1);
                this.mOps[v5] = ((Op)v3).mEnterAnim;
                this.mOps[v2 + 2] = ((Op)v3).mExitAnim;
                int v6_2 = v2 + 4;
                this.mOps[v2 + 3] = ((Op)v3).mPopEnterAnim;
                v2 += 5;
                this.mOps[v6_2] = ((Op)v3).mPopExitAnim;
                this.mOldMaxLifecycleStates[v1] = ((Op)v3).mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[v1] = ((Op)v3).mCurrentMaxState.ordinal();
                ++v1;
            }

            this.mTransition = arg9.mTransition;
            this.mName = arg9.mName;
            this.mIndex = arg9.mIndex;
            this.mBreadCrumbTitleRes = arg9.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = arg9.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = arg9.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = arg9.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = arg9.mSharedElementSourceNames;
            this.mSharedElementTargetNames = arg9.mSharedElementTargetNames;
            this.mReorderingAllowed = arg9.mReorderingAllowed;
            return;
        }

        throw new IllegalStateException("Not on back stack");
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager arg8) {
        BackStackRecord v0 = new BackStackRecord(arg8);
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < this.mOps.length; ++v2) {
            Op v3 = new Op();
            int v5 = v1 + 1;
            v3.mCmd = this.mOps[v1];
            if(FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Instantiate " + v0 + " op #" + v2 + " base fragment #" + this.mOps[v5]);
            }

            Object v4 = this.mFragmentWhos.get(v2);
            v3.mFragment = v4 != null ? arg8.findActiveFragment(((String)v4)) : null;
            v3.mOldMaxState = State.values()[this.mOldMaxLifecycleStates[v2]];
            v3.mCurrentMaxState = State.values()[this.mCurrentMaxLifecycleStates[v2]];
            v3.mEnterAnim = this.mOps[v5];
            v3.mExitAnim = this.mOps[v1 + 2];
            int v6 = v1 + 4;
            v3.mPopEnterAnim = this.mOps[v1 + 3];
            v1 += 5;
            v3.mPopExitAnim = this.mOps[v6];
            v0.mEnterAnim = v3.mEnterAnim;
            v0.mExitAnim = v3.mExitAnim;
            v0.mPopEnterAnim = v3.mPopEnterAnim;
            v0.mPopExitAnim = v3.mPopExitAnim;
            v0.addOp(v3);
        }

        v0.mTransition = this.mTransition;
        v0.mName = this.mName;
        v0.mIndex = this.mIndex;
        v0.mAddToBackStack = true;
        v0.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        v0.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        v0.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        v0.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        v0.mSharedElementSourceNames = this.mSharedElementSourceNames;
        v0.mSharedElementTargetNames = this.mSharedElementTargetNames;
        v0.mReorderingAllowed = this.mReorderingAllowed;
        v0.bumpBackStackNesting(1);
        return v0;
    }

    public void writeToParcel(Parcel arg2, int arg3) {
        arg2.writeIntArray(this.mOps);
        arg2.writeStringList(this.mFragmentWhos);
        arg2.writeIntArray(this.mOldMaxLifecycleStates);
        arg2.writeIntArray(this.mCurrentMaxLifecycleStates);
        arg2.writeInt(this.mTransition);
        arg2.writeString(this.mName);
        arg2.writeInt(this.mIndex);
        arg2.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, arg2, 0);
        arg2.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, arg2, 0);
        arg2.writeStringList(this.mSharedElementSourceNames);
        arg2.writeStringList(this.mSharedElementTargetNames);
        arg2.writeInt(this.mReorderingAllowed);
    }
}

