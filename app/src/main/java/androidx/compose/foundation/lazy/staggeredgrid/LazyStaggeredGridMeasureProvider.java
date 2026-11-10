package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJO\u0010!\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010#2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\'0&2\u0006\u0010\u001A\u001A\u00020\u000EH&¢\u0006\u0004\b(\u0010)R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001D\u001A\u00020\u001E8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006*"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "<init>", "(ZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "span", "childConstraints-JhjzzOo", "(II)J", "getAndMeasure", "index", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "lane", "constraints", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-pitSLOA", "(IIILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyStaggeredGridMeasureProvider extends LazyLayoutMeasuredItemProvider {
    public static final int $stable = 8;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridSlots resolvedSlots;

    static {
    }

    public LazyStaggeredGridMeasureProvider(boolean arg1, LazyStaggeredGridItemProvider arg2, LazyLayoutMeasureScope arg3, LazyStaggeredGridSlots arg4) {
        super();
        this.isVertical = arg1;
        this.itemProvider = arg2;
        this.measureScope = arg3;
        this.resolvedSlots = arg4;
    }

    private final long childConstraints-JhjzzOo(int arg3, int arg4) {
        LazyStaggeredGridSlots v0 = this.resolvedSlots;
        if(arg4 == 1) {
            arg3 = v0.getSizes()[arg3];
        }
        else {
            int v0_1 = v0.getPositions()[arg3];
            arg3 = arg3 + arg4 - 1;
            arg3 = this.resolvedSlots.getPositions()[arg3] + this.resolvedSlots.getSizes()[arg3] - v0_1;
        }

        if(this.isVertical) {
            return Constraints.Companion.fixedWidth-OenEA2s(arg3);
        }

        return Constraints.Companion.fixedHeight-OenEA2s(arg3);
    }

    public abstract LazyStaggeredGridMeasuredItem createItem-pitSLOA(int arg1, int arg2, int arg3, Object arg4, Object arg5, List arg6, long arg7);

    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int arg1, int arg2, int arg3, long arg4) {
        return this.getAndMeasure--hBUhpc(arg1, arg2, arg3, arg4);
    }

    public LazyStaggeredGridMeasuredItem getAndMeasure--hBUhpc(int arg11, int arg12, int arg13, long arg14) {
        return this.createItem-pitSLOA(arg11, arg12, arg13, this.itemProvider.getKey(arg11), this.itemProvider.getContentType(arg11), this.getPlaceables-3p2s80s(this.measureScope, arg11, arg14), arg14);
    }

    public final LazyStaggeredGridMeasuredItem getAndMeasure-jy6DScQ(int arg11, long arg12) {
        Object v5 = this.itemProvider.getKey(arg11);
        Object v6 = this.itemProvider.getContentType(arg11);
        int v0 = this.resolvedSlots.getSizes().length;
        int v1 = ((int)(arg12 >> 0x20));
        int v3 = RangesKt.coerceAtMost(v1, v0 - 1);
        int v4 = RangesKt.coerceAtMost((((int)(arg12 & 0xFFFFFFFFL))) - v1, v0 - v3);
        long v8 = this.childConstraints-JhjzzOo(v3, v4);
        return this.createItem-pitSLOA(arg11, v3, v4, v5, v6, this.getPlaceables-3p2s80s(this.measureScope, arg11, v8), v8);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}

