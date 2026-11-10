package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    class com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$3 extends Property {
        com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$3(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(DrawableWithAnimatedVisibilityChange arg1) {
            return Float.valueOf(arg1.getGrowFraction());
        }

        public Object get(Object arg1) {
            return this.get(((DrawableWithAnimatedVisibilityChange)arg1));
        }

        public void set(DrawableWithAnimatedVisibilityChange arg1, Float arg2) {
            arg1.setGrowFraction(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((DrawableWithAnimatedVisibilityChange)arg1), ((Float)arg2));
        }
    }

    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property GROW_FRACTION;
    private List animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint;
    private ValueAnimator showAnimator;
    private int totalAlpha;

    static {
        DrawableWithAnimatedVisibilityChange.GROW_FRACTION = new com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$3(Float.class, "growFraction");
    }

    DrawableWithAnimatedVisibilityChange(Context arg2, BaseProgressIndicatorSpec arg3) {
        super();
        this.paint = new Paint();
        this.context = arg2;
        this.baseSpec = arg3;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.setAlpha(0xFF);
    }

    static void access$000(DrawableWithAnimatedVisibilityChange arg0) {
        arg0.dispatchAnimationStart();
    }

    static boolean access$101(DrawableWithAnimatedVisibilityChange arg0, boolean arg1, boolean arg2) {
        return super.setVisible(arg1, arg2);
    }

    static void access$200(DrawableWithAnimatedVisibilityChange arg0) {
        arg0.dispatchAnimationEnd();
    }

    private void cancelAnimatorsWithoutCallbacks(ValueAnimator[] arg5) {
        boolean v0 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int v1 = arg5.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            arg5[v2].cancel();
        }

        this.ignoreCallbacks = v0;
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    private void dispatchAnimationEnd() {
        AnimationCallback v0 = this.internalAnimationCallback;
        if(v0 != null) {
            v0.onAnimationEnd(((Drawable)this));
        }

        List v0_1 = this.animationCallbacks;
        if(v0_1 != null && !this.ignoreCallbacks) {
            Iterator v0_2 = v0_1.iterator();
            while(v0_2.hasNext()) {
                v0_2.next().onAnimationEnd(((Drawable)this));
            }
        }
    }

    private void dispatchAnimationStart() {
        AnimationCallback v0 = this.internalAnimationCallback;
        if(v0 != null) {
            v0.onAnimationStart(((Drawable)this));
        }

        List v0_1 = this.animationCallbacks;
        if(v0_1 != null && !this.ignoreCallbacks) {
            Iterator v0_2 = v0_1.iterator();
            while(v0_2.hasNext()) {
                v0_2.next().onAnimationStart(((Drawable)this));
            }
        }
    }

    private void endAnimatorsWithoutCallbacks(ValueAnimator[] arg5) {
        boolean v0 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int v1 = arg5.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            arg5[v2].end();
        }

        this.ignoreCallbacks = v0;
    }

    public int getAlpha() {
        return this.totalAlpha;
    }

    float getGrowFraction() {
        if(!this.baseSpec.isShowAnimationEnabled() && !this.baseSpec.isHideAnimationEnabled()) {
            return 1f;
        }

        if(!this.mockHideAnimationRunning) {
            if(this.mockShowAnimationRunning) {
            }
            else {
                return this.growFraction;
            }
        }

        return this.mockGrowFraction;
    }

    ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return this.setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator v0 = this.hideAnimator;
        if(v0 != null && (v0.isRunning()) || (this.mockHideAnimationRunning)) {
            return 1;
        }

        return 0;
    }

    public boolean isRunning() {
        if(!this.isShowing()) {
            if(this.isHiding()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isShowing() {
        ValueAnimator v0 = this.showAnimator;
        if(v0 != null && (v0.isRunning()) || (this.mockShowAnimationRunning)) {
            return 1;
        }

        return 0;
    }

    private void maybeInitializeAnimators() {
        ObjectAnimator v0;
        long v1 = 500;
        int v3 = 2;
        if(this.showAnimator == null) {
            v0 = ObjectAnimator.ofFloat(this, DrawableWithAnimatedVisibilityChange.GROW_FRACTION, new float[]{0f, 1f});
            this.showAnimator = ((ValueAnimator)v0);
            ((ValueAnimator)v0).setDuration(v1);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.setShowAnimator(this.showAnimator);
        }

        if(this.hideAnimator == null) {
            v0 = ObjectAnimator.ofFloat(this, DrawableWithAnimatedVisibilityChange.GROW_FRACTION, new float[]{1f, 0f});
            this.hideAnimator = ((ValueAnimator)v0);
            ((ValueAnimator)v0).setDuration(v1);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.setHideAnimator(this.hideAnimator);
        }
    }

    public void registerAnimationCallback(AnimationCallback arg2) {
        if(this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }

        if(!this.animationCallbacks.contains(arg2)) {
            this.animationCallbacks.add(arg2);
        }
    }

    public void setAlpha(int arg1) {
        this.totalAlpha = arg1;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter arg2) {
        this.paint.setColorFilter(arg2);
        this.invalidateSelf();
    }

    void setGrowFraction(float arg2) {
        if(this.growFraction != arg2) {
            this.growFraction = arg2;
            this.invalidateSelf();
        }
    }

    private void setHideAnimator(ValueAnimator arg2) {
        ValueAnimator v0 = this.hideAnimator;
        if(v0 != null) {
            if(!v0.isRunning()) {
            }
            else {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
        }

        this.hideAnimator = arg2;
        arg2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                super.onAnimationEnd(arg2);
                DrawableWithAnimatedVisibilityChange.access$101(DrawableWithAnimatedVisibilityChange.this, false, false);
                DrawableWithAnimatedVisibilityChange.this.dispatchAnimationEnd();
            }
        });
    }

    void setInternalAnimationCallback(AnimationCallback arg1) {
        this.internalAnimationCallback = arg1;
    }

    void setMockHideAnimationRunning(boolean arg1, float arg2) {
        this.mockHideAnimationRunning = arg1;
        this.mockGrowFraction = arg2;
    }

    void setMockShowAnimationRunning(boolean arg1, float arg2) {
        this.mockShowAnimationRunning = arg1;
        this.mockGrowFraction = arg2;
    }

    private void setShowAnimator(ValueAnimator arg2) {
        ValueAnimator v0 = this.showAnimator;
        if(v0 != null) {
            if(!v0.isRunning()) {
            }
            else {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
        }

        this.showAnimator = arg2;
        arg2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator arg1) {
                super.onAnimationStart(arg1);
                DrawableWithAnimatedVisibilityChange.this.dispatchAnimationStart();
            }
        });
    }

    public boolean setVisible(boolean arg3, boolean arg4, boolean arg5) {
        float v0 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        arg5 = !arg5 || v0 <= 0f ? false : true;
        return this.setVisibleInternal(arg3, arg4, arg5);
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        return this.setVisible(arg2, arg3, true);
    }

    boolean setVisibleInternal(boolean arg5, boolean arg6, boolean arg7) {
        this.maybeInitializeAnimators();
        if(!this.isVisible() && !arg5) {
            return 0;
        }

        ValueAnimator v0 = arg5 ? this.showAnimator : this.hideAnimator;
        ValueAnimator v2 = arg5 ? this.hideAnimator : this.showAnimator;
        if(!arg7) {
            if(v2.isRunning()) {
                this.cancelAnimatorsWithoutCallbacks(new ValueAnimator[]{v2});
            }

            if(v0.isRunning()) {
                v0.end();
            }
            else {
                this.endAnimatorsWithoutCallbacks(new ValueAnimator[]{v0});
            }

            return super.setVisible(arg5, false);
        }

        if((arg7) && (v0.isRunning())) {
            return 0;
        }

        arg7 = !arg5 || (super.setVisible(arg5, false)) ? true : false;
        BaseProgressIndicatorSpec v2_1 = this.baseSpec;
        arg5 = arg5 ? v2_1.isShowAnimationEnabled() : v2_1.isHideAnimationEnabled();
        if(!arg5) {
            this.endAnimatorsWithoutCallbacks(new ValueAnimator[]{v0});
            return arg7;
        }

        if(!arg6) {
            if(!v0.isPaused()) {
            }
            else {
                v0.resume();
                return arg7;
            }
        }

        v0.start();
        return arg7;
    }

    public void start() {
        this.setVisibleInternal(true, true, false);
    }

    public void stop() {
        this.setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(AnimationCallback arg2) {
        List v0 = this.animationCallbacks;
        if(v0 != null && (v0.contains(arg2))) {
            this.animationCallbacks.remove(arg2);
            if(this.animationCallbacks.isEmpty()) {
                this.animationCallbacks = null;
            }

            return 1;
        }

        return 0;
    }
}

