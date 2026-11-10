package com.TryJeanPc.goldenmouse.service;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import com.TryJeanPc.goldenmouse.controls.ControlConTecla;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class FloatingService$$ExternalSyntheticLambda173 implements View$OnTouchListener {
    public FloatingService$$ExternalSyntheticLambda173(FloatingService arg1, ControlConTecla arg2, Object arg3, BooleanRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final boolean onTouch(View arg7, MotionEvent arg8) {
        return FloatingService.abrirEditorTecla$lambda$307(this.f$0, this.f$1, this.f$2, this.f$3, arg7, arg8);
    }
}

