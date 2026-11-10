package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class LazyListScope$$ExternalSyntheticLambda2 implements Function3 {
    public LazyListScope$$ExternalSyntheticLambda2(Function4 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return LazyListScope.stickyHeader$lambda$1(this.f$0, ((LazyItemScope)arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

