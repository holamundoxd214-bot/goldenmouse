package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016J\t\u0010\u0013\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\u001D\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001D"}, d2={"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "getOverrideDescendants", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerHoverIconModifierElement extends ModifierNodeElement {
    public static final int $stable;
    private final PointerIcon icon;
    private final boolean overrideDescendants;

    static {
    }

    public PointerHoverIconModifierElement(PointerIcon arg1, boolean arg2) {
        super();
        this.icon = arg1;
        this.overrideDescendants = arg2;
    }

    public PointerHoverIconModifierElement(PointerIcon arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, false);
    }

    public final PointerIcon component1() {
        return this.icon;
    }

    public final boolean component2() {
        return this.overrideDescendants;
    }

    public final PointerHoverIconModifierElement copy(PointerIcon arg1, boolean arg2) {
        return new PointerHoverIconModifierElement(arg1, arg2);
    }

    public static PointerHoverIconModifierElement copy$default(PointerHoverIconModifierElement arg0, PointerIcon arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.icon;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.overrideDescendants;
        }

        return arg0.copy(arg1, arg2);
    }

    public Node create() {
        return this.create();
    }

    public PointerHoverIconModifierNode create() {
        return new PointerHoverIconModifierNode(this.icon, this.overrideDescendants);
    }

    public boolean equals(Object arg5) {
        if(this == (((PointerHoverIconModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PointerHoverIconModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.icon, ((PointerHoverIconModifierElement)arg5).icon)) {
            return 0;
        }

        if(this.overrideDescendants != ((PointerHoverIconModifierElement)arg5).overrideDescendants) {
            return 0;
        }

        return 1;
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    public int hashCode() {
        return this.icon.hashCode() * 0x1F + Boolean.hashCode(this.overrideDescendants);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("pointerHoverIcon");
        arg4.getProperties().set("icon", this.icon);
        arg4.getProperties().set("overrideDescendants", Boolean.valueOf(this.overrideDescendants));
    }

    public String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ')';
    }

    public void update(Node arg1) {
        this.update(((PointerHoverIconModifierNode)arg1));
    }

    public void update(PointerHoverIconModifierNode arg2) {
        arg2.setIcon(this.icon);
        arg2.setOverrideDescendants(this.overrideDescendants);
    }
}

