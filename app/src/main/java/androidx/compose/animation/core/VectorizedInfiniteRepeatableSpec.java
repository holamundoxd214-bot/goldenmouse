package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB!\b\u0017\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\fJ\u0010\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0011H\u0002J-\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001BJ-\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001BJ-\u0010 \u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001BJ%\u0010!\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\"R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0014\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/animation/core/VectorizedInfiniteRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "isInfinite", "", "()Z", "durationNanos", "", "getDurationNanos$animation_core", "()J", "initialOffsetNanos", "repetitionPlayTimeNanos", "playTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorizedInfiniteRepeatableSpec implements VectorizedAnimationSpec {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final RepeatMode repeatMode;

    static {
    }

    public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec arg1, RepeatMode arg2, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This method has been deprecated in favor of the constructor that accepts start offset.") public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec arg10, RepeatMode arg11) {
        this(arg10, arg11, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec arg1, RepeatMode arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = RepeatMode.Restart;
        }

        this(arg1, arg2);
    }

    private VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec arg3, RepeatMode arg4, long arg5) {
        super();
        this.animation = arg3;
        this.repeatMode = arg4;
        this.durationNanos = (((long)(arg3.getDelayMillis() + arg3.getDurationMillis()))) * 1000000;
        this.initialOffsetNanos = arg5 * 1000000;
    }

    public VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec arg7, RepeatMode arg8, long arg9, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 2) != 0) {
            arg8 = RepeatMode.Restart;
        }

        RepeatMode v2 = arg8;
        if((arg11 & 4) != 0) {
            arg9 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        this(arg7, v2, arg9, null);
    }

    public long getDurationNanos(AnimationVector arg1, AnimationVector arg2, AnimationVector arg3) {
        return 0x7FFFFFFFFFFFFFFFL;
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

    public boolean isInfinite() {
        return 1;
    }

    private final long repetitionPlayTimeNanos(long arg7) {
        long v0 = this.initialOffsetNanos;
        long v4 = 0;
        if(arg7 + v0 <= v4) {
            return v4;
        }

        arg7 += v0;
        v0 = arg7 / this.durationNanos;
        if(this.repeatMode != RepeatMode.Restart) {
            if(v0 % 2 == v4) {
            }
            else {
                return (v0 + 1) * this.durationNanos - arg7;
            }
        }

        return arg7 - v0 * this.durationNanos;
    }

    private final AnimationVector repetitionStartVelocity(long arg11, AnimationVector arg13, AnimationVector arg14, AnimationVector arg15) {
        long v0 = this.initialOffsetNanos;
        long v2 = this.durationNanos;
        if(arg11 + v0 > v2) {
            return this.animation.getVelocityFromNanos(v2 - v0, arg13, arg15, arg14);
        }

        return arg14;
    }
}

