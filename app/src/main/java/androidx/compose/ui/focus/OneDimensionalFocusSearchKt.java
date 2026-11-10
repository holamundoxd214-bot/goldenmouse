package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A/\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A \u0010\u000F\u001A\u00020\u0007*\u00020\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002\u001A \u0010\u0010\u001A\u00020\u0007*\u00020\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002\u001A7\u0010\u0011\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A7\u0010\u0015\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001A \u0010\u0017\u001A\u00020\u0007*\u00020\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002\u001A \u0010\u0018\u001A\u00020\u0007*\u00020\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\fH\u0002\u001A\f\u0010\u0019\u001A\u00020\u0007*\u00020\bH\u0002\u001AE\u0010\u001A\u001A\u00020\u001B\"\u0004\b\u0000\u0010\u001C*\b\u0012\u0004\u0012\u0002H\u001C0\u001D2\u0006\u0010\u001E\u001A\u0002H\u001C2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\u001B0\fH\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010 \u001AE\u0010!\u001A\u00020\u001B\"\u0004\b\u0000\u0010\u001C*\b\u0012\u0004\u0012\u0002H\u001C0\u001D2\u0006\u0010\u001E\u001A\u0002H\u001C2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\u001B0\fH\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010 \"\u0014\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003¨\u0006\""}, d2={"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "oneDimensionalFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "onFound", "Lkotlin/Function1;", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "forwardFocusSearch", "backwardFocusSearch", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "pickChildForForwardSearch", "pickChildForBackwardSearch", "isRoot", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OneDimensionalFocusSearchKt {
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

    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    public static final boolean access$searchChildren-4C6V_qg(FocusTargetNode arg0, FocusTargetNode arg1, int arg2, Function1 arg3) {
        return OneDimensionalFocusSearchKt.searchChildren-4C6V_qg(arg0, arg1, arg2, arg3);
    }

    private static final boolean backwardFocusSearch(FocusTargetNode arg9, Function1 arg10) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg9.getFocusState().ordinal()];
        int v1 = 4;
        int v2 = 3;
        int v3 = 2;
        if(v0 != 1) {
            if(v0 != v3 && v0 != v2) {
                if(v0 == v1) {
                    if(!OneDimensionalFocusSearchKt.pickChildForBackwardSearch(arg9, arg10)) {
                        boolean v9 = arg9.fetchFocusProperties$ui().getCanFocus() ? arg10.invoke(arg9).booleanValue() : false;
                        if(v9) {
                            return 1;
                        }

                        return 0;
                    }

                    return 1;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            return OneDimensionalFocusSearchKt.pickChildForBackwardSearch(arg9, arg10);
        }

        FocusTargetNode v0_1 = FocusTraversalKt.getActiveChild(arg9);
        String v6 = "ActiveParent must have a focusedChild";
        if(v0_1 != null) {
            int v7 = WhenMappings.$EnumSwitchMapping$0[v0_1.getFocusState().ordinal()];
            if(v7 != 1) {
                if(v7 != v3 && v7 != v2) {
                    if(v7 != v1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    else {
                        throw new IllegalStateException(v6.toString());
                    }
                }

                return OneDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg9, v0_1, FocusDirection.Companion.getPrevious-dhqQ-8s(), arg10);
            }

            if(!OneDimensionalFocusSearchKt.backwardFocusSearch(v0_1, arg10) && !OneDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg9, v0_1, FocusDirection.Companion.getPrevious-dhqQ-8s(), arg10) && (!v0_1.fetchFocusProperties$ui().getCanFocus() || !arg10.invoke(v0_1).booleanValue())) {
                return 0;
            }

            return 1;
        }

        throw new IllegalStateException(v6.toString());
    }

    private static final void forEachItemAfter(MutableVector arg4, Object arg5, Function1 arg6) {
        int v1 = 0;
        IntRange v0 = RangesKt.until(0, arg4.getSize());
        int v2 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v2 <= v0_1) {
            while(true) {
                if(v1 != 0) {
                    arg6.invoke(arg4.content[v2]);
                }

                if(Intrinsics.areEqual(arg4.content[v2], arg5)) {
                    v1 = 1;
                }

                if(v2 == v0_1) {
                    return;
                }

                ++v2;
            }
        }
    }

    private static final void forEachItemBefore(MutableVector arg4, Object arg5, Function1 arg6) {
        int v1 = 0;
        IntRange v0 = RangesKt.until(0, arg4.getSize());
        int v2 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v2 <= v0_1) {
            while(true) {
                if(v1 != 0) {
                    arg6.invoke(arg4.content[v0_1]);
                }

                if(Intrinsics.areEqual(arg4.content[v0_1], arg5)) {
                    v1 = 1;
                }

                if(v0_1 == v2) {
                    return;
                }

                --v0_1;
            }
        }
    }

    private static final boolean forwardFocusSearch(FocusTargetNode arg3, Function1 arg4) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getFocusState().ordinal()];
        if(v0 != 1) {
            if(v0 != 2 && v0 != 3) {
                if(v0 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                else if(arg3.fetchFocusProperties$ui().getCanFocus()) {
                    return arg4.invoke(arg3).booleanValue();
                }
                else {
                    return OneDimensionalFocusSearchKt.pickChildForForwardSearch(arg3, arg4);
                }
            }

            return OneDimensionalFocusSearchKt.pickChildForForwardSearch(arg3, arg4);
        }

        FocusTargetNode v0_1 = FocusTraversalKt.getActiveChild(arg3);
        if(v0_1 != null) {
            if(!OneDimensionalFocusSearchKt.forwardFocusSearch(v0_1, arg4)) {
                if(OneDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg(arg3, v0_1, FocusDirection.Companion.getNext-dhqQ-8s(), arg4)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }

    private static final boolean generateAndSearchChildren-4C6V_qg(FocusTargetNode arg7, FocusTargetNode arg8, int arg9, Function1 arg10) {
        if(OneDimensionalFocusSearchKt.searchChildren-4C6V_qg(arg7, arg8, arg9, arg10)) {
            return 1;
        }

        Object v7 = BeyondBoundsLayoutKt.searchBeyondBounds--OM-vw8(arg7, arg9, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(DelegatableNodeKt.requireOwner(arg7).getFocusOwner().getActiveFocusTargetNode(), arg7, arg8, arg9, arg10));
        if(v7 != null) {
            return ((Boolean)v7).booleanValue();
        }

        return 0;
    }

    private static void getInvalidFocusDirection$annotations() {
    }

    private static void getNoActiveChild$annotations() {
    }

    private static final boolean isRoot(FocusTargetNode arg10) {
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = ((DelegatableNode)arg10).getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg10));
        while(true) {
            Node v4 = null;
            if(v10 != null) {
                if((v10.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                    while(v1 != null) {
                        if((v1.getKindSet$ui() & v0) != 0) {
                            Node v5 = v1;
                            MutableVector v6 = ((MutableVector)v4);
                            while(true) {
                            label_25:
                                if(v5 != null) {
                                    if((v5 instanceof FocusTargetNode)) {
                                        v4 = v5;
                                        goto label_73;
                                    }
                                    else {
                                        if((v5.getKindSet$ui() & v0) != 0 && ((v5 instanceof DelegatingNode))) {
                                            Node v7 = v5.getDelegate$ui();
                                            int v8 = 0;
                                            while(v7 != null) {
                                                if((v7.getKindSet$ui() & v0) != 0) {
                                                    ++v8;
                                                    if(v8 == 1) {
                                                        v5 = v7;
                                                    }
                                                    else {
                                                        if(v6 == null) {
                                                            v6 = new MutableVector(new Node[16], 0);
                                                        }

                                                        if(v5 != null) {
                                                            if(v6 != null) {
                                                                v6.add(v5);
                                                            }

                                                            v5 = v4;
                                                        }

                                                        if(v6 == null) {
                                                            goto label_57;
                                                        }

                                                        v6.add(v7);
                                                    }
                                                }

                                            label_57:
                                                v7 = v7.getChild$ui();
                                            }

                                            if(v8 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_63;
                            }

                            v5 = DelegatableNodeKt.access$pop(v6);
                            goto label_25;
                        }

                    label_63:
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

                v1 = v4;
                continue;
            }

            break;
        }

    label_73:
        if(v4 == null) {
            return 1;
        }

        return 0;
    }

    public static final boolean oneDimensionalFocusSearch--OM-vw8(FocusTargetNode arg1, int arg2, Function1 arg3) {
        if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getNext-dhqQ-8s())) {
            return OneDimensionalFocusSearchKt.forwardFocusSearch(arg1, arg3);
        }

        if(FocusDirection.equals-impl0(arg2, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            return OneDimensionalFocusSearchKt.backwardFocusSearch(arg1, arg3);
        }

        throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode arg11, Function1 arg12) {
        Node v11_2;
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

    label_22:
        while(v4.getSize() != 0) {
            v11 = v4.removeAt(v4.getSize() - 1);
            if((((Node)v11).getAggregateChildKindSet$ui() & v2) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v4, ((Node)v11), false);
                continue;
            }

            goto label_33;
        }

        v0.sortWith(FocusableChildrenComparator.INSTANCE);
        int v11_1 = v0.getSize() - 1;
        Object[] v0_1 = v0.content;
        if(v11_1 < v0_1.length) {
            while(v11_1 >= 0) {
                Object v1_1 = v0_1[v11_1];
                if((FocusTraversalKt.isEligibleForFocusSearch(((FocusTargetNode)v1_1))) && (OneDimensionalFocusSearchKt.backwardFocusSearch(((FocusTargetNode)v1_1), arg12))) {
                    return 1;
                }

                --v11_1;
            }
        }

        return 0;
        while(true) {
        label_33:
            if(v11 == null) {
                goto label_22;
            }

            if((((Node)v11).getKindSet$ui() & v2) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                break;
            }

            v11_2 = ((Node)v11).getChild$ui();
        }

        while(true) {
        label_39:
            if(v11 == null) {
                goto label_22;
            }

            if((v11 instanceof FocusTargetNode)) {
                v0.add(v11);
            }
            else if((((Node)v11).getKindSet$ui() & v2) != 0 && ((v11 instanceof DelegatingNode))) {
                Node v8 = v11.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v2) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v11_2 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v1], 0);
                            }

                            if(v11_2 != null) {
                                if(v7 != null) {
                                    v7.add(v11_2);
                                }

                                v11 = v6;
                            }

                            if(v7 == null) {
                                goto label_70;
                            }

                            v7.add(v8);
                        }
                    }

                label_70:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v11_2 = DelegatableNodeKt.access$pop(v7);
        goto label_39;
    }

    private static final boolean pickChildForForwardSearch(FocusTargetNode arg11, Function1 arg12) {
        Node v11_2;
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

    label_22:
        while(v4.getSize() != 0) {
            v11 = v4.removeAt(v4.getSize() - 1);
            if((((Node)v11).getAggregateChildKindSet$ui() & v2) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v4, ((Node)v11), false);
                continue;
            }

            goto label_33;
        }

        v0.sortWith(FocusableChildrenComparator.INSTANCE);
        Object[] v11_1 = v0.content;
        int v0_1 = v0.getSize();
        v1 = 0;
        goto label_83;
        while(true) {
        label_33:
            if(v11 == null) {
                goto label_22;
            }

            if((((Node)v11).getKindSet$ui() & v2) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                goto label_39;
            }

            v11_2 = ((Node)v11).getChild$ui();
        }

    label_83:
        while(v1 < v0_1) {
            Object v2_1 = v11_1[v1];
            if((FocusTraversalKt.isEligibleForFocusSearch(((FocusTargetNode)v2_1))) && (OneDimensionalFocusSearchKt.forwardFocusSearch(((FocusTargetNode)v2_1), arg12))) {
                return 1;
            }

            ++v1;
        }

        return 0;
        while(true) {
        label_39:
            if(v11 == null) {
                goto label_22;
            }

            if((v11 instanceof FocusTargetNode)) {
                v0.add(v11);
            }
            else if((((Node)v11).getKindSet$ui() & v2) != 0 && ((v11 instanceof DelegatingNode))) {
                Node v8 = v11.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v2) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v11_2 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v1], 0);
                            }

                            if(v11 != null) {
                                if(v7 != null) {
                                    v7.add(v11);
                                }

                                v11 = v6;
                            }

                            if(v7 == null) {
                                goto label_70;
                            }

                            v7.add(v8);
                        }
                    }

                label_70:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v11_2 = DelegatableNodeKt.access$pop(v7);
        goto label_39;
    }

    private static final boolean searchChildren-4C6V_qg(FocusTargetNode arg12, FocusTargetNode arg13, int arg14, Function1 arg15) {
        Node v2_3;
        MutableVector v8;
        Object v7;
        Object v5_1;
        int v2_2;
        IntRange v1_1;
        Object v2_1;
        if(arg12.getFocusState() != FocusStateImpl.ActiveParent) {
            goto label_155;
        }

        int v1 = 16;
        MutableVector v0 = new MutableVector(new FocusTargetNode[v1], 0);
        FocusTargetNode v2 = arg12;
        int v4 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)v2).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v5 = new MutableVector(new Node[v1], 0);
        Node v6 = ((DelegatableNode)v2).getNode().getChild$ui();
        if(v6 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v5, ((DelegatableNode)v2).getNode(), false);
        }
        else {
            v5.add(v6);
        }

    label_26:
        while(v5.getSize() != 0) {
            v2_1 = v5.removeAt(v5.getSize() - 1);
            if((((Node)v2_1).getAggregateChildKindSet$ui() & v4) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v5, ((Node)v2_1), false);
                continue;
            }

            goto label_37;
        }

        v0.sortWith(FocusableChildrenComparator.INSTANCE);
        if(FocusDirection.equals-impl0(arg14, FocusDirection.Companion.getNext-dhqQ-8s())) {
            v1_1 = RangesKt.until(0, v0.getSize());
            v2_2 = v1_1.getFirst();
            v1 = v1_1.getLast();
            if(v2_2 <= v1) {
                v4 = 0;
                goto label_94;
            }
        }
        else if(FocusDirection.equals-impl0(arg14, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            v1_1 = RangesKt.until(0, v0.getSize());
            v2_2 = v1_1.getFirst();
            v1 = v1_1.getLast();
            if(v2_2 <= v1) {
                v4 = 0;
                goto label_120;
            }
        }
        else {
            throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
            while(true) {
            label_120:
                if(v4 != 0) {
                    v5_1 = v0.content[v1];
                    if((FocusTraversalKt.isEligibleForFocusSearch(((FocusTargetNode)v5_1))) && (OneDimensionalFocusSearchKt.backwardFocusSearch(((FocusTargetNode)v5_1), arg15))) {
                        return 1;
                    }
                }

                if(Intrinsics.areEqual(v0.content[v1], arg13)) {
                    v4 = 1;
                }

                if(v1 == v2_2) {
                    goto label_136;
                }

                --v1;
            }

            while(true) {
            label_94:
                if(v4 != 0) {
                    v5_1 = v0.content[v2_2];
                    if((FocusTraversalKt.isEligibleForFocusSearch(((FocusTargetNode)v5_1))) && (OneDimensionalFocusSearchKt.forwardFocusSearch(((FocusTargetNode)v5_1), arg15))) {
                        return 1;
                    }
                }

                if(Intrinsics.areEqual(v0.content[v2_2], arg13)) {
                    v4 = 1;
                }

                if(v2_2 == v1) {
                    break;
                }

                ++v2_2;
            }
        }

    label_136:
        if(!FocusDirection.equals-impl0(arg14, FocusDirection.Companion.getNext-dhqQ-8s()) && (arg12.fetchFocusProperties$ui().getCanFocus())) {
            if(OneDimensionalFocusSearchKt.isRoot(arg12)) {
            }
            else {
                return arg15.invoke(arg12).booleanValue();
            }
        }

        return 0;
        while(true) {
        label_37:
            if(v2_1 == null) {
                goto label_26;
            }

            if((((Node)v2_1).getKindSet$ui() & v4) != 0) {
                v7 = null;
                v8 = ((MutableVector)v7);
                break;
            }

            v2_3 = ((Node)v2_1).getChild$ui();
        }

        while(true) {
        label_43:
            if(v2_1 == null) {
                goto label_26;
            }

            if((v2_1 instanceof FocusTargetNode)) {
                v0.add(v2_1);
            }
            else if((((Node)v2_1).getKindSet$ui() & v4) != 0 && ((v2_1 instanceof DelegatingNode))) {
                Node v9 = v2_1.getDelegate$ui();
                int v10 = 0;
                while(v9 != null) {
                    if((v9.getKindSet$ui() & v4) != 0) {
                        ++v10;
                        if(v10 == 1) {
                            v2_3 = v9;
                        }
                        else {
                            if(v8 == null) {
                                v8 = new MutableVector(new Node[v1], 0);
                            }

                            if(v2_1 != null) {
                                if(v8 != null) {
                                    v8.add(v2_1);
                                }

                                v2_1 = v7;
                            }

                            if(v8 == null) {
                                goto label_74;
                            }

                            v8.add(v9);
                        }
                    }

                label_74:
                    v9 = v9.getChild$ui();
                }

                if(v10 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v2_3 = DelegatableNodeKt.access$pop(v8);
        goto label_43;
    label_155:
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }
}

