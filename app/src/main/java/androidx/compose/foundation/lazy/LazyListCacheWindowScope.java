package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010&\u001A\b\u0012\u0004\u0012\u00020(0\'2\u0006\u0010)\u001A\u00020\u00112\u0018\u0010*\u001A\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001A\u00020\u00112\u0006\u00100\u001A\u00020\u0011H\u0016J\u0010\u00101\u001A\u00020\u00112\u0006\u00100\u001A\u00020\u0011H\u0016J\u0010\u00102\u001A\u00020\u00112\u0006\u0010)\u001A\u00020\u0011H\u0016J\u0010\u00103\u001A\u0002042\u0006\u00100\u001A\u00020\u0011H\u0016J\b\u00105\u001A\u00020\u0011H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001A\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0013R\u0014\u0010\u001C\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0013R\u0014\u0010\u001E\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0013R\u0014\u0010 \u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0013R\u0016\u0010\"\u001A\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%R\u0014\u0010-\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010\u0013¨\u00066"}, d2={"Landroidx/compose/foundation/lazy/LazyListCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "<init>", "()V", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "setLayoutInfo", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)V", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "getPrefetchScope", "()Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "setPrefetchScope", "(Landroidx/compose/foundation/lazy/LazyListPrefetchScope;)V", "totalItemsCount", "", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleItemLine", "getLastIndexInLine", "getVisibleLineKey", "", "getLastLineIndex", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListCacheWindowScope implements CacheWindowScope {
    public static final int $stable = 8;
    public LazyListLayoutInfo layoutInfo;
    public LazyListPrefetchScope prefetchScope;

    static {
    }

    public LazyListCacheWindowScope() {
        super();
    }

    public Density getDensity() {
        LazyListLayoutInfo v2 = this.getLayoutInfo();
        Density v1 = null;
        if((v2 instanceof LazyListMeasureResult)) {
        }
        else {
            v2 = ((LazyListLayoutInfo)v1);
        }

        if(v2 != null) {
            return ((LazyListMeasureResult)v2).getDensity();
        }

        return v1;
    }

    public int getFirstVisibleLineIndex() {
        return CollectionsKt.first(this.getLayoutInfo().getVisibleItemsInfo()).getIndex();
    }

    public boolean getHasVisibleItems() {
        return this.getLayoutInfo().getVisibleItemsInfo().isEmpty() ^ 1;
    }

    public int getLastIndexInLine(int arg1) {
        return arg1;
    }

    public int getLastLineIndex() {
        if(this.getTotalItemsCount() == 0) {
            return -1;
        }

        return this.getTotalItemsCount() - 1;
    }

    public int getLastVisibleLineIndex() {
        return CollectionsKt.last(this.getLayoutInfo().getVisibleItemsInfo()).getIndex();
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        LazyListLayoutInfo v0 = this.layoutInfo;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public int getMainAxisExtraSpaceEnd() {
        Object v0 = CollectionsKt.last(this.getLayoutInfo().getVisibleItemsInfo());
        return Math.abs(((LazyListItemInfo)v0).getOffset() + ((LazyListItemInfo)v0).getSize() + this.getLayoutInfo().getMainAxisItemSpacing() - this.getLayoutInfo().getViewportEndOffset());
    }

    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(CollectionsKt.first(this.getLayoutInfo().getVisibleItemsInfo()).getOffset() + this.getLayoutInfo().getBeforeContentPadding(), 0));
    }

    public int getMainAxisViewportSize() {
        return LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(this.getLayoutInfo());
    }

    public final LazyListPrefetchScope getPrefetchScope() {
        LazyListPrefetchScope v0 = this.prefetchScope;
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
        return this.getLayoutInfo().getVisibleItemsInfo().get(arg1).getIndex();
    }

    public int getVisibleItemSize(int arg1) {
        return this.getLayoutInfo().getVisibleItemsInfo().get(arg1).getSize();
    }

    public int getVisibleLineCount() {
        return this.getLayoutInfo().getVisibleItemsInfo().size();
    }

    public Object getVisibleLineKey(int arg1) {
        return this.getLayoutInfo().getVisibleItemsInfo().get(arg1).getKey();
    }

    public List schedulePrefetch(int arg2, Function2 arg3) {
        return CollectionsKt.listOf(this.getPrefetchScope().schedulePrefetch(arg2, new LazyListCacheWindowScope$$ExternalSyntheticLambda0(arg3)));
    }

    static final Unit schedulePrefetch$lambda$0(Function2 arg1, LazyListPrefetchResultScope arg2) {
        arg1.invoke(Integer.valueOf(arg2.getIndex()), Integer.valueOf(arg2.getMainAxisSize()));
        return Unit.INSTANCE;
    }

    public final void setLayoutInfo(LazyListLayoutInfo arg1) {
        this.layoutInfo = arg1;
    }

    public final void setPrefetchScope(LazyListPrefetchScope arg1) {
        this.prefetchScope = arg1;
    }
}

