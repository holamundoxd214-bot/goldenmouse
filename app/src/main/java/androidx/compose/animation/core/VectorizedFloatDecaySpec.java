package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001D\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J%\u0010\u001A\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001D\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0010\u0010\n\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\f\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\r\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001D"}, d2={"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "<init>", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "targetVector", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class VectorizedFloatDecaySpec implements VectorizedDecayAnimationSpec {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private AnimationVector targetVector;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec arg1) {
        super();
        this.floatDecaySpec = arg1;
        this.absVelocityThreshold = arg1.getAbsVelocityThreshold();
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public long getDurationNanos(AnimationVector arg8, AnimationVector arg9) {
        AnimationVector v0 = this.velocityVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg8);
            this.velocityVector = v0;
        }

        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v0 = null;
        }

        int v0_1 = v0.getSize$animation_core();
        long v1 = 0;
        int v3;
        for(v3 = 0; v3 < v0_1; ++v3) {
            v1 = Math.max(v1, this.floatDecaySpec.getDurationNanos(arg8.get$animation_core(v3), arg9.get$animation_core(v3)));
        }

        return v1;
    }

    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    public AnimationVector getTargetValue(AnimationVector arg9, AnimationVector arg10) {
        AnimationVector v4;
        AnimationVector v0 = this.targetVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg9);
            this.targetVector = v0;
        }

        AnimationVector v1 = null;
        String v2 = "targetVector";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        int v0_1 = v0.getSize$animation_core();
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = this.targetVector;
            if(v3 >= v0_1) {
                break;
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v4 = v1;
            }

            v4.set$animation_core(v3, this.floatDecaySpec.getTargetValue(arg9.get$animation_core(v3), arg10.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }

    public AnimationVector getValueFromNanos(long arg9, AnimationVector arg11, AnimationVector arg12) {
        AnimationVector v4;
        AnimationVector v0 = this.valueVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg11);
            this.valueVector = v0;
        }

        AnimationVector v1 = null;
        String v2 = "valueVector";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        int v0_1 = v0.getSize$animation_core();
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = this.valueVector;
            if(v3 >= v0_1) {
                break;
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v4 = v1;
            }

            v4.set$animation_core(v3, this.floatDecaySpec.getValueFromNanos(arg9, arg11.get$animation_core(v3), arg12.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }

    public AnimationVector getVelocityFromNanos(long arg9, AnimationVector arg11, AnimationVector arg12) {
        AnimationVector v4;
        AnimationVector v0 = this.velocityVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg11);
            this.velocityVector = v0;
        }

        AnimationVector v1 = null;
        String v2 = "velocityVector";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        int v0_1 = v0.getSize$animation_core();
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = this.velocityVector;
            if(v3 >= v0_1) {
                break;
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v4 = v1;
            }

            v4.set$animation_core(v3, this.floatDecaySpec.getVelocityFromNanos(arg9, arg11.get$animation_core(v3), arg12.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }
}

