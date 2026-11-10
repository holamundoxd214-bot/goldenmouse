package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.jvm.functions.Function1;

public final class LazyStaggeredGridMeasureResultKt$$ExternalSyntheticLambda0 implements Function1 {
    public LazyStaggeredGridMeasureResultKt$$ExternalSyntheticLambda0(int arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Integer.valueOf(LazyStaggeredGridMeasureResultKt.findVisibleItem$lambda$0(this.f$0, ((LazyStaggeredGridItemInfo)arg1)));
    }
}

