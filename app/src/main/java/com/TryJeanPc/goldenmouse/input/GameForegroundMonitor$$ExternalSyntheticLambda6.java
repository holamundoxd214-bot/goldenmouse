package com.TryJeanPc.goldenmouse.input;

import java.util.Set;

public final class GameForegroundMonitor$$ExternalSyntheticLambda6 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda6(GameForegroundMonitor arg1, long arg2, long arg4, Set arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg6;
    }

    public final void run() {
        GameForegroundMonitor.observe$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

