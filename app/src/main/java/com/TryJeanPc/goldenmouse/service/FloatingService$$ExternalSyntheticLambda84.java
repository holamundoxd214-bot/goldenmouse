package com.TryJeanPc.goldenmouse.service;

import android.os.ResultReceiver;
import kotlin.jvm.functions.Function1;

public final class FloatingService$$ExternalSyntheticLambda84 implements Function1 {
    public FloatingService$$ExternalSyntheticLambda84(FloatingService arg1, ResultReceiver arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return FloatingService.onStartCommand$lambda$58(this.f$0, this.f$1, ((String)arg2));
    }
}

