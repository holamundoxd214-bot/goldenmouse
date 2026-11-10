package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0003H&J/\u0010\b\u001A\u00020\t*\u00020\u00032\u0006\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0004\u001A\u00020\u0003*\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/LookaheadScope;", "", "toLookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LookaheadScope {
    LayoutCoordinates getLookaheadScopeCoordinates(PlacementScope arg1);

    default long localLookaheadPositionOf-au-aQtc(LayoutCoordinates arg1, LayoutCoordinates arg2, long arg3, boolean arg5) {
        return LookaheadScopeKt.localLookaheadPositionOf-Fgt4K4Q(this, arg1, arg2, arg3, arg5);
    }

    static long localLookaheadPositionOf-au-aQtc$default(LookaheadScope arg6, LayoutCoordinates arg7, LayoutCoordinates arg8, long arg9, boolean arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 2) != 0) {
                arg9 = Offset.Companion.getZero-F1C5BW0();
            }

            return arg6.localLookaheadPositionOf-au-aQtc(arg7, arg8, arg9, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localLookaheadPositionOf-au-aQtc");
    }

    LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates arg1);
}

