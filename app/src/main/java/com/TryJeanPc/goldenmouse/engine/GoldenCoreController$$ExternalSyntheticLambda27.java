package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.jvm.functions.Function2;

public final class GoldenCoreController$$ExternalSyntheticLambda27 implements Function2 {
    public GoldenCoreController$$ExternalSyntheticLambda27(GoldenCoreController arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return Boolean.valueOf(GoldenCoreController.createFreeLook$lambda$5(this.f$0, ((Long)arg3).longValue(), ((InputBinding)arg4)));
    }
}

