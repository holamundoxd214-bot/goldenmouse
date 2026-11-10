package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.jvm.functions.Function1;

public final class LegacyTextFieldState$$ExternalSyntheticLambda3 implements Function1 {
    public LegacyTextFieldState$$ExternalSyntheticLambda3(LegacyTextFieldState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(LegacyTextFieldState.onImeActionPerformedWithResult$lambda$0(this.f$0, ((ImeAction)arg1)));
    }
}

