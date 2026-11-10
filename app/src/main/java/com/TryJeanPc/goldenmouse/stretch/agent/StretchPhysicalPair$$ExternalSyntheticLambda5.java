package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchGeometryPlan;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import kotlin.jvm.functions.Function1;

public final class StretchPhysicalPair$$ExternalSyntheticLambda5 implements Function1 {
    public StretchPhysicalPair$$ExternalSyntheticLambda5(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchGeometryPlan arg3, StretchSize arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return Boolean.valueOf(StretchPhysicalPair.apply$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, ((StretchOriginalEvidence)arg4)));
    }
}

