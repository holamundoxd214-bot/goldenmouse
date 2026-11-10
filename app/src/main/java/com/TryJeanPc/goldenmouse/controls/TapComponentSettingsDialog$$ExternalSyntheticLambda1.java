package com.TryJeanPc.goldenmouse.controls;

import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class TapComponentSettingsDialog$$ExternalSyntheticLambda1 implements DialogInterface$OnDismissListener {
    public TapComponentSettingsDialog$$ExternalSyntheticLambda1(ObjectRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onDismiss(DialogInterface arg1) {
        TapComponentSettingsDialog.show$lambda$1(this.f$0, arg1);
    }
}

