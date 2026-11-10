package androidx.compose.ui.modifier;

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

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\u0007\u001A\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\t0\u000B2\u0006\u0010\f\u001A\u0002H\tH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R$\u0010\u000E\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "provide", "", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "current", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    default Object getCurrent(ModifierLocal arg11) {
        if(!this.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("ModifierLocal accessed from an unattached node");
        }

        int v0 = NodeKind.constructor-impl(0x20);
        if(!((DelegatableNode)this).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = ((DelegatableNode)this).getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this));
        while(v10 != null) {
            Node v3 = null;
            if((v10.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                while(v1 != null) {
                    if((v1.getKindSet$ui() & v0) != 0) {
                        Node v2 = v1;
                        MutableVector v4 = ((MutableVector)v3);
                        while(true) {
                        label_28:
                            if(v2 != null) {
                                if((v2 instanceof ModifierLocalModifierNode)) {
                                    if(((ModifierLocalModifierNode)v2).getProvidedValues().contains$ui(arg11)) {
                                        return ((ModifierLocalModifierNode)v2).getProvidedValues().get$ui(arg11);
                                    }
                                }
                                else if((v2.getKindSet$ui() & v0) != 0 && ((v2 instanceof DelegatingNode))) {
                                    Node v5 = v2.getDelegate$ui();
                                    int v7 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & v0) != 0) {
                                            ++v7;
                                            if(v7 == 1) {
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
                                                    goto label_66;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_66:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v7 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_72;
                        }

                        v2 = DelegatableNodeKt.access$pop(v4);
                        goto label_28;
                    }

                label_72:
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

        return arg11.getDefaultFactory$ui().invoke();
    }

    default ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    default void provide(ModifierLocal arg3, Object arg4) {
        int v0 = this.getProvidedValues() != EmptyMap.INSTANCE ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
        }

        if(!this.getProvidedValues().contains$ui(arg3)) {
            InlineClassHelperKt.throwIllegalArgumentException("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + arg3 + " was not found.");
        }

        this.getProvidedValues().set$ui(arg3, arg4);
    }
}

