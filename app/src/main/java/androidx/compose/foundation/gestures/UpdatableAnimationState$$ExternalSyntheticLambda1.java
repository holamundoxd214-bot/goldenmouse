package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class UpdatableAnimationState$$ExternalSyntheticLambda1 implements Function1 {
    public UpdatableAnimationState$$ExternalSyntheticLambda1(UpdatableAnimationState arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg4) {
        return UpdatableAnimationState.animateToZero$lambda$2(this.f$0, this.f$1, ((Long)arg4).longValue());
    }
}

