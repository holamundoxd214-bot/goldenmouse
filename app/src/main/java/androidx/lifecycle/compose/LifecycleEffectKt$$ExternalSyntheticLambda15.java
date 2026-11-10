package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LifecycleEffectKt$$ExternalSyntheticLambda15 implements Function2 {
    public LifecycleEffectKt$$ExternalSyntheticLambda15(LifecycleOwner arg1, Function1 arg2, int arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return LifecycleEffectKt.LifecycleResumeEffect$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

