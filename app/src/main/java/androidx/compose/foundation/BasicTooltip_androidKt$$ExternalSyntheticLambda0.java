package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.functions.Function2;

public final class BasicTooltip_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public BasicTooltip_androidKt$$ExternalSyntheticLambda0(PopupPositionProvider arg1, Function2 arg2, BasicTooltipState arg3, Modifier arg4, boolean arg5, boolean arg6, Function2 arg7, int arg8, int arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
    }

    public final Object invoke(Object arg12, Object arg13) {
        return BasicTooltip_androidKt.BasicTooltipBoxAndroid$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, arg12, ((Integer)arg13).intValue());
    }
}

