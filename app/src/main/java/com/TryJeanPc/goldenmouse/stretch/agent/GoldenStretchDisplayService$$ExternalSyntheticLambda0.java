package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder$DeathRecipient;

public final class GoldenStretchDisplayService$$ExternalSyntheticLambda0 implements IBinder$DeathRecipient {
    public GoldenStretchDisplayService$$ExternalSyntheticLambda0(GoldenStretchDisplayService arg1, GoldenStretchDisplayAgent arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void binderDied() {
        GoldenStretchDisplayService.onTransact$lambda$9(this.f$0, this.f$1);
    }
}

