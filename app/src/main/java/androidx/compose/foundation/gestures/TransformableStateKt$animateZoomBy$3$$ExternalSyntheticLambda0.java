package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class TransformableStateKt$animateZoomBy$3$$ExternalSyntheticLambda0 implements Function1 {
    public TransformableStateKt$animateZoomBy$3$$ExternalSyntheticLambda0(FloatRef arg1, TransformScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TransformableStateKt$animateZoomBy$3.invokeSuspend$lambda$0(this.f$0, this.f$1, ((AnimationScope)arg2));
    }
}

