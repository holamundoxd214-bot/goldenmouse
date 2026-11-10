package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class SuspendAnimationKt$$ExternalSyntheticLambda0 implements Function1 {
    public SuspendAnimationKt$$ExternalSyntheticLambda0(ObjectRef arg1, Object arg2, Animation arg3, AnimationVector arg4, AnimationState arg5, float arg6, Function1 arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final Object invoke(Object arg10) {
        return SuspendAnimationKt.animate$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, ((Long)arg10).longValue());
    }
}

