package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LazyGridCacheWindowScope$$ExternalSyntheticLambda0 implements Function1 {
    public LazyGridCacheWindowScope$$ExternalSyntheticLambda0(Function2 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return LazyGridCacheWindowScope.schedulePrefetch$lambda$0(this.f$0, this.f$1, ((LazyGridPrefetchResultScope)arg2));
    }
}

