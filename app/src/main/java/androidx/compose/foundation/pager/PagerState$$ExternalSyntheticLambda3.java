package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.jvm.functions.Function1;

public final class PagerState$$ExternalSyntheticLambda3 implements Function1 {
    public PagerState$$ExternalSyntheticLambda3(PagerState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return PagerState.prefetchState$lambda$0(this.f$0, ((NestedPrefetchScope)arg1));
    }
}

