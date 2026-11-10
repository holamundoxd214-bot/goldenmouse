package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bg\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u00126\u0010\u000B\u001A2\u0012\u0004\u0012\u00020\r\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000E¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001A\u00020\u0002H\u0016J\u0010\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u001B\u001A\u00020\u0002H\u0016J\f\u0010\u001C\u001A\u00020\u0013*\u00020\u001DH\u0016J\u0013\u0010\u001E\u001A\u00020\n2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001A\u00020\"H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000B\u001A2\u0012\u0004\u0012\u00020\r\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000E¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f¢\u0006\u0002\b\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/KeyboardOptions;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldTextLayoutModifier extends ModifierNodeElement {
    public static final int $stable;
    private final KeyboardOptions keyboardOptions;
    private final Function2 onTextLayout;
    private final boolean singleLine;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final TextStyle textStyle;

    static {
    }

    public TextFieldTextLayoutModifier(TextLayoutState arg1, TransformedTextFieldState arg2, TextStyle arg3, boolean arg4, Function2 arg5, KeyboardOptions arg6) {
        super();
        this.textLayoutState = arg1;
        this.textFieldState = arg2;
        this.textStyle = arg3;
        this.singleLine = arg4;
        this.onTextLayout = arg5;
        this.keyboardOptions = arg6;
    }

    public TextFieldTextLayoutModifierNode create() {
        return new TextFieldTextLayoutModifierNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout, this.keyboardOptions);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextFieldTextLayoutModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextFieldTextLayoutModifier)) {
            return 0;
        }

        if(this.singleLine != ((TextFieldTextLayoutModifier)arg5).singleLine) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textLayoutState, ((TextFieldTextLayoutModifier)arg5).textLayoutState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldState, ((TextFieldTextLayoutModifier)arg5).textFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textStyle, ((TextFieldTextLayoutModifier)arg5).textStyle)) {
            return 0;
        }

        if(this.onTextLayout != ((TextFieldTextLayoutModifier)arg5).onTextLayout) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyboardOptions, ((TextFieldTextLayoutModifier)arg5).keyboardOptions)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = (((Boolean.hashCode(this.singleLine) * 0x1F + this.textLayoutState.hashCode()) * 0x1F + this.textFieldState.hashCode()) * 0x1F + this.textStyle.hashCode()) * 0x1F;
        Function2 v1 = this.onTextLayout;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (v0 + v1_1) * 0x1F + this.keyboardOptions.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(TextFieldTextLayoutModifierNode arg8) {
        arg8.updateNode(this.textLayoutState, this.textFieldState, this.textStyle, this.singleLine, this.onTextLayout, this.keyboardOptions);
    }

    public void update(Node arg1) {
        this.update(((TextFieldTextLayoutModifierNode)arg1));
    }
}

