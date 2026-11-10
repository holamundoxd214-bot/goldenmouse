package androidx.compose.ui.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0012\b\u0002\u0010\u0003\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"bringIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "bounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewModifierNodeKt {
    public static final Object bringIntoView(DelegatableNode arg11, Function0 arg12, Continuation arg13) {
        Node v3;
        if(!arg11.getNode().isAttached()) {
            return Unit.INSTANCE;
        }

        int v0 = NodeKind.constructor-impl(0x80000);
        if(!arg11.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = arg11.getNode().getParent$ui();
        LayoutNode v2 = DelegatableNodeKt.requireLayoutNode(arg11);
        while(true) {
            v3 = null;
            if(v2 != null) {
                if((v2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                    while(v1 != null) {
                        if((v1.getKindSet$ui() & v0) != 0) {
                            Node v4 = v1;
                            MutableVector v5 = ((MutableVector)v3);
                            while(true) {
                            label_28:
                                if(v4 != null) {
                                    if((v4 instanceof BringIntoViewModifierNode)) {
                                        v3 = v4;
                                        goto label_80;
                                    }
                                    else {
                                        if((v4.getKindSet$ui() & v0) != 0 && ((v4 instanceof DelegatingNode))) {
                                            Node v6 = v4.getDelegate$ui();
                                            int v8 = 0;
                                            while(v6 != null) {
                                                if((v6.getKindSet$ui() & v0) != 0) {
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
                                                                Boxing.boxBoolean(v5.add(v4));
                                                            }

                                                            v4 = v3;
                                                        }

                                                        if(v5 == null) {
                                                            goto label_64;
                                                        }

                                                        Boxing.boxBoolean(v5.add(v6));
                                                    }
                                                }

                                            label_64:
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

                                goto label_70;
                            }

                            v4 = DelegatableNodeKt.pop(v5);
                            goto label_28;
                        }

                    label_70:
                        v1 = v1.getParent$ui();
                    }
                }

                v2 = v2.getParent$ui();
                if(v2 != null) {
                    NodeChain v1_1 = v2.getNodes$ui();
                    if(v1_1 != null) {
                        v1 = v1_1.getTail$ui();
                        continue;
                    }
                }

                v1 = v3;
                continue;
            }

            break;
        }

    label_80:
        if(v3 == null) {
            return Unit.INSTANCE;
        }

        LayoutCoordinates v11 = DelegatableNodeKt.requireLayoutCoordinates(arg11);
        Object v11_1 = ((BringIntoViewModifierNode)v3).bringIntoView(v11, new BringIntoViewModifierNodeKt$bringIntoView$2(arg12, v11), arg13);
        if(v11_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v11_1;
        }

        return Unit.INSTANCE;
    }

    public static Object bringIntoView$default(DelegatableNode arg0, Function0 arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        return BringIntoViewModifierNodeKt.bringIntoView(arg0, arg1, arg2);
    }
}

