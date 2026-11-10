package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.jvm.functions.Function2;

public final class PagerState$animateScrollToPage$3$$ExternalSyntheticLambda0 implements Function2 {
    public PagerState$animateScrollToPage$3$$ExternalSyntheticLambda0(PagerState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return PagerState$animateScrollToPage$3.invokeSuspend$lambda$0(this.f$0, ((ScrollScope)arg1), ((Integer)arg2).intValue());
    }
}

