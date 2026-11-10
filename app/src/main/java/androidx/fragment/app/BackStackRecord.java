package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.Lifecycle$State;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    BackStackRecord(FragmentManager arg3) {
        FragmentFactory v0 = arg3.getFragmentFactory();
        ClassLoader v1 = arg3.getHost() != null ? arg3.getHost().getContext().getClassLoader() : null;
        super(v0, v1);
        this.mIndex = -1;
        this.mManager = arg3;
    }

    void bumpBackStackNesting(int arg8) {
        if(!this.mAddToBackStack) {
        }
        else {
            int v0 = 2;
            String v2 = "FragmentManager";
            if(FragmentManager.isLoggingEnabled(v0)) {
                Log.v(v2, "Bump nesting in " + this + " by " + arg8);
            }

            int v1 = this.mOps.size();
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Object v4 = this.mOps.get(v3);
                if(((Op)v4).mFragment != null) {
                    ((Op)v4).mFragment.mBackStackNesting += arg8;
                    if(FragmentManager.isLoggingEnabled(v0)) {
                        Log.v(v2, "Bump nesting of " + ((Op)v4).mFragment + " to " + ((Op)v4).mFragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int commit() {
        return this.commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }

    int commitInternal(boolean arg3) {
        if(!this.mCommitted) {
            if(FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter v1 = new PrintWriter(new LogWriter("FragmentManager"));
                this.dump("  ", v1);
                v1.close();
            }

            this.mCommitted = true;
            this.mIndex = this.mAddToBackStack ? this.mManager.allocBackStackIndex() : -1;
            this.mManager.enqueueAction(((OpGenerator)this), arg3);
            return this.mIndex;
        }

        throw new IllegalStateException("commit already called");
    }

    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(((OpGenerator)this), false);
    }

    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(((OpGenerator)this), true);
    }

    public FragmentTransaction detach(Fragment arg3) {
        if(arg3.mFragmentManager != null) {
            if(arg3.mFragmentManager == this.mManager) {
            }
            else {
                throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + arg3.toString() + " is already attached to a FragmentManager.");
            }
        }

        return super.detach(arg3);
    }

    void doAddOp(int arg1, Fragment arg2, String arg3, int arg4) {
        super.doAddOp(arg1, arg2, arg3, arg4);
        arg2.mFragmentManager = this.mManager;
    }

    public void dump(String arg2, PrintWriter arg3) {
        this.dump(arg2, arg3, true);
    }

    public void dump(String arg6, PrintWriter arg7, boolean arg8) {
        String v3;
        if(arg8) {
            arg7.print(arg6);
            arg7.print("mName=");
            arg7.print(this.mName);
            arg7.print(" mIndex=");
            arg7.print(this.mIndex);
            arg7.print(" mCommitted=");
            arg7.println(this.mCommitted);
            if(this.mTransition != 0) {
                arg7.print(arg6);
                arg7.print("mTransition=#");
                arg7.print(Integer.toHexString(this.mTransition));
            }

            if(this.mEnterAnim != 0 || this.mExitAnim != 0) {
                arg7.print(arg6);
                arg7.print("mEnterAnim=#");
                arg7.print(Integer.toHexString(this.mEnterAnim));
                arg7.print(" mExitAnim=#");
                arg7.println(Integer.toHexString(this.mExitAnim));
            }

            if(this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                arg7.print(arg6);
                arg7.print("mPopEnterAnim=#");
                arg7.print(Integer.toHexString(this.mPopEnterAnim));
                arg7.print(" mPopExitAnim=#");
                arg7.println(Integer.toHexString(this.mPopExitAnim));
            }

            if(this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                arg7.print(arg6);
                arg7.print("mBreadCrumbTitleRes=#");
                arg7.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                arg7.print(" mBreadCrumbTitleText=");
                arg7.println(this.mBreadCrumbTitleText);
            }

            if(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null) {
                goto label_80;
            }

            arg7.print(arg6);
            arg7.print("mBreadCrumbShortTitleRes=#");
            arg7.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
            arg7.print(" mBreadCrumbShortTitleText=");
            arg7.println(this.mBreadCrumbShortTitleText);
        }

    label_80:
        if(!this.mOps.isEmpty()) {
            arg7.print(arg6);
            arg7.println("Operations:");
            int v0 = this.mOps.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = this.mOps.get(v1);
                switch(((Op)v2).mCmd) {
                    case 0: {
                        v3 = "NULL";
                        break;
                    }
                    case 1: {
                        v3 = "ADD";
                        break;
                    }
                    case 2: {
                        v3 = "REPLACE";
                        break;
                    }
                    case 3: {
                        v3 = "REMOVE";
                        break;
                    }
                    case 4: {
                        v3 = "HIDE";
                        break;
                    }
                    case 5: {
                        v3 = "SHOW";
                        break;
                    }
                    case 6: {
                        v3 = "DETACH";
                        break;
                    }
                    case 7: {
                        v3 = "ATTACH";
                        break;
                    }
                    case 8: {
                        v3 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 9: {
                        v3 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 10: {
                        v3 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    default: {
                        v3 = "cmd=" + ((Op)v2).mCmd;
                        break;
                    }
                }

                arg7.print(arg6);
                arg7.print("  Op #");
                arg7.print(v1);
                arg7.print(": ");
                arg7.print(v3);
                arg7.print(" ");
                arg7.println(((Op)v2).mFragment);
                if(arg8) {
                    if(((Op)v2).mEnterAnim != 0 || ((Op)v2).mExitAnim != 0) {
                        arg7.print(arg6);
                        arg7.print("enterAnim=#");
                        arg7.print(Integer.toHexString(((Op)v2).mEnterAnim));
                        arg7.print(" exitAnim=#");
                        arg7.println(Integer.toHexString(((Op)v2).mExitAnim));
                    }

                    if(((Op)v2).mPopEnterAnim == 0 && ((Op)v2).mPopExitAnim == 0) {
                        goto label_164;
                    }

                    arg7.print(arg6);
                    arg7.print("popEnterAnim=#");
                    arg7.print(Integer.toHexString(((Op)v2).mPopEnterAnim));
                    arg7.print(" popExitAnim=#");
                    arg7.println(Integer.toHexString(((Op)v2).mPopExitAnim));
                }

            label_164:
            }
        }
    }

    void executeOps() {
        int v0 = this.mOps.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v4 = this.mOps.get(v2);
            Fragment v5 = ((Op)v4).mFragment;
            if(v5 != null) {
                v5.setPopDirection(false);
                v5.setNextTransition(this.mTransition);
                v5.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }

            switch(((Op)v4).mCmd) {
                case 1: {
                    goto label_82;
                }
                case 3: {
                    goto label_74;
                }
                case 4: {
                    goto label_66;
                }
                case 5: {
                    goto label_56;
                }
                case 6: {
                    goto label_48;
                }
                case 7: {
                    goto label_38;
                }
                case 8: {
                    goto label_35;
                }
                case 9: {
                    goto label_31;
                }
                case 10: {
                    goto label_27;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((Op)v4).mCmd);
        label_82:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v5, false);
            this.mManager.addFragment(v5);
            goto label_91;
        label_66:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.hideFragment(v5);
            goto label_91;
        label_35:
            this.mManager.setPrimaryNavigationFragment(v5);
            goto label_91;
        label_38:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v5, false);
            this.mManager.attachFragment(v5);
            goto label_91;
        label_56:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v5, false);
            this.mManager.showFragment(v5);
            goto label_91;
        label_74:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.removeFragment(v5);
            goto label_91;
        label_27:
            this.mManager.setMaxLifecycle(v5, ((Op)v4).mCurrentMaxState);
            goto label_91;
        label_31:
            this.mManager.setPrimaryNavigationFragment(null);
            goto label_91;
        label_48:
            v5.setAnimations(((Op)v4).mEnterAnim, ((Op)v4).mExitAnim, ((Op)v4).mPopEnterAnim, ((Op)v4).mPopExitAnim);
            this.mManager.detachFragment(v5);
        label_91:
            if(!this.mReorderingAllowed && ((Op)v4).mCmd != 1 && v5 != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(v5);
            }
        }

        if(!this.mReorderingAllowed && !FragmentManager.USE_STATE_MANAGER) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    void executePopOps(boolean arg9) {
        int v0;
        for(v0 = this.mOps.size() - 1; v0 >= 0; --v0) {
            Object v2 = this.mOps.get(v0);
            Fragment v3 = ((Op)v2).mFragment;
            if(v3 != null) {
                v3.setPopDirection(true);
                v3.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                v3.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }

            switch(((Op)v2).mCmd) {
                case 1: {
                    goto label_82;
                }
                case 3: {
                    goto label_74;
                }
                case 4: {
                    goto label_66;
                }
                case 5: {
                    goto label_56;
                }
                case 6: {
                    goto label_48;
                }
                case 7: {
                    goto label_38;
                }
                case 8: {
                    goto label_34;
                }
                case 9: {
                    goto label_31;
                }
                case 10: {
                    goto label_27;
                }
            }

            throw new IllegalArgumentException("Unknown cmd: " + ((Op)v2).mCmd);
        label_82:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v3, true);
            this.mManager.removeFragment(v3);
            goto label_91;
        label_66:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.showFragment(v3);
            goto label_91;
        label_34:
            this.mManager.setPrimaryNavigationFragment(null);
            goto label_91;
        label_38:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v3, true);
            this.mManager.detachFragment(v3);
            goto label_91;
        label_56:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.setExitAnimationOrder(v3, true);
            this.mManager.hideFragment(v3);
            goto label_91;
        label_74:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.addFragment(v3);
            goto label_91;
        label_27:
            this.mManager.setMaxLifecycle(v3, ((Op)v2).mOldMaxState);
            goto label_91;
        label_31:
            this.mManager.setPrimaryNavigationFragment(v3);
            goto label_91;
        label_48:
            v3.setAnimations(((Op)v2).mEnterAnim, ((Op)v2).mExitAnim, ((Op)v2).mPopEnterAnim, ((Op)v2).mPopExitAnim);
            this.mManager.attachFragment(v3);
        label_91:
            if(!this.mReorderingAllowed && ((Op)v2).mCmd != 3 && v3 != null && !FragmentManager.USE_STATE_MANAGER) {
                this.mManager.moveFragmentToExpectedState(v3);
            }
        }

        if(!this.mReorderingAllowed && (arg9) && !FragmentManager.USE_STATE_MANAGER) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }

    Fragment expandOps(ArrayList arg17, Fragment arg18) {
        BackStackRecord v0 = this;
        ArrayList v1 = arg17;
        Fragment v3 = arg18;
        int v4;
        for(v4 = 0; v4 < v0.mOps.size(); ++v4) {
            Object v5 = v0.mOps.get(v4);
            int v6 = ((Op)v5).mCmd;
            if(v6 != 1) {
                Fragment v9 = null;
                int v10 = 3;
                int v11 = 9;
                if(v6 != 2) {
                    if(v6 != v10 && v6 != 6) {
                        if(v6 != 7) {
                            if(v6 != 8) {
                            }
                            else {
                                v0.mOps.add(v4, new Op(v11, v3));
                                ++v4;
                                v3 = ((Op)v5).mFragment;
                            }

                            goto label_89;
                        }
                        else {
                            goto label_87;
                        }
                    }

                    v1.remove(((Op)v5).mFragment);
                    if(((Op)v5).mFragment != v3) {
                        goto label_89;
                    }

                    v0.mOps.add(v4, new Op(v11, ((Op)v5).mFragment));
                    ++v4;
                    v3 = v9;
                }
                else {
                    Fragment v6_1 = ((Op)v5).mFragment;
                    int v8 = v6_1.mContainerId;
                    int v12 = v1.size() - 1;
                    int v13 = 0;
                    while(v12 >= 0) {
                        Object v14 = v1.get(v12);
                        if(((Fragment)v14).mContainerId == v8) {
                            if((((Fragment)v14)) == v6_1) {
                                v13 = 1;
                            }
                            else {
                                if((((Fragment)v14)) == v3) {
                                    v0.mOps.add(v4, new Op(v11, ((Fragment)v14)));
                                    ++v4;
                                    v3 = v9;
                                }

                                Op v15 = new Op(v10, ((Fragment)v14));
                                v15.mEnterAnim = ((Op)v5).mEnterAnim;
                                v15.mPopEnterAnim = ((Op)v5).mPopEnterAnim;
                                v15.mExitAnim = ((Op)v5).mExitAnim;
                                v15.mPopExitAnim = ((Op)v5).mPopExitAnim;
                                v0.mOps.add(v4, v15);
                                v1.remove(v14);
                                ++v4;
                            }
                        }

                        --v12;
                    }

                    if(v13 != 0) {
                        v0.mOps.remove(v4);
                        --v4;
                        goto label_89;
                    }

                    ((Op)v5).mCmd = 1;
                    v1.add(v6_1);
                }
            }
            else {
            label_87:
                v1.add(((Op)v5).mFragment);
            }

        label_89:
        }

        return v3;
    }

    public boolean generateOps(ArrayList arg3, ArrayList arg4) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }

        arg3.add(this);
        arg4.add(Boolean.valueOf(false));
        if(this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }

        return 1;
    }

    public CharSequence getBreadCrumbShortTitle() {
        if(this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
        }

        return this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        if(this.mBreadCrumbTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
        }

        return this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public FragmentTransaction hide(Fragment arg3) {
        if(arg3.mFragmentManager != null) {
            if(arg3.mFragmentManager == this.mManager) {
            }
            else {
                throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + arg3.toString() + " is already attached to a FragmentManager.");
            }
        }

        return super.hide(arg3);
    }

    boolean interactsWith(int arg6) {
        int v0 = this.mOps.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v3 = this.mOps.get(v2);
            int v3_1 = ((Op)v3).mFragment != null ? ((Op)v3).mFragment.mContainerId : 0;
            if(v3_1 != 0 && v3_1 == arg6) {
                return 1;
            }
        }

        return 0;
    }

    boolean interactsWith(ArrayList arg11, int arg12, int arg13) {
        if(arg13 == arg12) {
            return 0;
        }

        int v1 = this.mOps.size();
        int v2 = -1;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = this.mOps.get(v3);
            int v4_1 = ((Op)v4).mFragment != null ? ((Op)v4).mFragment.mContainerId : 0;
            if(v4_1 != 0 && v4_1 != v2) {
                for(v2 = arg12; v2 < arg13; ++v2) {
                    Object v5 = arg11.get(v2);
                    int v6 = ((BackStackRecord)v5).mOps.size();
                    int v7;
                    for(v7 = 0; v7 < v6; ++v7) {
                        Object v8 = ((BackStackRecord)v5).mOps.get(v7);
                        int v8_1 = ((Op)v8).mFragment != null ? ((Op)v8).mFragment.mContainerId : 0;
                        if(v8_1 == v4_1) {
                            return 1;
                        }
                    }
                }

                v2 = v4_1;
            }
        }

        return 0;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    private static boolean isFragmentPostponed(Op arg1) {
        Fragment v1 = arg1.mFragment;
        if(v1 != null && (v1.mAdded) && v1.mView != null && !v1.mDetached && !v1.mHidden && (v1.isPostponed())) {
            return 1;
        }

        return 0;
    }

    boolean isPostponed() {
        int v1;
        for(v1 = 0; v1 < this.mOps.size(); ++v1) {
            if(BackStackRecord.isFragmentPostponed(this.mOps.get(v1))) {
                return 1;
            }
        }

        return 0;
    }

    public FragmentTransaction remove(Fragment arg3) {
        if(arg3.mFragmentManager != null) {
            if(arg3.mFragmentManager == this.mManager) {
            }
            else {
                throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + arg3.toString() + " is already attached to a FragmentManager.");
            }
        }

        return super.remove(arg3);
    }

    public void runOnCommitRunnables() {
        if(this.mCommitRunnables != null) {
            int v0;
            for(v0 = 0; v0 < this.mCommitRunnables.size(); ++v0) {
                this.mCommitRunnables.get(v0).run();
            }

            this.mCommitRunnables = null;
        }
    }

    public FragmentTransaction setMaxLifecycle(Fragment arg4, State arg5) {
        if(arg4.mFragmentManager == this.mManager) {
            String v1 = "Cannot set maximum Lifecycle to ";
            if(arg5 == State.INITIALIZED) {
                if(arg4.mState <= -1) {
                }
                else {
                    throw new IllegalArgumentException(v1 + arg5 + " after the Fragment has been created");
                }
            }

            if(arg5 != State.DESTROYED) {
                return super.setMaxLifecycle(arg4, arg5);
            }

            throw new IllegalArgumentException(v1 + arg5 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }

        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    void setOnStartPostponedListener(OnStartEnterTransitionListener arg4) {
        int v0;
        for(v0 = 0; v0 < this.mOps.size(); ++v0) {
            Object v1 = this.mOps.get(v0);
            if(BackStackRecord.isFragmentPostponed(((Op)v1))) {
                ((Op)v1).mFragment.setOnStartEnterTransitionListener(arg4);
            }
        }
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment arg3) {
        if(arg3 != null && arg3.mFragmentManager != null) {
            if(arg3.mFragmentManager == this.mManager) {
            }
            else {
                throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + arg3.toString() + " is already attached to a FragmentManager.");
            }
        }

        return super.setPrimaryNavigationFragment(arg3);
    }

    public FragmentTransaction show(Fragment arg3) {
        if(arg3.mFragmentManager != null) {
            if(arg3.mFragmentManager == this.mManager) {
            }
            else {
                throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + arg3.toString() + " is already attached to a FragmentManager.");
            }
        }

        return super.show(arg3);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("BackStackEntry{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        if(this.mIndex >= 0) {
            v0.append(" #");
            v0.append(this.mIndex);
        }

        if(this.mName != null) {
            v0.append(" ");
            v0.append(this.mName);
        }

        v0.append("}");
        return v0.toString();
    }

    Fragment trackAddedFragmentsInPop(ArrayList arg6, Fragment arg7) {
        int v0;
        for(v0 = this.mOps.size() - 1; v0 >= 0; --v0) {
            Object v2 = this.mOps.get(v0);
            int v3 = ((Op)v2).mCmd;
            if(v3 != 1) {
                if(v3 != 3) {
                    switch(v3) {
                        case 6: {
                            goto label_20;
                        }
                        case 7: {
                            goto label_23;
                        }
                        case 8: {
                            goto label_18;
                        }
                        case 9: {
                            goto label_16;
                        }
                        case 10: {
                            goto label_13;
                        }
                    }

                    goto label_25;
                label_18:
                    arg7 = null;
                    goto label_25;
                label_13:
                    ((Op)v2).mCurrentMaxState = ((Op)v2).mOldMaxState;
                    goto label_25;
                label_16:
                    arg7 = ((Op)v2).mFragment;
                    goto label_25;
                }

            label_20:
                arg6.add(((Op)v2).mFragment);
            }
            else {
            label_23:
                arg6.remove(((Op)v2).mFragment);
            }

        label_25:
        }

        return arg7;
    }
}

