package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001A\u00020\u000BX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "getPrefetchState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "setPrefetchState", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TraversablePrefetchStateNode extends Node implements TraversableNode {
    private LazyLayoutPrefetchState prefetchState;
    private final String traverseKey;

    public TraversablePrefetchStateNode(LazyLayoutPrefetchState arg1) {
        super();
        this.prefetchState = arg1;
        this.traverseKey = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";
    }

    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    public Object getTraverseKey() {
        return this.getTraverseKey();
    }

    public String getTraverseKey() {
        return this.traverseKey;
    }

    public final void setPrefetchState(LazyLayoutPrefetchState arg1) {
        this.prefetchState = arg1;
    }
}

