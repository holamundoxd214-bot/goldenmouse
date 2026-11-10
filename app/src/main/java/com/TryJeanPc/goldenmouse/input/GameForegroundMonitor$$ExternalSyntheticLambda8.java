package com.TryJeanPc.goldenmouse.input;

public final class GameForegroundMonitor$$ExternalSyntheticLambda8 implements Runnable {
    public GameForegroundMonitor$$ExternalSyntheticLambda8(GameForegroundMonitor arg1, CaptureStream arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        GameForegroundMonitor.closeStreamAsync$lambda$13(this.f$0, this.f$1);
    }
}

