package androidx.compose.foundation.pager;

import kotlin.jvm.functions.Function1;

public final class PagerState$$ExternalSyntheticLambda0 implements Function1 {
    public PagerState$$ExternalSyntheticLambda0(PagerState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Float.valueOf(PagerState.scrollableState$lambda$0(this.f$0, ((Float)arg1).floatValue()));
    }
}

