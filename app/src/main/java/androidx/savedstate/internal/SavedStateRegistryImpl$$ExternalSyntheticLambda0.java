package androidx.savedstate.internal;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class SavedStateRegistryImpl$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public SavedStateRegistryImpl$$ExternalSyntheticLambda0(SavedStateRegistryImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        SavedStateRegistryImpl.performAttach$lambda$12(this.f$0, arg1, arg2);
    }
}

