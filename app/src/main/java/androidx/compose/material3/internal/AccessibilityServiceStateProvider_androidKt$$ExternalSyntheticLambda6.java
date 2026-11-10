package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import kotlin.jvm.functions.Function0;

public final class AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda6 implements Function0 {
    public AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda6(Listener arg1, AccessibilityManager arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState$lambda$4$lambda$3(this.f$0, this.f$1);
    }
}

