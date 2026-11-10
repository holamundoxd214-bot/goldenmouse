package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class LazyGridIntervalContent$$ExternalSyntheticLambda5 implements Function4 {
    public LazyGridIntervalContent$$ExternalSyntheticLambda5(Function3 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return LazyGridIntervalContent.item$lambda$3(this.f$0, ((LazyGridItemScope)arg1), ((Integer)arg2).intValue(), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

