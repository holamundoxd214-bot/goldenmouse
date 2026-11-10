package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

public final class SuspendAnimationKt$$ExternalSyntheticLambda7 implements Function1 {
    public SuspendAnimationKt$$ExternalSyntheticLambda7(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg3) {
        return SuspendAnimationKt.callWithFrameNanos$lambda$0(this.f$0, ((Long)arg3).longValue());
    }
}

