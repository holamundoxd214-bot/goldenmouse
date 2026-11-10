package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda0 implements Function2 {
    public LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda0(LazyLayoutItemProvider arg1, int arg2, Object arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return LazyLayoutItemContentFactoryKt.SkippableItem_JVlU9Rs$lambda$0(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

