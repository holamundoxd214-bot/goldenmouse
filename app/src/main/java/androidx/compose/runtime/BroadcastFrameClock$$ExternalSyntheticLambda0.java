package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

public final class BroadcastFrameClock$$ExternalSyntheticLambda0 implements Function1 {
    public BroadcastFrameClock$$ExternalSyntheticLambda0(long arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg3) {
        return BroadcastFrameClock.sendFrame$lambda$0(this.f$0, ((FrameAwaiter)arg3));
    }
}

