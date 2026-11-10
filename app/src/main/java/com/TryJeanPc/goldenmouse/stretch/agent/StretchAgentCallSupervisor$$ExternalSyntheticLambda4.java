package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.jvm.functions.Function2;

public final class StretchAgentCallSupervisor$$ExternalSyntheticLambda4 implements Function2 {
    public StretchAgentCallSupervisor$$ExternalSyntheticLambda4(StretchAgentCallSupervisor arg1, Work arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return StretchAgentCallSupervisor.submit$lambda$5$lambda$3(this.f$0, this.f$1, ((StretchAgentReply)arg2), ((Throwable)arg3));
    }
}

