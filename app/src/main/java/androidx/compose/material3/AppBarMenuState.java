package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001A\u00020\rJ\u0006\u0010\u000E\u001A\u00020\rR+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000B\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000F"}, d2={"Landroidx/compose/material3/AppBarMenuState;", "", "<init>", "()V", "<set-?>", "", "isExpanded", "()Z", "setExpanded", "(Z)V", "isExpanded$delegate", "Landroidx/compose/runtime/MutableState;", "dismiss", "", "show", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AppBarMenuState {
    public static final int $stable;
    private final MutableState isExpanded$delegate;

    static {
    }

    public AppBarMenuState() {
        super();
        this.isExpanded$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public final void dismiss() {
        this.setExpanded(false);
    }

    public final boolean isExpanded() {
        return this.isExpanded$delegate.getValue().booleanValue();
    }

    private final void setExpanded(boolean arg1) {
        this.isExpanded$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void show() {
        this.setExpanded(true);
    }
}

