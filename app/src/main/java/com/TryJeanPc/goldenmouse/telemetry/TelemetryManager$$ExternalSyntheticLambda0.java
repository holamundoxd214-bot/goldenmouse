package com.TryJeanPc.goldenmouse.telemetry;

import kotlin.jvm.functions.Function1;

public final class TelemetryManager$$ExternalSyntheticLambda0 implements Function1 {
    public TelemetryManager$$ExternalSyntheticLambda0(TelemetryManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TelemetryManager.fpsCalculator$lambda$0(this.f$0, ((Integer)arg1).intValue());
    }
}

