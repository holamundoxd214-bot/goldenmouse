package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings$Global;

public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1f;

    static {
    }

    public AnimatorDurationScaleProvider() {
        super();
    }

    public float getSystemAnimatorDurationScale(ContentResolver arg2) {
        return Settings$Global.getFloat(arg2, "animator_duration_scale", 1f);
    }

    public static void setDefaultSystemAnimatorDurationScale(float arg0) {
        AnimatorDurationScaleProvider.defaultSystemAnimatorDurationScale = arg0;
    }
}

