package com.google.android.material.motion;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R$dimen;
import com.google.android.material.animation.AnimationUtils;

public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(View arg2) {
        super(arg2);
        Resources v2 = arg2.getResources();
        this.maxScaleXDistanceShrink = v2.getDimension(dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = v2.getDimension(dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = v2.getDimension(dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public void cancelBackProgress() {
        if(super.onCancelBackProgress() == null) {
            return;
        }

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
            View v1_1 = this.view;
            int v2_1;
            for(v2_1 = 0; v2_1 < ((ViewGroup)v1_1).getChildCount(); ++v2_1) {
                v0.playTogether(new Animator[]{ObjectAnimator.ofFloat(((ViewGroup)v1_1).getChildAt(v2_1), View.SCALE_Y, new float[]{v7})});
            }
        }

        v0.setDuration(((long)this.cancelDuration));
        v0.start();
    }

    private boolean checkAbsoluteGravity(int arg1, int arg2) {
        if((GravityCompat.getAbsoluteGravity(arg1, ViewCompat.getLayoutDirection(this.view)) & arg2) == arg2) {
            return 1;
        }

        return 0;
    }

    public void finishBackProgress(BackEventCompat arg8, int arg9, Animator$AnimatorListener arg10, ValueAnimator$AnimatorUpdateListener arg11) {
        boolean v0 = arg8.getSwipeEdge() == 0 ? true : false;
        boolean v3 = this.checkAbsoluteGravity(arg9, 3);
        float v4 = (((float)this.view.getWidth())) * this.view.getScaleX() + (((float)this.getEdgeMargin(v3)));
        View v5 = this.view;
        Property v6 = View.TRANSLATION_X;
        if(v3) {
            v4 = -v4;
        }

        ObjectAnimator v1 = ObjectAnimator.ofFloat(v5, v6, new float[]{v4});
        if(arg11 != null) {
            v1.addUpdateListener(arg11);
        }

        v1.setInterpolator(new FastOutSlowInInterpolator());
        v1.setDuration(((long)AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, arg8.getProgress())));
        v1.addListener(new AnimatorListenerAdapter(v0, arg9) {
            public void onAnimationEnd(Animator arg3) {
                MaterialSideContainerBackHelper.this.view.setTranslationX(0f);
                MaterialSideContainerBackHelper.this.updateBackProgress(0f, this.val$leftSwipeEdge, this.val$gravity);
            }
        });
        if(arg10 != null) {
            v1.addListener(arg10);
        }

        v1.start();
    }

    private int getEdgeMargin(boolean arg2) {
        ViewGroup$LayoutParams v1 = this.view.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
            if(arg2) {
                return ((ViewGroup$MarginLayoutParams)v1).leftMargin;
            }

            return ((ViewGroup$MarginLayoutParams)v1).rightMargin;
        }

        return 0;
    }

    public void startBackProgress(BackEventCompat arg1) {
        super.onStartBackProgress(arg1);
    }

    public void updateBackProgress(float arg10, boolean arg11, int arg12) {
        arg10 = this.interpolateProgress(arg10);
        boolean v12 = this.checkAbsoluteGravity(arg12, 3);
        int v0 = 0;
        int v11 = arg11 == v12 ? 1 : 0;
        int v1 = this.view.getWidth();
        int v2 = this.view.getHeight();
        float v3 = ((float)v1);
        if(v3 > 0f) {
            float v2_1 = ((float)v2);
            if(v2_1 <= 0f) {
            }
            else {
                float v5 = this.maxScaleXDistanceShrink / v3;
                float v6 = this.maxScaleXDistanceGrow / v3;
                float v7 = this.maxScaleYDistance / v2_1;
                View v2_2 = this.view;
                if(v12) {
                    v3 = 0f;
                }

                v2_2.setPivotX(v3);
                if(v11 != 0) {
                }
                else {
                    v6 = -v5;
                }

                v2_1 = AnimationUtils.lerp(0f, v6, arg10);
                v3 = 1f;
                v5 = v2_1 + v3;
                this.view.setScaleX(v5);
                arg10 = v3 - AnimationUtils.lerp(0f, v7, arg10);
                this.view.setScaleY(arg10);
                if(!(this.view instanceof ViewGroup)) {
                    return;
                }

                View v9 = this.view;
                while(v0 < ((ViewGroup)v9).getChildCount()) {
                    View v6_1 = ((ViewGroup)v9).getChildAt(v0);
                    int v7_1 = v12 ? v1 - v6_1.getRight() + v6_1.getWidth() : -v6_1.getLeft();
                    v6_1.setPivotX(((float)v7_1));
                    v6_1.setPivotY(((float)(-v6_1.getTop())));
                    v7 = v11 != 0 ? v3 - v2_1 : v3;
                    float v8 = arg10 != 0f ? v5 / arg10 * v7 : v3;
                    v6_1.setScaleX(v7);
                    v6_1.setScaleY(v8);
                    ++v0;
                }
            }
        }
    }

    public void updateBackProgress(BackEventCompat arg2, int arg3) {
        if(super.onUpdateBackProgress(arg2) == null) {
            return;
        }

        boolean v0 = arg2.getSwipeEdge() == 0 ? true : false;
        this.updateBackProgress(arg2.getProgress(), v0, arg3);
    }
}

