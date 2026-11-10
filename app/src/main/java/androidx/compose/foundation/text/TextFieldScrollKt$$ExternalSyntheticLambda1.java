package androidx.compose.foundation.text;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.jvm.functions.Function3;

public final class TextFieldScrollKt$$ExternalSyntheticLambda1 implements Function3 {
    public TextFieldScrollKt$$ExternalSyntheticLambda1(TextFieldScrollerPosition arg1, boolean arg2, OverscrollEffect arg3, MutableInteractionSource arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg8, Object arg9, Object arg10) {
        return TextFieldScrollKt.textFieldScrollable$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, arg8, arg9, ((Integer)arg10).intValue());
    }
}

