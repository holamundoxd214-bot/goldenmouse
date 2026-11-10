package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import kotlin.jvm.functions.Function0;

public final class ActionExecutor$$ExternalSyntheticLambda2 implements Function0 {
    public ActionExecutor$$ExternalSyntheticLambda2(ActionExecutor arg1, MappedControlBinding arg2, long arg3, long arg5, TapComponent arg7, int arg8) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg5;
        this.f$4 = arg7;
        this.f$5 = arg8;
    }

    public final Object invoke() {
        return ActionExecutor.scheduleTapPulse$lambda$9$lambda$8$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}

