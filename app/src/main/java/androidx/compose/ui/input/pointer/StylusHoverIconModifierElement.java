package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0002H\u0016J\f\u0010\u0015\u001A\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u00062\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DHÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\""}, d2={"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "touchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "getOverrideDescendants", "()Z", "getTouchBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StylusHoverIconModifierElement extends ModifierNodeElement {
    public static final int $stable;
    private final PointerIcon icon;
    private final boolean overrideDescendants;
    private final DpTouchBoundsExpansion touchBoundsExpansion;

    static {
    }

    public StylusHoverIconModifierElement(PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3) {
        super();
        this.icon = arg1;
        this.overrideDescendants = arg2;
        this.touchBoundsExpansion = arg3;
    }

    public StylusHoverIconModifierElement(PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, false, arg3);
    }

    public final PointerIcon component1() {
        return this.icon;
    }

    public final boolean component2() {
        return this.overrideDescendants;
    }

    public final DpTouchBoundsExpansion component3() {
        return this.touchBoundsExpansion;
    }

    public final StylusHoverIconModifierElement copy(PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3) {
        return new StylusHoverIconModifierElement(arg1, arg2, arg3);
    }

    public static StylusHoverIconModifierElement copy$default(StylusHoverIconModifierElement arg0, PointerIcon arg1, boolean arg2, DpTouchBoundsExpansion arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.icon;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.overrideDescendants;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.touchBoundsExpansion;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public Node create() {
        return this.create();
    }

    public StylusHoverIconModifierNode create() {
        return new StylusHoverIconModifierNode(this.icon, this.overrideDescendants, this.touchBoundsExpansion);
    }

    public boolean equals(Object arg5) {
        if(this == (((StylusHoverIconModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StylusHoverIconModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.icon, ((StylusHoverIconModifierElement)arg5).icon)) {
            return 0;
        }

        if(this.overrideDescendants != ((StylusHoverIconModifierElement)arg5).overrideDescendants) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.touchBoundsExpansion, ((StylusHoverIconModifierElement)arg5).touchBoundsExpansion)) {
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

    public final DpTouchBoundsExpansion getTouchBoundsExpansion() {
        return this.touchBoundsExpansion;
    }

    public int hashCode() {
        int v0 = (this.icon.hashCode() * 0x1F + Boolean.hashCode(this.overrideDescendants)) * 0x1F;
        DpTouchBoundsExpansion v2 = this.touchBoundsExpansion;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("stylusHoverIcon");
        arg4.getProperties().set("icon", this.icon);
        arg4.getProperties().set("overrideDescendants", Boolean.valueOf(this.overrideDescendants));
        arg4.getProperties().set("touchBoundsExpansion", this.touchBoundsExpansion);
    }

    public String toString() {
        return "StylusHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ", touchBoundsExpansion=" + this.touchBoundsExpansion + ')';
    }

    public void update(Node arg1) {
        this.update(((StylusHoverIconModifierNode)arg1));
    }

    public void update(StylusHoverIconModifierNode arg2) {
        arg2.setIcon(this.icon);
        arg2.setOverrideDescendants(this.overrideDescendants);
        arg2.setDpTouchBoundsExpansion(this.touchBoundsExpansion);
    }
}

