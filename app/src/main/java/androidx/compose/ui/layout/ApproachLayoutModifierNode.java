package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001A\u00020\u0003*\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J#\u0010\f\u001A\u00020\r*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001A\u00020\r*\u00020\u00162\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001C\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\u001C\u0010\u001E\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001AH\u0016J\u001C\u0010 \u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\u001C\u0010!\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001AH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minApproachIntrinsicWidth", "", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minApproachIntrinsicHeight", "width", "maxApproachIntrinsicWidth", "maxApproachIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ApproachLayoutModifierNode extends LayoutModifierNode {
    MeasureResult approachMeasure-3p2s80s(ApproachMeasureScope arg1, Measurable arg2, long arg3);

    boolean isMeasurementApproachInProgress-ozmzZPI(long arg1);

    default boolean isPlacementApproachInProgress(PlacementScope arg1, LayoutCoordinates arg2) {
        return 0;
    }

    default int maxApproachIntrinsicHeight(ApproachIntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        NodeCoordinator v0 = this.getNode().getCoordinator$ui();
        Intrinsics.checkNotNull(v0);
        LookaheadDelegate v0_1 = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0_1);
        if(v0_1.getHasMeasureResult()) {
            return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui(new ApproachLayoutModifierNode$maxApproachIntrinsicHeight$1(this), arg3, arg4, arg5);
        }

        return arg4.maxIntrinsicHeight(arg5);
    }

    default int maxApproachIntrinsicWidth(ApproachIntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        NodeCoordinator v0 = this.getNode().getCoordinator$ui();
        Intrinsics.checkNotNull(v0);
        LookaheadDelegate v0_1 = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0_1);
        if(v0_1.getHasMeasureResult()) {
            return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui(new ApproachLayoutModifierNode$maxApproachIntrinsicWidth$1(this), arg3, arg4, arg5);
        }

        return arg4.maxIntrinsicWidth(arg5);
    }

    default MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v7 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v7.getWidth(), v7.getHeight(), null, new ApproachLayoutModifierNode$measure$1$1(v7), 4, null);
    }

    default int minApproachIntrinsicHeight(ApproachIntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        NodeCoordinator v0 = this.getNode().getCoordinator$ui();
        Intrinsics.checkNotNull(v0);
        LookaheadDelegate v0_1 = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0_1);
        if(v0_1.getHasMeasureResult()) {
            return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui(new ApproachLayoutModifierNode$minApproachIntrinsicHeight$1(this), arg3, arg4, arg5);
        }

        return arg4.minIntrinsicHeight(arg5);
    }

    default int minApproachIntrinsicWidth(ApproachIntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        NodeCoordinator v0 = this.getNode().getCoordinator$ui();
        Intrinsics.checkNotNull(v0);
        LookaheadDelegate v0_1 = v0.getLookaheadDelegate();
        Intrinsics.checkNotNull(v0_1);
        if(v0_1.getHasMeasureResult()) {
            return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui(new ApproachLayoutModifierNode$minApproachIntrinsicWidth$1(this), arg3, arg4, arg5);
        }

        return arg4.minIntrinsicWidth(arg5);
    }
}

