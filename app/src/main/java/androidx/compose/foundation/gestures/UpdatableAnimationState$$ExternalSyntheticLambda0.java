package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;

public final class UpdatableAnimationState$$ExternalSyntheticLambda0 implements Function1 {
    public UpdatableAnimationState$$ExternalSyntheticLambda0(UpdatableAnimationState arg1, float arg2, Function1 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg5) {
        return UpdatableAnimationState.animateToZero$lambda$1(this.f$0, this.f$1, this.f$2, ((Long)arg5).longValue());
    }
}

