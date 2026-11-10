package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A3\u0010\u0007\u001A\u0002H\b\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u00020\n*\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00022\u0006\u0010\u000B\u001A\u00020\u0001¢\u0006\u0002\u0010\f\u001AE\u0010\r\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u000E\"\b\b\u0000\u0010\t*\u00020\n*\b\u0012\u0004\u0012\u0002H\t0\u000F2\u0006\u0010\u0010\u001A\u0002H\t2\u0006\u0010\u0011\u001A\u0002H\t2\u0006\u0010\u0012\u001A\u0002H\tH\u0007¢\u0006\u0002\u0010\u0013\u001Aa\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000E\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u00020\n2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\b0\u00162\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00182\u0006\u0010\u0010\u001A\u0002H\b2\u0006\u0010\u0011\u001A\u0002H\b2\u0006\u0010\u0012\u001A\u0002H\b¢\u0006\u0002\u0010\u0019\u001A,\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D0\u001B2\u0006\u0010\u0015\u001A\u00020\u001E2\u0006\u0010\u0010\u001A\u00020\u001C2\b\b\u0002\u0010\u0012\u001A\u00020\u001C\" \u0010\u0000\u001A\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"durationMillis", "", "Landroidx/compose/animation/core/Animation;", "getDurationMillis", "(Landroidx/compose/animation/core/Animation;)J", "MillisToNanos", "SecondsToMillis", "getVelocityFromNanos", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "playTimeNanos", "(Landroidx/compose/animation/core/Animation;J)Ljava/lang/Object;", "createAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/TargetBasedAnimation;", "TargetBasedAnimation", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/TargetBasedAnimation;", "DecayAnimation", "Landroidx/compose/animation/core/DecayAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimationKt {
    public static final long MillisToNanos = 1000000;
    public static final long SecondsToMillis = 1000;

    public static final DecayAnimation DecayAnimation(FloatDecayAnimationSpec arg2, float arg3, float arg4) {
        return new DecayAnimation(DecayAnimationSpecKt.generateDecayAnimationSpec(arg2), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(arg3), AnimationVectorsKt.AnimationVector(arg4));
    }

    public static DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec arg0, float arg1, float arg2, int arg3, Object arg4) {
        return AnimationKt.DecayAnimation(arg0, arg1, 0f);
    }

    public static final TargetBasedAnimation TargetBasedAnimation(AnimationSpec arg6, TwoWayConverter arg7, Object arg8, Object arg9, Object arg10) {
        return new TargetBasedAnimation(arg6, arg7, arg8, arg9, arg7.getConvertToVector().invoke(arg10));
    }

    public static final TargetBasedAnimation createAnimation(VectorizedAnimationSpec arg8, AnimationVector arg9, AnimationVector arg10, AnimationVector arg11) {
        return new TargetBasedAnimation(arg8, VectorConvertersKt.TwoWayConverter(new AnimationKt$$ExternalSyntheticLambda0(), new AnimationKt$$ExternalSyntheticLambda1()), arg9, arg10, arg11);
    }

    static final AnimationVector createAnimation$lambda$0(AnimationVector arg0) {
        return arg0;
    }

    static final AnimationVector createAnimation$lambda$1(AnimationVector arg0) {
        return arg0;
    }

    public static final long getDurationMillis(Animation arg4) {
        return arg4.getDurationNanos() / 1000000;
    }

    public static final Object getVelocityFromNanos(Animation arg1, long arg2) {
        return arg1.getTypeConverter().getConvertFromVector().invoke(arg1.getVelocityVectorFromNanos(arg2));
    }
}

