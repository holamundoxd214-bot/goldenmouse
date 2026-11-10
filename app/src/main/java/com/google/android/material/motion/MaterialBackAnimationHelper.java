package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R$attr;

public abstract class MaterialBackAnimationHelper {
    private static final int CANCEL_DURATION_DEFAULT = 100;
    private static final int HIDE_DURATION_MAX_DEFAULT = 300;
    private static final int HIDE_DURATION_MIN_DEFAULT = 150;
    private static final String TAG = "MaterialBackHelper";
    private BackEventCompat backEvent;
    protected final int cancelDuration;
    protected final int hideDurationMax;
    protected final int hideDurationMin;
    private final TimeInterpolator progressInterpolator;
    protected final View view;

    public MaterialBackAnimationHelper(View arg4) {
        super();
        this.view = arg4;
        Context v4 = arg4.getContext();
        this.progressInterpolator = MotionUtils.resolveThemeInterpolator(v4, attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0f, 0f, 0f, 1f));
        this.hideDurationMax = MotionUtils.resolveThemeDuration(v4, attr.motionDurationMedium2, 300);
        this.hideDurationMin = MotionUtils.resolveThemeDuration(v4, attr.motionDurationShort3, 150);
        this.cancelDuration = MotionUtils.resolveThemeDuration(v4, attr.motionDurationShort2, 100);
    }

    protected float interpolateProgress(float arg1) {
        return this.progressInterpolator.getInterpolation(arg1);
    }

    protected BackEventCompat onCancelBackProgress() {
        if(this.backEvent == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }

        BackEventCompat v0 = this.backEvent;
        this.backEvent = null;
        return v0;
    }

    public BackEventCompat onHandleBackInvoked() {
        BackEventCompat v0 = this.backEvent;
        this.backEvent = null;
        return v0;
    }

    protected void onStartBackProgress(BackEventCompat arg1) {
        this.backEvent = arg1;
    }

    protected BackEventCompat onUpdateBackProgress(BackEventCompat arg3) {
        if(this.backEvent == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }

        BackEventCompat v0 = this.backEvent;
        this.backEvent = arg3;
        return v0;
    }
}

