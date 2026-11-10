package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import kotlin.jvm.functions.Function1;

public final class LazySaveableStateHolder$$ExternalSyntheticLambda2 implements Function1 {
    public LazySaveableStateHolder$$ExternalSyntheticLambda2(SaveableStateRegistry arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(LazySaveableStateHolder._init_$lambda$0(this.f$0, arg1));
    }
}

