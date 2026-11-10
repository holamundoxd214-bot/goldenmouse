package com.TryJeanPc.goldenmouse.stretch.physical;

import com.TryJeanPc.goldenmouse.input.GameForegroundObservation;

public final class GoldenStretchGameLifecycle$$ExternalSyntheticLambda5 implements Runnable {
    public GoldenStretchGameLifecycle$$ExternalSyntheticLambda5(GoldenStretchGameLifecycle arg1, GameForegroundObservation arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        GoldenStretchGameLifecycle.observe$lambda$9(this.f$0, this.f$1);
    }
}

