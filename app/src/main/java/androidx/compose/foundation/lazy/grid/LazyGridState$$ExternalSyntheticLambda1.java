package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.jvm.functions.Function1;

public final class LazyGridState$$ExternalSyntheticLambda1 implements Function1 {
    public LazyGridState$$ExternalSyntheticLambda1(LazyGridState arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return LazyGridState.prefetchState$lambda$0(this.f$0, this.f$1, ((NestedPrefetchScope)arg2));
    }
}

