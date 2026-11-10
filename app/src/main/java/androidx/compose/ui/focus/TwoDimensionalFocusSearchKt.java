package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u001A;\u0010\u0003\u001A\u0004\u0018\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u000BH\u0000¢\u0006\u0004\b\f\u0010\r\u001A/\u0010\u000E\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u000BH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A7\u0010\u0011\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u000BH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A7\u0010\u0015\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u000BH\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001A\u001A\u0010\u0017\u001A\u00020\u0018*\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00050\u001BH\u0002\u001A+\u0010\u001C\u001A\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00050\u001B2\u0006\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u001E\u0010\u001F\u001A/\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\t2\u0006\u0010\"\u001A\u00020\t2\u0006\u0010#\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0004\b$\u0010%\u001A/\u0010&\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020\t2\u0006\u0010(\u001A\u00020\t2\u0006\u0010)\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010%\u001A\f\u0010+\u001A\u00020\t*\u00020\tH\u0002\u001A\f\u0010,\u001A\u00020\t*\u00020\tH\u0002\u001A\f\u0010-\u001A\u00020\u0005*\u00020\u0005H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2={"InvalidFocusDirection", "", "NoActiveChild", "twoDimensionalFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "onFound", "Lkotlin/Function1;", "twoDimensionalFocusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "findChildCorrespondingToFocusEnter", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/geometry/Rect;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "beamBeats", "source", "rect1", "rect2", "beamBeats-I7lrPNg", "topLeft", "bottomRight", "activeNode", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TwoDimensionalFocusSearchKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[FocusStateImpl.values().length];
            try {
                v0[FocusStateImpl.ActiveParent.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[FocusStateImpl.Active.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[FocusStateImpl.Captured.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[FocusStateImpl.Inactive.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    public static final boolean access$searchChildren-4C6V_qg(FocusTargetNode arg0, Rect arg1, int arg2, Function1 arg3) {
        return TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg(arg0, arg1, arg2, arg3);
    }

    private static final FocusTargetNode activeNode(FocusTargetNode arg2) {
        if(arg2.getFocusState() == FocusStateImpl.ActiveParent) {
            arg2 = FocusTraversalKt.findActiveFocusNode(arg2);
            if(arg2 != null) {
                return arg2;
            }

            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }

        throw new IllegalStateException("Searching for active node in inactive hierarchy".toString());
    }

    private static final boolean beamBeats-I7lrPNg(Rect arg3, Rect arg4, Rect arg5, int arg6) {
        if(!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(arg5, arg6, arg3)) {
            if(!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(arg4, arg6, arg3)) {
            }
            else if(!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$isInDirectionOfSearch(arg5, arg6, arg3)) {
                return 1;
            }
            else {
                if(!FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                    if(FocusDirection.equals-impl0(arg6, FocusDirection.Companion.getRight-dhqQ-8s())) {
                    }
                    else if(TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistance(arg4, arg6, arg3) < TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(arg5, arg6, arg3)) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect arg3, int arg4, Rect arg5) {
        if(!FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getRight-dhqQ-8s())) {
            }
            else {
                if(!FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    }
                    else {
                        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                    }
                }

                if(arg3.getRight() > arg5.getLeft() && arg3.getLeft() < arg5.getRight()) {
                    return 1;
                }

                return 0;
            }
        }

        if(arg3.getBottom() > arg5.getTop() && arg3.getTop() < arg5.getBottom()) {
            return 1;
        }

        return 0;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect arg3, int arg4, Rect arg5) {
        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            if(arg5.getLeft() >= arg3.getRight()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getRight-dhqQ-8s())) {
            if(arg5.getRight() <= arg3.getLeft()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getUp-dhqQ-8s())) {
            if(arg5.getTop() >= arg3.getBottom()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getDown-dhqQ-8s())) {
            if(arg5.getBottom() <= arg3.getTop()) {
                return 1;
            }

            return 0;
        }

        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance(Rect arg1, int arg2, Rect arg3) {
        float v1;
        float v2;
        if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            v2 = arg3.getLeft();
            v1 = arg1.getRight();
            goto label_6;
        }
        else {
            if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getRight-dhqQ-8s())) {
                v1 = arg1.getLeft();
                v2 = arg3.getRight();
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getUp-dhqQ-8s())) {
                v2 = arg3.getTop();
                v1 = arg1.getBottom();
            label_6:
                v2 -= v1;
                goto label_30;
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getDown-dhqQ-8s())) {
                v1 = arg1.getTop();
                v2 = arg3.getBottom();
            }
            else {
                goto label_34;
            }

            v2 = v1 - v2;
        }

    label_30:
        if(v2 < 0f) {
            return 0;
        }

        return v2;
    label_34:
        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect arg1, int arg2, Rect arg3) {
        float v1;
        float v2;
        if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            v2 = arg3.getLeft();
            v1 = arg1.getLeft();
            goto label_6;
        }
        else {
            if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getRight-dhqQ-8s())) {
                v1 = arg1.getRight();
                v2 = arg3.getRight();
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getUp-dhqQ-8s())) {
                v2 = arg3.getTop();
                v1 = arg1.getTop();
            label_6:
                v2 -= v1;
                goto label_30;
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getDown-dhqQ-8s())) {
                v1 = arg1.getBottom();
                v2 = arg3.getBottom();
            }
            else {
                goto label_34;
            }

            v2 = v1 - v2;
        }

    label_30:
        v1 = 1f;
        if(v2 < v1) {
            return v1;
        }

        return v2;
    label_34:
        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    private static final Rect bottomRight(Rect arg4) {
        return new Rect(arg4.getRight(), arg4.getBottom(), arg4.getRight(), arg4.getBottom());
    }

    private static final void collectAccessibleChildren(DelegatableNode arg10, MutableVector arg11) {
        Node v10_1;
        MutableVector v6;
        Object v5;
        Object v10;
        int v0 = NodeKind.constructor-impl(0x400);
        if(!arg10.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v2 = 16;
        MutableVector v1 = new MutableVector(new Node[v2], 0);
        Node v3 = arg10.getNode().getChild$ui();
        if(v3 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1, arg10.getNode(), false);
        }
        else {
            v1.add(v3);
        }

    label_19:
        while(v1.getSize() != 0) {
            v10 = v1.removeAt(v1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1, ((Node)v10), false);
                continue;
            }

            goto label_30;
        }

        return;
        while(true) {
        label_30:
            if(v10 == null) {
                goto label_19;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v5 = null;
                v6 = ((MutableVector)v5);
                break;
            }

            v10_1 = ((Node)v10).getChild$ui();
        }

        while(true) {
        label_36:
            if(v10 == null) {
                goto label_19;
            }

            if((v10 instanceof FocusTargetNode)) {
                if(((FocusTargetNode)v10).isAttached()) {
                    Object v7 = v10;
                    if(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v7)).isDeactivated()) {
                    }
                    else if(((FocusTargetNode)v10).fetchFocusProperties$ui().getCanFocus()) {
                        arg11.add(v10);
                    }
                    else {
                        TwoDimensionalFocusSearchKt.collectAccessibleChildren(((DelegatableNode)v7), arg11);
                    }
                }
            }
            else if((((Node)v10).getKindSet$ui() & v0) != 0 && ((v10 instanceof DelegatingNode))) {
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
                                v6 = new MutableVector(new Node[v2], 0);
                            }

                            if(v10 != null) {
                                if(v6 != null) {
                                    v6.add(v10);
                                }

                                v10 = v5;
                            }

                            if(v6 == null) {
                                goto label_79;
                            }

                            v6.add(v7_1);
                        }
                    }

                label_79:
                    v7_1 = v7_1.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v6);
        goto label_36;
    }

    private static final FocusTargetNode findBestCandidate-4WY_MpI(MutableVector arg7, Rect arg8, int arg9) {
        Object v2_2;
        Rect v0;
        float v2 = 1f;
        if(FocusDirection.equals-impl0(arg9, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            v0 = arg8.translate(arg8.getRight() - arg8.getLeft() + v2, 0f);
        }
        else if(FocusDirection.equals-impl0(arg9, FocusDirection.Companion.getRight-dhqQ-8s())) {
            v0 = arg8.translate(-(arg8.getRight() - arg8.getLeft() + v2), 0f);
        }
        else if(FocusDirection.equals-impl0(arg9, FocusDirection.Companion.getUp-dhqQ-8s())) {
            v0 = arg8.translate(0f, arg8.getBottom() - arg8.getTop() + v2);
        }
        else if(FocusDirection.equals-impl0(arg9, FocusDirection.Companion.getDown-dhqQ-8s())) {
            v0 = arg8.translate(0f, -(arg8.getBottom() - arg8.getTop() + v2));
        }
        else {
            goto label_59;
        }

        Object[] v1 = arg7.content;
        int v7 = arg7.getSize();
        FocusTargetNode v2_1 = null;
        int v3;
        for(v3 = 0; v3 < v7; ++v3) {
            Object v4 = v1[v3];
            if(FocusTraversalKt.isEligibleForFocusSearch(((FocusTargetNode)v4))) {
                Rect v5 = FocusTraversalKt.focusRect(((FocusTargetNode)v4));
                if(TwoDimensionalFocusSearchKt.isBetterCandidate-I7lrPNg(v5, v0, arg8, arg9)) {
                    v2_2 = v4;
                    v0 = v5;
                }
            }
        }

        return ((FocusTargetNode)v2_2);
    label_59:
        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    public static final boolean findChildCorrespondingToFocusEnter--OM-vw8(FocusTargetNode arg4, int arg5, Function1 arg6) {
        Rect v4_1;
        MutableVector v0 = new MutableVector(new FocusTargetNode[16], 0);
        TwoDimensionalFocusSearchKt.collectAccessibleChildren(arg4, v0);
        if(v0.getSize() <= 1) {
            Object v4 = v0.getSize() == 0 ? null : v0.content[0];
            if(v4 != null) {
                return arg6.invoke(v4).booleanValue();
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            arg5 = FocusDirection.Companion.getRight-dhqQ-8s();
        }

        if((FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getRight-dhqQ-8s())) || (FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getDown-dhqQ-8s()))) {
            v4_1 = TwoDimensionalFocusSearchKt.topLeft(FocusTraversalKt.focusRect(arg4));
        }
        else {
            if(!FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                if(FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getUp-dhqQ-8s())) {
                }
                else {
                    throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                }
            }

            v4_1 = TwoDimensionalFocusSearchKt.bottomRight(FocusTraversalKt.focusRect(arg4));
        }

        arg4 = TwoDimensionalFocusSearchKt.findBestCandidate-4WY_MpI(v0, v4_1, arg5);
        if(arg4 != null) {
            return arg6.invoke(arg4).booleanValue();
        }

        return 0;
    }

    private static final boolean generateAndSearchChildren-4C6V_qg(FocusTargetNode arg7, Rect arg8, int arg9, Function1 arg10) {
        if(TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg(arg7, arg8, arg9, arg10)) {
            return 1;
        }

        Object v7 = BeyondBoundsLayoutKt.searchBeyondBounds--OM-vw8(arg7, arg9, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(DelegatableNodeKt.requireOwner(arg7).getFocusOwner().getActiveFocusTargetNode(), arg7, arg8, arg9, arg10));
        if(v7 != null) {
            return ((Boolean)v7).booleanValue();
        }

        return 0;
    }

    public static final boolean isBetterCandidate-I7lrPNg(Rect arg5, Rect arg6, Rect arg7, int arg8) {
        if(!TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$isCandidate(arg5, arg8, arg7)) {
            return 0;
        }

        if(!TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$isCandidate(arg6, arg8, arg7)) {
            return 1;
        }

        if(TwoDimensionalFocusSearchKt.beamBeats-I7lrPNg(arg7, arg5, arg6, arg8)) {
            return 1;
        }

        if(TwoDimensionalFocusSearchKt.beamBeats-I7lrPNg(arg7, arg6, arg5, arg8)) {
            return 0;
        }

        if(TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$weightedDistance(arg8, arg7, arg5) < TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$weightedDistance(arg8, arg7, arg6)) {
            return 1;
        }

        return 0;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect arg3, int arg4, Rect arg5) {
        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            if((arg5.getRight() > arg3.getRight() || arg5.getLeft() >= arg3.getRight()) && arg5.getLeft() > arg3.getLeft()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getRight-dhqQ-8s())) {
            if((arg5.getLeft() < arg3.getLeft() || arg5.getRight() <= arg3.getLeft()) && arg5.getRight() < arg3.getRight()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getUp-dhqQ-8s())) {
            if((arg5.getBottom() > arg3.getBottom() || arg5.getTop() >= arg3.getBottom()) && arg5.getTop() > arg3.getTop()) {
                return 1;
            }

            return 0;
        }

        if(FocusDirection.equals-impl0(arg4, FocusDirection.Companion.getDown-dhqQ-8s())) {
            if((arg5.getTop() < arg3.getTop() || arg5.getBottom() <= arg3.getTop()) && arg5.getBottom() < arg3.getBottom()) {
                return 1;
            }

            return 0;
        }

        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect arg1, int arg2, Rect arg3) {
        float v1;
        float v2;
        if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            v2 = arg3.getLeft();
            v1 = arg1.getRight();
            goto label_6;
        }
        else {
            if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getRight-dhqQ-8s())) {
                v1 = arg1.getLeft();
                v2 = arg3.getRight();
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getUp-dhqQ-8s())) {
                v2 = arg3.getTop();
                v1 = arg1.getBottom();
            label_6:
                v2 -= v1;
                goto label_30;
            }
            else if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getDown-dhqQ-8s())) {
                v1 = arg1.getTop();
                v2 = arg3.getBottom();
            }
            else {
                goto label_34;
            }

            v2 = v1 - v2;
        }

    label_30:
        if(v2 < 0f) {
            return 0;
        }

        return v2;
    label_34:
        throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect arg2, int arg3, Rect arg4) {
        float v2;
        float v0;
        float v4;
        float v3;
        float v1 = 2f;
        if((FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getLeft-dhqQ-8s())) || (FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getRight-dhqQ-8s()))) {
            v3 = arg4.getTop() + (arg4.getBottom() - arg4.getTop()) / v1;
            v4 = arg2.getTop();
            v0 = arg2.getBottom();
            v2 = arg2.getTop();
        }
        else {
            if(!FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getUp-dhqQ-8s())) {
                if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getDown-dhqQ-8s())) {
                }
                else {
                    throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
                }
            }

            v3 = arg4.getLeft() + (arg4.getRight() - arg4.getLeft()) / v1;
            v4 = arg2.getLeft();
            v0 = arg2.getRight();
            v2 = arg2.getLeft();
        }

        return v3 - (v4 + (v0 - v2) / v1);
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int arg4, Rect arg5, Rect arg6) {
        long v0 = ((long)TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$majorAxisDistance(arg6, arg4, arg5));
        long v4 = ((long)TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$minorAxisDistance(arg6, arg4, arg5));
        return 13 * v0 * v0 + v4 * v4;
    }

    private static final boolean searchChildren-4C6V_qg(FocusTargetNode arg11, Rect arg12, int arg13, Function1 arg14) {
        Node v11_1;
        MutableVector v7;
        Object v6;
        Object v11;
        int v1 = 16;
        MutableVector v0 = new MutableVector(new FocusTargetNode[v1], 0);
        int v2 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)arg11).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v4 = new MutableVector(new Node[v1], 0);
        Node v5 = ((DelegatableNode)arg11).getNode().getChild$ui();
        if(v5 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v4, ((DelegatableNode)arg11).getNode(), false);
        }
        else {
            v4.add(v5);
        }

        while(true) {
        label_22:
            if(v4.getSize() != 0) {
                v11 = v4.removeAt(v4.getSize() - 1);
                if((((Node)v11).getAggregateChildKindSet$ui() & v2) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(v4, ((Node)v11), false);
                    continue;
                }

                break;
            }

            goto label_80;
        }

        while(true) {
            if(v11 == null) {
                goto label_22;
            }

            if((((Node)v11).getKindSet$ui() & v2) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                goto label_39;
            }

            v11_1 = v11_1.getChild$ui();
        }

    label_80:
        while(v0.getSize() != 0) {
            arg11 = TwoDimensionalFocusSearchKt.findBestCandidate-4WY_MpI(v0, arg12, arg13);
            if(arg11 == null) {
                return 0;
            }

            if(arg11.fetchFocusProperties$ui().getCanFocus()) {
                return arg14.invoke(arg11).booleanValue();
            }

            if(TwoDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg11, arg12, arg13, arg14)) {
                return 1;
            }

            v0.remove(arg11);
        }

        return 0;
        while(true) {
        label_39:
            if(v11_1 == null) {
                goto label_22;
            }

            if((v11_1 instanceof FocusTargetNode)) {
                if(((FocusTargetNode)v11_1).isAttached()) {
                    v0.add(v11_1);
                }
            }
            else if((v11_1.getKindSet$ui() & v2) != 0 && ((v11_1 instanceof DelegatingNode))) {
                Node v8 = v11_1.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v2) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v11_1 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v1], 0);
                            }

                            if(v11_1 != null) {
                                if(v7 != null) {
                                    v7.add(v11_1);
                                }

                                v11 = v6;
                            }

                            if(v7 == null) {
                                goto label_72;
                            }

                            v7.add(v8);
                        }
                    }

                label_72:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v11_1 = DelegatableNodeKt.access$pop(v7);
        goto label_39;
    }

    private static final Rect topLeft(Rect arg4) {
        return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getLeft(), arg4.getTop());
    }

    public static final Boolean twoDimensionalFocusSearch-sMXa3k8(FocusTargetNode arg8, int arg9, Rect arg10, Function1 arg11) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg8.getFocusState().ordinal()];
        int v1 = 4;
        int v2 = 3;
        int v3 = 2;
        if(v0 != 1) {
            if(v0 != v3 && v0 != v2) {
                if(v0 != v1) {
                    throw new NoWhenBranchMatchedException();
                }
                else if(arg8.fetchFocusProperties$ui().getCanFocus()) {
                    return arg11.invoke(arg8);
                }
                else if(arg10 == null) {
                    return Boolean.valueOf(TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(arg8, arg9, arg11));
                }
                else {
                    return Boolean.valueOf(TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg(arg8, arg10, arg9, arg11));
                }
            }

            return Boolean.valueOf(TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(arg8, arg9, arg11));
        }

        FocusTargetNode v0_1 = FocusTraversalKt.getActiveChild(arg8);
        String v5 = "ActiveParent must have a focusedChild";
        if(v0_1 != null) {
            int v6 = WhenMappings.$EnumSwitchMapping$0[v0_1.getFocusState().ordinal()];
            if(v6 != 1) {
                if(v6 != v3 && v6 != v2) {
                    if(v6 != v1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    else {
                        throw new IllegalStateException(v5.toString());
                    }
                }

                if(arg10 == null) {
                    arg10 = FocusTraversalKt.focusRect(v0_1);
                }

                return Boolean.valueOf(TwoDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg8, arg10, arg9, arg11));
            }

            Boolean v1_1 = TwoDimensionalFocusSearchKt.twoDimensionalFocusSearch-sMXa3k8(v0_1, arg9, arg10, arg11);
            if(!Intrinsics.areEqual(v1_1, Boolean.valueOf(false))) {
                return v1_1;
            }

            if(arg10 == null) {
                arg10 = FocusTraversalKt.focusRect(TwoDimensionalFocusSearchKt.activeNode(v0_1));
            }

            return Boolean.valueOf(TwoDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg8, arg10, arg9, arg11));
        }

        throw new IllegalStateException(v5.toString());
    }
}

