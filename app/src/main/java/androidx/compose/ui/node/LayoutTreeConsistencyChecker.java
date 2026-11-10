package androidx.compose.ui.node;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000B\u001A\u00020\fJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\f\u0010\u0010\u001A\u00020\u000E*\u00020\u0003H\u0002J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\b\u0010\u0013\u001A\u00020\u0012H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "consistentLayoutState", "nodeToString", "", "logTree", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutTreeConsistencyChecker {
    public static final int $stable = 8;
    private final List postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;

    static {
    }

    public LayoutTreeConsistencyChecker(LayoutNode arg1, DepthSortedSetsForDifferentPasses arg2, List arg3) {
        super();
        this.root = arg1;
        this.relayoutNodes = arg2;
        this.postponedMeasureRequests = arg3;
    }

    public final void assertConsistent() {
        if(this.isTreeConsistent(this.root)) {
            return;
        }

        System.out.println(this.logTree());
        throw new IllegalStateException("Inconsistency found!");
    }

    private final boolean consistentLayoutState(LayoutNode arg12) {
        Object v9;
        Object v8;
        int v6;
        List v3;
        LayoutNode v0 = arg12.getParent$ui();
        Object v1 = null;
        LayoutState v2 = v0 != null ? v0.getLayoutState$ui() : ((LayoutState)v1);
        if((arg12.isPlaced()) || arg12.getPlaceOrder$ui() != 0x7FFFFFFF && v0 != null && (v0.isPlaced())) {
            if(arg12.getMeasurePending$ui()) {
                v3 = this.postponedMeasureRequests;
                v6 = v3.size();
                int v7;
                for(v7 = 0; v7 < v6; ++v7) {
                    v8 = v3.get(v7);
                    v9 = v8;
                    if((Intrinsics.areEqual(((PostponedRequest)v9).getNode(), arg12)) && !((PostponedRequest)v9).isLookahead()) {
                        goto label_34;
                    }
                }

                v8 = v1;
            label_34:
                if(v8 == null) {
                    goto label_36;
                }

                return 1;
            }

        label_36:
            if(arg12.isDeactivated()) {
                return 1;
            }

            if(arg12.getMeasurePending$ui()) {
                if(!this.relayoutNodes.contains(arg12) && arg12.getLayoutState$ui() != LayoutState.LookaheadMeasuring && (v0 == null || !v0.getMeasurePending$ui()) && (v0 == null || !v0.getLookaheadMeasurePending$ui()) && v2 != LayoutState.Measuring) {
                    return 0;
                }

                return 1;
            }

            if(!arg12.getLayoutPending$ui()) {
                goto label_95;
            }

            if(!this.relayoutNodes.contains(arg12) && v0 != null && !v0.getMeasurePending$ui() && !v0.getLayoutPending$ui() && v2 != LayoutState.Measuring && v2 != LayoutState.LayingOut) {
                List v11 = this.postponedMeasureRequests;
                int v0_1 = v11.size();
                int v1_1 = 0;
                while(true) {
                    if(v1_1 >= v0_1) {
                        break;
                    }
                    else if(Intrinsics.areEqual(v11.get(v1_1).getNode(), arg12)) {
                    }
                    else {
                        ++v1_1;
                        continue;
                    }

                    return 1;
                }

                if(arg12.getLayoutState$ui() != LayoutState.Measuring) {
                    if(arg12.getLayoutState$ui() == LayoutState.LayingOut) {
                    }
                    else {
                        return 0;
                    }
                }
            }

            return 1;
        }

    label_95:
        if(Intrinsics.areEqual(arg12.isPlacedInLookahead(), Boolean.valueOf(true))) {
            if(arg12.getLookaheadMeasurePending$ui()) {
                v3 = this.postponedMeasureRequests;
                v6 = v3.size();
                for(v7 = 0; v7 < v6; ++v7) {
                    v8 = v3.get(v7);
                    v9 = v8;
                    if((Intrinsics.areEqual(((PostponedRequest)v9).getNode(), arg12)) && (((PostponedRequest)v9).isLookahead())) {
                        v1 = v8;
                        break;
                    }
                }

                if(v1 == null) {
                    goto label_119;
                }

                return 1;
            }

        label_119:
            if(arg12.getLookaheadMeasurePending$ui()) {
                if(!this.relayoutNodes.contains(arg12, true) && (v0 == null || !v0.getLookaheadMeasurePending$ui()) && v2 != LayoutState.LookaheadMeasuring && (v0 == null || !v0.getMeasurePending$ui() || !Intrinsics.areEqual(arg12.getLookaheadRoot$ui(), arg12))) {
                    return 0;
                }

                return 1;
            }

            if(!arg12.getLookaheadLayoutPending$ui()) {
                return 1;
            }

            if(this.relayoutNodes.contains(arg12, true)) {
                return 1;
            }

            if(v0 == null) {
                return 1;
            }

            if(v0.getLookaheadMeasurePending$ui()) {
                return 1;
            }

            if(v0.getLookaheadLayoutPending$ui()) {
                return 1;
            }

            if(v2 == LayoutState.LookaheadMeasuring) {
                return 1;
            }

            if(v2 == LayoutState.LookaheadLayingOut) {
                return 1;
            }

            if((v0.getLayoutPending$ui()) && (Intrinsics.areEqual(arg12.getLookaheadRoot$ui(), arg12))) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    private final boolean isTreeConsistent(LayoutNode arg5) {
        if(!this.consistentLayoutState(arg5)) {
            return 0;
        }

        List v5 = arg5.getChildren$ui();
        int v0 = v5.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.isTreeConsistent(v5.get(v2))) {
                return 0;
            }
        }

        return 1;
    }

    private final String logTree() {
        StringBuilder v0 = new StringBuilder();
        StringBuilder v1 = v0.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(v1, "append(...)");
        Intrinsics.checkNotNullExpressionValue(v1.append('\n'), "append(...)");
        LayoutTreeConsistencyChecker.logTree$printSubTree(this, v0, this.root, 0);
        return v0.toString();
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker arg4, StringBuilder arg5, LayoutNode arg6, int arg7) {
        String v0 = arg4.nodeToString(arg6);
        int v2 = 0;
        if(v0.length() > 0) {
            int v1;
            for(v1 = 0; v1 < arg7; ++v1) {
                arg5.append("..");
            }

            StringBuilder v0_1 = arg5.append(v0);
            Intrinsics.checkNotNullExpressionValue(v0_1, "append(...)");
            Intrinsics.checkNotNullExpressionValue(v0_1.append('\n'), "append(...)");
            ++arg7;
        }

        List v6 = arg6.getChildren$ui();
        int v0_2 = v6.size();
        while(v2 < v0_2) {
            LayoutTreeConsistencyChecker.logTree$printSubTree(arg4, arg5, v6.get(v2), arg7);
            ++v2;
        }
    }

    private final String nodeToString(LayoutNode arg5) {
        StringBuilder v0 = new StringBuilder();
        v0.append(arg5);
        char v2 = ']';
        v0.append("[" + arg5.getLayoutState$ui() + v2);
        if(!arg5.isPlaced()) {
            v0.append("[!isPlaced]");
        }

        v0.append("[measuredByParent=" + arg5.getMeasuredByParent$ui() + v2);
        if(!this.consistentLayoutState(arg5)) {
            v0.append("[INCONSISTENT]");
        }

        return v0.toString();
    }
}

