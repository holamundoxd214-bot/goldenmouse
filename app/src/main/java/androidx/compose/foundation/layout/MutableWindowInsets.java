package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0018\u0010\u0013\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0014\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016R+\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00018F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000B\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/MutableWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "initialInsets", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "<set-?>", "insets", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setInsets", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableWindowInsets implements WindowInsets {
    public static final int $stable;
    private final MutableState insets$delegate;

    static {
    }

    public MutableWindowInsets() {
        this(null, 1, null);
    }

    public MutableWindowInsets(WindowInsets arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = WindowInsetsKt.WindowInsets(0, 0, 0, 0);
        }

        this(arg1);
    }

    public MutableWindowInsets(WindowInsets arg3) {
        super();
        this.insets$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    public int getBottom(Density arg1) {
        return this.getInsets().getBottom(arg1);
    }

    public final WindowInsets getInsets() {
        return this.insets$delegate.getValue();
    }

    public int getLeft(Density arg1, LayoutDirection arg2) {
        return this.getInsets().getLeft(arg1, arg2);
    }

    public int getRight(Density arg1, LayoutDirection arg2) {
        return this.getInsets().getRight(arg1, arg2);
    }

    public int getTop(Density arg1) {
        return this.getInsets().getTop(arg1);
    }

    public final void setInsets(WindowInsets arg1) {
        this.insets$delegate.setValue(arg1);
    }
}

