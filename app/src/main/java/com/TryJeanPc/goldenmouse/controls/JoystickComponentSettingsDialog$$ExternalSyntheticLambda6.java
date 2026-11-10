package com.TryJeanPc.goldenmouse.controls;

import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

public final class JoystickComponentSettingsDialog$$ExternalSyntheticLambda6 implements DialogInterface$OnCancelListener {
    public JoystickComponentSettingsDialog$$ExternalSyntheticLambda6(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel(DialogInterface arg1) {
        JoystickComponentSettingsDialog.show$lambda$6$lambda$4(this.f$0, arg1);
    }
}

