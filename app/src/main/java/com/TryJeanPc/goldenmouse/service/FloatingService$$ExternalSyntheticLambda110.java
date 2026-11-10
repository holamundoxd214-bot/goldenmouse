package com.TryJeanPc.goldenmouse.service;

import android.graphics.Rect;
import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import kotlin.jvm.internal.Ref$IntRef;

public final class FloatingService$$ExternalSyntheticLambda110 implements View$OnTouchListener {
    public FloatingService$$ExternalSyntheticLambda110(AudioManager arg1, IntRef arg2, View arg3, int arg4, Rect arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final boolean onTouch(View arg8, MotionEvent arg9) {
        return FloatingService.configurarSliders$lambda$212(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg8, arg9);
    }
}

