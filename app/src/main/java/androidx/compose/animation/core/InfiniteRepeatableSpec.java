package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0017\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\u000BJ,\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001F"}, d2={"Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InfiniteRepeatableSpec implements AnimationSpec {
    public static final int $stable = 8;
    private final DurationBasedAnimationSpec animation;
    private final long initialStartOffset;
    private final RepeatMode repeatMode;

    static {
    }

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec arg1, RepeatMode arg2, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="This constructor has been deprecated") public InfiniteRepeatableSpec(DurationBasedAnimationSpec arg10, RepeatMode arg11) {
        this(arg10, arg11, StartOffset.constructor-impl$default(0, 0, 2, null), null);
    }

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec arg1, RepeatMode arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = RepeatMode.Restart;
        }

        this(arg1, arg2);
    }

    private InfiniteRepeatableSpec(DurationBasedAnimationSpec arg1, RepeatMode arg2, long arg3) {
        super();
        this.animation = arg1;
        this.repeatMode = arg2;
        this.initialStartOffset = arg3;
    }

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec arg7, RepeatMode arg8, long arg9, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 2) != 0) {
            arg8 = RepeatMode.Restart;
        }

        RepeatMode v2 = arg8;
        if((arg11 & 4) != 0) {
            arg9 = StartOffset.constructor-impl$default(0, 0, 2, null);
        }

        this(arg7, v2, arg9, null);
    }

    public boolean equals(Object arg5) {
        if(((arg5 instanceof InfiniteRepeatableSpec)) && (Intrinsics.areEqual(((InfiniteRepeatableSpec)arg5).animation, this.animation)) && ((InfiniteRepeatableSpec)arg5).repeatMode == this.repeatMode && (StartOffset.equals-impl0(((InfiniteRepeatableSpec)arg5).initialStartOffset, this.initialStartOffset))) {
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

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        return (this.animation.hashCode() * 0x1F + this.repeatMode.hashCode()) * 0x1F + StartOffset.hashCode-impl(this.initialStartOffset);
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg7) {
        return new VectorizedInfiniteRepeatableSpec(this.animation.vectorize(arg7), this.repeatMode, this.initialStartOffset, null);
    }
}

