package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;

public final class TextFieldSelectionState$$ExternalSyntheticLambda7 implements Function1 {
    public TextFieldSelectionState$$ExternalSyntheticLambda7(LongRef arg1, TextFieldSelectionState arg2, LongRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$0(this.f$0, this.f$1, this.f$2, ((Offset)arg3));
    }
}

