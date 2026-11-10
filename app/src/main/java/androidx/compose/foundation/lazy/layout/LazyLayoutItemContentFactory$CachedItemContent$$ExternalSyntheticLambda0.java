package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class LazyLayoutItemContentFactory$CachedItemContent$$ExternalSyntheticLambda0 implements Function2 {
    public LazyLayoutItemContentFactory$CachedItemContent$$ExternalSyntheticLambda0(LazyLayoutItemContentFactory arg1, CachedItemContent arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CachedItemContent.createContentLambda$lambda$0(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

