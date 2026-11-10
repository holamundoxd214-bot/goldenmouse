package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function3;

public final class TextFieldSizeKt$$ExternalSyntheticLambda1 implements Function3 {
    public TextFieldSizeKt$$ExternalSyntheticLambda1(TextStyle arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return TextFieldSizeKt.textFieldMinSize$lambda$0(this.f$0, ((Modifier)arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

