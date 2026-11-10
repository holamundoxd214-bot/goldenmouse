package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class RememberLifecycleOwnerKt$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public RememberLifecycleOwnerKt$$ExternalSyntheticLambda0(ComposeLifecycleOwner arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onStateChanged(LifecycleOwner arg1, Event arg2) {
        RememberLifecycleOwnerKt.$r8$lambda$0hrbeT26lEfIKGSpz-zHtCY4jIs(this.f$0, arg1, arg2);
    }
}

