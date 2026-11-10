package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u000FJ\u000F\u0010\u0015\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/layout/InsetsPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "calculateLeftPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class InsetsPaddingValues implements PaddingValues {
    private final Density density;
    private final WindowInsets insets;

    public InsetsPaddingValues(WindowInsets arg1, Density arg2) {
        super();
        this.insets = arg1;
        this.density = arg2;
    }

    public float calculateBottomPadding-D9Ej5fM() {
        return this.density.toDp-u2uoSUM(this.insets.getBottom(this.density));
    }

    public float calculateLeftPadding-u2uoSUM(LayoutDirection arg2) {
        return this.density.toDp-u2uoSUM(this.insets.getLeft(this.density, arg2));
    }

    public float calculateRightPadding-u2uoSUM(LayoutDirection arg2) {
        return this.density.toDp-u2uoSUM(this.insets.getRight(this.density, arg2));
    }

    public float calculateTopPadding-D9Ej5fM() {
        return this.density.toDp-u2uoSUM(this.insets.getTop(this.density));
    }

    public boolean equals(Object arg5) {
        if(this == (((InsetsPaddingValues)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof InsetsPaddingValues)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.insets, ((InsetsPaddingValues)arg5).insets)) && (Intrinsics.areEqual(this.density, ((InsetsPaddingValues)arg5).density))) {
            return 1;
        }

        return 0;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int hashCode() {
        return this.insets.hashCode() * 0x1F + this.density.hashCode();
    }

    public String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ')';
    }
}

