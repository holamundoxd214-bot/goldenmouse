package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function1;

public final class TextFieldSelectionManagerKt$$ExternalSyntheticLambda0 implements Function1 {
    public TextFieldSelectionManagerKt$$ExternalSyntheticLambda0(State arg1, TextFieldSelectionManager arg2, ContextMenuState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0(this.f$0, this.f$1, this.f$2, ((ContextMenuScope)arg3));
    }
}

