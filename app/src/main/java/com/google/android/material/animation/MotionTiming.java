package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MotionTiming {
    private long delay;
    private long duration;
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;

    public MotionTiming(long arg2, long arg4) {
        super();
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = arg2;
        this.duration = arg4;
    }

    public MotionTiming(long arg2, long arg4, TimeInterpolator arg6) {
        super();
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = arg2;
        this.duration = arg4;
        this.interpolator = arg6;
    }

    public void apply(Animator arg3) {
        arg3.setStartDelay(this.getDelay());
        arg3.setDuration(this.getDuration());
        arg3.setInterpolator(this.getInterpolator());
        if((arg3 instanceof ValueAnimator)) {
            ((ValueAnimator)arg3).setRepeatCount(this.getRepeatCount());
            ((ValueAnimator)arg3).setRepeatMode(this.getRepeatMode());
        }
    }

    static MotionTiming createFromAnimator(ValueAnimator arg6) {
        MotionTiming v0 = new MotionTiming(arg6.getStartDelay(), arg6.getDuration(), MotionTiming.getInterpolatorCompat(arg6));
        v0.repeatCount = arg6.getRepeatCount();
        v0.repeatMode = arg6.getRepeatMode();
        return v0;
    }

    public boolean equals(Object arg7) {
        if(this == (((MotionTiming)arg7))) {
            return 1;
        }

        if(!(arg7 instanceof MotionTiming)) {
            return 0;
        }

        if(this.getDelay() != ((MotionTiming)arg7).getDelay()) {
            return 0;
        }

        if(this.getDuration() != ((MotionTiming)arg7).getDuration()) {
            return 0;
        }

        if(this.getRepeatCount() != ((MotionTiming)arg7).getRepeatCount()) {
            return 0;
        }

        if(this.getRepeatMode() != ((MotionTiming)arg7).getRepeatMode()) {
            return 0;
        }

        return this.getInterpolator().getClass().equals(((MotionTiming)arg7).getInterpolator().getClass());
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator v0 = this.interpolator;
        if(v0 != null) {
            return v0;
        }

        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator arg1) {
        TimeInterpolator v1 = arg1.getInterpolator();
        if(!(v1 instanceof AccelerateDecelerateInterpolator)) {
            if(v1 == null) {
            }
            else if((v1 instanceof AccelerateInterpolator)) {
                return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            else {
                if((v1 instanceof DecelerateInterpolator)) {
                    v1 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
                }

                return v1;
            }
        }

        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        return ((((((int)(this.getDelay() ^ this.getDelay() >>> 0x20))) * 0x1F + (((int)(this.getDuration() ^ this.getDuration() >>> 0x20)))) * 0x1F + this.getInterpolator().getClass().hashCode()) * 0x1F + this.getRepeatCount()) * 0x1F + this.getRepeatMode();
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("\n");
        v0.append(this.getClass().getName());
        v0.append('{');
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" delay: ");
        v0.append(this.getDelay());
        v0.append(" duration: ");
        v0.append(this.getDuration());
        v0.append(" interpolator: ");
        v0.append(this.getInterpolator().getClass());
        v0.append(" repeatCount: ");
        v0.append(this.getRepeatCount());
        v0.append(" repeatMode: ");
        v0.append(this.getRepeatMode());
        v0.append("}\n");
        return v0.toString();
    }
}

