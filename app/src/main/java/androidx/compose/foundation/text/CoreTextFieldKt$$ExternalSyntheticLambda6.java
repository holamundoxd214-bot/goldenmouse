package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class CoreTextFieldKt$$ExternalSyntheticLambda6 implements Function1 {
    public CoreTextFieldKt$$ExternalSyntheticLambda6(LegacyTextFieldState arg1, boolean arg2, boolean arg3, TextInputService arg4, TextFieldValue arg5, ImeOptions arg6, OffsetMapping arg7, TextFieldSelectionManager arg8, CoroutineScope arg9, BringIntoViewRequester arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
        this.f$9 = arg10;
    }

    public final Object invoke(Object arg12) {
        return CoreTextFieldKt.$r8$lambda$BLYeOk5ZT4NO3L4OKNAC8YdZd5Q(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, arg12);
    }
}

