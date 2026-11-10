package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class JoystickComponentSettingsDialog$$ExternalSyntheticLambda2 implements Function3 {
    public JoystickComponentSettingsDialog$$ExternalSyntheticLambda2(ObjectRef arg1, Context arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return JoystickComponentSettingsDialog.show$lambda$2(this.f$0, this.f$1, ((String)arg2), ((InputBinding)arg3), ((Function1)arg4));
    }
}

