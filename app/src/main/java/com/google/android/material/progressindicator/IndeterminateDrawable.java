package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

public final class IndeterminateDrawable extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate animatorDelegate;
    private DrawingDelegate drawingDelegate;

    IndeterminateDrawable(Context arg1, BaseProgressIndicatorSpec arg2, DrawingDelegate arg3, IndeterminateAnimatorDelegate arg4) {
        super(arg1, arg2);
        this.setDrawingDelegate(arg3);
        this.setAnimatorDelegate(arg4);
    }

    public void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public static IndeterminateDrawable createCircularDrawable(Context arg3, CircularProgressIndicatorSpec arg4) {
        return new IndeterminateDrawable(arg3, ((BaseProgressIndicatorSpec)arg4), new CircularDrawingDelegate(arg4), new CircularIndeterminateAnimatorDelegate(arg4));
    }

    public static IndeterminateDrawable createLinearDrawable(Context arg3, LinearProgressIndicatorSpec arg4) {
        LinearIndeterminateContiguousAnimatorDelegate v2;
        LinearDrawingDelegate v1 = new LinearDrawingDelegate(arg4);
        if(arg4.indeterminateAnimationType == 0) {
            v2 = new LinearIndeterminateContiguousAnimatorDelegate(arg4);
        }
        else {
            LinearIndeterminateDisjointAnimatorDelegate v2_1 = new LinearIndeterminateDisjointAnimatorDelegate(arg3, arg4);
        }

        return new IndeterminateDrawable(arg3, ((BaseProgressIndicatorSpec)arg4), ((DrawingDelegate)v1), ((IndeterminateAnimatorDelegate)v2));
    }

    public void draw(Canvas arg9) {
        Rect v0 = new Rect();
        if(!this.getBounds().isEmpty() && (this.isVisible())) {
            if(!arg9.getClipBounds(v0)) {
            }
            else {
                arg9.save();
                this.drawingDelegate.validateSpecAndAdjustCanvas(arg9, this.getBounds(), this.getGrowFraction());
                this.drawingDelegate.fillTrack(arg9, this.paint);
                int v0_1;
                for(v0_1 = 0; v0_1 < this.animatorDelegate.segmentColors.length; ++v0_1) {
                    int v3 = v0_1 * 2;
                    this.drawingDelegate.fillIndicator(arg9, this.paint, this.animatorDelegate.segmentPositions[v3], this.animatorDelegate.segmentPositions[v3 + 1], this.animatorDelegate.segmentColors[v0_1]);
                }

                arg9.restore();
            }
        }
    }

    public int getAlpha() {
        return super.getAlpha();
    }

    IndeterminateAnimatorDelegate getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    DrawingDelegate getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public int getOpacity() {
        return super.getOpacity();
    }

    public boolean hideNow() {
        return super.hideNow();
    }

    public boolean isHiding() {
        return super.isHiding();
    }

    public boolean isRunning() {
        return super.isRunning();
    }

    public boolean isShowing() {
        return super.isShowing();
    }

    public void registerAnimationCallback(AnimationCallback arg1) {
        super.registerAnimationCallback(arg1);
    }

    public void setAlpha(int arg1) {
        super.setAlpha(arg1);
    }

    void setAnimatorDelegate(IndeterminateAnimatorDelegate arg1) {
        this.animatorDelegate = arg1;
        arg1.registerDrawable(this);
    }

    public void setColorFilter(ColorFilter arg1) {
        super.setColorFilter(arg1);
    }

    void setDrawingDelegate(DrawingDelegate arg1) {
        this.drawingDelegate = arg1;
        arg1.registerDrawable(((DrawableWithAnimatedVisibilityChange)this));
    }

    public boolean setVisible(boolean arg1, boolean arg2) {
        return super.setVisible(arg1, arg2);
    }

    public boolean setVisible(boolean arg1, boolean arg2, boolean arg3) {
        return super.setVisible(arg1, arg2, arg3);
    }

    boolean setVisibleInternal(boolean arg3, boolean arg4, boolean arg5) {
        arg4 = super.setVisibleInternal(arg3, arg4, arg5);
        if(!this.isRunning()) {
            this.animatorDelegate.cancelAnimatorImmediately();
        }

        this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if(arg3) {
            if(!arg5) {
                return arg4;
            }
            else {
                this.animatorDelegate.startAnimator();
            }
        }

        return arg4;
    }

    public void start() {
        super.start();
    }

    public void stop() {
        super.stop();
    }

    public boolean unregisterAnimationCallback(AnimationCallback arg1) {
        return super.unregisterAnimationCallback(arg1);
    }
}

