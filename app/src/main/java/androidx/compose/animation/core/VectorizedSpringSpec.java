package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\b\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\fJ&\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001AJ.\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001AR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001E¨\u0006\u001F"}, d2={"Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "dampingRatio", "", "stiffness", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(FFLandroidx/compose/animation/core/Animations;)V", "visibilityThreshold", "(FFLandroidx/compose/animation/core/AnimationVector;)V", "getDampingRatio", "()F", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "isInfinite", "", "()Z", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedSpringSpec implements VectorizedFiniteAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final float stiffness;

    static {
    }

    public VectorizedSpringSpec(float arg1, float arg2, AnimationVector arg3) {
        this(arg1, arg2, VectorizedAnimationSpecKt.createSpringAnimations(arg3, arg1, arg2));
    }

    private VectorizedSpringSpec(float arg2, float arg3, Animations arg4) {
        super();
        this.$$delegate_0 = new VectorizedFloatAnimationSpec(arg4);
        this.dampingRatio = arg2;
        this.stiffness = arg3;
    }

    public VectorizedSpringSpec(float arg1, float arg2, AnimationVector arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 1f;
        }

        if((arg4 & 2) != 0) {
            arg2 = 1500f;
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public long getDurationNanos(AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return this.$$delegate_0.getDurationNanos(arg1, arg2, arg3);
    }

    public AnimationVector getEndVelocity(AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return this.$$delegate_0.getEndVelocity(arg1, arg2, arg3);
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public AnimationVector getValueFromNanos(long arg1, AnimationVector arg3, AnimationVector arg4, AnimationVector arg5) {
        return this.$$delegate_0.getValueFromNanos(arg1, arg3, arg4, arg5);
    }

    public AnimationVector getVelocityFromNanos(long arg1, AnimationVector arg3, AnimationVector arg4, AnimationVector arg5) {
        return this.$$delegate_0.getVelocityFromNanos(arg1, arg3, arg4, arg5);
    }

    public boolean isInfinite() {
        return this.$$delegate_0.isInfinite();
    }
}

