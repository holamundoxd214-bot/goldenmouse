package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B8\u0012!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000B\u0010\fJ$\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000F\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J>\u0010\u0013\u001A\u00020\u00002#\b\u0002\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R,\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Landroidx/compose/animation/Slide;", "", "slideOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "Landroidx/compose/ui/unit/IntOffset;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getSlideOffset", "()Lkotlin/jvm/functions/Function1;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Slide {
    public static final int $stable;
    private final FiniteAnimationSpec animationSpec;
    private final Function1 slideOffset;

    static {
    }

    public Slide(Function1 arg1, FiniteAnimationSpec arg2) {
        super();
        this.slideOffset = arg1;
        this.animationSpec = arg2;
    }

    public final Function1 component1() {
        return this.slideOffset;
    }

    public final FiniteAnimationSpec component2() {
        return this.animationSpec;
    }

    public final Slide copy(Function1 arg1, FiniteAnimationSpec arg2) {
        return new Slide(arg1, arg2);
    }

    public static Slide copy$default(Slide arg0, Function1 arg1, FiniteAnimationSpec arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.slideOffset;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.animationSpec;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((Slide)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Slide)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.slideOffset, ((Slide)arg5).slideOffset)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((Slide)arg5).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1 getSlideOffset() {
        return this.slideOffset;
    }

    public int hashCode() {
        return this.slideOffset.hashCode() * 0x1F + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Slide(slideOffset=" + this.slideOffset + ", animationSpec=" + this.animationSpec + ')';
    }
}

