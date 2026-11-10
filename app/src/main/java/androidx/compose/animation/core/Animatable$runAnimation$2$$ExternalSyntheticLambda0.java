package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class Animatable$runAnimation$2$$ExternalSyntheticLambda0 implements Function1 {
    public Animatable$runAnimation$2$$ExternalSyntheticLambda0(Animatable arg1, AnimationState arg2, Function1 arg3, BooleanRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return Animatable$runAnimation$2.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((AnimationScope)arg4));
    }
}

