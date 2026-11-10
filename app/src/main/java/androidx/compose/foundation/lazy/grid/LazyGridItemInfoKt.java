package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000¨\u0006\u0005"}, d2={"lineIndex", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridItemInfoKt {
    public static final int lineIndex(LazyGridItemInfo arg1, Orientation arg2) {
        if(arg2 == Orientation.Vertical) {
            return arg1.getRow();
        }

        return arg1.getColumn();
    }
}

