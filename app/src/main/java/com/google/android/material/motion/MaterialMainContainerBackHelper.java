package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper {
    private static final float MIN_SCALE = 0.9f;
    private Integer expandedCornerSize;
    private Rect initialHideFromClipBounds;
    private Rect initialHideToClipBounds;
    private float initialTouchY;
    private final float maxTranslationY;
    private final float minEdgeGap;

    public MaterialMainContainerBackHelper(View arg2) {
        super(arg2);
        Resources v2 = arg2.getResources();
        this.minEdgeGap = v2.getDimension(dimen.m3_back_progress_main_container_min_edge_gap);
        this.maxTranslationY = v2.getDimension(dimen.m3_back_progress_main_container_max_translation_y);
    }

    public void cancelBackProgress(View arg4) {
        if(super.onCancelBackProgress() == null) {
            return;
        }

        AnimatorSet v4 = this.createResetScaleAndTranslationAnimator(arg4);
        if((this.view instanceof ClippableRoundedCornerLayout)) {
            v4.playTogether(new Animator[]{this.createCornerAnimator(this.view)});
        }

        v4.setDuration(((long)this.cancelDuration));
        v4.start();
        this.resetInitialValues();
    }

    private ValueAnimator createCornerAnimator(ClippableRoundedCornerLayout arg4) {
        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{arg4.getCornerRadius(), ((float)this.getExpandedCornerSize())});
        v3.addUpdateListener(new MaterialMainContainerBackHelper$$ExternalSyntheticLambda0(arg4));
        return v3;
    }

    private AnimatorSet createResetScaleAndTranslationAnimator(View arg9) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_X, new float[]{0f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Y, new float[]{0f})});
        v0.addListener(new AnimatorListenerAdapter(arg9) {
            public void onAnimationEnd(Animator arg1) {
                View v0 = this.val$collapsedView;
                if(v0 != null) {
                    v0.setVisibility(0);
                }
            }
        });
        return v0;
    }

    public void finishBackProgress(long arg1, View arg3) {
        AnimatorSet v3 = this.createResetScaleAndTranslationAnimator(arg3);
        v3.setDuration(arg1);
        v3.start();
        this.resetInitialValues();
    }

    public int getExpandedCornerSize() {
        Integer v0 = this.expandedCornerSize;
        if(v0 == null) {
            int v0_1 = this.isAtTopOfScreen() ? this.getMaxDeviceCornerRadius() : 0;
            v0 = Integer.valueOf(v0_1);
            this.expandedCornerSize = v0;
        }

        return v0.intValue();
    }

    public Rect getInitialHideFromClipBounds() {
        return this.initialHideFromClipBounds;
    }

    public Rect getInitialHideToClipBounds() {
        return this.initialHideToClipBounds;
    }

    private int getMaxDeviceCornerRadius() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            WindowInsets v0 = this.view.getRootWindowInsets();
            if(v0 != null) {
                return Math.max(Math.max(this.getRoundedCornerRadius(v0, 0), this.getRoundedCornerRadius(v0, 1)), Math.max(this.getRoundedCornerRadius(v0, 3), this.getRoundedCornerRadius(v0, 2)));
            }
        }

        return 0;
    }

    private int getRoundedCornerRadius(WindowInsets arg1, int arg2) {
        RoundedCorner v0 = arg1.getRoundedCorner(arg2);
        if(v0 != null) {
            return v0.getRadius();
        }

        return 0;
    }

    private boolean isAtTopOfScreen() {
        int[] v0 = new int[2];
        this.view.getLocationOnScreen(v0);
        if(v0[1] == 0) {
            return 1;
        }

        return 0;
    }

    static void lambda$createCornerAnimator$0(ClippableRoundedCornerLayout arg0, ValueAnimator arg1) {
        arg0.updateCornerRadius(arg1.getAnimatedValue().floatValue());
    }

    private void resetInitialValues() {
        this.initialTouchY = 0f;
        this.initialHideToClipBounds = null;
        this.initialHideFromClipBounds = null;
    }

    public void startBackProgress(float arg2, View arg3) {
        this.initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.view);
        if(arg3 != null) {
            this.initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.view, arg3);
        }

        this.initialTouchY = arg2;
    }

    public void startBackProgress(BackEventCompat arg1, View arg2) {
        super.onStartBackProgress(arg1);
        this.startBackProgress(arg1.getTouchY(), arg2);
    }

    public void updateBackProgress(float arg7, boolean arg8, float arg9, float arg10) {
        arg7 = this.interpolateProgress(arg7);
        float v0 = ((float)this.view.getWidth());
        float v1 = ((float)this.view.getHeight());
        if(v0 > 0f) {
            if(v1 <= 0f) {
            }
            else {
                float v3 = AnimationUtils.lerp(1f, 0.9f, arg7);
                float v4 = 2f;
                v0 = AnimationUtils.lerp(0f, Math.max(0f, (v0 - 0.9f * v0) / v4 - this.minEdgeGap), arg7);
                int v8 = arg8 ? 1 : -1;
                v0 *= ((float)v8);
                float v8_1 = Math.min(Math.max(0f, (v1 - v3 * v1) / v4 - this.minEdgeGap), this.maxTranslationY);
                arg9 -= this.initialTouchY;
                v8_1 = AnimationUtils.lerp(0f, v8_1, Math.abs(arg9) / v1) * Math.signum(arg9);
                this.view.setScaleX(v3);
                this.view.setScaleY(v3);
                this.view.setTranslationX(v0);
                this.view.setTranslationY(v8_1);
                if(!(this.view instanceof ClippableRoundedCornerLayout)) {
                    return;
                }

                this.view.updateCornerRadius(AnimationUtils.lerp(((float)this.getExpandedCornerSize()), arg10, arg7));
            }
        }
    }

    public void updateBackProgress(BackEventCompat arg3, View arg4, float arg5) {
        if(super.onUpdateBackProgress(arg3) == null) {
            return;
        }

        if(arg4 != null) {
            int v1 = 4;
            if(arg4.getVisibility() != v1) {
                arg4.setVisibility(v1);
            }
        }

        boolean v4 = arg3.getSwipeEdge() == 0 ? true : false;
        this.updateBackProgress(arg3.getProgress(), v4, arg3.getTouchY(), arg5);
    }
}

