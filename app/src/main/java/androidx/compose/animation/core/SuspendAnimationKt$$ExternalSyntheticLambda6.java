package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class SuspendAnimationKt$$ExternalSyntheticLambda6 implements Function1 {
    public SuspendAnimationKt$$ExternalSyntheticLambda6(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SuspendAnimationKt.animateDecay$lambda$0(this.f$0, ((AnimationScope)arg1));
    }
}

