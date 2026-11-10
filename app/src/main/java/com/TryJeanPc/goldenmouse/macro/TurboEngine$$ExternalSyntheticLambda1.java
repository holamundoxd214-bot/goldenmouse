package com.TryJeanPc.goldenmouse.macro;

public final class TurboEngine$$ExternalSyntheticLambda1 implements Runnable {
    public TurboEngine$$ExternalSyntheticLambda1(TurboEngine arg1, String arg2, int arg3, float arg4, float arg5, long arg6, long arg8, long arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg8;
        this.f$7 = arg10;
    }

    public final void run() {
        TurboEngine.scheduleNextCycle$lambda$6$lambda$5$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}

