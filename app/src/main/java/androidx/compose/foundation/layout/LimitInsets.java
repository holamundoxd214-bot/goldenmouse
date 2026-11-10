package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0018\u0010\u0013\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0014\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\rH\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\n¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    private LimitInsets(WindowInsets arg1, int arg2) {
        super();
        this.insets = arg1;
        this.sides = arg2;
    }

    public LimitInsets(WindowInsets arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((LimitInsets)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LimitInsets)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.insets, ((LimitInsets)arg5).insets)) && (WindowInsetsSides.equals-impl0(this.sides, ((LimitInsets)arg5).sides))) {
            return 1;
        }

        return 0;
    }

    public int getBottom(Density arg3) {
        if(WindowInsetsSides.hasAny-bkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.getBottom-JoeWqyM())) {
            return this.insets.getBottom(arg3);
        }

        return 0;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int getLeft(Density arg3, LayoutDirection arg4) {
        int v0 = arg4 == LayoutDirection.Ltr ? WindowInsetsSides.Companion.getAllowLeftInLtr-JoeWqyM$foundation_layout() : WindowInsetsSides.Companion.getAllowLeftInRtl-JoeWqyM$foundation_layout();
        if(WindowInsetsSides.hasAny-bkgdKaI$foundation_layout(this.sides, v0)) {
            return this.insets.getLeft(arg3, arg4);
        }

        return 0;
    }

    public int getRight(Density arg3, LayoutDirection arg4) {
        int v0 = arg4 == LayoutDirection.Ltr ? WindowInsetsSides.Companion.getAllowRightInLtr-JoeWqyM$foundation_layout() : WindowInsetsSides.Companion.getAllowRightInRtl-JoeWqyM$foundation_layout();
        if(WindowInsetsSides.hasAny-bkgdKaI$foundation_layout(this.sides, v0)) {
            return this.insets.getRight(arg3, arg4);
        }

        return 0;
    }

    public final int getSides-JoeWqyM() {
        return this.sides;
    }

    public int getTop(Density arg3) {
        if(WindowInsetsSides.hasAny-bkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.getTop-JoeWqyM())) {
            return this.insets.getTop(arg3);
        }

        return 0;
    }

    public int hashCode() {
        return this.insets.hashCode() * 0x1F + WindowInsetsSides.hashCode-impl(this.sides);
    }

    public String toString() {
        return "(" + this.insets + " only " + WindowInsetsSides.toString-impl(this.sides) + ')';
    }
}

