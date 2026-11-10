package androidx.compose.material3.internal;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

public final class AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$12$lambda$11$lambda$9(this.f$0, arg1, arg2);
    }
}

