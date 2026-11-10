package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.jvm.functions.Function1;

public final class LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0 implements Function1 {
    public LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0(GraphicsLayer arg1, LazyLayoutItemAnimation arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return LazyLayoutItemAnimation$animateAppearance$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Animatable)arg2));
    }
}

