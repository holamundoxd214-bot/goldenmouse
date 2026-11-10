package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import kotlin.jvm.functions.Function1;

public final class SelectionManagerKt$$ExternalSyntheticLambda0 implements Function1 {
    public SelectionManagerKt$$ExternalSyntheticLambda0(SelectionManager arg1, ContextMenuState arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SelectionManagerKt.contextMenuBuilder$lambda$0(this.f$0, this.f$1, ((ContextMenuScope)arg2));
    }
}

