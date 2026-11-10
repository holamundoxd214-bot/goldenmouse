package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\b\u001A\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0003\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\"\u0018\u0010\u0006\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2={"visibleLinesAverageMainAxisSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "firstVisibleItemLineIndex", "getFirstVisibleItemLineIndex", "calculateContentSize", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridLayoutInfoKt {
    public static final int calculateContentSize(LazyGridLayoutInfo arg4) {
        int v0 = arg4.getBeforeContentPadding() + arg4.getAfterContentPadding();
        if(arg4.getTotalItemsCount() == 0) {
            return v0;
        }

        int v1 = ((int)(((float)Math.ceil(((double)((((float)arg4.getTotalItemsCount())) / (((float)arg4.getMaxSpan()))))))));
        return (LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize(arg4) - arg4.getMainAxisItemSpacing()) * v1 + (v1 - 1) * arg4.getMainAxisItemSpacing() + v0;
    }

    public static final int getFirstVisibleItemLineIndex(LazyGridLayoutInfo arg2) {
        List v0 = arg2.getVisibleItemsInfo();
        if(v0.isEmpty()) {
            return 0;
        }

        if(arg2.getOrientation() == Orientation.Vertical) {
            return CollectionsKt.first(v0).getRow();
        }

        return CollectionsKt.first(v0).getColumn();
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }

    public static final int visibleLinesAverageMainAxisSize(LazyGridLayoutInfo arg12) {
        boolean v0 = arg12.getOrientation() == Orientation.Vertical ? true : false;
        List v1 = arg12.getVisibleItemsInfo();
        if(v1.isEmpty()) {
            return 0;
        }

        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(true) {
        label_14:
            if(v3 >= v1.size()) {
                goto label_43;
            }

            int v6 = LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize$lineOf(v0, arg12, v3);
            if(v6 != -1) {
                break;
            }

            ++v3;
        }

        int v7 = 0;
        goto label_22;
    label_43:
        return v4 / v5 + arg12.getMainAxisItemSpacing();
    label_22:
        while(v3 < v1.size()) {
            if(LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize$lineOf(v0, arg12, v3) != v6) {
                break;
            }

            long v8 = v0 ? v1.get(v3).getSize-YbymL2g() & 0xFFFFFFFFL : v1.get(v3).getSize-YbymL2g() >> 0x20;
            v7 = Math.max(v7, ((int)v8));
            ++v3;
        }

        v4 += v7;
        ++v5;
        goto label_14;
    }

    private static final int visibleLinesAverageMainAxisSize$lineOf(boolean arg0, LazyGridLayoutInfo arg1, int arg2) {
        if(arg0) {
            return arg1.getVisibleItemsInfo().get(arg2).getRow();
        }

        return arg1.getVisibleItemsInfo().get(arg2).getColumn();
    }
}

