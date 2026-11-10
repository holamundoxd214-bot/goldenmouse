package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class SuspendAnimationKt$$ExternalSyntheticLambda5 implements Function1 {
    public SuspendAnimationKt$$ExternalSyntheticLambda5(Function2 arg1, TwoWayConverter arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SuspendAnimationKt.animate$lambda$1(this.f$0, this.f$1, ((AnimationScope)arg2));
    }
}

