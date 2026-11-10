package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\u001E\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0000\u001A\f\u0010\b\u001A\u00020\u0001*\u00020\u0002H\u0002\u001A \u0010\t\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\u0001H\u0002\u001A)\u0010\n\u001A\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0002¢\u0006\u0002\b\u000F\u001A\f\u0010\u0010\u001A\u00020\u0002*\u00020\u0002H\u0002\u001A\u001B\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001B\u0010\u0015\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0014\u001A\u001B\u0010\u0017\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001A\u001B\u0010\u0019\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\fH\u0002¢\u0006\u0004\b\u001A\u0010\u0014¨\u0006\u001B"}, d2={"performRequestFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "captureFocus", "freeFocus", "clearFocus", "forced", "refreshFocusEvents", "grantFocus", "clearChildFocus", "requestOwnerFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-Etdf9zw", "requireActiveChild", "performCustomRequestFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomRequestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomClearFocus", "performCustomClearFocus-Mxy_nc0", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusTransactionsKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[FocusStateImpl.values().length];
            try {
                v0[FocusStateImpl.Active.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[FocusStateImpl.Captured.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[FocusStateImpl.ActiveParent.ordinal()] = 3;
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

    public static final boolean captureFocus(FocusTargetNode arg3) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getFocusState().ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return 0;
            }

            return 1;
        }

        DelegatableNodeKt.requireOwner(arg3).getFocusOwner().setFocusCaptured(true);
        arg3.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Captured);
        return 1;
    }

    private static final boolean clearChildFocus(FocusTargetNode arg0, boolean arg1, boolean arg2) {
        arg0 = FocusTraversalKt.getActiveChild(arg0);
        if(arg0 != null) {
            return FocusTransactionsKt.clearFocus(arg0, arg1, arg2);
        }

        return 1;
    }

    static boolean clearChildFocus$default(FocusTargetNode arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return FocusTransactionsKt.clearChildFocus(arg0, false, true);
    }

    public static final boolean clearFocus(FocusTargetNode arg4, boolean arg5, boolean arg6) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg4.getFocusState().ordinal()];
        FocusTargetNode v1 = null;
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                        return 1;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                if(FocusTransactionsKt.clearChildFocus(arg4, arg5, arg6)) {
                    if(arg6) {
                        arg4.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                    }

                    return 1;
                }

                return 0;
            }

            if((arg5) && !ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
                DelegatableNodeKt.requireOwner(arg4).getFocusOwner().setActiveFocusTargetNode(v1);
                if(arg6) {
                    arg4.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Inactive);
                }
            }

            return arg5;
        }

        if(!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) {
            DelegatableNodeKt.requireOwner(arg4).getFocusOwner().setActiveFocusTargetNode(v1);
            if(arg6) {
                arg4.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            }
        }

        return 1;
    }

    public static boolean clearFocus$default(FocusTargetNode arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return FocusTransactionsKt.clearFocus(arg0, false, arg2);
    }

    public static final boolean freeFocus(FocusTargetNode arg4) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg4.getFocusState().ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return 0;
            }
            else {
                DelegatableNodeKt.requireOwner(arg4).getFocusOwner().setFocusCaptured(false);
                arg4.dispatchFocusCallbacks$ui(FocusStateImpl.Captured, FocusStateImpl.Active);
            }
        }

        return 1;
    }

    private static final boolean grantFocus(FocusTargetNode arg3) {
        ObserverModifierNodeKt.observeReads(arg3, new FocusTransactionsKt$grantFocus$1(arg3));
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getFocusState().ordinal()];
        if(v0 != 1 && v0 != 2) {
            if(v0 != 3) {
                if(v0 == 4) {
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            DelegatableNodeKt.requireOwner(arg3).getFocusOwner().setActiveFocusTargetNode(arg3);
        }

        return 1;
    }

    public static final CustomDestinationResult performCustomClearFocus-Mxy_nc0(FocusTargetNode arg2, int arg3) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg2.getFocusState().ordinal()];
        if(v0 != 1) {
            if(v0 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            else if(v0 == 3) {
                CustomDestinationResult v0_1 = FocusTransactionsKt.performCustomClearFocus-Mxy_nc0(FocusTransactionsKt.requireActiveChild(arg2), arg3);
                if(v0_1 == CustomDestinationResult.None) {
                    v0_1 = null;
                }

                if(v0_1 == null) {
                    return FocusTransactionsKt.performCustomExit-Mxy_nc0(arg2, arg3);
                }

                return v0_1;
            }
            else if(v0 == 4) {
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        return CustomDestinationResult.None;
    }

    private static final CustomDestinationResult performCustomEnter-Mxy_nc0(FocusTargetNode arg7, int arg8) {
        CustomDestinationResult v8_4;
        FocusRequester v8_3;
        DefaultConstructorMarker v4;
        if(!arg7.isProcessingCustomEnter) {
            arg7.isProcessingCustomEnter = true;
            try {
                FocusProperties v2 = arg7.fetchFocusProperties$ui();
                v4 = null;
                CancelIndicatingFocusBoundaryScope v3 = new CancelIndicatingFocusBoundaryScope(arg8, v4);
                FocusOwner v8_1 = DelegatableNodeKt.requireOwner(arg7).getFocusOwner();
                FocusTargetNode v5 = v8_1.getActiveFocusTargetNode();
                v2.getOnEnter().invoke(v3);
                FocusTargetNode v8_2 = v8_1.getActiveFocusTargetNode();
                if(v3.isCanceled()) {
                    v8_3 = FocusRequester.Companion.getCancel();
                    if(v8_3 == FocusRequester.Companion.getCancel()) {
                        v8_4 = CustomDestinationResult.Cancelled;
                        goto label_25;
                    }
                    else {
                        goto label_27;
                    }
                }
                else {
                    goto label_40;
                }

                goto label_68;
            }
            catch(Throwable v8) {
                goto label_66;
            }

        label_25:
            arg7.isProcessingCustomEnter = false;
            return v8_4;
            try {
            label_27:
                if(v8_3 == FocusRequester.Companion.getRedirect$ui()) {
                    v8_4 = CustomDestinationResult.Redirected;
                }
                else {
                    goto label_33;
                }
            }
            catch(Throwable v8) {
                goto label_66;
            }

            arg7.isProcessingCustomEnter = false;
            return v8_4;
            try {
            label_33:
                v8_4 = FocusRequester.requestFocus-3ESFkO8$default(v8_3, 0, 1, v4) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
            }
            catch(Throwable v8) {
                goto label_66;
            }

            arg7.isProcessingCustomEnter = false;
            return v8_4;
        label_40:
            if(v5 != v8_2 && v8_2 != null) {
                try {
                    v8_3 = FocusRequester.Companion.getRedirect$ui();
                    if(v8_3 == FocusRequester.Companion.getCancel()) {
                        v8_4 = CustomDestinationResult.Cancelled;
                    }
                    else {
                        goto label_50;
                    }
                }
                catch(Throwable v8) {
                    goto label_66;
                }

                arg7.isProcessingCustomEnter = false;
                return v8_4;
                try {
                label_50:
                    if(v8_3 == FocusRequester.Companion.getRedirect$ui()) {
                        v8_4 = CustomDestinationResult.Redirected;
                    }
                    else {
                        goto label_56;
                    }
                }
                catch(Throwable v8) {
                    goto label_66;
                }

                arg7.isProcessingCustomEnter = false;
                return v8_4;
                try {
                label_56:
                    v8_4 = FocusRequester.requestFocus-3ESFkO8$default(v8_3, 0, 1, v4) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                catch(Throwable v8) {
                label_66:
                    arg7.isProcessingCustomEnter = false;
                    throw v8;
                }

                arg7.isProcessingCustomEnter = false;
                return v8_4;
            }

            arg7.isProcessingCustomEnter = false;
        }

    label_68:
        return CustomDestinationResult.None;
    }

    private static final CustomDestinationResult performCustomExit-Mxy_nc0(FocusTargetNode arg7, int arg8) {
        CustomDestinationResult v8_4;
        FocusRequester v8_3;
        DefaultConstructorMarker v4;
        if(!arg7.isProcessingCustomExit) {
            arg7.isProcessingCustomExit = true;
            try {
                FocusProperties v2 = arg7.fetchFocusProperties$ui();
                v4 = null;
                CancelIndicatingFocusBoundaryScope v3 = new CancelIndicatingFocusBoundaryScope(arg8, v4);
                FocusOwner v8_1 = DelegatableNodeKt.requireOwner(arg7).getFocusOwner();
                FocusTargetNode v5 = v8_1.getActiveFocusTargetNode();
                v2.getOnExit().invoke(v3);
                FocusTargetNode v8_2 = v8_1.getActiveFocusTargetNode();
                if(v3.isCanceled()) {
                    v8_3 = FocusRequester.Companion.getCancel();
                    if(v8_3 == FocusRequester.Companion.getCancel()) {
                        v8_4 = CustomDestinationResult.Cancelled;
                        goto label_25;
                    }
                    else {
                        goto label_27;
                    }
                }
                else {
                    goto label_40;
                }

                goto label_68;
            }
            catch(Throwable v8) {
                goto label_66;
            }

        label_25:
            arg7.isProcessingCustomExit = false;
            return v8_4;
            try {
            label_27:
                if(v8_3 == FocusRequester.Companion.getRedirect$ui()) {
                    v8_4 = CustomDestinationResult.Redirected;
                }
                else {
                    goto label_33;
                }
            }
            catch(Throwable v8) {
                goto label_66;
            }

            arg7.isProcessingCustomExit = false;
            return v8_4;
            try {
            label_33:
                v8_4 = FocusRequester.requestFocus-3ESFkO8$default(v8_3, 0, 1, v4) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
            }
            catch(Throwable v8) {
                goto label_66;
            }

            arg7.isProcessingCustomExit = false;
            return v8_4;
        label_40:
            if(v5 != v8_2 && v8_2 != null) {
                try {
                    v8_3 = FocusRequester.Companion.getRedirect$ui();
                    if(v8_3 == FocusRequester.Companion.getCancel()) {
                        v8_4 = CustomDestinationResult.Cancelled;
                    }
                    else {
                        goto label_50;
                    }
                }
                catch(Throwable v8) {
                    goto label_66;
                }

                arg7.isProcessingCustomExit = false;
                return v8_4;
                try {
                label_50:
                    if(v8_3 == FocusRequester.Companion.getRedirect$ui()) {
                        v8_4 = CustomDestinationResult.Redirected;
                    }
                    else {
                        goto label_56;
                    }
                }
                catch(Throwable v8) {
                    goto label_66;
                }

                arg7.isProcessingCustomExit = false;
                return v8_4;
                try {
                label_56:
                    v8_4 = FocusRequester.requestFocus-3ESFkO8$default(v8_3, 0, 1, v4) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                catch(Throwable v8) {
                label_66:
                    arg7.isProcessingCustomExit = false;
                    throw v8;
                }

                arg7.isProcessingCustomExit = false;
                return v8_4;
            }

            arg7.isProcessingCustomExit = false;
        }

    label_68:
        return CustomDestinationResult.None;
    }

    public static final CustomDestinationResult performCustomRequestFocus-Mxy_nc0(FocusTargetNode arg13, int arg14) {
        Node v7;
        Node v6;
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg13.getFocusState().ordinal()];
        if(v0 != 1) {
            int v2 = 2;
            if(v0 != v2) {
                int v3 = 3;
                if(v0 != v3) {
                    int v4 = 4;
                    if(v0 == v4) {
                        v0 = NodeKind.constructor-impl(0x400);
                        if(!((DelegatableNode)arg13).getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }

                        Node v5 = ((DelegatableNode)arg13).getNode().getParent$ui();
                        LayoutNode v13 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg13));
                        while(true) {
                            v6 = null;
                            if(v13 == null) {
                                break;
                            }

                            if((v13.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                                while(v5 != null) {
                                    if((v5.getKindSet$ui() & v0) != 0) {
                                        v7 = v5;
                                        MutableVector v8 = ((MutableVector)v6);
                                        while(true) {
                                        label_35:
                                            if(v7 != null) {
                                                if((v7 instanceof FocusTargetNode)) {
                                                    goto label_84;
                                                }
                                                else {
                                                    if((v7.getKindSet$ui() & v0) != 0 && ((v7 instanceof DelegatingNode))) {
                                                        Node v9 = v7.getDelegate$ui();
                                                        int v11 = 0;
                                                        while(v9 != null) {
                                                            if((v9.getKindSet$ui() & v0) != 0) {
                                                                ++v11;
                                                                if(v11 == 1) {
                                                                    v7 = v9;
                                                                }
                                                                else {
                                                                    if(v8 == null) {
                                                                        v8 = new MutableVector(new Node[16], 0);
                                                                    }

                                                                    if(v7 != null) {
                                                                        if(v8 != null) {
                                                                            v8.add(v7);
                                                                        }

                                                                        v7 = v6;
                                                                    }

                                                                    if(v8 == null) {
                                                                        goto label_67;
                                                                    }

                                                                    v8.add(v9);
                                                                }
                                                            }

                                                        label_67:
                                                            v9 = v9.getChild$ui();
                                                        }

                                                        if(v11 != 1) {
                                                            break;
                                                        }

                                                        continue;
                                                    }

                                                    break;
                                                }
                                            }

                                            goto label_73;
                                        }

                                        v7 = DelegatableNodeKt.access$pop(v8);
                                        goto label_35;
                                    }

                                label_73:
                                    v5 = v5.getParent$ui();
                                }
                            }

                            v13 = v13.getParent$ui();
                            if(v13 != null) {
                                NodeChain v5_1 = v13.getNodes$ui();
                                if(v5_1 != null) {
                                    v5 = v5_1.getTail$ui();
                                    continue;
                                }
                            }

                            v5 = v6;
                        }

                        v7 = v6;
                    label_84:
                        if(v7 == null) {
                            return CustomDestinationResult.None;
                        }

                        int v13_1 = WhenMappings.$EnumSwitchMapping$0[((FocusTargetNode)v7).getFocusState().ordinal()];
                        if(v13_1 != 1) {
                            if(v13_1 != v2) {
                                if(v13_1 != v3) {
                                    if(v13_1 == v4) {
                                        CustomDestinationResult v13_2 = FocusTransactionsKt.performCustomRequestFocus-Mxy_nc0(((FocusTargetNode)v7), arg14);
                                        if(v13_2 == CustomDestinationResult.None) {
                                        }
                                        else {
                                            CustomDestinationResult v6_1 = v13_2;
                                        }

                                        if((((CustomDestinationResult)v6)) == null) {
                                            return FocusTransactionsKt.performCustomEnter-Mxy_nc0(((FocusTargetNode)v7), arg14);
                                        }

                                        return ((CustomDestinationResult)v6);
                                    }

                                    throw new NoWhenBranchMatchedException();
                                }

                                return FocusTransactionsKt.performCustomRequestFocus-Mxy_nc0(((FocusTargetNode)v7), arg14);
                            }

                            return CustomDestinationResult.Cancelled;
                        }

                        return FocusTransactionsKt.performCustomEnter-Mxy_nc0(((FocusTargetNode)v7), arg14);
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                else {
                    return FocusTransactionsKt.performCustomClearFocus-Mxy_nc0(FocusTransactionsKt.requireActiveChild(arg13), arg14);
                }
            }
        }

        return CustomDestinationResult.None;
    }

    public static final boolean performRequestFocus(FocusTargetNode arg20) {
        MutableVector v9_2;
        MutableVector v5_1;
        FocusTargetNode v19;
        int v9_1;
        int v17;
        Node v14;
        MutableVector v11;
        FocusTargetNode v0 = arg20;
        FocusTargetNode v1 = v0;
        FocusOwner v2 = DelegatableNodeKt.requireOwner(((DelegatableNode)v1)).getFocusOwner();
        FocusTargetNode v3 = v2.getActiveFocusTargetNode();
        FocusStateImpl v4 = v0.getFocusState();
        int v5 = 1;
        if(v3 == v0) {
            v0.dispatchFocusCallbacks$ui(((FocusState)v4), ((FocusState)v4));
            return 1;
        }

        int v7 = 3;
        int v8 = 0;
        FocusDirection v9 = null;
        if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if(v3 != null && !v3.isInteropViewHost()) {
                goto label_28;
            }

            if(v0.isInteropViewHost()) {
                goto label_28;
            }

            if(FocusTransactionsKt.requestOwnerFocus-Etdf9zw$default(v0, v9, ((Rect)v9), v7, v9)) {
                goto label_28;
            }

            return 0;
        }
        else {
            if(v3 != null) {
                goto label_28;
            }

            if(FocusTransactionsKt.requestOwnerFocus-Etdf9zw$default(v0, v9, ((Rect)v9), v7, v9)) {
                goto label_28;
            }

            return 0;
        }

    label_28:
        String v6 = "visitAncestors called on an unattached node";
        v7 = 0x400;
        int v10 = 16;
        if(v3 != null) {
            v11 = new MutableVector(new FocusTargetNode[v10], 0);
            FocusTargetNode v12 = v3;
            int v13 = NodeKind.constructor-impl(v7);
            if(!((DelegatableNode)v12).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v6);
            }

            v14 = ((DelegatableNode)v12).getNode().getParent$ui();
            LayoutNode v12_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v12));
            while(v12_1 != null) {
                if((v12_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v13) != 0) {
                    while(v14 != null) {
                        if((v14.getKindSet$ui() & v13) != 0) {
                            MutableVector v16 = ((MutableVector)v9);
                            Node v15 = v14;
                            while(true) {
                            label_56:
                                if(v15 != null) {
                                    v17 = v7;
                                    if((v15 instanceof FocusTargetNode)) {
                                        v11.add(v15);
                                        break;
                                    }
                                    else if((v15.getKindSet$ui() & v13) == 0) {
                                        break;
                                    }
                                    else if((v15 instanceof DelegatingNode)) {
                                        Node v7_1 = v15.getDelegate$ui();
                                        v9_1 = 0;
                                        while(v7_1 != null) {
                                            if((v7_1.getKindSet$ui() & v13) != 0) {
                                                ++v9_1;
                                                if(v9_1 == v5) {
                                                    v19 = v1;
                                                    v15 = v7_1;
                                                }
                                                else {
                                                    if(v16 == null) {
                                                        v19 = v1;
                                                        v5_1 = new MutableVector(new Node[v10], 0);
                                                    }
                                                    else {
                                                        v19 = v1;
                                                        v5_1 = v16;
                                                    }

                                                    if(v15 != null) {
                                                        if(v5_1 != null) {
                                                            v5_1.add(v15);
                                                        }

                                                        v15 = null;
                                                    }

                                                    if(v5_1 != null) {
                                                        v5_1.add(v7_1);
                                                    }

                                                    v16 = v5_1;
                                                }
                                            }
                                            else {
                                                v19 = v1;
                                            }

                                            v7_1 = v7_1.getChild$ui();
                                            v1 = v19;
                                            v5 = 1;
                                        }

                                        v19 = v1;
                                        int v1_1 = v5;
                                        if(v9_1 != v1_1) {
                                            goto label_108;
                                        }

                                        v5 = v1_1;
                                        v7 = v17;
                                        v1 = v19;
                                        continue;
                                    }
                                    else {
                                        break;
                                    }
                                }

                                goto label_114;
                            }

                            v19 = v1;
                        label_108:
                            v15 = DelegatableNodeKt.access$pop(v16);
                            v7 = v17;
                            v1 = v19;
                            v5 = 1;
                            goto label_56;
                        }

                    label_114:
                        v14 = v14.getParent$ui();
                        v7 = v7;
                        v1 = v1;
                        v5 = 1;
                        v9_2 = null;
                    }
                }

                v19 = v1;
                v17 = v7;
                v12_1 = v12_1.getParent$ui();
                if(v12_1 != null) {
                    NodeChain v1_2 = v12_1.getNodes$ui();
                    if(v1_2 != null) {
                        v14 = v1_2.getTail$ui();
                    }
                    else {
                        goto label_131;
                    }
                }
                else {
                label_131:
                    v14 = null;
                }

                v7 = v17;
                v1 = v19;
                v5 = 1;
                v9_2 = null;
            }
        }
        else {
            v11 = null;
        }

        v19 = v1;
        MutableVector v1_3 = new MutableVector(new FocusTargetNode[v10], 0);
        v5 = NodeKind.constructor-impl(v7);
        if(!((DelegatableNode)v19).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(v6);
        }

        Node v6_1 = ((DelegatableNode)v19).getNode().getParent$ui();
        LayoutNode v7_2 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v19));
        v9_1 = 1;
        while(v7_2 != null) {
            if((v7_2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v5) != 0) {
                while(v6_1 != null) {
                    if((v6_1.getKindSet$ui() & v5) != 0) {
                        Node v13_1 = v6_1;
                        MutableVector v12_2 = null;
                        while(v13_1 != null) {
                            if((v13_1 instanceof FocusTargetNode)) {
                                Boolean v14_1 = v11 != null ? Boolean.valueOf(v11.remove(v13_1)) : null;
                                if(v14_1 == null || !v14_1.booleanValue()) {
                                    v1_3.add(v13_1);
                                }

                                if((((FocusTargetNode)v13_1)) != v3) {
                                    goto label_214;
                                }

                                v9_1 = v8;
                                goto label_214;
                            }
                            else {
                                if((v13_1.getKindSet$ui() & v5) != 0 && ((v13_1 instanceof DelegatingNode))) {
                                    v14 = v13_1.getDelegate$ui();
                                    int v15_1 = v8;
                                    while(v14 != null) {
                                        if((v14.getKindSet$ui() & v5) != 0) {
                                            ++v15_1;
                                            if(v15_1 == 1) {
                                                v13_1 = v14;
                                            }
                                            else {
                                                if(v12_2 == null) {
                                                    v12_2 = new MutableVector(new Node[v10], 0);
                                                }

                                                if(v13_1 != null) {
                                                    if(v12_2 != null) {
                                                        v12_2.add(v13_1);
                                                    }

                                                    v13_1 = null;
                                                }

                                                if(v12_2 == null) {
                                                    goto label_207;
                                                }

                                                v12_2.add(v14);
                                            }
                                        }

                                    label_207:
                                        v14 = v14.getChild$ui();
                                        v10 = 16;
                                    }

                                    if(v15_1 != 1) {
                                        goto label_214;
                                    }

                                    goto label_215;
                                }

                            label_214:
                                v13_1 = DelegatableNodeKt.access$pop(v12_2);
                            }

                        label_215:
                            v8 = 0;
                            v10 = 16;
                        }
                    }

                    v6_1 = v6_1.getParent$ui();
                    v8 = 0;
                    v10 = 16;
                }
            }

            v7_2 = v7_2.getParent$ui();
            if(v7_2 != null) {
                NodeChain v6_2 = v7_2.getNodes$ui();
                if(v6_2 != null) {
                    v6_1 = v6_2.getTail$ui();
                }
                else {
                    goto label_228;
                }
            }
            else {
            label_228:
                v6_1 = null;
            }

            v8 = 0;
            v10 = 16;
        }

        if(v9_1 != 0 && v3 != null && !FocusTransactionsKt.clearFocus$default(v3, false, true, 1, null)) {
            return 0;
        }

        FocusTransactionsKt.grantFocus(v0);
        if((ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) && v9_1 != 0 && v3 != null) {
            v3.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
        }

        if(v11 != null) {
            v5 = v11.getSize() - 1;
            Object[] v6_3 = v11.content;
            if(v5 >= v6_3.length) {
                goto label_266;
            }

            while(v5 >= 0) {
                Object v7_3 = v6_3[v5];
                if(v2.getActiveFocusTargetNode() != v0) {
                    return 0;
                }

                ((FocusTargetNode)v7_3).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                --v5;
            }
        }

    label_266:
        v5 = v1_3.getSize() - 1;
        Object[] v1_4 = v1_3.content;
        if(v5 < v1_4.length) {
            while(v5 >= 0) {
                Object v6_4 = v1_4[v5];
                if(v2.getActiveFocusTargetNode() != v0) {
                    return 0;
                }
                else {
                    FocusStateImpl v7_4 = (((FocusTargetNode)v6_4)) == v3 ? FocusStateImpl.Active : FocusStateImpl.Inactive;
                    ((FocusTargetNode)v6_4).dispatchFocusCallbacks$ui(((FocusState)v7_4), FocusStateImpl.ActiveParent);
                    --v5;
                    continue;
                }

                break;
            }
        }

        if(v2.getActiveFocusTargetNode() != v0) {
            return 0;
        }

        v0.dispatchFocusCallbacks$ui(((FocusState)v4), FocusStateImpl.Active);
        if(v2.getActiveFocusTargetNode() != v0) {
            return 0;
        }

        if((ComposeUiFlags.isViewFocusFixEnabled) && DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v19)).getInteropView() == null) {
            FocusTransactionsKt.requestOwnerFocus-Etdf9zw(v0, FocusDirection.box-impl(FocusDirection.Companion.getNext-dhqQ-8s()), null);
        }

        return 1;
    }

    private static final boolean requestOwnerFocus-Etdf9zw(FocusTargetNode arg0, FocusDirection arg1, Rect arg2) {
        return DelegatableNodeKt.requireOwner(((DelegatableNode)arg0)).getFocusOwner().requestOwnerFocus-7o62pno(arg1, arg2);
    }

    static boolean requestOwnerFocus-Etdf9zw$default(FocusTargetNode arg1, FocusDirection arg2, Rect arg3, int arg4, Object arg5) {
        FocusDirection v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((Rect)v0);
        }

        return FocusTransactionsKt.requestOwnerFocus-Etdf9zw(arg1, arg2, arg3);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode arg1) {
        arg1 = FocusTraversalKt.getActiveChild(arg1);
        if(arg1 != null) {
            return arg1;
        }

        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }
}

