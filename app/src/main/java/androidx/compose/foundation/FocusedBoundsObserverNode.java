package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005R(\u0010\u0003\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\bR\u0014\u0010\f\u001A\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/FocusedBoundsObserverNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "onPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "setOnPositioned", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onFocusBoundsChanged", "focusedBounds", "TraverseKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusedBoundsObserverNode extends Node implements TraversableNode {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/FocusedBoundsObserverNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker arg1) {
            this();
        }

        private TraverseKey() {
            super();
        }
    }

    public static final int $stable;
    public static final TraverseKey TraverseKey;
    private Function1 onPositioned;
    private final Object traverseKey;

    static {
        FocusedBoundsObserverNode.TraverseKey = new TraverseKey(null);
        FocusedBoundsObserverNode.$stable = 8;
    }

    public FocusedBoundsObserverNode(Function1 arg1) {
        super();
        this.onPositioned = arg1;
        this.traverseKey = FocusedBoundsObserverNode.TraverseKey;
    }

    public final Function1 getOnPositioned() {
        return this.onPositioned;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates arg2) {
        this.onPositioned.invoke(arg2);
        TraversableNode v1 = TraversableNodeKt.findNearestAncestor(((TraversableNode)this));
        if(v1 != null) {
            ((FocusedBoundsObserverNode)v1).onFocusBoundsChanged(arg2);
        }
    }

    public final void setOnPositioned(Function1 arg1) {
        this.onPositioned = arg1;
    }
}

