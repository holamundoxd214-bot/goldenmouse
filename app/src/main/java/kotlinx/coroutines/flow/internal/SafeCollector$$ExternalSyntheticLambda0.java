package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

public final class SafeCollector$$ExternalSyntheticLambda0 implements Function2 {
    public SafeCollector$$ExternalSyntheticLambda0() {
        super();
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Integer.valueOf(SafeCollector.collectContextSize$lambda$0(((Integer)arg1).intValue(), ((Element)arg2)));
    }
}

