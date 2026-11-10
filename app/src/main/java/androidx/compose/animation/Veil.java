package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0018\u001A\u00020\bHÆ\u0003J>\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u0013\u0010\u001C\u001A\u00020\b2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2={"Landroidx/compose/animation/Veil;", "", "initialColor", "Landroidx/compose/ui/graphics/Color;", "targetColor", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "matchParentSize", "", "<init>", "(JJLandroidx/compose/animation/core/FiniteAnimationSpec;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialColor-0d7_KjU", "()J", "J", "getTargetColor-0d7_KjU", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getMatchParentSize", "()Z", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component4", "copy", "copy-RFnl5yQ", "(JJLandroidx/compose/animation/core/FiniteAnimationSpec;Z)Landroidx/compose/animation/Veil;", "equals", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Veil {
    public static final int $stable;
    private final FiniteAnimationSpec animationSpec;
    private final long initialColor;
    private final boolean matchParentSize;
    private final long targetColor;

    static {
    }

    public Veil(long arg1, long arg3, FiniteAnimationSpec arg5, boolean arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5, arg6);
    }

    private Veil(long arg1, long arg3, FiniteAnimationSpec arg5, boolean arg6) {
        super();
        this.initialColor = arg1;
        this.targetColor = arg3;
        this.animationSpec = arg5;
        this.matchParentSize = arg6;
    }

    public final long component1-0d7_KjU() {
        return this.initialColor;
    }

    public final long component2-0d7_KjU() {
        return this.targetColor;
    }

    public final FiniteAnimationSpec component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.matchParentSize;
    }

    public final Veil copy-RFnl5yQ(long arg9, long arg11, FiniteAnimationSpec arg13, boolean arg14) {
        return new Veil(arg9, arg11, arg13, arg14, null);
    }

    public static Veil copy-RFnl5yQ$default(Veil arg7, long arg8, long arg10, FiniteAnimationSpec arg12, boolean arg13, int arg14, Object arg15) {
        if((arg14 & 1) != 0) {
            arg8 = arg7.initialColor;
        }

        long v1 = arg8;
        if((arg14 & 2) != 0) {
            arg10 = arg7.targetColor;
        }

        long v3 = arg10;
        if((arg14 & 4) != 0) {
            arg12 = arg7.animationSpec;
        }

        FiniteAnimationSpec v5 = arg12;
        if((arg14 & 8) != 0) {
            arg13 = arg7.matchParentSize;
        }

        return arg7.copy-RFnl5yQ(v1, v3, v5, arg13);
    }

    public boolean equals(Object arg8) {
        if(this == (((Veil)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Veil)) {
            return 0;
        }

        if(!Color.equals-impl0(this.initialColor, ((Veil)arg8).initialColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.targetColor, ((Veil)arg8).targetColor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((Veil)arg8).animationSpec)) {
            return 0;
        }

        if(this.matchParentSize != ((Veil)arg8).matchParentSize) {
            return 0;
        }

        return 1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final long getInitialColor-0d7_KjU() {
        return this.initialColor;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    public final long getTargetColor-0d7_KjU() {
        return this.targetColor;
    }

    public int hashCode() {
        return ((Color.hashCode-impl(this.initialColor) * 0x1F + Color.hashCode-impl(this.targetColor)) * 0x1F + this.animationSpec.hashCode()) * 0x1F + Boolean.hashCode(this.matchParentSize);
    }

    public String toString() {
        return "Veil(initialColor=" + Color.toString-impl(this.initialColor) + ", targetColor=" + Color.toString-impl(this.targetColor) + ", animationSpec=" + this.animationSpec + ", matchParentSize=" + this.matchParentSize + ')';
    }
}

