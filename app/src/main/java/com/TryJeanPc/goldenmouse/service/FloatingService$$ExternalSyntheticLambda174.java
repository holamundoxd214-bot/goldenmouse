package com.TryJeanPc.goldenmouse.service;

import android.view.MotionEvent;
import android.view.View$OnGenericMotionListener;
import android.view.View;
import com.TryJeanPc.goldenmouse.controls.ControlConTecla;

public final class FloatingService$$ExternalSyntheticLambda174 implements View$OnGenericMotionListener {
    public FloatingService$$ExternalSyntheticLambda174(FloatingService arg1, ControlConTecla arg2, Object arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final boolean onGenericMotion(View arg3, MotionEvent arg4) {
        return FloatingService.abrirEditorTecla$lambda$308(this.f$0, this.f$1, this.f$2, arg3, arg4);
    }
}

