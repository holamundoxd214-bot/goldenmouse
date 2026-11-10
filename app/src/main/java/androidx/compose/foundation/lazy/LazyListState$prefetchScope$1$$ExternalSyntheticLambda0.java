package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchResultScope;
import kotlin.jvm.functions.Function1;

public final class LazyListState$prefetchScope$1$$ExternalSyntheticLambda0 implements Function1 {
    public LazyListState$prefetchScope$1$$ExternalSyntheticLambda0(Function1 arg1, int arg2, LazyListMeasureResult arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return LazyListState$prefetchScope$1.schedulePrefetch$lambda$1(this.f$0, this.f$1, this.f$2, ((PrefetchResultScope)arg3));
    }
}

