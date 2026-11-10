package androidx.compose.foundation.lazy;

import kotlin.jvm.functions.Function2;

public final class LazyListItemProviderImpl$$ExternalSyntheticLambda1 implements Function2 {
    public LazyListItemProviderImpl$$ExternalSyntheticLambda1(LazyListItemProviderImpl arg1, int arg2, Object arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return LazyListItemProviderImpl.Item$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

