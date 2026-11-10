package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010&\u001A\b\u0012\u0004\u0012\u00020(0\'2\u0006\u0010)\u001A\u00020\u00112\u0018\u0010*\u001A\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001A\u00020\u00112\u0006\u00100\u001A\u00020\u0011H\u0016J\u0010\u00101\u001A\u0002022\u0006\u00100\u001A\u00020\u0011H\u0016J\u0010\u00103\u001A\u00020\u00112\u0006\u00100\u001A\u00020\u0011H\u0016J\u0010\u00107\u001A\u00020\u00112\u0006\u0010)\u001A\u00020\u0011H\u0016J\b\u00108\u001A\u00020\u0011H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001A\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0013R\u0014\u0010\u001C\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0013R\u0014\u0010\u001E\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0013R\u0014\u0010 \u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0013R\u0016\u0010\"\u001A\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%R\u0014\u0010-\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010\u0013R\u0015\u0010)\u001A\u00020\u0011*\u0002048F¢\u0006\u0006\u001A\u0004\b5\u00106¨\u00069"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "<init>", "()V", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "setLayoutInfo", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)V", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "getPrefetchScope", "()Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "setPrefetchScope", "(Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;)V", "totalItemsCount", "", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleLineKey", "", "getVisibleItemLine", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "getLineIndex", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;)I", "getLastIndexInLine", "getLastLineIndex", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyGridCacheWindowScope implements CacheWindowScope {
    public LazyGridLayoutInfo layoutInfo;
    public LazyGridPrefetchScope prefetchScope;

    public LazyGridCacheWindowScope() {
        super();
    }

    public Density getDensity() {
        LazyGridLayoutInfo v2 = this.getLayoutInfo();
        Density v1 = null;
        if((v2 instanceof LazyGridMeasureResult)) {
        }
        else {
            v2 = ((LazyGridLayoutInfo)v1);
        }

        if(v2 != null) {
            return ((LazyGridMeasureResult)v2).getDensity();
        }

        return v1;
    }

    public int getFirstVisibleLineIndex() {
        return this.getLineIndex(CollectionsKt.first(this.getLayoutInfo().getVisibleItemsInfo()));
    }

    public boolean getHasVisibleItems() {
        return this.getLayoutInfo().getVisibleItemsInfo().isEmpty() ^ 1;
    }

    public int getLastIndexInLine(int arg2) {
        LazyGridLayoutInfo v1 = this.getLayoutInfo();
        if((v1 instanceof LazyGridMeasureResult)) {
        }
        else {
            v1 = null;
        }

        int v0 = -1;
        if(v1 == null) {
            return v0;
        }

        Object v1_1 = ((LazyGridMeasureResult)v1).getPrefetchInfoRetriever().invoke(Integer.valueOf(arg2));
        if(((List)v1_1).isEmpty()) {
            return v0;
        }

        return CollectionsKt.first(((List)v1_1)).getFirst().intValue() + ((List)v1_1).size() - 1;
    }

    public int getLastLineIndex() {
        LazyGridLayoutInfo v0 = this.getLayoutInfo();
        if((v0 instanceof LazyGridMeasureResult)) {
        }
        else {
            v0 = null;
        }

        int v1 = -1;
        if(v0 == null) {
            return v1;
        }

        if(this.getTotalItemsCount() == 0) {
            return v1;
        }

        return ((LazyGridMeasureResult)v0).getLineIndexProvider().invoke(Integer.valueOf(this.getTotalItemsCount() - 1)).intValue();
    }

    public int getLastVisibleLineIndex() {
        return this.getLineIndex(CollectionsKt.last(this.getLayoutInfo().getVisibleItemsInfo()));
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        LazyGridLayoutInfo v0 = this.layoutInfo;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public final int getLineIndex(LazyGridItemInfo arg1) {
        return LazyGridItemInfoKt.lineIndex(arg1, this.getLayoutInfo().getOrientation());
    }

    public int getMainAxisExtraSpaceEnd() {
        Object v0 = CollectionsKt.last(this.getLayoutInfo().getVisibleItemsInfo());
        return Math.abs(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(((LazyGridItemInfo)v0), this.getLayoutInfo().getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(((LazyGridItemInfo)v0), this.getLayoutInfo().getOrientation()) + this.getLayoutInfo().getMainAxisItemSpacing() - this.getLayoutInfo().getViewportEndOffset());
    }

    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(CollectionsKt.first(this.getLayoutInfo().getVisibleItemsInfo()), this.getLayoutInfo().getOrientation()) + this.getLayoutInfo().getBeforeContentPadding(), 0));
    }

    public int getMainAxisViewportSize() {
        return LazyGridLayoutInfoKt.getSingleAxisViewportSize(this.getLayoutInfo());
    }

    public final LazyGridPrefetchScope getPrefetchScope() {
        LazyGridPrefetchScope v0 = this.prefetchScope;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("prefetchScope");
        return null;
    }

    public int getTotalItemsCount() {
        return this.getLayoutInfo().getTotalItemsCount();
    }

    public int getVisibleItemLine(int arg1) {
        return this.getFirstVisibleLineIndex() + arg1;
    }

    public int getVisibleItemSize(int arg8) {
        arg8 += this.getFirstVisibleLineIndex();
        List v0 = this.getLayoutInfo().getVisibleItemsInfo();
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v3 = 0;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0.get(v4);
            if(this.getLineIndex(v5) == arg8) {
                v1.add(v5);
            }
        }

        arg8 = v1.size();
        int v0_1 = 0;
        while(v3 < arg8) {
            v0_1 = Math.max(LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(((List)v1).get(v3), this.getLayoutInfo().getOrientation()), v0_1);
            ++v3;
        }

        return v0_1;
    }

    public int getVisibleLineCount() {
        return this.getLastVisibleLineIndex() - this.getFirstVisibleLineIndex() + 1;
    }

    public Object getVisibleLineKey(int arg7) {
        arg7 += this.getFirstVisibleLineIndex();
        List v0 = this.getLayoutInfo().getVisibleItemsInfo();
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = v0.get(v3);
            if(this.getLineIndex(v4) == arg7) {
                v1.add(v4);
            }
        }

        Object v6 = CollectionsKt.firstOrNull(((List)v1));
        if(v6 != null) {
            v6 = ((LazyGridItemInfo)v6).getKey();
            if(v6 != null) {
                return v6;
            }
        }

        return CachedItem.NoKey;
    }

    public List schedulePrefetch(int arg2, Function2 arg3) {
        return this.getPrefetchScope().scheduleLinePrefetch(arg2, new LazyGridCacheWindowScope$$ExternalSyntheticLambda0(arg3, arg2));
    }

    static final Unit schedulePrefetch$lambda$0(Function2 arg6, int arg7, LazyGridPrefetchResultScope arg8) {
        int v0 = arg8.getLineItemCount();
        int v1 = 0x80000000;
        int v4 = v1;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v4 = ComparisonsKt.maxOf(arg8.getMainAxisSize(v3), new int[0]);
        }

        if(v4 != v1) {
            arg6.invoke(Integer.valueOf(arg7), Integer.valueOf(v4));
        }

        return Unit.INSTANCE;
    }

    public final void setLayoutInfo(LazyGridLayoutInfo arg1) {
        this.layoutInfo = arg1;
    }

    public final void setPrefetchScope(LazyGridPrefetchScope arg1) {
        this.prefetchScope = arg1;
    }
}

