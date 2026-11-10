package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {
    class androidx.fragment.app.SpecialEffectsController$3 {
        static {
            int[] v0 = new int[LifecycleImpact.values().length];
            androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = v0;
            try {
                v0[LifecycleImpact.ADDING.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
            label_8:
                int v0_1 = 2;
                try {
                    androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[LifecycleImpact.REMOVING.ordinal()] = v0_1;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                label_13:
                    int v2 = 3;
                    try {
                        androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[LifecycleImpact.NONE.ordinal()] = v2;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                    label_18:
                        int[] v3 = new int[State.values().length];
                        androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = v3;
                        try {
                            v3[State.REMOVED.ordinal()] = 1;
                            goto label_25;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_25:
                                androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.VISIBLE.ordinal()] = v0_1;
                                goto label_29;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_29:
                                    androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.GONE.ordinal()] = v2;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.INVISIBLE.ordinal()] = 4;
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
            }
        }
    }

    class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(State arg2, LifecycleImpact arg3, FragmentStateManager arg4, CancellationSignal arg5) {
            super(arg2, arg3, arg4.getFragment(), arg5);
            this.mFragmentStateManager = arg4;
        }

        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        void onStart() {
            if(this.getLifecycleImpact() == LifecycleImpact.ADDING) {
                Fragment v0 = this.mFragmentStateManager.getFragment();
                View v1 = v0.mView.findFocus();
                if(v1 != null) {
                    v0.setFocusedView(v1);
                    if(FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + v1 + " for Fragment " + v0);
                    }
                }

                v1 = this.getFragment().requireView();
                if(v1.getParent() == null) {
                    this.mFragmentStateManager.addViewToContainer();
                    v1.setAlpha(0f);
                }

                if(v1.getAlpha() == 0f && v1.getVisibility() == 0) {
                    v1.setVisibility(4);
                }

                v1.setAlpha(v0.getPostOnViewCreatedAlpha());
            }
        }
    }

    class Operation {
        enum LifecycleImpact {
            public static final enum LifecycleImpact ADDING;
            public static final enum LifecycleImpact NONE;
            public static final enum LifecycleImpact REMOVING;

            static {
                LifecycleImpact v0 = new LifecycleImpact("NONE", 0);
                LifecycleImpact.NONE = v0;
                LifecycleImpact v1 = new LifecycleImpact("ADDING", 1);
                LifecycleImpact.ADDING = v1;
                LifecycleImpact v2 = new LifecycleImpact("REMOVING", 2);
                LifecycleImpact.REMOVING = v2;
                LifecycleImpact.$VALUES = new LifecycleImpact[]{v0, v1, v2};
            }

            private LifecycleImpact(String arg1, int arg2) {
                super(arg1, arg2);
            }

            public static LifecycleImpact valueOf(String arg1) {
                return Enum.valueOf(LifecycleImpact.class, arg1);
            }

            public static LifecycleImpact[] values() {
                return LifecycleImpact.$VALUES.clone();
            }
        }

        enum State {
            public static final enum State GONE;
            public static final enum State INVISIBLE;
            public static final enum State REMOVED;
            public static final enum State VISIBLE;

            static {
                State v0 = new State("REMOVED", 0);
                State.REMOVED = v0;
                State v1 = new State("VISIBLE", 1);
                State.VISIBLE = v1;
                State v2 = new State("GONE", 2);
                State.GONE = v2;
                State v3 = new State("INVISIBLE", 3);
                State.INVISIBLE = v3;
                State.$VALUES = new State[]{v0, v1, v2, v3};
            }

            private State(String arg1, int arg2) {
                super(arg1, arg2);
            }

            void applyState(View arg5) {
                int v4 = androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[this.ordinal()];
                String v1 = "FragmentManager";
                int v2 = 2;
                if(v4 != 1) {
                    String v0 = "SpecialEffectsController: Setting view ";
                    if(v4 == v2) {
                        if(FragmentManager.isLoggingEnabled(v2)) {
                            Log.v(v1, v0 + arg5 + " to VISIBLE");
                        }

                        arg5.setVisibility(0);
                        return;
                    }
                    else if(v4 != 3) {
                        int v3 = 4;
                        if(v4 != v3) {
                        }
                        else {
                            if(FragmentManager.isLoggingEnabled(v2)) {
                                Log.v(v1, v0 + arg5 + " to INVISIBLE");
                            }

                            arg5.setVisibility(v3);
                            return;
                        }
                    }
                    else {
                        if(FragmentManager.isLoggingEnabled(v2)) {
                            Log.v(v1, v0 + arg5 + " to GONE");
                        }

                        arg5.setVisibility(8);
                        return;
                    }
                }
                else {
                    ViewParent v4_1 = arg5.getParent();
                    if(v4_1 == null) {
                        return;
                    }

                    if(FragmentManager.isLoggingEnabled(v2)) {
                        Log.v(v1, "SpecialEffectsController: Removing view " + arg5 + " from container " + v4_1);
                    }

                    ((ViewGroup)v4_1).removeView(arg5);
                }
            }

            static State from(int arg3) {
                if(arg3 != 0) {
                    if(arg3 != 4) {
                        if(arg3 == 8) {
                            return State.GONE;
                        }

                        throw new IllegalArgumentException("Unknown visibility " + arg3);
                    }

                    return State.INVISIBLE;
                }

                return State.VISIBLE;
            }

            static State from(View arg2) {
                if(arg2.getAlpha() == 0f && arg2.getVisibility() == 0) {
                    return State.INVISIBLE;
                }

                return State.from(arg2.getVisibility());
            }

            public static State valueOf(String arg1) {
                return Enum.valueOf(State.class, arg1);
            }

            public static State[] values() {
                return State.$VALUES.clone();
            }
        }

        private final List mCompletionListeners;
        private State mFinalState;
        private final Fragment mFragment;
        private boolean mIsCanceled;
        private boolean mIsComplete;
        private LifecycleImpact mLifecycleImpact;
        private final HashSet mSpecialEffectsSignals;

        Operation(State arg2, LifecycleImpact arg3, Fragment arg4, CancellationSignal arg5) {
            super();
            this.mCompletionListeners = new ArrayList();
            this.mSpecialEffectsSignals = new HashSet();
            this.mIsCanceled = false;
            this.mIsComplete = false;
            this.mFinalState = arg2;
            this.mLifecycleImpact = arg3;
            this.mFragment = arg4;
            arg5.setOnCancelListener(new OnCancelListener() {
                public void onCancel() {
                    Operation.this.cancel();
                }
            });
        }

        final void addCompletionListener(Runnable arg1) {
            this.mCompletionListeners.add(arg1);
        }

        final void cancel() {
            if(this.isCanceled()) {
            }
            else {
                this.mIsCanceled = true;
                if(this.mSpecialEffectsSignals.isEmpty()) {
                    this.complete();
                    return;
                }
                else {
                    Iterator v1 = new ArrayList(this.mSpecialEffectsSignals).iterator();
                    while(v1.hasNext()) {
                        v1.next().cancel();
                    }
                }
            }
        }

        public void complete() {
            if(this.mIsComplete) {
            }
            else {
                if(FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }

                this.mIsComplete = true;
                Iterator v2 = this.mCompletionListeners.iterator();
                while(v2.hasNext()) {
                    v2.next().run();
                }
            }
        }

        public final void completeSpecialEffect(CancellationSignal arg2) {
            if((this.mSpecialEffectsSignals.remove(arg2)) && (this.mSpecialEffectsSignals.isEmpty())) {
                this.complete();
            }
        }

        public State getFinalState() {
            return this.mFinalState;
        }

        public final Fragment getFragment() {
            return this.mFragment;
        }

        LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        final boolean isCanceled() {
            return this.mIsCanceled;
        }

        final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(CancellationSignal arg1) {
            this.onStart();
            this.mSpecialEffectsSignals.add(arg1);
        }

        final void mergeWith(State arg6, LifecycleImpact arg7) {
            int v7 = androidx.fragment.app.SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[arg7.ordinal()];
            String v1 = "SpecialEffectsController: For fragment ";
            String v2 = "FragmentManager";
            int v3 = 2;
            if(v7 != 1) {
                String v0 = " mFinalState = ";
                if(v7 == v3) {
                    if(FragmentManager.isLoggingEnabled(v3)) {
                        Log.v(v2, v1 + this.mFragment + v0 + this.mFinalState + " -> REMOVED. mLifecycleImpact  = " + this.mLifecycleImpact + " to REMOVING.");
                    }

                    this.mFinalState = State.REMOVED;
                    this.mLifecycleImpact = LifecycleImpact.REMOVING;
                    return;
                }
                else if(v7 != 3) {
                }
                else if(this.mFinalState != State.REMOVED) {
                    if(FragmentManager.isLoggingEnabled(v3)) {
                        Log.v(v2, v1 + this.mFragment + v0 + this.mFinalState + " -> " + arg6 + ". ");
                    }

                    this.mFinalState = arg6;
                    return;
                }
            }
            else {
                if(this.mFinalState != State.REMOVED) {
                    return;
                }

                if(FragmentManager.isLoggingEnabled(v3)) {
                    Log.v(v2, v1 + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.mLifecycleImpact + " to ADDING.");
                }

                this.mFinalState = State.VISIBLE;
                this.mLifecycleImpact = LifecycleImpact.ADDING;
            }
        }

        void onStart() {
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("Operation {");
            v0.append(Integer.toHexString(System.identityHashCode(this)));
            v0.append("} {mFinalState = ");
            v0.append(this.mFinalState);
            v0.append("} {mLifecycleImpact = ");
            v0.append(this.mLifecycleImpact);
            v0.append("} {mFragment = ");
            v0.append(this.mFragment);
            v0.append("}");
            return v0.toString();
        }
    }

    private final ViewGroup mContainer;
    boolean mIsContainerPostponed;
    boolean mOperationDirectionIsPop;
    final ArrayList mPendingOperations;
    final ArrayList mRunningOperations;

    SpecialEffectsController(ViewGroup arg2) {
        super();
        this.mPendingOperations = new ArrayList();
        this.mRunningOperations = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = arg2;
    }

    private void enqueue(State arg4, LifecycleImpact arg5, FragmentStateManager arg6) {
        ArrayList v0 = this.mPendingOperations;
        __monitor_enter(v0);
        try {
            CancellationSignal v1 = new CancellationSignal();
            Operation v2 = this.findPendingOperation(arg6.getFragment());
            if(v2 != null) {
                v2.mergeWith(arg4, arg5);
                __monitor_exit(v0);
                return;
            }

            FragmentStateManagerOperation v2_1 = new FragmentStateManagerOperation(arg4, arg5, arg6, v1);
            this.mPendingOperations.add(v2_1);
            v2_1.addCompletionListener(new Runnable(v2_1) {
                public void run() {
                    if(SpecialEffectsController.this.mPendingOperations.contains(this.val$operation)) {
                        this.val$operation.getFinalState().applyState(this.val$operation.getFragment().mView);
                    }
                }
            });
            v2_1.addCompletionListener(new Runnable(v2_1) {
                public void run() {
                    SpecialEffectsController.this.mPendingOperations.remove(this.val$operation);
                    SpecialEffectsController.this.mRunningOperations.remove(this.val$operation);
                }
            });
            __monitor_exit(v0);
            return;
        label_23:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_23;
        }

        throw v3;
    }

    void enqueueAdd(State arg3, FragmentStateManager arg4) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + arg4.getFragment());
        }

        this.enqueue(arg3, LifecycleImpact.ADDING, arg4);
    }

    void enqueueHide(FragmentStateManager arg3) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + arg3.getFragment());
        }

        this.enqueue(State.GONE, LifecycleImpact.NONE, arg3);
    }

    void enqueueRemove(FragmentStateManager arg3) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + arg3.getFragment());
        }

        this.enqueue(State.REMOVED, LifecycleImpact.REMOVING, arg3);
    }

    void enqueueShow(FragmentStateManager arg3) {
        if(FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + arg3.getFragment());
        }

        this.enqueue(State.VISIBLE, LifecycleImpact.NONE, arg3);
    }

    abstract void executeOperations(List arg1, boolean arg2);

    void executePendingOperations() {
        if(this.mIsContainerPostponed) {
            return;
        }

        if(!ViewCompat.isAttachedToWindow(this.mContainer)) {
            this.forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }

        ArrayList v0 = this.mPendingOperations;
        __monitor_enter(v0);
        try {
            if(!this.mPendingOperations.isEmpty()) {
                ArrayList v2 = new ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                Iterator v2_1 = v2.iterator();
                while(v2_1.hasNext()) {
                    Object v3 = v2_1.next();
                    if(FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + v3);
                    }

                    ((Operation)v3).cancel();
                    if(((Operation)v3).isComplete()) {
                        continue;
                    }

                    this.mRunningOperations.add(v3);
                }

                this.updateFinalState();
                v2 = new ArrayList(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll(((Collection)v2));
                Iterator v3_1 = v2.iterator();
                while(v3_1.hasNext()) {
                    v3_1.next().onStart();
                }

                this.executeOperations(((List)v2), this.mOperationDirectionIsPop);
                this.mOperationDirectionIsPop = false;
            }

            __monitor_exit(v0);
            return;
        label_61:
            __monitor_exit(v0);
        }
        catch(Throwable v7) {
            goto label_61;
        }

        throw v7;
    }

    private Operation findPendingOperation(Fragment arg3) {
        Object v0;
        Iterator v2 = this.mPendingOperations.iterator();
        do {
        label_2:
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
            if(!((Operation)v0).getFragment().equals(arg3)) {
                goto label_2;
            }
        }
        while(((Operation)v0).isCanceled());

        return ((Operation)v0);
    }

    private Operation findRunningOperation(Fragment arg3) {
        Object v0;
        Iterator v2 = this.mRunningOperations.iterator();
        do {
        label_2:
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
            if(!((Operation)v0).getFragment().equals(arg3)) {
                goto label_2;
            }
        }
        while(((Operation)v0).isCanceled());

        return ((Operation)v0);
    }

    void forceCompleteAllOperations() {
        Object v3;
        boolean v0 = ViewCompat.isAttachedToWindow(this.mContainer);
        ArrayList v1 = this.mPendingOperations;
        __monitor_enter(v1);
        try {
            this.updateFinalState();
            Iterator v2 = this.mPendingOperations.iterator();
            while(v2.hasNext()) {
                v2.next().onStart();
            }

            v2 = new ArrayList(this.mRunningOperations).iterator();
            while(true) {
                int v4 = 2;
                if(!v2.hasNext()) {
                    break;
                }

                v3 = v2.next();
                if(FragmentManager.isLoggingEnabled(v4)) {
                    String v4_1 = "FragmentManager";
                    StringBuilder v5 = new StringBuilder().append("SpecialEffectsController: ");
                    String v6 = v0 ? "" : "Container " + this.mContainer + " is not attached to window. ";
                    Log.v(v4_1, v5.append(v6).append("Cancelling running operation ").append(v3).toString());
                }

                ((Operation)v3).cancel();
            }

            v2 = new ArrayList(this.mPendingOperations).iterator();
            while(v2.hasNext()) {
                v3 = v2.next();
                if(FragmentManager.isLoggingEnabled(v4)) {
                    String v5_1 = "FragmentManager";
                    StringBuilder v6_1 = new StringBuilder().append("SpecialEffectsController: ");
                    String v7 = v0 ? "" : "Container " + this.mContainer + " is not attached to window. ";
                    Log.v(v5_1, v6_1.append(v7).append("Cancelling pending operation ").append(v3).toString());
                }

                ((Operation)v3).cancel();
            }

            __monitor_exit(v1);
            return;
        label_84:
            __monitor_exit(v1);
        }
        catch(Throwable v9) {
            goto label_84;
        }

        throw v9;
    }

    void forcePostponedExecutePendingOperations() {
        if(this.mIsContainerPostponed) {
            this.mIsContainerPostponed = false;
            this.executePendingOperations();
        }
    }

    LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager arg2) {
        Operation v0 = this.findPendingOperation(arg2.getFragment());
        LifecycleImpact v0_1 = v0 != null ? v0.getLifecycleImpact() : null;
        Operation v1 = this.findRunningOperation(arg2.getFragment());
        if(v1 != null && (v0_1 == null || v0_1 == LifecycleImpact.NONE)) {
            return v1.getLifecycleImpact();
        }

        return v0_1;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    static SpecialEffectsController getOrCreateController(ViewGroup arg0, FragmentManager arg1) {
        return SpecialEffectsController.getOrCreateController(arg0, arg1.getSpecialEffectsControllerFactory());
    }

    static SpecialEffectsController getOrCreateController(ViewGroup arg2, SpecialEffectsControllerFactory arg3) {
        Object v0 = arg2.getTag(id.special_effects_controller_view_tag);
        if((v0 instanceof SpecialEffectsController)) {
            return ((SpecialEffectsController)v0);
        }

        SpecialEffectsController v3 = arg3.createController(arg2);
        arg2.setTag(id.special_effects_controller_view_tag, v3);
        return v3;
    }

    void markPostponedState() {
        ArrayList v0 = this.mPendingOperations;
        __monitor_enter(v0);
        try {
            this.updateFinalState();
            this.mIsContainerPostponed = false;
            int v1;
            for(v1 = this.mPendingOperations.size() - 1; v1 >= 0; --v1) {
                Object v2 = this.mPendingOperations.get(v1);
                State v3 = State.from(((Operation)v2).getFragment().mView);
                if(((Operation)v2).getFinalState() == State.VISIBLE && v3 != State.VISIBLE) {
                    this.mIsContainerPostponed = ((Operation)v2).getFragment().isPostponed();
                    break;
                }
            }

            __monitor_exit(v0);
            return;
        label_28:
            __monitor_exit(v0);
        }
        catch(Throwable v6) {
            goto label_28;
        }

        throw v6;
    }

    private void updateFinalState() {
        Iterator v3 = this.mPendingOperations.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            if(((Operation)v0).getLifecycleImpact() != LifecycleImpact.ADDING) {
                continue;
            }

            ((Operation)v0).mergeWith(State.from(((Operation)v0).getFragment().requireView().getVisibility()), LifecycleImpact.NONE);
        }
    }

    void updateOperationDirection(boolean arg1) {
        this.mOperationDirectionIsPop = arg1;
    }
}

