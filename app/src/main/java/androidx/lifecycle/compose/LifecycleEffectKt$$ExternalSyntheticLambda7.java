package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LifecycleEffectKt$$ExternalSyntheticLambda7 implements Function2 {
    public LifecycleEffectKt$$ExternalSyntheticLambda7(Object[] arg1, LifecycleOwner arg2, Function1 arg3, int arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

