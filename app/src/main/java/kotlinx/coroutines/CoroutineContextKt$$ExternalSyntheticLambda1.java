package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CoroutineContextKt$$ExternalSyntheticLambda1 implements Function2 {
    public CoroutineContextKt$$ExternalSyntheticLambda1(ObjectRef arg1, boolean arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CoroutineContextKt.foldCopies$lambda$1(this.f$0, this.f$1, ((CoroutineContext)arg2), ((Element)arg3));
    }
}

