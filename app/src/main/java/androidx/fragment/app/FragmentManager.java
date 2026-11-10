package androidx.fragment.app;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater$Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest$Builder;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager implements FragmentResultOwner {
    class androidx.fragment.app.FragmentManager$1 extends OnBackPressedCallback {
        androidx.fragment.app.FragmentManager$1(FragmentManager arg1, boolean arg2) {
            FragmentManager.this = arg1;
            super(arg2);
        }

        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    }

    class androidx.fragment.app.FragmentManager$2 implements Callback {
        androidx.fragment.app.FragmentManager$2(FragmentManager arg1) {
            FragmentManager.this = arg1;
            super();
        }

        public void onComplete(Fragment arg2, CancellationSignal arg3) {
            if(!arg3.isCanceled()) {
                FragmentManager.this.removeCancellationSignal(arg2, arg3);
            }
        }

        public void onStart(Fragment arg1, CancellationSignal arg2) {
            FragmentManager.this.addCancellationSignal(arg1, arg2);
        }
    }

    class androidx.fragment.app.FragmentManager$3 extends FragmentFactory {
        androidx.fragment.app.FragmentManager$3(FragmentManager arg1) {
            FragmentManager.this = arg1;
            super();
        }

        public Fragment instantiate(ClassLoader arg2, String arg3) {
            return FragmentManager.this.getHost().instantiate(FragmentManager.this.getHost().getContext(), arg3, null);
        }
    }

    class androidx.fragment.app.FragmentManager$4 implements SpecialEffectsControllerFactory {
        androidx.fragment.app.FragmentManager$4(FragmentManager arg1) {
            FragmentManager.this = arg1;
            super();
        }

        public SpecialEffectsController createController(ViewGroup arg1) {
            return new DefaultSpecialEffectsController(arg1);
        }
    }

    class androidx.fragment.app.FragmentManager$5 implements Runnable {
        androidx.fragment.app.FragmentManager$5(FragmentManager arg1) {
            FragmentManager.this = arg1;
            super();
        }

        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    }

    public interface BackStackEntry {
        @Deprecated CharSequence getBreadCrumbShortTitle();

        @Deprecated int getBreadCrumbShortTitleRes();

        @Deprecated CharSequence getBreadCrumbTitle();

        @Deprecated int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    class FragmentIntentSenderContract extends ActivityResultContract {
        FragmentIntentSenderContract() {
            super();
        }

        public Intent createIntent(Context arg3, IntentSenderRequest arg4) {
            Intent v2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent v3 = arg4.getFillInIntent();
            if(v3 != null) {
                String v0 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
                Bundle v1 = v3.getBundleExtra(v0);
                if(v1 != null) {
                    v2.putExtra(v0, v1);
                    v3.removeExtra(v0);
                    if(v3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        arg4 = new Builder(arg4.getIntentSender()).setFillInIntent(null).setFlags(arg4.getFlagsValues(), arg4.getFlagsMask()).build();
                    }
                }
            }

            v2.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", ((Parcelable)arg4));
            if(FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + v2);
            }

            return v2;
        }

        public Intent createIntent(Context arg1, Object arg2) {
            return this.createIntent(arg1, ((IntentSenderRequest)arg2));
        }

        public ActivityResult parseResult(int arg1, Intent arg2) {
            return new ActivityResult(arg1, arg2);
        }

        public Object parseResult(int arg1, Intent arg2) {
            return this.parseResult(arg1, arg2);
        }
    }

    public abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
            super();
        }

        @Deprecated public void onFragmentActivityCreated(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentAttached(FragmentManager arg1, Fragment arg2, Context arg3) {
        }

        public void onFragmentCreated(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentDestroyed(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentDetached(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentPaused(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentPreAttached(FragmentManager arg1, Fragment arg2, Context arg3) {
        }

        public void onFragmentPreCreated(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentResumed(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentSaveInstanceState(FragmentManager arg1, Fragment arg2, Bundle arg3) {
        }

        public void onFragmentStarted(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentStopped(FragmentManager arg1, Fragment arg2) {
        }

        public void onFragmentViewCreated(FragmentManager arg1, Fragment arg2, View arg3, Bundle arg4) {
        }

        public void onFragmentViewDestroyed(FragmentManager arg1, Fragment arg2) {
        }
    }

    class LaunchedFragmentInfo implements Parcelable {
        class androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1 implements Parcelable$Creator {
            androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1() {
                super();
            }

            public LaunchedFragmentInfo createFromParcel(Parcel arg1) {
                return new LaunchedFragmentInfo(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public LaunchedFragmentInfo[] newArray(int arg1) {
                return new LaunchedFragmentInfo[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        int mRequestCode;
        String mWho;

        static {
            LaunchedFragmentInfo.CREATOR = new androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1();
        }

        LaunchedFragmentInfo(String arg1, int arg2) {
            super();
            this.mWho = arg1;
            this.mRequestCode = arg2;
        }

        LaunchedFragmentInfo(Parcel arg2) {
            super();
            this.mWho = arg2.readString();
            this.mRequestCode = arg2.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            arg1.writeString(this.mWho);
            arg1.writeInt(this.mRequestCode);
        }
    }

    class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(Lifecycle arg1, FragmentResultListener arg2, LifecycleEventObserver arg3) {
            super();
            this.mLifecycle = arg1;
            this.mListener = arg2;
            this.mObserver = arg3;
        }

        public boolean isAtLeast(State arg1) {
            return this.mLifecycle.getCurrentState().isAtLeast(arg1);
        }

        public void onFragmentResult(String arg1, Bundle arg2) {
            this.mListener.onFragmentResult(arg1, arg2);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(ArrayList arg1, ArrayList arg2);
    }

    class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(FragmentManager arg1, String arg2, int arg3, int arg4) {
            FragmentManager.this = arg1;
            super();
            this.mName = arg2;
            this.mId = arg3;
            this.mFlags = arg4;
        }

        public boolean generateOps(ArrayList arg7, ArrayList arg8) {
            if(FragmentManager.this.mPrimaryNav != null && this.mId < 0 && this.mName == null && (FragmentManager.this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
                return 0;
            }

            return FragmentManager.this.popBackStackState(arg7, arg8, this.mName, this.mId, this.mFlags);
        }
    }

    class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord arg1, boolean arg2) {
            super();
            this.mIsBack = arg2;
            this.mRecord = arg1;
        }

        void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }

        void completeTransaction() {
            int v0 = this.mNumPostponed > 0 ? 1 : 0;
            Iterator v2 = this.mRecord.mManager.getFragments().iterator();
            while(v2.hasNext()) {
                Object v3 = v2.next();
                ((Fragment)v3).setOnStartEnterTransitionListener(null);
                if(v0 == 0) {
                    continue;
                }

                if(!((Fragment)v3).isPostponed()) {
                    continue;
                }

                ((Fragment)v3).startPostponedEnterTransition();
            }

            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, v0 ^ 1, true);
        }

        public boolean isReady() {
            if(this.mNumPostponed == 0) {
                return 1;
            }

            return 0;
        }

        public void onStartEnterTransition() {
            int v0 = this.mNumPostponed - 1;
            this.mNumPostponed = v0;
            if(v0 != 0) {
                return;
            }

            this.mRecord.mManager.scheduleCommit();
        }

        public void startListening() {
            ++this.mNumPostponed;
        }
    }

    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    static boolean USE_STATE_MANAGER = true;
    ArrayList mBackStack;
    private ArrayList mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private FragmentContainer mContainer;
    private ArrayList mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private Map mExitAnimationCancellationSignals;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private final Callback mFragmentTransitionCallback;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList mPendingActions;
    private ArrayList mPostponedTransactions;
    Fragment mPrimaryNav;
    private ActivityResultLauncher mRequestPermissions;
    private final Map mResultListeners;
    private final Map mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher mStartActivityForResult;
    private ActivityResultLauncher mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList mTmpAddedFragments;
    private ArrayList mTmpIsPop;
    private ArrayList mTmpRecords;

    static {
    }

    public FragmentManager() {
        super();
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        this.mOnBackPressedCallback = new androidx.fragment.app.FragmentManager$1(this, false);
        this.mBackStackIndex = new AtomicInteger();
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());
        this.mFragmentTransitionCallback = new androidx.fragment.app.FragmentManager$2(this);
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new androidx.fragment.app.FragmentManager$3(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new androidx.fragment.app.FragmentManager$4(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new androidx.fragment.app.FragmentManager$5(this);
    }

    static Map access$000(FragmentManager arg0) {
        return arg0.mResults;
    }

    static Map access$100(FragmentManager arg0) {
        return arg0.mResultListeners;
    }

    static FragmentStore access$200(FragmentManager arg0) {
        return arg0.mFragmentStore;
    }

    private void addAddedFragments(ArraySet arg5) {
        int v0 = this.mCurState;
        if(v0 < 1) {
        }
        else {
            v0 = Math.min(v0, 5);
            Iterator v1 = this.mFragmentStore.getFragments().iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                if(((Fragment)v2).mState >= v0) {
                    continue;
                }

                this.moveToState(((Fragment)v2), v0);
                if(((Fragment)v2).mView == null) {
                    continue;
                }

                if(((Fragment)v2).mHidden) {
                    continue;
                }

                if(!((Fragment)v2).mIsNewlyAdded) {
                    continue;
                }

                arg5.add(v2);
            }
        }
    }

    void addBackStackState(BackStackRecord arg2) {
        ArrayList v0 = this.mBackStack;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mBackStack = v0;
        }

        v0.add(arg2);
    }

    void addCancellationSignal(Fragment arg3, CancellationSignal arg4) {
        if(this.mExitAnimationCancellationSignals.get(arg3) == null) {
            this.mExitAnimationCancellationSignals.put(arg3, new HashSet());
        }

        this.mExitAnimationCancellationSignals.get(arg3).add(arg4);
    }

    FragmentStateManager addFragment(Fragment arg4) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "add: " + arg4);
        }

        FragmentStateManager v0 = this.createOrGetFragmentStateManager(arg4);
        arg4.mFragmentManager = this;
        this.mFragmentStore.makeActive(v0);
        if(!arg4.mDetached) {
            this.mFragmentStore.addFragment(arg4);
            arg4.mRemoving = false;
            if(arg4.mView == null) {
                arg4.mHiddenChanged = false;
            }

            if(!this.isMenuAvailable(arg4)) {
                return v0;
            }

            this.mNeedMenuInvalidate = true;
        }

        return v0;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener arg1) {
        this.mOnAttachListeners.add(arg1);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener arg2) {
        ArrayList v0 = this.mBackStackChangeListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mBackStackChangeListeners = v0;
        }

        v0.add(arg2);
    }

    void addRetainedFragment(Fragment arg1) {
        this.mNonConfig.addRetainedFragment(arg1);
    }

    int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    void attachController(FragmentHostCallback arg3, FragmentContainer arg4, Fragment arg5) {
        FragmentManagerViewModel v3;
        if(this.mHost == null) {
            this.mHost = arg3;
            this.mContainer = arg4;
            this.mParent = arg5;
            if(arg5 != null) {
                this.addFragmentOnAttachListener(new FragmentOnAttachListener(arg5) {
                    public void onAttachFragment(FragmentManager arg1, Fragment arg2) {
                        this.val$parent.onAttachFragment(arg2);
                    }
                });
            }
            else if((arg3 instanceof FragmentOnAttachListener)) {
                this.addFragmentOnAttachListener(arg3);
            }

            if(this.mParent != null) {
                this.updateOnBackPressedCallbackEnabled();
            }

            if((arg3 instanceof OnBackPressedDispatcherOwner)) {
                FragmentHostCallback v4 = arg3;
                OnBackPressedDispatcher v0 = ((OnBackPressedDispatcherOwner)v4).getOnBackPressedDispatcher();
                this.mOnBackPressedDispatcher = v0;
                if(arg5 != null) {
                    Fragment v4_1 = arg5;
                }

                v0.addCallback(((LifecycleOwner)v4), this.mOnBackPressedCallback);
            }

            if(arg5 != null) {
                v3 = arg5.mFragmentManager.getChildNonConfig(arg5);
                this.mNonConfig = v3;
            }
            else if((arg3 instanceof ViewModelStoreOwner)) {
                v3 = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner)arg3).getViewModelStore());
                this.mNonConfig = v3;
            }
            else {
                v3 = new FragmentManagerViewModel(false);
                this.mNonConfig = v3;
            }

            v3.setIsStateSaved(this.isStateSaved());
            this.mFragmentStore.setNonConfig(this.mNonConfig);
            arg3 = this.mHost;
            if((arg3 instanceof ActivityResultRegistryOwner)) {
                ActivityResultRegistry v3_1 = ((ActivityResultRegistryOwner)arg3).getActivityResultRegistry();
                String v4_2 = arg5 != null ? arg5.mWho + ":" : "";
                v4_2 = "FragmentManager:" + v4_2;
                this.mStartActivityForResult = v3_1.register(v4_2 + "StartActivityForResult", new StartActivityForResult(), new ActivityResultCallback() {
                    public void onActivityResult(ActivityResult arg4) {
                        Object v0 = FragmentManager.this.mLaunchedFragments.pollFirst();
                        String v1 = "FragmentManager";
                        if(v0 == null) {
                            Log.w(v1, "No Activities were started for result for " + this);
                            return;
                        }

                        String v2 = ((LaunchedFragmentInfo)v0).mWho;
                        int v0_1 = ((LaunchedFragmentInfo)v0).mRequestCode;
                        Fragment v3 = FragmentManager.this.mFragmentStore.findFragmentByWho(v2);
                        if(v3 == null) {
                            Log.w(v1, "Activity result delivered for unknown Fragment " + v2);
                            return;
                        }

                        v3.onActivityResult(v0_1, arg4.getResultCode(), arg4.getData());
                    }

                    public void onActivityResult(Object arg1) {
                        this.onActivityResult(((ActivityResult)arg1));
                    }
                });
                this.mStartIntentSenderForResult = v3_1.register(v4_2 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new ActivityResultCallback() {
                    public void onActivityResult(ActivityResult arg4) {
                        Object v0 = FragmentManager.this.mLaunchedFragments.pollFirst();
                        String v1 = "FragmentManager";
                        if(v0 == null) {
                            Log.w(v1, "No IntentSenders were started for " + this);
                            return;
                        }

                        String v2 = ((LaunchedFragmentInfo)v0).mWho;
                        int v0_1 = ((LaunchedFragmentInfo)v0).mRequestCode;
                        Fragment v3 = FragmentManager.this.mFragmentStore.findFragmentByWho(v2);
                        if(v3 == null) {
                            Log.w(v1, "Intent Sender result delivered for unknown Fragment " + v2);
                            return;
                        }

                        v3.onActivityResult(v0_1, arg4.getResultCode(), arg4.getData());
                    }

                    public void onActivityResult(Object arg1) {
                        this.onActivityResult(((ActivityResult)arg1));
                    }
                });
                this.mRequestPermissions = v3_1.register(v4_2 + "RequestPermissions", new RequestMultiplePermissions(), new ActivityResultCallback() {
                    public void onActivityResult(Object arg1) {
                        this.onActivityResult(((Map)arg1));
                    }

                    public void onActivityResult(Map arg6) {
                        Object[] v0 = arg6.keySet().toArray(new String[0]);
                        ArrayList v2 = new ArrayList(arg6.values());
                        int[] v6 = new int[v2.size()];
                        int v3;
                        for(v3 = 0; v3 < v2.size(); ++v3) {
                            int v4 = v2.get(v3).booleanValue() ? 0 : -1;
                            v6[v3] = v4;
                        }

                        Object v1 = FragmentManager.this.mLaunchedFragments.pollFirst();
                        String v2_1 = "FragmentManager";
                        if(v1 == null) {
                            Log.w(v2_1, "No permissions were requested for " + this);
                            return;
                        }

                        String v3_1 = ((LaunchedFragmentInfo)v1).mWho;
                        int v1_1 = ((LaunchedFragmentInfo)v1).mRequestCode;
                        Fragment v5 = FragmentManager.this.mFragmentStore.findFragmentByWho(v3_1);
                        if(v5 == null) {
                            Log.w(v2_1, "Permission request result delivered for unknown Fragment " + v3_1);
                            return;
                        }

                        v5.onRequestPermissionsResult(v1_1, ((String[])v0), v6);
                    }
                });
            }

            return;
        }

        throw new IllegalStateException("Already attached");
    }

    void attachFragment(Fragment arg5) {
        int v0 = 2;
        String v2 = "FragmentManager";
        if(FragmentManager.isLoggingEnabled(v0)) {
            Log.v(v2, "attach: " + arg5);
        }

        if(arg5.mDetached) {
            arg5.mDetached = false;
            if(!arg5.mAdded) {
                this.mFragmentStore.addFragment(arg5);
                if(FragmentManager.isLoggingEnabled(v0)) {
                    Log.v(v2, "add from attach: " + arg5);
                }

                if(!this.isMenuAvailable(arg5)) {
                    return;
                }

                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    private void cancelExitAnimation(Fragment arg4) {
        Object v0 = this.mExitAnimationCancellationSignals.get(arg4);
        if(v0 != null) {
            Iterator v1 = ((HashSet)v0).iterator();
            while(v1.hasNext()) {
                v1.next().cancel();
            }

            ((HashSet)v0).clear();
            this.destroyFragmentView(arg4);
            this.mExitAnimationCancellationSignals.remove(arg4);
        }
    }

    boolean checkForMenus() {
        Iterator v0 = this.mFragmentStore.getActiveFragments().iterator();
        boolean v2 = false;
        do {
            if(!v0.hasNext()) {
                return 0;
            }

            Object v3 = v0.next();
            if(v3 != null) {
                v2 = this.isMenuAvailable(((Fragment)v3));
            }
        }
        while(!v2);

        return 1;
    }

    private void checkStateLoss() {
        if(!this.isStateSaved()) {
            return;
        }

        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final void clearFragmentResult(String arg1) {
        this.mResults.remove(arg1);
    }

    public final void clearFragmentResultListener(String arg1) {
        Object v0 = this.mResultListeners.remove(arg1);
        if(v0 != null) {
            ((LifecycleAwareResultListener)v0).removeObserver();
        }
    }

    private Set collectAllSpecialEffectsController() {
        HashSet v0 = new HashSet();
        Iterator v1 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while(v1.hasNext()) {
            ViewGroup v2 = v1.next().getFragment().mContainer;
            if(v2 == null) {
                continue;
            }

            ((Set)v0).add(SpecialEffectsController.getOrCreateController(v2, this.getSpecialEffectsControllerFactory()));
        }

        return ((Set)v0);
    }

    private Set collectChangedControllers(ArrayList arg4, int arg5, int arg6) {
        HashSet v0 = new HashSet();
        while(arg5 < arg6) {
            Iterator v1 = arg4.get(arg5).mOps.iterator();
            while(v1.hasNext()) {
                Fragment v2 = v1.next().mFragment;
                if(v2 == null) {
                    continue;
                }

                ViewGroup v2_1 = v2.mContainer;
                if(v2_1 == null) {
                    continue;
                }

                ((Set)v0).add(SpecialEffectsController.getOrCreateController(v2_1, this));
            }

            ++arg5;
        }

        return ((Set)v0);
    }

    void completeExecute(BackStackRecord arg10, boolean arg11, boolean arg12, boolean arg13) {
        if(arg11) {
            arg10.executePopOps(arg13);
        }
        else {
            arg10.executeOps();
        }

        ArrayList v2 = new ArrayList(1);
        ArrayList v3 = new ArrayList(1);
        v2.add(arg10);
        v3.add(Boolean.valueOf(arg11));
        if((arg12) && this.mCurState >= 1) {
            FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, v2, v3, 0, 1, true, this.mFragmentTransitionCallback);
        }

        if(arg13) {
            this.moveToState(this.mCurState, true);
        }

        Iterator v9 = this.mFragmentStore.getActiveFragments().iterator();
        while(v9.hasNext()) {
            Object v11 = v9.next();
            if(v11 == null) {
                continue;
            }

            if(((Fragment)v11).mView == null) {
                continue;
            }

            if(!((Fragment)v11).mIsNewlyAdded) {
                continue;
            }

            if(!arg10.interactsWith(((Fragment)v11).mContainerId)) {
                continue;
            }

            if(((Fragment)v11).mPostponedAlpha > 0f) {
                ((Fragment)v11).mView.setAlpha(((Fragment)v11).mPostponedAlpha);
            }

            if(arg13) {
                ((Fragment)v11).mPostponedAlpha = 0f;
                continue;
            }

            ((Fragment)v11).mPostponedAlpha = -1f;
            ((Fragment)v11).mIsNewlyAdded = false;
        }
    }

    private void completeShowHideFragment(Fragment arg7) {
        if(arg7.mView != null) {
            AnimationOrAnimator v0 = FragmentAnim.loadAnimation(this.mHost.getContext(), arg7, arg7.mHidden ^ 1, arg7.getPopDirection());
            if(v0 != null && v0.animator != null) {
                v0.animator.setTarget(arg7.mView);
                if(!arg7.mHidden) {
                    arg7.mView.setVisibility(0);
                }
                else if(arg7.isHideReplaced()) {
                    arg7.setHideReplaced(false);
                }
                else {
                    ViewGroup v2 = arg7.mContainer;
                    View v3 = arg7.mView;
                    v2.startViewTransition(v3);
                    v0.animator.addListener(new AnimatorListenerAdapter(v2, v3, arg7) {
                        public void onAnimationEnd(Animator arg3) {
                            this.val$container.endViewTransition(this.val$animatingView);
                            arg3.removeListener(((Animator$AnimatorListener)this));
                            if(this.val$fragment.mView != null && (this.val$fragment.mHidden)) {
                                this.val$fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }

                v0.animator.start();
                goto label_52;
            }

            if(v0 != null) {
                arg7.mView.startAnimation(v0.animation);
                v0.animation.start();
            }

            int v0_1 = !arg7.mHidden || (arg7.isHideReplaced()) ? 0 : 8;
            arg7.mView.setVisibility(v0_1);
            if(!arg7.isHideReplaced()) {
                goto label_52;
            }

            arg7.setHideReplaced(false);
        }

    label_52:
        this.invalidateMenuForFragment(arg7);
        arg7.mHiddenChanged = false;
        arg7.onHiddenChanged(arg7.mHidden);
    }

    FragmentStateManager createOrGetFragmentStateManager(Fragment arg4) {
        FragmentStateManager v0 = this.mFragmentStore.getFragmentStateManager(arg4.mWho);
        if(v0 != null) {
            return v0;
        }

        v0 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, arg4);
        v0.restoreState(this.mHost.getContext().getClassLoader());
        v0.setFragmentManagerState(this.mCurState);
        return v0;
    }

    private void destroyFragmentView(Fragment arg3) {
        arg3.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(arg3, false);
        arg3.mContainer = null;
        arg3.mView = null;
        arg3.mViewLifecycleOwner = null;
        arg3.mViewLifecycleOwnerLiveData.setValue(null);
        arg3.mInLayout = false;
    }

    void detachFragment(Fragment arg5) {
        int v0 = 2;
        String v2 = "FragmentManager";
        if(FragmentManager.isLoggingEnabled(v0)) {
            Log.v(v2, "detach: " + arg5);
        }

        if(!arg5.mDetached) {
            arg5.mDetached = true;
            if(arg5.mAdded) {
                if(FragmentManager.isLoggingEnabled(v0)) {
                    Log.v(v2, "remove from detach: " + arg5);
                }

                this.mFragmentStore.removeFragment(arg5);
                if(this.isMenuAvailable(arg5)) {
                    this.mNeedMenuInvalidate = true;
                }

                this.setVisibleRemovingFragment(arg5);
            }
        }
    }

    void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(4);
    }

    void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(0);
    }

    void dispatchConfigurationChanged(Configuration arg2) {
        Iterator v1 = this.mFragmentStore.getFragments().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((Fragment)v0).performConfigurationChanged(arg2);
        }
    }

    boolean dispatchContextItemSelected(MenuItem arg4) {
        if(this.mCurState < 1) {
            return 0;
        }

        Iterator v3 = this.mFragmentStore.getFragments().iterator();
        do {
        label_8:
            if(!v3.hasNext()) {
                return 0;
            }

            Object v0 = v3.next();
            if(v0 == null) {
                goto label_8;
            }
        }
        while(!((Fragment)v0).performContextItemSelected(arg4));

        return 1;
    }

    void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(1);
    }

    boolean dispatchCreateOptionsMenu(Menu arg8, MenuInflater arg9) {
        int v1 = 0;
        if(this.mCurState < 1) {
            return 0;
        }

        Iterator v0 = this.mFragmentStore.getFragments().iterator();
        ArrayList v3 = null;
        boolean v4;
        for(v4 = false; v0.hasNext(); v4 = true) {
            Object v5 = v0.next();
            if(v5 == null) {
                continue;
            }

            if(!this.isParentMenuVisible(((Fragment)v5))) {
                continue;
            }

            if(!((Fragment)v5).performCreateOptionsMenu(arg8, arg9)) {
                continue;
            }

            if(v3 == null) {
                v3 = new ArrayList();
            }

            v3.add(v5);
        }

        if(this.mCreatedMenus != null) {
            while(v1 < this.mCreatedMenus.size()) {
                Object v8 = this.mCreatedMenus.get(v1);
                if(v3 == null || !v3.contains(v8)) {
                    ((Fragment)v8).onDestroyOptionsMenu();
                }

                ++v1;
            }
        }

        this.mCreatedMenus = v3;
        return v4;
    }

    void dispatchDestroy() {
        this.mDestroyed = true;
        this.execPendingActions(true);
        this.endAnimatingAwayFragments();
        this.dispatchStateChange(-1);
        FragmentHostCallback v0 = null;
        this.mHost = v0;
        this.mContainer = ((FragmentContainer)v0);
        this.mParent = ((Fragment)v0);
        if(this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = ((OnBackPressedDispatcher)v0);
        }

        ActivityResultLauncher v0_1 = this.mStartActivityForResult;
        if(v0_1 != null) {
            v0_1.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    void dispatchDestroyView() {
        this.dispatchStateChange(1);
    }

    void dispatchLowMemory() {
        Iterator v1 = this.mFragmentStore.getFragments().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((Fragment)v0).performLowMemory();
        }
    }

    void dispatchMultiWindowModeChanged(boolean arg2) {
        Iterator v1 = this.mFragmentStore.getFragments().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((Fragment)v0).performMultiWindowModeChanged(arg2);
        }
    }

    void dispatchOnAttachFragment(Fragment arg3) {
        Iterator v0 = this.mOnAttachListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onAttachFragment(this, arg3);
        }
    }

    boolean dispatchOptionsItemSelected(MenuItem arg4) {
        if(this.mCurState < 1) {
            return 0;
        }

        Iterator v3 = this.mFragmentStore.getFragments().iterator();
        do {
        label_8:
            if(!v3.hasNext()) {
                return 0;
            }

            Object v0 = v3.next();
            if(v0 == null) {
                goto label_8;
            }
        }
        while(!((Fragment)v0).performOptionsItemSelected(arg4));

        return 1;
    }

    void dispatchOptionsMenuClosed(Menu arg3) {
        if(this.mCurState < 1) {
        }
        else {
            Iterator v2 = this.mFragmentStore.getFragments().iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                if(v0 == null) {
                    continue;
                }

                ((Fragment)v0).performOptionsMenuClosed(arg3);
            }
        }
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment arg2) {
        if(arg2 != null && (arg2.equals(this.findActiveFragment(arg2.mWho)))) {
            arg2.performPrimaryNavigationFragmentChanged();
        }
    }

    void dispatchPause() {
        this.dispatchStateChange(5);
    }

    void dispatchPictureInPictureModeChanged(boolean arg2) {
        Iterator v1 = this.mFragmentStore.getFragments().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
            if(v0 == null) {
                continue;
            }

            ((Fragment)v0).performPictureInPictureModeChanged(arg2);
        }
    }

    boolean dispatchPrepareOptionsMenu(Menu arg6) {
        boolean v1 = false;
        if(this.mCurState < 1) {
            return 0;
        }

        Iterator v0 = this.mFragmentStore.getFragments().iterator();
        while(v0.hasNext()) {
            Object v3 = v0.next();
            if(v3 == null) {
                continue;
            }

            if(!this.isParentMenuVisible(((Fragment)v3))) {
                continue;
            }

            if(!((Fragment)v3).performPrepareOptionsMenu(arg6)) {
                continue;
            }

            v1 = true;
        }

        return v1;
    }

    void dispatchPrimaryNavigationFragmentChanged() {
        this.updateOnBackPressedCallbackEnabled();
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(7);
    }

    void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(5);
    }

    private void dispatchStateChange(int arg4) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(arg4);
            this.moveToState(arg4, false);
            if(FragmentManager.USE_STATE_MANAGER) {
                Iterator v4_1 = this.collectAllSpecialEffectsController().iterator();
                while(v4_1.hasNext()) {
                    v4_1.next().forceCompleteAllOperations();
                }
            }
        }
        catch(Throwable v4) {
            this.mExecutingActions = false;
            throw v4;
        }

        this.mExecutingActions = false;
        this.execPendingActions(true);
    }

    void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        this.dispatchStateChange(4);
    }

    void dispatchViewCreated() {
        this.dispatchStateChange(2);
    }

    private void doPendingDeferredStart() {
        if(this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            this.startPendingDeferredFragments();
        }
    }

    public void dump(String arg5, FileDescriptor arg6, PrintWriter arg7, String[] arg8) {
        Object v2;
        int v6_1;
        String v0 = arg5 + "    ";
        this.mFragmentStore.dump(arg5, arg6, arg7, arg8);
        ArrayList v6 = this.mCreatedMenus;
        int v8 = 0;
        if(v6 != null) {
            v6_1 = v6.size();
            if(v6_1 > 0) {
                arg7.print(arg5);
                arg7.println("Fragments Created Menus:");
                int v1;
                for(v1 = 0; v1 < v6_1; ++v1) {
                    v2 = this.mCreatedMenus.get(v1);
                    arg7.print(arg5);
                    arg7.print("  #");
                    arg7.print(v1);
                    arg7.print(": ");
                    arg7.println(((Fragment)v2).toString());
                }
            }
        }

        v6 = this.mBackStack;
        if(v6 != null) {
            v6_1 = v6.size();
            if(v6_1 > 0) {
                arg7.print(arg5);
                arg7.println("Back Stack:");
                for(v1 = 0; v1 < v6_1; ++v1) {
                    v2 = this.mBackStack.get(v1);
                    arg7.print(arg5);
                    arg7.print("  #");
                    arg7.print(v1);
                    arg7.print(": ");
                    arg7.println(((BackStackRecord)v2).toString());
                    ((BackStackRecord)v2).dump(v0, arg7);
                }
            }
        }

        arg7.print(arg5);
        arg7.println("Back Stack Index: " + this.mBackStackIndex.get());
        v6 = this.mPendingActions;
        __monitor_enter(v6);
        try {
            int v0_1 = this.mPendingActions.size();
            if(v0_1 > 0) {
                arg7.print(arg5);
                arg7.println("Pending Actions:");
                while(v8 < v0_1) {
                    Object v1_1 = this.mPendingActions.get(v8);
                    arg7.print(arg5);
                    arg7.print("  #");
                    arg7.print(v8);
                    arg7.print(": ");
                    arg7.println(v1_1);
                    ++v8;
                }
            }

            __monitor_exit(v6);
        }
        catch(Throwable v4) {
            try {
            label_128:
                __monitor_exit(v6);
            }
            catch(Throwable v4) {
                goto label_128;
            }

            throw v4;
        }

        arg7.print(arg5);
        arg7.println("FragmentManager misc state:");
        arg7.print(arg5);
        arg7.print("  mHost=");
        arg7.println(this.mHost);
        arg7.print(arg5);
        arg7.print("  mContainer=");
        arg7.println(this.mContainer);
        if(this.mParent != null) {
            arg7.print(arg5);
            arg7.print("  mParent=");
            arg7.println(this.mParent);
        }

        arg7.print(arg5);
        arg7.print("  mCurState=");
        arg7.print(this.mCurState);
        arg7.print(" mStateSaved=");
        arg7.print(this.mStateSaved);
        arg7.print(" mStopped=");
        arg7.print(this.mStopped);
        arg7.print(" mDestroyed=");
        arg7.println(this.mDestroyed);
        if(this.mNeedMenuInvalidate) {
            arg7.print(arg5);
            arg7.print("  mNeedMenuInvalidate=");
            arg7.println(this.mNeedMenuInvalidate);
        }
    }

    @Deprecated public static void enableDebugLogging(boolean arg0) {
        FragmentManager.DEBUG = arg0;
    }

    public static void enableNewStateManager(boolean arg0) {
        FragmentManager.USE_STATE_MANAGER = arg0;
    }

    private void endAnimatingAwayFragments() {
        if(FragmentManager.USE_STATE_MANAGER) {
            Iterator v2 = this.collectAllSpecialEffectsController().iterator();
            while(v2.hasNext()) {
                v2.next().forceCompleteAllOperations();
            }
        }
        else if(!this.mExitAnimationCancellationSignals.isEmpty()) {
            Iterator v0 = this.mExitAnimationCancellationSignals.keySet().iterator();
            while(v0.hasNext()) {
                Object v1 = v0.next();
                this.cancelExitAnimation(((Fragment)v1));
                this.moveToState(((Fragment)v1));
            }
        }
    }

    void enqueueAction(OpGenerator arg3, boolean arg4) {
        if(!arg4) {
            if(this.mHost != null) {
                this.checkStateLoss();
            }
            else if(this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }

        ArrayList v0 = this.mPendingActions;
        __monitor_enter(v0);
        try {
            if(this.mHost == null) {
                if(arg4) {
                    __monitor_exit(v0);
                    return;
                }

                throw new IllegalStateException("Activity has been destroyed");
            }

            this.mPendingActions.add(arg3);
            this.scheduleCommit();
            __monitor_exit(v0);
            return;
        label_31:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_31;
        }

        throw v2;
    }

    private void ensureExecReady(boolean arg3) {
        if(!this.mExecutingActions) {
            if(this.mHost == null) {
                if(this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }

                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }

            if(Looper.myLooper() == this.mHost.getHandler().getLooper()) {
                if(!arg3) {
                    this.checkStateLoss();
                }

                if(this.mTmpRecords == null) {
                    this.mTmpRecords = new ArrayList();
                    this.mTmpIsPop = new ArrayList();
                }

                this.mExecutingActions = true;
                ArrayList v0 = null;
                try {
                    this.executePostponedTransaction(v0, v0);
                }
                catch(Throwable v0_1) {
                    this.mExecutingActions = false;
                    throw v0_1;
                }

                this.mExecutingActions = false;
                return;
            }

            throw new IllegalStateException("Must be called from main thread of fragment host");
        }

        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    boolean execPendingActions(boolean arg3) {
        this.ensureExecReady(arg3);
        arg3 = false;
        while(this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            arg3 = true;
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            catch(Throwable v3) {
                this.cleanupExec();
                throw v3;
            }

            this.cleanupExec();
        }

        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return arg3;
    }

    void execSingleAction(OpGenerator arg2, boolean arg3) {
        if((arg3) && (this.mHost == null || (this.mDestroyed))) {
            return;
        }

        this.ensureExecReady(arg3);
        if(arg2.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            }
            catch(Throwable v2) {
                this.cleanupExec();
                throw v2;
            }

            this.cleanupExec();
        }

        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
    }

    private static void executeOps(ArrayList arg3, ArrayList arg4, int arg5, int arg6) {
        while(arg5 < arg6) {
            Object v0 = arg3.get(arg5);
            boolean v2 = true;
            if(arg4.get(arg5).booleanValue()) {
                ((BackStackRecord)v0).bumpBackStackNesting(-1);
                if(arg5 == arg6 - 1) {
                }
                else {
                    v2 = false;
                }

                ((BackStackRecord)v0).executePopOps(v2);
            }
            else {
                ((BackStackRecord)v0).bumpBackStackNesting(1);
                ((BackStackRecord)v0).executeOps();
            }

            ++arg5;
        }
    }

    private void executeOpsTogether(ArrayList arg13, ArrayList arg14, int arg15, int arg16) {
        int v11_1;
        Iterator v1;
        int v0_2;
        Object v6;
        int v4 = arg15;
        int v5 = arg16;
        boolean v8 = arg13.get(arg15).mReorderingAllowed;
        ArrayList v0 = this.mTmpAddedFragments;
        if(v0 == null) {
            this.mTmpAddedFragments = new ArrayList();
        }
        else {
            v0.clear();
        }

        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment v0_1 = this.getPrimaryNavigationFragment();
        int v9 = 0;
        int v2;
        for(v2 = v4; v2 < v5; ++v2) {
            v6 = arg13.get(v2);
            boolean v7 = arg14.get(v2).booleanValue();
            ArrayList v11 = this.mTmpAddedFragments;
            v0_1 = !v7 ? ((BackStackRecord)v6).expandOps(v11, v0_1) : ((BackStackRecord)v6).trackAddedFragmentsInPop(v11, v0_1);
            v9 = v9 != 0 || (((BackStackRecord)v6).mAddToBackStack) ? 1 : 0;
        }

        this.mTmpAddedFragments.clear();
        if(!v8 && this.mCurState >= 1) {
            if(FragmentManager.USE_STATE_MANAGER) {
                v0_2 = v4;
                goto label_46;
            }
            else {
                FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, arg13, arg14, v4, v5, false, this.mFragmentTransitionCallback);
                goto label_71;
            label_46:
                while(v0_2 < v5) {
                    v1 = arg13.get(v0_2).mOps.iterator();
                    while(v1.hasNext()) {
                        Fragment v2_1 = v1.next().mFragment;
                        if(v2_1 == null) {
                            continue;
                        }

                        if(v2_1.mFragmentManager == null) {
                            continue;
                        }

                        this.mFragmentStore.makeActive(this.createOrGetFragmentStateManager(v2_1));
                    }

                    ++v0_2;
                }
            }
        }

    label_71:
        FragmentManager.executeOps(arg13, arg14, arg15, arg16);
        if(FragmentManager.USE_STATE_MANAGER) {
            boolean v0_3 = arg14.get(v5 - 1).booleanValue();
            int v1_1;
            for(v1_1 = v4; v1_1 < v5; ++v1_1) {
                v6 = arg13.get(v1_1);
                if(v0_3) {
                    int v7_1;
                    for(v7_1 = ((BackStackRecord)v6).mOps.size() - 1; v7_1 >= 0; --v7_1) {
                        Fragment v8_1 = ((BackStackRecord)v6).mOps.get(v7_1).mFragment;
                        if(v8_1 != null) {
                            this.createOrGetFragmentStateManager(v8_1).moveToExpectedState();
                        }
                    }
                }
                else {
                    Iterator v6_1 = ((BackStackRecord)v6).mOps.iterator();
                    while(v6_1.hasNext()) {
                        Fragment v7_2 = v6_1.next().mFragment;
                        if(v7_2 == null) {
                            continue;
                        }

                        this.createOrGetFragmentStateManager(v7_2).moveToExpectedState();
                    }
                }
            }

            this.moveToState(this.mCurState, true);
            v1 = this.collectChangedControllers(arg13, arg15, v5).iterator();
            while(v1.hasNext()) {
                v6 = v1.next();
                ((SpecialEffectsController)v6).updateOperationDirection(v0_3);
                ((SpecialEffectsController)v6).markPostponedState();
                ((SpecialEffectsController)v6).executePendingOperations();
            }

            v11_1 = v5;
        }
        else {
            if(v8) {
                ArraySet v5_1 = new ArraySet();
                this.addAddedFragments(v5_1);
                int v6_2 = this.postponePostponableTransactions(arg13, arg14, v4, arg16, v5_1);
                v11_1 = arg16;
                v4 = v4;
                this.makeRemovedFragmentsInvisible(v5_1);
                v5 = v6_2;
            }
            else {
                v11_1 = v5;
            }

            if(v5 == v4) {
                goto label_148;
            }

            if(!v8) {
                goto label_148;
            }

            if(this.mCurState >= 1) {
                FragmentTransition.startTransitions(this.mHost.getContext(), this.mContainer, arg13, arg14, v4, v5, true, this.mFragmentTransitionCallback);
            }

            this.moveToState(this.mCurState, true);
        }

    label_148:
        for(v0_2 = arg15; v0_2 < v11_1; ++v0_2) {
            Object v1_2 = arg13.get(v0_2);
            if((arg14.get(v0_2).booleanValue()) && ((BackStackRecord)v1_2).mIndex >= 0) {
                ((BackStackRecord)v1_2).mIndex = -1;
            }

            ((BackStackRecord)v1_2).runOnCommitRunnables();
        }

        if(v9 != 0) {
            this.reportBackStackChanged();
        }
    }

    public boolean executePendingTransactions() {
        boolean v0 = this.execPendingActions(true);
        this.forcePostponedTransactions();
        return v0;
    }

    private void executePostponedTransaction(ArrayList arg8, ArrayList arg9) {
        int v5;
        ArrayList v0 = this.mPostponedTransactions;
        int v0_1 = v0 == null ? 0 : v0.size();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = this.mPostponedTransactions.get(v2);
            int v4 = -1;
            if(arg8 == null || (((StartEnterTransitionListener)v3).mIsBack)) {
            label_27:
                if(!((StartEnterTransitionListener)v3).isReady()) {
                    if(arg8 == null) {
                    }
                    else if(((StartEnterTransitionListener)v3).mRecord.interactsWith(arg8, 0, arg8.size())) {
                        goto label_34;
                    }

                    goto label_51;
                }

            label_34:
                this.mPostponedTransactions.remove(v2);
                --v2;
                --v0_1;
                if(arg8 != null && !((StartEnterTransitionListener)v3).mIsBack) {
                    v5 = arg8.indexOf(((StartEnterTransitionListener)v3).mRecord);
                    if(v5 != v4 && arg9 != null && (arg9.get(v5).booleanValue())) {
                        ((StartEnterTransitionListener)v3).cancelTransaction();
                        goto label_51;
                    }
                }

                ((StartEnterTransitionListener)v3).completeTransaction();
            }
            else {
                v5 = arg8.indexOf(((StartEnterTransitionListener)v3).mRecord);
                if(v5 == v4) {
                    goto label_27;
                }
                else if(arg9 == null) {
                    goto label_27;
                }
                else if(arg9.get(v5).booleanValue()) {
                    this.mPostponedTransactions.remove(v2);
                    --v2;
                    --v0_1;
                    ((StartEnterTransitionListener)v3).cancelTransaction();
                }
                else {
                    goto label_27;
                }
            }

        label_51:
        }
    }

    Fragment findActiveFragment(String arg1) {
        return this.mFragmentStore.findActiveFragment(arg1);
    }

    public static Fragment findFragment(View arg3) {
        Fragment v0 = FragmentManager.findViewFragment(arg3);
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("View " + arg3 + " does not have a Fragment set");
    }

    public Fragment findFragmentById(int arg1) {
        return this.mFragmentStore.findFragmentById(arg1);
    }

    public Fragment findFragmentByTag(String arg1) {
        return this.mFragmentStore.findFragmentByTag(arg1);
    }

    Fragment findFragmentByWho(String arg1) {
        return this.mFragmentStore.findFragmentByWho(arg1);
    }

    static FragmentManager findFragmentManager(View arg4) {
        Fragment v0 = FragmentManager.findViewFragment(arg4);
        if(v0 != null) {
            if(v0.isAdded()) {
                return v0.getChildFragmentManager();
            }

            throw new IllegalStateException("The Fragment " + v0 + " that owns View " + arg4 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }

        Context v0_1 = arg4.getContext();
        while(true) {
            if(!(v0_1 instanceof ContextWrapper)) {
                break;
            }
            else if((v0_1 instanceof FragmentActivity)) {
            }
            else {
                v0_1 = ((ContextWrapper)v0_1).getBaseContext();
                continue;
            }

            goto label_28;
        }

        v0_1 = null;
    label_28:
        if(v0_1 != null) {
            return ((FragmentActivity)v0_1).getSupportFragmentManager();
        }

        throw new IllegalStateException("View " + arg4 + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment findViewFragment(View arg2) {
        View v0;
        while(true) {
            v0 = null;
            if(arg2 == null) {
                break;
            }

            Fragment v1 = FragmentManager.getViewFragment(arg2);
            if(v1 != null) {
                return v1;
            }

            ViewParent v2 = ((View)v2).getParent();
            if((v2 instanceof View)) {
                continue;
            }

            arg2 = v0;
        }

        return ((Fragment)v0);
    }

    private void forcePostponedTransactions() {
        if(FragmentManager.USE_STATE_MANAGER) {
            Iterator v2 = this.collectAllSpecialEffectsController().iterator();
            while(v2.hasNext()) {
                v2.next().forcePostponedExecutePendingOperations();
            }
        }
        else {
            if(this.mPostponedTransactions == null) {
                return;
            }

            while(!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    private boolean generateOpsForPendingActions(ArrayList arg6, ArrayList arg7) {
        int v3;
        int v2;
        ArrayList v0 = this.mPendingActions;
        __monitor_enter(v0);
        try {
            v2 = 0;
            if(this.mPendingActions.isEmpty()) {
                __monitor_exit(v0);
                return 0;
            }

            int v1 = this.mPendingActions.size();
            v3 = 0;
        }
        catch(Throwable v5) {
            goto label_26;
        }

        while(true) {
            ArrayList v4 = this.mPendingActions;
            if(v2 >= v1) {
                goto label_18;
            }

            try {
                v3 |= v4.get(v2).generateOps(arg6, arg7);
                ++v2;
                continue;
            label_18:
                v4.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                __monitor_exit(v0);
                return ((boolean)v3);
            label_26:
                __monitor_exit(v0);
                break;
            }
            catch(Throwable v5) {
                goto label_26;
            }
        }

        throw v5;
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    List getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public BackStackEntry getBackStackEntryAt(int arg1) {
        return this.mBackStack.get(arg1);
    }

    public int getBackStackEntryCount() {
        ArrayList v0 = this.mBackStack;
        if(v0 != null) {
            return v0.size();
        }

        return 0;
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment arg1) {
        return this.mNonConfig.getChildNonConfig(arg1);
    }

    FragmentContainer getContainer() {
        return this.mContainer;
    }

    public Fragment getFragment(Bundle arg5, String arg6) {
        String v5 = arg5.getString(arg6);
        if(v5 == null) {
            return null;
        }

        Fragment v0 = this.findActiveFragment(v5);
        if(v0 == null) {
            this.throwException(new IllegalStateException("Fragment no longer exists for key " + arg6 + ": unique id " + v5));
        }

        return v0;
    }

    private ViewGroup getFragmentContainer(Fragment arg3) {
        if(arg3.mContainer != null) {
            return arg3.mContainer;
        }

        ViewGroup v1 = null;
        if(arg3.mContainerId <= 0) {
            return v1;
        }

        if(this.mContainer.onHasView()) {
            View v2 = this.mContainer.onFindViewById(arg3.mContainerId);
            if((v2 instanceof ViewGroup)) {
                return ((ViewGroup)v2);
            }
        }

        return v1;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory v0 = this.mFragmentFactory;
        if(v0 != null) {
            return v0;
        }

        Fragment v0_1 = this.mParent;
        if(v0_1 != null) {
            return v0_1.mFragmentManager.getFragmentFactory();
        }

        return this.mHostFragmentFactory;
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public List getFragments() {
        return this.mFragmentStore.getFragments();
    }

    FragmentHostCallback getHost() {
        return this.mHost;
    }

    LayoutInflater$Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory v0 = this.mSpecialEffectsControllerFactory;
        if(v0 != null) {
            return v0;
        }

        Fragment v0_1 = this.mParent;
        if(v0_1 != null) {
            return v0_1.mFragmentManager.getSpecialEffectsControllerFactory();
        }

        return this.mDefaultSpecialEffectsControllerFactory;
    }

    static Fragment getViewFragment(View arg1) {
        Object v1 = arg1.getTag(id.fragment_container_view_tag);
        if((v1 instanceof Fragment)) {
            return ((Fragment)v1);
        }

        return null;
    }

    ViewModelStore getViewModelStore(Fragment arg1) {
        return this.mNonConfig.getViewModelStore(arg1);
    }

    void handleOnBackPressed() {
        this.execPendingActions(true);
        if(this.mOnBackPressedCallback.isEnabled()) {
            this.popBackStackImmediate();
            return;
        }

        this.mOnBackPressedDispatcher.onBackPressed();
    }

    void hideFragment(Fragment arg3) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "hide: " + arg3);
        }

        if(!arg3.mHidden) {
            arg3.mHidden = true;
            arg3.mHiddenChanged ^= 1;
            this.setVisibleRemovingFragment(arg3);
        }
    }

    void invalidateMenuForFragment(Fragment arg2) {
        if((arg2.mAdded) && (this.isMenuAvailable(arg2))) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    static boolean isLoggingEnabled(int arg1) {
        if(!FragmentManager.DEBUG) {
            if(Log.isLoggable("FragmentManager", arg1)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isMenuAvailable(Fragment arg1) {
        if((arg1.mHasMenu) && (arg1.mMenuVisible) || (arg1.mChildFragmentManager.checkForMenus())) {
            return 1;
        }

        return 0;
    }

    boolean isParentMenuVisible(Fragment arg1) {
        if(arg1 == null) {
            return 1;
        }

        return arg1.isMenuVisible();
    }

    boolean isPrimaryNavigation(Fragment arg4) {
        if(arg4 == null) {
            return 1;
        }

        FragmentManager v1 = arg4.mFragmentManager;
        if((arg4.equals(v1.getPrimaryNavigationFragment())) && (this.isPrimaryNavigation(v1.mParent))) {
            return 1;
        }

        return 0;
    }

    boolean isStateAtLeast(int arg1) {
        if(this.mCurState >= arg1) {
            return 1;
        }

        return 0;
    }

    public boolean isStateSaved() {
        if(!this.mStateSaved) {
            if(this.mStopped) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void launchRequestPermissions(Fragment arg2, String[] arg3, int arg4) {
        if(this.mRequestPermissions != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(arg2.mWho, arg4));
            this.mRequestPermissions.launch(arg3);
            return;
        }

        this.mHost.onRequestPermissionsFromFragment(arg2, arg3, arg4);
    }

    void launchStartActivityForResult(Fragment arg2, Intent arg3, int arg4, Bundle arg5) {
        if(this.mStartActivityForResult != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(arg2.mWho, arg4));
            if(arg3 != null && arg5 != null) {
                arg3.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", arg5);
            }

            this.mStartActivityForResult.launch(arg3);
            return;
        }

        this.mHost.onStartActivityFromFragment(arg2, arg3, arg4, arg5);
    }

    void launchStartIntentSenderForResult(Fragment arg10, IntentSender arg11, int arg12, Intent arg13, int arg14, int arg15, int arg16, Bundle arg17) throws IntentSender$SendIntentException {
        Bundle v8 = arg17;
        if(this.mStartIntentSenderForResult != null) {
            String v0 = "FragmentManager";
            int v1 = 2;
            if(v8 != null) {
                if(arg13 == null) {
                    arg13 = new Intent();
                    arg13.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                }

                if(FragmentManager.isLoggingEnabled(v1)) {
                    Log.v(v0, "ActivityOptions " + v8 + " were added to fillInIntent " + arg13 + " for fragment " + arg10);
                }

                arg13.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", v8);
            }

            IntentSenderRequest v11 = new Builder(arg11).setFillInIntent(arg13).setFlags(arg15, arg14).build();
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(arg10.mWho, arg12));
            if(FragmentManager.isLoggingEnabled(v1)) {
                Log.v(v0, "Fragment " + arg10 + "is launching an IntentSender for result ");
            }

            this.mStartIntentSenderForResult.launch(v11);
            return;
        }

        this.mHost.onStartIntentSenderFromFragment(arg10, arg11, arg12, arg13, arg14, arg15, arg16, v8);
    }

    private void makeRemovedFragmentsInvisible(ArraySet arg5) {
        int v4 = arg5.size();
        int v0;
        for(v0 = 0; v0 < v4; ++v0) {
            Object v1 = arg5.valueAt(v0);
            if(!((Fragment)v1).mAdded) {
                View v2 = ((Fragment)v1).requireView();
                ((Fragment)v1).mPostponedAlpha = v2.getAlpha();
                v2.setAlpha(0f);
            }
        }
    }

    void moveFragmentToExpectedState(Fragment arg4) {
        if(this.mFragmentStore.containsActiveFragment(arg4.mWho)) {
            this.moveToState(arg4);
            if(arg4.mView != null && (arg4.mIsNewlyAdded) && arg4.mContainer != null) {
                if(arg4.mPostponedAlpha > 0f) {
                    arg4.mView.setAlpha(arg4.mPostponedAlpha);
                }

                arg4.mPostponedAlpha = 0f;
                arg4.mIsNewlyAdded = false;
                AnimationOrAnimator v0 = FragmentAnim.loadAnimation(this.mHost.getContext(), arg4, true, arg4.getPopDirection());
                if(v0 == null) {
                    goto label_55;
                }

                if(v0.animation != null) {
                    arg4.mView.startAnimation(v0.animation);
                    goto label_55;
                }

                v0.animator.setTarget(arg4.mView);
                v0.animator.start();
            }

        label_55:
            if(!arg4.mHiddenChanged) {
                return;
            }

            this.completeShowHideFragment(arg4);
        }
        else if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Ignoring moving " + arg4 + " to state " + this.mCurState + "since it is not added to " + this);
            return;
        }
    }

    void moveToState(int arg3, boolean arg4) {
        if(this.mHost == null) {
            if(arg3 == -1) {
            }
            else {
                throw new IllegalStateException("No activity");
            }
        }

        if((arg4) || arg3 != this.mCurState) {
            this.mCurState = arg3;
            boolean v3 = FragmentManager.USE_STATE_MANAGER;
            FragmentStore v4 = this.mFragmentStore;
            if(v3) {
                v4.moveToExpectedState();
            }
            else {
                Iterator v3_1 = v4.getFragments().iterator();
                while(v3_1.hasNext()) {
                    this.moveFragmentToExpectedState(v3_1.next());
                }

                v3_1 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
                while(v3_1.hasNext()) {
                    Object v4_1 = v3_1.next();
                    Fragment v0 = ((FragmentStateManager)v4_1).getFragment();
                    if(!v0.mIsNewlyAdded) {
                        this.moveFragmentToExpectedState(v0);
                    }

                    if(!v0.mRemoving) {
                        continue;
                    }

                    if(v0.isInBackStack()) {
                        continue;
                    }

                    this.mFragmentStore.makeInactive(((FragmentStateManager)v4_1));
                }
            }

            this.startPendingDeferredFragments();
            if(!this.mNeedMenuInvalidate) {
                return;
            }

            FragmentHostCallback v3_2 = this.mHost;
            if(v3_2 == null) {
                return;
            }

            if(this.mCurState != 7) {
                return;
            }

            v3_2.onSupportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
        }
        else {
        }
    }

    void moveToState(Fragment arg11, int arg12) {
        FragmentStateManager v0 = this.mFragmentStore.getFragmentStateManager(arg11.mWho);
        int v1 = 1;
        if(v0 == null) {
            v0 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, arg11);
            v0.setFragmentManagerState(1);
        }

        int v3 = 2;
        if((arg11.mFromLayout) && (arg11.mInLayout) && arg11.mState == v3) {
            arg12 = Math.max(arg12, v3);
        }

        arg12 = Math.min(arg12, v0.computeExpectedState());
        int v4 = 3;
        String v5 = "FragmentManager";
        int v6 = -1;
        int v7 = 5;
        int v8 = 4;
        if(arg11.mState <= arg12) {
            if(arg11.mState < arg12 && !this.mExitAnimationCancellationSignals.isEmpty()) {
                this.cancelExitAnimation(arg11);
            }

            int v10 = arg11.mState;
            if(v10 != v6) {
                if(v10 == 0) {
                    goto label_43;
                }
                else if(v10 == 1) {
                    goto label_45;
                }
                else if(v10 == v3) {
                    goto label_49;
                }
                else if(v10 == v8) {
                    goto label_51;
                }
                else if(v10 != v7) {
                    goto label_155;
                }
            }
            else if(arg12 > v6) {
                v0.attach();
                goto label_43;
            }
            else {
            label_43:
                if(arg12 > 0) {
                    v0.create();
                    goto label_45;
                }
                else {
                label_45:
                    if(arg12 > v6) {
                        v0.ensureInflatedView();
                    }

                    if(arg12 > 1) {
                        v0.createView();
                    }

                label_49:
                    if(arg12 > v3) {
                        v0.activityCreated();
                    }

                label_51:
                    if(arg12 <= v8) {
                        goto label_53;
                    }

                    v0.start();
                }
            }

        label_53:
            if(arg12 <= v7) {
                goto label_155;
            }

            v0.resume();
            goto label_155;
        }
        else {
            if(arg11.mState > arg12) {
                int v2 = arg11.mState;
                if(v2 != 0) {
                    if(v2 != 1) {
                        if(v2 != v3) {
                            if(v2 != v8) {
                                if(v2 != v7) {
                                    int v9 = 7;
                                    if(v2 != v9) {
                                        goto label_155;
                                    }
                                    else if(arg12 < v9) {
                                        v0.pause();
                                    }
                                }

                                if(arg12 >= v7) {
                                    goto label_71;
                                }

                                v0.stop();
                            }

                        label_71:
                            if(arg12 >= v8) {
                                goto label_88;
                            }

                            if(FragmentManager.isLoggingEnabled(v4)) {
                                Log.d(v5, "movefrom ACTIVITY_CREATED: " + arg11);
                            }

                            if(arg11.mView == null) {
                                goto label_88;
                            }

                            if(!this.mHost.onShouldSaveFragmentState(arg11)) {
                                goto label_88;
                            }

                            if(arg11.mSavedViewState != null) {
                                goto label_88;
                            }

                            v0.saveViewState();
                        }

                    label_88:
                        if(arg12 >= v3) {
                            goto label_145;
                        }

                        if(arg11.mView != null && arg11.mContainer != null) {
                            arg11.mContainer.endViewTransition(arg11.mView);
                            arg11.mView.clearAnimation();
                            if(!arg11.isRemovingParent()) {
                                AnimationOrAnimator v2_1 = this.mCurState <= v6 || (this.mDestroyed) || arg11.mView.getVisibility() != 0 || arg11.mPostponedAlpha < 0f ? null : FragmentAnim.loadAnimation(this.mHost.getContext(), arg11, false, arg11.getPopDirection());
                                arg11.mPostponedAlpha = 0f;
                                ViewGroup v6_1 = arg11.mContainer;
                                View v7_1 = arg11.mView;
                                if(v2_1 != null) {
                                    FragmentAnim.animateRemoveFragment(arg11, v2_1, this.mFragmentTransitionCallback);
                                }

                                v6_1.removeView(v7_1);
                                if(FragmentManager.isLoggingEnabled(v3)) {
                                    Log.v(v5, "Removing view " + v7_1 + " for fragment " + arg11 + " from container " + v6_1);
                                }

                                if(v6_1 == arg11.mContainer) {
                                    goto label_141;
                                }

                                return;
                            }
                        }

                    label_141:
                        if(this.mExitAnimationCancellationSignals.get(arg11) != null) {
                            goto label_145;
                        }

                        v0.destroyFragmentView();
                    }

                label_145:
                    if(arg12 >= 1) {
                        goto label_151;
                    }

                    if(this.mExitAnimationCancellationSignals.get(arg11) != null) {
                        goto label_152;
                    }

                    v0.destroy();
                    goto label_151;
                }
                else {
                label_151:
                    v1 = arg12;
                }

            label_152:
                if(v1 < 0) {
                    v0.detach();
                }

                arg12 = v1;
            }

        label_155:
            if(arg11.mState == arg12) {
                return;
            }

            if(FragmentManager.isLoggingEnabled(v4)) {
                Log.d(v5, "moveToState: Fragment state for " + arg11 + " not updated inline; expected state " + arg12 + " found " + arg11.mState);
            }

            arg11.mState = arg12;
        }
    }

    void moveToState(Fragment arg2) {
        this.moveToState(arg2, this.mCurState);
    }

    void noteStateNotSaved() {
        if(this.mHost == null) {
        }
        else {
            this.mStateSaved = false;
            this.mStopped = false;
            this.mNonConfig.setIsStateSaved(false);
            Iterator v2 = this.mFragmentStore.getFragments().iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                if(v0 == null) {
                    continue;
                }

                ((Fragment)v0).noteStateNotSaved();
            }
        }
    }

    void onContainerAvailable(FragmentContainerView arg5) {
        Iterator v4 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while(v4.hasNext()) {
            Object v0 = v4.next();
            Fragment v1 = ((FragmentStateManager)v0).getFragment();
            if(v1.mContainerId != arg5.getId()) {
                continue;
            }

            if(v1.mView == null) {
                continue;
            }

            if(v1.mView.getParent() != null) {
                continue;
            }

            v1.mContainer = ((ViewGroup)arg5);
            ((FragmentStateManager)v0).addViewToContainer();
        }
    }

    @Deprecated public FragmentTransaction openTransaction() {
        return this.beginTransaction();
    }

    void performPendingDeferredStart(FragmentStateManager arg3) {
        Fragment v0 = arg3.getFragment();
        if(v0.mDeferStart) {
            if(this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            else {
                v0.mDeferStart = false;
                if(FragmentManager.USE_STATE_MANAGER) {
                    arg3.moveToExpectedState();
                    return;
                }
                else {
                    this.moveToState(v0);
                }
            }
        }
    }

    public void popBackStack(int arg3, int arg4) {
        if(arg3 >= 0) {
            this.enqueueAction(new PopBackStackState(this, null, arg3, arg4), false);
            return;
        }

        throw new IllegalArgumentException("Bad id: " + arg3);
    }

    public void popBackStack() {
        this.enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public void popBackStack(String arg3, int arg4) {
        this.enqueueAction(new PopBackStackState(this, arg3, -1, arg4), false);
    }

    private boolean popBackStackImmediate(String arg9, int arg10, int arg11) {
        this.execPendingActions(false);
        this.ensureExecReady(true);
        Fragment v1 = this.mPrimaryNav;
        if(v1 != null && arg10 < 0 && arg9 == null && (v1.getChildFragmentManager().popBackStackImmediate())) {
            return 1;
        }

        FragmentManager v2 = this;
        boolean v8 = v2.popBackStackState(this.mTmpRecords, this.mTmpIsPop, arg9, arg10, arg11);
        if(v8) {
            v2.mExecutingActions = true;
            try {
                v2.removeRedundantOperationsAndExecute(v2.mTmpRecords, v2.mTmpIsPop);
            }
            catch(Throwable v0) {
                v2.cleanupExec();
                throw v0;
            }

            v2.cleanupExec();
        }

        v2.updateOnBackPressedCallbackEnabled();
        v2.doPendingDeferredStart();
        v2.mFragmentStore.burpActive();
        return v8;
    }

    public boolean popBackStackImmediate() {
        return this.popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int arg2, int arg3) {
        if(arg2 >= 0) {
            return this.popBackStackImmediate(null, arg2, arg3);
        }

        throw new IllegalArgumentException("Bad id: " + arg2);
    }

    public boolean popBackStackImmediate(String arg2, int arg3) {
        return this.popBackStackImmediate(arg2, -1, arg3);
    }

    boolean popBackStackState(ArrayList arg6, ArrayList arg7, String arg8, int arg9, int arg10) {
        int v8;
        ArrayList v0 = this.mBackStack;
        if(v0 == null) {
            return 0;
        }

        if(arg8 != null || arg9 >= 0 || (arg10 & 1) != 0) {
            if(arg8 != null || arg9 >= 0) {
                int v0_1;
                for(v0_1 = v0.size() - 1; v0_1 >= 0; --v0_1) {
                    Object v3 = this.mBackStack.get(v0_1);
                    if(arg8 != null && (arg8.equals(((BackStackRecord)v3).getName()))) {
                        break;
                    }

                    if(arg9 >= 0 && arg9 == ((BackStackRecord)v3).mIndex) {
                        break;
                    }
                }

                if(v0_1 < 0) {
                    return 0;
                }

                if((arg10 & 1) != 0) {
                    while(true) {
                        --v0_1;
                        if(v0_1 >= 0) {
                            Object v10 = this.mBackStack.get(v0_1);
                            if(arg8 != null && (arg8.equals(((BackStackRecord)v10).getName()))) {
                                continue;
                            }

                            if(arg9 < 0) {
                                break;
                            }

                            if(arg9 != ((BackStackRecord)v10).mIndex) {
                                break;
                            }

                            continue;
                        }

                        break;
                    }
                }

                v8 = v0_1;
            }
            else {
                v8 = -1;
            }

            if(v8 == this.mBackStack.size() - 1) {
                return 0;
            }

            for(arg9 = this.mBackStack.size() - 1; arg9 > v8; --arg9) {
                arg6.add(this.mBackStack.remove(arg9));
                arg7.add(Boolean.valueOf(true));
            }
        }
        else {
            v8 = v0.size() - 1;
            if(v8 < 0) {
                return 0;
            }
            else {
                arg6.add(this.mBackStack.remove(v8));
                arg7.add(Boolean.valueOf(true));
            }
        }

        return 1;
    }

    private int postponePostponableTransactions(ArrayList arg7, ArrayList arg8, int arg9, int arg10, ArraySet arg11) {
        int v0 = arg10 - 1;
        int v1 = arg10;
        while(v0 >= arg9) {
            Object v2 = arg7.get(v0);
            boolean v3 = arg8.get(v0).booleanValue();
            if((((BackStackRecord)v2).isPostponed()) && !((BackStackRecord)v2).interactsWith(arg7, v0 + 1, arg10)) {
                if(this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }

                StartEnterTransitionListener v4 = new StartEnterTransitionListener(((BackStackRecord)v2), v3);
                this.mPostponedTransactions.add(v4);
                ((BackStackRecord)v2).setOnStartPostponedListener(((OnStartEnterTransitionListener)v4));
                if(v3) {
                    ((BackStackRecord)v2).executeOps();
                }
                else {
                    ((BackStackRecord)v2).executePopOps(false);
                }

                --v1;
                if(v0 != v1) {
                    arg7.remove(v0);
                    arg7.add(v1, v2);
                }

                this.addAddedFragments(arg11);
            }

            --v0;
        }

        return v1;
    }

    public void putFragment(Bundle arg4, String arg5, Fragment arg6) {
        if(arg6.mFragmentManager != this) {
            this.throwException(new IllegalStateException("Fragment " + arg6 + " is not currently in the FragmentManager"));
        }

        arg4.putString(arg5, arg6.mWho);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg1, boolean arg2) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(arg1, arg2);
    }

    void removeCancellationSignal(Fragment arg2, CancellationSignal arg3) {
        Object v0 = this.mExitAnimationCancellationSignals.get(arg2);
        if(v0 != null && (((HashSet)v0).remove(arg3)) && (((HashSet)v0).isEmpty())) {
            this.mExitAnimationCancellationSignals.remove(arg2);
            if(arg2.mState < 5) {
                this.destroyFragmentView(arg2);
                this.moveToState(arg2);
            }
        }
    }

    void removeFragment(Fragment arg3) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "remove: " + arg3 + " nesting=" + arg3.mBackStackNesting);
        }

        boolean v0 = arg3.isInBackStack();
        if(arg3.mDetached) {
            if(!v0) {
            }
            else {
                return;
            }
        }

        this.mFragmentStore.removeFragment(arg3);
        if(this.isMenuAvailable(arg3)) {
            this.mNeedMenuInvalidate = true;
        }

        arg3.mRemoving = true;
        this.setVisibleRemovingFragment(arg3);
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener arg1) {
        this.mOnAttachListeners.remove(arg1);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener arg1) {
        ArrayList v0 = this.mBackStackChangeListeners;
        if(v0 != null) {
            v0.remove(arg1);
        }
    }

    private void removeRedundantOperationsAndExecute(ArrayList arg5, ArrayList arg6) {
        if(arg5.isEmpty()) {
        }
        else if(arg5.size() == arg6.size()) {
            this.executePostponedTransaction(arg5, arg6);
            int v0 = arg5.size();
            int v1 = 0;
            int v2 = 0;
            while(v1 < v0) {
                if(!arg5.get(v1).mReorderingAllowed) {
                    if(v2 != v1) {
                        this.executeOpsTogether(arg5, arg6, v2, v1);
                    }

                    v2 = v1 + 1;
                    if(arg6.get(v1).booleanValue()) {
                        while(v2 < v0) {
                            if(!arg6.get(v2).booleanValue()) {
                                break;
                            }

                            if(arg5.get(v2).mReorderingAllowed) {
                                break;
                            }

                            ++v2;
                        }
                    }

                    this.executeOpsTogether(arg5, arg6, v1, v2);
                    v1 = v2 - 1;
                }

                ++v1;
            }

            if(v2 == v0) {
                return;
            }

            this.executeOpsTogether(arg5, arg6, v2, v0);
        }
        else {
            goto label_36;
        }

        return;
    label_36:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    void removeRetainedFragment(Fragment arg1) {
        this.mNonConfig.removeRetainedFragment(arg1);
    }

    private void reportBackStackChanged() {
        if(this.mBackStackChangeListeners != null) {
            int v0;
            for(v0 = 0; v0 < this.mBackStackChangeListeners.size(); ++v0) {
                this.mBackStackChangeListeners.get(v0).onBackStackChanged();
            }
        }
    }

    void restoreAllState(Parcelable arg3, FragmentManagerNonConfig arg4) {
        if((this.mHost instanceof ViewModelStoreOwner)) {
            this.throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }

        this.mNonConfig.restoreFromSnapshot(arg4);
        this.restoreSaveState(arg3);
    }

    void restoreSaveState(Parcelable arg12) {
        int v0_1;
        FragmentStateManager v5;
        String v4;
        String v2;
        if(arg12 == null) {
        }
        else {
            if(((FragmentManagerState)arg12).mActive == null) {
                return;
            }

            goto label_5;
        }

        return;
    label_5:
        this.mFragmentStore.resetActiveFragments();
        Iterator v0 = ((FragmentManagerState)arg12).mActive.iterator();
        while(true) {
            v2 = "): ";
            int v3 = 2;
            v4 = "FragmentManager";
            if(!v0.hasNext()) {
                break;
            }

            Object v10 = v0.next();
            if(v10 == null) {
                continue;
            }

            Fragment v1 = this.mNonConfig.findRetainedFragmentByWho(((FragmentState)v10).mWho);
            if(v1 != null) {
                if(FragmentManager.isLoggingEnabled(v3)) {
                    Log.v(v4, "restoreSaveState: re-attaching retained " + v1);
                }

                v5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, v1, ((FragmentState)v10));
            }
            else {
                v5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), this.getFragmentFactory(), ((FragmentState)v10));
            }

            v1 = v5.getFragment();
            v1.mFragmentManager = this;
            if(FragmentManager.isLoggingEnabled(v3)) {
                Log.v(v4, "restoreSaveState: active (" + v1.mWho + v2 + v1);
            }

            v5.restoreState(this.mHost.getContext().getClassLoader());
            this.mFragmentStore.makeActive(v5);
            v5.setFragmentManagerState(this.mCurState);
        }

        v0 = this.mNonConfig.getRetainedFragments().iterator();
        while(v0.hasNext()) {
            Object v1_1 = v0.next();
            if(this.mFragmentStore.containsActiveFragment(((Fragment)v1_1).mWho)) {
                continue;
            }

            if(FragmentManager.isLoggingEnabled(v3)) {
                Log.v(v4, "Discarding retained Fragment " + v1_1 + " that was not found in the set of active Fragments " + ((FragmentManagerState)arg12).mActive);
            }

            this.mNonConfig.removeRetainedFragment(((Fragment)v1_1));
            ((Fragment)v1_1).mFragmentManager = this;
            v5 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, ((Fragment)v1_1));
            v5.setFragmentManagerState(1);
            v5.moveToExpectedState();
            ((Fragment)v1_1).mRemoving = true;
            v5.moveToExpectedState();
        }

        this.mFragmentStore.restoreAddedFragments(((FragmentManagerState)arg12).mAdded);
        int v1_2 = 0;
        if(((FragmentManagerState)arg12).mBackStack != null) {
            this.mBackStack = new ArrayList(((FragmentManagerState)arg12).mBackStack.length);
            v0_1 = 0;
            goto label_111;
        }
        else {
            this.mBackStack = null;
            goto label_144;
        label_111:
            while(v0_1 < ((FragmentManagerState)arg12).mBackStack.length) {
                BackStackRecord v5_1 = ((FragmentManagerState)arg12).mBackStack[v0_1].instantiate(this);
                if(FragmentManager.isLoggingEnabled(v3)) {
                    Log.v(v4, "restoreAllState: back stack #" + v0_1 + " (index " + v5_1.mIndex + v2 + v5_1);
                    PrintWriter v7 = new PrintWriter(new LogWriter(v4));
                    v5_1.dump("  ", v7, false);
                    v7.close();
                }

                this.mBackStack.add(v5_1);
                ++v0_1;
            }
        }

    label_144:
        this.mBackStackIndex.set(((FragmentManagerState)arg12).mBackStackIndex);
        if(((FragmentManagerState)arg12).mPrimaryNavActiveWho != null) {
            Fragment v0_2 = this.findActiveFragment(((FragmentManagerState)arg12).mPrimaryNavActiveWho);
            this.mPrimaryNav = v0_2;
            this.dispatchParentPrimaryNavigationFragmentChanged(v0_2);
        }

        ArrayList v0_3 = ((FragmentManagerState)arg12).mResultKeys;
        if(v0_3 != null) {
            while(v1_2 < v0_3.size()) {
                Object v2_1 = ((FragmentManagerState)arg12).mResults.get(v1_2);
                ((Bundle)v2_1).setClassLoader(this.mHost.getContext().getClassLoader());
                this.mResults.put(v0_3.get(v1_2), v2_1);
                ++v1_2;
            }
        }

        this.mLaunchedFragments = new ArrayDeque(((FragmentManagerState)arg12).mLaunchedFragments);
    }

    @Deprecated FragmentManagerNonConfig retainNonConfig() {
        if((this.mHost instanceof ViewModelStoreOwner)) {
            this.throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }

        return this.mNonConfig.getSnapshot();
    }

    static int reverseTransit(int arg3) {
        int v0 = 0x2002;
        int v1 = 0x1001;
        if(arg3 != v1) {
            int v2 = 0x1003;
            if(arg3 != v2) {
                if(arg3 != v0) {
                    return 0;
                }

                return v1;
            }

            return v2;
        }

        return v0;
    }

    Parcelable saveAllState() {
        BackStackState[] v4_1;
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList v0 = this.mFragmentStore.saveActiveFragments();
        String v2 = "FragmentManager";
        int v3 = 2;
        Parcelable v4 = null;
        if(v0.isEmpty()) {
            if(FragmentManager.isLoggingEnabled(v3)) {
                Log.v(v2, "saveAllState: no fragments!");
            }

            return v4;
        }

        ArrayList v1 = this.mFragmentStore.saveAddedFragments();
        ArrayList v5 = this.mBackStack;
        if(v5 != null) {
            int v5_1 = v5.size();
            if(v5_1 > 0) {
                v4_1 = new BackStackState[v5_1];
                int v6;
                for(v6 = 0; v6 < v5_1; ++v6) {
                    v4_1[v6] = new BackStackState(this.mBackStack.get(v6));
                    if(FragmentManager.isLoggingEnabled(v3)) {
                        Log.v(v2, "saveAllState: adding back stack #" + v6 + ": " + this.mBackStack.get(v6));
                    }
                }
            }
        }

        FragmentManagerState v2_1 = new FragmentManagerState();
        v2_1.mActive = v0;
        v2_1.mAdded = v1;
        v2_1.mBackStack = v4_1;
        v2_1.mBackStackIndex = this.mBackStackIndex.get();
        Fragment v0_1 = this.mPrimaryNav;
        if(v0_1 != null) {
            v2_1.mPrimaryNavActiveWho = v0_1.mWho;
        }

        v2_1.mResultKeys.addAll(this.mResults.keySet());
        v2_1.mResults.addAll(this.mResults.values());
        v2_1.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        return ((Parcelable)v2_1);
    }

    public SavedState saveFragmentInstanceState(Fragment arg5) {
        FragmentStateManager v0 = this.mFragmentStore.getFragmentStateManager(arg5.mWho);
        if(v0 == null || !v0.getFragment().equals(arg5)) {
            this.throwException(new IllegalStateException("Fragment " + arg5 + " is not currently in the FragmentManager"));
        }

        return v0.saveInstanceState();
    }

    void scheduleCommit() {
        ArrayList v0 = this.mPendingActions;
        __monitor_enter(v0);
        try {
            ArrayList v1 = this.mPostponedTransactions;
            int v2 = 0;
            int v1_1 = v1 == null || (v1.isEmpty()) ? 0 : 1;
            if(this.mPendingActions.size() == 1) {
                v2 = 1;
            }

            if(v1_1 != 0 || v2 != 0) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
                this.updateOnBackPressedCallbackEnabled();
            }

            __monitor_exit(v0);
            return;
        label_29:
            __monitor_exit(v0);
        }
        catch(Throwable v5) {
            goto label_29;
        }

        throw v5;
    }

    void setExitAnimationOrder(Fragment arg1, boolean arg2) {
        ViewGroup v0 = this.getFragmentContainer(arg1);
        if(v0 != null && ((v0 instanceof FragmentContainerView))) {
            ((FragmentContainerView)v0).setDrawDisappearingViewsLast((((int)arg2)) ^ 1);
        }
    }

    public void setFragmentFactory(FragmentFactory arg1) {
        this.mFragmentFactory = arg1;
    }

    public final void setFragmentResult(String arg3, Bundle arg4) {
        Object v0 = this.mResultListeners.get(arg3);
        if(v0 != null && (((LifecycleAwareResultListener)v0).isAtLeast(State.STARTED))) {
            ((LifecycleAwareResultListener)v0).onFragmentResult(arg3, arg4);
            return;
        }

        this.mResults.put(arg3, arg4);
    }

    public final void setFragmentResultListener(String arg3, LifecycleOwner arg4, FragmentResultListener arg5) {
        Lifecycle v4 = arg4.getLifecycle();
        if(v4.getCurrentState() == State.DESTROYED) {
        }
        else {
            androidx.fragment.app.FragmentManager$6 v0 = new LifecycleEventObserver(arg3, arg5, v4) {
                public void onStateChanged(LifecycleOwner arg3, Event arg4) {
                    if(arg4 == Event.ON_START) {
                        Object v3 = FragmentManager.this.mResults.get(this.val$requestKey);
                        if(v3 != null) {
                            this.val$listener.onFragmentResult(this.val$requestKey, ((Bundle)v3));
                            FragmentManager.this.clearFragmentResult(this.val$requestKey);
                        }
                    }

                    if(arg4 == Event.ON_DESTROY) {
                        this.val$lifecycle.removeObserver(((LifecycleObserver)this));
                        FragmentManager.this.mResultListeners.remove(this.val$requestKey);
                    }
                }
            };
            v4.addObserver(((LifecycleObserver)v0));
            Object v2 = this.mResultListeners.put(arg3, new LifecycleAwareResultListener(v4, arg5, ((LifecycleEventObserver)v0)));
            if(v2 != null) {
                ((LifecycleAwareResultListener)v2).removeObserver();
            }
        }
    }

    void setMaxLifecycle(Fragment arg3, State arg4) {
        if((arg3.equals(this.findActiveFragment(arg3.mWho))) && (arg3.mHost == null || arg3.mFragmentManager == this)) {
            arg3.mMaxState = arg4;
            return;
        }

        throw new IllegalArgumentException("Fragment " + arg3 + " is not an active fragment of FragmentManager " + this);
    }

    void setPrimaryNavigationFragment(Fragment arg4) {
        if(arg4 != null) {
            if(arg4.equals(this.findActiveFragment(arg4.mWho))) {
                if(arg4.mHost == null) {
                    goto label_21;
                }
                else if(arg4.mFragmentManager == this) {
                    goto label_21;
                }
            }

            throw new IllegalArgumentException("Fragment " + arg4 + " is not an active fragment of FragmentManager " + this);
        }

    label_21:
        Fragment v0 = this.mPrimaryNav;
        this.mPrimaryNav = arg4;
        this.dispatchParentPrimaryNavigationFragmentChanged(v0);
        this.dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory arg1) {
        this.mSpecialEffectsControllerFactory = arg1;
    }

    private void setVisibleRemovingFragment(Fragment arg3) {
        ViewGroup v2 = this.getFragmentContainer(arg3);
        if(v2 != null && arg3.getEnterAnim() + arg3.getExitAnim() + arg3.getPopEnterAnim() + arg3.getPopExitAnim() > 0) {
            if(v2.getTag(id.visible_removing_fragment_view_tag) == null) {
                v2.setTag(id.visible_removing_fragment_view_tag, arg3);
            }

            v2.getTag(id.visible_removing_fragment_view_tag).setPopDirection(arg3.getPopDirection());
        }
    }

    void showFragment(Fragment arg2) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "show: " + arg2);
        }

        if(arg2.mHidden) {
            arg2.mHidden = false;
            arg2.mHiddenChanged ^= 1;
        }
    }

    private void startPendingDeferredFragments() {
        Iterator v0 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while(v0.hasNext()) {
            this.performPendingDeferredStart(v0.next());
        }
    }

    private void throwException(RuntimeException arg8) {
        String v1 = "FragmentManager";
        Log.e(v1, arg8.getMessage());
        Log.e(v1, "Activity state:");
        PrintWriter v2 = new PrintWriter(new LogWriter(v1));
        FragmentHostCallback v0 = this.mHost;
        String v3 = "Failed dumping state";
        FileDescriptor v5 = null;
        String v6 = "  ";
        if(v0 != null) {
            try {
                v0.onDump(v6, v5, v2, new String[0]);
            }
            catch(Exception v7) {
                Log.e(v1, v3, ((Throwable)v7));
            }

            goto label_26;
        }

        try {
            this.dump(v6, v5, v2, new String[0]);
        }
        catch(Exception v7) {
            Log.e(v1, v3, ((Throwable)v7));
        }

    label_26:
        throw arg8;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("FragmentManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        Fragment v1 = this.mParent;
        String v2 = "}";
        String v3 = "{";
        if(v1 != null) {
            v0.append(v1.getClass().getSimpleName());
            v0.append(v3);
            v0.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            v0.append(v2);
        }
        else {
            FragmentHostCallback v1_1 = this.mHost;
            if(v1_1 != null) {
                v0.append(v1_1.getClass().getSimpleName());
                v0.append(v3);
                v0.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                v0.append(v2);
            }
            else {
                v0.append("null");
            }
        }

        v0.append("}}");
        return v0.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks arg1) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(arg1);
    }

    private void updateOnBackPressedCallbackEnabled() {
        boolean v2;
        ArrayList v0 = this.mPendingActions;
        __monitor_enter(v0);
        try {
            v2 = true;
            if(!this.mPendingActions.isEmpty()) {
                this.mOnBackPressedCallback.setEnabled(true);
                __monitor_exit(v0);
                return;
            }

            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            try {
            label_22:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_22;
            }

            throw v3;
        }

        OnBackPressedCallback v0_1 = this.mOnBackPressedCallback;
        if(this.getBackStackEntryCount() <= 0 || !this.isPrimaryNavigation(this.mParent)) {
            v2 = false;
        }
        else {
        }

        v0_1.setEnabled(v2);
    }
}

