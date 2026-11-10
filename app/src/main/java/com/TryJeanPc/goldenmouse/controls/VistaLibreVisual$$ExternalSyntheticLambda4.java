package com.TryJeanPc.goldenmouse.controls;

import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class VistaLibreVisual$$ExternalSyntheticLambda4 implements View$OnKeyListener {
    public VistaLibreVisual$$ExternalSyntheticLambda4(BooleanRef arg1, BooleanRef arg2, Function1 arg3, VistaLibreVisual arg4, ObjectRef arg5, ObjectRef arg6, TextView arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final boolean onKey(View arg11, int arg12, KeyEvent arg13) {
        return VistaLibreVisual.conectarPanel$lambda$16(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, arg11, arg12, arg13);
    }
}

