package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.functions.Function1;

public final class AndroidLegacyPlatformTextInputServiceAdapter$$ExternalSyntheticLambda0 implements Function1 {
    public AndroidLegacyPlatformTextInputServiceAdapter$$ExternalSyntheticLambda0(TextFieldValue arg1, AndroidLegacyPlatformTextInputServiceAdapter arg2, ImeOptions arg3, Function1 arg4, Function1 arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg7) {
        return AndroidLegacyPlatformTextInputServiceAdapter.startInput$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg7);
    }
}

