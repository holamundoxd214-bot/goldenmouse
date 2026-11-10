package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001C\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u001C\u0010\u0010\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u001C\u0010\u0012\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u001C\u0010\u0013\u001A\u00020\f*\u00020\r2\u0006\u0010\u0005\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LayoutModifierNode extends DelegatableNode {
    default int maxIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui(new LayoutModifierNode$maxIntrinsicHeight$1(this), arg3, arg4, arg5);
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui(new LayoutModifierNode$maxIntrinsicWidth$1(this), arg3, arg4, arg5);
    }

    MeasureResult measure-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3);

    default int minIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui(new LayoutModifierNode$minIntrinsicHeight$1(this), arg3, arg4, arg5);
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui(new LayoutModifierNode$minIntrinsicWidth$1(this), arg3, arg4, arg5);
    }
}

