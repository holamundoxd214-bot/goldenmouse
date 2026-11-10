package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000E0\r\"\b\b\u0001\u0010\u000E*\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000E0\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0018"}, d2={"Landroidx/compose/animation/core/StartDelayAnimationSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "startDelayNanos", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;J)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getStartDelayNanos", "()J", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "hashCode", "", "equals", "", "other", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class StartDelayAnimationSpec implements AnimationSpec {
    private final AnimationSpec animationSpec;
    private final long startDelayNanos;

    public StartDelayAnimationSpec(AnimationSpec arg1, long arg2) {
        super();
        this.animationSpec = arg1;
        this.startDelayNanos = arg2;
    }

    public boolean equals(Object arg7) {
        if(!(arg7 instanceof StartDelayAnimationSpec)) {
            return 0;
        }

        if(((StartDelayAnimationSpec)arg7).startDelayNanos == this.startDelayNanos && (Intrinsics.areEqual(((StartDelayAnimationSpec)arg7).animationSpec, this.animationSpec))) {
            return 1;
        }

        return 0;
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public int hashCode() {
        return this.animationSpec.hashCode() * 0x1F + Long.hashCode(this.startDelayNanos);
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg4) {
        return new StartDelayVectorizedAnimationSpec(this.animationSpec.vectorize(arg4), this.startDelayNanos);
    }
}

