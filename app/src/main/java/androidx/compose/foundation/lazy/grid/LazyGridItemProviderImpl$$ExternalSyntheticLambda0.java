package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class LazyGridItemProviderImpl$$ExternalSyntheticLambda0 implements Function2 {
    public LazyGridItemProviderImpl$$ExternalSyntheticLambda0(LazyGridItemProviderImpl arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return LazyGridItemProviderImpl.Item$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

