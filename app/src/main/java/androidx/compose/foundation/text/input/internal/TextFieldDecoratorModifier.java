package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001A\u00020\f\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\f\u0012\u000E\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u0002H\u0016J\u0010\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u0002H\u0016J\f\u0010\u001E\u001A\u00020\u0018*\u00020\u001FH\u0016J\t\u0010 \u001A\u00020\u0004HÂ\u0003J\t\u0010!\u001A\u00020\u0006HÂ\u0003J\t\u0010\"\u001A\u00020\bHÂ\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\nHÂ\u0003J\t\u0010$\u001A\u00020\fHÂ\u0003J\t\u0010%\u001A\u00020\fHÂ\u0003J\t\u0010&\u001A\u00020\u000FHÂ\u0003J\u000B\u0010\'\u001A\u0004\u0018\u00010\u0011HÂ\u0003J\t\u0010(\u001A\u00020\fHÂ\u0003J\t\u0010)\u001A\u00020\u0014HÂ\u0003J\t\u0010*\u001A\u00020\fHÂ\u0003J\u0011\u0010+\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÂ\u0003J\u008D\u0001\u0010,\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\f2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\f2\u0010\b\u0002\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0001J\u0013\u0010-\u001A\u00020\f2\b\u0010.\u001A\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001A\u000201HÖ\u0001J\t\u00102\u001A\u000203HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldDecoratorModifier extends ModifierNodeElement {
    public static final int $stable;
    private final boolean enabled;
    private final InputTransformation filter;
    private final MutableInteractionSource interactionSource;
    private final boolean isPassword;
    private final KeyboardActionHandler keyboardActionHandler;
    private final KeyboardOptions keyboardOptions;
    private final boolean readOnly;
    private final boolean singleLine;
    private final MutableSharedFlow stylusHandwritingTrigger;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    static {
    }

    public TextFieldDecoratorModifier(TransformedTextFieldState arg1, TextLayoutState arg2, TextFieldSelectionState arg3, InputTransformation arg4, boolean arg5, boolean arg6, KeyboardOptions arg7, KeyboardActionHandler arg8, boolean arg9, MutableInteractionSource arg10, boolean arg11, MutableSharedFlow arg12) {
        super();
        this.textFieldState = arg1;
        this.textLayoutState = arg2;
        this.textFieldSelectionState = arg3;
        this.filter = arg4;
        this.enabled = arg5;
        this.readOnly = arg6;
        this.keyboardOptions = arg7;
        this.keyboardActionHandler = arg8;
        this.singleLine = arg9;
        this.interactionSource = arg10;
        this.isPassword = arg11;
        this.stylusHandwritingTrigger = arg12;
    }

    private final TransformedTextFieldState component1() {
        return this.textFieldState;
    }

    private final MutableInteractionSource component10() {
        return this.interactionSource;
    }

    private final boolean component11() {
        return this.isPassword;
    }

    private final MutableSharedFlow component12() {
        return this.stylusHandwritingTrigger;
    }

    private final TextLayoutState component2() {
        return this.textLayoutState;
    }

    private final TextFieldSelectionState component3() {
        return this.textFieldSelectionState;
    }

    private final InputTransformation component4() {
        return this.filter;
    }

    private final boolean component5() {
        return this.enabled;
    }

    private final boolean component6() {
        return this.readOnly;
    }

    private final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    private final KeyboardActionHandler component8() {
        return this.keyboardActionHandler;
    }

    private final boolean component9() {
        return this.singleLine;
    }

    public final TextFieldDecoratorModifier copy(TransformedTextFieldState arg1, TextLayoutState arg2, TextFieldSelectionState arg3, InputTransformation arg4, boolean arg5, boolean arg6, KeyboardOptions arg7, KeyboardActionHandler arg8, boolean arg9, MutableInteractionSource arg10, boolean arg11, MutableSharedFlow arg12) {
        return new TextFieldDecoratorModifier(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public static TextFieldDecoratorModifier copy$default(TextFieldDecoratorModifier arg0, TransformedTextFieldState arg1, TextLayoutState arg2, TextFieldSelectionState arg3, InputTransformation arg4, boolean arg5, boolean arg6, KeyboardOptions arg7, KeyboardActionHandler arg8, boolean arg9, MutableInteractionSource arg10, boolean arg11, MutableSharedFlow arg12, int arg13, Object arg14) {
        if((arg13 & 1) != 0) {
            arg1 = arg0.textFieldState;
        }

        if((arg13 & 2) != 0) {
            arg2 = arg0.textLayoutState;
        }

        if((arg13 & 4) != 0) {
            arg3 = arg0.textFieldSelectionState;
        }

        if((arg13 & 8) != 0) {
            arg4 = arg0.filter;
        }

        if((arg13 & 16) != 0) {
            arg5 = arg0.enabled;
        }

        if((arg13 & 0x20) != 0) {
            arg6 = arg0.readOnly;
        }

        if((arg13 & 0x40) != 0) {
            arg7 = arg0.keyboardOptions;
        }

        if((arg13 & 0x80) != 0) {
            arg8 = arg0.keyboardActionHandler;
        }

        if((arg13 & 0x100) != 0) {
            arg9 = arg0.singleLine;
        }

        if((arg13 & 0x200) != 0) {
            arg10 = arg0.interactionSource;
        }

        if((arg13 & 0x400) != 0) {
            arg11 = arg0.isPassword;
        }

        if((arg13 & 0x800) != 0) {
            arg12 = arg0.stylusHandwritingTrigger;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public TextFieldDecoratorModifierNode create() {
        return new TextFieldDecoratorModifierNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource, this.isPassword, this.stylusHandwritingTrigger);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextFieldDecoratorModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextFieldDecoratorModifier)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldState, ((TextFieldDecoratorModifier)arg5).textFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textLayoutState, ((TextFieldDecoratorModifier)arg5).textLayoutState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldSelectionState, ((TextFieldDecoratorModifier)arg5).textFieldSelectionState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.filter, ((TextFieldDecoratorModifier)arg5).filter)) {
            return 0;
        }

        if(this.enabled != ((TextFieldDecoratorModifier)arg5).enabled) {
            return 0;
        }

        if(this.readOnly != ((TextFieldDecoratorModifier)arg5).readOnly) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyboardOptions, ((TextFieldDecoratorModifier)arg5).keyboardOptions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyboardActionHandler, ((TextFieldDecoratorModifier)arg5).keyboardActionHandler)) {
            return 0;
        }

        if(this.singleLine != ((TextFieldDecoratorModifier)arg5).singleLine) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((TextFieldDecoratorModifier)arg5).interactionSource)) {
            return 0;
        }

        if(this.isPassword != ((TextFieldDecoratorModifier)arg5).isPassword) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stylusHandwritingTrigger, ((TextFieldDecoratorModifier)arg5).stylusHandwritingTrigger)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = ((this.textFieldState.hashCode() * 0x1F + this.textLayoutState.hashCode()) * 0x1F + this.textFieldSelectionState.hashCode()) * 0x1F;
        InputTransformation v1 = this.filter;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((((v0 + v1_1) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F + Boolean.hashCode(this.readOnly)) * 0x1F + this.keyboardOptions.hashCode()) * 0x1F;
        KeyboardActionHandler v1_2 = this.keyboardActionHandler;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = ((((v0 + v1_1) * 0x1F + Boolean.hashCode(this.singleLine)) * 0x1F + this.interactionSource.hashCode()) * 0x1F + Boolean.hashCode(this.isPassword)) * 0x1F;
        MutableSharedFlow v3 = this.stylusHandwritingTrigger;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("TextFieldDecoratorModifier(textFieldState=");
        v0.append(this.textFieldState).append(", textLayoutState=").append(this.textLayoutState).append(", textFieldSelectionState=").append(this.textFieldSelectionState).append(", filter=").append(this.filter).append(", enabled=").append(this.enabled).append(", readOnly=").append(this.readOnly).append(", keyboardOptions=").append(this.keyboardOptions).append(", keyboardActionHandler=").append(this.keyboardActionHandler).append(", singleLine=").append(this.singleLine).append(", interactionSource=").append(this.interactionSource).append(", isPassword=").append(this.isPassword).append(", stylusHandwritingTrigger=");
        v0.append(this.stylusHandwritingTrigger).append(')');
        return v0.toString();
    }

    public void update(TextFieldDecoratorModifierNode arg14) {
        arg14.updateNode(this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.filter, this.enabled, this.readOnly, this.keyboardOptions, this.keyboardActionHandler, this.singleLine, this.interactionSource, this.isPassword, this.stylusHandwritingTrigger);
    }

    public void update(Node arg1) {
        this.update(((TextFieldDecoratorModifierNode)arg1));
    }
}

