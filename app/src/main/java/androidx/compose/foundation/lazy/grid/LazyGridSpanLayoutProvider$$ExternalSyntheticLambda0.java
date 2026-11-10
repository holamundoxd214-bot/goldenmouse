package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function1;

public final class LazyGridSpanLayoutProvider$$ExternalSyntheticLambda0 implements Function1 {
    public LazyGridSpanLayoutProvider$$ExternalSyntheticLambda0(int arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Integer.valueOf(LazyGridSpanLayoutProvider.getLineIndexOfItem$lambda$1(this.f$0, ((Bucket)arg1)));
    }
}

