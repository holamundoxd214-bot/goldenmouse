package com.TryJeanPc.goldenmouse.service;

import android.app.AlertDialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;

public final class FloatingService$$ExternalSyntheticLambda13 implements DialogInterface$OnDismissListener {
    public FloatingService$$ExternalSyntheticLambda13(FloatingService arg1, AlertDialog arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onDismiss(DialogInterface arg2) {
        FloatingService.mostrarDiagnosticoCamara$lambda$64(this.f$0, this.f$1, arg2);
    }
}

