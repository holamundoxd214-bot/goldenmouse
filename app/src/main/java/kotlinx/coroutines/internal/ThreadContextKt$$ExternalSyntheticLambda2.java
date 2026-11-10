package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

public final class ThreadContextKt$$ExternalSyntheticLambda2 implements Function2 {
    public ThreadContextKt$$ExternalSyntheticLambda2() {
        super();
    }

    public final Object invoke(Object arg1, Object arg2) {
        return ThreadContextKt.updateState$lambda$2(((ThreadState)arg1), ((Element)arg2));
    }
}

