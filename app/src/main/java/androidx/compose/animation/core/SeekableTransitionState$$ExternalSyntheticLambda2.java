package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

public final class SeekableTransitionState$$ExternalSyntheticLambda2 implements Function1 {
    public SeekableTransitionState$$ExternalSyntheticLambda2(SeekableTransitionState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg3) {
        return SeekableTransitionState.animateOneFrameLambda$lambda$0(this.f$0, ((Long)arg3).longValue());
    }
}

