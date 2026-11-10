package androidx.compose.foundation.text.input.internal.selection;

import android.content.Context;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class TextFieldSelectionState_androidKt$$ExternalSyntheticLambda3 implements Function2 {
    public TextFieldSelectionState_androidKt$$ExternalSyntheticLambda3(TextFieldSelectionState arg1, CoroutineScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0(this.f$0, this.f$1, ((TextContextMenuBuilderScope)arg2), ((Context)arg3));
    }
}

