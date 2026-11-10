package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class TextFieldSelectionStateKt$$ExternalSyntheticLambda1 implements Function1 {
    public TextFieldSelectionStateKt$$ExternalSyntheticLambda1(State arg1, ContextMenuState arg2, Function2 arg3, TextFieldSelectionState arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return TextFieldSelectionStateKt.contextMenuBuilder$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((ContextMenuScope)arg4));
    }
}

