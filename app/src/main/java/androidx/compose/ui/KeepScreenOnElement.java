package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÂ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0002H\u0016J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0002H\u0016J\f\u0010\t\u001A\u00020\u0007*\u00020\nH\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001¨\u0006\u0013"}, d2={"Landroidx/compose/ui/KeepScreenOnElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/KeepScreenOnNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeepScreenOnElement extends ModifierNodeElement {
    public static final KeepScreenOnElement INSTANCE;

    static {
        KeepScreenOnElement.INSTANCE = new KeepScreenOnElement();
    }

    private KeepScreenOnElement() {
        super();
    }

    public KeepScreenOnNode create() {
        return new KeepScreenOnNode();
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        if(this == (((KeepScreenOnElement)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof KeepScreenOnElement)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return 0xFAFD0ED3;
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("keepScreenOn");
    }

    public String toString() {
        return "KeepScreenOnElement";
    }

    public void update(KeepScreenOnNode arg1) {
    }

    public void update(Node arg1) {
        this.update(((KeepScreenOnNode)arg1));
    }
}

