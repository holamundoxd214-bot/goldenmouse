package com.TryJeanPc.goldenmouse.controls;

import android.widget.TextView;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class VistaLibreVisual$$ExternalSyntheticLambda9 implements Runnable {
    public VistaLibreVisual$$ExternalSyntheticLambda9(InputBinding arg1, BooleanRef arg2, BooleanRef arg3, Function1 arg4, VistaLibreVisual arg5, ObjectRef arg6, ObjectRef arg7, TextView arg8) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
    }

    public final void run() {
        VistaLibreVisual.conectarPanel$lambda$14$lambda$13$lambda$12(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}

