package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda3 implements Function4 {
    public LazyStaggeredGridIntervalContent$$ExternalSyntheticLambda3(Function3 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return LazyStaggeredGridIntervalContent.item$lambda$3(this.f$0, ((LazyStaggeredGridItemScope)arg1), ((Integer)arg2).intValue(), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

