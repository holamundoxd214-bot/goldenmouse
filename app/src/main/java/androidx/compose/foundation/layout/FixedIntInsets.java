package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u000E\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010\u000F\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u0010\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/FixedIntInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftVal", "", "topVal", "rightVal", "bottomVal", "<init>", "(IIII)V", "getLeft", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "toString", "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FixedIntInsets implements WindowInsets {
    private final int bottomVal;
    private final int leftVal;
    private final int rightVal;
    private final int topVal;

    public FixedIntInsets(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.leftVal = arg1;
        this.topVal = arg2;
        this.rightVal = arg3;
        this.bottomVal = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((FixedIntInsets)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FixedIntInsets)) {
            return 0;
        }

        if(this.leftVal == ((FixedIntInsets)arg5).leftVal && this.topVal == ((FixedIntInsets)arg5).topVal && this.rightVal == ((FixedIntInsets)arg5).rightVal && this.bottomVal == ((FixedIntInsets)arg5).bottomVal) {
            return 1;
        }

        return 0;
    }

    public int getBottom(Density arg1) {
        return this.bottomVal;
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return this.leftVal;
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return this.rightVal;
    }

    public int getTop(Density arg1) {
        return this.topVal;
    }

    public int hashCode() {
        return ((this.leftVal * 0x1F + this.topVal) * 0x1F + this.rightVal) * 0x1F + this.bottomVal;
    }

    public String toString() {
        return "Insets(left=" + this.leftVal + ", top=" + this.topVal + ", right=" + this.rightVal + ", bottom=" + this.bottomVal + ')';
    }
}

