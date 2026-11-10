package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchResultScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class PagerCacheWindowScope$$ExternalSyntheticLambda0 implements Function1 {
    public PagerCacheWindowScope$$ExternalSyntheticLambda0(Function2 arg1, PagerCacheWindowScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return PagerCacheWindowScope.schedulePrefetch$lambda$0(this.f$0, this.f$1, ((PrefetchResultScope)arg2));
    }
}

