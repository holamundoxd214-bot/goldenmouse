package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

public final class BufferedChannel$$ExternalSyntheticLambda0 implements Function3 {
    public BufferedChannel$$ExternalSyntheticLambda0(Object arg1, BufferedChannel arg2, SelectInstance arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg7, Object arg8, Object arg9) {
        return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(this.f$0, this.f$1, this.f$2, arg7, arg8, arg9);
    }
}

