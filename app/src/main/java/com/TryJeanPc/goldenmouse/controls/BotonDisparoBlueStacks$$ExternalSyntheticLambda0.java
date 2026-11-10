package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

public final class BotonDisparoBlueStacks$$ExternalSyntheticLambda0 implements Function1 {
    public BotonDisparoBlueStacks$$ExternalSyntheticLambda0(BotonDisparoBlueStacks arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(BotonDisparoBlueStacks.dispatchTouchEvent$lambda$1(this.f$0, ((MotionEvent)arg1)));
    }
}

