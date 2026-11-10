package kotlinx.coroutines.sync;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

public final class MutexImpl$$ExternalSyntheticLambda0 implements Function3 {
    public MutexImpl$$ExternalSyntheticLambda0(MutexImpl arg1, Object arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1$lambda$0(this.f$0, this.f$1, ((Throwable)arg2), arg3, ((CoroutineContext)arg4));
    }
}

