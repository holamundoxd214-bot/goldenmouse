package androidx.compose.foundation.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LazyListCacheWindowScope$$ExternalSyntheticLambda0 implements Function1 {
    public LazyListCacheWindowScope$$ExternalSyntheticLambda0(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return LazyListCacheWindowScope.schedulePrefetch$lambda$0(this.f$0, ((LazyListPrefetchResultScope)arg1));
    }
}

