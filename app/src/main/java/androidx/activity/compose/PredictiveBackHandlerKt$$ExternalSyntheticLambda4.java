package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import kotlin.jvm.functions.Function1;

public final class PredictiveBackHandlerKt$$ExternalSyntheticLambda4 implements Function1 {
    public PredictiveBackHandlerKt$$ExternalSyntheticLambda4(BackHandlerDispatcherCompat arg1, ComposePredictiveBackHandler arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return PredictiveBackHandlerKt.$r8$lambda$nQooPx1G5uRDz4nlmkTLRPyb09k(this.f$0, this.f$1, ((LifecycleStartStopEffectScope)arg2));
    }
}

