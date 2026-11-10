package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import kotlin.jvm.functions.Function1;

public final class LazyLayoutItemAnimation$animatePlacementDelta$1$$ExternalSyntheticLambda0 implements Function1 {
    public LazyLayoutItemAnimation$animatePlacementDelta$1$$ExternalSyntheticLambda0(LazyLayoutItemAnimation arg1, long arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg4) {
        return LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Animatable)arg4));
    }
}

