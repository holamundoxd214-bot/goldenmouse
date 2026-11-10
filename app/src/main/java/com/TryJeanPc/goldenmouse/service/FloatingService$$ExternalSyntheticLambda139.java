package com.TryJeanPc.goldenmouse.service;

import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.view.View;

public final class FloatingService$$ExternalSyntheticLambda139 implements DialogInterface$OnDismissListener {
    public FloatingService$$ExternalSyntheticLambda139(View arg1, FloatingService arg2, Dialog arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onDismiss(DialogInterface arg3) {
        FloatingService.mostrarRetrocesoVisual$lambda$150(this.f$0, this.f$1, this.f$2, arg3);
    }
}

