package androidx.lifecycle.compose;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LifecycleEffectKt$$ExternalSyntheticLambda16 implements Function2 {
    public LifecycleEffectKt$$ExternalSyntheticLambda16(Object arg1, Object arg2, Object arg3, LifecycleOwner arg4, Function1 arg5, int arg6, int arg7) {
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
        return LifecycleEffectKt.LifecycleStartEffect$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, arg10, ((Integer)arg11).intValue());
    }
}

