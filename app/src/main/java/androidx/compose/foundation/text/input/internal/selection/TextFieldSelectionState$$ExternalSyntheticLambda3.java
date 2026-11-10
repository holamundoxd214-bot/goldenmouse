package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import kotlin.jvm.functions.Function0;

public final class TextFieldSelectionState$$ExternalSyntheticLambda3 implements Function0 {
    public TextFieldSelectionState$$ExternalSyntheticLambda3(TextFieldSelectionState arg1, Handle arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$4(this.f$0, this.f$1);
    }
}

