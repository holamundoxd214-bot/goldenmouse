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

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u007F\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u000B\u0012\u000E\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F\u0012\u000E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F\u0012\u0006\u0010\u0014\u001A\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\f\u0010\u001A\u001A\u00020\u0010*\u00020\u001BH\u0016J\u0013\u0010\u001C\u001A\u00020\b2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class CombinedClickableElement extends ModifierNodeElement {
    private final boolean enabled;
    private final boolean hapticFeedbackEnabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0 onClick;
    private final String onClickLabel;
    private final Function0 onDoubleClick;
    private final Function0 onLongClick;
    private final String onLongClickLabel;
    private final Role role;
    private final boolean useLocalIndication;

    public CombinedClickableElement(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7, String arg8, Function0 arg9, Function0 arg10, boolean arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    private CombinedClickableElement(MutableInteractionSource arg1, IndicationNodeFactory arg2, boolean arg3, boolean arg4, String arg5, Role arg6, Function0 arg7, String arg8, Function0 arg9, Function0 arg10, boolean arg11) {
        super();
        this.interactionSource = arg1;
        this.indicationNodeFactory = arg2;
        this.useLocalIndication = arg3;
        this.enabled = arg4;
        this.onClickLabel = arg5;
        this.role = arg6;
        this.onClick = arg7;
        this.onLongClickLabel = arg8;
        this.onLongClick = arg9;
        this.onDoubleClick = arg10;
        this.hapticFeedbackEnabled = arg11;
    }

    public CombinedClickableNode create() {
        return new CombinedClickableNode(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.hapticFeedbackEnabled, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((CombinedClickableElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((CombinedClickableElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.indicationNodeFactory, ((CombinedClickableElement)arg5).indicationNodeFactory)) {
            return 0;
        }

        if(this.useLocalIndication != ((CombinedClickableElement)arg5).useLocalIndication) {
            return 0;
        }

        if(this.enabled != ((CombinedClickableElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onClickLabel, ((CombinedClickableElement)arg5).onClickLabel)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.role, ((CombinedClickableElement)arg5).role)) {
            return 0;
        }

        if(this.onClick != ((CombinedClickableElement)arg5).onClick) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onLongClickLabel, ((CombinedClickableElement)arg5).onLongClickLabel)) {
            return 0;
        }

        if(this.onLongClick != ((CombinedClickableElement)arg5).onLongClick) {
            return 0;
        }

        if(this.onDoubleClick != ((CombinedClickableElement)arg5).onDoubleClick) {
            return 0;
        }

        if(this.hapticFeedbackEnabled != ((CombinedClickableElement)arg5).hapticFeedbackEnabled) {
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
        v2_1 = v2_3 != null ? Role.hashCode-impl(v2_3.unbox-impl()) : 0;
        v0_1 = ((v0_1 + v2_1) * 0x1F + this.onClick.hashCode()) * 0x1F;
        v2_2 = this.onLongClickLabel;
        v2_1 = v2_2 != null ? v2_2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Function0 v2_4 = this.onLongClick;
        v2_1 = v2_4 != null ? v2_4.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2_4 = this.onDoubleClick;
        if(v2_4 != null) {
            v1 = v2_4.hashCode();
        }

        return (v0_1 + v1) * 0x1F + Boolean.hashCode(this.hapticFeedbackEnabled);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("combinedClickable");
        arg4.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("onClickLabel", this.onClickLabel);
        arg4.getProperties().set("role", this.role);
        arg4.getProperties().set("onClick", this.onClick);
        arg4.getProperties().set("onDoubleClick", this.onDoubleClick);
        arg4.getProperties().set("onLongClick", this.onLongClick);
        arg4.getProperties().set("onLongClickLabel", this.onLongClickLabel);
        arg4.getProperties().set("hapticFeedbackEnabled", Boolean.valueOf(this.hapticFeedbackEnabled));
    }

    public void update(CombinedClickableNode arg13) {
        arg13.setHapticFeedbackEnabled(this.hapticFeedbackEnabled);
        arg13.update-2tQrsxU(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.onClickLabel, this.role);
    }

    public void update(Node arg1) {
        this.update(((CombinedClickableNode)arg1));
    }
}

