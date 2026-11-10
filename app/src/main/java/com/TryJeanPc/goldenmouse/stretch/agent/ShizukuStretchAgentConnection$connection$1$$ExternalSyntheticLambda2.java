package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder$DeathRecipient;
import android.os.IBinder;
import kotlin.jvm.functions.Function0;

public final class ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda2 implements Function0 {
    public ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda2(IBinder arg1, IBinder$DeathRecipient arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return ShizukuStretchAgentConnection$connection$1.onServiceConnected$lambda$4$lambda$2(this.f$0, this.f$1);
    }
}

