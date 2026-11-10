package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources$NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.Iterator;

class FragmentStateManager {
    class androidx.fragment.app.FragmentStateManager$2 {
        static {
            int[] v0 = new int[State.values().length];
            androidx.fragment.app.FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State = v0;
            try {
                v0[State.RESUMED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.fragment.app.FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State[State.STARTED.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.fragment.app.FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State[State.CREATED.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.fragment.app.FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State[State.INITIALIZED.ordinal()] = 4;
                            return;
                        }
                        catch(NoSuchFieldError ) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    private final Fragment mFragment;
    private int mFragmentManagerState;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState;

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher arg2, FragmentStore arg3, Fragment arg4) {
        super();
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = arg2;
        this.mFragmentStore = arg3;
        this.mFragment = arg4;
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher arg3, FragmentStore arg4, Fragment arg5, FragmentState arg6) {
        super();
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = arg3;
        this.mFragmentStore = arg4;
        this.mFragment = arg5;
        SparseArray v2 = null;
        arg5.mSavedViewState = v2;
        arg5.mSavedViewRegistryState = ((Bundle)v2);
        arg5.mBackStackNesting = 0;
        arg5.mInLayout = false;
        arg5.mAdded = false;
        String v3 = arg5.mTarget != null ? arg5.mTarget.mWho : ((String)v2);
        arg5.mTargetWho = v3;
        arg5.mTarget = ((Fragment)v2);
        if(arg6.mSavedFragmentState != null) {
            arg5.mSavedFragmentState = arg6.mSavedFragmentState;
            return;
        }

        arg5.mSavedFragmentState = new Bundle();
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher arg2, FragmentStore arg3, ClassLoader arg4, FragmentFactory arg5, FragmentState arg6) {
        super();
        this.mMovingToState = false;
        this.mFragmentManagerState = -1;
        this.mDispatcher = arg2;
        this.mFragmentStore = arg3;
        Fragment v2 = arg5.instantiate(arg4, arg6.mClassName);
        this.mFragment = v2;
        if(arg6.mArguments != null) {
            arg6.mArguments.setClassLoader(arg4);
        }

        v2.setArguments(arg6.mArguments);
        v2.mWho = arg6.mWho;
        v2.mFromLayout = arg6.mFromLayout;
        v2.mRestored = true;
        v2.mFragmentId = arg6.mFragmentId;
        v2.mContainerId = arg6.mContainerId;
        v2.mTag = arg6.mTag;
        v2.mRetainInstance = arg6.mRetainInstance;
        v2.mRemoving = arg6.mRemoving;
        v2.mDetached = arg6.mDetached;
        v2.mHidden = arg6.mHidden;
        v2.mMaxState = State.values()[arg6.mMaxLifecycleState];
        v2.mSavedFragmentState = arg6.mSavedFragmentState != null ? arg6.mSavedFragmentState : new Bundle();
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + v2);
        }
    }

    void activityCreated() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
        }

        this.mFragment.performActivityCreated(this.mFragment.mSavedFragmentState);
        this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
    }

    void addViewToContainer() {
        this.mFragment.mContainer.addView(this.mFragment.mView, this.mFragmentStore.findFragmentIndexInContainer(this.mFragment));
    }

