package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0002H\u0016J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0002H\u0016J\f\u0010\t\u001A\u00020\b*\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/ui/semantics/EmptySemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "node", "<init>", "(Landroidx/compose/ui/semantics/EmptySemanticsModifier;)V", "create", "update", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmptySemanticsElement extends ModifierNodeElement {
    public static final int $stable;
    private final EmptySemanticsModifier node;

    static {
    }

    public EmptySemanticsElement(EmptySemanticsModifier arg1) {
        super();
        this.node = arg1;
    }

    public Node create() {
        return this.create();
    }

    public EmptySemanticsModifier create() {
        return this.node;
    }

    public boolean equals(Object arg1) {
        if((((EmptySemanticsElement)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(Node arg1) {
        this.update(((EmptySemanticsModifier)arg1));
    }

    public void update(EmptySemanticsModifier arg1) {
    }
}

