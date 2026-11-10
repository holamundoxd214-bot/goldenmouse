package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\b\b\u0001\u0010\u000B*\u00020\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2={"Landroidx/compose/animation/core/SnapSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "delay", "", "<init>", "(I)V", "getDelay", "()I", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnapSpec implements DurationBasedAnimationSpec {
    public static final int $stable;
    private final int delay;

    static {
    }

    public SnapSpec(int arg1) {
        super();
        this.delay = arg1;
    }

    public SnapSpec() {
        this(0, 1, null);
    }

    public SnapSpec(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(0);
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof SnapSpec)) && ((SnapSpec)arg3).delay == this.delay) {
            return 1;
        }

        return 0;
    }

    public final int getDelay() {
        return this.delay;
    }

    public int hashCode() {
        return this.delay;
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverter arg1) {
        return new VectorizedSnapSpec(this.delay);
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

