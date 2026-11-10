package com.TryJeanPc.goldenmouse.engine;

import kotlin.jvm.functions.Function0;

public final class TimedActionScheduler$$ExternalSyntheticLambda1 implements Runnable {
    public TimedActionScheduler$$ExternalSyntheticLambda1(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        TimedActionScheduler.schedule$lambda$2(this.f$0);
    }
}

