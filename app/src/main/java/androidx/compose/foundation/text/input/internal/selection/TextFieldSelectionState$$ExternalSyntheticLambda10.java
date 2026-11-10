package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class TextFieldSelectionState$$ExternalSyntheticLambda10 implements Function2 {
    public TextFieldSelectionState$$ExternalSyntheticLambda10(LongRef arg1, TextFieldSelectionState arg2, LongRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$3(this.f$0, this.f$1, this.f$2, ((PointerInputChange)arg3), ((Offset)arg4));
    }
}

