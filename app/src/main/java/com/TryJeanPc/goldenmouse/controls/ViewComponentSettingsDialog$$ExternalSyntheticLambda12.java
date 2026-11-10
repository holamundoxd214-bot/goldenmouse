package com.TryJeanPc.goldenmouse.controls;

import android.view.View$OnLongClickListener;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class ViewComponentSettingsDialog$$ExternalSyntheticLambda12 implements View$OnLongClickListener {
    public ViewComponentSettingsDialog$$ExternalSyntheticLambda12(BooleanRef arg1, VistaInlineBindingCapture arg2, ObjectRef arg3, TextView arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final boolean onLongClick(View arg4) {
        return ViewComponentSettingsDialog.bindContent$lambda$11(this.f$0, this.f$1, this.f$2, this.f$3, arg4);
    }
}

