package com.TryJeanPc.goldenmouse.controls;

import android.view.View$OnClickListener;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class ViewComponentSettingsDialog$$ExternalSyntheticLambda10 implements View$OnClickListener {
    public ViewComponentSettingsDialog$$ExternalSyntheticLambda10(BooleanRef arg1, VistaInlineBindingCapture arg2, TextView arg3, Function1 arg4, ViewComponent arg5, Switch arg6, ObjectRef arg7, ObjectRef arg8) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
    }

    public final void onClick(View arg10) {
        ViewComponentSettingsDialog.bindContent$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, arg10);
    }
}

