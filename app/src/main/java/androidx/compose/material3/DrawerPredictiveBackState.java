package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\r2\u0006\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\rJ\u0006\u0010!\u001A\u00020\u001AR+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\r8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\r8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001A\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012¨\u0006\""}, d2={"Landroidx/compose/material3/DrawerPredictiveBackState;", "", "<init>", "()V", "<set-?>", "", "swipeEdgeMatchesDrawer", "getSwipeEdgeMatchesDrawer", "()Z", "setSwipeEdgeMatchesDrawer", "(Z)V", "swipeEdgeMatchesDrawer$delegate", "Landroidx/compose/runtime/MutableState;", "", "scaleXDistance", "getScaleXDistance", "()F", "setScaleXDistance", "(F)V", "scaleXDistance$delegate", "Landroidx/compose/runtime/MutableFloatState;", "scaleYDistance", "getScaleYDistance", "setScaleYDistance", "scaleYDistance$delegate", "update", "", "progress", "swipeEdgeLeft", "isRtl", "maxScaleXDistanceGrow", "maxScaleXDistanceShrink", "maxScaleYDistance", "clear", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawerPredictiveBackState {
    public static final int $stable;
    private final MutableFloatState scaleXDistance$delegate;
    private final MutableFloatState scaleYDistance$delegate;
    private final MutableState swipeEdgeMatchesDrawer$delegate;

    static {
    }

    public DrawerPredictiveBackState() {
        super();
        this.swipeEdgeMatchesDrawer$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.scaleXDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.scaleYDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
    }

    public final void clear() {
        this.setSwipeEdgeMatchesDrawer(true);
        this.setScaleXDistance(0f);
        this.setScaleYDistance(0f);
    }

    public final float getScaleXDistance() {
        return this.scaleXDistance$delegate.getFloatValue();
    }

    public final float getScaleYDistance() {
        return this.scaleYDistance$delegate.getFloatValue();
    }

    public final boolean getSwipeEdgeMatchesDrawer() {
        return this.swipeEdgeMatchesDrawer$delegate.getValue().booleanValue();
    }

    public final void setScaleXDistance(float arg1) {
        this.scaleXDistance$delegate.setFloatValue(arg1);
    }

    public final void setScaleYDistance(float arg1) {
        this.scaleYDistance$delegate.setFloatValue(arg1);
    }

    public final void setSwipeEdgeMatchesDrawer(boolean arg1) {
        this.swipeEdgeMatchesDrawer$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void update(float arg1, boolean arg2, boolean arg3, float arg4, float arg5, float arg6) {
        arg2 = arg2 != arg3 ? true : false;
        this.setSwipeEdgeMatchesDrawer(arg2);
        if(this.getSwipeEdgeMatchesDrawer()) {
        }
        else {
            arg4 = arg5;
        }

        this.setScaleXDistance(MathHelpersKt.lerp(0f, arg4, arg1));
        this.setScaleYDistance(MathHelpersKt.lerp(0f, arg6, arg1));
    }
}

