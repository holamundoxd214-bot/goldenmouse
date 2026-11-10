package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class TextFieldKeyInputKt$$ExternalSyntheticLambda0 implements Function3 {
    public TextFieldKeyInputKt$$ExternalSyntheticLambda0(LegacyTextFieldState arg1, TextFieldSelectionManager arg2, TextFieldValue arg3, boolean arg4, boolean arg5, OffsetMapping arg6, UndoManager arg7, Function1 arg8, int arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
    }

    public final Object invoke(Object arg13, Object arg14, Object arg15) {
        return TextFieldKeyInputKt.textFieldKeyInput_2WJ9YEU$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, arg13, arg14, ((Integer)arg15).intValue());
    }
}

