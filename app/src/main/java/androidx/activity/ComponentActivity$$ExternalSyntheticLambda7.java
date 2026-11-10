package androidx.activity;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class ComponentActivity$$ExternalSyntheticLambda7 implements LifecycleEventObserver {
    public ComponentActivity$$ExternalSyntheticLambda7(ComponentActivity arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        ComponentActivity._init_$lambda$2(this.f$0, arg1, arg2);
    }
}

