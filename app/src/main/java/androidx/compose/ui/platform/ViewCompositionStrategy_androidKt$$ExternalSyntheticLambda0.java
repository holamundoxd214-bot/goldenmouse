package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(AbstractComposeView arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        ViewCompositionStrategy_androidKt.installForLifecycle$lambda$1(this.f$0, arg1, arg2);
    }
}

