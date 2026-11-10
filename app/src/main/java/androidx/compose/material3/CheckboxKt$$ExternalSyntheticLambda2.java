package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class CheckboxKt$$ExternalSyntheticLambda2 implements Function2 {
    public CheckboxKt$$ExternalSyntheticLambda2(ToggleableState arg1, Function0 arg2, Stroke arg3, Stroke arg4, Modifier arg5, boolean arg6, CheckboxColors arg7, MutableInteractionSource arg8, int arg9, int arg10) {
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
        this.f$9 = arg10;
    }

    public final Object invoke(Object arg13, Object arg14) {
        return CheckboxKt.TriStateCheckbox$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, arg13, ((Integer)arg14).intValue());
    }
}

