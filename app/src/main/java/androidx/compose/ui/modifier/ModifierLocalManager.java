package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001A\u00020\u0013J\u0006\u0010\u0014\u001A\u00020\u0013J*\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00172\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\f2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\n0\u001AH\u0002J\u001A\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\n2\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\fJ\u001A\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\n2\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\fJ\u001A\u0010\u001D\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\n2\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000B\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000F\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/node/Owner;)V", "getOwner", "()Landroidx/compose/ui/node/Owner;", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "invalidated", "", "invalidate", "", "triggerUpdates", "invalidateConsumersOfNodeForKey", "node", "Landroidx/compose/ui/Modifier$Node;", "key", "set", "", "updatedProvider", "insertedProvider", "removedProvider", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModifierLocalManager {
    public static final int $stable = 8;
    private final MutableVector inserted;
    private final MutableVector insertedLocal;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector removed;
    private final MutableVector removedLocal;

    static {
    }

    public ModifierLocalManager(Owner arg4) {
        super();
        this.owner = arg4;
        this.inserted = new MutableVector(new BackwardsCompatNode[16], 0);
        this.insertedLocal = new MutableVector(new ModifierLocal[16], 0);
        this.removed = new MutableVector(new LayoutNode[16], 0);
        this.removedLocal = new MutableVector(new ModifierLocal[16], 0);
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void insertedProvider(BackwardsCompatNode arg2, ModifierLocal arg3) {
        this.inserted.add(arg2);
        this.insertedLocal.add(arg3);
        this.invalidate();
    }

    public final void invalidate() {
        if(!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new ModifierLocalManager$invalidate$1(this));
        }
    }

    private final void invalidateConsumersOfNodeForKey(Node arg12, ModifierLocal arg13, Set arg14) {
        Node v6_1;
        MutableVector v7;
        Object v6;
        Object v5;
        Object v4;
        Object v12;
        int v11 = NodeKind.constructor-impl(0x20);
        if(!((DelegatableNode)arg12).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v1 = 16;
        MutableVector v0 = new MutableVector(new Node[v1], 0);
        Node v2 = ((DelegatableNode)arg12).getNode().getChild$ui();
        if(v2 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v0, ((DelegatableNode)arg12).getNode(), false);
        }
        else {
            v0.add(v2);
        }

        while(true) {
        label_19:
            if(v0.getSize() == 0) {
                return;
            }

            v12 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v12).getAggregateChildKindSet$ui() & v11) != 0) {
                v4 = v12;
                while(true) {
                label_29:
                    if(v4 != null && (((Node)v4).isAttached())) {
                        if((((Node)v4).getKindSet$ui() & v11) != 0) {
                            v5 = null;
                            v6 = v4;
                            v7 = ((MutableVector)v5);
                            while(true) {
                            label_38:
                                if(v6 != null) {
                                    if((v6 instanceof ModifierLocalModifierNode)) {
                                        if((v6 instanceof BackwardsCompatNode)) {
                                            Object v8 = v6;
                                            if(((((BackwardsCompatNode)v8).getElement() instanceof ModifierLocalConsumer)) && (((BackwardsCompatNode)v8).getReadValues().contains(arg13))) {
                                                arg14.add(v6);
                                            }
                                        }

                                        if(!((ModifierLocalModifierNode)v6).getProvidedValues().contains$ui(arg13)) {
                                            goto label_85;
                                        }

                                        goto label_19;
                                    }
                                    else {
                                        goto label_55;
                                    }
                                }

                                goto label_87;
                            }
                        }

                        goto label_87;
                    }

                    goto label_89;
                }
            }

            goto label_89;
        }

    label_55:
        if((((Node)v6).getKindSet$ui() & v11) != 0 && ((v6 instanceof DelegatingNode))) {
            Node v8_1 = v6.getDelegate$ui();
            int v9 = 0;
            while(v8_1 != null) {
                if((v8_1.getKindSet$ui() & v11) != 0) {
                    ++v9;
                    if(v9 == 1) {
                        v6_1 = v8_1;
                    }
                    else {
                        if(v7 == null) {
                            v7 = new MutableVector(new Node[v1], 0);
                        }

                        if(v6_1 != null) {
                            if(v7 != null) {
                                v7.add(v6_1);
                            }

                            v6 = v5;
                        }

                        if(v7 == null) {
                            goto label_81;
                        }

                        v7.add(v8_1);
                    }
                }

            label_81:
                v8_1 = v8_1.getChild$ui();
            }

            if(v9 != 1) {
                goto label_85;
            }

            goto label_38;
        }

    label_85:
        v6_1 = DelegatableNodeKt.access$pop(v7);
        goto label_38;
    label_87:
        Node v4_1 = ((Node)v4).getChild$ui();
        goto label_29;
    label_89:
        DelegatableNodeKt.access$addLayoutNodeChildren(v0, ((Node)v12), false);
        goto label_19;
    }

    public final void removedProvider(BackwardsCompatNode arg2, ModifierLocal arg3) {
        this.removed.add(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg2)));
        this.removedLocal.add(arg3);
        this.invalidate();
    }

    public final void triggerUpdates() {
        Object v5;
        int v0 = 0;
        this.invalidated = false;
        HashSet v1 = new HashSet();
        MutableVector v2 = this.removed;
        Object[] v3 = v2.content;
        int v2_1 = v2.getSize();
        int v4;
        for(v4 = 0; v4 < v2_1; ++v4) {
            v5 = v3[v4];
            Object v6 = this.removedLocal.content[v4];
            if(((LayoutNode)v5).getNodes$ui().getHead$ui().isAttached()) {
                this.invalidateConsumersOfNodeForKey(((LayoutNode)v5).getNodes$ui().getHead$ui(), ((ModifierLocal)v6), v1);
            }
        }

        this.removed.clear();
        this.removedLocal.clear();
        v2 = this.inserted;
        v3 = v2.content;
        v2_1 = v2.getSize();
        while(v0 < v2_1) {
            Object v4_1 = v3[v0];
            v5 = this.insertedLocal.content[v0];
            if(((BackwardsCompatNode)v4_1).isAttached()) {
                this.invalidateConsumersOfNodeForKey(((Node)v4_1), ((ModifierLocal)v5), v1);
            }

            ++v0;
        }

        this.inserted.clear();
        this.insertedLocal.clear();
        Iterator v8 = ((Iterable)v1).iterator();
        while(v8.hasNext()) {
            v8.next().updateModifierLocalConsumer();
        }
    }

    public final void updatedProvider(BackwardsCompatNode arg2, ModifierLocal arg3) {
        this.inserted.add(arg2);
        this.insertedLocal.add(arg3);
        this.invalidate();
    }
}

