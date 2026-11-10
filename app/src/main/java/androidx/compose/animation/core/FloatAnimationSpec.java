package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H&J(\u0010\t\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H&J \u0010\n\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0016J \u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H&J,\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000E0\r\"\b\b\u0000\u0010\u000E*\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000E0\u0011H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2={"Landroidx/compose/animation/core/FloatAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "vectorize", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FloatAnimationSpec extends AnimationSpec {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static float getEndVelocity(FloatAnimationSpec arg0, float arg1, float arg2, float arg3) {
            return arg0.getEndVelocity(arg1, arg2, arg3);
        }

        @Deprecated public static VectorizedFloatAnimationSpec vectorize(FloatAnimationSpec arg0, TwoWayConverter arg1) {
            return arg0.vectorize(arg1);
        }
    }

    static float access$getEndVelocity$jd(FloatAnimationSpec arg0, float arg1, float arg2, float arg3) {
        return super.getEndVelocity(arg1, arg2, arg3);
    }

    static VectorizedFloatAnimationSpec access$vectorize$jd(FloatAnimationSpec arg0, TwoWayConverter arg1) {
        return super.vectorize(arg1);
    }

    long getDurationNanos(float arg1, float arg2, float arg3);

    default float getEndVelocity(float arg7, float arg8, float arg9) {
        return this.getVelocityFromNanos(this.getDurationNanos(arg7, arg8, arg9), arg7, arg8, arg9);
    }

    float getValueFromNanos(long arg1, float arg2, float arg3, float arg4);

    float getVelocityFromNanos(long arg1, float arg2, float arg3, float arg4);

    default VectorizedFloatAnimationSpec vectorize(TwoWayConverter arg1) {
        return new VectorizedFloatAnimationSpec(this);
    }

    default VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

