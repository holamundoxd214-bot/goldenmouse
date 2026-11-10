package com.TryJeanPc.goldenmouse.controls;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class EditorHitDispatcher$Companion$$ExternalSyntheticLambda0 implements View$OnTouchListener {
    public EditorHitDispatcher$Companion$$ExternalSyntheticLambda0(ObjectRef arg1, ViewGroup arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean onTouch(View arg2, MotionEvent arg3) {
        return Companion.installFallback$lambda$0(this.f$0, this.f$1, arg2, arg3);
    }
}

