package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\u0012\u0010\u0003\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2={"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "dispatchDraw", "Landroidx/compose/ui/node/DelegatableNode;", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawModifierNodeKt {
    public static final void dispatchDraw(DelegatableNode arg8, ContentDrawScope arg9) {
        Node v8 = arg8.getNode();
        int v0 = NodeKind.constructor-impl(4);
        Node v1 = null;
        MutableVector v2 = ((MutableVector)v1);
        while(true) {
        label_5:
            if(v8 == null) {
                return;
            }

            if((v8 instanceof DrawModifierNode)) {
                ((DrawModifierNode)v8).draw(arg9);
            }
            else if((v8.getKindSet$ui() & v0) != 0 && ((v8 instanceof DelegatingNode))) {
                Node v3 = v8.getDelegate$ui();
                int v5 = 0;
                while(v3 != null) {
                    if((v3.getKindSet$ui() & v0) != 0) {
                        ++v5;
                        if(v5 == 1) {
                            v8 = v3;
                        }
                        else {
                            if(v2 == null) {
                                v2 = new MutableVector(new Node[16], 0);
                            }

                            if(v8 != null) {
                                if(v2 != null) {
                                    v2.add(v8);
                                }

                                v8 = v1;
                            }

                            if(v2 == null) {
                                goto label_39;
                            }

                            v2.add(v3);
                        }
                    }

                label_39:
                    v3 = v3.getChild$ui();
                }

                if(v5 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v8 = DelegatableNodeKt.pop(v2);
        goto label_5;
    }

    public static final void invalidateDraw(DrawModifierNode arg1) {
        if(arg1.getNode().isAttached()) {
            DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)arg1), NodeKind.constructor-impl(1)).invalidateLayer();
        }
    }
}

