package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class AnchoredDraggableKt$animateToWithDecay$2$$ExternalSyntheticLambda0 implements Function1 {
    public AnchoredDraggableKt$animateToWithDecay$2$$ExternalSyntheticLambda0(float arg1, FloatRef arg2, AnchoredDragScope arg3, FloatRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return AnchoredDraggableKt$animateToWithDecay$2.invokeSuspend$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, ((AnimationScope)arg4));
    }
}

