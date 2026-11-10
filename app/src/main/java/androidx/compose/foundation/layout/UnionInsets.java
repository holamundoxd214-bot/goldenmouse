package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\r\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\b\u0010\u000F\u001A\u00020\u0007H\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/UnionInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "first", "second", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;)V", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "hashCode", "equals", "", "other", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class UnionInsets implements WindowInsets {
    private final WindowInsets first;
    private final WindowInsets second;

    public UnionInsets(WindowInsets arg1, WindowInsets arg2) {
        super();
        this.first = arg1;
        this.second = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((UnionInsets)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof UnionInsets)) {
            return 0;
        }

        if((Intrinsics.areEqual(((UnionInsets)arg5).first, this.first)) && (Intrinsics.areEqual(((UnionInsets)arg5).second, this.second))) {
            return 1;
        }

        return 0;
    }

    public int getBottom(Density arg2) {
        return Math.max(this.first.getBottom(arg2), this.second.getBottom(arg2));
    }

    public int getLeft(Density arg2, LayoutDirection arg3) {
        return Math.max(this.first.getLeft(arg2, arg3), this.second.getLeft(arg2, arg3));
    }

    public int getRight(Density arg2, LayoutDirection arg3) {
        return Math.max(this.first.getRight(arg2, arg3), this.second.getRight(arg2, arg3));
    }

    public int getTop(Density arg2) {
        return Math.max(this.first.getTop(arg2), this.second.getTop(arg2));
    }

    public int hashCode() {
        return this.first.hashCode() + this.second.hashCode() * 0x1F;
    }

    public String toString() {
        return "(" + this.first + " ∪ " + this.second + ')';
    }
}

