package com.TryJeanPc.goldenmouse.input;

public final class GameForegroundMonitor$$ExternalSyntheticLambda7 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda7(GameForegroundMonitor arg1, long arg2, long arg4, String arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg6;
    }

    public final void run() {
        GameForegroundMonitor.observe$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

