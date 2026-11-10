package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class TextFieldPressGestureFilterKt$$ExternalSyntheticLambda0 implements Function3 {
    public TextFieldPressGestureFilterKt$$ExternalSyntheticLambda0(Function1 arg1, MutableInteractionSource arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return TextFieldPressGestureFilterKt.tapPressTextFieldModifier$lambda$0(this.f$0, this.f$1, ((Modifier)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

