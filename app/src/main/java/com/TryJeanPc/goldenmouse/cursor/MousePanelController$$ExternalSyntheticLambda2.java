package com.TryJeanPc.goldenmouse.cursor;

import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import java.util.List;

public final class MousePanelController$$ExternalSyntheticLambda2 implements DialogInterface$OnClickListener {
    public MousePanelController$$ExternalSyntheticLambda2(MousePanelController arg1, List arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onClick(DialogInterface arg2, int arg3) {
        MousePanelController.loadDialog$lambda$12(this.f$0, this.f$1, arg2, arg3);
    }
}

