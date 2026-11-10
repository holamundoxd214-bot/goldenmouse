package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class AnchoredDraggableState$Companion$$ExternalSyntheticLambda1 implements Function1 {
    public AnchoredDraggableState$Companion$$ExternalSyntheticLambda1(Function1 arg1, Function0 arg2, AnimationSpec arg3, DecayAnimationSpec arg4, Function1 arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg7) {
        return Companion.Saver$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg7);
    }
}

