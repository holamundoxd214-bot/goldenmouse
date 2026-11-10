package com.TryJeanPc.goldenmouse.macro.execution;

import java.util.concurrent.ScheduledFuture;

public final class TimedMacroScheduler$$ExternalSyntheticLambda1 implements MacroTask {
    public TimedMacroScheduler$$ExternalSyntheticLambda1(ScheduledFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void cancel() {
        TimedMacroScheduler.schedule$lambda$4(this.f$0);
    }
}

