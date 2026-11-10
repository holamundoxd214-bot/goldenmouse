package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\f\u0010\u000B\u001A\u00020\t*\u00020\fH\u0016J\t\u0010\r\u001A\u00020\u0004HÂ\u0003J\u0013\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TraversablePrefetchStateModifierElement extends ModifierNodeElement {
    private final LazyLayoutPrefetchState prefetchState;

    public TraversablePrefetchStateModifierElement(LazyLayoutPrefetchState arg1) {
        super();
        this.prefetchState = arg1;
    }

    private final LazyLayoutPrefetchState component1() {
        return this.prefetchState;
    }

    public final TraversablePrefetchStateModifierElement copy(LazyLayoutPrefetchState arg1) {
        return new TraversablePrefetchStateModifierElement(arg1);
    }

    public static TraversablePrefetchStateModifierElement copy$default(TraversablePrefetchStateModifierElement arg0, LazyLayoutPrefetchState arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.prefetchState;
        }

        return arg0.copy(arg1);
    }

    public TraversablePrefetchStateNode create() {
        return new TraversablePrefetchStateNode(this.prefetchState);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((TraversablePrefetchStateModifierElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof TraversablePrefetchStateModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.prefetchState, ((TraversablePrefetchStateModifierElement)arg4).prefetchState)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.prefetchState.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("traversablePrefetchState");
        arg2.setValue(this.prefetchState);
    }

    public String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.prefetchState + ')';
    }

    public void update(TraversablePrefetchStateNode arg1) {
        arg1.setPrefetchState(this.prefetchState);
    }

    public void update(Node arg1) {
        this.update(((TraversablePrefetchStateNode)arg1));
    }
}

