package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u0016\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u001A\u001B\u0010\u0000\u001A\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u0005¢\u0006\u0002\u0010\u0006\u001A(\u0010\u0007\u001A\u00020\b*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000B0\n\u001A-\u0010\u0007\u001A\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\u0010\f\u001A(\u0010\r\u001A\u00020\b*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000B0\n\u001A-\u0010\r\u001A\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\u0010\f\u001A(\u0010\u000E\u001A\u00020\b*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000F0\n\u001A-\u0010\u000E\u001A\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000F0\n¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2={"findNearestAncestor", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", "T", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TraversableNodeKt {
    public static final TraversableNode findNearestAncestor(DelegatableNode arg10, Object arg11) {
        Node v2;
        int v0 = NodeKind.constructor-impl(0x40000);
        if(!arg10.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = arg10.getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(arg10);
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
                                if((v3 instanceof TraversableNode)) {
                                    if(Intrinsics.areEqual(arg11, ((TraversableNode)v3).getTraverseKey())) {
                                        return ((TraversableNode)v3);
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

                        v3 = DelegatableNodeKt.pop(v4);
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

        return ((TraversableNode)v2);
    }

    public static final TraversableNode findNearestAncestor(TraversableNode arg11) {
        Node v3;
        TraversableNode v0 = arg11;
        int v1 = NodeKind.constructor-impl(0x40000);
        if(!((DelegatableNode)v0).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v2 = ((DelegatableNode)v0).getNode().getParent$ui();
        LayoutNode v0_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0));
        while(true) {
            v3 = null;
            if(v0_1 == null) {
                break;
            }

            if((v0_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v1) != 0) {
                while(v2 != null) {
                    if((v2.getKindSet$ui() & v1) != 0) {
                        Node v4 = v2;
                        MutableVector v5 = ((MutableVector)v3);
                        while(true) {
                        label_24:
                            if(v4 != null) {
                                if((v4 instanceof TraversableNode)) {
                                    if((Intrinsics.areEqual(arg11.getTraverseKey(), ((TraversableNode)v4).getTraverseKey())) && (Actual_jvmKt.areObjectsOfSameType(arg11, v4))) {
                                        return ((TraversableNode)v4);
                                    }
                                }
                                else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                    Node v6 = v4.getDelegate$ui();
                                    int v8 = 0;
                                    while(v6 != null) {
                                        if((v6.getKindSet$ui() & v1) != 0) {
                                            ++v8;
                                            if(v8 == 1) {
                                                v4 = v6;
                                            }
                                            else {
                                                if(v5 == null) {
                                                    v5 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v4 != null) {
                                                    if(v5 != null) {
                                                        v5.add(v4);
                                                    }

                                                    v4 = v3;
                                                }

                                                if(v5 == null) {
                                                    goto label_63;
                                                }

                                                v5.add(v6);
                                            }
                                        }

                                    label_63:
                                        v6 = v6.getChild$ui();
                                    }

                                    if(v8 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_69;
                        }

                        v4 = DelegatableNodeKt.pop(v5);
                        goto label_24;
                    }

                label_69:
                    v2 = v2.getParent$ui();
                }
            }

            v0_1 = v0_1.getParent$ui();
            if(v0_1 != null) {
                NodeChain v2_1 = v0_1.getNodes$ui();
                if(v2_1 != null) {
                    v2 = v2_1.getTail$ui();
                    continue;
                }
            }

            v2 = v3;
        }

        return ((TraversableNode)v3);
    }

    public static final void traverseAncestors(DelegatableNode arg10, Object arg11, Function1 arg12) {
        int v0 = NodeKind.constructor-impl(0x40000);
        if(!arg10.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = arg10.getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(arg10);
        while(v10 != null) {
            Node v3 = null;
            if((v10.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                while(v1 != null) {
                    if((v1.getKindSet$ui() & v0) != 0) {
                        Node v2 = v1;
                        MutableVector v4 = ((MutableVector)v3);
                        while(true) {
                        label_23:
                            if(v2 != null) {
                                boolean v6 = true;
                                if((v2 instanceof TraversableNode)) {
                                    if(Intrinsics.areEqual(arg11, ((TraversableNode)v2).getTraverseKey())) {
                                        v6 = arg12.invoke(v2).booleanValue();
                                    }

                                    if(v6) {
                                        break;
                                    }

                                    return;
                                }
                                else {
                                    if((v2.getKindSet$ui() & v0) == 0) {
                                        break;
                                    }

                                    if(!(v2 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v5 = v2.getDelegate$ui();
                                    int v8 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & v0) != 0) {
                                            ++v8;
                                            if(v8 == 1) {
                                                v2 = v5;
                                            }
                                            else {
                                                if(v4 == null) {
                                                    v4 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v4 != null) {
                                                        v4.add(v2);
                                                    }

                                                    v2 = v3;
                                                }

                                                if(v4 == null) {
                                                    goto label_62;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_62:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v8 != 1) {
                                        break;
                                    }

                                    continue;
                                }
                            }

                            goto label_68;
                        }

                        v2 = DelegatableNodeKt.pop(v4);
                        goto label_23;
                    }

                label_68:
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

            v1 = v3;
        }
    }

    public static final void traverseAncestors(TraversableNode arg11, Function1 arg12) {
        TraversableNode v0 = arg11;
        int v1 = NodeKind.constructor-impl(0x40000);
        if(!((DelegatableNode)v0).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v2 = ((DelegatableNode)v0).getNode().getParent$ui();
        LayoutNode v0_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0));
        while(v0_1 != null) {
            Node v4 = null;
            if((v0_1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v1) != 0) {
                while(v2 != null) {
                    if((v2.getKindSet$ui() & v1) != 0) {
                        Node v3 = v2;
                        MutableVector v5 = ((MutableVector)v4);
                        while(true) {
                        label_24:
                            if(v3 != null) {
                                boolean v7 = true;
                                if((v3 instanceof TraversableNode)) {
                                    if((Intrinsics.areEqual(arg11.getTraverseKey(), ((TraversableNode)v3).getTraverseKey())) && (Actual_jvmKt.areObjectsOfSameType(arg11, v3))) {
                                        v7 = arg12.invoke(v3).booleanValue();
                                    }

                                    if(v7) {
                                        break;
                                    }

                                    return;
                                }
                                else {
                                    if((v3.getKindSet$ui() & v1) == 0) {
                                        break;
                                    }

                                    if(!(v3 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v6 = v3.getDelegate$ui();
                                    int v9 = 0;
                                    while(v6 != null) {
                                        if((v6.getKindSet$ui() & v1) != 0) {
                                            ++v9;
                                            if(v9 == 1) {
                                                v3 = v6;
                                            }
                                            else {
                                                if(v5 == null) {
                                                    v5 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v3 != null) {
                                                    if(v5 != null) {
                                                        v5.add(v3);
                                                    }

                                                    v3 = v4;
                                                }

                                                if(v5 == null) {
                                                    goto label_66;
                                                }

                                                v5.add(v6);
                                            }
                                        }

                                    label_66:
                                        v6 = v6.getChild$ui();
                                    }

                                    if(v9 != 1) {
                                        break;
                                    }

                                    continue;
                                }
                            }

                            goto label_72;
                        }

                        v3 = DelegatableNodeKt.pop(v5);
                        goto label_24;
                    }

                label_72:
                    v2 = v2.getParent$ui();
                }
            }

            v0_1 = v0_1.getParent$ui();
            if(v0_1 != null) {
                NodeChain v2_1 = v0_1.getNodes$ui();
                if(v2_1 != null) {
                    v2 = v2_1.getTail$ui();
                    continue;
                }
            }

            v2 = v4;
        }
    }

    public static final void traverseChildren(DelegatableNode arg10, Object arg11, Function1 arg12) {
        Node v10_1;
        MutableVector v6;
        Object v5;
        Object v10;
        int v0 = NodeKind.constructor-impl(0x40000);
        if(!arg10.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v2 = 16;
        MutableVector v1 = new MutableVector(new Node[v2], 0);
        Node v3 = arg10.getNode().getChild$ui();
        if(v3 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v1, arg10.getNode(), false);
        }
        else {
            v1.add(v3);
        }

    label_19:
        while(v1.getSize() != 0) {
            v10 = v1.removeAt(v1.getSize() - 1);
            if((((Node)v10).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v1, ((Node)v10), false);
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

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_36:
            if(v10_1 == null) {
                goto label_19;
            }

            if((v10_1 instanceof TraversableNode)) {
                boolean v10_2 = Intrinsics.areEqual(arg11, ((TraversableNode)v10_1).getTraverseKey()) ? arg12.invoke(v10_1).booleanValue() : true;
                if(v10_2) {
                    break;
                }

                return;
            }
            else {
                if((v10_1.getKindSet$ui() & v0) == 0) {
                    break;
                }

                if(!(v10_1 instanceof DelegatingNode)) {
                    break;
                }

                Node v7 = v10_1.getDelegate$ui();
                int v8 = 0;
                while(v7 != null) {
                    if((v7.getKindSet$ui() & v0) != 0) {
                        ++v8;
                        if(v8 == 1) {
                            v10_1 = v7;
                        }
                        else {
                            if(v6 == null) {
                                v6 = new MutableVector(new Node[v2], 0);
                            }

                            if(v10_1 != null) {
                                if(v6 != null) {
                                    v6.add(v10_1);
                                }

                                v10 = v5;
                            }

                            if(v6 == null) {
                                goto label_74;
                            }

                            v6.add(v7);
                        }
                    }

                label_74:
                    v7 = v7.getChild$ui();
                }

                if(v8 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v10_1 = DelegatableNodeKt.pop(v6);
        goto label_36;
    }

    public static final void traverseChildren(TraversableNode arg11, Function1 arg12) {
        Node v0_2;
        MutableVector v7;
        Object v6;
        Object v0_1;
        TraversableNode v0 = arg11;
        int v1 = NodeKind.constructor-impl(0x40000);
        if(!((DelegatableNode)v0).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v3 = 16;
        MutableVector v2 = new MutableVector(new Node[v3], 0);
        Node v4 = ((DelegatableNode)v0).getNode().getChild$ui();
        if(v4 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v2, ((DelegatableNode)v0).getNode(), false);
        }
        else {
            v2.add(v4);
        }

    label_20:
        while(v2.getSize() != 0) {
            v0_1 = v2.removeAt(v2.getSize() - 1);
            if((((Node)v0_1).getAggregateChildKindSet$ui() & v1) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v2, ((Node)v0_1), false);
                continue;
            }

            goto label_31;
        }

        return;
        while(true) {
        label_31:
            if(v0_1 == null) {
                goto label_20;
            }

            if((((Node)v0_1).getKindSet$ui() & v1) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                break;
            }

            v0_2 = ((Node)v0_1).getChild$ui();
        }

        while(true) {
        label_37:
            if(v0_1 == null) {
                goto label_20;
            }

            if((v0_1 instanceof TraversableNode)) {
                boolean v0_3 = !Intrinsics.areEqual(arg11.getTraverseKey(), ((TraversableNode)v0_1).getTraverseKey()) || !Actual_jvmKt.areObjectsOfSameType(arg11, v0_1) ? true : arg12.invoke(v0_1).booleanValue();
                if(v0_3) {
                    break;
                }

                return;
            }
            else {
                if((((Node)v0_1).getKindSet$ui() & v1) == 0) {
                    break;
                }

                if(!(v0_1 instanceof DelegatingNode)) {
                    break;
                }

                Node v8 = v0_1.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v1) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v0_2 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v3], 0);
                            }

                            if(v0_1 != null) {
                                if(v7 != null) {
                                    v7.add(v0_1);
                                }

                                v0_1 = v6;
                            }

                            if(v7 == null) {
                                goto label_78;
                            }

                            v7.add(v8);
                        }
                    }

                label_78:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v0_2 = DelegatableNodeKt.pop(v7);
        goto label_37;
    }

    public static final void traverseDescendants(DelegatableNode arg12, Object arg13, Function1 arg14) {
        Node v7_2;
        MutableVector v8;
        Object v7;
        Object v6;
        Object v12;
        int v0 = NodeKind.constructor-impl(0x40000);
        if(!arg12.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v2 = 16;
        MutableVector v1 = new MutableVector(new Node[v2], 0);
        Node v3 = arg12.getNode().getChild$ui();
        if(v3 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v1, arg12.getNode(), false);
        }
        else {
            v1.add(v3);
        }

        do {
        label_19:
            if(v1.getSize() == 0) {
                return;
            }

            v12 = v1.removeAt(v1.getSize() - 1);
            if((((Node)v12).getAggregateChildKindSet$ui() & v0) != 0) {
                Object v5 = v12;
                while(true) {
                label_29:
                    if(v5 != null && (((Node)v5).isAttached())) {
                        if((((Node)v5).getKindSet$ui() & v0) != 0) {
                            v6 = null;
                            v7 = v5;
                            v8 = ((MutableVector)v6);
                            while(true) {
                            label_38:
                                if(v7 != null) {
                                    if((v7 instanceof TraversableNode)) {
                                        if(Intrinsics.areEqual(arg13, ((TraversableNode)v7).getTraverseKey())) {
                                            v7 = arg14.invoke(v7);
                                        }
                                        else {
                                            TraverseDescendantsAction v7_1 = TraverseDescendantsAction.ContinueTraversal;
                                        }

                                        if(v7_1 == TraverseDescendantsAction.CancelTraversal) {
                                            return;
                                        }

                                        if(v7_1 == TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            goto label_19;
                                        }

                                        goto label_52;
                                    }
                                    else {
                                        goto label_53;
                                    }
                                }

                                goto label_85;
                            }
                        }

                        goto label_85;
                    }

                    goto label_87;
                }
            }

            goto label_87;
        }
        while(true);

    label_52:
        goto label_83;
    label_53:
        if((((Node)v7).getKindSet$ui() & v0) != 0 && ((v7 instanceof DelegatingNode))) {
            Node v9 = v7.getDelegate$ui();
            int v10 = 0;
            while(v9 != null) {
                if((v9.getKindSet$ui() & v0) != 0) {
                    ++v10;
                    if(v10 == 1) {
                        v7_2 = v9;
                    }
                    else {
                        if(v8 == null) {
                            v8 = new MutableVector(new Node[v2], 0);
                        }

                        if(v7 != null) {
                            if(v8 != null) {
                                v8.add(v7);
                            }

                            v7 = v6;
                        }

                        if(v8 == null) {
                            goto label_79;
                        }

                        v8.add(v9);
                    }
                }

            label_79:
                v9 = v9.getChild$ui();
            }

            if(v10 != 1) {
                goto label_83;
            }

            goto label_38;
        }

    label_83:
        v7_2 = DelegatableNodeKt.pop(v8);
        goto label_38;
    label_85:
        Node v5_1 = v5_1.getChild$ui();
        goto label_29;
    label_87:
        DelegatableNodeKt.addLayoutNodeChildren(v1, ((Node)v12), false);
        goto label_19;
    }

    public static final void traverseDescendants(TraversableNode arg13, Function1 arg14) {
        Node v8_2;
        MutableVector v9;
        Object v8;
        Object v7;
        Object v6;
        Object v0_1;
        TraversableNode v0 = arg13;
        int v1 = NodeKind.constructor-impl(0x40000);
        if(!((DelegatableNode)v0).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v3 = 16;
        MutableVector v2 = new MutableVector(new Node[v3], 0);
        Node v4 = ((DelegatableNode)v0).getNode().getChild$ui();
        if(v4 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v2, ((DelegatableNode)v0).getNode(), false);
        }
        else {
            v2.add(v4);
        }

        do {
        label_20:
            if(v2.getSize() == 0) {
                return;
            }

            v0_1 = v2.removeAt(v2.getSize() - 1);
            if((((Node)v0_1).getAggregateChildKindSet$ui() & v1) != 0) {
                v6 = v0_1;
                while(true) {
                label_30:
                    if(v6 != null && (((Node)v6).isAttached())) {
                        if((((Node)v6).getKindSet$ui() & v1) != 0) {
                            v7 = null;
                            v8 = v6;
                            v9 = ((MutableVector)v7);
                            while(true) {
                            label_39:
                                if(v8 != null) {
                                    if((v8 instanceof TraversableNode)) {
                                        if(!Intrinsics.areEqual(arg13.getTraverseKey(), ((TraversableNode)v8).getTraverseKey()) || !Actual_jvmKt.areObjectsOfSameType(arg13, v8)) {
                                            TraverseDescendantsAction v8_1 = TraverseDescendantsAction.ContinueTraversal;
                                        }
                                        else {
                                            v8 = arg14.invoke(v8);
                                        }

                                        if(v8 == TraverseDescendantsAction.CancelTraversal) {
                                            return;
                                        }

                                        if(v8 == TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            goto label_20;
                                        }

                                        goto label_56;
                                    }
                                    else {
                                        goto label_57;
                                    }
                                }

                                goto label_89;
                            }
                        }

                        goto label_89;
                    }

                    goto label_91;
                }
            }

            goto label_91;
        }
        while(true);

    label_56:
        goto label_87;
    label_57:
        if((((Node)v8).getKindSet$ui() & v1) != 0 && ((v8 instanceof DelegatingNode))) {
            Node v10 = v8.getDelegate$ui();
            int v11 = 0;
            while(v10 != null) {
                if((v10.getKindSet$ui() & v1) != 0) {
                    ++v11;
                    if(v11 == 1) {
                        v8_2 = v10;
                    }
                    else {
                        if(v9 == null) {
                            v9 = new MutableVector(new Node[v3], 0);
                        }

                        if(v8 != null) {
                            if(v9 != null) {
                                v9.add(v8);
                            }

                            v8 = v7;
                        }

                        if(v9 == null) {
                            goto label_83;
                        }

                        v9.add(v10);
                    }
                }

            label_83:
                v10 = v10.getChild$ui();
            }

            if(v11 != 1) {
                goto label_87;
            }

            goto label_39;
        }

    label_87:
        v8_2 = DelegatableNodeKt.pop(v9);
        goto label_39;
    label_89:
        Node v6_1 = ((Node)v6).getChild$ui();
        goto label_30;
    label_91:
        DelegatableNodeKt.addLayoutNodeChildren(v2, ((Node)v0_1), false);
        goto label_20;
    }
}

