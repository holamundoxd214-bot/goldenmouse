package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class LazySaveableStateHolderKt$$ExternalSyntheticLambda1 implements Function2 {
    public LazySaveableStateHolderKt$$ExternalSyntheticLambda1(Function3 arg1, LazySaveableStateHolder arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return LazySaveableStateHolderKt.LazySaveableStateHolderProvider$lambda$1(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

