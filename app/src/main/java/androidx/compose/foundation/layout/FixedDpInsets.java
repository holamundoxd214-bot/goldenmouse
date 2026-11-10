package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0018\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u000BH\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "toString", "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    private FixedDpInsets(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.leftDp = arg1;
        this.topDp = arg2;
        this.rightDp = arg3;
        this.bottomDp = arg4;
    }

    public FixedDpInsets(float arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((FixedDpInsets)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FixedDpInsets)) {
            return 0;
        }

        if((Dp.equals-impl0(this.leftDp, ((FixedDpInsets)arg5).leftDp)) && (Dp.equals-impl0(this.topDp, ((FixedDpInsets)arg5).topDp)) && (Dp.equals-impl0(this.rightDp, ((FixedDpInsets)arg5).rightDp)) && (Dp.equals-impl0(this.bottomDp, ((FixedDpInsets)arg5).bottomDp))) {
            return 1;
        }

        return 0;
    }

    public int getBottom(Density arg1) {
        return arg1.roundToPx-0680j_4(this.bottomDp);
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return arg1.roundToPx-0680j_4(this.leftDp);
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return arg1.roundToPx-0680j_4(this.rightDp);
    }

    public int getTop(Density arg1) {
        return arg1.roundToPx-0680j_4(this.topDp);
    }

    public int hashCode() {
        return ((Dp.hashCode-impl(this.leftDp) * 0x1F + Dp.hashCode-impl(this.topDp)) * 0x1F + Dp.hashCode-impl(this.rightDp)) * 0x1F + Dp.hashCode-impl(this.bottomDp);
    }

    public String toString() {
        return "Insets(left=" + Dp.toString-impl(this.leftDp) + ", top=" + Dp.toString-impl(this.topDp) + ", right=" + Dp.toString-impl(this.rightDp) + ", bottom=" + Dp.toString-impl(this.bottomDp) + ')';
    }
}

