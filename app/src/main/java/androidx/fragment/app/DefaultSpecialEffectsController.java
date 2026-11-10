package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController extends SpecialEffectsController {
    class androidx.fragment.app.DefaultSpecialEffectsController$10 {
        static {
            int[] v0 = new int[State.values().length];
            androidx.fragment.app.DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = v0;
            try {
                v0[State.GONE.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.fragment.app.DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.INVISIBLE.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.fragment.app.DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.REMOVED.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.fragment.app.DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[State.VISIBLE.ordinal()] = 4;
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

    class AnimationInfo extends SpecialEffectsInfo {
        private AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(Operation arg1, CancellationSignal arg2, boolean arg3) {
            super(arg1, arg2);
            this.mLoadedAnim = false;
            this.mIsPop = arg3;
        }

        AnimationOrAnimator getAnimation(Context arg5) {
            if(this.mLoadedAnim) {
                return this.mAnimation;
            }

            Fragment v0 = this.getOperation().getFragment();
            boolean v1 = this.getOperation().getFinalState() == State.VISIBLE ? true : false;
            AnimationOrAnimator v5 = FragmentAnim.loadAnimation(arg5, v0, v1, this.mIsPop);
            this.mAnimation = v5;
            this.mLoadedAnim = true;
            return v5;
        }
    }

    class SpecialEffectsInfo {
        private final Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(Operation arg1, CancellationSignal arg2) {
            super();
            this.mOperation = arg1;
            this.mSignal = arg2;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            State v0 = State.from(this.mOperation.getFragment().mView);
            State v2 = this.mOperation.getFinalState();
            if(v0 != v2 && (v0 == State.VISIBLE || v2 == State.VISIBLE)) {
                return 0;
            }

            return 1;
        }
    }

    class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(Operation arg2, CancellationSignal arg3, boolean arg4, boolean arg5) {
            Object v3;
            super(arg2, arg3);
            if(arg2.getFinalState() == State.VISIBLE) {
                v3 = arg4 ? arg2.getFragment().getReenterTransition() : arg2.getFragment().getEnterTransition();
                this.mTransition = v3;
                boolean v3_1 = arg4 ? arg2.getFragment().getAllowReturnTransitionOverlap() : arg2.getFragment().getAllowEnterTransitionOverlap();
                this.mOverlapAllowed = v3_1;
            }
            else {
                v3 = arg4 ? arg2.getFragment().getReturnTransition() : arg2.getFragment().getExitTransition();
                this.mTransition = v3;
                this.mOverlapAllowed = true;
            }

            if(arg5) {
                if(arg4) {
                    this.mSharedElementTransition = arg2.getFragment().getSharedElementReturnTransition();
                    return;
                }

                this.mSharedElementTransition = arg2.getFragment().getSharedElementEnterTransition();
                return;
            }

            this.mSharedElementTransition = null;
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl v0 = this.getHandlingImpl(this.mTransition);
            FragmentTransitionImpl v1 = this.getHandlingImpl(this.mSharedElementTransition);
            if(v0 != null && v1 != null) {
                if(v0 == v1) {
                }
                else {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
                }
            }

            if(v0 != null) {
                return v0;
            }

            return v1;
        }

        private FragmentTransitionImpl getHandlingImpl(Object arg4) {
            if(arg4 == null) {
                return null;
            }

            if(FragmentTransition.PLATFORM_IMPL != null && (FragmentTransition.PLATFORM_IMPL.canHandle(arg4))) {
                return FragmentTransition.PLATFORM_IMPL;
            }

            if(FragmentTransition.SUPPORT_IMPL != null && (FragmentTransition.SUPPORT_IMPL.canHandle(arg4))) {
                return FragmentTransition.SUPPORT_IMPL;
            }

            throw new IllegalArgumentException("Transition " + arg4 + " for fragment " + this.getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if(this.mSharedElementTransition != null) {
                return 1;
            }

            return 0;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }
    }

    DefaultSpecialEffectsController(ViewGroup arg1) {
        super(arg1);
    }

    void applyContainerChanges(Operation arg1) {
        arg1.getFinalState().applyState(arg1.getFragment().mView);
    }

    void captureTransitioningViews(ArrayList arg5, View arg6) {
        if((arg6 instanceof ViewGroup)) {
            View v0 = arg6;
            if(!ViewGroupCompat.isTransitionGroup(((ViewGroup)v0))) {
                int v6 = ((ViewGroup)v0).getChildCount();
                int v1;
                for(v1 = 0; v1 < v6; ++v1) {
                    View v2 = ((ViewGroup)v0).getChildAt(v1);
                    if(v2.getVisibility() == 0) {
                        this.captureTransitioningViews(arg5, v2);
                    }
                }
            }
            else if(!arg5.contains(arg6)) {
                arg5.add(v0);
                return;
            }
        }
        else {
            if(arg5.contains(arg6)) {
                return;
            }

            arg5.add(arg6);
        }
    }

    void executeOperations(List arg11, boolean arg12) {
        Object v1;
        Iterator v0 = arg11.iterator();
        Object v6 = null;
        Object v7 = v6;
        while(v0.hasNext()) {
            v1 = v0.next();
            State v2 = State.from(((Operation)v1).getFragment().mView);
            int v3 = androidx.fragment.app.DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[((Operation)v1).getFinalState().ordinal()];
            if(v3 != 1 && v3 != 2 && v3 != 3) {
                if(v3 != 4) {
                }
                else {
                    if(v2 == State.VISIBLE) {
                        continue;
                    }

                    v7 = v1;
                }

                continue;
            }

            if(v2 != State.VISIBLE) {
                continue;
            }

            if(v6 != null) {
                continue;
            }

            v6 = v1;
        }

        ArrayList v0_1 = new ArrayList();
        ArrayList v3_1 = new ArrayList();
        ArrayList v4 = new ArrayList(((Collection)arg11));
        Iterator v11 = arg11.iterator();
        while(v11.hasNext()) {
            v1 = v11.next();
            CancellationSignal v2_1 = new CancellationSignal();
            ((Operation)v1).markStartedSpecialEffect(v2_1);
            ((List)v0_1).add(new AnimationInfo(((Operation)v1), v2_1, arg12));
            v2_1 = new CancellationSignal();
            ((Operation)v1).markStartedSpecialEffect(v2_1);
            boolean v9 = false;
            if(arg12) {
                if(v1 == v6) {
                    goto label_57;
                }
            }
            else if(v1 == v7) {
            label_57:
                v9 = true;
            }

            ((List)v3_1).add(new TransitionInfo(((Operation)v1), v2_1, arg12, v9));
            ((Operation)v1).addCompletionListener(new Runnable(((List)v4), ((Operation)v1)) {
                public void run() {
                    if(this.val$awaitingContainerChanges.contains(this.val$operation)) {
                        this.val$awaitingContainerChanges.remove(this.val$operation);
                        DefaultSpecialEffectsController.this.applyContainerChanges(this.val$operation);
                    }
                }
            });
        }

        DefaultSpecialEffectsController v2_2 = this;
        Map v10 = v2_2.startTransitions(((List)v3_1), ((List)v4), arg12, ((Operation)v6), ((Operation)v7));
        v2_2.startAnimations(((List)v0_1), ((List)v4), v10.containsValue(Boolean.valueOf(true)), v10);
        Iterator v10_1 = ((List)v4).iterator();
        while(v10_1.hasNext()) {
            v2_2.applyContainerChanges(v10_1.next());
        }

        ((List)v4).clear();
    }

    void findNamedViews(Map arg5, View arg6) {
        String v0 = ViewCompat.getTransitionName(arg6);
        if(v0 != null) {
            arg5.put(v0, arg6);
        }

        if((arg6 instanceof ViewGroup)) {
            int v0_1 = ((ViewGroup)arg6).getChildCount();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                View v2 = ((ViewGroup)arg6).getChildAt(v1);
                if(v2.getVisibility() == 0) {
                    this.findNamedViews(arg5, v2);
                }
            }
        }
    }

    void retainMatchingViews(ArrayMap arg1, Collection arg2) {
        Iterator v0 = arg1.entrySet().iterator();
        while(v0.hasNext()) {
            if(arg2.contains(ViewCompat.getTransitionName(v0.next().getValue()))) {
                continue;
            }

            v0.remove();
        }
    }

    private void startAnimations(List arg16, List arg17, boolean arg18, Map arg19) {
        Object v6;
        String v3;
        ViewGroup v2 = this.getContainer();
        Context v7 = v2.getContext();
        ArrayList v8 = new ArrayList();
        Iterator v9 = arg16.iterator();
        int v0;
        for(v0 = 0; true; v0 = 1) {
        label_7:
            v3 = "FragmentManager";
            int v4 = 2;
            if(!v9.hasNext()) {
                break;
            }

            v6 = v9.next();
            if(((AnimationInfo)v6).isVisibilityUnchanged()) {
                ((AnimationInfo)v6).completeSpecialEffect();
                goto label_7;
            }

            AnimationOrAnimator v1 = ((AnimationInfo)v6).getAnimation(v7);
            if(v1 == null) {
                ((AnimationInfo)v6).completeSpecialEffect();
                goto label_7;
            }

            Animator v11 = v1.animator;
            if(v11 == null) {
                v8.add(v6);
                goto label_7;
            }

            Operation v5 = ((AnimationInfo)v6).getOperation();
            Fragment v1_1 = v5.getFragment();
            if(Boolean.TRUE.equals(arg19.get(v5))) {
                if(FragmentManager.isLoggingEnabled(v4)) {
                    Log.v(v3, "Ignoring Animator set on " + v1_1 + " as this Fragment was involved in a Transition.");
                }

                ((AnimationInfo)v6).completeSpecialEffect();
                goto label_7;
            }

            boolean v4_1 = v5.getFinalState() == State.GONE ? true : false;
            List v14 = arg17;
            if(v4_1) {
                v14.remove(v5);
            }

            View v3_1 = v1_1.mView;
            v2.startViewTransition(v3_1);
            v11.addListener(new AnimatorListenerAdapter(v2, v3_1, v4_1, v5, ((AnimationInfo)v6)) {
                public void onAnimationEnd(Animator arg2) {
                    this.val$container.endViewTransition(this.val$viewToAnimate);
                    if(this.val$isHideOperation) {
                        this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
                    }

                    this.val$animationInfo.completeSpecialEffect();
                }
            });
            v11.setTarget(v3_1);
            v11.start();
            ((AnimationInfo)v6).getSignal().setOnCancelListener(new OnCancelListener(v11) {
                public void onCancel() {
                    this.val$animator.end();
                }
            });
        }

        Iterator v5_1 = v8.iterator();
        while(v5_1.hasNext()) {
            v6 = v5_1.next();
            Operation v8_1 = ((AnimationInfo)v6).getOperation();
            Fragment v9_1 = v8_1.getFragment();
            String v10 = "Ignoring Animation set on ";
            if(arg18) {
                if(FragmentManager.isLoggingEnabled(v4)) {
                    Log.v(v3, v10 + v9_1 + " as Animations cannot run alongside Transitions.");
                }

                ((AnimationInfo)v6).completeSpecialEffect();
                continue;
            }

            if(v0 != 0) {
                if(FragmentManager.isLoggingEnabled(v4)) {
                    Log.v(v3, v10 + v9_1 + " as Animations cannot run alongside Animators.");
                }

                ((AnimationInfo)v6).completeSpecialEffect();
                continue;
            }

            View v9_2 = v9_1.mView;
            Object v10_1 = Preconditions.checkNotNull(Preconditions.checkNotNull(((AnimationInfo)v6).getAnimation(v7)).animation);
            if(v8_1.getFinalState() != State.REMOVED) {
                v9_2.startAnimation(((Animation)v10_1));
                ((AnimationInfo)v6).completeSpecialEffect();
            }
            else {
                v2.startViewTransition(v9_2);
                EndViewTransitionAnimation v8_2 = new EndViewTransitionAnimation(((Animation)v10_1), v2, v9_2);
                ((Animation)v8_2).setAnimationListener(new Animation$AnimationListener(v2, v9_2, ((AnimationInfo)v6)) {
                    public void onAnimationEnd(Animation arg2) {
                        this.val$container.post(new Runnable() {
                            public void run() {
                                this.this$1.val$container.endViewTransition(this.this$1.val$viewToAnimate);
                                this.this$1.val$animationInfo.completeSpecialEffect();
                            }
                        });
                    }

                    public void onAnimationRepeat(Animation arg1) {
                    }

                    public void onAnimationStart(Animation arg1) {
                    }
                });
                v9_2.startAnimation(((Animation)v8_2));
            }

            ((AnimationInfo)v6).getSignal().setOnCancelListener(new OnCancelListener(v9_2, v2, ((AnimationInfo)v6)) {
                public void onCancel() {
                    this.val$viewToAnimate.clearAnimation();
                    this.val$container.endViewTransition(this.val$viewToAnimate);
                    this.val$animationInfo.completeSpecialEffect();
                }
            });
        }
    }

    private Map startTransitions(List arg29, List arg30, boolean arg31, Operation arg32, Operation arg33) {
        Operation v12_2;
        Object v9_3;
        View v21_1;
        Object v4_3;
        ArrayList v25;
        ArrayList v27;
        int v4_2;
        Operation v2_2;
        Operation v3_5;
        Object v13_1;
        int v18;
        ArrayList v9_2;
        ArrayMap v19;
        ArrayList v4_1;
        Rect v5_4;
        View v7_1;
        Object v3_3;
        int v22;
        Object v21;
        Object v5_2;
        int v0_3;
        SharedElementCallback v3_2;
        SharedElementCallback v0_2;
        Object v20;
        ArrayList v7;
        Object v2;
        DefaultSpecialEffectsController v1 = this;
        boolean v4 = arg31;
        HashMap v6 = new HashMap();
        Iterator v0 = arg29.iterator();
        FragmentTransitionImpl v8 = null;
        while(true) {
            if(!v0.hasNext()) {
                goto label_35;
            }

            v2 = v0.next();
            if(((TransitionInfo)v2).isVisibilityUnchanged()) {
                continue;
            }

            FragmentTransitionImpl v3 = ((TransitionInfo)v2).getHandlingImpl();
            if(v8 == null) {
                v8 = v3;
                continue;
            }

            if(v3 == null) {
                continue;
            }

            if(v8 != v3) {
                break;
            }
        }

        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + ((TransitionInfo)v2).getOperation().getFragment() + " returned Transition " + ((TransitionInfo)v2).getTransition() + " which uses a different Transition  type than other Fragments.");
    label_35:
        int v9 = 0;
        if(v8 == null) {
            v0 = arg29.iterator();
            goto label_38;
        }
        else {
            View v10 = new View(v1.getContainer().getContext());
            Rect v11 = new Rect();
            ArrayList v12 = new ArrayList();
            ArrayList v15 = new ArrayList();
            ArrayMap v13 = new ArrayMap();
            Iterator v16 = arg29.iterator();
            int v17 = 0;
            Object v0_1 = null;
            Object v14 = null;
            while(v16.hasNext()) {
                v2 = v16.next();
                if(!((TransitionInfo)v2).hasSharedElementTransition() || arg32 == null || arg33 == null) {
                    v18 = v9;
                    v7_1 = v10;
                    v5_4 = v11;
                    v4_1 = v12;
                    v19 = v13;
                    v9_2 = v15;
                    v14 = v14;
                }
                else {
                    v0_1 = v8.wrapTransitionInSet(v8.cloneTransition(((TransitionInfo)v2).getSharedElementTransition()));
                    ArrayList v2_1 = arg33.getFragment().getSharedElementSourceNames();
                    ArrayList v5 = arg32.getFragment().getSharedElementSourceNames();
                    v7 = arg32.getFragment().getSharedElementTargetNames();
                    while(v9 < v7.size()) {
                        int v3_1 = v2_1.indexOf(v7.get(v9));
                        v20 = v0_1;
                        if(v3_1 != -1) {
                            v2_1.set(v3_1, v5.get(v9));
                        }

                        ++v9;
                        v0_1 = v20;
                    }

                    v20 = v0_1;
                    v7 = arg33.getFragment().getSharedElementTargetNames();
                    if(!v4) {
                        v0_2 = arg32.getFragment().getExitTransitionCallback();
                        v3_2 = arg33.getFragment().getEnterTransitionCallback();
                    }
                    else {
                        v0_2 = arg32.getFragment().getEnterTransitionCallback();
                        v3_2 = arg33.getFragment().getExitTransitionCallback();
                    }

                    int v5_1 = v2_1.size();
                    v9 = 0;
                    while(v9 < v5_1) {
                        v13.put(v2_1.get(v9), v7.get(v9));
                        ++v9;
                        v5_1 = v5_1;
                    }

                    ArrayMap v9_1 = new ArrayMap();
                    v1.findNamedViews(((Map)v9_1), arg32.getFragment().mView);
                    v9_1.retainAll(((Collection)v2_1));
                    if(v0_2 != null) {
                        v0_2.onMapSharedElements(((List)v2_1), ((Map)v9_1));
                        v0_3 = v2_1.size() - 1;
                        goto label_127;
                    }
                    else {
                        v13.retainAll(v9_1.keySet());
                        goto label_145;
                    label_127:
                        while(v0_3 >= 0) {
                            v5_2 = v2_1.get(v0_3);
                            v21 = v9_1.get(v5_2);
                            if(v21 == null) {
                                v13.remove(v5_2);
                                v22 = v0_3;
                            }
                            else {
                                v22 = v0_3;
                                if(!((String)v5_2).equals(ViewCompat.getTransitionName(((View)v21)))) {
                                    v13.put(ViewCompat.getTransitionName(((View)v21)), v13.remove(v5_2));
                                }
                            }

                            v0_3 = v22 - 1;
                        }
                    }

                label_145:
                    ArrayMap v5_3 = new ArrayMap();
                    v1.findNamedViews(((Map)v5_3), arg33.getFragment().mView);
                    v5_3.retainAll(((Collection)v7));
                    v5_3.retainAll(v13.values());
                    if(v3_2 != null) {
                        v3_2.onMapSharedElements(((List)v7), ((Map)v5_3));
                        for(v0_3 = v7.size() - 1; v0_3 >= 0; v0_3 = v22 - 1) {
                            v3_3 = v7.get(v0_3);
                            v21 = v5_3.get(v3_3);
                            if(v21 == null) {
                                String v3_4 = FragmentTransition.findKeyForValue(v13, ((String)v3_3));
                                if(v3_4 != null) {
                                    v13.remove(v3_4);
                                }

                                v22 = v0_3;
                            }
                            else {
                                v22 = v0_3;
                                if(((String)v3_3).equals(ViewCompat.getTransitionName(((View)v21)))) {
                                    goto label_174;
                                }

                                String v0_4 = FragmentTransition.findKeyForValue(v13, ((String)v3_3));
                                if(v0_4 == null) {
                                    goto label_174;
                                }

                                v13.put(v0_4, ViewCompat.getTransitionName(((View)v21)));
                            }

                        label_174:
                        }
                    }
                    else {
                        FragmentTransition.retainValues(v13, v5_3);
                    }

                    v1.retainMatchingViews(v9_1, v13.keySet());
                    v1.retainMatchingViews(v5_3, v13.values());
                    if(v13.isEmpty()) {
                        v12.clear();
                        v15.clear();
                        v7_1 = v10;
                        v5_4 = v11;
                        v4_1 = v12;
                        v19 = v13;
                        v9_2 = v15;
                        v0_1 = null;
                        v18 = 0;
                        goto label_270;
                    }

                    FragmentTransition.callSharedElementStartEnd(arg33.getFragment(), arg32.getFragment(), v4, v9_1, true);
                    v19 = v13;
                    v21 = v14;
                    v13_1 = v20;
                    v1 = this;
                    ArrayList v20_1 = v2_1;
                    v3_5 = arg32;
                    v2_2 = arg33;
                    OneShotPreDrawListener.add(this.getContainer(), new Runnable(v2_2, v3_5, v4, v5_3) {
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
                        }
                    });
                    v12.addAll(v9_1.values());
                    if(!v20_1.isEmpty()) {
                        v4_2 = 0;
                        v0_1 = v9_1.get(v20_1.get(0));
                        v8.setEpicenter(v13_1, ((View)v0_1));
                    }
                    else {
                        v4_2 = 0;
                        v0_1 = v21;
                    }

                    v15.addAll(v5_3.values());
                    if(!v7.isEmpty()) {
                        v5_2 = v5_3.get(v7.get(v4_2));
                        if(v5_2 != null) {
                            OneShotPreDrawListener.add(v1.getContainer(), new Runnable(v8, ((View)v5_2), v11) {
                                public void run() {
                                    this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
                                }
                            });
                            v17 = 1;
                        }
                    }

                    v8.setSharedElementTargets(v13_1, v10, v12);
                    v7_1 = v10;
                    v18 = v4_2;
                    v4_1 = v12;
                    v5_4 = v11;
                    v8.scheduleRemoveTargets(v13_1, null, null, null, null, v13_1, v15);
                    v9_2 = v15;
                    ((Map)v6).put(v3_5, Boolean.valueOf(true));
                    ((Map)v6).put(v2_2, Boolean.valueOf(true));
                    v14 = v0_1;
                    v0_1 = v13_1;
                }

            label_270:
                v12 = v4_1;
                v11 = v5_4;
                v10 = v7_1;
                v15 = v9_2;
                v9 = v18;
                v13 = v19;
                v4 = arg31;
            }

            v3_5 = arg32;
            v2_2 = arg33;
            boolean v18_1 = ((boolean)v9);
            v7_1 = v10;
            v5_4 = v11;
            v4_1 = v12;
            v19 = v13;
            v21 = v14;
            v9_2 = v15;
            ArrayList v10_1 = new ArrayList();
            v16 = arg29.iterator();
            Object v11_1 = null;
            Object v12_1 = null;
            while(v16.hasNext()) {
                v20 = v16.next();
                if(((TransitionInfo)v20).isVisibilityUnchanged()) {
                    ((Map)v6).put(((TransitionInfo)v20).getOperation(), Boolean.valueOf(v18_1));
                    ((TransitionInfo)v20).completeSpecialEffect();
                    continue;
                }

                v13_1 = v8.cloneTransition(((TransitionInfo)v20).getTransition());
                Operation v14_1 = ((TransitionInfo)v20).getOperation();
                if(v0_1 != null) {
                    if(v14_1 != v3_5 && v14_1 != v2_2) {
                        goto label_312;
                    }

                    int v15_1 = 1;
                }
                else {
                label_312:
                    boolean v15_2 = v18_1;
                }

                if(v13_1 == null) {
                    if(!(((boolean)v15_1))) {
                        ((Map)v6).put(v14_1, Boolean.valueOf(v18_1));
                        ((TransitionInfo)v20).completeSpecialEffect();
                    }

                    v27 = v4_1;
                    v25 = v9_2;
                    v4_3 = v11_1;
                    v3_3 = v21;
                    v21_1 = v7_1;
                    v7 = v10_1;
                }
                else {
                    Object v23 = v11_1;
                    ArrayList v11_2 = new ArrayList();
                    ArrayList v31 = v10_1;
                    v1.captureTransitioningViews(v11_2, v14_1.getFragment().mView);
                    if((((boolean)v15_1))) {
                        if(v14_1 == v3_5) {
                            v11_2.removeAll(((Collection)v4_1));
                        }
                        else {
                            v11_2.removeAll(((Collection)v9_2));
                        }
                    }

                    if(v11_2.isEmpty()) {
                        v8.addTarget(v13_1, v7_1);
                        v27 = v4_1;
                        v25 = v9_2;
                        v2 = v12_1;
                        v9_3 = v13_1;
                        v12_2 = v14_1;
                        v3_3 = v21;
                        v4_3 = v23;
                        v21_1 = v7_1;
                        v7 = v31;
                    }
                    else {
                        v8.addTargets(v13_1, v11_2);
                        v25 = v9_2;
                        v9_3 = v13_1;
                        Operation v26 = v14_1;
                        v27 = v4_1;
                        v3_3 = v21;
                        v4_3 = v23;
                        v2 = v12_1;
                        v21_1 = v7_1;
                        v7 = v31;
                        v8.scheduleRemoveTargets(v9_3, v9_3, v11_2, null, null, null, null);
                        if(v26.getFinalState() == State.GONE) {
                            v12_2 = v26;
                            arg30.remove(v12_2);
                            ArrayList v13_2 = new ArrayList(((Collection)v11_2));
                            v13_2.remove(v12_2.getFragment().mView);
                            v8.scheduleHideFragmentView(v9_3, v12_2.getFragment().mView, v13_2);
                            OneShotPreDrawListener.add(v1.getContainer(), new Runnable(v11_2) {
                                public void run() {
                                    FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
                                }
                            });
                        }
                        else {
                            v12_2 = v26;
                        }
                    }

                    if(v12_2.getFinalState() == State.VISIBLE) {
                        v7.addAll(((Collection)v11_2));
                        if(v17 != 0) {
                            v8.setEpicenter(v9_3, v5_4);
                        }
                    }
                    else {
                        v8.setEpicenter(v9_3, ((View)v3_3));
                    }

                    ((Map)v6).put(v12_2, Boolean.valueOf(true));
                    if(((TransitionInfo)v20).isOverlapAllowed()) {
                        v4_3 = v8.mergeTransitionsTogether(v4_3, v9_3, null);
                    }
                    else {
                        v2 = v8.mergeTransitionsTogether(v2, v9_3, null);
                    }

                    v12_1 = v2;
                }

                v2_2 = arg33;
                v11_1 = v4_3;
                v10_1 = v7;
                v7_1 = v21_1;
                v9_2 = v25;
                v4_1 = v27;
                v21 = v3_3;
                v3_5 = arg32;
            }

            v27 = v4_1;
            v25 = v9_2;
            v7 = v10_1;
            v2 = v8.mergeTransitionsInSequence(v11_1, v12_1, v0_1);
            Iterator v3_6 = arg29.iterator();
            while(v3_6.hasNext()) {
                v4_3 = v3_6.next();
                if(((TransitionInfo)v4_3).isVisibilityUnchanged()) {
                    continue;
                }

                v5_2 = ((TransitionInfo)v4_3).getTransition();
                Operation v9_4 = ((TransitionInfo)v4_3).getOperation();
                Operation v10_2 = arg32;
                Operation v11_3 = arg33;
                if(v0_1 != null) {
                    if(v9_4 != v10_2 && v9_4 != v11_3) {
                        goto label_441;
                    }

                    int v12_3 = 1;
                }
                else {
                label_441:
                    boolean v12_4 = v18_1;
                }

                if(v5_2 == null && !v12_4) {
                    continue;
                }

                if(!ViewCompat.isLaidOut(v1.getContainer())) {
                    if(FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + v1.getContainer() + " has not been laid out. Completing operation " + v9_4);
                    }

                    ((TransitionInfo)v4_3).completeSpecialEffect();
                    continue;
                }

                v8.setListenerForTransitionEnd(((TransitionInfo)v4_3).getOperation().getFragment(), v2, ((TransitionInfo)v4_3).getSignal(), new Runnable(((TransitionInfo)v4_3)) {
                    public void run() {
                        this.val$transitionInfo.completeSpecialEffect();
                    }
                });
            }

            if(!ViewCompat.isLaidOut(v1.getContainer())) {
                goto label_473;
            }

            FragmentTransition.setViewVisibility(v7, 4);
            ArrayList v3_7 = v8.prepareSetNameOverridesReordered(v25);
            v8.beginDelayedTransition(v1.getContainer(), v2);
            v8.setNameOverridesReordered(v1.getContainer(), v27, v25, v3_7, v19);
            FragmentTransition.setViewVisibility(v7, ((int)v18_1));
            v8.swapSharedElementTargets(v0_1, v27, v25);
            return ((Map)v6);
        label_38:
            while(v0.hasNext()) {
                Object v1_1 = v0.next();
                ((Map)v6).put(((TransitionInfo)v1_1).getOperation(), Boolean.valueOf(false));
                ((TransitionInfo)v1_1).completeSpecialEffect();
            }
        }

    label_473:
        return ((Map)v6);
    }
}

