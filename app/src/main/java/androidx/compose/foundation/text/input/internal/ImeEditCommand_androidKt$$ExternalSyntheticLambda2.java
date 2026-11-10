package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final class ImeEditCommand_androidKt$$ExternalSyntheticLambda2 implements Function1 {
    public ImeEditCommand_androidKt$$ExternalSyntheticLambda2(String arg1, List arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return ImeEditCommand_androidKt.setComposingText$lambda$0(this.f$0, this.f$1, this.f$2, ((TextFieldBuffer)arg3));
    }
}

