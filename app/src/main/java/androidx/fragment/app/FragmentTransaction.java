package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle$State;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    final class Op {
        int mCmd;
        State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op(int arg1, Fragment arg2) {
            super();
            this.mCmd = arg1;
            this.mFragment = arg2;
            this.mOldMaxState = State.RESUMED;
            this.mCurrentMaxState = State.RESUMED;
        }

        Op(int arg1, Fragment arg2, State arg3) {
            super();
            this.mCmd = arg1;
            this.mFragment = arg2;
            this.mOldMaxState = arg2.mMaxState;
            this.mCurrentMaxState = arg3;
        }

        Op() {
            super();
        }
    }

    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 0x1000;
    public static final int TRANSIT_EXIT_MASK = 0x2000;
    public static final int TRANSIT_FRAGMENT_CLOSE = 0x2002;
    public static final int TRANSIT_FRAGMENT_FADE = 0x1003;
    public static final int TRANSIT_FRAGMENT_OPEN = 0x1001;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList mSharedElementSourceNames;
    ArrayList mSharedElementTargetNames;
    int mTransition;

    @Deprecated public FragmentTransaction() {
        super();
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(FragmentFactory arg2, ClassLoader arg3) {
        super();
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = arg2;
        this.mClassLoader = arg3;
    }

    public FragmentTransaction add(Fragment arg3, String arg4) {
        this.doAddOp(0, arg3, arg4, 1);
        return this;
    }

    public FragmentTransaction add(int arg3, Fragment arg4) {
        this.doAddOp(arg3, arg4, null, 1);
        return this;
    }

    public FragmentTransaction add(int arg2, Fragment arg3, String arg4) {
        this.doAddOp(arg2, arg3, arg4, 1);
        return this;
    }

    public final FragmentTransaction add(int arg1, Class arg2, Bundle arg3) {
        return this.add(arg1, this.createFragment(arg2, arg3));
    }

    public final FragmentTransaction add(int arg1, Class arg2, Bundle arg3, String arg4) {
        return this.add(arg1, this.createFragment(arg2, arg3), arg4);
    }

    FragmentTransaction add(ViewGroup arg1, Fragment arg2, String arg3) {
        arg2.mContainer = arg1;
        return this.add(arg1.getId(), arg2, arg3);
    }

    public final FragmentTransaction add(Class arg1, Bundle arg2, String arg3) {
        return this.add(this.createFragment(arg1, arg2), arg3);
    }

    void addOp(Op arg2) {
        this.mOps.add(arg2);
        arg2.mEnterAnim = this.mEnterAnim;
        arg2.mExitAnim = this.mExitAnim;
        arg2.mPopEnterAnim = this.mPopEnterAnim;
        arg2.mPopExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction addSharedElement(View arg3, String arg4) {
        String v1;
        if(!FragmentTransition.supportsTransition()) {
            return this;
        }

        String v3 = ViewCompat.getTransitionName(arg3);
        if(v3 == null) {
            goto label_43;
        }

        if(this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementTargetNames = new ArrayList();
        }
        else {
            v1 = "\' has already been added to the transaction.";
            if(!this.mSharedElementTargetNames.contains(arg4)) {
                if(!this.mSharedElementSourceNames.contains(v3)) {
                    goto label_20;
                }

                goto label_25;
            }
            else {
                goto label_34;
            }
        }

    label_20:
        this.mSharedElementSourceNames.add(v3);
        this.mSharedElementTargetNames.add(arg4);
        return this;
    label_25:
        throw new IllegalArgumentException("A shared element with the source name \'" + v3 + v1);
    label_34:
        throw new IllegalArgumentException("A shared element with the target name \'" + arg4 + v1);
    label_43:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        return this;
    }

    public FragmentTransaction addToBackStack(String arg2) {
        if(this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = arg2;
            return this;
        }

        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction attach(Fragment arg3) {
        this.addOp(new Op(7, arg3));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    private Fragment createFragment(Class arg2, Bundle arg3) {
        FragmentFactory v0 = this.mFragmentFactory;
        if(v0 != null) {
            ClassLoader v1 = this.mClassLoader;
            if(v1 != null) {
                Fragment v1_1 = v0.instantiate(v1, arg2.getName());
                if(arg3 != null) {
                    v1_1.setArguments(arg3);
                }

                return v1_1;
            }

            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }

        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public FragmentTransaction detach(Fragment arg3) {
        this.addOp(new Op(6, arg3));
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if(!this.mAddToBackStack) {
            this.mAllowAddToBackStack = false;
            return this;
        }

        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    void doAddOp(int arg4, Fragment arg5, String arg6, int arg7) {
        Class v0 = arg5.getClass();
        int v1 = v0.getModifiers();
        if(!v0.isAnonymousClass() && (Modifier.isPublic(v1)) && (!v0.isMemberClass() || (Modifier.isStatic(v1)))) {
            String v0_1 = " now ";
            String v1_1 = ": was ";
            if(arg6 != null) {
                if(arg5.mTag != null) {
                    if(arg6.equals(arg5.mTag)) {
                    }
                    else {
                        throw new IllegalStateException("Can\'t change tag of fragment " + arg5 + v1_1 + arg5.mTag + v0_1 + arg6);
                    }
                }

                arg5.mTag = arg6;
            }

            if(arg4 != 0) {
                if(arg4 != -1) {
                    if(arg5.mFragmentId != 0) {
                        if(arg5.mFragmentId == arg4) {
                        }
                        else {
                            throw new IllegalStateException("Can\'t change container ID of fragment " + arg5 + v1_1 + arg5.mFragmentId + v0_1 + arg4);
                        }
                    }

                    arg5.mFragmentId = arg4;
                    arg5.mContainerId = arg4;
                }
                else {
                    throw new IllegalArgumentException("Can\'t add fragment " + arg5 + " with tag " + arg6 + " to container view with no id");
                }
            }

            this.addOp(new Op(arg7, arg5));
            return;
        }

        throw new IllegalStateException("Fragment " + v0.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public FragmentTransaction hide(Fragment arg3) {
        this.addOp(new Op(4, arg3));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction remove(Fragment arg3) {
        this.addOp(new Op(3, arg3));
        return this;
    }

    public FragmentTransaction replace(int arg2, Fragment arg3) {
        return this.replace(arg2, arg3, null);
    }

    public FragmentTransaction replace(int arg2, Fragment arg3, String arg4) {
        if(arg2 != 0) {
            this.doAddOp(arg2, arg3, arg4, 2);
            return this;
        }

        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public final FragmentTransaction replace(int arg2, Class arg3, Bundle arg4) {
        return this.replace(arg2, arg3, arg4, null);
    }

    public final FragmentTransaction replace(int arg1, Class arg2, Bundle arg3, String arg4) {
        return this.replace(arg1, this.createFragment(arg2, arg3), arg4);
    }

    public FragmentTransaction runOnCommit(Runnable arg2) {
        this.disallowAddToBackStack();
        ArrayList v0 = this.mCommitRunnables;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mCommitRunnables = v0;
        }

        v0.add(arg2);
        return this;
    }

    @Deprecated public FragmentTransaction setAllowOptimization(boolean arg1) {
        return this.setReorderingAllowed(arg1);
    }

    @Deprecated public FragmentTransaction setBreadCrumbShortTitle(int arg1) {
        this.mBreadCrumbShortTitleRes = arg1;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Deprecated public FragmentTransaction setBreadCrumbShortTitle(CharSequence arg2) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = arg2;
        return this;
    }

    @Deprecated public FragmentTransaction setBreadCrumbTitle(int arg1) {
        this.mBreadCrumbTitleRes = arg1;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Deprecated public FragmentTransaction setBreadCrumbTitle(CharSequence arg2) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = arg2;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int arg2, int arg3) {
        return this.setCustomAnimations(arg2, arg3, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int arg1, int arg2, int arg3, int arg4) {
        this.mEnterAnim = arg1;
        this.mExitAnim = arg2;
        this.mPopEnterAnim = arg3;
        this.mPopExitAnim = arg4;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment arg3, State arg4) {
        this.addOp(new Op(10, arg3, arg4));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment arg3) {
        this.addOp(new Op(8, arg3));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean arg1) {
        this.mReorderingAllowed = arg1;
        return this;
    }

    public FragmentTransaction setTransition(int arg1) {
        this.mTransition = arg1;
        return this;
    }

    @Deprecated public FragmentTransaction setTransitionStyle(int arg1) {
        return this;
    }

    public FragmentTransaction show(Fragment arg3) {
        this.addOp(new Op(5, arg3));
        return this;
    }
}

