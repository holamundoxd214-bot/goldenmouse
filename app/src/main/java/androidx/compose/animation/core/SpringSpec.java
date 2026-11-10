package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0015\u0010\u0006\u001A\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u001B"}, d2={"Landroidx/compose/animation/core/SpringSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFLjava/lang/Object;)V", "getDampingRatio", "()F", "getStiffness", "getVisibilityThreshold", "()Ljava/lang/Object;", "Ljava/lang/Object;", "vectorize", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SpringSpec implements FiniteAnimationSpec {
    public static final int $stable;
    private final float dampingRatio;
    private final float stiffness;
    private final Object visibilityThreshold;

    static {
    }

    public SpringSpec(float arg1, float arg2, Object arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 1f;
        }

        if((arg4 & 2) != 0) {
            arg2 = 1500f;
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public SpringSpec(float arg1, float arg2, Object arg3) {
        super();
        this.dampingRatio = arg1;
        this.stiffness = arg2;
        this.visibilityThreshold = arg3;
    }

    public SpringSpec() {
        this(0f, 0f, null, 7, null);
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof SpringSpec)) && ((SpringSpec)arg4).dampingRatio == this.dampingRatio && ((SpringSpec)arg4).stiffness == this.stiffness && (Intrinsics.areEqual(((SpringSpec)arg4).visibilityThreshold, this.visibilityThreshold))) {
            return 1;
        }

        return 0;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public final Object getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public int hashCode() {
        Object v0 = this.visibilityThreshold;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        return (v0_1 * 0x1F + Float.hashCode(this.dampingRatio)) * 0x1F + Float.hashCode(this.stiffness);
    }

    public VectorizedAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }

    public VectorizedSpringSpec vectorize(TwoWayConverter arg4) {
        return new VectorizedSpringSpec(this.dampingRatio, this.stiffness, AnimationSpecKt.convert(arg4, this.visibilityThreshold));
    }

    public VectorizedFiniteAnimationSpec vectorize(TwoWayConverter arg1) {
        return this.vectorize(arg1);
    }
}

