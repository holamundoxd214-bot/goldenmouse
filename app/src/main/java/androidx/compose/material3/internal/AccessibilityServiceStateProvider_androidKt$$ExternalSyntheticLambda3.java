package androidx.compose.material3.internal;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda3 implements Function1 {
    public AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda3(LifecycleOwner arg1, Function1 arg2, Function0 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$12$lambda$11(this.f$0, this.f$1, this.f$2, ((DisposableEffectScope)arg3));
    }
}

