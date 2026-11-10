package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import kotlin.jvm.functions.Function1;

public final class ImeEditCommand_androidKt$$ExternalSyntheticLambda0 implements Function1 {
    public ImeEditCommand_androidKt$$ExternalSyntheticLambda0(int arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints$lambda$0(this.f$0, this.f$1, ((TextFieldBuffer)arg2));
    }
}

