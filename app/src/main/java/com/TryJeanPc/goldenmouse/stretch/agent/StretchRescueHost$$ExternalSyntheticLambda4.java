package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder$DeathRecipient;

public final class StretchRescueHost$$ExternalSyntheticLambda4 implements IBinder$DeathRecipient {
    public StretchRescueHost$$ExternalSyntheticLambda4(StretchRescueHost arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void binderDied() {
        StretchRescueHost.sourceDeath$lambda$0(this.f$0);
    }
}

