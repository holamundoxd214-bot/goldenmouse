package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fB)\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\rJ,\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0001\u0010\u0019*\u00020\u001A2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u001CH\u0016J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001A\u00020\n¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2={"Landroidx/compose/animation/core/RepeatableSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "getIterations", "()I", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "vectorize", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RepeatableSpec implements FiniteAnimationSpec {
    public static final int $stable;
    private final DurationBasedAnimationSpec animation;
    private final long initialStartOffset;
    private final int iterations;
    private final RepeatMode repeatMode;

    static {
    }

    public RepeatableSpec(int arg1, DurationBasedAnimationSpec arg2, RepeatMode arg3, long arg4, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This constructor has been deprecated") public RepeatableSpec(int arg11, DurationBasedAnimationSpec arg12, RepeatMode arg13) {
        this(arg11, arg12, arg13, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public RepeatableSpec(int arg1, DurationBasedAnimationSpec arg2, RepeatMode arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = RepeatMode.Restart;
        }

        this(arg1, arg2, arg3);
    }

    private RepeatableSpec(int arg1, DurationBasedAnimationSpec arg2, RepeatMode arg3, long arg4) {
        super();
        this.iterations = arg1;
        this.animation = arg2;
        this.repeatMode = arg3;
        this.initialStartOffset = arg4;
    }

    public RepeatableSpec(int arg8, DurationBasedAnimationSpec arg9, RepeatMode arg10, long arg11, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg10 = RepeatMode.Restart;
        }

        RepeatMode v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        this(arg8, arg9, v3, arg11, null);
    }

    public boolean equals(Object arg5) {
        if(((arg5 instanceof RepeatableSpec)) && ((RepeatableSpec)arg5).iterations == this.iterations && (Intrinsics.areEqual(((RepeatableSpec)arg5).animation, this.animation)) && ((RepeatableSpec)arg5).repeatMode == this.repeatMode && (StartOffset.equals-impl0(((RepeatableSpec)arg5).initialStartOffset, this.initialStartOffset))) {
            return 1;
        }

        return 0;
    }

    public final DurationBasedAnimationSpec getAnimation() {
        return this.animation;
    }

    public final long getInitialStartOffset-Rmkjzm4() {
        return this.initialStartOffset;
    }

    public final int getIterations() {
        return this.iterations;
    }

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        return ((this.iterations * 0x1F + this.animation.hashCode()) * 0x1F + this.repeatMode.hashCode()) * 0x1F + StartOffset.hashCode-impl(this.initialStartOffset);
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg8) {
        return new VectorizedRepeatableSpec(this.iterations, this.animation.vectorize(arg8), this.repeatMode, this.initialStartOffset, null);
    }
}

