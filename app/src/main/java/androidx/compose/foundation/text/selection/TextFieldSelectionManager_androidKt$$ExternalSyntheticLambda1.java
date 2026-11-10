package androidx.compose.foundation.text.selection;

import android.content.Context;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda1(TextFieldSelectionManager arg1, CoroutineScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0(this.f$0, this.f$1, ((TextContextMenuBuilderScope)arg2), ((Context)arg3));
    }
}

