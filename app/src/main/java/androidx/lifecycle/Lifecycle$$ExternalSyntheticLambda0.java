package androidx.lifecycle;

import kotlinx.coroutines.flow.MutableStateFlow;

public final class Lifecycle$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public Lifecycle$$ExternalSyntheticLambda0(MutableStateFlow arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        Lifecycle._get_currentStateFlow_$lambda$0(this.f$0, arg1, arg2);
    }
}

