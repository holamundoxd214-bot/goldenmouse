package com.TryJeanPc.goldenmouse.graphics;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

public final class GraphicsCommandRunner$$ExternalSyntheticLambda7 implements Callable {
    public GraphicsCommandRunner$$ExternalSyntheticLambda7(boolean arg1, Function0 arg2, AtomicReference arg3, GraphicsAttemptLog arg4, String arg5, Function0 arg6, GraphicsCommandRunner arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final Object call() {
        return GraphicsCommandRunner.run$lambda$15(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}

