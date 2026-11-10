package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;

public final class BasicSecureTextFieldKt$$ExternalSyntheticLambda5 implements Function2 {
    public BasicSecureTextFieldKt$$ExternalSyntheticLambda5(boolean arg1, InputTransformation arg2, SecureTextFieldController arg3, TextFieldState arg4, Modifier arg5, boolean arg6, boolean arg7, TextStyle arg8, KeyboardOptions arg9, KeyboardActionHandler arg10, Function2 arg11, MutableInteractionSource arg12, Brush arg13, CodepointTransformation arg14, TextFieldDecorator arg15, ScrollState arg16) {
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
    }

    public final Object invoke(Object arg20, Object arg21) {
        return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, arg20, arg21.intValue());
    }
}

