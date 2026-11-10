package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\nJ\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\fJ\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0012\u001A\u00020\u000EJ\b\u0010\u0013\u001A\u00020\u0010H\u0002J\b\u0010\u0014\u001A\u00020\u0010H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/FocusOwner;Landroidx/compose/ui/node/Owner;)V", "focusTargetNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusEventNodes", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "isInvalidationScheduled", "", "scheduleInvalidation", "", "node", "hasPendingInvalidation", "invalidateNodes", "invalidateOwnerFocusState", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final MutableScatterSet focusEventNodes;
    private final FocusOwner focusOwner;
    private final MutableScatterSet focusTargetNodes;
    private boolean isInvalidationScheduled;
    private final Owner owner;

    static {
    }

    public FocusInvalidationManager(FocusOwner arg1, Owner arg2) {
        super();
        this.focusOwner = arg1;
        this.owner = arg2;
        this.focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
        this.focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    }

    public static final void access$invalidateNodes(FocusInvalidationManager arg0) {
        arg0.invalidateNodes();
    }

    public final boolean hasPendingInvalidation() {
        return this.isInvalidationScheduled;
    }

    private final void invalidateNodes() {
        long v19;
        int v3;
        long v16;
        int v13;
        long[] v1_2;
        MutableScatterSet v1_1;
        FocusInvalidationManager v0 = this;
        FocusTargetNode v1 = v0.focusOwner.getActiveFocusTargetNode();
        long v4 = 0xFF;
        int v6 = 7;
        long v7 = -9187201950435737472L;
        int v9 = 8;
        if(v1 == null) {
            v1_1 = v0.focusEventNodes;
            Object[] v11 = ((ScatterSet)v1_1).elements;
            v1_2 = ((ScatterSet)v1_1).metadata;
            int v12 = v1_2.length - 2;
            if(v12 >= 0) {
                v13 = 0;
                while(true) {
                    long v14 = v1_2[v13];
                    v16 = 0x80;
                    if((~v14 << v6 & v14 & v7) != v7) {
                        int v2 = 8 - (~(v13 - v12) >>> 0x1F);
                        v3 = 0;
                        while(v3 < v2) {
                            if((v14 & v4) < v16) {
                                v19 = v4;
                                v11[(v13 << 3) + v3].onFocusEvent(FocusStateImpl.Inactive);
                            }
                            else {
                                v19 = v4;
                            }

                            v14 >>= v9;
                            ++v3;
                            v4 = v19;
                        }

                        v19 = v4;
                        if(v2 != v9) {
                            break;
                        }
                    }
                    else {
                        v19 = v4;
                    }

                    if(v13 == v12) {
                        break;
                    }

                    ++v13;
                    v4 = v19;
                }
            }
        }
        else {
            v19 = v4;
            v16 = 0x80;
            if(!v1.isAttached()) {
                goto label_149;
            }

            if(v0.focusTargetNodes.contains(v1)) {
                v1.invalidateFocus$ui();
            }

            FocusStateImpl v2_1 = v1.getFocusState();
            v3 = 0x400;
            int v4_1 = NodeKind.constructor-impl(v3) | NodeKind.constructor-impl(0x1000);
            if(!((DelegatableNode)v1).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }

            Node v5 = ((DelegatableNode)v1).getNode();
            LayoutNode v1_3 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v1));
            int v11_1 = 0;
            while(v1_3 != null) {
                if((v1_3.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v4_1) != 0) {
                    while(v5 != null) {
                        if((v5.getKindSet$ui() & v4_1) != 0) {
                            if((NodeKind.constructor-impl(v3) & v5.getKindSet$ui()) != 0) {
                                ++v11_1;
                            }

                            if(!(v5 instanceof FocusEventModifierNode)) {
                                goto label_106;
                            }

                            if(!v0.focusEventNodes.contains(v5)) {
                                goto label_106;
                            }

                            if(v11_1 <= 1) {
                                v5.onFocusEvent(v2_1);
                            }
                            else {
                                v5.onFocusEvent(FocusStateImpl.ActiveParent);
                            }

                            v0.focusEventNodes.remove(v5);
                        }

                    label_106:
                        v5 = v5.getParent$ui();
                    }
                }

                v1_3 = v1_3.getParent$ui();
                if(v1_3 != null) {
                    NodeChain v5_1 = v1_3.getNodes$ui();
                    if(v5_1 != null) {
                        v5 = v5_1.getTail$ui();
                        continue;
                    }
                }

                v5 = null;
            }

            v1_1 = v0.focusEventNodes;
            Object[] v2_2 = ((ScatterSet)v1_1).elements;
            v1_2 = ((ScatterSet)v1_1).metadata;
            v3 = v1_2.length - 2;
            if(v3 < 0) {
                goto label_149;
            }

            for(v4_1 = 0; true; ++v4_1) {
                long v11_2 = v1_2[v4_1];
                if((~v11_2 << v6 & v11_2 & v7) != v7) {
                    int v5_2 = 8 - (~(v4_1 - v3) >>> 0x1F);
                    for(v13 = 0; v13 < v5_2; ++v13) {
                        if((v11_2 & v19) < v16) {
                            v2_2[(v4_1 << 3) + v13].onFocusEvent(FocusStateImpl.Inactive);
                        }

                        v11_2 >>= v9;
                    }

                    if(v5_2 != v9) {
                        break;
                    }
                }

                if(v4_1 == v3) {
                    break;
                }
            }
        }

    label_149:
        v0.invalidateOwnerFocusState();
        v0.focusTargetNodes.clear();
        v0.focusEventNodes.clear();
        v0.isInvalidationScheduled = false;
    }

    private final void invalidateOwnerFocusState() {
        if(this.focusOwner.getActiveFocusTargetNode() != null) {
            if(this.focusOwner.getRootState() == FocusStateImpl.Inactive) {
            }
            else {
                return;
            }
        }

        this.focusOwner.clearOwnerFocus();
    }

    public final void scheduleInvalidation() {
        if(!this.isInvalidationScheduled) {
            this.owner.registerOnEndApplyChangesListener(new FocusInvalidationManager$scheduleInvalidation$1(this));
            this.isInvalidationScheduled = true;
        }
    }

    public final void scheduleInvalidation(FocusEventModifierNode arg2) {
        if(this.focusEventNodes.add(arg2)) {
            this.scheduleInvalidation();
        }
    }

    public final void scheduleInvalidation(FocusTargetNode arg2) {
        if(this.focusTargetNodes.add(arg2)) {
            this.scheduleInvalidation();
        }
    }
}

