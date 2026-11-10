package com.TryJeanPc.goldenmouse.service;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;

public final class FloatingService$$ExternalSyntheticLambda111 implements View$OnTouchListener {
    public FloatingService$$ExternalSyntheticLambda111(FloatingService arg1, View arg2, int arg3, Rect arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final boolean onTouch(View arg7, MotionEvent arg8) {
        return FloatingService.configurarSliders$lambda$214(this.f$0, this.f$1, this.f$2, this.f$3, arg7, arg8);
    }
}

