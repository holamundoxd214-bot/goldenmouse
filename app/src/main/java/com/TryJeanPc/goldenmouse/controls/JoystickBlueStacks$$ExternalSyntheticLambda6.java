package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

public final class JoystickBlueStacks$$ExternalSyntheticLambda6 implements Function1 {
    public JoystickBlueStacks$$ExternalSyntheticLambda6(JoystickBlueStacks arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(JoystickBlueStacks.dispatchTouchEvent$lambda$1(this.f$0, ((MotionEvent)arg1)));
    }
}

