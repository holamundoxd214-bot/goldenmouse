package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.Map;
import kotlin.jvm.functions.Function1;

public final class LazySaveableStateHolder$Companion$$ExternalSyntheticLambda1 implements Function1 {
    public LazySaveableStateHolder$Companion$$ExternalSyntheticLambda1(SaveableStateRegistry arg1, SaveableStateHolder arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Companion.saver$lambda$1(this.f$0, this.f$1, ((Map)arg2));
    }
}

