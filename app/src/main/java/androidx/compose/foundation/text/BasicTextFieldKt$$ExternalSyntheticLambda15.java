package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;

public final class BasicTextFieldKt$$ExternalSyntheticLambda15 implements Function2 {
    public BasicTextFieldKt$$ExternalSyntheticLambda15(TextFieldState arg1, Modifier arg2, boolean arg3, boolean arg4, InputTransformation arg5, TextStyle arg6, KeyboardOptions arg7, KeyboardActionHandler arg8, TextFieldLineLimits arg9, Function2 arg10, MutableInteractionSource arg11, Brush arg12, CodepointTransformation arg13, OutputTransformation arg14, TextFieldDecorator arg15, ScrollState arg16, boolean arg17, int arg18, int arg19, int arg20) {
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
        this.f$19 = arg20;
    }

    public final Object invoke(Object arg24, Object arg25) {
        return BasicTextFieldKt.BasicTextField$lambda$15(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, this.f$18, this.f$19, arg24, arg25.intValue());
    }
}

