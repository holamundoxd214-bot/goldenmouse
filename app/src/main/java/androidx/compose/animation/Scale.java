package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u000F\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J4\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001F"}, d2={"Landroidx/compose/animation/Scale;", "", "scale", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScale", "()F", "getTransformOrigin-SzJe1aQ", "()J", "J", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "component2-SzJe1aQ", "component3", "copy", "copy-bnNdC4k", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;)Landroidx/compose/animation/Scale;", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Scale {
    public static final int $stable;
    private final FiniteAnimationSpec animationSpec;
    private final float scale;
    private final long transformOrigin;

    static {
    }

    public Scale(float arg1, long arg2, FiniteAnimationSpec arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    private Scale(float arg1, long arg2, FiniteAnimationSpec arg4) {
        super();
        this.scale = arg1;
        this.transformOrigin = arg2;
        this.animationSpec = arg4;
    }

    public final float component1() {
        return this.scale;
    }

    public final long component2-SzJe1aQ() {
        return this.transformOrigin;
    }

    public final FiniteAnimationSpec component3() {
        return this.animationSpec;
    }

    public final Scale copy-bnNdC4k(float arg7, long arg8, FiniteAnimationSpec arg10) {
        return new Scale(arg7, arg8, arg10, null);
    }

    public static Scale copy-bnNdC4k$default(Scale arg0, float arg1, long arg2, FiniteAnimationSpec arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.scale;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.transformOrigin;
        }

        if((arg5 & 4) != 0) {
            arg4 = arg0.animationSpec;
        }

        return arg0.copy-bnNdC4k(arg1, arg2, arg4);
    }

    public boolean equals(Object arg8) {
        if(this == (((Scale)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Scale)) {
            return 0;
        }

        if(Float.compare(this.scale, ((Scale)arg8).scale) != 0) {
            return 0;
        }

        if(!TransformOrigin.equals-impl0(this.transformOrigin, ((Scale)arg8).transformOrigin)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((Scale)arg8).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final float getScale() {
        return this.scale;
    }

    public final long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    public int hashCode() {
        return (Float.hashCode(this.scale) * 0x1F + TransformOrigin.hashCode-impl(this.transformOrigin)) * 0x1F + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Scale(scale=" + this.scale + ", transformOrigin=" + TransformOrigin.toString-impl(this.transformOrigin) + ", animationSpec=" + this.animationSpec + ')';
    }
}

