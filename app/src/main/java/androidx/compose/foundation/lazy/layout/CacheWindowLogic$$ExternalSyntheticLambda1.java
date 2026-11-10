package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function2;

public final class CacheWindowLogic$$ExternalSyntheticLambda1 implements Function2 {
    public CacheWindowLogic$$ExternalSyntheticLambda1(CacheWindowLogic arg1, CacheWindowScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CacheWindowLogic.scheduleNextItemIfNeeded$lambda$1(this.f$0, this.f$1, ((Integer)arg2).intValue(), ((Integer)arg3).intValue());
    }
}

