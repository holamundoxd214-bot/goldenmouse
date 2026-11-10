package com.TryJeanPc.goldenmouse.service;

import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.View;
import com.TryJeanPc.goldenmouse.controls.ControlConTecla;
import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class FloatingService$$ExternalSyntheticLambda172 implements View$OnKeyListener {
    public FloatingService$$ExternalSyntheticLambda172(FloatingService arg1, ControlConTecla arg2, Object arg3, VistaActivationCapture arg4, ObjectRef arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final boolean onKey(View arg9, int arg10, KeyEvent arg11) {
        return FloatingService.abrirEditorTecla$lambda$306(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg9, arg10, arg11);
    }
}

