package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Landroidx/compose/animation/Fade;", "", "alpha", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(FLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAlpha", "()F", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Fade {
    public static final int $stable;
    private final float alpha;
    private final FiniteAnimationSpec animationSpec;

    static {
    }

    public Fade(float arg1, FiniteAnimationSpec arg2) {
        super();
        this.alpha = arg1;
        this.animationSpec = arg2;
    }

    public final float component1() {
        return this.alpha;
    }

    public final FiniteAnimationSpec component2() {
        return this.animationSpec;
    }

    public final Fade copy(float arg1, FiniteAnimationSpec arg2) {
        return new Fade(arg1, arg2);
    }

    public static Fade copy$default(Fade arg0, float arg1, FiniteAnimationSpec arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.alpha;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.animationSpec;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((Fade)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Fade)) {
            return 0;
        }

        if(Float.compare(this.alpha, ((Fade)arg5).alpha) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((Fade)arg5).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return Float.hashCode(this.alpha) * 0x1F + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Fade(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + ')';
    }
}

