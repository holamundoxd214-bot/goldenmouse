package androidx.compose.material3;

import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class SearchBarDefaults$$ExternalSyntheticLambda11 implements KeyboardActionHandler {
    public SearchBarDefaults$$ExternalSyntheticLambda11(Function1 arg1, TextFieldState arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onKeyboardAction(Function0 arg2) {
        SearchBarDefaults.InputField$lambda$29$lambda$28(this.f$0, this.f$1, arg2);
    }
}

