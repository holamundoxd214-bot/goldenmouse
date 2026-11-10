package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

public final class GoldenStretchDisplayService$$ExternalSyntheticLambda11 implements Function2 {
    public GoldenStretchDisplayService$$ExternalSyntheticLambda11(IBinder arg1, String arg2, StretchAgentRequest arg3, IntRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return GoldenStretchDisplayService.onTransact$lambda$16(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Boolean)arg8).booleanValue());
    }
}

