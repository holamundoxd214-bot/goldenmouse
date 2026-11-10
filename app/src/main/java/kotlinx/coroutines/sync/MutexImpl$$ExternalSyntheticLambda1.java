package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

public final class MutexImpl$$ExternalSyntheticLambda1 implements Function3 {
    public MutexImpl$$ExternalSyntheticLambda1(MutexImpl arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1(this.f$0, ((SelectInstance)arg1), arg2, arg3);
    }
}

