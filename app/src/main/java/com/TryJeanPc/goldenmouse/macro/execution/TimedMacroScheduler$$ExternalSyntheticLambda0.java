package com.TryJeanPc.goldenmouse.macro.execution;

import kotlin.jvm.functions.Function0;

public final class TimedMacroScheduler$$ExternalSyntheticLambda0 implements Runnable {
    public TimedMacroScheduler$$ExternalSyntheticLambda0(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        TimedMacroScheduler.schedule$lambda$3(this.f$0);
    }
}

