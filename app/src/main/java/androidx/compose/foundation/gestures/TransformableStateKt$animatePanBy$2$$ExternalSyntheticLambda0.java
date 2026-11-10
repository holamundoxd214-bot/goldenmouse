package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;

public final class TransformableStateKt$animatePanBy$2$$ExternalSyntheticLambda0 implements Function1 {
    public TransformableStateKt$animatePanBy$2$$ExternalSyntheticLambda0(LongRef arg1, TransformScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TransformableStateKt$animatePanBy$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((AnimationScope)arg2));
    }
}

