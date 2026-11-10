package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class ContextMenuUiKt$$ExternalSyntheticLambda7 implements Function2 {
    public ContextMenuUiKt$$ExternalSyntheticLambda7(PopupPositionProvider arg1, Function0 arg2, Modifier arg3, ContextMenuColors arg4, Function1 arg5, int arg6, int arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final Object invoke(Object arg10, Object arg11) {
        return ContextMenuUiKt.ContextMenuPopup$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, arg10, ((Integer)arg11).intValue());
    }
}

