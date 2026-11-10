package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A9\u0010\u0000\u001A\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u0002H\u00022\u0006\u0010\u0006\u001A\u0002H\u00022\u0006\u0010\u0007\u001A\u0002H\u0002H\u0000¢\u0006\u0002\u0010\b\u001AA\u0010\t\u001A\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u0002H\u00022\u0006\u0010\f\u001A\u0002H\u00022\u0006\u0010\r\u001A\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u000E\u001A\u0018\u0010\u000F\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001A\u00020\u0001H\u0000\u001A1\u0010\u0012\u001A\u00020\u0013\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0014\u001A\u0004\u0018\u0001H\u00022\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0018\"\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"getDurationMillis", "", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromMillis", "playTimeMillis", "start", "end", "startVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "clampPlayTime", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "playTime", "createSpringAnimations", "Landroidx/compose/animation/core/Animations;", "visibilityThreshold", "dampingRatio", "", "stiffness", "(Landroidx/compose/animation/core/AnimationVector;FF)Landroidx/compose/animation/core/Animations;", "EmptyIntArray", "", "EmptyFloatArray", "", "EmptyArcSpline", "Landroidx/compose/animation/core/ArcSpline;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VectorizedAnimationSpecKt {
    private static final ArcSpline EmptyArcSpline;
    private static final float[] EmptyFloatArray;
    private static final int[] EmptyIntArray;

    static {
        VectorizedAnimationSpecKt.EmptyIntArray = new int[0];
        VectorizedAnimationSpecKt.EmptyFloatArray = new float[0];
        VectorizedAnimationSpecKt.EmptyArcSpline = new ArcSpline(new int[2], new float[2], new float[][]{new float[2], new float[2]});
    }

    public static final Animations access$createSpringAnimations(AnimationVector arg0, float arg1, float arg2) {
        return VectorizedAnimationSpecKt.createSpringAnimations(arg0, arg1, arg2);
    }

    public static final ArcSpline access$getEmptyArcSpline$p() {
        return VectorizedAnimationSpecKt.EmptyArcSpline;
    }

    public static final float[] access$getEmptyFloatArray$p() {
        return VectorizedAnimationSpecKt.EmptyFloatArray;
    }

    public static final int[] access$getEmptyIntArray$p() {
        return VectorizedAnimationSpecKt.EmptyIntArray;
    }

    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec arg4, long arg5) {
        arg5 -= ((long)arg4.getDelayMillis());
        long v0 = ((long)arg4.getDurationMillis());
        long v2 = 0;
        if(arg5 < v2) {
            arg5 = v2;
        }

        if(arg5 > v0) {
            return v0;
        }

        return arg5;
    }

    private static final Animations createSpringAnimations(AnimationVector arg1, float arg2, float arg3) {
        if(arg1 != null) {
            return new VectorizedAnimationSpecKt$createSpringAnimations$1(arg1, arg2, arg3);
        }

        return new VectorizedAnimationSpecKt$createSpringAnimations$2(arg2, arg3);
    }

    public static final long getDurationMillis(VectorizedAnimationSpec arg0, AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return arg0.getDurationNanos(arg1, arg2, arg3) / 1000000;
    }

    public static final AnimationVector getValueFromMillis(VectorizedAnimationSpec arg2, long arg3, AnimationVector arg5, AnimationVector arg6, AnimationVector arg7) {
        return arg2.getValueFromNanos(arg3 * 1000000, arg5, arg6, arg7);
    }
}

