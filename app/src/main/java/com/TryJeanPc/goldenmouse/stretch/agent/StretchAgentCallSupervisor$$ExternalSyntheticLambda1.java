package com.TryJeanPc.goldenmouse.stretch.agent;

public final class StretchAgentCallSupervisor$$ExternalSyntheticLambda1 implements Runnable {
    public StretchAgentCallSupervisor$$ExternalSyntheticLambda1(StretchAgentCallSupervisor arg1, StretchAgentRequest arg2, Work arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        StretchAgentCallSupervisor.submit$lambda$5(this.f$0, this.f$1, this.f$2);
    }
}

