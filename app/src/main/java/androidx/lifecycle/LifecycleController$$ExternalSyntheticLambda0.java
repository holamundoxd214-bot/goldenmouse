package androidx.lifecycle;

import kotlinx.coroutines.Job;

public final class LifecycleController$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public LifecycleController$$ExternalSyntheticLambda0(LifecycleController arg1, Job arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onStateChanged(LifecycleOwner arg2, Event arg3) {
        LifecycleController.observer$lambda$0(this.f$0, this.f$1, arg2, arg3);
    }
}

