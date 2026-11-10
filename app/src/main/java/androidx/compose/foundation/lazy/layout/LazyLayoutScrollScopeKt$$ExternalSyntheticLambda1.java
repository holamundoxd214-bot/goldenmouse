package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1 implements Function1 {
    public LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1(float arg1, FloatRef arg2, LazyLayoutScrollScope arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return LazyLayoutScrollScopeKt.animateScrollToItem$lambda$7(this.f$0, this.f$1, this.f$2, ((AnimationScope)arg3));
    }
}

