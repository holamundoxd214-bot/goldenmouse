package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0012\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2={"Landroidx/compose/animation/core/VectorizedSnapSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "delayMillis", "", "<init>", "(I)V", "getDelayMillis", "()I", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "durationMillis", "getDurationMillis", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedSnapSpec implements VectorizedDurationBasedAnimationSpec {
    public static final int $stable;
    private final int delayMillis;

    static {
    }

    public VectorizedSnapSpec(int arg1) {
        super();
        this.delayMillis = arg1;
    }

    public VectorizedSnapSpec() {
        this(0, 1, null);
    }

    public VectorizedSnapSpec(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(0);
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public int getDurationMillis() {
        return 0;
    }

    public AnimationVector getValueFromNanos(long arg5, AnimationVector arg7, AnimationVector arg8, AnimationVector arg9) {
        if(arg5 < (((long)this.getDelayMillis())) * 1000000) {
            return arg7;
        }

        return arg8;
    }

    public AnimationVector getVelocityFromNanos(long arg1, AnimationVector arg3, AnimationVector arg4, AnimationVector arg5) {
        return arg5;
    }
}

