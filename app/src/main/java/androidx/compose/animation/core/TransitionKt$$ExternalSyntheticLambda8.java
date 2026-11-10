package androidx.compose.animation.core;

import kotlin.jvm.functions.Function2;

public final class TransitionKt$$ExternalSyntheticLambda8 implements Function2 {
    public TransitionKt$$ExternalSyntheticLambda8(Transition arg1, TransitionAnimationState arg2, Object arg3, Object arg4, FiniteAnimationSpec arg5, int arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg9, Object arg10) {
        return TransitionKt.UpdateInitialAndTargetValues$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg9, ((Integer)arg10).intValue());
    }
}

