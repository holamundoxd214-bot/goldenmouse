package com.TryJeanPc.goldenmouse.service;

import android.graphics.Rect;
import android.view.View;

public final class FloatingService$$ExternalSyntheticLambda157 implements Runnable {
    public FloatingService$$ExternalSyntheticLambda157(View arg1, float arg2, int arg3, Rect arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void run() {
        FloatingService.configurarSliders$actualizarNivel$lambda$211(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

