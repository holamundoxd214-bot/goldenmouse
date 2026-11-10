package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class LifecycleEffectKt$$ExternalSyntheticLambda6 implements Function2 {
    public LifecycleEffectKt$$ExternalSyntheticLambda6(Event arg1, LifecycleOwner arg2, Function0 arg3, int arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return LifecycleEffectKt.LifecycleEventEffect$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

