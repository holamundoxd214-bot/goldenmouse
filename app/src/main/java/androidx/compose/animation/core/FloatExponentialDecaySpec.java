package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003H\u0016J \u0010\u000F\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003H\u0016J\u0018\u0010\u0010\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003H\u0016J\u0018\u0010\u0011\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003H\u0016R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "<init>", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "getTargetValue", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable;
    private final float absVelocityThreshold;
    private final float friction;

    static {
    }

    public FloatExponentialDecaySpec(float arg2, float arg3) {
        super();
        this.absVelocityThreshold = Math.max(1.000000E-07f, Math.abs(arg3));
        this.friction = Math.max(0.0001f, arg2) * -4.2f;
    }

    public FloatExponentialDecaySpec() {
        this(0f, 0f, 3, null);
    }

    public FloatExponentialDecaySpec(float arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 1f;
        }

        if((arg3 & 2) != 0) {
            arg2 = 0.1f;
        }

        this(arg1, arg2);
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public long getDurationNanos(float arg3, float arg4) {
        return (((long)((((float)Math.log(((double)(this.getAbsVelocityThreshold() / Math.abs(arg4)))))) * 1000f / this.friction))) * 1000000;
    }

    public float getTargetValue(float arg7, float arg8) {
        if(Math.abs(arg8) <= this.getAbsVelocityThreshold()) {
            return arg7;
        }

        return arg7 - arg8 / this.friction + arg8 / this.friction * (((float)Math.exp((((double)this.friction)) * (Math.log(((double)Math.abs(this.getAbsVelocityThreshold() / arg8))) / (((double)this.friction)) * 1000) / 1000)));
    }

    public float getValueFromNanos(long arg3, float arg5, float arg6) {
        return arg5 - arg6 / this.friction + arg6 / this.friction * (((float)Math.exp(((double)(this.friction * (((float)(arg3 / 1000000))) / 1000f)))));
    }

    public float getVelocityFromNanos(long arg3, float arg5, float arg6) {
        return arg6 * (((float)Math.exp(((double)((((float)(arg3 / 1000000))) / 1000f * this.friction)))));
    }
}

