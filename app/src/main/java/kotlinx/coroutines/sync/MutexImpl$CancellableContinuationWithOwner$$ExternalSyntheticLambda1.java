package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function1;

public final class MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda1 implements Function1 {
    public MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda1(MutexImpl arg1, CancellableContinuationWithOwner arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return CancellableContinuationWithOwner.resume$lambda$6(this.f$0, this.f$1, ((Throwable)arg2));
    }
}

