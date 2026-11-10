package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

public final class ThreadContextKt$$ExternalSyntheticLambda1 implements Function2 {
    public ThreadContextKt$$ExternalSyntheticLambda1() {
        super();
    }

    public final Object invoke(Object arg1, Object arg2) {
        return ThreadContextKt.findOne$lambda$1(((ThreadContextElement)arg1), ((Element)arg2));
    }
}

