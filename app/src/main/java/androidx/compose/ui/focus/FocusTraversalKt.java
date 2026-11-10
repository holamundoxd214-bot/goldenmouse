package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001AC\u0010\t\u001A\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000EH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A\f\u0010\u0011\u001A\u00020\f*\u00020\u0002H\u0000\u001A\u000E\u0010\u0017\u001A\u0004\u0018\u00010\u0002*\u00020\u0002H\u0000\u001A\u000E\u0010\u0018\u001A\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002\"\u0018\u0010\u0012\u001A\u00020\n*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\"\u001A\u0010\u0014\u001A\u0004\u0018\u00010\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2={"customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "focusSearch", "", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "focusRect", "isEligibleForFocusSearch", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "activeChild", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "findActiveFocusNode", "findNonDeactivatedParent", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusTraversalKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[LayoutDirection.Rtl.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    v0 = new int[FocusStateImpl.values().length];
                    try {
                        v0[FocusStateImpl.Active.ordinal()] = 1;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            v0[FocusStateImpl.ActiveParent.ordinal()] = v2;
                            goto label_21;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_21:
                                v0[FocusStateImpl.Captured.ordinal()] = 3;
                                goto label_25;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_25:
                                    v0[FocusStateImpl.Inactive.ordinal()] = 4;
                                    goto label_29;
                                }
                                catch(NoSuchFieldError ) {
                                label_29:
                                    WhenMappings.$EnumSwitchMapping$1 = v0;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final FocusRequester customFocusSearch--OM-vw8(FocusTargetNode arg5, int arg6, LayoutDirection arg7) {
        FocusRequester v5_1;
        int v5;
        FocusProperties v0 = arg5.fetchFocusProperties$ui();
        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getNext-dhqQ-8s())) {
            return v0.getNext();
        }

        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            return v0.getPrevious();
        }

        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getUp-dhqQ-8s())) {
            return v0.getUp();
        }

        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getDown-dhqQ-8s())) {
            return v0.getDown();
        }

        int v2 = 2;
        FocusRequester v4 = null;
        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            v5 = WhenMappings.$EnumSwitchMapping$0[arg7.ordinal()];
            if(v5 == 1) {
                v5_1 = v0.getStart();
            }
            else if(v5 == v2) {
                v5_1 = v0.getEnd();
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(v5_1 == FocusRequester.Companion.getDefault()) {
            }
            else {
                v4 = v5_1;
            }

            if(v4 == null) {
                return v0.getLeft();
            }

            return v4;
        }

        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getRight-dhqQ-8s())) {
            v5 = WhenMappings.$EnumSwitchMapping$0[arg7.ordinal()];
            if(v5 == 1) {
                v5_1 = v0.getEnd();
            }
            else if(v5 == v2) {
                v5_1 = v0.getStart();
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(v5_1 == FocusRequester.Companion.getDefault()) {
            }
            else {
                v4 = v5_1;
            }

            if(v4 == null) {
                return v0.getRight();
            }

            return v4;
        }

        if(!FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getExit-dhqQ-8s())) {
            }
            else {
                throw new IllegalStateException("invalid FocusDirection".toString());
            }
        }

        CancelIndicatingFocusBoundaryScope v7 = new CancelIndicatingFocusBoundaryScope(arg6, ((DefaultConstructorMarker)v4));
        FocusOwner v5_2 = DelegatableNodeKt.requireOwner(((DelegatableNode)arg5)).getFocusOwner();
        FocusTargetNode v1 = v5_2.getActiveFocusTargetNode();
        if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            v0.getOnEnter().invoke(v7);
        }
        else {
            v0.getOnExit().invoke(v7);
        }

        if(v7.isCanceled()) {
            return FocusRequester.Companion.getCancel();
        }

        if(v1 != v5_2.getActiveFocusTargetNode()) {
            return FocusRequester.Companion.getRedirect$ui();
        }

        return FocusRequester.Companion.getDefault();
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode arg1) {
        arg1 = DelegatableNodeKt.requireOwner(((DelegatableNode)arg1)).getFocusOwner().getActiveFocusTargetNode();
        if(arg1 != null && (arg1.isAttached())) {
            return arg1;
        }

        return null;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode arg10) {
        Node v2;
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = ((DelegatableNode)arg10).getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg10));
        while(true) {
            v2 = null;
            if(v10 == null) {
                break;
            }

            if((v10.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                while(v1 != null) {
                    if((v1.getKindSet$ui() & v0) != 0) {
                        Node v3 = v1;
                        MutableVector v4 = ((MutableVector)v2);
                        while(true) {
                        label_23:
                            if(v3 != null) {
                                if((v3 instanceof FocusTargetNode)) {
                                    if(((FocusTargetNode)v3).fetchFocusProperties$ui().getCanFocus()) {
                                        return ((FocusTargetNode)v3);
                                    }
                                }
                                else if((v3.getKindSet$ui() & v0) != 0 && ((v3 instanceof DelegatingNode))) {
                                    Node v5 = v3.getDelegate$ui();
                                    int v7 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & v0) != 0) {
                                            ++v7;
                                            if(v7 == 1) {
                                                v3 = v5;
                                            }
                                            else {
                                                if(v4 == null) {
                                                    v4 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v3 != null) {
                                                    if(v4 != null) {
                                                        v4.add(v3);
                                                    }

                                                    v3 = v2;
                                                }

                                                if(v4 == null) {
                                                    goto label_59;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_59:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v7 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_65;
                        }

                        v3 = DelegatableNodeKt.access$pop(v4);
                        goto label_23;
                    }

                label_65:
                    v1 = v1.getParent$ui();
                }
            }

            v10 = v10.getParent$ui();
            if(v10 != null) {
                NodeChain v1_1 = v10.getNodes$ui();
                if(v1_1 != null) {
                    v1 = v1_1.getTail$ui();
                    continue;
                }
            }

            v1 = v2;
        }

        return ((FocusTargetNode)v2);
    }

    public static final Rect focusRect(FocusTargetNode arg2) {
        if(!arg2.isAttached()) {
            return Rect.Companion.getZero();
        }

        NodeCoordinator v0 = arg2.getCoordinator$ui();
        if(v0 != null) {
            LayoutCoordinates v0_1 = LayoutCoordinatesKt.findRootCoordinates(((LayoutCoordinates)v0));
            if(v0_1 != null) {
                if(v0_1.isAttached()) {
                }
                else {
                    v0_1 = null;
                }

                if(v0_1 == null) {
                    goto label_17;
                }

                return arg2.fetchFocusRect$ui(v0_1);
            }
        }

    label_17:
        return Rect.Companion.getZero();
    }

    public static final Boolean focusSearch-0X8WOeE(FocusTargetNode arg2, int arg3, LayoutDirection arg4, Rect arg5, Function1 arg6) {
        if(!FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getNext-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            }
            else {
                if(!FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getLeft-dhqQ-8s()) && !FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getRight-dhqQ-8s()) && !FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    }
                    else {
                        Boolean v1 = null;
                        if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getEnter-dhqQ-8s())) {
                            arg3 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
                            if(arg3 == 1) {
                                arg3 = FocusDirection.Companion.getRight-dhqQ-8s();
                            }
                            else if(arg3 == 2) {
                                arg3 = FocusDirection.Companion.getLeft-dhqQ-8s();
                            }
                            else {
                                throw new NoWhenBranchMatchedException();
                            }

                            arg2 = FocusTraversalKt.findActiveFocusNode(arg2);
                            if(arg2 != null) {
                                return TwoDimensionalFocusSearchKt.twoDimensionalFocusSearch-sMXa3k8(arg2, arg3, arg5, arg6);
                            }

                            return v1;
                        }
                        else {
                            if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getExit-dhqQ-8s())) {
                                FocusTargetNode v3 = FocusTraversalKt.findActiveFocusNode(arg2);
                                if(v3 != null) {
                                    FocusTargetNode v1_1 = FocusTraversalKt.findNonDeactivatedParent(v3);
                                }

                                boolean v2 = (((FocusTargetNode)v1)) == null || (Intrinsics.areEqual(v1, arg2)) ? false : arg6.invoke(v1).booleanValue();
                                return Boolean.valueOf(v2);
                            }

                            throw new IllegalStateException("Focus search invoked with invalid FocusDirection " + FocusDirection.toString-impl(arg3).toString());
                        }
                    }
                }

                return TwoDimensionalFocusSearchKt.twoDimensionalFocusSearch-sMXa3k8(arg2, arg3, arg5, arg6);
            }
        }

        return Boolean.valueOf(OneDimensionalFocusSearchKt.oneDimensionalFocusSearch--OM-vw8(arg2, arg3, arg6));
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode arg10) {
        Node v10_1;
        MutableVector v6;
        Object v10;
        FocusTargetNode v1 = null;
        if(!arg10.getNode().isAttached()) {
            return v1;
        }

        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v3 = 16;
        MutableVector v2 = new MutableVector(new Node[v3], 0);
        Node v4 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v4 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v2.add(v4);
        }

    label_24:
        while(v2.getSize() != 0) {
            v10 = v2.removeAt(v2.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v2, ((Node)v10), false);
                continue;
            }

            goto label_35;
        }

        return v1;
        while(true) {
        label_35:
            if(v10 == null) {
                goto label_24;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v6 = ((MutableVector)v1);
                break;
            }

            v10_1 = ((Node)v10).getChild$ui();
        }

        while(true) {
        label_40:
            if(v10 == null) {
                goto label_24;
            }

            if(!(v10 instanceof FocusTargetNode)) {
                if((((Node)v10).getKindSet$ui() & v0) == 0) {
                    break;
                }

                if(!(v10 instanceof DelegatingNode)) {
                    break;
                }

                Node v7_1 = v10.getDelegate$ui();
                int v8 = 0;
                while(v7_1 != null) {
                    if((v7_1.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7_1;
                        }
                        else {
                            if(v6 == null) {
                                v6 = new MutableVector(new Node[v3], 0);
                            }

                            if(v10 != null) {
                                if(v6 != null) {
                                    v6.add(v10);
                                }

                                v10 = v1;
                            }

                            if(v6 == null) {
                                goto label_88;
                            }

                            v6.add(v7_1);
                        }
                    }

                label_88:
                    v7_1 = v7_1.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }
            else if(((FocusTargetNode)v10).getNode().isAttached()) {
                int v7 = WhenMappings.$EnumSwitchMapping$1[((FocusTargetNode)v10).getFocusState().ordinal()];
                if(v7 != 1 && v7 != 2 && v7 != 3) {
                    if(v7 == 4) {
                        break;
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return ((FocusTargetNode)v10);
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v6);
        goto label_40;
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode arg2) {
        NodeCoordinator v0 = arg2.getCoordinator$ui();
        if(v0 != null) {
            LayoutNode v0_1 = v0.getLayoutNode();
            if(v0_1 != null && (v0_1.isPlaced())) {
                NodeCoordinator v2 = arg2.getCoordinator$ui();
                if(v2 != null) {
                    LayoutNode v2_1 = v2.getLayoutNode();
                    if(v2_1 != null && (v2_1.isAttached())) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}

