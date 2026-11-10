package com.TryJeanPc.goldenmouse.service;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.FrameLayout;
import com.TryJeanPc.goldenmouse.controls.ControlEliminable;
import com.TryJeanPc.goldenmouse.controls.ControlVisual;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;

public final class FloatingService$$ExternalSyntheticLambda87 implements View$OnTouchListener {
    public FloatingService$$ExternalSyntheticLambda87(View arg1, FloatingService arg2, BooleanRef arg3, FloatRef arg4, FloatRef arg5, FloatRef arg6, FloatRef arg7, BooleanRef arg8, FrameLayout arg9, int[] arg10, ControlVisual arg11, ControlEliminable arg12, boolean arg13) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
        this.f$9 = arg10;
        this.f$10 = arg11;
        this.f$11 = arg12;
        this.f$12 = arg13;
    }

    public final boolean onTouch(View arg16, MotionEvent arg17) {
        return FloatingService.crearControlArrastrable$lambda$224(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, arg16, arg17);
    }
}

