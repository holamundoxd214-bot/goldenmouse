package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.input.InputEvent;
import kotlin.jvm.functions.Function1;

public final class GoldenCoreController$listener$1$$ExternalSyntheticLambda2 implements Function1 {
    public GoldenCoreController$listener$1$$ExternalSyntheticLambda2(boolean arg1, GoldenCoreController arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return GoldenCoreController$listener$1.onInputEvent$lambda$4(this.f$0, this.f$1, ((InputEvent)arg2));
    }
}

