package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u001A\u001D\u0010\u0006\u001A\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b*\u0002H\u0007H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"nestedScrollModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "findNearestAttachedAncestor", "T", "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NestedScrollNodeKt {
    public static final TraversableNode access$findNearestAttachedAncestor(TraversableNode arg0) {
        return NestedScrollNodeKt.findNearestAttachedAncestor(arg0);
    }

    private static final TraversableNode findNearestAttachedAncestor(TraversableNode arg2) {
        ObjectRef v0 = new ObjectRef();
        TraversableNodeKt.traverseAncestors(arg2, new NestedScrollNodeKt$findNearestAttachedAncestor$1(v0));
        return v0.element;
    }

    public static final DelegatableNode nestedScrollModifierNode(NestedScrollConnection arg1, NestedScrollDispatcher arg2) {
        return new NestedScrollNode(arg1, arg2);
    }
}

