package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class Transition$$ExternalSyntheticLambda2 implements Function2 {
    public Transition$$ExternalSyntheticLambda2(Transition arg1, Object arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return Transition.animateTo$lambda$3(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

