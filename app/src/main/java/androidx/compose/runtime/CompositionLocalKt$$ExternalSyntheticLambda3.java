package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

public final class CompositionLocalKt$$ExternalSyntheticLambda3 implements Function1 {
    public CompositionLocalKt$$ExternalSyntheticLambda3(HostDefaultKey arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return CompositionLocalKt.compositionLocalWithHostDefaultOf$lambda$0(this.f$0, ((CompositionLocalAccessorScope)arg1));
    }
}

