package com.TryJeanPc.goldenmouse.service;

import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;

public final class FloatingService$$ExternalSyntheticLambda16 implements DialogInterface$OnDismissListener {
    public FloatingService$$ExternalSyntheticLambda16(FloatingService arg1, Dialog arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onDismiss(DialogInterface arg2) {
        FloatingService.mostrarVentanaMacroScript$lambda$255(this.f$0, this.f$1, arg2);
    }
}

