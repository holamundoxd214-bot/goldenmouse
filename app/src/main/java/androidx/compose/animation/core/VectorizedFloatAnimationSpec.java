package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000E\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001B"}, d2={"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(Landroidx/compose/animation/core/Animations;)V", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "endVelocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedFloatAnimationSpec implements VectorizedFiniteAnimationSpec {
    public static final int $stable = 8;
    private final Animations anims;
    private AnimationVector endVelocityVector;
    private AnimationVector valueVector;
    private AnimationVector velocityVector;

    static {
    }

    public VectorizedFloatAnimationSpec(FloatAnimationSpec arg2) {
        this(new Animations() {
            public FloatAnimationSpec get(int arg1) {
                return this.$anim;
            }
        });
    }

    public VectorizedFloatAnimationSpec(Animations arg1) {
        super();
        this.anims = arg1;
    }

    public long getDurationNanos(AnimationVector arg9, AnimationVector arg10, AnimationVector arg11) {
        int v0 = arg9.getSize$animation_core();
        long v1 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1 = Math.max(v1, this.anims.get(v3).getDurationNanos(arg9.get$animation_core(v3), arg10.get$animation_core(v3), arg11.get$animation_core(v3)));
        }

        return v1;
    }

    public AnimationVector getEndVelocity(AnimationVector arg10, AnimationVector arg11, AnimationVector arg12) {
        AnimationVector v4;
        AnimationVector v0 = this.endVelocityVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg12);
            this.endVelocityVector = v0;
        }

        AnimationVector v1 = null;
        String v2 = "endVelocityVector";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        int v0_1 = v0.getSize$animation_core();
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = this.endVelocityVector;
            if(v3 >= v0_1) {
                break;
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v4 = v1;
            }

            v4.set$animation_core(v3, this.anims.get(v3).getEndVelocity(arg10.get$animation_core(v3), arg11.get$animation_core(v3), arg12.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }

    public AnimationVector getValueFromNanos(long arg15, AnimationVector arg17, AnimationVector arg18, AnimationVector arg19) {
        AnimationVector v4;
        AnimationVector v0 = this.valueVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg17);
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

            v4.set$animation_core(v3, this.anims.get(v3).getValueFromNanos(arg15, arg17.get$animation_core(v3), arg18.get$animation_core(v3), arg19.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }

    public AnimationVector getVelocityFromNanos(long arg15, AnimationVector arg17, AnimationVector arg18, AnimationVector arg19) {
        AnimationVector v4;
        AnimationVector v0 = this.velocityVector;
        if(v0 == null) {
            v0 = AnimationVectorsKt.newInstance(arg19);
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

            v4.set$animation_core(v3, this.anims.get(v3).getVelocityFromNanos(arg15, arg17.get$animation_core(v3), arg18.get$animation_core(v3), arg19.get$animation_core(v3)));
        }

        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            return v1;
        }

        return v4;
    }
}

