package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

public final class CompositionLocalKt$$ExternalSyntheticLambda2 implements Function2 {
    public CompositionLocalKt$$ExternalSyntheticLambda2(CompositionLocalContext arg1, Function2 arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return CompositionLocalKt.CompositionLocalProvider$lambda$3(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

