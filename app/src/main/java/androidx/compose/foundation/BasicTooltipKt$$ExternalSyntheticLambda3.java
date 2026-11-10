package androidx.compose.foundation;

import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class BasicTooltipKt$$ExternalSyntheticLambda3 implements Function2 {
    public BasicTooltipKt$$ExternalSyntheticLambda3(PopupPositionProvider arg1, BasicTooltipState arg2, CoroutineScope arg3, boolean arg4, Function2 arg5, int arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg9, Object arg10) {
        return BasicTooltipKt.TooltipPopup$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg9, ((Integer)arg10).intValue());
    }
}

