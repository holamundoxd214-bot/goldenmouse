package androidx.compose.ui.semantics;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u001A\u001A\u00020\u001BH\u0080\u0002¢\u0006\u0002\b\u001CJ\u001F\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u00162\b\u0010 \u001A\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b\"R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2={"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "outerSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "nodes", "Landroidx/collection/IntObjectMap;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/EmptySemanticsModifier;Landroidx/collection/IntObjectMap;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/semantics/SemanticsListener;", "getListeners$ui", "()Landroidx/collection/MutableObjectList;", "rootInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "getRootInfo$ui", "()Landroidx/compose/ui/semantics/SemanticsInfo;", "get", "semanticsId", "", "get$ui", "notifySemanticsChange", "", "semanticsInfo", "previousSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "notifySemanticsChange$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsOwner {
    public static final int $stable = 8;
    private final MutableObjectList listeners;
    private final IntObjectMap nodes;
    private final EmptySemanticsModifier outerSemanticsNode;
    private final LayoutNode rootNode;

    static {
    }

    public SemanticsOwner(LayoutNode arg1, EmptySemanticsModifier arg2, IntObjectMap arg3) {
        super();
        this.rootNode = arg1;
        this.outerSemanticsNode = arg2;
        this.nodes = arg3;
        this.listeners = new MutableObjectList(2);
    }

    public final SemanticsInfo get$ui(int arg1) {
        return this.nodes.get(arg1);
    }

    public final MutableObjectList getListeners$ui() {
        return this.listeners;
    }

    public final SemanticsInfo getRootInfo$ui() {
        return this.rootNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        return new SemanticsNode(this.outerSemanticsNode, false, this.rootNode, new SemanticsConfiguration());
    }

    public final void notifySemanticsChange$ui(SemanticsInfo arg4, SemanticsConfiguration arg5) {
        MutableObjectList v3 = this.listeners;
        Object[] v0 = ((ObjectList)v3).content;
        int v3_1 = ((ObjectList)v3)._size;
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            v0[v1].onSemanticsChanged(arg4, arg5);
        }
    }
}

