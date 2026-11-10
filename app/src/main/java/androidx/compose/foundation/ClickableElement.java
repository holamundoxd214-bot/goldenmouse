package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001A\u00020\u0002H\u0016J\u0010\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u0010*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001A\u00020\b2\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/ClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ClickableElement extends ModifierNodeElement {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0 onClick;
    private final String onClickLabel;
    private final Role role;
    private final boolean useLocalIndication;

    private ClickableElement(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7) {
        super();
        this.interactionSource = arg1;
        this.indicationNodeFactory = arg2;
        this.useLocalIndication = arg3;
        this.enabled = arg4;
        this.onClickLabel = arg5;
        this.role = arg6;
        this.onClick = arg7;
    }

    public ClickableElement(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, this.onClick, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ClickableElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((ClickableElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.indicationNodeFactory, ((ClickableElement)arg5).indicationNodeFactory)) {
            return 0;
        }

        if(this.useLocalIndication != ((ClickableElement)arg5).useLocalIndication) {
            return 0;
        }

        if(this.enabled != ((ClickableElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onClickLabel, ((ClickableElement)arg5).onClickLabel)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.role, ((ClickableElement)arg5).role)) {
            return 0;
        }

        if(this.onClick != ((ClickableElement)arg5).onClick) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        MutableInteractionSource v0 = this.interactionSource;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        IndicationNodeFactory v2 = this.indicationNodeFactory;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (((v0_1 + v2_1) * 0x1F + Boolean.hashCode(this.useLocalIndication)) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        String v2_2 = this.onClickLabel;
        v2_1 = v2_2 != null ? v2_2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Role v2_3 = this.role;
        if(v2_3 != null) {
            v1 = Role.hashCode-impl(v2_3.unbox-impl());
        }

        return (v0_1 + v1) * 0x1F + this.onClick.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("clickable");
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("onClick", this.onClick);
        arg4.getProperties().set("onClickLabel", this.onClickLabel);
        arg4.getProperties().set("role", this.role);
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
    }

    public void update(ClickableNode arg9) {
        arg9.update-O2vRcR0(this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    public void update(Node arg1) {
        this.update(((ClickableNode)arg1));
    }
}

