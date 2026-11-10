package androidx.compose.foundation.gestures.snapping;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;

public final class SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0 implements Function1 {
    public SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0(FloatRef arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SnapFlingBehavior$fling$result$1.invokeSuspend$lambda$1(this.f$0, this.f$1, ((Float)arg2).floatValue());
    }
}

