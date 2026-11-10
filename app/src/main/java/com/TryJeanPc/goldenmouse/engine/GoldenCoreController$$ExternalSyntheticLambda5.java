package com.TryJeanPc.goldenmouse.engine;

import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;

public final class GoldenCoreController$$ExternalSyntheticLambda5 implements Consumer {
    public GoldenCoreController$$ExternalSyntheticLambda5(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        GoldenCoreController.setUiInteractionMode$lambda$27(this.f$0, arg1);
    }
}

