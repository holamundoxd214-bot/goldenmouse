package com.TryJeanPc.goldenmouse.service;

import com.TryJeanPc.goldenmouse.controls.BotonVistaBlueStacks;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.jvm.functions.Function1;

public final class FloatingService$$ExternalSyntheticLambda47 implements Function1 {
    public FloatingService$$ExternalSyntheticLambda47(BotonVistaBlueStacks arg1, FloatingService arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(FloatingService.conectarConfiguracionAvanzada$lambda$287$lambda$281(this.f$0, this.f$1, ((InputBinding)arg2)));
    }
}

