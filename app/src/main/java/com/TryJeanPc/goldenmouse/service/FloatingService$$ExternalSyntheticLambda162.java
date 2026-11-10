package com.TryJeanPc.goldenmouse.service;

import android.content.SharedPreferences;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;

public final class FloatingService$$ExternalSyntheticLambda162 implements CompoundButton$OnCheckedChangeListener {
    public FloatingService$$ExternalSyntheticLambda162(SharedPreferences arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCheckedChanged(CompoundButton arg1, boolean arg2) {
        FloatingService.mostrarPanelMouse$lambda$176$lambda$170(this.f$0, arg1, arg2);
    }
}

