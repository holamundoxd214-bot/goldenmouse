package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

public final class BufferedChannel$$ExternalSyntheticLambda1 implements Function3 {
    public BufferedChannel$$ExternalSyntheticLambda1(BufferedChannel arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(this.f$0, ((SelectInstance)arg1), arg2, arg3);
    }
}

