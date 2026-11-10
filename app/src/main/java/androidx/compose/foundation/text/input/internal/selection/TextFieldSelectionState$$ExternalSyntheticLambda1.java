package androidx.compose.foundation.text.input.internal.selection;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$LongRef;

public final class TextFieldSelectionState$$ExternalSyntheticLambda1 implements Function0 {
    public TextFieldSelectionState$$ExternalSyntheticLambda1(LongRef arg1, TextFieldSelectionState arg2, LongRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$2(this.f$0, this.f$1, this.f$2);
    }
}

