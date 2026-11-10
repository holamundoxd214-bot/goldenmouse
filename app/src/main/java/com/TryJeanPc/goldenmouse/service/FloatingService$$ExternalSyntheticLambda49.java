package com.TryJeanPc.goldenmouse.service;

import com.TryJeanPc.goldenmouse.controls.BotonVistaBlueStacks;
import com.TryJeanPc.goldenmouse.controls.ComponentPlacement;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import kotlin.jvm.functions.Function2;

public final class FloatingService$$ExternalSyntheticLambda49 implements Function2 {
    public FloatingService$$ExternalSyntheticLambda49(BotonVistaBlueStacks arg1, FloatingService arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return Boolean.valueOf(FloatingService.conectarConfiguracionAvanzada$lambda$287$lambda$284(this.f$0, this.f$1, ((ComponentPlacement)arg2), ((ViewComponent)arg3)));
    }
}

