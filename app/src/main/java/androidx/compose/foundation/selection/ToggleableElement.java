package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\u0004\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0002H\u0016J\f\u0010\u0015\u001A\u00020\u000F*\u00020\u0016H\u0016J\u0013\u0010\u0017\u001A\u00020\u00042\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/selection/ToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/ToggleableNode;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "<init>", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ToggleableElement extends ModifierNodeElement {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function1 onValueChange;
    private final Role role;
    private final boolean useLocalIndication;
    private final boolean value;

    private ToggleableElement(boolean arg1, MutableInteractionSource arg2, IndicationNodeFactory arg3, boolean arg4, boolean arg5, Role arg6, Function1 arg7) {
        super();
        this.value = arg1;
        this.interactionSource = arg2;
        this.indicationNodeFactory = arg3;
        this.useLocalIndication = arg4;
        this.enabled = arg5;
        this.role = arg6;
        this.onValueChange = arg7;
    }

    public ToggleableElement(boolean arg1, MutableInteractionSource arg2, IndicationNodeFactory arg3, boolean arg4, boolean arg5, Role arg6, Function1 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public ToggleableNode create() {
        return new ToggleableNode(this.value, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onValueChange, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ToggleableElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(this.value != ((ToggleableElement)arg5).value) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((ToggleableElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.indicationNodeFactory, ((ToggleableElement)arg5).indicationNodeFactory)) {
            return 0;
        }

        if(this.useLocalIndication != ((ToggleableElement)arg5).useLocalIndication) {
            return 0;
        }

        if(this.enabled != ((ToggleableElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.role, ((ToggleableElement)arg5).role)) {
            return 0;
        }

        if(this.onValueChange != ((ToggleableElement)arg5).onValueChange) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = Boolean.hashCode(this.value) * 0x1F;
        MutableInteractionSource v1 = this.interactionSource;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        IndicationNodeFactory v1_2 = this.indicationNodeFactory;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (((v0 + v1_1) * 0x1F + Boolean.hashCode(this.useLocalIndication)) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        Role v1_3 = this.role;
        if(v1_3 != null) {
            v2 = Role.hashCode-impl(v1_3.unbox-impl());
        }

        return (v0 + v2) * 0x1F + this.onValueChange.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("toggleable");
        arg4.getProperties().set("value", arg4.getValue());
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("role", this.role);
        arg4.getProperties().set("onValueChange", this.onValueChange);
    }

    public void update(ToggleableNode arg9) {
        arg9.update-O2vRcR0(this.value, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onValueChange);
    }

    public void update(Node arg1) {
        this.update(((ToggleableNode)arg1));
    }
}

