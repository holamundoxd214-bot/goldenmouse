package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rB)\b\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\f\u0010\u000EJ\u0010\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0010H\u0002J-\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001AJ-\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AJ-\u0010\u001F\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AJ%\u0010 \u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010!R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/animation/core/VectorizedRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "durationNanos", "", "getDurationNanos$animation_core", "()J", "initialOffsetNanos", "repetitionPlayTimeNanos", "playTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedRepeatableSpec implements VectorizedFiniteAnimationSpec {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final int iterations;
    private final RepeatMode repeatMode;

    static {
    }

    public VectorizedRepeatableSpec(int arg1, VectorizedDurationBasedAnimationSpec arg2, RepeatMode arg3, long arg4, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This method has been deprecated in favor of the constructor that accepts start offset.") public VectorizedRepeatableSpec(int arg11, VectorizedDurationBasedAnimationSpec arg12, RepeatMode arg13) {
        this(arg11, arg12, arg13, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public VectorizedRepeatableSpec(int arg1, VectorizedDurationBasedAnimationSpec arg2, RepeatMode arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = RepeatMode.Restart;
        }

        this(arg1, arg2, arg3);
    }

    private VectorizedRepeatableSpec(int arg3, VectorizedDurationBasedAnimationSpec arg4, RepeatMode arg5, long arg6) {
        super();
        this.iterations = arg3;
        this.animation = arg4;
        this.repeatMode = arg5;
        if(arg3 >= 1) {
            this.durationNanos = (((long)(arg4.getDelayMillis() + arg4.getDurationMillis()))) * 1000000;
            this.initialOffsetNanos = arg6 * 1000000;
            return;
        }

        throw new IllegalArgumentException("Iterations count can\'t be less than 1");
    }

    public VectorizedRepeatableSpec(int arg8, VectorizedDurationBasedAnimationSpec arg9, RepeatMode arg10, long arg11, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg10 = RepeatMode.Restart;
        }

        RepeatMode v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        this(arg8, arg9, v3, arg11, null);
    }

    public long getDurationNanos(AnimationVector arg3, AnimationVector arg4, AnimationVector arg5) {
        return (((long)this.iterations)) * this.durationNanos - this.initialOffsetNanos;
    }

    public final long getDurationNanos$animation_core() {
        return this.durationNanos;
    }

    public AnimationVector getValueFromNanos(long arg7, AnimationVector arg9, AnimationVector arg10, AnimationVector arg11) {
        return this.animation.getValueFromNanos(this.repetitionPlayTimeNanos(arg7), arg9, arg10, this.repetitionStartVelocity(arg7, arg9, arg11, arg10));
    }

    public AnimationVector getVelocityFromNanos(long arg7, AnimationVector arg9, AnimationVector arg10, AnimationVector arg11) {
        return this.animation.getVelocityFromNanos(this.repetitionPlayTimeNanos(arg7), arg9, arg10, this.repetitionStartVelocity(arg7, arg9, arg11, arg10));
    }

    private final long repetitionPlayTimeNanos(long arg9) {
        long v0 = this.initialOffsetNanos;
        long v4 = 0;
        if(arg9 + v0 <= v4) {
            return v4;
        }

        arg9 += v0;
        long v6 = 1;
        v0 = Math.min(arg9 / this.durationNanos, (((long)this.iterations)) - v6);
        if(this.repeatMode != RepeatMode.Restart) {
            if(v0 % 2 == v4) {
            }
            else {
                return (v0 + v6) * this.durationNanos - arg9;
            }
        }

        return arg9 - v0 * this.durationNanos;
    }

    private final AnimationVector repetitionStartVelocity(long arg11, AnimationVector arg13, AnimationVector arg14, AnimationVector arg15) {
        long v0 = this.initialOffsetNanos;
        long v2 = this.durationNanos;
        if(arg11 + v0 > v2) {
            return this.getVelocityFromNanos(v2 - v0, arg13, arg14, arg15);
        }

        return arg14;
    }
}

