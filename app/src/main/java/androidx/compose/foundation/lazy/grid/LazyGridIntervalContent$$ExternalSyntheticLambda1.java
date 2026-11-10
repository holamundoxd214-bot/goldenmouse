package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class LazyGridIntervalContent$$ExternalSyntheticLambda1 implements Function3 {
    public LazyGridIntervalContent$$ExternalSyntheticLambda1(Function4 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return LazyGridIntervalContent.stickyHeader$lambda$2(this.f$0, this.f$1, ((LazyGridItemScope)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

