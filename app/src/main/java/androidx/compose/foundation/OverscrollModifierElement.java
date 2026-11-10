package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\f\u0010\u0011\u001A\u00020\t*\u00020\u0012H\u0016R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/OverscrollModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/OverscrollModifierNode;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/OverscrollEffect;)V", "create", "update", "", "node", "equals", "", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class OverscrollModifierElement extends ModifierNodeElement {
    private final OverscrollEffect overscrollEffect;

    public OverscrollModifierElement(OverscrollEffect arg1) {
        super();
        this.overscrollEffect = arg1;
    }

    public OverscrollModifierNode create() {
        OverscrollEffect v1 = this.overscrollEffect;
        DelegatableNode v1_1 = v1 != null ? v1.getNode() : null;
        return new OverscrollModifierNode(v1_1);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((OverscrollModifierElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof OverscrollModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overscrollEffect, ((OverscrollModifierElement)arg4).overscrollEffect)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        OverscrollEffect v0 = this.overscrollEffect;
        if(v0 != null) {
            return v0.hashCode();
        }

        return 0;
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("overscroll");
        arg2.getProperties().set("overscrollEffect", this.overscrollEffect);
    }

    public void update(OverscrollModifierNode arg1) {
        OverscrollEffect v0 = this.overscrollEffect;
        DelegatableNode v0_1 = v0 != null ? v0.getNode() : null;
        arg1.update(v0_1);
    }

    public void update(Node arg1) {
        this.update(((OverscrollModifierNode)arg1));
    }
}

