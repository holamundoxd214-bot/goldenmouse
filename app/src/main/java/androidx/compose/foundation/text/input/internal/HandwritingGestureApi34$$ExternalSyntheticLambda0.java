package androidx.compose.foundation.text.input.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.MatchResult;

public final class HandwritingGestureApi34$$ExternalSyntheticLambda0 implements Function1 {
    public HandwritingGestureApi34$$ExternalSyntheticLambda0(IntRef arg1, IntRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return HandwritingGestureApi34.performRemoveSpaceGesture$lambda$1(this.f$0, this.f$1, ((MatchResult)arg2));
    }
}

