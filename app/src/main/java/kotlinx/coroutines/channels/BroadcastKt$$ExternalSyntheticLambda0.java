package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;

public final class BroadcastKt$$ExternalSyntheticLambda0 implements Function1 {
    public BroadcastKt$$ExternalSyntheticLambda0(ReceiveChannel arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return BroadcastKt.broadcast$lambda$1(this.f$0, ((Throwable)arg1));
    }
}

