package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class CoreTextFieldKt$$ExternalSyntheticLambda13 implements Function2 {
    public CoreTextFieldKt$$ExternalSyntheticLambda13(TextFieldSelectionManager arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CoreTextFieldKt.TextFieldCursorHandle$lambda$4(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

