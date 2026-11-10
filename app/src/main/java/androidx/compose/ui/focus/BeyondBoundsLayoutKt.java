package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A>\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0019\u0010\u0005\u001A\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BeyondBoundsLayoutKt {
    public static final Object searchBeyondBounds--OM-vw8(FocusTargetNode arg11, int arg12, Function1 arg13) {
        Node v4;
        Node v3;
        FocusTargetNode v0 = arg11;
        int v1 = NodeKind.constructor-impl(0x400);
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
                        v4 = v2;
                        MutableVector v5 = ((MutableVector)v3);
                        while(true) {
                        label_24:
                            if(v4 != null) {
                                if((v4 instanceof FocusTargetNode)) {
                                    goto label_74;
                                }
                                else {
                                    if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
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
                                                        goto label_57;
                                                    }

                                                    v5.add(v6);
                                                }
                                            }

                                        label_57:
                                            v6 = v6.getChild$ui();
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

                        v4 = DelegatableNodeKt.access$pop(v5);
                        goto label_24;
                    }

                label_63:
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

        v4 = v3;
    label_74:
        if(v4 != null && (Intrinsics.areEqual(((FocusTargetNode)v4).getBeyondBoundsLayoutParent(), arg11.getBeyondBoundsLayoutParent()))) {
            return v3;
        }

        BeyondBoundsLayout v11 = arg11.getBeyondBoundsLayoutParent();
        if(v11 == null) {
            return v3;
        }

        if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getUp-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getAbove-hoxUOeE();
        }
        else if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getDown-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getBelow-hoxUOeE();
        }
        else if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getLeft-hoxUOeE();
        }
        else if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getRight-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getRight-hoxUOeE();
        }
        else if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getNext-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getAfter-hoxUOeE();
        }
        else if(FocusDirection.equals-impl0(arg12, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            arg12 = LayoutDirection.Companion.getBefore-hoxUOeE();
        }
        else {
            goto label_125;
        }

        return v11.layout-o7g1Pn8(arg12, arg13);
    label_125:
        throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
        return v3;
    }
}

