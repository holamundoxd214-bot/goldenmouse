package com.TryJeanPc.goldenmouse.input;

import java.util.concurrent.LinkedBlockingQueue;

public final class GoldenInputEngine$$ExternalSyntheticLambda9 implements Runnable {
    public GoldenInputEngine$$ExternalSyntheticLambda9(DeviceCaptureSession arg1, GoldenInputEngine arg2, LinkedBlockingQueue arg3, long arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void run() {
        GoldenInputEngine.readCaptureSessions$lambda$28$lambda$27(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

