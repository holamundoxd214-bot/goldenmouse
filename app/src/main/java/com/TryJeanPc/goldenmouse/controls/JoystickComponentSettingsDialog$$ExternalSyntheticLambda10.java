package com.TryJeanPc.goldenmouse.controls;

import android.app.Dialog;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.View;
import android.widget.EditText;
import kotlin.jvm.functions.Function1;

public final class JoystickComponentSettingsDialog$$ExternalSyntheticLambda10 implements View$OnKeyListener {
    public JoystickComponentSettingsDialog$$ExternalSyntheticLambda10(EditText arg1, Function1 arg2, Dialog arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final boolean onKey(View arg7, int arg8, KeyEvent arg9) {
        return JoystickComponentSettingsDialog.setupKeyDialog$lambda$15$lambda$14(this.f$0, this.f$1, this.f$2, arg7, arg8, arg9);
    }
}

