package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0017\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A \u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0012H\u0000\u001A\u0018\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0012H\u0000\"\u0016\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001A\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001A\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001A\u0004\b\u0006\u0010\u0003\"\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0019"}, d2={"HandleWidth", "Landroidx/compose/ui/unit/Dp;", "getHandleWidth", "()F", "F", "HandleHeight", "getHandleHeight", "SelectionHandleInfoKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "getSelectionHandleInfoKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getAdjustedCoordinates", "Landroidx/compose/ui/geometry/Offset;", "position", "getAdjustedCoordinates-k-4lQ0M", "(J)J", "isLeftSelectionHandle", "", "isStartHandle", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "isHandleLtrDirection", "areHandlesCrossed", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionHandlesKt {
    private static final float HandleHeight;
    private static final float HandleWidth;
    private static final SemanticsPropertyKey SelectionHandleInfoKey;

    static {
        SelectionHandlesKt.HandleWidth = Dp.constructor-impl(25f);
        SelectionHandlesKt.HandleHeight = Dp.constructor-impl(25f);
        SelectionHandlesKt.SelectionHandleInfoKey = new SemanticsPropertyKey("SelectionHandleInfo", null, 2, null);
    }

    public static final long getAdjustedCoordinates-k-4lQ0M(long arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) - 1f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20)))))) << 0x20);
    }

    public static final float getHandleHeight() {
        return SelectionHandlesKt.HandleHeight;
    }

    public static final float getHandleWidth() {
        return SelectionHandlesKt.HandleWidth;
    }

    public static final SemanticsPropertyKey getSelectionHandleInfoKey() {
        return SelectionHandlesKt.SelectionHandleInfoKey;
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection arg1, boolean arg2) {
        if(arg1 == ResolvedTextDirection.Ltr && !arg2 || arg1 == ResolvedTextDirection.Rtl && (arg2)) {
            return 1;
        }

        return 0;
    }

    public static final boolean isLeftSelectionHandle(boolean arg0, ResolvedTextDirection arg1, boolean arg2) {
        if(arg0) {
            return SelectionHandlesKt.isHandleLtrDirection(arg1, arg2);
        }

        if(!SelectionHandlesKt.isHandleLtrDirection(arg1, arg2)) {
            return 1;
        }

        return 0;
    }
}

