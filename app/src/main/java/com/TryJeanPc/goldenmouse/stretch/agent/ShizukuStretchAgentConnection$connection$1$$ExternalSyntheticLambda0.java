package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import kotlin.jvm.functions.Function1;

public final class ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda0 implements Function1 {
    public ShizukuStretchAgentConnection$connection$1$$ExternalSyntheticLambda0(ShizukuStretchAgentConnection arg1, IBinder arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return ShizukuStretchAgentConnection$connection$1.onServiceConnected$lambda$4$lambda$0(this.f$0, this.f$1, ((StretchAgentRequest)arg2));
    }
}

