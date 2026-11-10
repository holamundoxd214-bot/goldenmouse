package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.jvm.functions.Function0;

public final class StretchAgentCallSupervisor$$ExternalSyntheticLambda0 implements Function0 {
    public StretchAgentCallSupervisor$$ExternalSyntheticLambda0(StretchAgentCallSupervisor arg1, Work arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return StretchAgentCallSupervisor.submit$lambda$2(this.f$0, this.f$1);
    }
}

