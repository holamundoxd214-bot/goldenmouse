package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.jvm.functions.Function1;

public final class LazyListState$Companion$$ExternalSyntheticLambda1 implements Function1 {
    public LazyListState$Companion$$ExternalSyntheticLambda1(LazyListPrefetchStrategy arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Companion.saver$lambda$1(this.f$0, ((List)arg1));
    }
}

