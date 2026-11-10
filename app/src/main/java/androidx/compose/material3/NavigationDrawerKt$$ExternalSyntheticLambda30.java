package androidx.compose.material3;

import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.jvm.functions.Function1;

public final class NavigationDrawerKt$$ExternalSyntheticLambda30 implements Function1 {
    public NavigationDrawerKt$$ExternalSyntheticLambda30(FloatProducer arg1, float arg2, boolean arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return NavigationDrawerKt.horizontalScaleDown$lambda$55(this.f$0, this.f$1, this.f$2, ((GraphicsLayerScope)arg3));
    }
}

