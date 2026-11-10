package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0016\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\f\u0010\u000B\u001A\u00020\u0004*\u00020\u0002H\u0000\u001A\u0014\u0010\f\u001A\u00020\u0004*\u00020\u00022\u0006\u0010\r\u001A\u00020\u0004H\u0000\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001A\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n\"\u0018\u0010\u000E\u001A\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "EmptyArray", "", "EmptyLazyStaggeredGridLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "getEmptyLazyStaggeredGridLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "visibleItemsAverageSize", "calculateContentSize", "laneCount", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasureResultKt {
    private static final int[] EmptyArray;
    private static final LazyStaggeredGridMeasureResult EmptyLazyStaggeredGridLayoutInfo;

    static {
        int[] v2 = new int[0];
        LazyStaggeredGridMeasureResultKt.EmptyArray = v2;
        LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo = new LazyStaggeredGridMeasureResult(v2, v2, 0f, new LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1(), 0f, false, false, false, new LazyStaggeredGridSlots(v2, v2), new LazyStaggeredGridSpanProvider(new MutableIntervalList()), DensityKt.Density$default(1f, 0f, 2, null), 0, CollectionsKt.emptyList(), IntSize.Companion.getZero-YbymL2g(), 0, 0, 0, 0, 0, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), null);
    }

    public static final int calculateContentSize(LazyStaggeredGridLayoutInfo arg3, int arg4) {
        int v0 = arg3.getBeforeContentPadding() + arg3.getAfterContentPadding();
        if(arg3.getTotalItemsCount() != 0) {
            if(arg4 <= 0) {
            }
            else {
                return LazyStaggeredGridMeasureResultKt.visibleItemsAverageSize(arg3) * arg3.getTotalItemsCount() / arg4 - arg3.getMainAxisItemSpacing() + v0;
            }
        }

        return v0;
    }

    public static final LazyStaggeredGridItemInfo findVisibleItem(LazyStaggeredGridLayoutInfo arg9, int arg10) {
        LazyStaggeredGridItemInfo v1 = null;
        if(arg9.getVisibleItemsInfo().isEmpty()) {
            return v1;
        }

        int v0 = CollectionsKt.first(arg9.getVisibleItemsInfo()).getIndex();
        if(arg10 <= CollectionsKt.last(arg9.getVisibleItemsInfo()).getIndex() && v0 <= arg10) {
            return CollectionsKt.getOrNull(arg9.getVisibleItemsInfo(), CollectionsKt.binarySearch$default(arg9.getVisibleItemsInfo(), 0, 0, new LazyStaggeredGridMeasureResultKt$$ExternalSyntheticLambda0(arg10), 3, null));
        }

        return v1;
    }

    static final int findVisibleItem$lambda$0(int arg0, LazyStaggeredGridItemInfo arg1) {
        return arg1.getIndex() - arg0;
    }

    public static final LazyStaggeredGridMeasureResult getEmptyLazyStaggeredGridLayoutInfo() {
        return LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo;
    }

    public static final int getSingleAxisViewportSize(LazyStaggeredGridLayoutInfo arg4) {
        long v0 = arg4.getOrientation() == Orientation.Vertical ? arg4.getViewportSize-YbymL2g() & 0xFFFFFFFFL : arg4.getViewportSize-YbymL2g() >> 0x20;
        return ((int)v0);
    }

    public static final int visibleItemsAverageSize(LazyStaggeredGridLayoutInfo arg8) {
        List v0 = arg8.getVisibleItemsInfo();
        int v2 = 0;
        if(v0.isEmpty()) {
            return 0;
        }

        int v1 = v0.size();
        int v3 = 0;
        while(v2 < v1) {
            Object v4 = v0.get(v2);
            long v4_1 = arg8.getOrientation() == Orientation.Vertical ? ((LazyStaggeredGridItemInfo)v4).getSize-YbymL2g() & 0xFFFFFFFFL : ((LazyStaggeredGridItemInfo)v4).getSize-YbymL2g() >> 0x20;
            v3 += ((int)v4_1);
            ++v2;
        }

        return v3 / v0.size() + arg8.getMainAxisItemSpacing();
    }
}

