package com.TryJeanPc.goldenmouse.service;

import android.content.SharedPreferences;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;

public final class FloatingService$$ExternalSyntheticLambda120 implements CompoundButton$OnCheckedChangeListener {
    public FloatingService$$ExternalSyntheticLambda120(SharedPreferences arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCheckedChanged(CompoundButton arg1, boolean arg2) {
        FloatingService.enlazarControlesAjustes$lambda$193(this.f$0, arg1, arg2);
    }
}

