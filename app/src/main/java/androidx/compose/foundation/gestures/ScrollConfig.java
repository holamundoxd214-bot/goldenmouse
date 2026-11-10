package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J#\u0010\b\u001A\u00020\t*\u00020\n2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH&¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/ScrollConfig;", "", "isSmoothScrollingEnabled", "", "()Z", "isPreciseWheelScroll", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ScrollConfig {
    long calculateMouseWheelScroll-8xgXZGE(Density arg1, PointerEvent arg2, long arg3);

    default boolean isPreciseWheelScroll(PointerEvent arg1) {
        return 0;
    }

    default boolean isSmoothScrollingEnabled() {
        return 1;
    }
}

