package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;

public final class TextFieldSelectionState$$ExternalSyntheticLambda11 implements Function1 {
    public TextFieldSelectionState$$ExternalSyntheticLambda11(LongRef arg1, TextFieldSelectionState arg2, boolean arg3, Handle arg4, LongRef arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg7) {
        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg7);
    }
}

