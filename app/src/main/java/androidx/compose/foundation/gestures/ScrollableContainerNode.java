package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0003\u001A\u00020\u0004R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "enabled", "", "<init>", "(Z)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "value", "getEnabled", "()Z", "update", "", "TraverseKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollableContainerNode extends Node implements TraversableNode {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/ScrollableContainerNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker arg1) {
            this();
        }

        private TraverseKey() {
            super();
        }
    }

    public static final int $stable;
    public static final TraverseKey TraverseKey;
    private boolean enabled;
    private final Object traverseKey;

    static {
        ScrollableContainerNode.TraverseKey = new TraverseKey(null);
        ScrollableContainerNode.$stable = 8;
    }

    public ScrollableContainerNode(boolean arg2) {
        super();
        this.traverseKey = ScrollableContainerNode.TraverseKey;
        this.enabled = arg2;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void update(boolean arg1) {
        this.enabled = arg1;
    }
}

