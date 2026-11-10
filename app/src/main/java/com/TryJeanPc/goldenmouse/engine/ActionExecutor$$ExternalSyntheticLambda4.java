package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import kotlin.jvm.functions.Function0;

public final class ActionExecutor$$ExternalSyntheticLambda4 implements Function0 {
    public ActionExecutor$$ExternalSyntheticLambda4(ActionExecutor arg1, long arg2, long arg4, MappedControlBinding arg6, long arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg6;
        this.f$4 = arg7;
    }

    public final Object invoke() {
        return ActionExecutor.scheduleJoystickActivation$lambda$17(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

