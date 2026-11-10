package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final class LazyListState$Companion$$ExternalSyntheticLambda3 implements Function1 {
    public LazyListState$Companion$$ExternalSyntheticLambda3(LazyLayoutCacheWindow arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Companion.saver$lambda$3(this.f$0, ((List)arg1));
    }
}

