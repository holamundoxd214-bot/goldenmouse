package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="MeasureBlocks was deprecated. Please use MeasurePolicy instead.") @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\ba\u0018\u00002\u00020\u0001J-\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\nH&¢\u0006\u0004\b\u000B\u0010\fJ&\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0012\u001A\u00020\u000EH&J&\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0014\u001A\u00020\u000EH&J&\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0012\u001A\u00020\u000EH&J&\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0014\u001A\u00020\u000EH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/MeasureBlocks;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "h", "minIntrinsicHeight", "w", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MeasureBlocks {
    int maxIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3);

    int maxIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3);

    MeasureResult measure-3p2s80s(MeasureScope arg1, List arg2, long arg3);

    int minIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3);

    int minIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3);
}

