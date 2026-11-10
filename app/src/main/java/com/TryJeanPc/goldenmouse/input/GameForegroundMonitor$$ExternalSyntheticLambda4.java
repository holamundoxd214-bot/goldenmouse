package com.TryJeanPc.goldenmouse.input;

public final class GameForegroundMonitor$$ExternalSyntheticLambda4 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda4(GameForegroundMonitor arg1, long arg2, long arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
    }

    public final void run() {
        GameForegroundMonitor.observe$lambda$4(this.f$0, this.f$1, this.f$2);
    }
}

