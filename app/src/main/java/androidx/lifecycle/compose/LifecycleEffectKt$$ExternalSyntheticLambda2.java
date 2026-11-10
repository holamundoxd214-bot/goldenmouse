package androidx.lifecycle.compose;

import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class LifecycleEffectKt$$ExternalSyntheticLambda2 implements LifecycleEventObserver {
    public LifecycleEffectKt$$ExternalSyntheticLambda2(Event arg1, State arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onStateChanged(LifecycleOwner arg2, Event arg3) {
        LifecycleEffectKt.$r8$lambda$A6QyfzS99xVcWsa9fXn_JRBHe1Q(this.f$0, this.f$1, arg2, arg3);
    }
}

