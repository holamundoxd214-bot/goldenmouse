package com.TryJeanPc.goldenmouse.macro.editor;

import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;

public final class MacroEditorController$$ExternalSyntheticLambda5 implements DialogInterface$OnDismissListener {
    public MacroEditorController$$ExternalSyntheticLambda5(MacroEditorController arg1, Dialog arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onDismiss(DialogInterface arg2) {
        MacroEditorController.showChild$lambda$46(this.f$0, this.f$1, arg2);
    }
}

