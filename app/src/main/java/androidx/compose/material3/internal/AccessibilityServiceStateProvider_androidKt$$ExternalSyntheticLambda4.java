package androidx.compose.material3.internal;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda4 implements Function2 {
    public AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda4(LifecycleOwner arg1, Function1 arg2, Function0 arg3, int arg4, int arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8, Object arg9) {
        return AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$13(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, ((Integer)arg9).intValue());
    }
}

