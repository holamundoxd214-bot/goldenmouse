package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LifecycleEffectKt$$ExternalSyntheticLambda10 implements Function2 {
    public LifecycleEffectKt$$ExternalSyntheticLambda10(Object arg1, Object arg2, LifecycleOwner arg3, Function1 arg4, int arg5, int arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg9, Object arg10) {
        return LifecycleEffectKt.LifecycleStartEffect$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg9, ((Integer)arg10).intValue());
    }
}

