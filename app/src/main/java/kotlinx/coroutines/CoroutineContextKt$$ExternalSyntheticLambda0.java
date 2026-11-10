package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

public final class CoroutineContextKt$$ExternalSyntheticLambda0 implements Function2 {
    public CoroutineContextKt$$ExternalSyntheticLambda0() {
        super();
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(CoroutineContextKt.hasCopyableElements$lambda$0(((Boolean)arg1).booleanValue(), ((Element)arg2)));
    }
}

