package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.function.BiConsumer;
import kotlin.jvm.functions.Function2;

public final class StretchAgentCallSupervisor$$ExternalSyntheticLambda5 implements BiConsumer {
    public StretchAgentCallSupervisor$$ExternalSyntheticLambda5(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1, Object arg2) {
        StretchAgentCallSupervisor.submit$lambda$5$lambda$4(this.f$0, arg1, arg2);
    }
}

