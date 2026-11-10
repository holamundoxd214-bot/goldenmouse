package com.TryJeanPc.goldenmouse.service;

import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;

public final class FloatingService$$ExternalSyntheticLambda148 implements SharedPreferences$OnSharedPreferenceChangeListener {
    public FloatingService$$ExternalSyntheticLambda148(FloatingService arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onSharedPreferenceChanged(SharedPreferences arg1, String arg2) {
        FloatingService.decorativePreferenceListener$lambda$7(this.f$0, arg1, arg2);
    }
}

