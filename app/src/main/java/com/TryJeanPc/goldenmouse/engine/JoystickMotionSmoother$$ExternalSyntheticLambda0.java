package com.TryJeanPc.goldenmouse.engine;

import kotlin.jvm.functions.Function0;

public final class JoystickMotionSmoother$$ExternalSyntheticLambda0 implements Function0 {
    public JoystickMotionSmoother$$ExternalSyntheticLambda0(JoystickMotionSmoother arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke() {
        return JoystickMotionSmoother.scheduleTick$lambda$3(this.f$0);
    }
}

