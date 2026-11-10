package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class DefaultFlingBehavior$performFling$2$$ExternalSyntheticLambda0 implements Function1 {
    public DefaultFlingBehavior$performFling$2$$ExternalSyntheticLambda0(FloatRef arg1, ScrollScope arg2, FloatRef arg3, DefaultFlingBehavior arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return DefaultFlingBehavior$performFling$2.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((AnimationScope)arg4));
    }
}

