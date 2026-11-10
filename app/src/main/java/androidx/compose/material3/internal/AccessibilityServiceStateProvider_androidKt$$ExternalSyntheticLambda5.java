package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.lifecycle.Lifecycle$Event;
import kotlin.jvm.functions.Function1;

public final class AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda5 implements Function1 {
    public AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda5(Listener arg1, AccessibilityManager arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState$lambda$2$lambda$1(this.f$0, this.f$1, ((Event)arg2));
    }
}

