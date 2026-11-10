package androidx.lifecycle.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

public final class LifecycleEffectKt$$ExternalSyntheticLambda18 implements Function1 {
    public LifecycleEffectKt$$ExternalSyntheticLambda18(LifecycleOwner arg1, LifecycleResumePauseEffectScope arg2, Function1 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return LifecycleEffectKt.$r8$lambda$hYU7toFu4qU05Pf6QAbM48SVc_g(this.f$0, this.f$1, this.f$2, ((DisposableEffectScope)arg3));
    }
}

