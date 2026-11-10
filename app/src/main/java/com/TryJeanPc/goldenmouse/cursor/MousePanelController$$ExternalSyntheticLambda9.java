package com.TryJeanPc.goldenmouse.cursor;

import android.app.AlertDialog;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.EditText;

public final class MousePanelController$$ExternalSyntheticLambda9 implements View$OnClickListener {
    public MousePanelController$$ExternalSyntheticLambda9(EditText arg1, AlertDialog arg2, MousePanelController arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onClick(View arg3) {
        MousePanelController.saveDialog$lambda$11(this.f$0, this.f$1, this.f$2, arg3);
    }
}

