package com.TryJeanPc.goldenmouse.service;

import android.app.Dialog;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class FloatingService$$ExternalSyntheticLambda137 implements DialogInterface$OnKeyListener {
    public FloatingService$$ExternalSyntheticLambda137(BooleanRef arg1, BooleanRef arg2, View arg3, View arg4, Dialog arg5, FloatingService arg6, View arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final boolean onKey(DialogInterface arg11, int arg12, KeyEvent arg13) {
        return FloatingService.mostrarRetrocesoVisual$lambda$149(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, arg11, arg12, arg13);
    }
}

