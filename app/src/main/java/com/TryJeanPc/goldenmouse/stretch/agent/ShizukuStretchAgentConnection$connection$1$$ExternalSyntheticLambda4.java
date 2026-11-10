package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;

public final class ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda4 implements Runnable {
    public ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda4(ShizukuStretchAgentConnection arg1, IBinder arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        ShizukuStretchAgentConnection$connection$1.onServiceConnected$lambda$4(this.f$0, this.f$1);
    }
}

