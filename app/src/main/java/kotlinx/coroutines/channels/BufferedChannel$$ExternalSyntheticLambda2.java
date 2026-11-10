package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

public final class BufferedChannel$$ExternalSyntheticLambda2 implements Function3 {
    public BufferedChannel$$ExternalSyntheticLambda2(Function1 arg1, Object arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return BufferedChannel.bindCancellationFun$lambda$89(this.f$0, this.f$1, ((Throwable)arg2), arg3, ((CoroutineContext)arg4));
    }
}

