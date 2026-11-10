package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u008E\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001A9\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u0010\u0006\u001A2\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\f\u001A\u00020\rH\u0007\u001A9\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000F\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00112\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001A3\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\u0004\b\u0000\u0010\u00022\u001D\u0010\u0017\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u001A0\u0018¢\u0006\u0002\b\u001BH\u0007\u001A1\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00020\u001D\"\u0004\b\u0000\u0010\u00022\u001D\u0010\u0017\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001E\u0012\u0004\u0012\u00020\u001A0\u0018¢\u0006\u0002\b\u001B\u001A;\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00020\u001D\"\u0004\b\u0000\u0010\u00022\b\b\u0001\u0010\u001F\u001A\u00020\u00112\u001D\u0010\u0017\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001E\u0012\u0004\u0012\u00020\u001A0\u0018¢\u0006\u0002\b\u001B\u001AE\u0010 \u001A\b\u0012\u0004\u0012\u0002H\u00020!\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001A\u00020\n2\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(H\u0007¢\u0006\u0004\b)\u0010*\u001A4\u0010 \u001A\b\u0012\u0004\u0012\u0002H\u00020!\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001A\u00020\n2\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001A\u00020&H\u0007\u001A=\u0010+\u001A\b\u0012\u0004\u0012\u0002H\u00020,\"\u0004\b\u0000\u0010\u00022\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(H\u0007¢\u0006\u0004\b-\u0010.\u001A,\u0010+\u001A\b\u0012\u0004\u0012\u0002H\u00020,\"\u0004\b\u0000\u0010\u00022\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020$2\b\b\u0002\u0010%\u001A\u00020&H\u0007\u001A\u001E\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u000200\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u000B\u001A\u00020\nH\u0007\u001A*\u00101\u001A\b\u0012\u0004\u0012\u0002H\u000202\"\u0004\b\u0000\u0010\u00022\f\u00103\u001A\b\u0012\u0004\u0012\u0002H\u0002022\u0006\u00104\u001A\u000205H\u0001¨\u00066"}, d2={"convert", "V", "T", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", "init", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "keyframesWithSpline", "Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "periodicBias", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "repeatable-91I0pcU", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/RepeatableSpec;", "infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayed", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "startDelayNanos", "", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimationSpecKt {
    public static final AnimationVector access$convert(TwoWayConverter arg0, Object arg1) {
        return AnimationSpecKt.convert(arg0, arg1);
    }

    private static final AnimationVector convert(TwoWayConverter arg0, Object arg1) {
        if(arg1 == null) {
            return null;
        }

        return arg0.getConvertToVector().invoke(arg1);
    }

    public static final AnimationSpec delayed(AnimationSpec arg1, long arg2) {
        return new StartDelayAnimationSpec(arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This method has been deprecated in favor of the infinite repeatable function that accepts start offset.") public static final InfiniteRepeatableSpec infiniteRepeatable(DurationBasedAnimationSpec arg6, RepeatMode arg7) {
        return new InfiniteRepeatableSpec(arg6, arg7, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public static InfiniteRepeatableSpec infiniteRepeatable$default(DurationBasedAnimationSpec arg0, RepeatMode arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = RepeatMode.Restart;
        }

        return AnimationSpecKt.infiniteRepeatable(arg0, arg1);
    }

    public static final InfiniteRepeatableSpec infiniteRepeatable-9IiC70o(DurationBasedAnimationSpec arg6, RepeatMode arg7, long arg8) {
        return new InfiniteRepeatableSpec(arg6, arg7, arg8, null);
    }

    public static InfiniteRepeatableSpec infiniteRepeatable-9IiC70o$default(DurationBasedAnimationSpec arg0, RepeatMode arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = RepeatMode.Restart;
        }

        if((arg4 & 4) != 0) {
            arg2 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        return AnimationSpecKt.infiniteRepeatable-9IiC70o(arg0, arg1, arg2);
    }

    public static final KeyframesSpec keyframes(Function1 arg2) {
        KeyframesSpecConfig v1 = new KeyframesSpecConfig();
        arg2.invoke(v1);
        return new KeyframesSpec(v1);
    }

    public static final KeyframesWithSplineSpec keyframesWithSpline(float arg2, Function1 arg3) {
        KeyframesWithSplineSpecConfig v1 = new KeyframesWithSplineSpecConfig();
        arg3.invoke(v1);
        return new KeyframesWithSplineSpec(v1, arg2);
    }

    public static final KeyframesWithSplineSpec keyframesWithSpline(Function1 arg2) {
        KeyframesWithSplineSpecConfig v1 = new KeyframesWithSplineSpecConfig();
        arg2.invoke(v1);
        return new KeyframesWithSplineSpec(v1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This method has been deprecated in favor of the repeatable function that accepts start offset.") public static final RepeatableSpec repeatable(int arg7, DurationBasedAnimationSpec arg8, RepeatMode arg9) {
        return new RepeatableSpec(arg7, arg8, arg9, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public static RepeatableSpec repeatable$default(int arg0, DurationBasedAnimationSpec arg1, RepeatMode arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = RepeatMode.Restart;
        }

        return AnimationSpecKt.repeatable(arg0, arg1, arg2);
    }

    public static final RepeatableSpec repeatable-91I0pcU(int arg7, DurationBasedAnimationSpec arg8, RepeatMode arg9, long arg10) {
        return new RepeatableSpec(arg7, arg8, arg9, arg10, null);
    }

    public static RepeatableSpec repeatable-91I0pcU$default(int arg0, DurationBasedAnimationSpec arg1, RepeatMode arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg2 = RepeatMode.Restart;
        }

        if((arg5 & 8) != 0) {
            arg3 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        return AnimationSpecKt.repeatable-91I0pcU(arg0, arg1, arg2, arg3);
    }

    public static final SnapSpec snap(int arg1) {
        return new SnapSpec(arg1);
    }

    public static SnapSpec snap$default(int arg0, int arg1, Object arg2) {
        return AnimationSpecKt.snap(0);
    }

    public static final SpringSpec spring(float arg1, float arg2, Object arg3) {
        return new SpringSpec(arg1, arg2, arg3);
    }

    public static SpringSpec spring$default(float arg0, float arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg0 = 1f;
        }

        if((arg3 & 2) != 0) {
            arg1 = 1500f;
        }

        if((arg3 & 4) != 0) {
            arg2 = null;
        }

        return AnimationSpecKt.spring(arg0, arg1, arg2);
    }

    public static final TweenSpec tween(int arg1, int arg2, Easing arg3) {
        return new TweenSpec(arg1, arg2, arg3);
    }

    public static TweenSpec tween$default(int arg0, int arg1, Easing arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg0 = 300;
        }

        if((arg3 & 4) != 0) {
            arg2 = EasingKt.getFastOutSlowInEasing();
        }

        return AnimationSpecKt.tween(arg0, 0, arg2);
    }
}

