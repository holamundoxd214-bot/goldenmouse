package com.TryJeanPc.goldenmouse.engine;

import kotlin.jvm.functions.Function2;

public final class GoldenCoreController$$ExternalSyntheticLambda8 implements Function2 {
    public GoldenCoreController$$ExternalSyntheticLambda8(GoldenCoreController arg1, Function2 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return GoldenCoreController.setCursorCallback$lambda$21(this.f$0, this.f$1, ((Float)arg2).floatValue(), ((Float)arg3).floatValue());
    }
}

