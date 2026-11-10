package com.TryJeanPc.goldenmouse.macro;

public final class TurboEngine$$ExternalSyntheticLambda2 implements Runnable {
    public TurboEngine$$ExternalSyntheticLambda2(TurboEngine arg1, int arg2, long arg3, long arg5, String arg7, long arg8, float arg10, float arg11) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg5;
        this.f$4 = arg7;
        this.f$5 = arg8;
        this.f$6 = arg10;
        this.f$7 = arg11;
    }

    public final void run() {
        TurboEngine.scheduleNextCycle$lambda$6$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}

