package com.TryJeanPc.goldenmouse.input;

import android.os.IBinder$DeathRecipient;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ForegroundObserverMain$$ExternalSyntheticLambda1 implements IBinder$DeathRecipient {
    public ForegroundObserverMain$$ExternalSyntheticLambda1(AtomicBoolean arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void binderDied() {
        ForegroundObserverMain.main$lambda$4(this.f$0);
    }
}

