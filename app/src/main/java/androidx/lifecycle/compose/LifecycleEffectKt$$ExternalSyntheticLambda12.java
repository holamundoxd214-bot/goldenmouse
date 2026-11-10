package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class LifecycleEffectKt$$ExternalSyntheticLambda12 implements LifecycleEventObserver {
    public LifecycleEffectKt$$ExternalSyntheticLambda12(LifecycleStartStopEffectScope arg1, ObjectRef arg2, Function1 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onStateChanged(LifecycleOwner arg3, Event arg4) {
        LifecycleEffectKt.$r8$lambda$QY7v88a473xDOMs5julNK5kYLk8(this.f$0, this.f$1, this.f$2, arg3, arg4);
    }
}

