package androidx.compose.foundation.layout;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0007H\u0002J\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0007J\u0018\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016J \u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016J\u0018\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016J \u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/layout/SplineBasedFloatDecayAnimationSpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "magicPhysicalCoefficient", "getSplineDeceleration", "", "velocity", "flingDistance", "getTargetValue", "initialValue", "initialVelocity", "getValueFromNanos", "playTimeNanos", "", "getDurationNanos", "getVelocityFromNanos", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    private final float magicPhysicalCoefficient;

    public SplineBasedFloatDecayAnimationSpec(Density arg2) {
        super();
        this.magicPhysicalCoefficient = arg2.getDensity() * 386.087799f * 160f * 0.84f;
    }

    public final float flingDistance(float arg9) {
        return (((float)((((double)(WindowInsetsConnection_androidKt.access$getPlatformFlingScrollFriction$p() * this.magicPhysicalCoefficient))) * Math.exp(WindowInsetsConnection_androidKt.access$getDecelerationRate$p() / WindowInsetsConnection_androidKt.access$getDecelMinusOne$p() * this.getSplineDeceleration(arg9))))) * Math.signum(arg9);
    }

    public float getAbsVelocityThreshold() {
        return 0;
    }

    public long getDurationNanos(float arg3, float arg4) {
        return ((long)(Math.exp(this.getSplineDeceleration(arg4) / WindowInsetsConnection_androidKt.access$getDecelMinusOne$p()) * 1000000000));
    }

    private final double getSplineDeceleration(float arg3) {
        return AndroidFlingSpline.INSTANCE.deceleration(arg3, WindowInsetsConnection_androidKt.access$getPlatformFlingScrollFriction$p() * this.magicPhysicalCoefficient);
    }

    public float getTargetValue(float arg1, float arg2) {
        return arg1 + this.flingDistance(arg2);
    }

    public float getValueFromNanos(long arg5, float arg7, float arg8) {
        long v0 = this.getDurationNanos(0f, arg8);
        float v5 = v0 > 0 ? (((float)arg5)) / (((float)v0)) : 1f;
        return arg7 + this.flingDistance(arg8) * FlingResult.getDistanceCoefficient-impl(AndroidFlingSpline.INSTANCE.flingPosition-LfoxSSI(v5));
    }

    public float getVelocityFromNanos(long arg5, float arg7, float arg8) {
        long v0 = this.getDurationNanos(0f, arg8);
        float v5 = v0 > 0 ? (((float)arg5)) / (((float)v0)) : 1f;
        return FlingResult.getVelocityCoefficient-impl(AndroidFlingSpline.INSTANCE.flingPosition-LfoxSSI(v5)) * this.flingDistance(arg8) / (((float)v0)) * 1000000000f;
    }
}

