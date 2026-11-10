package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\f\u0010\u000B\u001A\u00020\t*\u00020\fH\u0016J\t\u0010\r\u001A\u00020\u0004HÂ\u0003J\u0013\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/ui/layout/LayoutIdElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutIdModifier;", "layoutId", "", "<init>", "(Ljava/lang/Object;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LayoutIdElement extends ModifierNodeElement {
    private final Object layoutId;

    public LayoutIdElement(Object arg1) {
        super();
        this.layoutId = arg1;
    }

    private final Object component1() {
        return this.layoutId;
    }

    public final LayoutIdElement copy(Object arg1) {
        return new LayoutIdElement(arg1);
    }

    public static LayoutIdElement copy$default(LayoutIdElement arg0, Object arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.layoutId;
        }

        return arg0.copy(arg1);
    }

    public Node create() {
        return this.create();
    }

    public LayoutIdModifier create() {
        return new LayoutIdModifier(this.layoutId);
    }

    public boolean equals(Object arg4) {
        if(this == (((LayoutIdElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof LayoutIdElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.layoutId, ((LayoutIdElement)arg4).layoutId)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.layoutId.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("layoutId");
        arg2.setValue(this.layoutId);
    }

    public String toString() {
        return "LayoutIdElement(layoutId=" + this.layoutId + ')';
    }

    public void update(Node arg1) {
        this.update(((LayoutIdModifier)arg1));
    }

    public void update(LayoutIdModifier arg1) {
        arg1.setLayoutId$ui(this.layoutId);
    }
}

