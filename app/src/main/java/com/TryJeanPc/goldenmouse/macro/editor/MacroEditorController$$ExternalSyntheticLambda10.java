package com.TryJeanPc.goldenmouse.macro.editor;

import android.app.AlertDialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;

public final class MacroEditorController$$ExternalSyntheticLambda10 implements DialogInterface$OnDismissListener {
    public MacroEditorController$$ExternalSyntheticLambda10(MacroEditorController arg1, AlertDialog arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onDismiss(DialogInterface arg2) {
        MacroEditorController.requestCancel$lambda$28(this.f$0, this.f$1, arg2);
    }
}

