package androidx.compose.animation;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0002J\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\tH\u0016J \u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\tH\u0016J\u0018\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\tH\u0016J \u0010\u0015\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\tH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Landroidx/compose/animation/SplineBasedFloatDecayAnimationSpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "flingCalculator", "Landroidx/compose/animation/FlingCalculator;", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "flingDistance", "startVelocity", "getTargetValue", "initialValue", "initialVelocity", "getValueFromNanos", "playTimeNanos", "", "getDurationNanos", "getVelocityFromNanos", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    public static final int $stable;
    private final FlingCalculator flingCalculator;

    static {
    }

    public SplineBasedFloatDecayAnimationSpec(Density arg3) {
        super();
        this.flingCalculator = new FlingCalculator(SplineBasedFloatDecayAnimationSpec_androidKt.getPlatformFlingScrollFriction(), arg3);
    }

    private final float flingDistance(float arg1) {
        return this.flingCalculator.flingDistance(arg1) * Math.signum(arg1);
    }

    public float getAbsVelocityThreshold() {
        return 0;
    }

    public long getDurationNanos(float arg3, float arg4) {
        return this.flingCalculator.flingDuration(arg4) * 1000000;
    }

    public float getTargetValue(float arg1, float arg2) {
        return arg1 + this.flingDistance(arg2);
    }

    public float getValueFromNanos(long arg3, float arg5, float arg6) {
        return arg5 + this.flingCalculator.flingInfo(arg6).position(arg3 / 1000000);
    }

    public float getVelocityFromNanos(long arg3, float arg5, float arg6) {
        return this.flingCalculator.flingInfo(arg6).velocity(arg3 / 1000000);
    }
}

