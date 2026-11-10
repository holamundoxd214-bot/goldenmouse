package com.TryJeanPc.goldenmouse.shizuku;

import kotlin.jvm.functions.Function0;

public final class GoldenInputServiceConnection$$ExternalSyntheticLambda1 implements Function0 {
    public GoldenInputServiceConnection$$ExternalSyntheticLambda1(GoldenInputServiceConnection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke() {
        return Boolean.valueOf(GoldenInputServiceConnection.awaitConnected$lambda$2$lambda$1(this.f$0));
    }
}

