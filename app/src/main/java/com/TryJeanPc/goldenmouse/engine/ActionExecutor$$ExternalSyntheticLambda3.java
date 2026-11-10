package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import kotlin.jvm.functions.Function0;

public final class ActionExecutor$$ExternalSyntheticLambda3 implements Function0 {
    public ActionExecutor$$ExternalSyntheticLambda3(ActionExecutor arg1, long arg2, MappedControlBinding arg4, long arg5, int arg7, TapComponent arg8, long arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg7;
        this.f$5 = arg8;
        this.f$6 = arg9;
    }

    public final Object invoke() {
        return ActionExecutor.scheduleTapPulse$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}

