package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b%\b\u0001\u0018\u00002\u00020\u0001:\u0001_B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020 ¢\u0006\u0004\b*\u0010+J\u0018\u0010.\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\tJ\u0018\u00101\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\tJ\u0018\u00102\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\tJ\u0018\u00103\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\tJ\u000E\u00104\u001A\u00020(2\u0006\u0010/\u001A\u00020\u0003J\u001F\u00105\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\u0010)\u001A\u0004\u0018\u00010 H\u0002¢\u0006\u0002\b6J\u001F\u00107\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\u0010)\u001A\u0004\u0018\u00010 H\u0002¢\u0006\u0002\b8J\u0018\u00109\u001A\u00020\t2\u0010\b\u0002\u0010:\u001A\n\u0012\u0004\u0012\u00020(\u0018\u00010;J\u0006\u0010<\u001A\u00020(J\u0010\u0010=\u001A\u00020(2\u0006\u0010/\u001A\u00020\u0003H\u0002J\u001D\u00109\u001A\u00020(2\u0006\u0010/\u001A\u00020\u00032\u0006\u0010)\u001A\u00020 ¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u00020(2\u0006\u0010/\u001A\u00020\u0003H\u0002J\u001F\u0010A\u001A\u00020(2\u0006\u0010B\u001A\u00020\t2\f\u0010C\u001A\b\u0012\u0004\u0012\u00020(0;H\u0082\bJ\u000E\u0010D\u001A\u00020(2\u0006\u0010E\u001A\u00020\u0017J\b\u0010F\u001A\u00020(H\u0002J$\u0010G\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00032\b\b\u0002\u0010H\u001A\u00020\t2\b\b\u0002\u0010I\u001A\u00020\tH\u0002J\b\u0010J\u001A\u00020(H\u0002J\u0018\u0010K\u001A\u00020(2\u0006\u0010/\u001A\u00020\u00032\u0006\u0010H\u001A\u00020\tH\u0002J\u0016\u0010L\u001A\u00020(2\u0006\u0010/\u001A\u00020\u00032\u0006\u0010H\u001A\u00020\tJ\u0018\u0010M\u001A\u00020(2\u0006\u0010N\u001A\u00020\u00032\u0006\u0010H\u001A\u00020\tH\u0002J\u0018\u0010O\u001A\u00020(2\u0006\u0010/\u001A\u00020\u00032\u0006\u0010H\u001A\u00020\tH\u0002J\u0010\u0010P\u001A\u00020(2\b\b\u0002\u0010Q\u001A\u00020\tJ\u000E\u0010R\u001A\u00020(2\u0006\u0010N\u001A\u00020\u0003J\u0014\u0010^\u001A\u00020\t*\u00020\u00032\u0006\u0010H\u001A\u00020\tH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u001A\u0010\u000E\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u000B\"\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00198F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010!\u001A\u0004\u0018\u00010\"X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010,\u001A\u0004\u0018\u00010-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010S\u001A\u00020\t*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bT\u0010UR\u0018\u0010V\u001A\u00020\t*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bW\u0010UR\u0018\u0010X\u001A\u00020\t*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bY\u0010UR\u0018\u0010Z\u001A\u00020\t*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b[\u0010UR\u0018\u0010\\\u001A\u00020\t*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b]\u0010U¨\u0006`"}, d2={"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "hasPendingMeasureOrLayout", "", "getHasPendingMeasureOrLayout", "()Z", "hasPendingOnPositionedCallbacks", "getHasPendingOnPositionedCallbacks", "duringMeasureLayout", "getDuringMeasureLayout$ui", "setDuringMeasureLayout$ui", "(Z)V", "duringFullMeasureLayoutPass", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "value", "", "measureIteration", "getMeasureIteration", "()J", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "uncaughtExceptionHandler", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "getUncaughtExceptionHandler$ui", "()Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "setUncaughtExceptionHandler$ui", "(Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;)V", "updateRootConstraints", "", "constraints", "updateRootConstraints-BRTryo0", "(J)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "requestLookaheadRemeasure", "layoutNode", "forced", "requestRemeasure", "requestLookaheadRelayout", "requestRelayout", "requestOnPositionedCallback", "doLookaheadRemeasure", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureOnly", "remeasureLookaheadRootsInSubtree", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "ensureSubtreeLookaheadReplaced", "performMeasureAndLayout", "fullPass", "block", "registerOnLayoutCompletedListener", "listener", "callOnLayoutCompletedListeners", "remeasureAndRelayoutIfNeeded", "affectsLookahead", "relayoutNeeded", "drainPostponedMeasureRequests", "remeasureOnly", "forceMeasureTheSubtree", "onlyRemeasureIfPending", "node", "forceMeasureTheSubtreeInternal", "dispatchOnPositionedCallbacks", "forceDispatch", "onNodeDetached", "remeasureCanAffectParentSize", "getRemeasureCanAffectParentSize", "(Landroidx/compose/ui/node/LayoutNode;)Z", "measuredByPlacedParent", "getMeasuredByPlacedParent", "canAffectPlacedParent", "getCanAffectPlacedParent", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "lookaheadRemeasureCanAffectParentSize", "getLookaheadRemeasureCanAffectParentSize", "measurePending", "PostponedRequest", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MeasureAndLayoutDelegate {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "<init>", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PostponedRequest {
        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        static {
        }

        public PostponedRequest(LayoutNode arg1, boolean arg2, boolean arg3) {
            super();
            this.node = arg1;
            this.isLookahead = arg2;
            this.isForced = arg3;
        }

        public final LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutState.values().length];
            try {
                v0[LayoutState.LookaheadMeasuring.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutState.Measuring.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[LayoutState.LookaheadLayingOut.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[LayoutState.LayingOut.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[LayoutState.Idle.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringFullMeasureLayoutPass;
    private boolean duringMeasureLayout;
    private long measureIteration;
    private final MutableVector onLayoutCompletedListeners;
    private final OnPositionedDispatcher onPositionedDispatcher;
    private final MutableVector postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;
    private Constraints rootConstraints;
    private UncaughtExceptionHandler uncaughtExceptionHandler;

    static {
    }

    public MeasureAndLayoutDelegate(LayoutNode arg8) {
        super();
        this.root = arg8;
        DepthSortedSetsForDifferentPasses v0 = new DepthSortedSetsForDifferentPasses(Owner.Companion.getEnableExtraAssertions());
        this.relayoutNodes = v0;
        this.onPositionedDispatcher = new OnPositionedDispatcher();
        this.onLayoutCompletedListeners = new MutableVector(new OnLayoutCompletedListener[16], 0);
        this.measureIteration = 1;
        MutableVector v1 = new MutableVector(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = v1;
        LayoutTreeConsistencyChecker v2 = Owner.Companion.getEnableExtraAssertions() ? new LayoutTreeConsistencyChecker(arg8, v0, v1.asMutableList()) : null;
        this.consistencyChecker = v2;
    }

    public static final DepthSortedSetsForDifferentPasses access$getRelayoutNodes$p(MeasureAndLayoutDelegate arg0) {
        return arg0.relayoutNodes;
    }

    public static final LayoutNode access$getRoot$p(MeasureAndLayoutDelegate arg0) {
        return arg0.root;
    }

    public static final boolean access$remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate arg0, LayoutNode arg1, boolean arg2, boolean arg3) {
        return arg0.remeasureAndRelayoutIfNeeded(arg1, arg2, arg3);
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector v0 = this.onLayoutCompletedListeners;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1[v2].onLayoutComplete();
        }

        this.onLayoutCompletedListeners.clear();
    }

    public final void dispatchOnPositionedCallbacks(boolean arg2) {
        if(arg2) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }

        if(this.onPositionedDispatcher.isNotEmpty()) {
            this.onPositionedDispatcher.dispatch();
        }
    }

    public static void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate arg0, boolean arg1, int arg2, Object arg3) {
        arg0.dispatchOnPositionedCallbacks(false);
    }

    private final boolean doLookaheadRemeasure-sdFAvZA(LayoutNode arg9, Constraints arg10) {
        if(arg9.getLookaheadRoot$ui() == null) {
            return 0;
        }

        Constraints v1 = null;
        boolean v10 = arg10 != null ? arg9.lookaheadRemeasure-_Sx5XlM$ui(arg10) : LayoutNode.lookaheadRemeasure-_Sx5XlM$ui$default(arg9, v1, 1, v1);
        LayoutNode v2 = arg9.getParent$ui();
        if((v10) && v2 != null) {
            if(v2.getLookaheadRoot$ui() == null) {
                LayoutNode.requestRemeasure$ui$default(v2, false, false, false, 3, null);
                return v10;
            }
            else if(arg9.getMeasuredByParentInLookahead$ui() == UsageByParent.InMeasureBlock) {
                LayoutNode.requestLookaheadRemeasure$ui$default(v2, false, false, false, 3, null);
                return v10;
            }
            else if(arg9.getMeasuredByParentInLookahead$ui() == UsageByParent.InLayoutBlock) {
                LayoutNode.requestLookaheadRelayout$ui$default(v2, false, 1, v1);
            }
        }

        return v10;
    }

    private final boolean doRemeasure-sdFAvZA(LayoutNode arg8, Constraints arg9) {
        Constraints v0 = null;
        boolean v9 = arg9 != null ? arg8.remeasure-_Sx5XlM$ui(arg9) : LayoutNode.remeasure-_Sx5XlM$ui$default(arg8, v0, 1, v0);
        LayoutNode v1 = arg8.getParent$ui();
        if((v9) && v1 != null) {
            if(arg8.getMeasuredByParent$ui() == UsageByParent.InMeasureBlock) {
                LayoutNode.requestRemeasure$ui$default(v1, false, false, false, 3, null);
                return v9;
            }
            else if(arg8.getMeasuredByParent$ui() == UsageByParent.InLayoutBlock) {
                LayoutNode.requestRelayout$ui$default(v1, false, 1, v0);
            }
        }

        return v9;
    }

    private final void drainPostponedMeasureRequests() {
        MeasureAndLayoutDelegate v0 = this;
        if(v0.postponedMeasureRequests.getSize() != 0) {
            MutableVector v1 = v0.postponedMeasureRequests;
            Object[] v2 = v1.content;
            int v1_1 = v1.getSize();
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                Object v4 = v2[v3];
                if(((PostponedRequest)v4).getNode().isAttached()) {
                    if(!((PostponedRequest)v4).isLookahead()) {
                        LayoutNode.requestRemeasure$ui$default(((PostponedRequest)v4).getNode(), ((PostponedRequest)v4).isForced(), false, false, 2, null);
                    }
                    else {
                        LayoutNode.requestLookaheadRemeasure$ui$default(((PostponedRequest)v4).getNode(), ((PostponedRequest)v4).isForced(), false, false, 2, null);
                    }
                }
            }

            v0.postponedMeasureRequests.clear();
        }
    }

    private final void ensureSubtreeLookaheadReplaced(LayoutNode arg7) {
        MutableVector v7 = arg7.get_children$ui();
        Object[] v0 = v7.content;
        int v7_1 = v7.getSize();
        int v1;
        for(v1 = 0; v1 < v7_1; ++v1) {
            Object v2 = v0[v1];
            if((Intrinsics.areEqual(((LayoutNode)v2).isPlacedInLookahead(), Boolean.valueOf(true))) && !((LayoutNode)v2).isDeactivated()) {
                if(this.relayoutNodes.contains(((LayoutNode)v2), true)) {
                    ((LayoutNode)v2).lookaheadReplace$ui();
                }

                this.ensureSubtreeLookaheadReplaced(((LayoutNode)v2));
            }
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode arg2, boolean arg3) {
        if(!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalStateException("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }

        if(this.measurePending(arg2, arg3)) {
            InlineClassHelperKt.throwIllegalArgumentException("node not yet measured");
        }

        this.forceMeasureTheSubtreeInternal(arg2, arg3);
    }

    private final void forceMeasureTheSubtreeInternal(LayoutNode arg8, boolean arg9) {
        MutableVector v0 = arg8.get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v3;
        for(v3 = 0; v3 < v0_1; ++v3) {
            Object v4 = v1[v3];
            if(!arg9 && (this.getRemeasureCanAffectParentSize(((LayoutNode)v4))) || (arg9) && (this.getLookaheadRemeasureCanAffectParentSize(((LayoutNode)v4)))) {
                if((LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(((LayoutNode)v4))) && !arg9) {
                    if((((LayoutNode)v4).getLookaheadMeasurePending$ui()) && (this.relayoutNodes.contains(((LayoutNode)v4), true))) {
                        this.remeasureAndRelayoutIfNeeded(((LayoutNode)v4), true, false);
                        goto label_25;
                    }

                    this.forceMeasureTheSubtree(((LayoutNode)v4), true);
                }

            label_25:
                this.onlyRemeasureIfPending(((LayoutNode)v4), arg9);
                if(this.measurePending(((LayoutNode)v4), arg9)) {
                    goto label_29;
                }

                this.forceMeasureTheSubtreeInternal(((LayoutNode)v4), arg9);
            }

        label_29:
        }

        this.onlyRemeasureIfPending(arg8, arg9);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode arg3) {
        if(arg3.getLookaheadMeasurePending$ui()) {
            if(arg3.getMeasuredByParentInLookahead$ui() == UsageByParent.NotUsed) {
                AlignmentLinesOwner v2 = arg3.getLayoutDelegate$ui().getLookaheadAlignmentLinesOwner$ui();
                if(v2 != null) {
                    AlignmentLines v2_1 = v2.getAlignmentLines();
                    if(v2_1 == null) {
                    }
                    else if(v2_1.getRequired$ui()) {
                        return 1;
                    }
                }
                else {
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final boolean getCanAffectPlacedParent(LayoutNode arg2) {
        if((arg2.getMeasurePending$ui()) && (this.getMeasuredByPlacedParent(arg2))) {
            return 1;
        }

        return 0;
    }

    public final boolean getDuringMeasureLayout$ui() {
        return this.duringMeasureLayout;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    private final boolean getLookaheadRemeasureCanAffectParentSize(LayoutNode arg3) {
        if(arg3.getMeasuredByParentInLookahead$ui() != UsageByParent.InMeasureBlock) {
            AlignmentLinesOwner v2 = arg3.getLayoutDelegate$ui().getLookaheadAlignmentLinesOwner$ui();
            if(v2 != null) {
                AlignmentLines v2_1 = v2.getAlignmentLines();
                if(v2_1 != null && (v2_1.getRequired$ui())) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    public final long getMeasureIteration() {
        if(!this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }

        return this.measureIteration;
    }

    private final boolean getMeasuredByPlacedParent(LayoutNode arg3) {
        do {
            if(arg3.getMeasuredByParent$ui() == UsageByParent.NotUsed && !arg3.getLayoutDelegate$ui().getAlignmentLinesOwner$ui().getAlignmentLines().getRequired$ui()) {
                LayoutNode v2 = arg3.getParent$ui();
                LayoutState v2_1 = v2 != null ? v2.getLayoutState$ui() : null;
                if(v2_1 == LayoutState.Measuring) {
                    goto label_18;
                }

                return 0;
            }

        label_18:
            arg3 = arg3.getParent$ui();
            if(arg3 == null) {
                return 0;
            }
        }
        while(!arg3.isPlaced());

        return 1;
    }

    private final boolean getRemeasureCanAffectParentSize(LayoutNode arg2) {
        if(arg2.getMeasuredByParent$ui() != UsageByParent.InMeasureBlock) {
            if(arg2.getLayoutDelegate$ui().getAlignmentLinesOwner$ui().getAlignmentLines().getRequired$ui()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final UncaughtExceptionHandler getUncaughtExceptionHandler$ui() {
        return this.uncaughtExceptionHandler;
    }

    public final boolean measureAndLayout(Function0 arg9) {
        boolean v6;
        boolean v5;
        LayoutNode v4;
        boolean v3;
        DepthSortedSetsForDifferentPasses v2;
        if(!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }

        if(!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }

        if(this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }

        boolean v1 = false;
        if(this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = true;
            try {
                if(!this.relayoutNodes.isNotEmpty()) {
                    goto label_78;
                }

                v2 = this.relayoutNodes;
                v3 = false;
            }
            catch(Throwable v9) {
                v3 = false;
                goto label_85;
            }

            try {
                while(true) {
                    if(!v2.lookaheadAndAncestorMeasureSet.isEmpty()) {
                        v4 = v2.lookaheadAndAncestorMeasureSet.pop();
                        v5 = v4.getLookaheadRoot$ui() != null ? true : false;
                        v6 = false;
                    }
                    else {
                        if(!v2.lookaheadAndAncestorPlaceSet.isEmpty()) {
                            v4 = v2.lookaheadAndAncestorPlaceSet.pop();
                            v5 = v4.getLookaheadRoot$ui() != null ? true : false;
                            v6 = true;
                            goto label_56;
                        }

                        if(v2.approachSet.isEmpty()) {
                            break;
                        }

                        v4 = v2.approachSet.pop();
                        v6 = true;
                        v5 = false;
                    }

                label_56:
                    v5 = this.remeasureAndRelayoutIfNeeded(v4, v5, v6);
                    if(!v6) {
                        if(v4.getLookaheadLayoutPending$ui()) {
                            this.relayoutNodes.add(v4, Invalidation.LookaheadPlacement);
                        }

                        if(!v4.getLayoutPending$ui()) {
                            goto label_68;
                        }

                        this.relayoutNodes.add(v4, Invalidation.Placement);
                    }

                label_68:
                    if(v4 != this.root) {
                        continue;
                    }

                    if(!v5) {
                        continue;
                    }

                    v3 = true;
                }

                if(arg9 == null) {
                    goto label_79;
                }

                arg9.invoke();
                goto label_79;
            }
            catch(Throwable v9) {
            }

            try {
            label_85:
                UncaughtExceptionHandler v0 = this.uncaughtExceptionHandler;
                if(v0 != null) {
                    v0.onUncaughtException(v9);
                    goto label_79;
                }

                throw v9;
            }
            catch(Throwable v9) {
                this.duringMeasureLayout = false;
                this.duringFullMeasureLayoutPass = false;
                throw v9;
            }

        label_78:
            v3 = false;
        label_79:
            this.duringMeasureLayout = false;
            this.duringFullMeasureLayoutPass = false;
            v1 = v3;
            LayoutTreeConsistencyChecker v9_1 = this.consistencyChecker;
            if(v9_1 == null) {
                goto label_98;
            }

            v9_1.assertConsistent();
        }

    label_98:
        this.callOnLayoutCompletedListeners();
        return v1;
    }

    public static boolean measureAndLayout$default(MeasureAndLayoutDelegate arg0, Function0 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return arg0.measureAndLayout(arg1);
    }

    public final void measureAndLayout-0kLqBqw(LayoutNode arg4, long arg5) {
        if(arg4.isDeactivated()) {
            return;
        }

        if(Intrinsics.areEqual(arg4, this.root)) {
            InlineClassHelperKt.throwIllegalArgumentException("measureAndLayout called on root");
        }

        if(!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }

        if(!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }

        if(this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }

        if(this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = false;
            try {
                this.relayoutNodes.remove(arg4);
                if(((this.doLookaheadRemeasure-sdFAvZA(arg4, Constraints.box-impl(arg5))) || (arg4.getLookaheadLayoutPending$ui())) && (Intrinsics.areEqual(arg4.isPlacedInLookahead(), Boolean.valueOf(true)))) {
                    arg4.lookaheadReplace$ui();
                }

                this.ensureSubtreeLookaheadReplaced(arg4);
                this.doRemeasure-sdFAvZA(arg4, Constraints.box-impl(arg5));
                if((arg4.getLayoutPending$ui()) && (arg4.isPlaced())) {
                    arg4.replace$ui();
                    this.onPositionedDispatcher.onNodePositioned(arg4);
                }

                this.drainPostponedMeasureRequests();
            }
            catch(Throwable v4) {
                try {
                    UncaughtExceptionHandler v5 = this.uncaughtExceptionHandler;
                    if(v5 != null) {
                        v5.onUncaughtException(v4);
                        goto label_56;
                    }

                    throw v4;
                }
                catch(Throwable v4) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw v4;
                }
            }

        label_56:
            this.duringMeasureLayout = false;
            this.duringFullMeasureLayoutPass = false;
            LayoutTreeConsistencyChecker v4_1 = this.consistencyChecker;
            if(v4_1 == null) {
                goto label_67;
            }

            v4_1.assertConsistent();
        }

    label_67:
        this.callOnLayoutCompletedListeners();
    }

    public final void measureOnly() {
        if(!this.relayoutNodes.isNotEmpty()) {
            return;
        }

        if(!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }

        if(!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }

        if(this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }

        if(this.rootConstraints == null) {
            return;
        }

        this.duringMeasureLayout = true;
        this.duringFullMeasureLayoutPass = false;
        try {
            if(this.relayoutNodes.getAffectsLookaheadMeasure()) {
                LayoutNode v2 = this.root.getLookaheadRoot$ui();
                goto label_28;
            }

            goto label_33;
        }
        catch(Throwable v0) {
            goto label_39;
        }

    label_28:
        LayoutNode v3 = this.root;
        if(v2 != null) {
            try {
                this.remeasureOnly(v3, true);
                goto label_33;
            label_32:
                this.remeasureLookaheadRootsInSubtree(v3);
            label_33:
                this.remeasureOnly(this.root, false);
                goto label_35;
            }
            catch(Throwable v0) {
                try {
                label_39:
                    UncaughtExceptionHandler v2_1 = this.uncaughtExceptionHandler;
                    if(v2_1 != null) {
                        v2_1.onUncaughtException(v0);
                        goto label_35;
                    }

                    throw v0;
                }
                catch(Throwable v0) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw v0;
                }
            }
        }
        else {
            goto label_32;
        }

        goto label_33;
    label_35:
        this.duringMeasureLayout = false;
        this.duringFullMeasureLayoutPass = false;
        LayoutTreeConsistencyChecker v4 = this.consistencyChecker;
        if(v4 != null) {
            v4.assertConsistent();
        }
    }

    private final boolean measurePending(LayoutNode arg1, boolean arg2) {
        if(arg2) {
            return arg1.getLookaheadMeasurePending$ui();
        }

        return arg1.getMeasurePending$ui();
    }

    public final void onNodeDetached(LayoutNode arg2) {
        this.relayoutNodes.remove(arg2);
        this.onPositionedDispatcher.remove(arg2);
    }

    private final void onlyRemeasureIfPending(LayoutNode arg2, boolean arg3) {
        if(this.measurePending(arg2, arg3)) {
            this.remeasureAndRelayoutIfNeeded(arg2, arg3, false);
        }
    }

    private final void performMeasureAndLayout(boolean arg2, Function0 arg3) {
        if(!this.root.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unattached root");
        }

        if(!this.root.isPlaced()) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called with unplaced root");
        }

        if(this.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("performMeasureAndLayout called during measure layout");
        }

        if(this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            this.duringFullMeasureLayoutPass = arg2;
            try {
                arg3.invoke();
            }
            catch(Throwable v3) {
                try {
                    UncaughtExceptionHandler v0 = this.uncaughtExceptionHandler;
                    if(v0 != null) {
                        v0.onUncaughtException(v3);
                        goto label_21;
                    }

                    throw v3;
                }
                catch(Throwable v3) {
                    this.duringMeasureLayout = false;
                    this.duringFullMeasureLayoutPass = false;
                    throw v3;
                }
            }

        label_21:
            this.duringMeasureLayout = false;
            this.duringFullMeasureLayoutPass = false;
            LayoutTreeConsistencyChecker v1 = this.consistencyChecker;
            if(v1 == null) {
                return;
            }

            v1.assertConsistent();
        }
    }

    public final void registerOnLayoutCompletedListener(OnLayoutCompletedListener arg1) {
        this.onLayoutCompletedListeners.add(arg1);
    }

    private final boolean remeasureAndRelayoutIfNeeded(LayoutNode arg5, boolean arg6, boolean arg7) {
        Constraints v0;
        boolean v1 = false;
        if(arg5.isDeactivated()) {
            return 0;
        }

        if(!arg5.isPlaced() && !arg5.isPlacedByParent() && !this.getCanAffectPlacedParent(arg5) && !Intrinsics.areEqual(arg5.isPlacedInLookahead(), Boolean.valueOf(true)) && !this.getCanAffectParentInLookahead(arg5)) {
            if(arg5.getAlignmentLinesRequired$ui()) {
            }
            else {
                return 0;
            }
        }

        if(arg5 == this.root) {
            v0 = this.rootConstraints;
            Intrinsics.checkNotNull(v0);
        }
        else {
            v0 = null;
        }

        if(arg6) {
            if(arg5.getLookaheadMeasurePending$ui()) {
                v1 = this.doLookaheadRemeasure-sdFAvZA(arg5, v0);
            }

            if(!arg7) {
                goto label_68;
            }

            if(!v1 && !arg5.getLookaheadLayoutPending$ui()) {
                goto label_68;
            }

            if(!Intrinsics.areEqual(arg5.isPlacedInLookahead(), Boolean.valueOf(true))) {
                goto label_68;
            }

            arg5.lookaheadReplace$ui();
        }
        else {
            arg6 = arg5.getMeasurePending$ui() ? this.doRemeasure-sdFAvZA(arg5, v0) : false;
            if((arg7) && (arg5.getLayoutPending$ui())) {
                if(arg5 != this.root) {
                    LayoutNode v7 = arg5.getParent$ui();
                    if(v7 == null) {
                    }
                    else if(!v7.isPlaced()) {
                    }
                    else if(arg5.isPlacedByParent()) {
                        goto label_57;
                    }

                    goto label_67;
                }

            label_57:
                if(arg5 == this.root) {
                    arg5.place$ui(0, 0);
                }
                else {
                    arg5.replace$ui();
                }

                this.onPositionedDispatcher.onNodePositioned(arg5);
                LayoutTreeConsistencyChecker v5 = this.consistencyChecker;
                if(v5 == null) {
                    goto label_67;
                }

                v5.assertConsistent();
            }

        label_67:
            v1 = arg6;
        }

    label_68:
        this.drainPostponedMeasureRequests();
        return v1;
    }

    static boolean remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate arg1, LayoutNode arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        return arg1.remeasureAndRelayoutIfNeeded(arg2, true, true);
    }

    private final void remeasureLookaheadRootsInSubtree(LayoutNode arg5) {
        MutableVector v5 = arg5.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            Object v2 = v0[v1];
            if(this.getRemeasureCanAffectParentSize(((LayoutNode)v2))) {
                if(LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(((LayoutNode)v2))) {
                    this.remeasureOnly(((LayoutNode)v2), true);
                }
                else {
                    this.remeasureLookaheadRootsInSubtree(((LayoutNode)v2));
                }
            }
        }
    }

    private final void remeasureOnly(LayoutNode arg2, boolean arg3) {
        Constraints v0;
        if(arg2.isDeactivated()) {
            return;
        }

        if(arg2 == this.root) {
            v0 = this.rootConstraints;
            Intrinsics.checkNotNull(v0);
        }
        else {
            v0 = null;
        }

        if(arg3) {
            this.doLookaheadRemeasure-sdFAvZA(arg2, v0);
            return;
        }

        this.doRemeasure-sdFAvZA(arg2, v0);
    }

    public final boolean requestLookaheadRelayout(LayoutNode arg5, boolean arg6) {
        LayoutTreeConsistencyChecker v4;
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg5.getLayoutState$ui().ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 == 3) {
                    goto label_67;
                }
                else if(v0 != 4) {
                    if(v0 == 5) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }

            if(((arg5.getLookaheadMeasurePending$ui()) || (arg5.getLookaheadLayoutPending$ui())) && !arg6) {
                v4 = this.consistencyChecker;
                if(v4 != null) {
                    v4.assertConsistent();
                }

                return 0;
            }

            arg5.markLookaheadLayoutPending$ui();
            arg5.markLayoutPending$ui();
            if(arg5.isDeactivated()) {
                return 0;
            }

            LayoutNode v6 = arg5.getParent$ui();
            if(Intrinsics.areEqual(arg5.isPlacedInLookahead(), Boolean.valueOf(true))) {
                if(v6 != null && (v6.getLookaheadMeasurePending$ui())) {
                    goto label_50;
                }

                if(v6 != null && (v6.getLookaheadLayoutPending$ui())) {
                    goto label_50;
                }

                this.relayoutNodes.add(arg5, Invalidation.LookaheadPlacement);
            }
            else {
            label_50:
                if(!arg5.isPlaced()) {
                    goto label_63;
                }

                if(v6 != null && (v6.getLayoutPending$ui())) {
                    goto label_63;
                }

                if(v6 != null && (v6.getMeasurePending$ui())) {
                    goto label_63;
                }

                this.relayoutNodes.add(arg5, Invalidation.Placement);
            }

        label_63:
            if(!this.duringFullMeasureLayoutPass) {
                return 1;
            }

            return 0;
        }

    label_67:
        v4 = this.consistencyChecker;
        if(v4 != null) {
            v4.assertConsistent();
        }

        return 0;
    }

    public static boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate arg0, LayoutNode arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.requestLookaheadRelayout(arg1, false);
    }

    public final boolean requestLookaheadRemeasure(LayoutNode arg5, boolean arg6) {
        int v0 = arg5.getLookaheadRoot$ui() != null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }

        v0 = WhenMappings.$EnumSwitchMapping$0[arg5.getLayoutState$ui().ordinal()];
        if(v0 != 1) {
            if(v0 != 2 && v0 != 3 && v0 != 4) {
                if(v0 == 5) {
                    if((arg5.getLookaheadMeasurePending$ui()) && !arg6) {
                        return 0;
                    }

                    arg5.markLookaheadMeasurePending$ui();
                    arg5.markMeasurePending$ui();
                    if(arg5.isDeactivated()) {
                        return 0;
                    }

                    if((Intrinsics.areEqual(arg5.isPlacedInLookahead(), Boolean.valueOf(true))) || (this.getCanAffectParentInLookahead(arg5))) {
                        LayoutNode v6 = arg5.getParent$ui();
                        if(v6 != null && (v6.getLookaheadMeasurePending$ui())) {
                        label_42:
                            if(!arg5.isPlaced() && !this.getCanAffectPlacedParent(arg5)) {
                                goto label_58;
                            }

                            v6 = arg5.getParent$ui();
                            if(v6 != null && (v6.getMeasurePending$ui())) {
                                goto label_58;
                            }

                            this.relayoutNodes.add(arg5, Invalidation.Measurement);
                            goto label_58;
                        }

                        this.relayoutNodes.add(arg5, Invalidation.LookaheadMeasurement);
                    }
                    else {
                        goto label_42;
                    }

                label_58:
                    if(!this.duringFullMeasureLayoutPass) {
                        return 1;
                    }

                    return 0;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            this.postponedMeasureRequests.add(new PostponedRequest(arg5, true, arg6));
            LayoutTreeConsistencyChecker v4 = this.consistencyChecker;
            if(v4 == null) {
                return 0;
            }

            v4.assertConsistent();
        }

        return 0;
    }

    public static boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate arg0, LayoutNode arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.requestLookaheadRemeasure(arg1, false);
    }

    public final void requestOnPositionedCallback(LayoutNode arg1) {
        this.onPositionedDispatcher.onNodePositioned(arg1);
    }

    public final boolean requestRelayout(LayoutNode arg6, boolean arg7) {
        LayoutTreeConsistencyChecker v5;
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg6.getLayoutState$ui().ordinal()];
        if(v0 != 1 && v0 != 2 && v0 != 3 && v0 != 4) {
            if(v0 == 5) {
                LayoutNode v0_1 = arg6.getParent$ui();
                boolean v3 = v0_1 == null || (v0_1.isPlaced()) ? true : false;
                if(!arg7) {
                    if(!arg6.getMeasurePending$ui()) {
                        if(!arg6.getLayoutPending$ui()) {
                        }
                        else if(arg6.isPlaced() != v3) {
                        }
                        else if(arg6.isPlaced() == arg6.isPlacedByParent()) {
                            goto label_33;
                        }

                        goto label_37;
                    }

                label_33:
                    v5 = this.consistencyChecker;
                    if(v5 != null) {
                        v5.assertConsistent();
                    }

                    return 0;
                }

            label_37:
                arg6.markLayoutPending$ui();
                if(arg6.isDeactivated()) {
                    return 0;
                }

                if((arg6.isPlacedByParent()) && (v3)) {
                    if(v0_1 == null || !v0_1.getLayoutPending$ui()) {
                        if(v0_1 != null && (v0_1.getMeasurePending$ui())) {
                            goto label_55;
                        }

                        this.relayoutNodes.add(arg6, Invalidation.Placement);
                    }
                    else {
                    }

                label_55:
                    if(this.duringFullMeasureLayoutPass) {
                        return 0;
                    }

                    return 1;
                }

                return 0;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        v5 = this.consistencyChecker;
        if(v5 != null) {
            v5.assertConsistent();
        }

        return 0;
    }

    public static boolean requestRelayout$default(MeasureAndLayoutDelegate arg0, LayoutNode arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.requestRelayout(arg1, false);
    }

    public final boolean requestRemeasure(LayoutNode arg5, boolean arg6) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg5.getLayoutState$ui().ordinal()];
        if(v0 != 1 && v0 != 2) {
            if(v0 != 3 && v0 != 4) {
                if(v0 == 5) {
                    if((arg5.getMeasurePending$ui()) && !arg6) {
                        return 0;
                    }

                    arg5.markMeasurePending$ui();
                    if(arg5.isDeactivated()) {
                        return 0;
                    }

                    if(!arg5.isPlaced()) {
                        if(this.getCanAffectPlacedParent(arg5)) {
                        }
                        else {
                            return 0;
                        }
                    }

                    LayoutNode v6 = arg5.getParent$ui();
                    if(v6 == null || !v6.getMeasurePending$ui()) {
                        this.relayoutNodes.add(arg5, Invalidation.Measurement);
                    }
                    else {
                    }

                    if(!this.duringFullMeasureLayoutPass) {
                        return 1;
                    }

                    return 0;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            this.postponedMeasureRequests.add(new PostponedRequest(arg5, false, arg6));
            LayoutTreeConsistencyChecker v4 = this.consistencyChecker;
            if(v4 == null) {
                return 0;
            }

            v4.assertConsistent();
        }

        return 0;
    }

    public static boolean requestRemeasure$default(MeasureAndLayoutDelegate arg0, LayoutNode arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.requestRemeasure(arg1, false);
    }

    public final void setDuringMeasureLayout$ui(boolean arg1) {
        this.duringMeasureLayout = arg1;
    }

    public final void setUncaughtExceptionHandler$ui(UncaughtExceptionHandler arg1) {
        this.uncaughtExceptionHandler = arg1;
    }

    public final void updateRootConstraints-BRTryo0(long arg3) {
        Constraints v0 = this.rootConstraints;
        boolean v0_1 = v0 == null ? false : Constraints.equals-impl0(v0.unbox-impl(), arg3);
        if(!v0_1) {
            if(this.duringMeasureLayout) {
                InlineClassHelperKt.throwIllegalArgumentException("updateRootConstraints called while measuring");
            }

            this.rootConstraints = Constraints.box-impl(arg3);
            if(this.root.getLookaheadRoot$ui() != null) {
                this.root.markLookaheadMeasurePending$ui();
            }

            this.root.markMeasurePending$ui();
            DepthSortedSetsForDifferentPasses v3 = this.relayoutNodes;
            LayoutNode v2 = this.root;
            Invalidation v4 = v2.getLookaheadRoot$ui() != null ? Invalidation.LookaheadMeasurement : Invalidation.Measurement;
            v3.add(v2, v4);
        }
    }
}

