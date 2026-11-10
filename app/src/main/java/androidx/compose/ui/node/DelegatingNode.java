package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b\rJ!\u0010\u0013\u001A\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001A\u0002H\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u001BJ\u0015\u0010\u001C\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u0001H\u0010¢\u0006\u0002\b\u001EJ\u001F\u0010\u000E\u001A\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001A\u0002H\u0014H\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001F\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u0015H\u0004J\u0018\u0010 \u001A\u00020\n2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0001H\u0002J\u0018\u0010#\u001A\u00020\n2\u0006\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020&H\u0002J\"\u0010\'\u001A\u00020\n2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0)H\u0080\b¢\u0006\u0002\b*J\r\u0010+\u001A\u00020\nH\u0010¢\u0006\u0002\b,J\r\u0010-\u001A\u00020\nH\u0010¢\u0006\u0002\b.J\r\u0010/\u001A\u00020\nH\u0010¢\u0006\u0002\b0J\r\u00101\u001A\u00020\nH\u0010¢\u0006\u0002\b2J\r\u00103\u001A\u00020\nH\u0010¢\u0006\u0002\b4R\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\u000E\u001A\u0004\u0018\u00010\u0001X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2={"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "selfKindSet", "", "getSelfKindSet$ui$annotations", "getSelfKindSet$ui", "()I", "updateCoordinator", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui", "delegate", "getDelegate$ui", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui", "(Landroidx/compose/ui/Modifier$Node;)V", "delegateUnprotected", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "delegateUnprotected$ui", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "undelegateUnprotected", "instance", "undelegateUnprotected$ui", "setAsDelegateTo", "owner", "setAsDelegateTo$ui", "undelegate", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "forEachImmediateDelegate", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui", "markAsAttached", "markAsAttached$ui", "runAttachLifecycle", "runAttachLifecycle$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "markAsDetached", "markAsDetached$ui", "reset", "reset$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DelegatingNode extends Node {
    public static final int $stable = 8;
    private Node delegate;
    private final int selfKindSet;

    static {
    }

    public DelegatingNode() {
        super();
        this.selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);
    }

    protected final DelegatableNode delegate(DelegatableNode arg7) {
        Node v0 = arg7.getNode();
        Object v1 = null;
        if((((DelegatableNode)v0)) != arg7) {
            DelegatableNode v2 = (arg7 instanceof Node) ? arg7 : ((DelegatableNode)v1);
            if(v2 != null) {
                Node v1_1 = ((Node)v2).getParent$ui();
            }

            if(v0 == this.getNode() && (Intrinsics.areEqual(v1_1, this))) {
                return arg7;
            }

            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }

        if(v0.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }

        v0.setAsDelegateTo$ui(this.getNode());
        int v2_1 = this.getKindSet$ui();
        int v3 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(v0);
        v0.setKindSet$ui(v3);
        this.validateDelegateKindSet(v3, v0);
        v0.setChild$ui(this.delegate);
        this.delegate = v0;
        v0.setParent$ui(this);
        this.updateNodeKindSet(this.getKindSet$ui() | v3, false);
        if(this.isAttached()) {
            int v4 = 2;
            if((v3 & NodeKind.constructor-impl(v4)) == 0 || (v2_1 & NodeKind.constructor-impl(v4)) != 0) {
                this.updateCoordinator$ui(this.getCoordinator$ui());
            }
            else {
                NodeChain v2_2 = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui();
                this.getNode().updateCoordinator$ui(((NodeCoordinator)v1));
                v2_2.syncCoordinators();
            }

            v0.markAsAttached$ui();
            v0.runAttachLifecycle$ui();
            NodeKindKt.autoInvalidateInsertedNode(v0);
        }

        return arg7;
    }

    public final DelegatableNode delegateUnprotected$ui(DelegatableNode arg1) {
        return this.delegate(arg1);
    }

    public final void forEachImmediateDelegate$ui(Function1 arg1) {
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            arg1.invoke(v0);
        }
    }

    public final Node getDelegate$ui() {
        return this.delegate;
    }

    public final int getSelfKindSet$ui() {
        return this.selfKindSet;
    }

    public static void getSelfKindSet$ui$annotations() {
    }

    public void markAsAttached$ui() {
        super.markAsAttached$ui();
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.updateCoordinator$ui(this.getCoordinator$ui());
            if(!v0.isAttached()) {
                v0.markAsAttached$ui();
            }
        }
    }

    public void markAsDetached$ui() {
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.markAsDetached$ui();
        }

        super.markAsDetached$ui();
    }

    public void reset$ui() {
        super.reset$ui();
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.reset$ui();
        }
    }

    public void runAttachLifecycle$ui() {
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.runAttachLifecycle$ui();
        }

        super.runAttachLifecycle$ui();
    }

    public void runDetachLifecycle$ui() {
        super.runDetachLifecycle$ui();
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.runDetachLifecycle$ui();
        }
    }

    public void setAsDelegateTo$ui(Node arg1) {
        super.setAsDelegateTo$ui(arg1);
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.setAsDelegateTo$ui(arg1);
        }
    }

    public final void setDelegate$ui(Node arg1) {
        this.delegate = arg1;
    }

    protected final void undelegate(DelegatableNode arg6) {
        Node v0 = this.delegate;
        Node v1 = null;
        Node v2 = v1;
        while(v0 != null) {
            if((((DelegatableNode)v0)) == arg6) {
                if(v0.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(v0);
                    v0.runDetachLifecycle$ui();
                    v0.markAsDetached$ui();
                }

                v0.setAsDelegateTo$ui(v0);
                v0.setAggregateChildKindSet$ui(0);
                if(v2 == null) {
                    this.delegate = v0.getChild$ui();
                }
                else {
                    v2.setChild$ui(v0.getChild$ui());
                }

                v0.setChild$ui(v1);
                v0.setParent$ui(v1);
                int v6 = this.getKindSet$ui();
                int v0_1 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                this.updateNodeKindSet(v0_1, true);
                if(this.isAttached()) {
                    int v2_1 = 2;
                    if((v6 & NodeKind.constructor-impl(v2_1)) != 0) {
                        if((NodeKind.constructor-impl(v2_1) & v0_1) != 0) {
                            return;
                        }
                        else {
                            NodeChain v6_1 = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui();
                            this.getNode().updateCoordinator$ui(((NodeCoordinator)v1));
                            v6_1.syncCoordinators();
                        }
                    }
                }

                return;
            }

            v2 = v0;
            v0 = v0.getChild$ui();
        }

        throw new IllegalStateException("Could not find delegate: " + arg6.toString());
    }

    public final void undelegateUnprotected$ui(DelegatableNode arg1) {
        this.undelegate(arg1);
    }

    public void updateCoordinator$ui(NodeCoordinator arg1) {
        super.updateCoordinator$ui(arg1);
        Node v0;
        for(v0 = this.getDelegate$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.updateCoordinator$ui(arg1);
        }
    }

    private final void updateNodeKindSet(int arg3, boolean arg4) {
        int v4_1;
        Node v2;
        int v0 = this.getKindSet$ui();
        this.setKindSet$ui(arg3);
        if(v0 != arg3) {
            if(DelegatableNodeKt.isDelegationRoot(this)) {
                this.setAggregateChildKindSet$ui(arg3);
            }

            if(!this.isAttached()) {
                return;
            }

            Node v0_1 = this.getNode();
            while(this != null) {
                arg3 |= ((Node)this).getKindSet$ui();
                ((Node)this).setKindSet$ui(arg3);
                if(this == (((DelegatingNode)v0_1))) {
                    break;
                }

                v2 = v2.getParent$ui();
            }

            if((arg4) && (((DelegatingNode)v2)) == (((DelegatingNode)v0_1))) {
                arg3 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(v0_1);
                v0_1.setKindSet$ui(arg3);
            }

            if((((DelegatingNode)v2)) != null) {
                Node v4 = v2.getChild$ui();
                if(v4 != null) {
                    v4_1 = v4.getAggregateChildKindSet$ui();
                }
                else {
                    goto label_26;
                }
            }
            else {
            label_26:
                v4_1 = 0;
            }

            arg3 |= v4_1;
            while((((DelegatingNode)v2)) != null) {
                arg3 |= v2.getKindSet$ui();
                v2.setAggregateChildKindSet$ui(arg3);
                v2 = v2.getParent$ui();
            }
        }
    }

    private final void validateDelegateKindSet(int arg4, Node arg5) {
        int v0 = this.getKindSet$ui();
        int v1 = 2;
        if((arg4 & NodeKind.constructor-impl(v1)) != 0 && (NodeKind.constructor-impl(v1) & v0) != 0 && !(this instanceof LayoutModifierNode)) {
            InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + arg5);
        }
    }
}

