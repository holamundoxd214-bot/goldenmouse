package com.google.android.material.motion;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R$dimen;
import com.google.android.material.animation.AnimationUtils;

public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper {
    private final float maxScaleXDistance;
    private final float maxScaleYDistance;

    public MaterialBottomContainerBackHelper(View arg2) {
        super(arg2);
        Resources v2 = arg2.getResources();
        this.maxScaleXDistance = v2.getDimension(dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.maxScaleYDistance = v2.getDimension(dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public void cancelBackProgress() {
        if(super.onCancelBackProgress() == null) {
            return;
        }

        Animator v0 = this.createResetScaleAnimator();
        v0.setDuration(((long)this.cancelDuration));
        v0.start();
    }

    private Animator createResetScaleAnimator() {
        AnimatorSet v0 = new AnimatorSet();
        Animator[] v1 = new Animator[2];
        View v2 = this.view;
        Property v3 = View.SCALE_X;
        float[] v5 = new float[1];
        float v7 = 1f;
        v5[0] = v7;
        v1[0] = ObjectAnimator.ofFloat(v2, v3, v5);
        v1[1] = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{v7});
        v0.playTogether(v1);
        if((this.view instanceof ViewGroup)) {
            View v9 = this.view;
            int v1_1;
            for(v1_1 = 0; v1_1 < ((ViewGroup)v9).getChildCount(); ++v1_1) {
                v0.playTogether(new Animator[]{ObjectAnimator.ofFloat(((ViewGroup)v9).getChildAt(v1_1), View.SCALE_Y, new float[]{v7})});
            }
        }

        v0.setInterpolator(new FastOutSlowInInterpolator());
        return ((Animator)v0);
    }

    public void finishBackProgressNotPersistent(BackEventCompat arg6, Animator$AnimatorListener arg7) {
        ObjectAnimator v0 = ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Y, new float[]{(((float)this.view.getHeight())) * this.view.getScaleY()});
        v0.setInterpolator(new FastOutSlowInInterpolator());
        v0.setDuration(((long)AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, arg6.getProgress())));
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                MaterialBottomContainerBackHelper.this.view.setTranslationY(0f);
                MaterialBottomContainerBackHelper.this.updateBackProgress(0f);
            }
        });
        if(arg7 != null) {
            v0.addListener(arg7);
        }

        v0.start();
    }

    public void finishBackProgressPersistent(BackEventCompat arg3, Animator$AnimatorListener arg4) {
        Animator v0 = this.createResetScaleAnimator();
        v0.setDuration(((long)AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, arg3.getProgress())));
        if(arg4 != null) {
            v0.addListener(arg4);
        }

        v0.start();
    }

    public void startBackProgress(BackEventCompat arg1) {
        super.onStartBackProgress(arg1);
    }

    public void updateBackProgress(BackEventCompat arg2) {
        if(super.onUpdateBackProgress(arg2) == null) {
            return;
        }

        this.updateBackProgress(arg2.getProgress());
    }

    public void updateBackProgress(float arg7) {
        arg7 = this.interpolateProgress(arg7);
        float v0 = ((float)this.view.getWidth());
        float v1 = ((float)this.view.getHeight());
        if(v0 > 0f) {
            if(v1 <= 0f) {
            }
            else {
                float v3 = this.maxScaleXDistance / v0;
                v0 = this.maxScaleYDistance / v1;
                v3 = AnimationUtils.lerp(0f, v3, arg7);
                arg7 = AnimationUtils.lerp(0f, v0, arg7);
                v0 = 1f;
                v3 = v0 - v3;
                arg7 = v0 - arg7;
                this.view.setScaleX(v3);
                this.view.setPivotY(v1);
                this.view.setScaleY(arg7);
                if((this.view instanceof ViewGroup)) {
                    View v6 = this.view;
                    int v1_1;
                    for(v1_1 = 0; v1_1 < ((ViewGroup)v6).getChildCount(); ++v1_1) {
                        View v4 = ((ViewGroup)v6).getChildAt(v1_1);
                        v4.setPivotY(((float)(-v4.getTop())));
                        float v5 = arg7 != 0f ? v3 / arg7 : v0;
                        v4.setScaleY(v5);
                    }
                }
            }
        }
    }
}

