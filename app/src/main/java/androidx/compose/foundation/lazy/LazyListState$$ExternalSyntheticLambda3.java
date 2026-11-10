package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.jvm.functions.Function1;

public final class LazyListState$$ExternalSyntheticLambda3 implements Function1 {
    public LazyListState$$ExternalSyntheticLambda3(LazyListState arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return LazyListState.prefetchState$lambda$0(this.f$0, this.f$1, ((NestedPrefetchScope)arg2));
    }
}

