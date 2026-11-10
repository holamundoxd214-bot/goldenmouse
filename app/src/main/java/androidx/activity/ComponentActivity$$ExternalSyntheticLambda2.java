package androidx.activity;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class ComponentActivity$$ExternalSyntheticLambda2 implements LifecycleEventObserver {
    public ComponentActivity$$ExternalSyntheticLambda2(OnBackPressedDispatcher arg1, ComponentActivity arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onStateChanged(LifecycleOwner arg2, Event arg3) {
        ComponentActivity.addObserverForBackInvoker$lambda$0(this.f$0, this.f$1, arg2, arg3);
    }
}

