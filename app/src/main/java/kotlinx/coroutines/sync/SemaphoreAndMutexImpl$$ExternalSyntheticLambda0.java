package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

public final class SemaphoreAndMutexImpl$$ExternalSyntheticLambda0 implements Function3 {
    public SemaphoreAndMutexImpl$$ExternalSyntheticLambda0(SemaphoreAndMutexImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return SemaphoreAndMutexImpl.onCancellationRelease$lambda$2(this.f$0, ((Throwable)arg1), ((Unit)arg2), ((CoroutineContext)arg3));
    }
}

