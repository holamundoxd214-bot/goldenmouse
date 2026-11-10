package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\r\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/PaddingValuesInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "toString", "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingValuesInsets implements WindowInsets {
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(PaddingValues arg1) {
        super();
        this.paddingValues = arg1;
    }

    public boolean equals(Object arg2) {
        if(this == (((PaddingValuesInsets)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof PaddingValuesInsets)) {
            return 0;
        }

        return Intrinsics.areEqual(((PaddingValuesInsets)arg2).paddingValues, this.paddingValues);
    }

    public int getBottom(Density arg1) {
        return arg1.roundToPx-0680j_4(this.paddingValues.calculateBottomPadding-D9Ej5fM());
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return arg1.roundToPx-0680j_4(this.paddingValues.calculateLeftPadding-u2uoSUM(arg2));
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return arg1.roundToPx-0680j_4(this.paddingValues.calculateRightPadding-u2uoSUM(arg2));
    }

    public int getTop(Density arg1) {
        return arg1.roundToPx-0680j_4(this.paddingValues.calculateTopPadding-D9Ej5fM());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public String toString() {
        return "PaddingValues(" + Dp.toString-impl(this.paddingValues.calculateLeftPadding-u2uoSUM(LayoutDirection.Ltr)) + ", " + Dp.toString-impl(this.paddingValues.calculateTopPadding-D9Ej5fM()) + ", " + Dp.toString-impl(this.paddingValues.calculateRightPadding-u2uoSUM(LayoutDirection.Ltr)) + ", " + Dp.toString-impl(this.paddingValues.calculateBottomPadding-D9Ej5fM()) + ')';
    }
}

