package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Ai\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0014\b\u0002\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"textFieldKeyInput", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "editable", "", "singleLine", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textFieldKeyInput-2WJ9YEU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;I)Landroidx/compose/ui/Modifier;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldKeyInputKt {
    public static final Modifier textFieldKeyInput-2WJ9YEU(Modifier arg10, LegacyTextFieldState arg11, TextFieldSelectionManager arg12, TextFieldValue arg13, Function1 arg14, boolean arg15, boolean arg16, OffsetMapping arg17, UndoManager arg18, int arg19) {
        return ComposedModifierKt.composed$default(arg10, null, new TextFieldKeyInputKt$$ExternalSyntheticLambda0(arg11, arg12, arg13, arg15, arg16, arg17, arg18, arg14, arg19), 1, null);
    }

    public static Modifier textFieldKeyInput-2WJ9YEU$default(Modifier arg10, LegacyTextFieldState arg11, TextFieldSelectionManager arg12, TextFieldValue arg13, Function1 arg14, boolean arg15, boolean arg16, OffsetMapping arg17, UndoManager arg18, int arg19, int arg20, Object arg21) {
        TextFieldKeyInputKt$$ExternalSyntheticLambda1 v14;
        if((arg20 & 8) != 0) {
            v14 = new TextFieldKeyInputKt$$ExternalSyntheticLambda1();
        }

        return TextFieldKeyInputKt.textFieldKeyInput-2WJ9YEU(arg10, arg11, arg12, arg13, ((Function1)v14), arg15, arg16, arg17, arg18, arg19);
    }

    static final Unit textFieldKeyInput_2WJ9YEU$lambda$0(TextFieldValue arg0) {
        return Unit.INSTANCE;
    }

    static final Modifier textFieldKeyInput_2WJ9YEU$lambda$1(LegacyTextFieldState arg18, TextFieldSelectionManager arg19, TextFieldValue arg20, boolean arg21, boolean arg22, OffsetMapping arg23, UndoManager arg24, Function1 arg25, int arg26, Modifier arg27, Composer arg28, int arg29) {
        DeadKeyCombiner v1_3;
        TextPreparedSelectionState v1_2;
        Composer v0 = arg28;
        int v1 = 851809892;
        v0.startReplaceGroup(v1);
        ComposerKt.sourceInformation(v0, "C255@11924L41,256@11988L30,271@12524L18:TextFieldKeyInput.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg29, -1, "androidx.compose.foundation.text.textFieldKeyInput.<anonymous> (TextFieldKeyInput.kt:255)");
        }

        String v2 = "CC(remember):TextFieldKeyInput.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v0, 0x97B991ED, v2);
        Object v1_1 = v0.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new TextPreparedSelectionState();
            v0.updateRememberedValue(v1_2);
        }

        Object v9 = v1_2;
        ComposerKt.sourceInformationMarkerEnd(v0);
        ComposerKt.sourceInformationMarkerStart(v0, 0x97B999E2, v2);
        v1_1 = v0.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            v1_3 = new DeadKeyCombiner();
            v0.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        TextFieldKeyInput v3 = new TextFieldKeyInput(arg18, arg19, arg20, arg21, arg22, ((TextPreparedSelectionState)v9), arg23, arg24, v1_3, null, arg25, arg26, 0x200, null);
        Companion v1_4 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(v0, 0x97B9DCD6, v2);
        boolean v2_1 = v0.changedInstance(v3);
        Object v4 = v0.rememberedValue();
        if((v2_1) || v4 == Composer.Companion.getEmpty()) {
            TextFieldKeyInputKt$textFieldKeyInput$2$1$1 v4_1 = new TextFieldKeyInputKt$textFieldKeyInput$2$1$1(v3);
            v0.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Modifier v1_5 = KeyInputModifierKt.onKeyEvent(((Modifier)v1_4), ((Function1)v4));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v0.endReplaceGroup();
        return v1_5;
    }
}

