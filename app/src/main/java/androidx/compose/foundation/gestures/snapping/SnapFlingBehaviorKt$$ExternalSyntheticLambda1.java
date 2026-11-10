package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class SnapFlingBehaviorKt$$ExternalSyntheticLambda1 implements Function1 {
    public SnapFlingBehaviorKt$$ExternalSyntheticLambda1(float arg1, FloatRef arg2, ScrollScope arg3, Function1 arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return SnapFlingBehaviorKt.animateWithTarget$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((AnimationScope)arg4));
    }
}

