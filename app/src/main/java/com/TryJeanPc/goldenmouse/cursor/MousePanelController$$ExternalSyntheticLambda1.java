package com.TryJeanPc.goldenmouse.cursor;

import android.app.AlertDialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;

public final class MousePanelController$$ExternalSyntheticLambda1 implements DialogInterface$OnDismissListener {
    public MousePanelController$$ExternalSyntheticLambda1(MousePanelController arg1, AlertDialog arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onDismiss(DialogInterface arg2) {
        MousePanelController.show$lambda$13(this.f$0, this.f$1, arg2);
    }
}

