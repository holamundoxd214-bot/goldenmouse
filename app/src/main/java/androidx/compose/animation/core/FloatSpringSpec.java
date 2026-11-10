package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0003H\u0016J(\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0003H\u0016J \u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0003H\u0016J \u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFF)V", "getDampingRatio", "()F", "getStiffness", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    static {
    }

    public FloatSpringSpec() {
        this(0f, 0f, 0f, 7, null);
    }

    public FloatSpringSpec(float arg1, float arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 1f;
        }

        if((arg4 & 2) != 0) {
            arg2 = 1500f;
        }

        if((arg4 & 4) != 0) {
            arg3 = 0.01f;
        }

        this(arg1, arg2, arg3);
    }

    public FloatSpringSpec(float arg2, float arg3, float arg4) {
        super();
        this.dampingRatio = arg2;
        this.stiffness = arg3;
        this.visibilityThreshold = arg4;
        SpringSimulation v4 = new SpringSimulation(1f);
        v4.setDampingRatio(arg2);
        v4.setStiffness(arg3);
        this.spring = v4;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public long getDurationNanos(float arg3, float arg4, float arg5) {
        return SpringEstimationKt.estimateAnimationDurationMillis(this.spring.getStiffness(), this.spring.getDampingRatio(), arg5 / this.visibilityThreshold, (arg3 - arg4) / this.visibilityThreshold, 1f) * 1000000;
    }

    public float getEndVelocity(float arg1, float arg2, float arg3) {
        return 0;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public float getValueFromNanos(long arg3, float arg5, float arg6, float arg7) {
        this.spring.setFinalPosition(arg6);
        return Float.intBitsToFloat(((int)(this.spring.updateValues-IJZedt4$animation_core(arg5, arg7, arg3 / 1000000) >> 0x20)));
    }

    public float getVelocityFromNanos(long arg3, float arg5, float arg6, float arg7) {
        this.spring.setFinalPosition(arg6);
        return Float.intBitsToFloat(((int)(this.spring.updateValues-IJZedt4$animation_core(arg5, arg7, arg3 / 1000000) & 0xFFFFFFFFL)));
    }
}

