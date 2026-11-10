package com.TryJeanPc.goldenmouse.input;

public final class GameForegroundMonitor$$ExternalSyntheticLambda2 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda2(GameForegroundMonitor arg1, long arg2, long arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
    }

    public final void run() {
        GameForegroundMonitor.observe$lambda$9(this.f$0, this.f$1, this.f$2);
    }
}

