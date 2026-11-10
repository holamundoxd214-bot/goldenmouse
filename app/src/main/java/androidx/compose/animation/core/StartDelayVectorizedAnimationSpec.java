package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0013\u0010\u001B\u001A\u00020\u000E2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000F¨\u0006\u001E"}, d2={"Landroidx/compose/animation/core/StartDelayVectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "vectorizedAnimationSpec", "startDelayNanos", "", "<init>", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;J)V", "getVectorizedAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getStartDelayNanos", "()J", "isInfinite", "", "()Z", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "hashCode", "", "equals", "other", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class StartDelayVectorizedAnimationSpec implements VectorizedAnimationSpec {
    private final long startDelayNanos;
    private final VectorizedAnimationSpec vectorizedAnimationSpec;

    public StartDelayVectorizedAnimationSpec(VectorizedAnimationSpec arg1, long arg2) {
        super();
        this.vectorizedAnimationSpec = arg1;
        this.startDelayNanos = arg2;
    }

    public boolean equals(Object arg7) {
        if(!(arg7 instanceof StartDelayVectorizedAnimationSpec)) {
            return 0;
        }

        if(((StartDelayVectorizedAnimationSpec)arg7).startDelayNanos == this.startDelayNanos && (Intrinsics.areEqual(((StartDelayVectorizedAnimationSpec)arg7).vectorizedAnimationSpec, this.vectorizedAnimationSpec))) {
            return 1;
        }

        return 0;
    }

    public long getDurationNanos(AnimationVector arg3, AnimationVector arg4, AnimationVector arg5) {
        return this.vectorizedAnimationSpec.getDurationNanos(arg3, arg4, arg5) + this.startDelayNanos;
    }

    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public AnimationVector getValueFromNanos(long arg4, AnimationVector arg6, AnimationVector arg7, AnimationVector arg8) {
        long v0 = this.startDelayNanos;
        if(arg4 < v0) {
            return arg6;
        }

        return this.vectorizedAnimationSpec.getValueFromNanos(arg4 - v0, arg6, arg7, arg8);
    }

    public final VectorizedAnimationSpec getVectorizedAnimationSpec() {
        return this.vectorizedAnimationSpec;
    }

    public AnimationVector getVelocityFromNanos(long arg4, AnimationVector arg6, AnimationVector arg7, AnimationVector arg8) {
        long v0 = this.startDelayNanos;
        if(arg4 < v0) {
            return arg8;
        }

        return this.vectorizedAnimationSpec.getVelocityFromNanos(arg4 - v0, arg6, arg7, arg8);
    }

    public int hashCode() {
        return this.vectorizedAnimationSpec.hashCode() * 0x1F + Long.hashCode(this.startDelayNanos);
    }

    public boolean isInfinite() {
        return this.vectorizedAnimationSpec.isInfinite();
    }
}

