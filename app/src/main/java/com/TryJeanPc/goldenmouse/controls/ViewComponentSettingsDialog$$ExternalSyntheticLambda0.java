package com.TryJeanPc.goldenmouse.controls;

import android.widget.Switch;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class ViewComponentSettingsDialog$$ExternalSyntheticLambda0 implements Function1 {
    public ViewComponentSettingsDialog$$ExternalSyntheticLambda0(Function1 arg1, ViewComponent arg2, Switch arg3, ObjectRef arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return ViewComponentSettingsDialog.bindContent$lambda$10$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, ((InputBinding)arg4));
    }
}

