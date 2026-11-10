package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class SuspendAnimationKt$$ExternalSyntheticLambda2 implements Function1 {
    public SuspendAnimationKt$$ExternalSyntheticLambda2(ObjectRef arg1, float arg2, Animation arg3, AnimationState arg4, Function1 arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg8) {
        return SuspendAnimationKt.animate$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, ((Long)arg8).longValue());
    }
}

