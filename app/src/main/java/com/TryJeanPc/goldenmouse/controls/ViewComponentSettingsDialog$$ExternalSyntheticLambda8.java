package com.TryJeanPc.goldenmouse.controls;

import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

public final class ViewComponentSettingsDialog$$ExternalSyntheticLambda8 implements DialogInterface$OnDismissListener {
    public ViewComponentSettingsDialog$$ExternalSyntheticLambda8(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onDismiss(DialogInterface arg1) {
        ViewComponentSettingsDialog.show$lambda$1(this.f$0, arg1);
    }
}

