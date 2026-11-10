package androidx.compose.animation.core;

import androidx.collection.IntListKt;
import androidx.collection.IntObjectMapKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ,\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u0006H\u0016R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001E"}, d2={"Landroidx/compose/animation/core/ArcAnimationSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "mode", "Landroidx/compose/animation/core/ArcMode;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(IIILandroidx/compose/animation/core/Easing;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMode--9T-Mq4", "()I", "I", "getDurationMillis", "getDelayMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ArcAnimationSpec implements DurationBasedAnimationSpec {
    public static final int $stable;
    private final int delayMillis;
    private final int durationMillis;
    private final Easing easing;
    private final int mode;

    static {
    }

    private ArcAnimationSpec(int arg1, int arg2, int arg3, Easing arg4) {
        super();
        this.mode = arg1;
        this.durationMillis = arg2;
        this.delayMillis = arg3;
        this.easing = arg4;
    }

    public ArcAnimationSpec(int arg7, int arg8, int arg9, Easing arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 1) != 0) {
            arg7 = ArcMode.Companion.getArcBelow--9T-Mq4();
        }

        int v1 = arg7;
        if((arg11 & 2) != 0) {
            arg8 = 300;
        }

        int v2 = arg8;
        if((arg11 & 8) != 0) {
            arg10 = EasingKt.getFastOutSlowInEasing();
        }

        this(v1, v2, 0, arg10, null);
    }

    public ArcAnimationSpec(int arg1, int arg2, int arg3, Easing arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg4) {
        if(this == (((ArcAnimationSpec)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ArcAnimationSpec)) {
            return 0;
        }

        if(!ArcMode.equals-impl0(this.mode, ((ArcAnimationSpec)arg4).mode)) {
            return 0;
        }

        if(this.durationMillis != ((ArcAnimationSpec)arg4).durationMillis) {
            return 0;
        }

        if(this.delayMillis != ((ArcAnimationSpec)arg4).delayMillis) {
            return 0;
        }

        return Intrinsics.areEqual(this.easing, ((ArcAnimationSpec)arg4).easing);
    }

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    public final int getMode--9T-Mq4() {
        return this.mode;
    }

    public int hashCode() {
        return ((ArcMode.hashCode-impl(this.mode) * 0x1F + this.durationMillis) * 0x1F + this.delayMillis) * 0x1F + this.easing.hashCode();
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter arg9) {
        return new VectorizedKeyframesSpec(IntListKt.intListOf(0, this.durationMillis), IntObjectMapKt.emptyIntObjectMap(), this.durationMillis, this.delayMillis, this.easing, this.mode, null);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

