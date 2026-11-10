package com.TryJeanPc.goldenmouse.input;

public final class GameForegroundMonitor$$ExternalSyntheticLambda0 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda0(GameForegroundMonitor arg1, long arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        GameForegroundMonitor.select$lambda$1(this.f$0, this.f$1);
    }
}

