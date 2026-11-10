package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.functions.Function3;

public final class TextFieldCursorKt$$ExternalSyntheticLambda1 implements Function3 {
    public TextFieldCursorKt$$ExternalSyntheticLambda1(Brush arg1, LegacyTextFieldState arg2, TextFieldValue arg3, OffsetMapping arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg8, Object arg9, Object arg10) {
        return TextFieldCursorKt.cursor$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, arg8, arg9, ((Integer)arg10).intValue());
    }
}

