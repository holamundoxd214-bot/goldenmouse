package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class ContextMenuUiKt$$ExternalSyntheticLambda6 implements Function2 {
    public ContextMenuUiKt$$ExternalSyntheticLambda6(Modifier arg1, ContextMenuColors arg2, Function1 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return ContextMenuUiKt.ContextMenuPopup$lambda$1(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

