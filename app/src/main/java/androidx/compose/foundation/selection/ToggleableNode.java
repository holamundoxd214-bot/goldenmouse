package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.autofill.FillableData_androidKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0004\b\u000F\u0010\u0010JU\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00032\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u0016J\f\u0010\u0017\u001A\u00020\u000E*\u00020\u0018H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/selection/ToggleableNode;", "Landroidx/compose/foundation/ClickableNode;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "<init>", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_onClick", "Lkotlin/Function0;", "get_onClick", "()Lkotlin/jvm/functions/Function0;", "update", "update-O2vRcR0", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ToggleableNode extends ClickableNode {
    private final Function0 _onClick;
    private Function1 onValueChange;
    private boolean value;

    public ToggleableNode(boolean arg1, MutableInteractionSource arg2, IndicationNodeFactory arg3, boolean arg4, boolean arg5, Role arg6, Function1 arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private ToggleableNode(boolean arg11, MutableInteractionSource arg12, IndicationNodeFactory arg13, boolean arg14, boolean arg15, Role arg16, Function1 arg17) {
        super(arg12, arg13, arg14, arg15, null, arg16, new ToggleableNode$$ExternalSyntheticLambda1(arg17, arg11), null);
        this.value = arg11;
        this.onValueChange = arg17;
        this._onClick = new ToggleableNode$$ExternalSyntheticLambda2(this);
    }

    static final Unit _init_$lambda$0(Function1 arg0, boolean arg1) {
        arg0.invoke(Boolean.valueOf((((int)arg1)) ^ 1));
        return Unit.INSTANCE;
    }

    static final Unit _onClick$lambda$0(ToggleableNode arg1) {
        arg1.onValueChange.invoke(Boolean.valueOf(arg1.value ^ 1));
        return Unit.INSTANCE;
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setToggleableState(arg3, ToggleableStateKt.ToggleableState(this.value));
        SemanticsPropertiesKt.setContentDataType(arg3, ContentDataType.Companion.getToggle());
        FillableData v2 = FillableData_androidKt.createFromBoolean(FillableData.Companion, this.value);
        if(v2 != null) {
            SemanticsPropertiesKt.setFillableData(arg3, v2);
        }

        SemanticsPropertiesKt.onFillData$default(arg3, null, new ToggleableNode$$ExternalSyntheticLambda0(arg3), 1, null);
    }

    static final boolean applyAdditionalSemantics$lambda$1(SemanticsPropertyReceiver arg0, FillableData arg1) {
        Boolean v1 = arg1.getBooleanValue();
        if(v1 != null) {
            SemanticsPropertiesKt.setToggleableState(arg0, ToggleableStateKt.ToggleableState(v1.booleanValue()));
            return 1;
        }

        return 0;
    }

    public final Function0 get_onClick() {
        return this._onClick;
    }

    public final void update-O2vRcR0(boolean arg9, MutableInteractionSource arg10, IndicationNodeFactory arg11, boolean arg12, boolean arg13, Role arg14, Function1 arg15) {
        if(this.value != arg9) {
            this.value = arg9;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }

        this.onValueChange = arg15;
        super.update-O2vRcR0(arg10, arg11, arg12, arg13, null, arg14, this._onClick);
    }
}

