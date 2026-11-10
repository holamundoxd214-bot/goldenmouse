package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H&J\f\u0010\u0005\u001A\u00020\u0003*\u00020\u0004H&J(\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rH&Jg\u0010\u000E\u001A\u00020\u000F2\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u00032\b\u0010\u0014\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0003H&¢\u0006\u0002\u0010\u0018J9\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020 H&¢\u0006\u0004\b!\u0010\"ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface RowColumnMeasurePolicy {
    long createConstraints-xF2OJ5Q(int arg1, int arg2, int arg3, int arg4, boolean arg5);

    static long createConstraints-xF2OJ5Q$default(RowColumnMeasurePolicy arg6, int arg7, int arg8, int arg9, int arg10, boolean arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            return arg6.createConstraints-xF2OJ5Q(arg7, arg8, arg9, arg10, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConstraints-xF2OJ5Q");
    }

    int crossAxisSize(Placeable arg1);

    int mainAxisSize(Placeable arg1);

    MeasureResult placeHelper(Placeable[] arg1, MeasureScope arg2, int arg3, int[] arg4, int arg5, int arg6, int[] arg7, int arg8, int arg9, int arg10);

    void populateMainAxisPositions(int arg1, int[] arg2, int[] arg3, MeasureScope arg4);
}

