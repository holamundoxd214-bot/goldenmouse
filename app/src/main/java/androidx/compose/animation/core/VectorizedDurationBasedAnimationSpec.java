package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J%\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000FR\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2={"Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "durationMillis", "", "getDurationMillis", "()I", "delayMillis", "getDelayMillis", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface VectorizedDurationBasedAnimationSpec extends VectorizedFiniteAnimationSpec {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static long getDurationNanos(VectorizedDurationBasedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
            return arg0.getDurationNanos(arg1, arg2, arg3);
        }

        @Deprecated public static AnimationVector getEndVelocity(VectorizedDurationBasedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
            return arg0.getEndVelocity(arg1, arg2, arg3);
        }

        @Deprecated public static boolean isInfinite(VectorizedDurationBasedAnimationSpec arg0) {
            return arg0.isInfinite();
        }
    }

    static long access$getDurationNanos$jd(VectorizedDurationBasedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return super.getDurationNanos(arg1, arg2, arg3);
    }

    static AnimationVector access$getEndVelocity$jd(VectorizedDurationBasedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return super.getEndVelocity(arg1, arg2, arg3);
    }

    static boolean access$isInfinite$jd(VectorizedDurationBasedAnimationSpec arg0) {
        return super.isInfinite();
    }

    int getDelayMillis();

    int getDurationMillis();

    default long getDurationNanos(AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return (((long)(this.getDelayMillis() + this.getDurationMillis()))) * 1000000;
    }
}

