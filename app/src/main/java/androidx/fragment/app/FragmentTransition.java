package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class FragmentTransition {
    interface Callback {
        void onComplete(Fragment arg1, CancellationSignal arg2);

        void onStart(Fragment arg1, CancellationSignal arg2);
    }

    class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
            super();
        }
    }

    private static final int[] INVERSE_OPS;
    static final FragmentTransitionImpl PLATFORM_IMPL;
    static final FragmentTransitionImpl SUPPORT_IMPL;

    static {
        FragmentTransition.INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        FragmentTransition.PLATFORM_IMPL = new FragmentTransitionCompat21();
        FragmentTransition.SUPPORT_IMPL = FragmentTransition.resolveSupportImpl();
    }

    private FragmentTransition() {
        super();
    }

    private static void addSharedElementsWithMatchingNames(ArrayList arg3, ArrayMap arg4, Collection arg5) {
        int v0;
        for(v0 = arg4.size() - 1; v0 >= 0; --v0) {
            Object v1 = arg4.valueAt(v0);
            if(arg5.contains(ViewCompat.getTransitionName(((View)v1)))) {
                arg3.add(v1);
            }
        }
    }

    private static void addToFirstInLastOut(BackStackRecord arg8, Op arg9, SparseArray arg10, boolean arg11, boolean arg12) {
        FragmentContainerTransition v5_1;
        boolean v9_1;
        int v4;
        Fragment v0 = arg9.mFragment;
        if(v0 == null) {
        }
        else {
            int v1 = v0.mContainerId;
            if(v1 == 0) {
            }
            else {
                int v9 = arg11 ? FragmentTransition.INVERSE_OPS[arg9.mCmd] : arg9.mCmd;
                boolean v2 = false;
                int v3 = 1;
                if(v9 != 1) {
                    if(v9 == 3) {
                    label_52:
                        if(arg12) {
                            if(v0.mAdded) {
                                goto label_65;
                            }
                            else if(v0.mView == null) {
                                goto label_65;
                            }
                            else if(v0.mView.getVisibility() == 0) {
                                if(v0.mPostponedAlpha < 0f) {
                                    goto label_65;
                                }

                                goto label_63;
                            }
                            else {
                                goto label_65;
                            }
                        }
                        else if(!v0.mAdded) {
                        label_65:
                            v9 = 0;
                        }
                        else if(!v0.mHidden) {
                        label_63:
                            v9 = 1;
                        }
                        else {
                            goto label_65;
                        }
                    }
                    else if(v9 != 4) {
                        if(v9 != 5) {
                            if(v9 == 6) {
                                goto label_52;
                            }
                            else if(v9 != 7) {
                                v9 = 0;
                                v3 = 0;
                                v4 = 0;
                                goto label_89;
                            }
                            else {
                                goto label_76;
                            }
                        }
                        else if(!arg12) {
                            v9_1 = v0.mHidden;
                            goto label_86;
                        }
                        else if(!v0.mHiddenChanged) {
                            goto label_85;
                        }
                        else if(v0.mHidden) {
                            goto label_85;
                        }
                        else if(v0.mAdded) {
                            goto label_83;
                        }
                        else {
                            goto label_85;
                        }
                    }
                    else if(arg12) {
                        if(!v0.mHiddenChanged) {
                            goto label_65;
                        }
                        else if(!v0.mAdded) {
                            goto label_65;
                        }
                        else if(v0.mHidden) {
                            goto label_63;
                        }
                        else {
                            goto label_65;
                        }
                    }
                    else if(!v0.mAdded) {
                        goto label_65;
                    }
                    else if(!v0.mHidden) {
                        goto label_63;
                    }
                    else {
                        goto label_65;
                    }

                    v4 = v9;
                    v9 = 1;
                    v3 = 0;
                }
                else {
                label_76:
                    if(arg12) {
                        v9_1 = v0.mIsNewlyAdded;
                        goto label_86;
                    }

                    if(!v0.mAdded) {
                        if(v0.mHidden) {
                            goto label_85;
                        }

                    label_83:
                        v9_1 = true;
                    }
                    else {
                    label_85:
                        v9_1 = false;
                    }

                label_86:
                    v4 = 0;
                    v2 = v9_1;
                    v9 = 0;
                }

            label_89:
                Object v5 = arg10.get(v1);
                if(v2) {
                    v5_1 = FragmentTransition.ensureContainer(((FragmentContainerTransition)v5), arg10, v1);
                    v5_1.lastIn = v0;
                    v5_1.lastInIsPop = arg11;
                    v5_1.lastInTransaction = arg8;
                }

                Fragment v2_1 = null;
                if(!arg12 && v3 != 0) {
                    if(v5 != null && ((FragmentContainerTransition)v5).firstOut == v0) {
                        ((FragmentContainerTransition)v5).firstOut = v2_1;
                    }

                    if(arg8.mReorderingAllowed) {
                        goto label_109;
                    }

                    FragmentManager v3_1 = arg8.mManager;
                    v3_1.getFragmentStore().makeActive(v3_1.createOrGetFragmentStateManager(v0));
                    v3_1.moveToState(v0);
                }

            label_109:
                if(v4 != 0 && (v5 == null || ((FragmentContainerTransition)v5).firstOut == null)) {
                    v5_1 = FragmentTransition.ensureContainer(((FragmentContainerTransition)v5), arg10, v1);
                    v5_1.firstOut = v0;
                    v5_1.firstOutIsPop = arg11;
                    v5_1.firstOutTransaction = arg8;
                }

                if(arg12) {
                    return;
                }

                if(v9 == 0) {
                    return;
                }

                if(v5 == null) {
                    return;
                }

                if(((FragmentContainerTransition)v5).lastIn != v0) {
                    return;
                }

                ((FragmentContainerTransition)v5).lastIn = v2_1;
            }
        }
    }

    public static void calculateFragments(BackStackRecord arg4, SparseArray arg5, boolean arg6) {
        int v0 = arg4.mOps.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            FragmentTransition.addToFirstInLastOut(arg4, arg4.mOps.get(v2), arg5, false, arg6);
        }
    }

    private static ArrayMap calculateNameOverrides(int arg9, ArrayList arg10, ArrayList arg11, int arg12, int arg13) {
        ArrayList v1_1;
        ArrayList v2_1;
        ArrayMap v0 = new ArrayMap();
        --arg13;
        while(arg13 >= arg12) {
            Object v1 = arg10.get(arg13);
            if(!((BackStackRecord)v1).interactsWith(arg9)) {
            }
            else {
                boolean v2 = arg11.get(arg13).booleanValue();
                if(((BackStackRecord)v1).mSharedElementSourceNames != null) {
                    int v3 = ((BackStackRecord)v1).mSharedElementSourceNames.size();
                    if(v2) {
                        v2_1 = ((BackStackRecord)v1).mSharedElementSourceNames;
                        v1_1 = ((BackStackRecord)v1).mSharedElementTargetNames;
                    }
                    else {
                        ArrayList v8 = ((BackStackRecord)v1).mSharedElementSourceNames;
                        v2_1 = ((BackStackRecord)v1).mSharedElementTargetNames;
                        v1_1 = v8;
                    }

                    int v4;
                    for(v4 = 0; v4 < v3; ++v4) {
                        Object v5 = v1_1.get(v4);
                        Object v6 = v2_1.get(v4);
                        Object v7 = v0.remove(v6);
                        if(v7 != null) {
                            v0.put(v5, v7);
                        }
                        else {
                            v0.put(v5, v6);
                        }
                    }
                }
            }

            --arg13;
        }

        return v0;
    }

    public static void calculatePopFragments(BackStackRecord arg3, SparseArray arg4, boolean arg5) {
        if(!arg3.mManager.getContainer().onHasView()) {
        }
        else {
            int v0;
            for(v0 = arg3.mOps.size() - 1; v0 >= 0; --v0) {
                FragmentTransition.addToFirstInLastOut(arg3, arg3.mOps.get(v0), arg4, true, arg5);
            }
        }
    }

    static void callSharedElementStartEnd(Fragment arg3, Fragment arg4, boolean arg5, ArrayMap arg6, boolean arg7) {
        SharedElementCallback v3 = arg5 ? arg4.getEnterTransitionCallback() : arg3.getEnterTransitionCallback();
        if(v3 != null) {
            ArrayList v4 = new ArrayList();
            ArrayList v5 = new ArrayList();
            int v0 = 0;
            int v1 = arg6 == null ? 0 : arg6.size();
            while(v0 < v1) {
                v5.add(arg6.keyAt(v0));
                v4.add(arg6.valueAt(v0));
                ++v0;
            }

            List v6 = null;
            if(arg7) {
                v3.onSharedElementStart(((List)v5), ((List)v4), v6);
                return;
            }

            v3.onSharedElementEnd(((List)v5), ((List)v4), v6);
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl arg4, List arg5) {
        int v0 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!arg4.canHandle(arg5.get(v2))) {
                return 0;
            }
        }

        return 1;
    }

    static ArrayMap captureInSharedElements(FragmentTransitionImpl arg3, ArrayMap arg4, Object arg5, FragmentContainerTransition arg6) {
        String v0_2;
        ArrayList v3_1;
        SharedElementCallback v6;
        Fragment v0 = arg6.lastIn;
        View v1 = v0.getView();
        if(!arg4.isEmpty() && arg5 != null) {
            if(v1 == null) {
            }
            else {
                ArrayMap v5 = new ArrayMap();
                arg3.findNamedViews(((Map)v5), v1);
                BackStackRecord v3 = arg6.lastInTransaction;
                if(arg6.lastInIsPop) {
                    v6 = v0.getExitTransitionCallback();
                    v3_1 = v3.mSharedElementSourceNames;
                }
                else {
                    v6 = v0.getEnterTransitionCallback();
                    v3_1 = v3.mSharedElementTargetNames;
                }

                if(v3_1 != null) {
                    v5.retainAll(((Collection)v3_1));
                    v5.retainAll(arg4.values());
                }

                if(v6 != null) {
                    v6.onMapSharedElements(((List)v3_1), ((Map)v5));
                    int v6_1;
                    for(v6_1 = v3_1.size() - 1; v6_1 >= 0; --v6_1) {
                        Object v0_1 = v3_1.get(v6_1);
                        Object v1_1 = v5.get(v0_1);
                        if(v1_1 == null) {
                            v0_2 = FragmentTransition.findKeyForValue(arg4, ((String)v0_1));
                            if(v0_2 != null) {
                                arg4.remove(v0_2);
                            }
                        }
                        else if(!((String)v0_1).equals(ViewCompat.getTransitionName(((View)v1_1)))) {
                            v0_2 = FragmentTransition.findKeyForValue(arg4, ((String)v0_1));
                            if(v0_2 != null) {
                                arg4.put(v0_2, ViewCompat.getTransitionName(((View)v1_1)));
                            }
                        }
                    }

                    return v5;
                }

                FragmentTransition.retainValues(arg4, v5);
                return v5;
            }
        }

        arg4.clear();
        return null;
    }

    private static ArrayMap captureOutSharedElements(FragmentTransitionImpl arg3, ArrayMap arg4, Object arg5, FragmentContainerTransition arg6) {
        ArrayList v3_1;
        SharedElementCallback v5_1;
        if(!arg4.isEmpty()) {
            if(arg5 == null) {
            }
            else {
                Fragment v5 = arg6.firstOut;
                ArrayMap v0 = new ArrayMap();
                arg3.findNamedViews(((Map)v0), v5.requireView());
                BackStackRecord v3 = arg6.firstOutTransaction;
                if(arg6.firstOutIsPop) {
                    v5_1 = v5.getEnterTransitionCallback();
                    v3_1 = v3.mSharedElementTargetNames;
                }
                else {
                    v5_1 = v5.getExitTransitionCallback();
                    v3_1 = v3.mSharedElementSourceNames;
                }

                if(v3_1 != null) {
                    v0.retainAll(((Collection)v3_1));
                }

                if(v5_1 != null) {
                    v5_1.onMapSharedElements(((List)v3_1), ((Map)v0));
                    int v5_2;
                    for(v5_2 = v3_1.size() - 1; v5_2 >= 0; --v5_2) {
                        Object v6 = v3_1.get(v5_2);
                        Object v1 = v0.get(v6);
                        if(v1 == null) {
                            arg4.remove(v6);
                        }
                        else if(!((String)v6).equals(ViewCompat.getTransitionName(((View)v1)))) {
                            arg4.put(ViewCompat.getTransitionName(((View)v1)), arg4.remove(v6));
                        }
                    }

                    return v0;
                }

                arg4.retainAll(v0.keySet());
                return v0;
            }
        }

        arg4.clear();
        return null;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment arg2, Fragment arg3) {
        Object v2;
        ArrayList v0 = new ArrayList();
        if(arg2 != null) {
            Object v1 = arg2.getExitTransition();
            if(v1 != null) {
                v0.add(v1);
            }

            v1 = arg2.getReturnTransition();
            if(v1 != null) {
                v0.add(v1);
            }

            v2 = arg2.getSharedElementReturnTransition();
            if(v2 == null) {
                goto label_12;
            }

            v0.add(v2);
        }

    label_12:
        if(arg3 != null) {
            v2 = arg3.getEnterTransition();
            if(v2 != null) {
                v0.add(v2);
            }

            v2 = arg3.getReenterTransition();
            if(v2 != null) {
                v0.add(v2);
            }

            v2 = arg3.getSharedElementEnterTransition();
            if(v2 == null) {
                goto label_22;
            }

            v0.add(v2);
        }

    label_22:
        FragmentTransitionImpl v3 = null;
        if(v0.isEmpty()) {
            return v3;
        }

        FragmentTransitionImpl v2_1 = FragmentTransition.PLATFORM_IMPL;
        if(v2_1 != null && (FragmentTransition.canHandleAll(v2_1, ((List)v0)))) {
            return v2_1;
        }

        FragmentTransitionImpl v1_1 = FragmentTransition.SUPPORT_IMPL;
        if(v1_1 != null && (FragmentTransition.canHandleAll(v1_1, ((List)v0)))) {
            return v1_1;
        }

        if(v2_1 == null && v1_1 == null) {
            return v3;
        }

        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList configureEnteringExitingViews(FragmentTransitionImpl arg1, Object arg2, Fragment arg3, ArrayList arg4, View arg5) {
        if(arg2 != null) {
            ArrayList v0 = new ArrayList();
            View v3 = arg3.getView();
            if(v3 != null) {
                arg1.captureTransitioningViews(v0, v3);
            }

            if(arg4 != null) {
                v0.removeAll(((Collection)arg4));
            }

            if(!v0.isEmpty()) {
                v0.add(arg5);
                arg1.addTargets(arg2, v0);
            }

            return v0;
        }

        return null;
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl arg15, ViewGroup arg16, View arg17, ArrayMap arg18, FragmentContainerTransition arg19, ArrayList arg20, ArrayList arg21, Object arg22, Object arg23) {
        Rect v1_1;
        Object v3_1;
        View v14;
        FragmentContainerTransition v6 = arg19;
        ArrayList v10 = arg20;
        Object v11 = arg22;
        Fragment v7 = v6.lastIn;
        Fragment v8 = v6.firstOut;
        Object v1 = null;
        if(v7 != null) {
            if(v8 == null) {
            }
            else {
                boolean v9 = v6.lastInIsPop;
                Object v2 = arg18.isEmpty() ? v1 : FragmentTransition.getSharedElementTransition(arg15, v7, v8, v9);
                ArrayMap v12 = arg18;
                ArrayMap v3 = FragmentTransition.captureOutSharedElements(arg15, v12, v2, v6);
                if(v12.isEmpty()) {
                    v2 = v1;
                }
                else {
                    v10.addAll(v3.values());
                }

                if(v11 == null && arg23 == null && v2 == null) {
                    return v1;
                }

                FragmentTransition.callSharedElementStartEnd(v7, v8, v9, v3, true);
                if(v2 != null) {
                    Rect v13 = new Rect();
                    v14 = arg17;
                    arg15.setSharedElementTargets(v2, v14, v10);
                    FragmentTransition.setOutEpicenter(arg15, v2, arg23, v3, v6.firstOutIsPop, v6.firstOutTransaction);
                    v3_1 = v2;
                    if(v11 != null) {
                        arg15.setEpicenter(v11, v13);
                    }

                    v1_1 = v13;
                }
                else {
                    v14 = arg17;
                    v3_1 = v2;
                }

                OneShotPreDrawListener.add(arg16, new Runnable(arg15, v12, v3_1, v6, arg21, v14, v7, v8, v9, v10, v11, v1_1) {
                    public void run() {
                        ArrayMap v0 = FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
                        if(v0 != null) {
                            this.val$sharedElementsIn.addAll(v0.values());
                            this.val$sharedElementsIn.add(this.val$nonExistentView);
                        }

                        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, v0, false);
                        Object v1 = this.val$finalSharedElementTransition;
                        if(v1 != null) {
                            this.val$impl.swapSharedElementTargets(v1, this.val$sharedElementsOut, this.val$sharedElementsIn);
                            View v0_1 = FragmentTransition.getInEpicenterView(v0, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
                            if(v0_1 != null) {
                                this.val$impl.getBoundsOnScreen(v0_1, this.val$inEpicenter);
                            }
                        }
                    }
                });
                return v3_1;
            }
        }

        return v1;
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl arg15, ViewGroup arg16, View arg17, ArrayMap arg18, FragmentContainerTransition arg19, ArrayList arg20, ArrayList arg21, Object arg22, Object arg23) {
        Rect v7_1;
        View v1 = arg17;
        ArrayMap v2 = arg18;
        FragmentContainerTransition v6 = arg19;
        ArrayList v3 = arg20;
        ArrayList v4 = arg21;
        Object v7 = arg22;
        Fragment v8 = v6.lastIn;
        Fragment v9 = v6.firstOut;
        if(v8 != null) {
            v8.requireView().setVisibility(0);
        }

        Object v5 = null;
        if(v8 != null) {
            if(v9 == null) {
            }
            else {
                boolean v10 = v6.lastInIsPop;
                Object v11 = v2.isEmpty() ? v5 : FragmentTransition.getSharedElementTransition(arg15, v8, v9, v10);
                ArrayMap v12 = FragmentTransition.captureOutSharedElements(arg15, v2, v11, v6);
                ArrayMap v13 = FragmentTransition.captureInSharedElements(arg15, v2, v11, v6);
                if(v2.isEmpty()) {
                    if(v12 != null) {
                        v12.clear();
                    }

                    if(v13 != null) {
                        v13.clear();
                    }

                    v11 = v5;
                }
                else {
                    FragmentTransition.addSharedElementsWithMatchingNames(v3, v12, v2.keySet());
                    FragmentTransition.addSharedElementsWithMatchingNames(v4, v13, v2.values());
                }

                if(v7 == null && arg23 == null && v11 == null) {
                    return v5;
                }

                FragmentTransition.callSharedElementStartEnd(v8, v9, v10, v12, true);
                if(v11 != null) {
                    v4.add(v1);
                    arg15.setSharedElementTargets(v11, v1, v3);
                    FragmentTransition.setOutEpicenter(arg15, v11, arg23, v12, v6.firstOutIsPop, v6.firstOutTransaction);
                    Rect v5_1 = new Rect();
                    v1 = FragmentTransition.getInEpicenterView(v13, v6, v7, v10);
                    if(v1 != null) {
                        arg15.setEpicenter(v7, v5_1);
                    }

                    v7_1 = v5_1;
                    View v5_2 = v1;
                }
                else {
                    v7_1 = ((Rect)v5);
                }

                OneShotPreDrawListener.add(arg16, new Runnable(v8, v9, v10, v13, ((View)v5), arg15, v7_1) {
                    public void run() {
                        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
                        View v0 = this.val$epicenterView;
                        if(v0 != null) {
                            this.val$impl.getBoundsOnScreen(v0, this.val$epicenter);
                        }
                    }
                });
                return v11;
            }
        }

        return v5;
    }

    private static void configureTransitionsOrdered(ViewGroup arg16, FragmentContainerTransition arg17, View arg18, ArrayMap arg19, Callback arg20) {
        FragmentContainerTransition v4 = arg17;
        Callback v9 = arg20;
        Fragment v10 = v4.lastIn;
        Fragment v11 = v4.firstOut;
        FragmentTransitionImpl v0 = FragmentTransition.chooseImpl(v11, v10);
        if(v0 == null) {
        }
        else {
            boolean v1 = v4.lastInIsPop;
            boolean v2 = v4.firstOutIsPop;
            Object v1_1 = FragmentTransition.getEnterTransition(v0, v10, v1);
            Object v8 = FragmentTransition.getExitTransition(v0, v11, v2);
            ArrayList v5 = new ArrayList();
            ArrayList v6 = new ArrayList();
            Object v12 = FragmentTransition.configureSharedElementsOrdered(v0, arg16, arg18, arg19, v4, v5, v6, v1_1, v8);
            View v13 = arg18;
            ArrayMap v14 = arg19;
            v1_1 = v1_1;
            ArrayList v7 = v6;
            v6 = v5;
            if(v1_1 == null && v12 == null && v8 == null) {
                return;
            }

            ArrayList v15 = FragmentTransition.configureEnteringExitingViews(v0, v8, v11, v6, v13);
            if(v15 == null || (v15.isEmpty())) {
                v8 = null;
            }

            Object v2_1 = v8;
            v0.addTarget(v1_1, v13);
            Object v3 = v12;
            Object v5_1 = FragmentTransition.mergeTransitions(v0, v1_1, v2_1, v3, v10, v4.lastInIsPop);
            Fragment v8_1 = v10;
            if(v11 != null && v15 != null && (v15.size() > 0 || v6.size() > 0)) {
                CancellationSignal v4_1 = new CancellationSignal();
                v9.onStart(v11, v4_1);
                v0.setListenerForTransitionEnd(v11, v5_1, v4_1, new Runnable(v9, v11, v4_1) {
                    public void run() {
                        this.val$callback.onComplete(this.val$outFragment, this.val$signal);
                    }
                });
            }

            if(v5_1 == null) {
                return;
            }

            Object v6_1 = v3;
            ArrayList v3_1 = new ArrayList();
            v0.scheduleRemoveTargets(v5_1, v1_1, v3_1, v2_1, v15, v6_1, v7);
            FragmentTransition.scheduleTargetChange(v0, arg16, v8_1, v13, v7, v1_1, v3_1, v2_1, v15);
            v0.setNameOverridesOrdered(arg16, v7, ((Map)v14));
            v0.beginDelayedTransition(arg16, v5_1);
            v0.scheduleNameReset(arg16, v7, ((Map)v14));
        }
    }

    private static void configureTransitionsReordered(ViewGroup arg14, FragmentContainerTransition arg15, View arg16, ArrayMap arg17, Callback arg18) {
        Callback v9 = arg18;
        Fragment v10 = arg15.lastIn;
        Fragment v11 = arg15.firstOut;
        FragmentTransitionImpl v0 = FragmentTransition.chooseImpl(v11, v10);
        if(v0 == null) {
        }
        else {
            boolean v12 = arg15.lastInIsPop;
            boolean v1 = arg15.firstOutIsPop;
            ArrayList v3 = new ArrayList();
            ArrayList v2 = new ArrayList();
            Object v7 = FragmentTransition.getEnterTransition(v0, v10, v12);
            Object v8 = FragmentTransition.getExitTransition(v0, v11, v1);
            ArrayList v5 = v2;
            ArrayList v6 = v3;
            View v2_1 = arg16;
            Object v4 = FragmentTransition.configureSharedElementsReordered(v0, arg14, v2_1, arg17, arg15, v5, v6, v7, v8);
            Object v1_1 = v7;
            Object v3_1 = v8;
            ArrayList v8_1 = v5;
            if(v1_1 == null && v4 == null && v3_1 == null) {
                return;
            }

            ArrayList v7_1 = FragmentTransition.configureEnteringExitingViews(v0, v3_1, v11, v8_1, v2_1);
            ArrayList v13 = FragmentTransition.configureEnteringExitingViews(v0, v1_1, v10, v6, v2_1);
            FragmentTransition.setViewVisibility(v13, 4);
            Object v2_2 = v3_1;
            v3_1 = v4;
            v4 = FragmentTransition.mergeTransitions(v0, v1_1, v2_2, v3_1, v10, v12);
            if(v11 != null && v7_1 != null && (v7_1.size() > 0 || v8_1.size() > 0)) {
                CancellationSignal v5_1 = new CancellationSignal();
                v9.onStart(v11, v5_1);
                v0.setListenerForTransitionEnd(v11, v4, v5_1, new Runnable(v9, v11, v5_1) {
                    public void run() {
                        this.val$callback.onComplete(this.val$outFragment, this.val$signal);
                    }
                });
            }

            if(v4 == null) {
                return;
            }

            FragmentTransition.replaceHide(v0, v2_2, v11, v7_1);
            ArrayList v9_1 = v0.prepareSetNameOverridesReordered(v6);
            v0.scheduleRemoveTargets(v4, v1_1, v13, v2_2, v7_1, v3_1, v6);
            v0.beginDelayedTransition(arg14, v4);
            v0.setNameOverridesReordered(arg14, v8_1, v6, v9_1, arg17);
            FragmentTransition.setViewVisibility(v13, 0);
            v0.swapSharedElementTargets(v3_1, v8_1, v6);
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition arg0, SparseArray arg1, int arg2) {
        if(arg0 == null) {
            arg0 = new FragmentContainerTransition();
            arg1.put(arg2, arg0);
        }

        return arg0;
    }

    static String findKeyForValue(ArrayMap arg3, String arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg4.equals(arg3.valueAt(v1))) {
                return arg3.keyAt(v1);
            }
        }

        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl arg0, Fragment arg1, boolean arg2) {
        if(arg1 == null) {
            return null;
        }

        Object v1 = arg2 ? arg1.getReenterTransition() : arg1.getEnterTransition();
        return arg0.cloneTransition(v1);
    }

    private static Object getExitTransition(FragmentTransitionImpl arg0, Fragment arg1, boolean arg2) {
        if(arg1 == null) {
            return null;
        }

        Object v1 = arg2 ? arg1.getReturnTransition() : arg1.getExitTransition();
        return arg0.cloneTransition(v1);
    }

    static View getInEpicenterView(ArrayMap arg0, FragmentContainerTransition arg1, Object arg2, boolean arg3) {
        BackStackRecord v1 = arg1.lastInTransaction;
        if(arg2 != null && arg0 != null && v1.mSharedElementSourceNames != null && !v1.mSharedElementSourceNames.isEmpty()) {
            Object v1_1 = arg3 ? v1.mSharedElementSourceNames.get(0) : v1.mSharedElementTargetNames.get(0);
            return arg0.get(v1_1);
        }

        return null;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl arg0, Fragment arg1, Fragment arg2, boolean arg3) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else {
                Object v1 = arg3 ? arg2.getSharedElementReturnTransition() : arg1.getSharedElementEnterTransition();
                return arg0.wrapTransitionInSet(arg0.cloneTransition(v1));
            }
        }

        return null;
    }

    private static Object mergeTransitions(FragmentTransitionImpl arg0, Object arg1, Object arg2, Object arg3, Fragment arg4, boolean arg5) {
        boolean v4;
        if(arg1 == null || arg2 == null || arg4 == null) {
            v4 = true;
        }
        else if(arg5) {
            v4 = arg4.getAllowReturnTransitionOverlap();
        }
        else {
            v4 = arg4.getAllowEnterTransitionOverlap();
        }

        if(v4) {
            return arg0.mergeTransitionsTogether(arg2, arg1, arg3);
        }

        return arg0.mergeTransitionsInSequence(arg2, arg1, arg3);
    }

    private static void replaceHide(FragmentTransitionImpl arg1, Object arg2, Fragment arg3, ArrayList arg4) {
        if(arg3 != null && arg2 != null && (arg3.mAdded) && (arg3.mHidden) && (arg3.mHiddenChanged)) {
            arg3.setHideReplaced(true);
            arg1.scheduleHideFragmentView(arg2, arg3.getView(), arg4);
            OneShotPreDrawListener.add(arg3.mContainer, new Runnable(arg4) {
                public void run() {
                    FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor().newInstance();
        }
        catch(Exception ) {
            return null;
        }
    }

    static void retainValues(ArrayMap arg2, ArrayMap arg3) {
        int v0;
        for(v0 = arg2.size() - 1; v0 >= 0; --v0) {
            if(!arg3.containsKey(arg2.valueAt(v0))) {
                arg2.removeAt(v0);
            }
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl arg9, ViewGroup arg10, Fragment arg11, View arg12, ArrayList arg13, Object arg14, ArrayList arg15, Object arg16, ArrayList arg17) {
        OneShotPreDrawListener.add(((View)arg10), new Runnable(arg14, arg9, arg12, arg11, arg13, arg15, arg17, arg16) {
            public void run() {
                Object v0 = this.val$enterTransition;
                if(v0 != null) {
                    this.val$impl.removeTarget(v0, this.val$nonExistentView);
                    this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
                }

                if(this.val$exitingViews != null) {
                    if(this.val$exitTransition != null) {
                        ArrayList v0_1 = new ArrayList();
                        v0_1.add(this.val$nonExistentView);
                        this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, v0_1);
                    }

                    this.val$exitingViews.clear();
                    this.val$exitingViews.add(this.val$nonExistentView);
                }
            }
        });
    }

    private static void setOutEpicenter(FragmentTransitionImpl arg1, Object arg2, Object arg3, ArrayMap arg4, boolean arg5, BackStackRecord arg6) {
        if(arg6.mSharedElementSourceNames != null && !arg6.mSharedElementSourceNames.isEmpty()) {
            Object v5 = arg5 ? arg6.mSharedElementTargetNames.get(0) : arg6.mSharedElementSourceNames.get(0);
            Object v4 = arg4.get(v5);
            arg1.setEpicenter(arg2, ((View)v4));
            if(arg3 == null) {
                return;
            }

            arg1.setEpicenter(arg3, ((View)v4));
        }
    }

    static void setViewVisibility(ArrayList arg2, int arg3) {
        if(arg2 == null) {
        }
        else {
            int v0;
            for(v0 = arg2.size() - 1; v0 >= 0; --v0) {
                arg2.get(v0).setVisibility(arg3);
            }
        }
    }

    static void startTransitions(Context arg7, FragmentContainer arg8, ArrayList arg9, ArrayList arg10, int arg11, int arg12, boolean arg13, Callback arg14) {
        SparseArray v0 = new SparseArray();
        int v1;
        for(v1 = arg11; v1 < arg12; ++v1) {
            Object v2 = arg9.get(v1);
            if(arg10.get(v1).booleanValue()) {
                FragmentTransition.calculatePopFragments(((BackStackRecord)v2), v0, arg13);
            }
            else {
                FragmentTransition.calculateFragments(((BackStackRecord)v2), v0, arg13);
            }
        }

        if(v0.size() != 0) {
            View v1_1 = new View(arg7);
            int v7 = v0.size();
            int v2_1;
            for(v2_1 = 0; v2_1 < v7; ++v2_1) {
                int v3 = v0.keyAt(v2_1);
                ArrayMap v4 = FragmentTransition.calculateNameOverrides(v3, arg9, arg10, arg11, arg12);
                Object v5 = v0.valueAt(v2_1);
                if(arg8.onHasView()) {
                    View v3_1 = arg8.onFindViewById(v3);
                    if(v3_1 == null) {
                    }
                    else if(arg13) {
                        FragmentTransition.configureTransitionsReordered(((ViewGroup)v3_1), ((FragmentContainerTransition)v5), v1_1, v4, arg14);
                    }
                    else {
                        FragmentTransition.configureTransitionsOrdered(((ViewGroup)v3_1), ((FragmentContainerTransition)v5), v1_1, v4, arg14);
                    }
                }
            }
        }
    }

    static boolean supportsTransition() {
        if(FragmentTransition.PLATFORM_IMPL == null) {
            if(FragmentTransition.SUPPORT_IMPL != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

