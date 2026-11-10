package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

public final class EffectsKt$$ExternalSyntheticLambda0 implements Function2 {
    public EffectsKt$$ExternalSyntheticLambda0(Function2 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return EffectsKt.LaunchedEffect$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

