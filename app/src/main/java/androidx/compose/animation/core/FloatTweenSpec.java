package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0010H\u0016J\u0011\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\rH\u0082\bJ \u0010\u0016\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0010H\u0016J(\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0010H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(IILandroidx/compose/animation/core/Easing;)V", "getDuration", "()I", "getDelay", "durationNanos", "", "delayNanos", "getValueFromNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "clampPlayTimeNanos", "getDurationNanos", "getVelocityFromNanos", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;
    private final Easing easing;

    static {
    }

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    public FloatTweenSpec(int arg1, int arg2, Easing arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 300;
        }

        if((arg4 & 4) != 0) {
            arg3 = EasingKt.getFastOutSlowInEasing();
        }

        this(arg1, 0, arg3);
    }

    public FloatTweenSpec(int arg5, int arg6, Easing arg7) {
        super();
        this.duration = arg5;
        this.delay = arg6;
        this.easing = arg7;
        this.durationNanos = (((long)arg5)) * 1000000;
        this.delayNanos = (((long)arg6)) * 1000000;
    }

    private final long clampPlayTimeNanos(long arg5) {
        arg5 -= this.delayNanos;
        long v0 = this.durationNanos;
        long v2 = 0;
        if(arg5 < v2) {
            arg5 = v2;
        }

        if(arg5 > v0) {
            return v0;
        }

        return arg5;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    public long getDurationNanos(float arg3, float arg4, float arg5) {
        return this.delayNanos + this.durationNanos;
    }

    public float getValueFromNanos(long arg5, float arg7, float arg8, float arg9) {
        arg5 -= this.delayNanos;
        long v0 = this.durationNanos;
        long v2 = 0;
        if(arg5 < v2) {
            arg5 = v2;
        }

        if(arg5 > v0) {
            arg5 = v0;
        }

        float v2_1 = 1f;
        float v5 = this.duration == 0 ? v2_1 : (((float)arg5)) / (((float)v0));
        float v4 = this.easing.transform(v5);
        return arg7 * (v2_1 - v4) + arg8 * v4;
    }

    public float getVelocityFromNanos(long arg10, float arg12, float arg13, float arg14) {
        long v1 = arg10 - this.delayNanos;
        long v3 = this.durationNanos;
        long v5 = 0;
        if(v1 < v5) {
            v1 = v5;
        }

        long v7 = v1 > v3 ? v3 : v1;
        if(v7 == v5) {
            return arg14;
        }

        return (this.getValueFromNanos(v7, arg12, arg13, arg14) - this.getValueFromNanos(v7 - 1000000, arg12, arg13, arg14)) * 1000f;
    }
}

