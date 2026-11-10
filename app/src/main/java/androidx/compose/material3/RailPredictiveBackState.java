package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005R+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2={"Landroidx/compose/material3/RailPredictiveBackState;", "", "<init>", "()V", "<set-?>", "", "swipeEdgeMatchesRail", "getSwipeEdgeMatchesRail", "()Z", "setSwipeEdgeMatchesRail", "(Z)V", "swipeEdgeMatchesRail$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "isSwipeEdgeLeft", "isRtl", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RailPredictiveBackState {
    public static final int $stable;
    private final MutableState swipeEdgeMatchesRail$delegate;

    static {
    }

    public RailPredictiveBackState() {
        super();
        this.swipeEdgeMatchesRail$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
    }

    public final boolean getSwipeEdgeMatchesRail() {
        return this.swipeEdgeMatchesRail$delegate.getValue().booleanValue();
    }

    public final void setSwipeEdgeMatchesRail(boolean arg1) {
        this.swipeEdgeMatchesRail$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void update(boolean arg1, boolean arg2) {
        if(!arg1 || (arg2)) {
            if(!arg1 && (arg2)) {
            label_4:
                arg1 = true;
                goto label_7;
            }

            arg1 = false;
        }
        else {
            goto label_4;
        }

    label_7:
        this.setSwipeEdgeMatchesRail(arg1);
    }
}

