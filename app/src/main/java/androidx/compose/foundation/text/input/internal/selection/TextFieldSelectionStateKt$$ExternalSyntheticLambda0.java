package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class TextFieldSelectionStateKt$$ExternalSyntheticLambda0 implements Function1 {
    public TextFieldSelectionStateKt$$ExternalSyntheticLambda0(Function0 arg1, TextFieldSelectionState arg2, Function0 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures$lambda$0(this.f$0, this.f$1, this.f$2, ((Offset)arg3));
    }
}

