package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder$DeathRecipient;

public final class ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda1 implements IBinder$DeathRecipient {
    public ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda1(ShizukuStretchAgentConnection arg1, StretchAgentCallSupervisor arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void binderDied() {
        ShizukuStretchAgentConnection$connection$1.onServiceConnected$lambda$4$lambda$1(this.f$0, this.f$1);
    }
}

