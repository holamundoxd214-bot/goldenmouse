package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class AppBarKt$$ExternalSyntheticLambda23 implements Function1 {
    public AppBarKt$$ExternalSyntheticLambda23(FloatRef arg1, BottomAppBarState arg2, FloatRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return AppBarKt.settleAppBarBottom$lambda$29(this.f$0, this.f$1, this.f$2, ((AnimationScope)arg3));
    }
}

