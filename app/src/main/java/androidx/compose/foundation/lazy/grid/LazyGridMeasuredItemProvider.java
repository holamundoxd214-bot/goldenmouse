package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J_\u0010\u001E\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010 2\u0006\u0010\"\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\b2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH&¢\u0006\u0004\b&\u0010\'R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006("}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "defaultMainAxisSpacing", "", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;I)V", "getAndMeasure", "index", "lane", "span", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSpacing", "getAndMeasure-m8Kt_7k", "(IJIII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "headerIndices", "Landroidx/collection/IntList;", "getHeaderIndices", "()Landroidx/collection/IntList;", "createItem", "key", "", "contentType", "crossAxisSize", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-O3s9Psw", "(ILjava/lang/Object;Ljava/lang/Object;IILjava/util/List;JII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyGridMeasuredItemProvider extends LazyLayoutMeasuredItemProvider {
    public static final int $stable = 8;
    private final int defaultMainAxisSpacing;
    private final LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    static {
    }

    public LazyGridMeasuredItemProvider(LazyGridItemProvider arg1, LazyLayoutMeasureScope arg2, int arg3) {
        super();
        this.itemProvider = arg1;
        this.measureScope = arg2;
        this.defaultMainAxisSpacing = arg3;
    }

    public abstract LazyGridMeasuredItem createItem-O3s9Psw(int arg1, Object arg2, Object arg3, int arg4, int arg5, List arg6, long arg7, int arg8, int arg9);

    public LazyGridMeasuredItem getAndMeasure--hBUhpc(int arg8, int arg9, int arg10, long arg11) {
        return this.getAndMeasure-m8Kt_7k(arg8, arg11, arg9, arg10, this.defaultMainAxisSpacing);
    }

    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int arg1, int arg2, int arg3, long arg4) {
        return this.getAndMeasure--hBUhpc(arg1, arg2, arg3, arg4);
    }

    public final LazyGridMeasuredItem getAndMeasure-m8Kt_7k(int arg12, long arg13, int arg15, int arg16, int arg17) {
        int v4;
        Object v2 = this.itemProvider.getKey(arg12);
        Object v3 = this.itemProvider.getContentType(arg12);
        List v6 = this.getPlaceables-3p2s80s(this.measureScope, arg12, arg13);
        if(Constraints.getHasFixedWidth-impl(arg13)) {
            v4 = Constraints.getMinWidth-impl(arg13);
        }
        else {
            if(!Constraints.getHasFixedHeight-impl(arg13)) {
                InlineClassHelperKt.throwIllegalArgumentException("does not have fixed height");
            }

            v4 = Constraints.getMinHeight-impl(arg13);
        }

        LazyGridMeasuredItemProvider v0 = this;
        int v1 = arg12;
        long v7 = arg13;
        int v9 = arg15;
        int v10 = arg16;
        int v5 = arg17;
        return v0.createItem-O3s9Psw(v1, v2, v3, v4, v5, v6, v7, v9, v10);
    }

    public final IntList getHeaderIndices() {
        return this.itemProvider.getHeaderIndexes();
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}

