package androidx.compose.foundation.text;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.jvm.functions.Function1;

public final class CoreTextFieldKt$$ExternalSyntheticLambda19 implements Function1 {
    public CoreTextFieldKt$$ExternalSyntheticLambda19(LegacyTextFieldState arg1, TextInputService arg2, TextFieldValue arg3, ImeOptions arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return CoreTextFieldKt.$r8$lambda$YVhuVDTeAif0Ph9o_50aQp0Yc8o(this.f$0, this.f$1, this.f$2, this.f$3, ((DisposableEffectScope)arg4));
    }
}

