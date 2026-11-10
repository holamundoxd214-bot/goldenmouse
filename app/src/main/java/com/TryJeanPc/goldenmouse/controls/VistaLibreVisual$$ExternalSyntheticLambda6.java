package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class VistaLibreVisual$$ExternalSyntheticLambda6 implements View$OnTouchListener {
    public VistaLibreVisual$$ExternalSyntheticLambda6(BooleanRef arg1, BooleanRef arg2, Function1 arg3, VistaLibreVisual arg4, ObjectRef arg5, ObjectRef arg6, TextView arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final boolean onTouch(View arg10, MotionEvent arg11) {
        return VistaLibreVisual.conectarPanel$lambda$20(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, arg10, arg11);
    }
}

