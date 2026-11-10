package com.TryJeanPc.goldenmouse.service;

import android.content.SharedPreferences;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class FloatingService$$ExternalSyntheticLambda119 implements View$OnClickListener {
    public FloatingService$$ExternalSyntheticLambda119(List arg1, ObjectRef arg2, SharedPreferences arg3, TextView arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onClick(View arg4) {
        FloatingService.enlazarControlesAjustes$lambda$192(this.f$0, this.f$1, this.f$2, this.f$3, arg4);
    }
}

