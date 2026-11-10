package androidx.lifecycle.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

public final class RememberLifecycleOwnerKt$$ExternalSyntheticLambda1 implements Function1 {
    public RememberLifecycleOwnerKt$$ExternalSyntheticLambda1(LifecycleOwner arg1, ComposeLifecycleOwner arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return RememberLifecycleOwnerKt.$r8$lambda$vBHoW7NavqSLRgsSYO-rN8QcXx4(this.f$0, this.f$1, ((DisposableEffectScope)arg2));
    }
}

