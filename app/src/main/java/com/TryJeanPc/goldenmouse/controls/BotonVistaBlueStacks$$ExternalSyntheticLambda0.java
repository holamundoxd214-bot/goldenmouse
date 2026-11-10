package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

public final class BotonVistaBlueStacks$$ExternalSyntheticLambda0 implements Function1 {
    public BotonVistaBlueStacks$$ExternalSyntheticLambda0(BotonVistaBlueStacks arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(BotonVistaBlueStacks.dispatchTouchEvent$lambda$14(this.f$0, ((MotionEvent)arg1)));
    }
}

