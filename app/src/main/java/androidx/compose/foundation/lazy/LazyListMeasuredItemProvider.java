package androidx.compose.foundation.lazy;

import androidx.collection.IntList;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ/\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0003\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0012\u001A\u00020\u0013J?\u0010$\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010&2\f\u0010(\u001A\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\u0003\u001A\u00020\u0004H&¢\u0006\u0004\b+\u0010,R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u001C\u001A\u00020\u001D8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010 \u001A\u00020!8F¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006-"}, d2={"Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "<init>", "(JZLandroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "getAndMeasure", "index", "", "lane", "span", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getAndMeasure-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "keepAround", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "createItem", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-X9ElhV4", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyListMeasuredItemProvider extends LazyLayoutMeasuredItemProvider {
    public static final int $stable = 8;
    private final long childConstraints;
    private final LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    static {
    }

    private LazyListMeasuredItemProvider(long arg7, boolean arg9, LazyListItemProvider arg10, LazyLayoutMeasureScope arg11) {
        super();
        this.itemProvider = arg10;
        this.measureScope = arg11;
        int v10 = 0x7FFFFFFF;
        int v1 = arg9 ? Constraints.getMaxWidth-impl(arg7) : v10;
        if(!arg9) {
            v10 = Constraints.getMaxHeight-impl(arg7);
        }

        this.childConstraints = ConstraintsKt.Constraints$default(0, v1, 0, v10, 5, null);
    }

    public LazyListMeasuredItemProvider(long arg1, boolean arg3, LazyListItemProvider arg4, LazyLayoutMeasureScope arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg4, arg5);
    }

    public abstract LazyListMeasuredItem createItem-X9ElhV4(int arg1, Object arg2, Object arg3, List arg4, long arg5);

    public LazyListMeasuredItem getAndMeasure--hBUhpc(int arg1, int arg2, int arg3, long arg4) {
        return this.getAndMeasure-0kLqBqw(arg1, arg4);
    }

    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int arg1, int arg2, int arg3, long arg4) {
        return this.getAndMeasure--hBUhpc(arg1, arg2, arg3, arg4);
    }

    public final LazyListMeasuredItem getAndMeasure-0kLqBqw(int arg9, long arg10) {
        return this.createItem-X9ElhV4(arg9, this.itemProvider.getKey(arg9), this.itemProvider.getContentType(arg9), this.getPlaceables-3p2s80s(this.measureScope, arg9, arg10), arg10);
    }

    public static LazyListMeasuredItem getAndMeasure-0kLqBqw$default(LazyListMeasuredItemProvider arg0, int arg1, long arg2, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = arg0.childConstraints;
            }

            return arg0.getAndMeasure-0kLqBqw(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
    }

    public final long getChildConstraints-msEJaDk() {
        return this.childConstraints;
    }

    public final IntList getHeaderIndexes() {
        return this.itemProvider.getHeaderIndexes();
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }

    public final void keepAround(int arg1) {
        this.measureScope.compose(arg1);
    }
}

