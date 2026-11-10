package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0002H\u0016J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\f\u0010\u000F\u001A\u00020\r*\u00020\u0010H\u0016¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "<init>", "()V", "create", "hashCode", "", "equals", "", "other", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class RecalculateWindowInsetsModifierElement extends ModifierNodeElement {
    public static final RecalculateWindowInsetsModifierElement INSTANCE;

    static {
        RecalculateWindowInsetsModifierElement.INSTANCE = new RecalculateWindowInsetsModifierElement();
    }

    private RecalculateWindowInsetsModifierElement() {
        super();
    }

    public RecalculateWindowInsetsModifierNode create() {
        return new RecalculateWindowInsetsModifierNode();
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg1) {
        if((((RecalculateWindowInsetsModifierElement)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return 0;
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("recalculateWindowInsets");
    }

    public void update(RecalculateWindowInsetsModifierNode arg1) {
    }

    public void update(Node arg1) {
        this.update(((RecalculateWindowInsetsModifierNode)arg1));
    }
}

