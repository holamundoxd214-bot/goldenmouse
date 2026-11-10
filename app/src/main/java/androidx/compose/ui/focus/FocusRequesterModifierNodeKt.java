package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.PinnableContainer$PinnedHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0004\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0005\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0006\u001A\u00020\u0001*\u00020\u0002\u001A\u000E\u0010\u0007\u001A\u0004\u0018\u00010\b*\u00020\u0002H\u0000¨\u0006\t"}, d2={"requestFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "captureFocus", "freeFocus", "saveFocusedChild", "restoreFocusedChild", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusRequesterModifierNodeKt {
    public static final boolean captureFocus(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_46;
            }

            if((v1 instanceof FocusTargetNode)) {
                if(FocusTransactionsKt.captureFocus(((FocusTargetNode)v1))) {
                    return 1;
                }
            }
            else if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_40;
                            }

                            v3.add(v7);
                        }
                    }

                label_40:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_46:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_1 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_1.add(v3_1);
        }

    label_61:
        while(v1_1.getSize() != 0) {
            v10 = v1_1.removeAt(v1_1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((Node)v10), false);
                continue;
            }

            goto label_71;
        }

        return 0;
        while(true) {
        label_71:
            if(v10 == null) {
                goto label_61;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_76:
            if(v10_1 == null) {
                goto label_61;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                if(FocusTransactionsKt.captureFocus(((FocusTargetNode)v10_1))) {
                    return 1;
                }
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
                v7 = v10_1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10_1 != null) {
                                if(v3 != null) {
                                    v3.add(v10_1);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_108;
                            }

                            v3.add(v7);
                        }
                    }

                label_108:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_76;
    }

    public static final boolean freeFocus(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_46;
            }

            if((v1 instanceof FocusTargetNode)) {
                if(FocusTransactionsKt.freeFocus(((FocusTargetNode)v1))) {
                    return 1;
                }
            }
            else if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_40;
                            }

                            v3.add(v7);
                        }
                    }

                label_40:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_46:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_1 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_1.add(v3_1);
        }

    label_61:
        while(v1_1.getSize() != 0) {
            v10 = v1_1.removeAt(v1_1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((Node)v10), false);
                continue;
            }

            goto label_71;
        }

        return 0;
        while(true) {
        label_71:
            if(v10 == null) {
                goto label_61;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_76:
            if(v10_1 == null) {
                goto label_61;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                if(FocusTransactionsKt.freeFocus(((FocusTargetNode)v10_1))) {
                    return 1;
                }
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
                v7 = v10_1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10_1 != null) {
                                if(v3 != null) {
                                    v3.add(v10_1);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_108;
                            }

                            v3.add(v7);
                        }
                    }

                label_108:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_76;
    }

    public static final PinnedHandle pinFocusedChild(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_46;
            }

            if((v1 instanceof FocusTargetNode)) {
                PinnedHandle v1_1 = FocusRestorerKt.pinFocusedChild(((FocusTargetNode)v1));
                if(v1_1 != null) {
                    return v1_1;
                }
            }
            else if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_40;
                            }

                            v3.add(v7);
                        }
                    }

                label_40:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_46:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_2 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_2, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_2.add(v3_1);
        }

    label_61:
        while(v1_2.getSize() != 0) {
            v10 = v1_2.removeAt(v1_2.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_2, ((Node)v10), false);
                continue;
            }

            goto label_71;
        }

        return ((PinnedHandle)v2);
        while(true) {
        label_71:
            if(v10 == null) {
                goto label_61;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_76:
            if(v10_1 == null) {
                goto label_61;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                PinnedHandle v10_2 = FocusRestorerKt.pinFocusedChild(((FocusTargetNode)v10_1));
                if(v10_2 != null) {
                    return v10_2;
                }
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
                v7 = v10_1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10_1 != null) {
                                if(v3 != null) {
                                    v3.add(v10_1);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_108;
                            }

                            v3.add(v7);
                        }
                    }

                label_108:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_76;
    }

    public static final boolean requestFocus(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Object v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_57;
            }

            if((v1 instanceof FocusTargetNode)) {
                if(ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                    return FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v1), 0, 1, v2);
                }

                if(((FocusTargetNode)v1).fetchFocusProperties$ui().getCanFocus()) {
                    return FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v1), 0, 1, v2);
                }

                return TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(((FocusTargetNode)v1), FocusDirection.Companion.getEnter-dhqQ-8s(), FocusRequesterModifierNodeKt$requestFocus$1$1.INSTANCE);
            }

            if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = ((Node)v2);
                            }

                            if(v3 == null) {
                                goto label_51;
                            }

                            v3.add(v7);
                        }
                    }

                label_51:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_57:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_1 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_1.add(v3_1);
        }

    label_72:
        while(v1_1.getSize() != 0) {
            v10 = v1_1.removeAt(v1_1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((Node)v10), false);
                continue;
            }

            goto label_82;
        }

        return 0;
        while(true) {
        label_82:
            if(v10 == null) {
                goto label_72;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = ((Node)v10).getChild$ui();
        }

        while(true) {
        label_87:
            if(v10 == null) {
                goto label_72;
            }

            if((v10 instanceof FocusTargetNode)) {
                if(ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                    return FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v10), 0, 1, v2);
                }

                if(((FocusTargetNode)v10).fetchFocusProperties$ui().getCanFocus()) {
                    return FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v10), 0, 1, v2);
                }

                return TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(((FocusTargetNode)v10), FocusDirection.Companion.getEnter-dhqQ-8s(), FocusRequesterModifierNodeKt$requestFocus$1$1.INSTANCE);
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0 && ((v10 instanceof DelegatingNode))) {
                v7 = v10.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10 != null) {
                                if(v3 != null) {
                                    v3.add(v10);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_130;
                            }

                            v3.add(v7);
                        }
                    }

                label_130:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_87;
    }

    public static final boolean restoreFocusedChild(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_46;
            }

            if((v1 instanceof FocusTargetNode)) {
                if(FocusRestorerKt.restoreFocusedChild(((FocusTargetNode)v1))) {
                    return 1;
                }
            }
            else if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_40;
                            }

                            v3.add(v7);
                        }
                    }

                label_40:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_46:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_1 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_1.add(v3_1);
        }

    label_61:
        while(v1_1.getSize() != 0) {
            v10 = v1_1.removeAt(v1_1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((Node)v10), false);
                continue;
            }

            goto label_71;
        }

        return 0;
        while(true) {
        label_71:
            if(v10 == null) {
                goto label_61;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_76:
            if(v10_1 == null) {
                goto label_61;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                if(FocusRestorerKt.restoreFocusedChild(((FocusTargetNode)v10_1))) {
                    return 1;
                }
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
                v7 = v10_1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10_1 != null) {
                                if(v3 != null) {
                                    v3.add(v10_1);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_108;
                            }

                            v3.add(v7);
                        }
                    }

                label_108:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_76;
    }

    public static final boolean saveFocusedChild(FocusRequesterModifierNode arg10) {
        Node v10_1;
        Object v10;
        int v8;
        Node v7;
        int v4;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg10).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            v4 = 16;
            if(v1 == null) {
                goto label_46;
            }

            if((v1 instanceof FocusTargetNode)) {
                if(FocusRestorerKt.saveFocusedChild(((FocusTargetNode)v1))) {
                    return 1;
                }
            }
            else if((v1.getKindSet$ui() & v0) != 0 && ((v1 instanceof DelegatingNode))) {
                v7 = v1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_40;
                            }

                            v3.add(v7);
                        }
                    }

                label_40:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_46:
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_1 = new MutableVector(new Node[v4], 0);
        Node v3_1 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((DelegatableNode)arg10).getNode(), false);
        }
        else {
            v1_1.add(v3_1);
        }

    label_61:
        while(v1_1.getSize() != 0) {
            v10 = v1_1.removeAt(v1_1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_1, ((Node)v10), false);
                continue;
            }

            goto label_71;
        }

        return 0;
        while(true) {
        label_71:
            if(v10 == null) {
                goto label_61;
            }

            if((((Node)v10).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_76:
            if(v10_1 == null) {
                goto label_61;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                if(FocusRestorerKt.saveFocusedChild(((FocusTargetNode)v10_1))) {
                    return 1;
                }
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
                v7 = v10_1.getDelegate$ui();
                v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v4], 0);
                            }

                            if(v10_1 != null) {
                                if(v3 != null) {
                                    v3.add(v10_1);
                                }

                                v10 = v2;
                            }

                            if(v3 == null) {
                                goto label_108;
                            }

                            v3.add(v7);
                        }
                    }

                label_108:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.access$pop(v3);
        goto label_76;
    }
}

