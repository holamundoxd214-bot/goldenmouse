package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

public final class NextFrameEndCallbackQueue$$ExternalSyntheticLambda1 implements Function0 {
    public NextFrameEndCallbackQueue$$ExternalSyntheticLambda1(NextFrameEndCallbackQueue arg1, Function0 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return NextFrameEndCallbackQueue.onNewAwaiters$lambda$0(this.f$0, this.f$1);
    }
}

