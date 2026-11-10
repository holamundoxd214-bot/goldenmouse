package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener;

public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0 implements NotifyImeListener {
    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1$$ExternalSyntheticLambda0(ComposeInputMethodManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onChange(TextFieldCharSequence arg1, TextFieldCharSequence arg2, boolean arg3) {
        androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1.invokeSuspend$lambda$0(this.f$0, arg1, arg2, arg3);
    }
}

