package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener;

public final class TransformedTextFieldState$$ExternalSyntheticLambda0 implements NotifyImeListener {
    public TransformedTextFieldState$$ExternalSyntheticLambda0(NotifyImeListener arg1, TransformedTextFieldState arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onChange(TextFieldCharSequence arg2, TextFieldCharSequence arg3, boolean arg4) {
        TransformedTextFieldState.collectImeNotifications$lambda$0(this.f$0, this.f$1, arg2, arg3, arg4);
    }
}

