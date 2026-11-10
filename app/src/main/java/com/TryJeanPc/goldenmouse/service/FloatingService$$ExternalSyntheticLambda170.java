package com.TryJeanPc.goldenmouse.service;

import com.TryJeanPc.goldenmouse.controls.ControlConTecla;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class FloatingService$$ExternalSyntheticLambda170 implements Function1 {
    public FloatingService$$ExternalSyntheticLambda170(ObjectRef arg1, FloatingService arg2, ControlConTecla arg3, Object arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return FloatingService.abrirEditorTecla$lambda$304(this.f$0, this.f$1, this.f$2, this.f$3, ((InputBinding)arg4));
    }
}