    void attach() {
        FragmentStateManager v4_1;
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.mFragment);
        }

        String v1 = " that does not belong to this FragmentManager!";
        String v2 = " declared target fragment ";
        String v3 = "Fragment ";
        Fragment v4 = null;
        if(this.mFragment.mTarget != null) {
            FragmentStateManager v0 = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTarget.mWho);
            Fragment v5 = this.mFragment;
            if(v0 != null) {
                v5.mTargetWho = v5.mTarget.mWho;
                this.mFragment.mTarget = v4;
                v4_1 = v0;
            }
            else {
                throw new IllegalStateException(v3 + v5 + v2 + this.mFragment.mTarget + v1);
            }
        }
        else if(this.mFragment.mTargetWho != null) {
            v4_1 = this.mFragmentStore.getFragmentStateManager(this.mFragment.mTargetWho);
            if(v4_1 != null) {
            }
            else {
                throw new IllegalStateException(v3 + this.mFragment + v2 + this.mFragment.mTargetWho + v1);
            }
        }

        if((((FragmentStateManager)v4)) != null && ((FragmentManager.USE_STATE_MANAGER) || ((FragmentStateManager)v4).getFragment().mState < 1)) {
            ((FragmentStateManager)v4).moveToExpectedState();
        }

        this.mFragment.mHost = this.mFragment.mFragmentManager.getHost();
        this.mFragment.mParentFragment = this.mFragment.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    int computeExpectedState() {
        if(this.mFragment.mFragmentManager == null) {
            return this.mFragment.mState;
        }

        int v0 = this.mFragmentManagerState;
        int v1 = androidx.fragment.app.FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()];
        int v2 = -1;
        int v3 = 5;
        int v4 = 3;
        int v5 = 4;
        int v6 = 2;
        if(v1 != 1) {
            if(v1 == v6) {
                v0 = Math.min(v0, v3);
            }
            else if(v1 == v4) {
                v0 = Math.min(v0, 1);
            }
            else if(v1 != v5) {
                v0 = Math.min(v0, v2);
            }
            else {
                v0 = Math.min(v0, 0);
            }
        }

        if(this.mFragment.mFromLayout) {
            boolean v1_1 = this.mFragment.mInLayout;
            int v8 = this.mFragmentManagerState;
            if(v1_1) {
                v0 = Math.max(v8, v6);
                if(this.mFragment.mView != null && this.mFragment.mView.getParent() == null) {
                    v0 = Math.min(v0, v6);
                }
            }
            else if(v8 < v5) {
                v0 = Math.min(v0, this.mFragment.mState);
            }
            else {
                v0 = Math.min(v0, 1);
            }
        }

        if(!this.mFragment.mAdded) {
            v0 = Math.min(v0, 1);
        }

        LifecycleImpact v1_2 = !FragmentManager.USE_STATE_MANAGER || this.mFragment.mContainer == null ? null : SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        if(v1_2 == LifecycleImpact.ADDING) {
            v0 = Math.min(v0, 6);
        }
        else if(v1_2 == LifecycleImpact.REMOVING) {
            v0 = Math.max(v0, v4);
        }
        else if(this.mFragment.mRemoving) {
            v0 = this.mFragment.isInBackStack() ? Math.min(v0, 1) : Math.min(v0, v2);
        }

        if((this.mFragment.mDeferStart) && this.mFragment.mState < v3) {
            v0 = Math.min(v0, v5);
        }

        if(FragmentManager.isLoggingEnabled(v6)) {
            Log.v("FragmentManager", "computeExpectedState() of " + v0 + " for " + this.mFragment);
        }

        return v0;
    }

    void create() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
        }

        if(!this.mFragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
            this.mFragment.performCreate(this.mFragment.mSavedFragmentState);
            this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
            return;
        }

        this.mFragment.restoreChildFragmentState(this.mFragment.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    void createView() {
        String v0_1;
        View v2_2;
        if(this.mFragment.mFromLayout) {
            return;
        }

        String v1 = "FragmentManager";
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d(v1, "moveto CREATE_VIEW: " + this.mFragment);
        }

        LayoutInflater v0 = this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState);
        ViewGroup v2 = this.mFragment.mContainer;
        Fragment v3 = this.mFragment;
        if(v2 != null) {
            v2 = v3.mContainer;
        }
        else if(v3.mContainerId != 0) {
            int v2_1 = this.mFragment.mContainerId;
            v3 = this.mFragment;
            if(v2_1 != -1) {
                v2_2 = v3.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
                if(v2_2 == null) {
                    if(this.mFragment.mRestored) {
                    }
                    else {
                        try {
                            v0_1 = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);
                        }
                        catch(Resources$NotFoundException ) {
                            v0_1 = "unknown";
                        }

                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + v0_1 + ") for fragment " + this.mFragment);
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Cannot create fragment " + v3 + " for a container view with no id");
            }
        }
        else {
            v2 = null;
        }

        this.mFragment.mContainer = ((ViewGroup)v2_2);
        this.mFragment.performCreateView(v0, ((ViewGroup)v2_2), this.mFragment.mSavedFragmentState);
        int v3_1 = 2;
        if(this.mFragment.mView != null) {
            boolean v4 = false;
            this.mFragment.mView.setSaveFromParentEnabled(false);
            this.mFragment.mView.setTag(id.fragment_container_view_tag, this.mFragment);
            if((((ViewGroup)v2_2)) != null) {
                this.addViewToContainer();
            }

            if(this.mFragment.mHidden) {
                this.mFragment.mView.setVisibility(8);
            }

            boolean v0_2 = ViewCompat.isAttachedToWindow(this.mFragment.mView);
            Fragment v2_3 = this.mFragment;
            if(v0_2) {
                ViewCompat.requestApplyInsets(v2_3.mView);
            }
            else {
                v2_3.mView.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener(v2_3.mView) {
                    public void onViewAttachedToWindow(View arg1) {
                        this.val$fragmentView.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
                        ViewCompat.requestApplyInsets(this.val$fragmentView);
                    }

                    public void onViewDetachedFromWindow(View arg1) {
                    }
                });
            }

            this.mFragment.performViewCreated();
            this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
            int v0_3 = this.mFragment.mView.getVisibility();
            float v2_4 = this.mFragment.mView.getAlpha();
            boolean v5 = FragmentManager.USE_STATE_MANAGER;
            Fragment v6 = this.mFragment;
            if(v5) {
                v6.setPostOnViewCreatedAlpha(v2_4);
                if(this.mFragment.mContainer == null) {
                    goto label_166;
                }

                if(v0_3 != 0) {
                    goto label_166;
                }

                View v0_4 = this.mFragment.mView.findFocus();
                if(v0_4 != null) {
                    this.mFragment.setFocusedView(v0_4);
                    if(FragmentManager.isLoggingEnabled(v3_1)) {
                        Log.v(v1, "requestFocus: Saved focused view " + v0_4 + " for Fragment " + this.mFragment);
                    }
                }

                this.mFragment.mView.setAlpha(0f);
                goto label_166;
            }

            if(v0_3 == 0 && v6.mContainer != null) {
                v4 = true;
            }

            v6.mIsNewlyAdded = v4;
        }

    label_166:
        this.mFragment.mState = v3_1;
    }

    void destroy() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
        }

        boolean v1 = true;
        int v0 = !this.mFragment.mRemoving || (this.mFragment.isInBackStack()) ? 0 : 1;
        if(v0 == 0) {
            if(this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            }
            else {
                if(this.mFragment.mTargetWho != null) {
                    Fragment v0_1 = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho);
                    if(v0_1 != null && (v0_1.mRetainInstance)) {
                        this.mFragment.mTarget = v0_1;
                    }
                }

                this.mFragment.mState = 0;
                return;
            }
        }

        FragmentHostCallback v3 = this.mFragment.mHost;
        if((v3 instanceof ViewModelStoreOwner)) {
            v1 = this.mFragmentStore.getNonConfig().isCleared();
        }
        else if((v3.getContext() instanceof Activity)) {
            int v1_1 = 1 ^ v3.getContext().isChangingConfigurations();
        }

        if(v0 != 0 || ((((boolean)v1_1)))) {
            this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
        }

        this.mFragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
        Iterator v0_2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while(v0_2.hasNext()) {
            Object v1_2 = v0_2.next();
            if(v1_2 == null) {
                continue;
            }

            Fragment v1_3 = ((FragmentStateManager)v1_2).getFragment();
            if(!this.mFragment.mWho.equals(v1_3.mTargetWho)) {
                continue;
            }

            v1_3.mTarget = this.mFragment;
            v1_3.mTargetWho = null;
        }

        if(this.mFragment.mTargetWho != null) {
            this.mFragment.mTarget = this.mFragmentStore.findActiveFragment(this.mFragment.mTargetWho);
        }

        this.mFragmentStore.makeInactive(this);
    }

    void destroyFragmentView() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.mFragment);
        }

        if(this.mFragment.mContainer != null && this.mFragment.mView != null) {
            this.mFragment.mContainer.removeView(this.mFragment.mView);
        }

        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        this.mFragment.mContainer = null;
        this.mFragment.mView = null;
        this.mFragment.mViewLifecycleOwner = null;
        this.mFragment.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    void detach() {
        int v0 = 3;
        String v2 = "FragmentManager";
        if(FragmentManager.isLoggingEnabled(v0)) {
            Log.d(v2, "movefrom ATTACHED: " + this.mFragment);
        }

        this.mFragment.performDetach();
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        this.mFragment.mState = -1;
        this.mFragment.mHost = null;
        this.mFragment.mParentFragment = null;
        this.mFragment.mFragmentManager = null;
        if((this.mFragment.mRemoving) && !this.mFragment.isInBackStack() || (this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment))) {
            if(FragmentManager.isLoggingEnabled(v0)) {
                Log.d(v2, "initState called for fragment: " + this.mFragment);
            }

            this.mFragment.initState();
        }
    }

    void ensureInflatedView() {
        if((this.mFragment.mFromLayout) && (this.mFragment.mInLayout) && !this.mFragment.mPerformedCreateView) {
            if(FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
            }

            this.mFragment.performCreateView(this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
            if(this.mFragment.mView == null) {
                return;
            }

            this.mFragment.mView.setSaveFromParentEnabled(false);
            this.mFragment.mView.setTag(id.fragment_container_view_tag, this.mFragment);
            if(this.mFragment.mHidden) {
                this.mFragment.mView.setVisibility(8);
            }

            this.mFragment.performViewCreated();
            this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
            this.mFragment.mState = 2;
        }
    }

    Fragment getFragment() {
        return this.mFragment;
    }

    private boolean isFragmentViewChild(View arg3) {
        if(arg3 == this.mFragment.mView) {
            return 1;
        }

        ViewParent v3;
        for(v3 = arg3.getParent(); v3 != null; v3 = v3.getParent()) {
            if(v3 == this.mFragment.mView) {
                return 1;
            }
        }

        return 0;
    }

    void moveToExpectedState() {
        int v4;
        String v1 = "FragmentManager";
        int v2 = 2;
        if(this.mMovingToState) {
            if(FragmentManager.isLoggingEnabled(v2)) {
                Log.v(v1, "Ignoring re-entrant call to moveToExpectedState() for " + this.getFragment());
            }

            return;
        }

        try {
            this.mMovingToState = true;
            while(true) {
            label_17:
                v4 = this.computeExpectedState();
                if(v4 == this.mFragment.mState) {
                    goto label_124;
                }

                int v5 = this.mFragment.mState;
                break;
            }
        }
        catch(Throwable v1_1) {
            goto label_161;
        }

        Fragment v6 = this.mFragment;
        if(v4 <= v5) {
            goto label_66;
        }

        try {
            switch(v6.mState + 1) {
                case 0: {
                    goto label_64;
                }
                case 1: {
                    goto label_62;
                }
                case 2: {
                    goto label_59;
                }
                case 3: {
                    goto label_57;
                }
                case 4: {
                    goto label_37;
                }
                case 5: {
                    goto label_35;
                }
                case 6: {
                    goto label_31;
                }
                case 7: {
                    goto label_29;
                }
            }

            goto label_17;
        label_35:
            this.start();
            goto label_17;
        label_37:
            if(this.mFragment.mView != null && this.mFragment.mContainer != null) {
                SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueAdd(androidx.fragment.app.SpecialEffectsController$Operation$State.from(this.mFragment.mView.getVisibility()), this);
            }

            this.mFragment.mState = 4;
            goto label_17;
        label_57:
            this.activityCreated();
            goto label_17;
        label_59:
            this.ensureInflatedView();
            this.createView();
            goto label_17;
        label_29:
            this.resume();
            goto label_17;
        label_62:
            this.create();
            goto label_17;
        label_31:
            this.mFragment.mState = 6;
            goto label_17;
        label_64:
            this.attach();
            goto label_17;
        label_66:
            switch(v6.mState - 1) {
                case -1: {
                    goto label_122;
                }
                case 0: {
                    goto label_120;
                }
                case 1: {
                    goto label_116;
                }
                case 2: {
                    goto label_111;
                }
                case 3: {
                    goto label_78;
                }
                case 4: {
                    goto label_76;
                }
                case 5: {
                    goto label_72;
                }
                case 6: {
                    goto label_70;
                }
            }

            goto label_17;
        label_116:
            this.destroyFragmentView();
            this.mFragment.mState = 1;
            goto label_17;
        label_70:
            this.pause();
            goto label_17;
        label_120:
            this.destroy();
            goto label_17;
        label_72:
            this.mFragment.mState = 5;
            goto label_17;
        label_122:
            this.detach();
            goto label_17;
        label_76:
            this.stop();
            goto label_17;
        label_78:
            v4 = 3;
            if(FragmentManager.isLoggingEnabled(v4)) {
                Log.d(v1, "movefrom ACTIVITY_CREATED: " + this.mFragment);
            }

            if(this.mFragment.mView != null && this.mFragment.mSavedViewState == null) {
                this.saveViewState();
            }

            if(this.mFragment.mView != null && this.mFragment.mContainer != null) {
                SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager()).enqueueRemove(this);
            }

            this.mFragment.mState = v4;
            goto label_17;
        label_111:
            this.mFragment.mInLayout = false;
            this.mFragment.mState = v2;
            goto label_17;
        label_124:
            if((FragmentManager.USE_STATE_MANAGER) && (this.mFragment.mHiddenChanged)) {
                if(this.mFragment.mView != null && this.mFragment.mContainer != null) {
                    SpecialEffectsController v1_2 = SpecialEffectsController.getOrCreateController(this.mFragment.mContainer, this.mFragment.getParentFragmentManager());
                    if(this.mFragment.mHidden) {
                        v1_2.enqueueHide(this);
                    }
                    else {
                        v1_2.enqueueShow(this);
                    }
                }

                if(this.mFragment.mFragmentManager != null) {
                    this.mFragment.mFragmentManager.invalidateMenuForFragment(this.mFragment);
                }

                this.mFragment.mHiddenChanged = false;
                this.mFragment.onHiddenChanged(this.mFragment.mHidden);
            }
        }
        catch(Throwable v1_1) {
            goto label_161;
        }

        this.mMovingToState = false;
        return;
    label_161:
        this.mMovingToState = false;
        throw v1_1;
    }

    void pause() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
        }

        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void restoreState(ClassLoader arg4) {
        if(this.mFragment.mSavedFragmentState == null) {
        }
        else {
            this.mFragment.mSavedFragmentState.setClassLoader(arg4);
            this.mFragment.mSavedViewState = this.mFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            this.mFragment.mSavedViewRegistryState = this.mFragment.mSavedFragmentState.getBundle("android:view_registry_state");
            this.mFragment.mTargetWho = this.mFragment.mSavedFragmentState.getString("android:target_state");
            if(this.mFragment.mTargetWho != null) {
                this.mFragment.mTargetRequestCode = this.mFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
            }

            Boolean v4 = this.mFragment.mSavedUserVisibleHint;
            Fragment v0 = this.mFragment;
            if(v4 != null) {
                v0.mUserVisibleHint = v0.mSavedUserVisibleHint.booleanValue();
                this.mFragment.mSavedUserVisibleHint = null;
            }
            else {
                v0.mUserVisibleHint = v0.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }

            if(this.mFragment.mUserVisibleHint) {
                return;
            }

            this.mFragment.mDeferStart = true;
        }
    }

    void resume() {
        String v1 = "FragmentManager";
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d(v1, "moveto RESUMED: " + this.mFragment);
        }

        View v0 = this.mFragment.getFocusedView();
        if(v0 != null && (this.isFragmentViewChild(v0))) {
            boolean v2 = v0.requestFocus();
            if(FragmentManager.isLoggingEnabled(2)) {
                StringBuilder v0_1 = new StringBuilder("requestFocus: Restoring focused view ").append(v0).append(" ");
                String v2_1 = v2 ? "succeeded" : "failed";
                Log.v(v1, v0_1.append(v2_1).append(" on Fragment ").append(this.mFragment).append(" resulting in focused view ").append(this.mFragment.mView.findFocus()).toString());
            }
        }

        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
        this.mFragment.mSavedViewRegistryState = null;
    }

    private Bundle saveBasicState() {
        Bundle v0 = new Bundle();
        this.mFragment.performSaveInstanceState(v0);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, v0, false);
        if(v0.isEmpty()) {
            v0 = null;
        }

        if(this.mFragment.mView != null) {
            this.saveViewState();
        }

        if(this.mFragment.mSavedViewState != null) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putSparseParcelableArray("android:view_state", this.mFragment.mSavedViewState);
        }

        if(this.mFragment.mSavedViewRegistryState != null) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putBundle("android:view_registry_state", this.mFragment.mSavedViewRegistryState);
        }

        if(!this.mFragment.mUserVisibleHint) {
            if(v0 == null) {
                v0 = new Bundle();
            }

            v0.putBoolean("android:user_visible_hint", this.mFragment.mUserVisibleHint);
        }

        return v0;
    }

    SavedState saveInstanceState() {
        SavedState v2 = null;
        if(this.mFragment.mState > -1) {
            Bundle v3 = this.saveBasicState();
            if(v3 != null) {
                return new SavedState(v3);
            }
        }

        return v2;
    }

    FragmentState saveState() {
        FragmentState v0 = new FragmentState(this.mFragment);
        if(this.mFragment.mState > -1 && v0.mSavedFragmentState == null) {
            v0.mSavedFragmentState = this.saveBasicState();
            if(this.mFragment.mTargetWho != null) {
                if(v0.mSavedFragmentState == null) {
                    v0.mSavedFragmentState = new Bundle();
                }

                v0.mSavedFragmentState.putString("android:target_state", this.mFragment.mTargetWho);
                if(this.mFragment.mTargetRequestCode == 0) {
                    return v0;
                }

                v0.mSavedFragmentState.putInt("android:target_req_state", this.mFragment.mTargetRequestCode);
            }

            return v0;
        }

        v0.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        return v0;
    }

    void saveViewState() {
        if(this.mFragment.mView == null) {
        }
        else {
            SparseArray v0 = new SparseArray();
            this.mFragment.mView.saveHierarchyState(v0);
            if(v0.size() > 0) {
                this.mFragment.mSavedViewState = v0;
            }

            Bundle v0_1 = new Bundle();
            this.mFragment.mViewLifecycleOwner.performSave(v0_1);
            if(v0_1.isEmpty()) {
                return;
            }

            this.mFragment.mSavedViewRegistryState = v0_1;
        }
    }

    void setFragmentManagerState(int arg1) {
        this.mFragmentManagerState = arg1;
    }

    void start() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
        }

        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void stop() {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
        }

        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}

