package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

public final class VistaLibreVisual$$ExternalSyntheticLambda10 implements Function1 {
    public VistaLibreVisual$$ExternalSyntheticLambda10(VistaLibreVisual arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(VistaLibreVisual.dispatchTouchEvent$lambda$10(this.f$0, ((MotionEvent)arg1)));
    }
}

