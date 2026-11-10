package androidx.compose.runtime.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;

public final class AwaiterQueue$$ExternalSyntheticLambda0 implements Function0 {
    public AwaiterQueue$$ExternalSyntheticLambda0(Awaiter arg1, AwaiterQueue arg2, IntRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return AwaiterQueue.addAwaiter$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}

