package kotlinx.coroutines.debug.internal;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public final class AgentPremain$$ExternalSyntheticLambda0 implements SignalHandler {
    public AgentPremain$$ExternalSyntheticLambda0() {
        super();
    }

    public final void handle(Signal arg1) {
        AgentPremain.installSignalHandler$lambda$1(arg1);
    }
}

