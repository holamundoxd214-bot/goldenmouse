package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
import kotlin.jvm.functions.Function0;

public final class GoldenStretchDisplayService$$ExternalSyntheticLambda16 implements Function0 {
    public GoldenStretchDisplayService$$ExternalSyntheticLambda16(Parcel arg1, StretchAgentReply arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return GoldenStretchDisplayService.onTransact$lambda$22(this.f$0, this.f$1);
    }
}

