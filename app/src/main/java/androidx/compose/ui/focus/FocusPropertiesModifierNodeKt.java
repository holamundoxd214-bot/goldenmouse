package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2={"invalidateFocusProperties", "", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(FocusPropertiesModifierNode arg10) {
        Node v10_1;
        MutableVector v6;
        Object v5;
        Object v10;
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)arg10).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v2 = 16;
        MutableVector v1 = new MutableVector(new Node[v2], 0);
        Node v3 = ((DelegatableNode)arg10).getNode().getChild$ui();
        if(v3 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1, ((DelegatableNode)arg10).getNode(), false);
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

            v10_1 = v10_1.getChild$ui();
        }

        while(true) {
        label_36:
            if(v10_1 == null) {
                goto label_19;
            }

            if((v10_1 instanceof FocusTargetNode)) {
                FocusTargetNodeKt.invalidateFocusTarget(((FocusTargetNode)v10_1));
            }
            else if((v10_1.getKindSet$ui() & v0) != 0 && ((v10_1 instanceof DelegatingNode))) {
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
                                goto label_67;
                            }

                            v6.add(v7);
                        }
                    }

                label_67:
                    v7 = v7.getChild$ui();
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
}

