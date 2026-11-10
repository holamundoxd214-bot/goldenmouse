package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0006\u0010\u001A\u001A\u00020\rJ)\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u0003¢\u0006\u0002\u0010\u001FR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0012¨\u0006 "}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "", "index", "", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "isVertical", "", "mainAxisSpacing", "<init>", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Landroidx/compose/foundation/lazy/grid/LazyGridSlots;Ljava/util/List;ZI)V", "getIndex", "()I", "getItems", "()[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "isEmpty", "position", "offset", "layoutWidth", "layoutHeight", "(III)[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridMeasuredLine {
    public static final int $stable = 8;
    private final int index;
    private final boolean isVertical;
    private final LazyGridMeasuredItem[] items;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final LazyGridSlots slots;
    private final List spans;

    static {
    }

    public LazyGridMeasuredLine(int arg1, LazyGridMeasuredItem[] arg2, LazyGridSlots arg3, List arg4, boolean arg5, int arg6) {
        super();
        this.index = arg1;
        this.items = arg2;
        this.slots = arg3;
        this.spans = arg4;
        this.isVertical = arg5;
        this.mainAxisSpacing = arg6;
        arg1 = arg2.length;
        int v4 = 0;
        int v5 = 0;
        while(v4 < arg1) {
            v5 = Math.max(v5, arg2[v4].getMainAxisSize());
            ++v4;
        }

        this.mainAxisSize = v5;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(v5 + this.mainAxisSpacing, 0);
    }

    public final int getIndex() {
        return this.index;
    }

    public final LazyGridMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        if(this.items.length == 0) {
            return 1;
        }

        return 0;
    }

    public final LazyGridMeasuredItem[] position(int arg14, int arg15, int arg16) {
        int v9;
        int v8;
        int v6_1;
        int v11;
        LazyGridMeasuredItem[] v0 = this.items;
        int v1 = v0.length;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v2 < v1) {
            LazyGridMeasuredItem v5 = v0[v2];
            int v12 = v3 + 1;
            v3 = GridItemSpan.getCurrentLineSpan-impl(this.spans.get(v3).unbox-impl());
            int v7 = this.slots.getPositions()[v4];
            boolean v6 = this.isVertical;
            int v10 = v6 ? this.index : v4;
            if(v6) {
                v11 = v4;
                v6_1 = arg14;
                v8 = arg15;
                v9 = arg16;
            }
            else {
                v11 = this.index;
                v8 = arg15;
                v9 = arg16;
                v6_1 = arg14;
            }

            v5.position(v6_1, v7, v8, v9, v10, v11);
            v4 += v3;
            ++v2;
            v3 = v12;
        }

        return this.items;
    }
}

