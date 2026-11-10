package com.TryJeanPc.goldenmouse.macro;

public final class TurboEngine$$ExternalSyntheticLambda0 implements Runnable {
    public TurboEngine$$ExternalSyntheticLambda0(TurboEngine arg1, long arg2, int arg4, float arg5, float arg6, long arg7, String arg9, long arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
        this.f$5 = arg7;
        this.f$6 = arg9;
        this.f$7 = arg10;
    }

    public final void run() {
        TurboEngine.scheduleNextCycle$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}

