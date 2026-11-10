package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class LazyListItemProviderImpl$$ExternalSyntheticLambda0 implements Function2 {
    public LazyListItemProviderImpl$$ExternalSyntheticLambda0(LazyListItemProviderImpl arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return LazyListItemProviderImpl.Item$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

