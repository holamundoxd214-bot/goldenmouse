package androidx.compose.foundation.text.input.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;

public final class TextFieldCoreModifierNode$startCursorJob$1$$ExternalSyntheticLambda0 implements Function0 {
    public TextFieldCoreModifierNode$startCursorJob$1$$ExternalSyntheticLambda0(TextFieldCoreModifierNode arg1, IntRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Integer.valueOf(TextFieldCoreModifierNode$startCursorJob$1.invokeSuspend$lambda$0(this.f$0, this.f$1));
    }
}

