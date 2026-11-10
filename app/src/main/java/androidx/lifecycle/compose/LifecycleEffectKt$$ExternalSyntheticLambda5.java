package androidx.lifecycle.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

public final class LifecycleEffectKt$$ExternalSyntheticLambda5 implements Function1 {
    public LifecycleEffectKt$$ExternalSyntheticLambda5(LifecycleOwner arg1, Event arg2, State arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return LifecycleEffectKt.$r8$lambda$m_Wt9UeoYDVeEVo103zbUcK2P9k(this.f$0, this.f$1, this.f$2, ((DisposableEffectScope)arg3));
    }
}

