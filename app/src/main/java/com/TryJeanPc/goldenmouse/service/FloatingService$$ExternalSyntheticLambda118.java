package com.TryJeanPc.goldenmouse.service;

import android.content.SharedPreferences;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;

public final class FloatingService$$ExternalSyntheticLambda118 implements CompoundButton$OnCheckedChangeListener {
    public FloatingService$$ExternalSyntheticLambda118(SharedPreferences arg1, FloatingService arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onCheckedChanged(CompoundButton arg2, boolean arg3) {
        FloatingService.enlazarControlesAjustes$lambda$180(this.f$0, this.f$1, arg2, arg3);
    }
}

