package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.jvm.functions.Function1;

public final class LazyGridState$Companion$$ExternalSyntheticLambda3 implements Function1 {
    public LazyGridState$Companion$$ExternalSyntheticLambda3(LazyGridPrefetchStrategy arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Companion.saver$lambda$1(this.f$0, ((List)arg1));
    }
}

