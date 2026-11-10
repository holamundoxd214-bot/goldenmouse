package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class CoreTextFieldKt$$ExternalSyntheticLambda23 implements Function2 {
    public CoreTextFieldKt$$ExternalSyntheticLambda23(Function3 arg1, LegacyTextFieldState arg2, TextStyle arg3, int arg4, int arg5, TextFieldScrollerPosition arg6, TextFieldValue arg7, VisualTransformation arg8, Modifier arg9, Modifier arg10, Modifier arg11, Modifier arg12, BringIntoViewRequester arg13, TextFieldSelectionManager arg14, boolean arg15, boolean arg16, Function1 arg17, OffsetMapping arg18, Density arg19) {
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
        this.f$9 = arg10;
        this.f$10 = arg11;
        this.f$11 = arg12;
        this.f$12 = arg13;
        this.f$13 = arg14;
        this.f$14 = arg15;
        this.f$15 = arg16;
        this.f$16 = arg17;
        this.f$17 = arg18;
        this.f$18 = arg19;
    }

    public final Object invoke(Object arg23, Object arg24) {
        return CoreTextFieldKt.CoreTextField$lambda$26(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, this.f$18, arg23, arg24.intValue());
    }
}

