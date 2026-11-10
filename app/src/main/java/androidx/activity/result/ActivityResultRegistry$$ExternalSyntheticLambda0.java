package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class ActivityResultRegistry$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public ActivityResultRegistry$$ExternalSyntheticLambda0(ActivityResultRegistry arg1, String arg2, ActivityResultCallback arg3, ActivityResultContract arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onStateChanged(LifecycleOwner arg7, Event arg8) {
        ActivityResultRegistry.register$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, arg7, arg8);
    }
}

