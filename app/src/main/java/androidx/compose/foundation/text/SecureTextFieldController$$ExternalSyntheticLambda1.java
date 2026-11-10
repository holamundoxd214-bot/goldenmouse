package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusState;
import kotlin.jvm.functions.Function1;

public final class SecureTextFieldController$$ExternalSyntheticLambda1 implements Function1 {
    public SecureTextFieldController$$ExternalSyntheticLambda1(SecureTextFieldController arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SecureTextFieldController.focusChangeModifier$lambda$0(this.f$0, ((FocusState)arg1));
    }
}

