package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.functions.Function1;

public final class LegacyTextFieldState$$ExternalSyntheticLambda1 implements Function1 {
    public LegacyTextFieldState$$ExternalSyntheticLambda1(LegacyTextFieldState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return LegacyTextFieldState.onValueChange$lambda$0(this.f$0, ((TextFieldValue)arg1));
    }
}

