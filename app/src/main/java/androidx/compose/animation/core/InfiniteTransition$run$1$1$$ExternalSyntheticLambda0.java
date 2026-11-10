package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;

public final class InfiniteTransition$run$1$1$$ExternalSyntheticLambda0 implements Function1 {
    public InfiniteTransition$run$1$1$$ExternalSyntheticLambda0(MutableState arg1, InfiniteTransition arg2, FloatRef arg3, CoroutineScope arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7) {
        return InfiniteTransition$run$1$1.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((Long)arg7).longValue());
    }
}

