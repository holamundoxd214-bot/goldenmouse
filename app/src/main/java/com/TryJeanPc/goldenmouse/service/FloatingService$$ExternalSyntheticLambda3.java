package com.TryJeanPc.goldenmouse.service;

import com.TryJeanPc.goldenmouse.profile.GameProfileStorage$IdRepairPlan;
import kotlin.jvm.functions.Function1;

public final class FloatingService$$ExternalSyntheticLambda3 implements Function1 {
    public FloatingService$$ExternalSyntheticLambda3(FloatingService arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(FloatingService.solicitarReparacionIds$lambda$81(this.f$0, ((IdRepairPlan)arg1)));
    }
}

