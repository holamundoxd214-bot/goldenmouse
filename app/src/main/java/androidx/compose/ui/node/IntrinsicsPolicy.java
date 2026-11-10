package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0005J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016J\u000E\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0016J\u000E\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016J\u000E\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0016J\u000E\u0010\u001C\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016J\u000E\u0010\u001D\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0016J\u000E\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016J\u000E\u0010\u001F\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR+\u0010\u000B\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00058B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006 "}, d2={"Landroidx/compose/ui/node/IntrinsicsPolicy;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "policy", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/MeasurePolicy;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "<set-?>", "measurePolicyState", "getMeasurePolicyState", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicyState", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measurePolicyState$delegate", "Landroidx/compose/runtime/MutableState;", "updateFrom", "", "measurePolicy", "minIntrinsicWidth", "", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "minLookaheadIntrinsicWidth", "minLookaheadIntrinsicHeight", "maxLookaheadIntrinsicWidth", "maxLookaheadIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IntrinsicsPolicy {
    public static final int $stable = 8;
    private final LayoutNode layoutNode;
    private final MutableState measurePolicyState$delegate;

    static {
    }

    public IntrinsicsPolicy(LayoutNode arg2, MeasurePolicy arg3) {
        super();
        this.layoutNode = arg2;
        this.measurePolicyState$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    private final MeasurePolicy getMeasurePolicyState() {
        return this.measurePolicyState$delegate.getValue();
    }

    public final int maxIntrinsicHeight(int arg3) {
        return this.getMeasurePolicyState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildMeasurables$ui(), arg3);
    }

    public final int maxIntrinsicWidth(int arg3) {
        return this.getMeasurePolicyState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildMeasurables$ui(), arg3);
    }

    public final int maxLookaheadIntrinsicHeight(int arg3) {
        return this.getMeasurePolicyState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildLookaheadMeasurables$ui(), arg3);
    }

    public final int maxLookaheadIntrinsicWidth(int arg3) {
        return this.getMeasurePolicyState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildLookaheadMeasurables$ui(), arg3);
    }

    public final int minIntrinsicHeight(int arg3) {
        return this.getMeasurePolicyState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildMeasurables$ui(), arg3);
    }

    public final int minIntrinsicWidth(int arg3) {
        return this.getMeasurePolicyState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildMeasurables$ui(), arg3);
    }

    public final int minLookaheadIntrinsicHeight(int arg3) {
        return this.getMeasurePolicyState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildLookaheadMeasurables$ui(), arg3);
    }

    public final int minLookaheadIntrinsicWidth(int arg3) {
        return this.getMeasurePolicyState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui(), this.layoutNode.getChildLookaheadMeasurables$ui(), arg3);
    }

    private final void setMeasurePolicyState(MeasurePolicy arg1) {
        this.measurePolicyState$delegate.setValue(arg1);
    }

    public final void updateFrom(MeasurePolicy arg1) {
        this.setMeasurePolicyState(arg1);
    }
}

