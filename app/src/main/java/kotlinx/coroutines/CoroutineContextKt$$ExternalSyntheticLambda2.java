package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

public final class CoroutineContextKt$$ExternalSyntheticLambda2 implements Function2 {
    public CoroutineContextKt$$ExternalSyntheticLambda2() {
        super();
    }

    public final Object invoke(Object arg1, Object arg2) {
        return CoroutineContextKt.foldCopies$lambda$2(((CoroutineContext)arg1), ((Element)arg2));
    }
}

