package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.function.BiConsumer;
import kotlin.jvm.functions.Function2;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda10 implements BiConsumer {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda10(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1, Object arg2) {
        ShizukuStretchAgentConnection.close$lambda$29(this.f$0, arg1, arg2);
    }
}

