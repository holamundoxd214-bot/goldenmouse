package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

public final class NextFrameEndCallbackQueue$$ExternalSyntheticLambda0 implements Function1 {
    public NextFrameEndCallbackQueue$$ExternalSyntheticLambda0() {
        super();
    }

    public final Object invoke(Object arg1) {
        return NextFrameEndCallbackQueue.markFrameComplete$lambda$0(((NextFrameEndAwaiter)arg1));
    }
}

