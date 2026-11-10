package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class CancellableContinuationImpl$$ExternalSyntheticLambda0 implements Function3 {
    public CancellableContinuationImpl$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return CancellableContinuationImpl.resume$lambda$13$lambda$12(this.f$0, ((Throwable)arg1), arg2, ((CoroutineContext)arg3));
    }
}

