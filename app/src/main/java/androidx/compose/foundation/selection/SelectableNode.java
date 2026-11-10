package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0004\b\u000F\u0010\u0010JO\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00032\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u0012J\f\u0010\u0013\u001A\u00020\u000E*\u00020\u0014H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/selection/SelectableNode;", "Landroidx/compose/foundation/ClickableNode;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-O2vRcR0", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SelectableNode extends ClickableNode {
    private boolean selected;

    public SelectableNode(boolean arg1, MutableInteractionSource arg2, IndicationNodeFactory arg3, boolean arg4, boolean arg5, Role arg6, Function0 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private SelectableNode(boolean arg10, MutableInteractionSource arg11, IndicationNodeFactory arg12, boolean arg13, boolean arg14, Role arg15, Function0 arg16) {
        super(arg11, arg12, arg13, arg14, null, arg15, arg16, null);
        this.selected = arg10;
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setSelected(arg1, this.selected);
    }

    public final void update-O2vRcR0(boolean arg9, MutableInteractionSource arg10, IndicationNodeFactory arg11, boolean arg12, boolean arg13, Role arg14, Function0 arg15) {
        if(this.selected != arg9) {
            this.selected = arg9;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        super.update-O2vRcR0(arg10, arg11, arg12, arg13, null, arg14, arg15);
    }
}

