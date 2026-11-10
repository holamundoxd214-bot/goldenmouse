package com.TryJeanPc.goldenmouse.engine;

import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;

public final class GoldenCoreController$listener$1$$ExternalSyntheticLambda0 implements Consumer {
    public GoldenCoreController$listener$1$$ExternalSyntheticLambda0(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        GoldenCoreController$listener$1.onCaptureStopped$lambda$1(this.f$0, arg1);
    }
}

