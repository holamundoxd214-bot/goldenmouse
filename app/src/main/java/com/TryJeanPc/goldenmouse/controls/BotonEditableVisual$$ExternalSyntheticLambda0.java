package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

public final class BotonEditableVisual$$ExternalSyntheticLambda0 implements Function1 {
    public BotonEditableVisual$$ExternalSyntheticLambda0(BotonEditableVisual arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(BotonEditableVisual.dispatchTouchEvent$lambda$1(this.f$0, ((MotionEvent)arg1)));
    }
}

