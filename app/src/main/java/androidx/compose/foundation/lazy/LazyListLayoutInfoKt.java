package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0004\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"visibleItemsAverageSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateContentSize", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListLayoutInfoKt {
    public static final int calculateContentSize(LazyListLayoutInfo arg3) {
        int v0 = arg3.getBeforeContentPadding() + arg3.getAfterContentPadding();
        if(arg3.getTotalItemsCount() == 0) {
            return v0;
        }

        return (LazyListLayoutInfoKt.visibleItemsAverageSize(arg3) - arg3.getMainAxisItemSpacing()) * arg3.getTotalItemsCount() + (arg3.getTotalItemsCount() - 1) * arg3.getMainAxisItemSpacing() + v0;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }

    public static final int visibleItemsAverageSize(LazyListLayoutInfo arg5) {
        List v0 = arg5.getVisibleItemsInfo();
        int v2 = 0;
        if(v0.isEmpty()) {
            return 0;
        }

        int v1 = v0.size();
        int v3 = 0;
        while(v2 < v1) {
            v3 += v0.get(v2).getSize();
            ++v2;
        }

        return v3 / v0.size() + arg5.getMainAxisItemSpacing();
    }
}

