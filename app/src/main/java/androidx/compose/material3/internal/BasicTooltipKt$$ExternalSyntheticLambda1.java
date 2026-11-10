package androidx.compose.material3.internal;

import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class BasicTooltipKt$$ExternalSyntheticLambda1 implements Function2 {
    public BasicTooltipKt$$ExternalSyntheticLambda1(PopupPositionProvider arg1, TooltipState arg2, Function0 arg3, CoroutineScope arg4, boolean arg5, MutableState arg6, Function2 arg7, int arg8) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
    }

    public final Object invoke(Object arg11, Object arg12) {
        return BasicTooltipKt.TooltipPopup$lambda$10(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, arg11, ((Integer)arg12).intValue());
    }
}

