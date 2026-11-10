package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0002H\u0016J\f\u0010\u0015\u001A\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\'\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EHÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006#"}, d2={"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "serviceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "getServiceAdapter", "()Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LegacyAdaptingPlatformTextInputModifier extends ModifierNodeElement {
    private final LegacyTextFieldState legacyTextFieldState;
    private final LegacyPlatformTextInputServiceAdapter serviceAdapter;
    private final TextFieldSelectionManager textFieldSelectionManager;

    public LegacyAdaptingPlatformTextInputModifier(LegacyPlatformTextInputServiceAdapter arg1, LegacyTextFieldState arg2, TextFieldSelectionManager arg3) {
        super();
        this.serviceAdapter = arg1;
        this.legacyTextFieldState = arg2;
        this.textFieldSelectionManager = arg3;
    }

    public final LegacyPlatformTextInputServiceAdapter component1() {
        return this.serviceAdapter;
    }

    public final LegacyTextFieldState component2() {
        return this.legacyTextFieldState;
    }

    public final TextFieldSelectionManager component3() {
        return this.textFieldSelectionManager;
    }

    public final LegacyAdaptingPlatformTextInputModifier copy(LegacyPlatformTextInputServiceAdapter arg1, LegacyTextFieldState arg2, TextFieldSelectionManager arg3) {
        return new LegacyAdaptingPlatformTextInputModifier(arg1, arg2, arg3);
    }

    public static LegacyAdaptingPlatformTextInputModifier copy$default(LegacyAdaptingPlatformTextInputModifier arg0, LegacyPlatformTextInputServiceAdapter arg1, LegacyTextFieldState arg2, TextFieldSelectionManager arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.serviceAdapter;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.legacyTextFieldState;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.textFieldSelectionManager;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public LegacyAdaptingPlatformTextInputModifierNode create() {
        return new LegacyAdaptingPlatformTextInputModifierNode(this.serviceAdapter, this.legacyTextFieldState, this.textFieldSelectionManager);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LegacyAdaptingPlatformTextInputModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.serviceAdapter, ((LegacyAdaptingPlatformTextInputModifier)arg5).serviceAdapter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.legacyTextFieldState, ((LegacyAdaptingPlatformTextInputModifier)arg5).legacyTextFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldSelectionManager, ((LegacyAdaptingPlatformTextInputModifier)arg5).textFieldSelectionManager)) {
            return 0;
        }

        return 1;
    }

    public final LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    public final LegacyPlatformTextInputServiceAdapter getServiceAdapter() {
        return this.serviceAdapter;
    }

    public final TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    public int hashCode() {
        return (this.serviceAdapter.hashCode() * 0x1F + this.legacyTextFieldState.hashCode()) * 0x1F + this.textFieldSelectionManager.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.serviceAdapter + ", legacyTextFieldState=" + this.legacyTextFieldState + ", textFieldSelectionManager=" + this.textFieldSelectionManager + ')';
    }

    public void update(LegacyAdaptingPlatformTextInputModifierNode arg2) {
        arg2.setServiceAdapter(this.serviceAdapter);
        arg2.setLegacyTextFieldState(this.legacyTextFieldState);
        arg2.setTextFieldSelectionManager(this.textFieldSelectionManager);
    }

    public void update(Node arg1) {
        this.update(((LegacyAdaptingPlatformTextInputModifierNode)arg1));
    }
}

