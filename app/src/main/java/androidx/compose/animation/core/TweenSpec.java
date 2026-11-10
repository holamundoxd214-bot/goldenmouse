package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001A"}, d2={"Landroidx/compose/animation/core/TweenSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "durationMillis", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(IILandroidx/compose/animation/core/Easing;)V", "getDurationMillis", "()I", "getDelay", "getEasing", "()Landroidx/compose/animation/core/Easing;", "vectorize", "Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TweenSpec implements DurationBasedAnimationSpec {
    public static final int $stable;
    private final int delay;
    private final int durationMillis;
    private final Easing easing;

    static {
    }

    public TweenSpec(int arg1, int arg2, Easing arg3) {
        super();
        this.durationMillis = arg1;
        this.delay = arg2;
        this.easing = arg3;
    }

    public TweenSpec() {
        this(0, 0, null, 7, null);
    }

    public TweenSpec(int arg1, int arg2, Easing arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 300;
        }

        if((arg4 & 4) != 0) {
            arg3 = EasingKt.getFastOutSlowInEasing();
        }

        this(arg1, 0, arg3);
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof TweenSpec)) && ((TweenSpec)arg4).durationMillis == this.durationMillis && ((TweenSpec)arg4).delay == this.delay && (Intrinsics.areEqual(((TweenSpec)arg4).easing, this.easing))) {
            return 1;
        }

        return 0;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    public int hashCode() {
        return (this.durationMillis * 0x1F + this.easing.hashCode()) * 0x1F + this.delay;
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedTweenSpec vectorize(TwoWayConverter arg3) {
        return new VectorizedTweenSpec(this.durationMillis, this.delay, this.easing);
    }

    public VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

