package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class SnackbarHostKt$$ExternalSyntheticLambda2 implements Function2 {
    public SnackbarHostKt$$ExternalSyntheticLambda2(SnackbarData arg1, Modifier arg2, Function3 arg3, int arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return SnackbarHostKt.FadeInFadeOutWithScale$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

