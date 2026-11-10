package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000E\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0007J\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0007J\u000E\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0007J9\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0016\u001A\u00020\u00072\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001A\u00020\u0007H&¢\u0006\u0002\u0010\'R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001B\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006("}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "<init>", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation", "(II)J", "spanOf", "index", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lineIndex", "keepAround", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createLine", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyGridMeasuredLineProvider {
    public static final int $stable = 8;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    static {
    }

    public LazyGridMeasuredLineProvider(boolean arg1, LazyGridSlots arg2, int arg3, int arg4, LazyGridMeasuredItemProvider arg5, LazyGridSpanLayoutProvider arg6) {
        super();
        this.isVertical = arg1;
        this.slots = arg2;
        this.gridItemsCount = arg3;
        this.spaceBetweenLines = arg4;
        this.measuredItemProvider = arg5;
        this.spanLayoutProvider = arg6;
    }

    public final long childConstraints-JhjzzOo$foundation(int arg3, int arg4) {
        LazyGridSlots v0 = this.slots;
        if(arg4 == 1) {
            arg3 = v0.getSizes()[arg3];
        }
        else {
            arg4 = arg4 + arg3 - 1;
            arg3 = v0.getPositions()[arg4] + this.slots.getSizes()[arg4] - this.slots.getPositions()[arg3];
        }

        arg3 = RangesKt.coerceAtLeast(arg3, 0);
        if(this.isVertical) {
            return Constraints.Companion.fixedWidth-OenEA2s(arg3);
        }

        return Constraints.Companion.fixedHeight-OenEA2s(arg3);
    }

    public abstract LazyGridMeasuredLine createLine(int arg1, LazyGridMeasuredItem[] arg2, List arg3, int arg4);

    public final LazyGridMeasuredLine getAndMeasure(int arg12) {
        LineConfiguration v0 = this.spanLayoutProvider.getLineConfiguration(arg12);
        int v1 = v0.getSpans().size();
        int v2 = 0;
        int v10 = v1 == 0 || v0.getFirstItemIndex() + v1 == this.gridItemsCount ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] v3 = new LazyGridMeasuredItem[v1];
        int v8 = 0;
        while(v2 < v1) {
            int v9 = GridItemSpan.getCurrentLineSpan-impl(v0.getSpans().get(v2).unbox-impl());
            LazyGridMeasuredItem v4 = this.measuredItemProvider.getAndMeasure-m8Kt_7k(v0.getFirstItemIndex() + v2, this.childConstraints-JhjzzOo$foundation(v8, v9), v8, v9, v10);
            v8 += v9;
            v3[v2] = v4;
            ++v2;
        }

        return this.createLine(arg12, v3, v0.getSpans(), v10);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }

    public final LazyGridMeasuredLine keepAround(int arg1) {
        return this.getAndMeasure(arg1);
    }

    public final int spanOf(int arg2) {
        return this.spanLayoutProvider.spanOf(arg2, this.spanLayoutProvider.getSlotsPerLine());
    }
}

