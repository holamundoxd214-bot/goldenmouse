package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0002H\u0016J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0002H\u0016J\f\u0010\t\u001A\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/viewinterop/FocusTargetInteropElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/viewinterop/FocusTargetInteropNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusTargetInteropElement extends ModifierNodeElement {
    public static final FocusTargetInteropElement INSTANCE;

    static {
        FocusTargetInteropElement.INSTANCE = new FocusTargetInteropElement();
    }

    private FocusTargetInteropElement() {
        super();
    }

    public Node create() {
        return this.create();
    }

    public FocusTargetInteropNode create() {
        return new FocusTargetInteropNode();
    }

    public boolean equals(Object arg1) {
        if((((FocusTargetInteropElement)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return "focusTargetInterop".hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("focusTargetInterop");
    }

    public void update(Node arg1) {
        this.update(((FocusTargetInteropNode)arg1));
    }

    public void update(FocusTargetInteropNode arg1) {
    }
}

