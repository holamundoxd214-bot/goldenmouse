package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import kotlin.jvm.functions.Function2;

public final class ActionExecutor$$ExternalSyntheticLambda0 implements Function2 {
    public ActionExecutor$$ExternalSyntheticLambda0(ActionExecutor arg1, long arg2, long arg4, MappedControlBinding arg6, long arg7, JoystickRuntimeState arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg6;
        this.f$4 = arg7;
        this.f$5 = arg9;
    }

    public final Object invoke(Object arg12, Object arg13) {
        return Boolean.valueOf(ActionExecutor.moveJoystick$lambda$13(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, ((Float)arg12).floatValue(), ((Float)arg13).floatValue()));
    }
}

