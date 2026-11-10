package com.TryJeanPc.goldenmouse.controls;

import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class JoystickComponentSettingsDialog$$ExternalSyntheticLambda7 implements DialogInterface$OnDismissListener {
    public JoystickComponentSettingsDialog$$ExternalSyntheticLambda7(Function0 arg1, ObjectRef arg2, Form arg3, Dialog arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onDismiss(DialogInterface arg4) {
        JoystickComponentSettingsDialog.show$lambda$6$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, arg4);
    }
}

