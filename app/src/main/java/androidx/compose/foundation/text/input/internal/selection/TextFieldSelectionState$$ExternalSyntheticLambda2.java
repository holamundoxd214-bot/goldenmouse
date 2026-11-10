package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class TextFieldSelectionState$$ExternalSyntheticLambda2 implements Function2 {
    public TextFieldSelectionState$$ExternalSyntheticLambda2(LongRef arg1, TextFieldSelectionState arg2, Handle arg3, LongRef arg4, boolean arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, arg9);
    }
}

