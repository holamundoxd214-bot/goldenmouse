package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$OnCreateContextMenuListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener, ActivityResultCaller, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    class androidx.fragment.app.Fragment$1 implements Runnable {
        androidx.fragment.app.Fragment$1(Fragment arg1) {
            Fragment.this = arg1;
            super();
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsHideReplaced;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList mSharedElementSourceNames;
        ArrayList mSharedElementTargetNames;
        OnStartEnterTransitionListener mStartEnterTransitionListener;

        AnimationInfo() {
            super();
            this.mEnterTransition = null;
            this.mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mExitTransition = null;
            this.mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1f;
            this.mFocusedView = null;
        }
    }

    public class InstantiationException extends RuntimeException {
        public InstantiationException(String arg1, Exception arg2) {
            super(arg1, ((Throwable)arg2));
        }
    }

    abstract class OnPreAttachedListener {
        OnPreAttachedListener(androidx.fragment.app.Fragment$1 arg1) {
            this();
        }

        private OnPreAttachedListener() {
            super();
        }

        abstract void onPreAttached();
    }

    interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    public class SavedState implements Parcelable {
        class androidx.fragment.app.Fragment$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.fragment.app.Fragment$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        final Bundle mState;

        static {
            SavedState.CREATOR = new androidx.fragment.app.Fragment$SavedState$1();
        }

        SavedState(Bundle arg1) {
            super();
            this.mState = arg1;
        }

        SavedState(Parcel arg1, ClassLoader arg2) {
            super();
            Bundle v1 = arg1.readBundle();
            this.mState = v1;
            if(arg2 != null && v1 != null) {
                v1.setClassLoader(arg2);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            arg1.writeBundle(this.mState);
        }
    }

    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData mViewLifecycleOwnerLiveData;
    String mWho;

    static {
        Fragment.USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        super();
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new androidx.fragment.app.Fragment$1(this);
        this.mMaxState = State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.initLifecycle();
    }

    public Fragment(int arg1) {
        this();
        this.mContentLayoutId = arg1;
    }

    void callStartTransitionListener(boolean arg4) {
        AnimationInfo v0 = this.mAnimationInfo;
        OnStartEnterTransitionListener v1 = null;
        if(v0 == null) {
        }
        else {
            v0.mEnterTransitionPostponed = false;
            OnStartEnterTransitionListener v0_1 = this.mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = v1;
            v1 = v0_1;
        }

        if(v1 != null) {
            v1.onStartEnterTransition();
            return;
        }

        if((FragmentManager.USE_STATE_MANAGER) && this.mView != null) {
            ViewGroup v0_2 = this.mContainer;
            if(v0_2 != null) {
                FragmentManager v1_1 = this.mFragmentManager;
                if(v1_1 != null) {
                    SpecialEffectsController v0_3 = SpecialEffectsController.getOrCreateController(v0_2, v1_1);
                    v0_3.markPostponedState();
                    if(arg4) {
                        this.mHost.getHandler().post(new Runnable(v0_3) {
                            public void run() {
                                this.val$controller.executePendingOperations();
                            }
                        });
                        return;
                    }
                    else {
                        v0_3.executePendingOperations();
                    }
                }
            }
        }
    }

    FragmentContainer createFragmentContainer() {
        return new FragmentContainer() {
            public View onFindViewById(int arg3) {
                View v0 = Fragment.this.mView;
                Fragment v2 = Fragment.this;
                if(v0 != null) {
                    return v2.mView.findViewById(arg3);
                }

                throw new IllegalStateException("Fragment " + v2 + " does not have a view");
            }

            public boolean onHasView() {
                if(Fragment.this.mView != null) {
                    return 1;
                }

                return 0;
            }
        };
    }

    public void dump(String arg3, FileDescriptor arg4, PrintWriter arg5, String[] arg6) {
        arg5.print(arg3);
        arg5.print("mFragmentId=#");
        arg5.print(Integer.toHexString(this.mFragmentId));
        arg5.print(" mContainerId=#");
        arg5.print(Integer.toHexString(this.mContainerId));
        arg5.print(" mTag=");
        arg5.println(this.mTag);
        arg5.print(arg3);
        arg5.print("mState=");
        arg5.print(this.mState);
        arg5.print(" mWho=");
        arg5.print(this.mWho);
        arg5.print(" mBackStackNesting=");
        arg5.println(this.mBackStackNesting);
        arg5.print(arg3);
        arg5.print("mAdded=");
        arg5.print(this.mAdded);
        arg5.print(" mRemoving=");
        arg5.print(this.mRemoving);
        arg5.print(" mFromLayout=");
        arg5.print(this.mFromLayout);
        arg5.print(" mInLayout=");
        arg5.println(this.mInLayout);
        arg5.print(arg3);
        arg5.print("mHidden=");
        arg5.print(this.mHidden);
        arg5.print(" mDetached=");
        arg5.print(this.mDetached);
        arg5.print(" mMenuVisible=");
        arg5.print(this.mMenuVisible);
        arg5.print(" mHasMenu=");
        arg5.println(this.mHasMenu);
        arg5.print(arg3);
        arg5.print("mRetainInstance=");
        arg5.print(this.mRetainInstance);
        arg5.print(" mUserVisibleHint=");
        arg5.println(this.mUserVisibleHint);
        if(this.mFragmentManager != null) {
            arg5.print(arg3);
            arg5.print("mFragmentManager=");
            arg5.println(this.mFragmentManager);
        }

        if(this.mHost != null) {
            arg5.print(arg3);
            arg5.print("mHost=");
            arg5.println(this.mHost);
        }

        if(this.mParentFragment != null) {
            arg5.print(arg3);
            arg5.print("mParentFragment=");
            arg5.println(this.mParentFragment);
        }

        if(this.mArguments != null) {
            arg5.print(arg3);
            arg5.print("mArguments=");
            arg5.println(this.mArguments);
        }

        if(this.mSavedFragmentState != null) {
            arg5.print(arg3);
            arg5.print("mSavedFragmentState=");
            arg5.println(this.mSavedFragmentState);
        }

        if(this.mSavedViewState != null) {
            arg5.print(arg3);
            arg5.print("mSavedViewState=");
            arg5.println(this.mSavedViewState);
        }

        if(this.mSavedViewRegistryState != null) {
            arg5.print(arg3);
            arg5.print("mSavedViewRegistryState=");
            arg5.println(this.mSavedViewRegistryState);
        }

        Fragment v0 = this.getTargetFragment();
        if(v0 != null) {
            arg5.print(arg3);
            arg5.print("mTarget=");
            arg5.print(v0);
            arg5.print(" mTargetRequestCode=");
            arg5.println(this.mTargetRequestCode);
        }

        arg5.print(arg3);
        arg5.print("mPopDirection=");
        arg5.println(this.getPopDirection());
        if(this.getEnterAnim() != 0) {
            arg5.print(arg3);
            arg5.print("getEnterAnim=");
            arg5.println(this.getEnterAnim());
        }

        if(this.getExitAnim() != 0) {
            arg5.print(arg3);
            arg5.print("getExitAnim=");
            arg5.println(this.getExitAnim());
        }

        if(this.getPopEnterAnim() != 0) {
            arg5.print(arg3);
            arg5.print("getPopEnterAnim=");
            arg5.println(this.getPopEnterAnim());
        }

        if(this.getPopExitAnim() != 0) {
            arg5.print(arg3);
            arg5.print("getPopExitAnim=");
            arg5.println(this.getPopExitAnim());
        }

        if(this.mContainer != null) {
            arg5.print(arg3);
            arg5.print("mContainer=");
            arg5.println(this.mContainer);
        }

        if(this.mView != null) {
            arg5.print(arg3);
            arg5.print("mView=");
            arg5.println(this.mView);
        }

        if(this.getAnimatingAway() != null) {
            arg5.print(arg3);
            arg5.print("mAnimatingAway=");
            arg5.println(this.getAnimatingAway());
        }

        if(this.getContext() != null) {
            LoaderManager.getInstance(((LifecycleOwner)this)).dump(arg3, arg4, arg5, arg6);
        }

        arg5.print(arg3);
        arg5.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(arg3 + "  ", arg4, arg5, arg6);
    }

    private AnimationInfo ensureAnimationInfo() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            v0 = new AnimationInfo();
            this.mAnimationInfo = v0;
        }

        return v0;
    }

    public final boolean equals(Object arg1) {
        return super.equals(arg1);
    }

    Fragment findFragmentByWho(String arg2) {
        if(arg2.equals(this.mWho)) {
            return this;
        }

        return this.mChildFragmentManager.findFragmentByWho(arg2);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback v0 = this.mHost;
        if(v0 == null) {
            return null;
        }

        return v0.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 != null) {
            if(v0.mAllowEnterTransitionOverlap == null) {
            }
            else {
                return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
            }
        }

        return 1;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 != null) {
            if(v0.mAllowReturnTransitionOverlap == null) {
            }
            else {
                return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
            }
        }

        return 1;
    }

    View getAnimatingAway() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mAnimatingAway;
    }

    Animator getAnimator() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mAnimator;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if(this.mHost != null) {
            return this.mChildFragmentManager;
        }

        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        FragmentHostCallback v0 = this.mHost;
        if(v0 == null) {
            return null;
        }

        return v0.getContext();
    }

    public Factory getDefaultViewModelProviderFactory() {
        if(this.mFragmentManager != null) {
            if(this.mDefaultFactory == null) {
                Context v0 = this.requireContext().getApplicationContext();
                while(true) {
                    if(!(v0 instanceof ContextWrapper)) {
                        break;
                    }
                    else if((v0 instanceof Application)) {
                    }
                    else {
                        v0 = ((ContextWrapper)v0).getBaseContext();
                        continue;
                    }

                    goto label_14;
                }

                v0 = null;
            label_14:
                if(v0 == null && (FragmentManager.isLoggingEnabled(3))) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + this.requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                }

                this.mDefaultFactory = new SavedStateViewModelFactory(((Application)v0), ((SavedStateRegistryOwner)this), this.getArguments());
            }

            return this.mDefaultFactory;
        }

        throw new IllegalStateException("Can\'t access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mEnterTransition;
    }

    SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mEnterTransitionCallback;
    }

    int getExitAnim() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mExitTransition;
    }

    SharedElementCallback getExitTransitionCallback() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mExitTransitionCallback;
    }

    View getFocusedView() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mFocusedView;
    }

    @Deprecated public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        FragmentHostCallback v0 = this.mHost;
        if(v0 == null) {
            return null;
        }

        return v0.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater v0 = this.mLayoutInflater;
        if(v0 == null) {
            return this.performGetLayoutInflater(null);
        }

        return v0;
    }

    @Deprecated public LayoutInflater getLayoutInflater(Bundle arg1) {
        FragmentHostCallback v1 = this.mHost;
        if(v1 != null) {
            LayoutInflater v1_1 = v1.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2(v1_1, this.mChildFragmentManager.getLayoutInflaterFactory());
            return v1_1;
        }

        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(((LifecycleOwner)this));
    }

    private int getMinimumMaxLifecycleState() {
        if(this.mMaxState != State.INITIALIZED) {
            if(this.mParentFragment == null) {
            }
            else {
                return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
            }
        }

        return this.mMaxState.ordinal();
    }

    int getNextTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager v0 = this.mFragmentManager;
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mIsPop;
    }

    int getPopEnterAnim() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mPopEnterAnim;
    }

    int getPopExitAnim() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mPopExitAnim;
    }

    float getPostOnViewCreatedAlpha() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 1f;
        }

        return v0.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        if(v0.mReenterTransition == Fragment.USE_DEFAULT_TRANSITION) {
            return this.getExitTransition();
        }

        return this.mAnimationInfo.mReenterTransition;
    }

    public final Resources getResources() {
        return this.requireContext().getResources();
    }

    @Deprecated public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        if(v0.mReturnTransition == Fragment.USE_DEFAULT_TRANSITION) {
            return this.getEnterTransition();
        }

        return this.mAnimationInfo.mReturnTransition;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        return v0.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return null;
        }

        if(v0.mSharedElementReturnTransition == Fragment.USE_DEFAULT_TRANSITION) {
            return this.getSharedElementEnterTransition();
        }

        return this.mAnimationInfo.mSharedElementReturnTransition;
    }

    ArrayList getSharedElementSourceNames() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 != null) {
            if(v0.mSharedElementSourceNames == null) {
            }
            else {
                return this.mAnimationInfo.mSharedElementSourceNames;
            }
        }

        return new ArrayList();
    }

    ArrayList getSharedElementTargetNames() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 != null) {
            if(v0.mSharedElementTargetNames == null) {
            }
            else {
                return this.mAnimationInfo.mSharedElementTargetNames;
            }
        }

        return new ArrayList();
    }

    public final String getString(int arg1) {
        return this.getResources().getString(arg1);
    }

    public final String getString(int arg1, Object[] arg2) {
        return this.getResources().getString(arg1, arg2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated public final Fragment getTargetFragment() {
        Fragment v0 = this.mTarget;
        if(v0 != null) {
            return v0;
        }

        FragmentManager v0_1 = this.mFragmentManager;
        if(v0_1 != null) {
            String v1 = this.mTargetWho;
            if(v1 != null) {
                return v0_1.findActiveFragment(v1);
            }
        }

        return null;
    }

    @Deprecated public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int arg1) {
        return this.getResources().getText(arg1);
    }

    @Deprecated public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner v1 = this.mViewLifecycleOwner;
        if(v1 != null) {
            return ((LifecycleOwner)v1);
        }

        throw new IllegalStateException("Can\'t access the Fragment View\'s LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public ViewModelStore getViewModelStore() {
        if(this.mFragmentManager != null) {
            if(this.getMinimumMaxLifecycleState() != State.INITIALIZED.ordinal()) {
                return this.mFragmentManager.getViewModelStore(this);
            }

            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }

        throw new IllegalStateException("Can\'t access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(((LifecycleOwner)this));
        this.mSavedStateRegistryController = SavedStateRegistryController.create(((SavedStateRegistryOwner)this));
        this.mDefaultFactory = null;
    }

    void initState() {
        this.initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    @Deprecated public static Fragment instantiate(Context arg4, String arg5, Bundle arg6) {
        Object v4_4;
        String v0 = ": make sure class name exists, is public, and has an empty constructor that is public";
        String v1 = "Unable to instantiate fragment ";
        try {
            v4_4 = FragmentFactory.loadFragmentClass(arg4.getClassLoader(), arg5).getConstructor().newInstance();
            if(arg6 != null) {
                arg6.setClassLoader(v4_4.getClass().getClassLoader());
                ((Fragment)v4_4).setArguments(arg6);
            }
        }
        catch(InvocationTargetException v4) {
            throw new InstantiationException(v1 + arg5 + ": calling Fragment constructor caused an exception", ((Exception)v4));
        }
        catch(NoSuchMethodException v4_1) {
            throw new InstantiationException(v1 + arg5 + ": could not find Fragment constructor", ((Exception)v4_1));
        }
        catch(IllegalAccessException v4_2) {
            throw new InstantiationException(v1 + arg5 + v0, ((Exception)v4_2));
        }
        catch(java.lang.InstantiationException v4_3) {
            throw new InstantiationException(v1 + arg5 + v0, ((Exception)v4_3));
        }

        return ((Fragment)v4_4);
    }

    @Deprecated public static Fragment instantiate(Context arg1, String arg2) {
        return Fragment.instantiate(arg1, arg2, null);
    }

    public final boolean isAdded() {
        if(this.mHost != null && (this.mAdded)) {
            return 1;
        }

        return 0;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mIsHideReplaced;
    }

    final boolean isInBackStack() {
        if(this.mBackStackNesting > 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if(this.mMenuVisible) {
            FragmentManager v0 = this.mFragmentManager;
            if(v0 != null && !v0.isParentMenuVisible(this.mParentFragment)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    boolean isPostponed() {
        AnimationInfo v0 = this.mAnimationInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        this = this.getParentFragment();
        if(this != null && ((this.isRemoving()) || (this.isRemovingParent()))) {
            return 1;
        }

        return 0;
    }

    public final boolean isResumed() {
        if(this.mState >= 7) {
            return 1;
        }

        return 0;
    }

    public final boolean isStateSaved() {
        FragmentManager v0 = this.mFragmentManager;
        if(v0 == null) {
            return 0;
        }

        return v0.isStateSaved();
    }

    public final boolean isVisible() {
        if((this.isAdded()) && !this.isHidden()) {
            View v0 = this.mView;
            if(v0 != null && v0.getWindowToken() != null && this.mView.getVisibility() == 0) {
                return 1;
            }
        }

        return 0;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated public void onActivityCreated(Bundle arg1) {
        this.mCalled = true;
    }

    @Deprecated public void onActivityResult(int arg3, int arg4, Intent arg5) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + arg3 + " resultCode: " + arg4 + " data: " + arg5);
        }
    }

    @Deprecated public void onAttach(Activity arg1) {
        this.mCalled = true;
    }

    public void onAttach(Context arg2) {
        this.mCalled = true;
        FragmentHostCallback v2 = this.mHost;
        Activity v2_1 = v2 == null ? null : v2.getActivity();
        if(v2_1 != null) {
            this.mCalled = false;
            this.onAttach(v2_1);
        }
    }

    @Deprecated public void onAttachFragment(Fragment arg1) {
    }

    public void onConfigurationChanged(Configuration arg1) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem arg1) {
        return 0;
    }

    public void onCreate(Bundle arg2) {
        this.mCalled = true;
        this.restoreChildFragmentState(arg2);
        if(!this.mChildFragmentManager.isStateAtLeast(1)) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    public Animation onCreateAnimation(int arg1, boolean arg2, int arg3) {
        return null;
    }

    public Animator onCreateAnimator(int arg1, boolean arg2, int arg3) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu arg1, View arg2, ContextMenu$ContextMenuInfo arg3) {
        this.requireActivity().onCreateContextMenu(arg1, arg2, arg3);
    }

    public void onCreateOptionsMenu(Menu arg1, MenuInflater arg2) {
    }

    public View onCreateView(LayoutInflater arg1, ViewGroup arg2, Bundle arg3) {
        int v0 = this.mContentLayoutId;
        if(v0 != 0) {
            return arg1.inflate(v0, arg2, false);
        }

        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle arg1) {
        return this.getLayoutInflater(arg1);
    }

    public void onHiddenChanged(boolean arg1) {
    }

    @Deprecated public void onInflate(Activity arg1, AttributeSet arg2, Bundle arg3) {
        this.mCalled = true;
    }

    public void onInflate(Context arg2, AttributeSet arg3, Bundle arg4) {
        this.mCalled = true;
        FragmentHostCallback v2 = this.mHost;
        Activity v2_1 = v2 == null ? null : v2.getActivity();
        if(v2_1 != null) {
            this.mCalled = false;
            this.onInflate(v2_1, arg3, arg4);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean arg1) {
    }

    public boolean onOptionsItemSelected(MenuItem arg1) {
        return 0;
    }

    public void onOptionsMenuClosed(Menu arg1) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean arg1) {
    }

    public void onPrepareOptionsMenu(Menu arg1) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean arg1) {
    }

    @Deprecated public void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle arg1) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View arg1, Bundle arg2) {
    }

    public void onViewStateRestored(Bundle arg1) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle arg3) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        this.onActivityCreated(arg3);
        if(this.mCalled) {
            this.restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void performAttach() {
        Iterator v0 = this.mOnPreAttachedListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onPreAttached();
        }

        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, this.createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        this.onAttach(this.mHost.getContext());
        if(this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performConfigurationChanged(Configuration arg1) {
        this.onConfigurationChanged(arg1);
        this.mChildFragmentManager.dispatchConfigurationChanged(arg1);
    }

    boolean performContextItemSelected(MenuItem arg2) {
        if(!this.mHidden) {
            if(this.onContextItemSelected(arg2)) {
                return 1;
            }

            return this.mChildFragmentManager.dispatchContextItemSelected(arg2);
        }

        return 0;
    }

    void performCreate(Bundle arg4) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(LifecycleOwner arg1, Event arg2) {
                if(arg2 == Event.ON_STOP && Fragment.this.mView != null) {
                    Fragment.this.mView.cancelPendingInputEvents();
                }
            }
        });
        this.mSavedStateRegistryController.performRestore(arg4);
        this.onCreate(arg4);
        this.mIsCreated = true;
        if(this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_CREATE);
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu arg3, MenuInflater arg4) {
        int v1 = 0;
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                this.onCreateOptionsMenu(arg3, arg4);
                v1 = 1;
            }

            return this.mChildFragmentManager.dispatchCreateOptionsMenu(arg3, arg4) | v1;
        }

        return 0;
    }

    void performCreateView(LayoutInflater arg3, ViewGroup arg4, Bundle arg5) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, this.getViewModelStore());
        View v3 = this.onCreateView(arg3, arg4, arg5);
        this.mView = v3;
        FragmentViewLifecycleOwner v4 = this.mViewLifecycleOwner;
        if(v3 != null) {
            v4.initialize();
            ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }

        if(!v4.isInitialized()) {
            this.mViewLifecycleOwner = null;
            return;
        }

        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        this.onDestroy();
        if(this.mCalled) {
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if(this.mView != null && (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(State.CREATED))) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_DESTROY);
        }

        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if(this.mCalled) {
            LoaderManager.getInstance(((LifecycleOwner)this)).markForRedelivery();
            this.mPerformedCreateView = false;
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        this.onDetach();
        this.mLayoutInflater = null;
        if(this.mCalled) {
            if(!this.mChildFragmentManager.isDestroyed()) {
                this.mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = new FragmentManagerImpl();
            }

            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater performGetLayoutInflater(Bundle arg1) {
        LayoutInflater v1 = this.onGetLayoutInflater(arg1);
        this.mLayoutInflater = v1;
        return v1;
    }

    void performLowMemory() {
        this.onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    void performMultiWindowModeChanged(boolean arg1) {
        this.onMultiWindowModeChanged(arg1);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(arg1);
    }

    boolean performOptionsItemSelected(MenuItem arg2) {
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible) && (this.onOptionsItemSelected(arg2))) {
                return 1;
            }

            return this.mChildFragmentManager.dispatchOptionsItemSelected(arg2);
        }

        return 0;
    }

    void performOptionsMenuClosed(Menu arg2) {
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                this.onOptionsMenuClosed(arg2);
            }

            this.mChildFragmentManager.dispatchOptionsMenuClosed(arg2);
        }
    }

    void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if(this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_PAUSE);
        }

        this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        this.onPause();
        if(this.mCalled) {
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean arg1) {
        this.onPictureInPictureModeChanged(arg1);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(arg1);
    }

    boolean performPrepareOptionsMenu(Menu arg3) {
        int v1 = 0;
        if(!this.mHidden) {
            if((this.mHasMenu) && (this.mMenuVisible)) {
                this.onPrepareOptionsMenu(arg3);
                v1 = 1;
            }

            return this.mChildFragmentManager.dispatchPrepareOptionsMenu(arg3) | v1;
        }

        return 0;
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean v0 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean v1 = this.mIsPrimaryNavigationFragment;
        if(v1 != null) {
            if(v1.booleanValue() != v0) {
            }
            else {
                return;
            }
        }

        this.mIsPrimaryNavigationFragment = Boolean.valueOf(v0);
        this.onPrimaryNavigationFragmentChanged(v0);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
    }

    void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        this.onResume();
        if(this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_RESUME);
            if(this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_RESUME);
            }

            this.mChildFragmentManager.dispatchResume();
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void performSaveInstanceState(Bundle arg2) {
        this.onSaveInstanceState(arg2);
        this.mSavedStateRegistryController.performSave(arg2);
        Parcelable v1 = this.mChildFragmentManager.saveAllState();
        if(v1 != null) {
            arg2.putParcelable("android:support:fragments", v1);
        }
    }

    void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        this.onStart();
        if(this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_START);
            if(this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_START);
            }

            this.mChildFragmentManager.dispatchStart();
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if(this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_STOP);
        }

        this.mLifecycleRegistry.handleLifecycleEvent(Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        this.onStop();
        if(this.mCalled) {
            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        this.onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long arg3, TimeUnit arg5) {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager v0 = this.mFragmentManager;
        Handler v0_1 = v0 != null ? v0.getHost().getHandler() : new Handler(Looper.getMainLooper());
        v0_1.removeCallbacks(this.mPostponedDurationRunnable);
        v0_1.postDelayed(this.mPostponedDurationRunnable, arg5.toMillis(arg3));
    }

    private ActivityResultLauncher prepareCallInternal(ActivityResultContract arg9, Function arg10, ActivityResultCallback arg11) {
        if(this.mState <= 1) {
            AtomicReference v5 = new AtomicReference();
            this.registerOnPreAttachListener(new OnPreAttachedListener(arg10, v5, arg9, arg11) {
                void onPreAttached() {
                    this.val$ref.set(this.val$registryProvider.apply(null).register(Fragment.this.generateActivityResultKey(), Fragment.this, this.val$contract, this.val$callback));
                }
            });
            return new ActivityResultLauncher(v5, arg9) {
                public ActivityResultContract getContract() {
                    return this.val$contract;
                }

                public void launch(Object arg1, ActivityOptionsCompat arg2) {
                    Object v0 = this.val$ref.get();
                    if(v0 != null) {
                        ((ActivityResultLauncher)v0).launch(arg1, arg2);
                        return;
                    }

                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }

                public void unregister() {
                    Object v1 = this.val$ref.getAndSet(null);
                    if(v1 != null) {
                        ((ActivityResultLauncher)v1).unregister();
                    }
                }
            };
        }

        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract arg2, ActivityResultCallback arg3) {
        return this.prepareCallInternal(arg2, new Function() {
            public ActivityResultRegistry apply(Void arg1) {
                boolean v1 = Fragment.this.mHost instanceof ActivityResultRegistryOwner;
                Fragment v0 = Fragment.this;
                if(v1) {
                    return v0.mHost.getActivityResultRegistry();
                }

                return v0.requireActivity().getActivityResultRegistry();
            }

            public Object apply(Object arg1) {
                return this.apply(((Void)arg1));
            }
        }, arg3);
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract arg2, ActivityResultRegistry arg3, ActivityResultCallback arg4) {
        return this.prepareCallInternal(arg2, new Function(arg3) {
            public ActivityResultRegistry apply(Void arg1) {
                return this.val$registry;
            }

            public Object apply(Object arg1) {
                return this.apply(((Void)arg1));
            }
        }, arg4);
    }

    public void registerForContextMenu(View arg1) {
        arg1.setOnCreateContextMenuListener(((View$OnCreateContextMenuListener)this));
    }

    private void registerOnPreAttachListener(OnPreAttachedListener arg2) {
        if(this.mState >= 0) {
            arg2.onPreAttached();
            return;
        }

        this.mOnPreAttachedListeners.add(arg2);
    }

    @Deprecated public final void requestPermissions(String[] arg2, int arg3) {
        if(this.mHost != null) {
            this.getParentFragmentManager().launchRequestPermissions(this, arg2, arg3);
            return;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity v0 = this.getActivity();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle v0 = this.getArguments();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context v0 = this.getContext();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated public final FragmentManager requireFragmentManager() {
        return this.getParentFragmentManager();
    }

    public final Object requireHost() {
        Object v0 = this.getHost();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment v0 = this.getParentFragment();
        if(v0 == null) {
            String v1 = "Fragment ";
            if(this.getContext() == null) {
                throw new IllegalStateException(v1 + this + " is not attached to any Fragment or host");
            }

            throw new IllegalStateException(v1 + this + " is not a child Fragment, it is directly attached to " + this.getContext());
        }

        return v0;
    }

    public final View requireView() {
        View v0 = this.getView();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle arg2) {
        if(arg2 != null) {
            Parcelable v2 = arg2.getParcelable("android:support:fragments");
            if(v2 != null) {
                this.mChildFragmentManager.restoreSaveState(v2);
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }

    private void restoreViewState() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }

        if(this.mView != null) {
            this.restoreViewState(this.mSavedFragmentState);
        }

        this.mSavedFragmentState = null;
    }

    final void restoreViewState(Bundle arg4) {
        SparseArray v0 = this.mSavedViewState;
        SparseArray v1 = null;
        if(v0 != null) {
            this.mView.restoreHierarchyState(v0);
            this.mSavedViewState = v1;
        }

        if(this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = ((Bundle)v1);
        }

        this.mCalled = false;
        this.onViewStateRestored(arg4);
        if(this.mCalled) {
            if(this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Event.ON_CREATE);
            }

            return;
        }

        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean arg1) {
        this.ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(arg1);
    }

    public void setAllowReturnTransitionOverlap(boolean arg1) {
        this.ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(arg1);
    }

    void setAnimatingAway(View arg1) {
        this.ensureAnimationInfo().mAnimatingAway = arg1;
    }

    void setAnimations(int arg2, int arg3, int arg4, int arg5) {
        if(this.mAnimationInfo == null && arg2 == 0 && arg3 == 0 && arg4 == 0 && arg5 == 0) {
            return;
        }

        this.ensureAnimationInfo().mEnterAnim = arg2;
        this.ensureAnimationInfo().mExitAnim = arg3;
        this.ensureAnimationInfo().mPopEnterAnim = arg4;
        this.ensureAnimationInfo().mPopExitAnim = arg5;
    }

    void setAnimator(Animator arg1) {
        this.ensureAnimationInfo().mAnimator = arg1;
    }

    public void setArguments(Bundle arg2) {
        if(this.mFragmentManager != null) {
            if(!this.isStateSaved()) {
            }
            else {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }

        this.mArguments = arg2;
    }

    public void setEnterSharedElementCallback(SharedElementCallback arg1) {
        this.ensureAnimationInfo().mEnterTransitionCallback = arg1;
    }

    public void setEnterTransition(Object arg1) {
        this.ensureAnimationInfo().mEnterTransition = arg1;
    }

    public void setExitSharedElementCallback(SharedElementCallback arg1) {
        this.ensureAnimationInfo().mExitTransitionCallback = arg1;
    }

    public void setExitTransition(Object arg1) {
        this.ensureAnimationInfo().mExitTransition = arg1;
    }

    void setFocusedView(View arg1) {
        this.ensureAnimationInfo().mFocusedView = arg1;
    }

    public void setHasOptionsMenu(boolean arg2) {
        if(this.mHasMenu != arg2) {
            this.mHasMenu = arg2;
            if((this.isAdded()) && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    void setHideReplaced(boolean arg1) {
        this.ensureAnimationInfo().mIsHideReplaced = arg1;
    }

    public void setInitialSavedState(SavedState arg2) {
        if(this.mFragmentManager == null) {
            Bundle v2 = arg2 == null || arg2.mState == null ? null : arg2.mState;
            this.mSavedFragmentState = v2;
            return;
        }

        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean arg2) {
        if(this.mMenuVisible != arg2) {
            this.mMenuVisible = arg2;
            if((this.mHasMenu) && (this.isAdded()) && !this.isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    void setNextTransition(int arg2) {
        if(this.mAnimationInfo == null && arg2 == 0) {
            return;
        }

        this.ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = arg2;
    }

    void setOnStartEnterTransitionListener(OnStartEnterTransitionListener arg3) {
        this.ensureAnimationInfo();
        if(arg3 == this.mAnimationInfo.mStartEnterTransitionListener) {
        }
        else {
            if(arg3 != null) {
                if(this.mAnimationInfo.mStartEnterTransitionListener == null) {
                }
                else {
                    throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
                }
            }

            if(this.mAnimationInfo.mEnterTransitionPostponed) {
                this.mAnimationInfo.mStartEnterTransitionListener = arg3;
            }

            if(arg3 == null) {
                return;
            }

            arg3.startListening();
        }
    }

    void setPopDirection(boolean arg2) {
        if(this.mAnimationInfo == null) {
            return;
        }

        this.ensureAnimationInfo().mIsPop = arg2;
    }

    void setPostOnViewCreatedAlpha(float arg1) {
        this.ensureAnimationInfo().mPostOnViewCreatedAlpha = arg1;
    }

    public void setReenterTransition(Object arg1) {
        this.ensureAnimationInfo().mReenterTransition = arg1;
    }

    @Deprecated public void setRetainInstance(boolean arg2) {
        this.mRetainInstance = arg2;
        FragmentManager v0 = this.mFragmentManager;
        if(v0 != null) {
            if(arg2) {
                v0.addRetainedFragment(this);
                return;
            }

            v0.removeRetainedFragment(this);
            return;
        }

        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object arg1) {
        this.ensureAnimationInfo().mReturnTransition = arg1;
    }

    public void setSharedElementEnterTransition(Object arg1) {
        this.ensureAnimationInfo().mSharedElementEnterTransition = arg1;
    }

    void setSharedElementNames(ArrayList arg2, ArrayList arg3) {
        this.ensureAnimationInfo();
        this.mAnimationInfo.mSharedElementSourceNames = arg2;
        this.mAnimationInfo.mSharedElementTargetNames = arg3;
    }

    public void setSharedElementReturnTransition(Object arg1) {
        this.ensureAnimationInfo().mSharedElementReturnTransition = arg1;
    }

    @Deprecated public void setTargetFragment(Fragment arg4, int arg5) {
        FragmentManager v0 = this.mFragmentManager;
        String v1 = null;
        FragmentManager v2 = arg4 != null ? arg4.mFragmentManager : ((FragmentManager)v1);
        if(v0 != null && v2 != null) {
            if(v0 == v2) {
            }
            else {
                throw new IllegalArgumentException("Fragment " + arg4 + " must share the same FragmentManager to be set as a target fragment");
            }
        }

        Fragment v0_1;
        for(v0_1 = arg4; true; v0_1 = v0_1.getTargetFragment()) {
            if(v0_1 == null) {
                goto label_39;
            }

            if(v0_1.equals(this)) {
                break;
            }
        }

        throw new IllegalArgumentException("Setting " + arg4 + " as the target of " + this + " would create a target cycle");
    label_39:
        if(arg4 == null) {
            this.mTargetWho = v1;
            this.mTarget = ((Fragment)v1);
        }
        else {
            if(this.mFragmentManager != null && arg4.mFragmentManager != null) {
                this.mTargetWho = arg4.mWho;
                this.mTarget = ((Fragment)v1);
                goto label_53;
            }

            this.mTargetWho = v1;
            this.mTarget = arg4;
        }

    label_53:
        this.mTargetRequestCode = arg5;
    }

    @Deprecated public void setUserVisibleHint(boolean arg4) {
        int v1 = 5;
        if(!this.mUserVisibleHint && (arg4) && this.mState < v1 && this.mFragmentManager != null && (this.isAdded()) && (this.mIsCreated)) {
            this.mFragmentManager.performPendingDeferredStart(this.mFragmentManager.createOrGetFragmentStateManager(this));
        }

        this.mUserVisibleHint = arg4;
        boolean v0 = this.mState >= v1 || (arg4) ? false : true;
        this.mDeferStart = v0;
        if(this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(arg4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String arg1) {
        FragmentHostCallback v0 = this.mHost;
        if(v0 != null) {
            return v0.onShouldShowRequestPermissionRationale(arg1);
        }

        return 0;
    }

    public void startActivity(Intent arg2) {
        this.startActivity(arg2, null);
    }

    public void startActivity(Intent arg3, Bundle arg4) {
        FragmentHostCallback v0 = this.mHost;
        if(v0 != null) {
            v0.onStartActivityFromFragment(this, arg3, -1, arg4);
            return;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated public void startActivityForResult(Intent arg2, int arg3) {
        this.startActivityForResult(arg2, arg3, null);
    }

    @Deprecated public void startActivityForResult(Intent arg2, int arg3, Bundle arg4) {
        if(this.mHost != null) {
            this.getParentFragmentManager().launchStartActivityForResult(this, arg2, arg3, arg4);
            return;
        }

        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated public void startIntentSenderForResult(IntentSender arg10, int arg11, Intent arg12, int arg13, int arg14, int arg15, Bundle arg16) throws IntentSender$SendIntentException {
        Bundle v8;
        String v2 = "Fragment ";
        if(this.mHost != null) {
            if(FragmentManager.isLoggingEnabled(2)) {
                v8 = arg16;
                Log.v("FragmentManager", v2 + this + " received the following in startIntentSenderForResult() requestCode: " + arg11 + " IntentSender: " + arg10 + " fillInIntent: " + arg12 + " options: " + v8);
            }
            else {
                v8 = arg16;
            }

            this.getParentFragmentManager().launchStartIntentSenderForResult(this, arg10, arg11, arg12, arg13, arg14, arg15, v8);
            return;
        }

        throw new IllegalStateException(v2 + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if(this.mAnimationInfo != null) {
            if(!this.ensureAnimationInfo().mEnterTransitionPostponed) {
            }
            else if(this.mHost == null) {
                this.ensureAnimationInfo().mEnterTransitionPostponed = false;
                return;
            }
            else if(Looper.myLooper() != this.mHost.getHandler().getLooper()) {
                this.mHost.getHandler().postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        Fragment.this.callStartTransitionListener(false);
                    }
                });
                return;
            }
            else {
                this.callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append(this.getClass().getSimpleName());
        v0.append("{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append("} (");
        v0.append(this.mWho);
        if(this.mFragmentId != 0) {
            v0.append(" id=0x");
            v0.append(Integer.toHexString(this.mFragmentId));
        }

        if(this.mTag != null) {
            v0.append(" tag=");
            v0.append(this.mTag);
        }

        v0.append(")");
        return v0.toString();
    }

    public void unregisterForContextMenu(View arg1) {
        arg1.setOnCreateContextMenuListener(null);
    }
}

