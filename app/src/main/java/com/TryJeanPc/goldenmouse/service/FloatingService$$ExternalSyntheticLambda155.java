package com.TryJeanPc.goldenmouse.service;

import android.graphics.Rect;
import android.media.AudioManager;
import android.view.View;
import kotlin.jvm.internal.Ref$IntRef;

public final class FloatingService$$ExternalSyntheticLambda155 implements Runnable {
    public FloatingService$$ExternalSyntheticLambda155(View arg1, IntRef arg2, AudioManager arg3, int arg4, Rect arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final void run() {
        FloatingService.configurarSliders$lambda$217$lambda$215(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

