package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class MouseWheelScrollingLogic$$ExternalSyntheticLambda1 implements Function1 {
    public MouseWheelScrollingLogic$$ExternalSyntheticLambda1(FloatRef arg1, MouseWheelScrollingLogic arg2, NestedScrollScope arg3, Function1 arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return MouseWheelScrollingLogic.animateMouseWheelScroll$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((AnimationScope)arg4));
    }
}

