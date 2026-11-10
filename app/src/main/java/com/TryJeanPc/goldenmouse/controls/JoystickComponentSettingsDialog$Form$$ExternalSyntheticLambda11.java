package com.TryJeanPc.goldenmouse.controls;

import android.view.View$OnClickListener;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;

public final class JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda11 implements View$OnClickListener {
    public JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda11(BooleanRef arg1, Form arg2, FloatRef arg3, float arg4, Function0 arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final void onClick(View arg7) {
        Form.bindRadioContent$lambda$37(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg7);
    }
}

