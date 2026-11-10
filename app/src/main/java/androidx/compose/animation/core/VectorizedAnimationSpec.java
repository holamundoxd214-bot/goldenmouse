package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J-\u0010\u0007\u001A\u00028\u00002\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000H&¢\u0006\u0002\u0010\rJ-\u0010\u000E\u001A\u00028\u00002\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000H&¢\u0006\u0002\u0010\rJ%\u0010\u000F\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001A\u00028\u00002\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0003"}, d2={"Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface VectorizedAnimationSpec {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static AnimationVector getEndVelocity(VectorizedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
            return arg0.getEndVelocity(arg1, arg2, arg3);
        }
    }

    static AnimationVector access$getEndVelocity$jd(VectorizedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return super.getEndVelocity(arg1, arg2, arg3);
    }

    long getDurationNanos(AnimationVector arg1, AnimationVector arg2, AnimationVector arg3);

    default AnimationVector getEndVelocity(AnimationVector arg7, AnimationVector arg8, AnimationVector arg9) {
        return this.getVelocityFromNanos(this.getDurationNanos(arg7, arg8, arg9), arg7, arg8, arg9);
    }

    AnimationVector getValueFromNanos(long arg1, AnimationVector arg2, AnimationVector arg3, AnimationVector arg4);

    AnimationVector getVelocityFromNanos(long arg1, AnimationVector arg2, AnimationVector arg3, AnimationVector arg4);

    boolean isInfinite();
}

