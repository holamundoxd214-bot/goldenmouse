package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010(\u001A\u00020\u0002H\u0016J\u0010\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0002H\u0016J\f\u0010,\u001A\u00020**\u00020-H\u0016J\t\u0010.\u001A\u00020\u0004HÆ\u0003J\t\u0010/\u001A\u00020\u0006HÆ\u0003J\t\u00100\u001A\u00020\bHÆ\u0003J\t\u00101\u001A\u00020\nHÆ\u0003J\t\u00102\u001A\u00020\nHÆ\u0003J\t\u00103\u001A\u00020\nHÆ\u0003J\t\u00104\u001A\u00020\u000EHÆ\u0003J\t\u00105\u001A\u00020\u0010HÆ\u0003J\t\u00106\u001A\u00020\u0012HÆ\u0003J\t\u00107\u001A\u00020\u0014HÆ\u0003Jm\u00108\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\f\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u0014HÆ\u0001J\u0013\u00109\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001A\u00020=HÖ\u0001J\t\u0010>\u001A\u00020?HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u000B\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001ER\u0011\u0010\f\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u001ER\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u0011\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'¨\u0006@"}, d2={"Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifierNode;", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "readOnly", "", "enabled", "isPassword", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/text/input/TransformedText;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/LegacyTextFieldState;ZZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/focus/FocusRequester;)V", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getReadOnly", "()Z", "getEnabled", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getImeOptions", "()Landroidx/compose/ui/text/input/ImeOptions;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CoreTextFieldSemanticsModifier extends ModifierNodeElement {
    public static final int $stable;
    private final boolean enabled;
    private final FocusRequester focusRequester;
    private final ImeOptions imeOptions;
    private final boolean isPassword;
    private final TextFieldSelectionManager manager;
    private final OffsetMapping offsetMapping;
    private final boolean readOnly;
    private final LegacyTextFieldState state;
    private final TransformedText transformedText;
    private final TextFieldValue value;

    static {
    }

    public CoreTextFieldSemanticsModifier(TransformedText arg1, TextFieldValue arg2, LegacyTextFieldState arg3, boolean arg4, boolean arg5, boolean arg6, OffsetMapping arg7, TextFieldSelectionManager arg8, ImeOptions arg9, FocusRequester arg10) {
        super();
        this.transformedText = arg1;
        this.value = arg2;
        this.state = arg3;
        this.readOnly = arg4;
        this.enabled = arg5;
        this.isPassword = arg6;
        this.offsetMapping = arg7;
        this.manager = arg8;
        this.imeOptions = arg9;
        this.focusRequester = arg10;
    }

    public final TransformedText component1() {
        return this.transformedText;
    }

    public final FocusRequester component10() {
        return this.focusRequester;
    }

    public final TextFieldValue component2() {
        return this.value;
    }

    public final LegacyTextFieldState component3() {
        return this.state;
    }

    public final boolean component4() {
        return this.readOnly;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final boolean component6() {
        return this.isPassword;
    }

    public final OffsetMapping component7() {
        return this.offsetMapping;
    }

    public final TextFieldSelectionManager component8() {
        return this.manager;
    }

    public final ImeOptions component9() {
        return this.imeOptions;
    }

    public final CoreTextFieldSemanticsModifier copy(TransformedText arg1, TextFieldValue arg2, LegacyTextFieldState arg3, boolean arg4, boolean arg5, boolean arg6, OffsetMapping arg7, TextFieldSelectionManager arg8, ImeOptions arg9, FocusRequester arg10) {
        return new CoreTextFieldSemanticsModifier(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static CoreTextFieldSemanticsModifier copy$default(CoreTextFieldSemanticsModifier arg0, TransformedText arg1, TextFieldValue arg2, LegacyTextFieldState arg3, boolean arg4, boolean arg5, boolean arg6, OffsetMapping arg7, TextFieldSelectionManager arg8, ImeOptions arg9, FocusRequester arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = arg0.transformedText;
        }

        if((arg11 & 2) != 0) {
            arg2 = arg0.value;
        }

        if((arg11 & 4) != 0) {
            arg3 = arg0.state;
        }

        if((arg11 & 8) != 0) {
            arg4 = arg0.readOnly;
        }

        if((arg11 & 16) != 0) {
            arg5 = arg0.enabled;
        }

        if((arg11 & 0x20) != 0) {
            arg6 = arg0.isPassword;
        }

        if((arg11 & 0x40) != 0) {
            arg7 = arg0.offsetMapping;
        }

        if((arg11 & 0x80) != 0) {
            arg8 = arg0.manager;
        }

        if((arg11 & 0x100) != 0) {
            arg9 = arg0.imeOptions;
        }

        if((arg11 & 0x200) != 0) {
            arg10 = arg0.focusRequester;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public CoreTextFieldSemanticsModifierNode create() {
        return new CoreTextFieldSemanticsModifierNode(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((CoreTextFieldSemanticsModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CoreTextFieldSemanticsModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.transformedText, ((CoreTextFieldSemanticsModifier)arg5).transformedText)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((CoreTextFieldSemanticsModifier)arg5).value)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((CoreTextFieldSemanticsModifier)arg5).state)) {
            return 0;
        }

        if(this.readOnly != ((CoreTextFieldSemanticsModifier)arg5).readOnly) {
            return 0;
        }

        if(this.enabled != ((CoreTextFieldSemanticsModifier)arg5).enabled) {
            return 0;
        }

        if(this.isPassword != ((CoreTextFieldSemanticsModifier)arg5).isPassword) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.offsetMapping, ((CoreTextFieldSemanticsModifier)arg5).offsetMapping)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.manager, ((CoreTextFieldSemanticsModifier)arg5).manager)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.imeOptions, ((CoreTextFieldSemanticsModifier)arg5).imeOptions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.focusRequester, ((CoreTextFieldSemanticsModifier)arg5).focusRequester)) {
            return 0;
        }

        return 1;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final ImeOptions getImeOptions() {
        return this.imeOptions;
    }

    public final TextFieldSelectionManager getManager() {
        return this.manager;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((((((this.transformedText.hashCode() * 0x1F + this.value.hashCode()) * 0x1F + this.state.hashCode()) * 0x1F + Boolean.hashCode(this.readOnly)) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F + Boolean.hashCode(this.isPassword)) * 0x1F + this.offsetMapping.hashCode()) * 0x1F + this.manager.hashCode()) * 0x1F + this.imeOptions.hashCode()) * 0x1F + this.focusRequester.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    public String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.transformedText + ", value=" + this.value + ", state=" + this.state + ", readOnly=" + this.readOnly + ", enabled=" + this.enabled + ", isPassword=" + this.isPassword + ", offsetMapping=" + this.offsetMapping + ", manager=" + this.manager + ", imeOptions=" + this.imeOptions + ", focusRequester=" + this.focusRequester + ')';
    }

    public void update(CoreTextFieldSemanticsModifierNode arg12) {
        arg12.updateNodeSemantics(this.transformedText, this.value, this.state, this.readOnly, this.enabled, this.isPassword, this.offsetMapping, this.manager, this.imeOptions, this.focusRequester);
    }

    public void update(Node arg1) {
        this.update(((CoreTextFieldSemanticsModifierNode)arg1));
    }
}

