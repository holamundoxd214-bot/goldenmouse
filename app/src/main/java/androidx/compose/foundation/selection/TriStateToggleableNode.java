package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.FillableData$Companion;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.autofill.FillableData_androidKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011JO\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0002\b\u0013J\f\u0010\u0014\u001A\u00020\u000F*\u00020\u0015H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/selection/TriStateToggleableNode;", "Landroidx/compose/foundation/ClickableNode;", "state", "Landroidx/compose/ui/state/ToggleableState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-O2vRcR0", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TriStateToggleableNode extends ClickableNode {
    private ToggleableState state;

    public TriStateToggleableNode(ToggleableState arg1, MutableInteractionSource arg2, IndicationNodeFactory arg3, boolean arg4, boolean arg5, Role arg6, Function0 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private TriStateToggleableNode(ToggleableState arg10, MutableInteractionSource arg11, IndicationNodeFactory arg12, boolean arg13, boolean arg14, Role arg15, Function0 arg16) {
        super(arg11, arg12, arg13, arg14, null, arg15, arg16, null);
        this.state = arg10;
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.setToggleableState(arg4, this.state);
        SemanticsPropertiesKt.setContentDataType(arg4, ContentDataType.Companion.getToggle());
        Companion v0 = FillableData.Companion;
        boolean v3 = this.state != ToggleableState.Indeterminate ? true : false;
        FillableData v3_1 = FillableData_androidKt.createFromBoolean(v0, v3);
        if(v3_1 != null) {
            SemanticsPropertiesKt.setFillableData(arg4, v3_1);
        }

        SemanticsPropertiesKt.onFillData$default(arg4, null, new TriStateToggleableNode$$ExternalSyntheticLambda0(arg4), 1, null);
    }

    static final boolean applyAdditionalSemantics$lambda$1(SemanticsPropertyReceiver arg0, FillableData arg1) {
        Boolean v1 = arg1.getBooleanValue();
        if(v1 != null) {
            SemanticsPropertiesKt.setToggleableState(arg0, ToggleableStateKt.ToggleableState(v1.booleanValue()));
            return 1;
        }

        return 0;
    }

    public final void update-O2vRcR0(ToggleableState arg9, MutableInteractionSource arg10, IndicationNodeFactory arg11, boolean arg12, boolean arg13, Role arg14, Function0 arg15) {
        if(this.state != arg9) {
            this.state = arg9;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        super.update-O2vRcR0(arg10, arg11, arg12, arg13, null, arg14, arg15);
    }
}

