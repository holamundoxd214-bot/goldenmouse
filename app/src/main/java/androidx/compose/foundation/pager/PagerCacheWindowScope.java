package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.CachedItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchResultScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010*\u001A\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001A\u00020\u00042\u0018\u0010.\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000/H\u0016J\u0010\u00103\u001A\u00020\u00042\u0006\u00104\u001A\u00020\u0004H\u0016J\u0010\u00105\u001A\u00020\u00042\u0006\u00104\u001A\u00020\u0004H\u0016J\u0010\u00106\u001A\u0002072\u0006\u00104\u001A\u00020\u0004H\u0016J\u0010\u00108\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\u0004H\u0016J\b\u00109\u001A\u00020\u0004H\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0017R\u0014\u0010\u001E\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0017R\u0014\u0010 \u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0017R\u0014\u0010\"\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0017R\u0014\u0010$\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\u0017R\u0016\u0010&\u001A\u0004\u0018\u00010\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R\u0014\u00101\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b2\u0010\u0017¨\u0006:"}, d2={"Landroidx/compose/foundation/pager/PagerCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "itemCount", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getItemCount", "()Lkotlin/jvm/functions/Function0;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "setLayoutInfo", "(Landroidx/compose/foundation/pager/PagerMeasureResult;)V", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "setState", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "totalItemsCount", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleItemLine", "getVisibleLineKey", "", "getLastIndexInLine", "getLastLineIndex", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PagerCacheWindowScope implements CacheWindowScope {
    private final Function0 itemCount;
    public PagerMeasureResult layoutInfo;
    public LazyLayoutPrefetchState state;

    public PagerCacheWindowScope(Function0 arg1) {
        super();
        this.itemCount = arg1;
    }

    public Density getDensity() {
        return this.getLayoutInfo().getDensity();
    }

    public int getFirstVisibleLineIndex() {
        return ((int)RangesKt.coerceAtLeast((((long)CollectionsKt.first(this.getLayoutInfo().getVisiblePagesInfo()).getIndex())) - (((long)this.getLayoutInfo().getBeyondViewportPageCount())), 0));
    }

    public boolean getHasVisibleItems() {
        return this.getLayoutInfo().getVisiblePagesInfo().isEmpty() ^ 1;
    }

    public final Function0 getItemCount() {
        return this.itemCount;
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
        return ((int)RangesKt.coerceAtMost((((long)CollectionsKt.last(this.getLayoutInfo().getVisiblePagesInfo()).getIndex())) + (((long)this.getLayoutInfo().getBeyondViewportPageCount())), (((long)this.getTotalItemsCount())) - 1));
    }

    public final PagerMeasureResult getLayoutInfo() {
        PagerMeasureResult v0 = this.layoutInfo;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public int getMainAxisExtraSpaceEnd() {
        return Math.abs(CollectionsKt.last(this.getLayoutInfo().getVisiblePagesInfo()).getOffset() + this.getLayoutInfo().getPageSize() + this.getLayoutInfo().getPageSpacing() - this.getLayoutInfo().getViewportEndOffset());
    }

    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(CollectionsKt.first(this.getLayoutInfo().getVisiblePagesInfo()).getOffset() + this.getLayoutInfo().getBeforeContentPadding(), 0));
    }

    public int getMainAxisViewportSize() {
        return PagerLayoutInfoKt.getMainAxisViewportSize(this.getLayoutInfo());
    }

    public final LazyLayoutPrefetchState getState() {
        LazyLayoutPrefetchState v0 = this.state;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public int getTotalItemsCount() {
        return this.itemCount.invoke().intValue();
    }

    public int getVisibleItemLine(int arg4) {
        int v0 = this.getLayoutInfo().getExtraPagesBefore().size();
        int v1 = this.getLayoutInfo().getVisiblePagesInfo().size();
        if(arg4 < v0) {
            return this.getLayoutInfo().getExtraPagesBefore().get(arg4).getIndex();
        }

        if(arg4 >= v0 && arg4 < v0 + v1) {
            return this.getLayoutInfo().getVisiblePagesInfo().get(arg4 - v0).getIndex();
        }

        if(arg4 >= v0 + v1) {
            return this.getLayoutInfo().getExtraPagesAfter().get(arg4 - v0 - v1).getIndex();
        }

        return -1;
    }

    public int getVisibleItemSize(int arg1) {
        return this.getLayoutInfo().getPageSize();
    }

    public int getVisibleLineCount() {
        return this.getLayoutInfo().getExtraPagesBefore().size() + this.getLayoutInfo().getVisiblePagesInfo().size() + this.getLayoutInfo().getExtraPagesAfter().size();
    }

    public Object getVisibleLineKey(int arg4) {
        int v0 = this.getLayoutInfo().getExtraPagesBefore().size();
        int v1 = this.getLayoutInfo().getVisiblePagesInfo().size();
        if(arg4 < v0) {
            return this.getLayoutInfo().getExtraPagesBefore().get(arg4).getKey();
        }

        if(arg4 >= v0 && arg4 < v0 + v1) {
            return this.getLayoutInfo().getVisiblePagesInfo().get(arg4 - v0).getKey();
        }

        if(arg4 >= v0 + v1) {
            return this.getLayoutInfo().getExtraPagesAfter().get(arg4 - v0 - v1).getKey();
        }

        return CachedItem.NoKey;
    }

    public List schedulePrefetch(int arg8, Function2 arg9) {
        return CollectionsKt.listOf(this.getState().schedulePrecompositionAndPremeasure-_EkL_-Y$foundation(arg8, this.getLayoutInfo().getChildConstraints-msEJaDk(), true, new PagerCacheWindowScope$$ExternalSyntheticLambda0(arg9, this)));
    }

    static final Unit schedulePrefetch$lambda$0(Function2 arg0, PagerCacheWindowScope arg1, PrefetchResultScope arg2) {
        arg0.invoke(Integer.valueOf(arg2.getIndex()), Integer.valueOf(arg1.getLayoutInfo().getPageSize()));
        return Unit.INSTANCE;
    }

    public final void setLayoutInfo(PagerMeasureResult arg1) {
        this.layoutInfo = arg1;
    }

    public final void setState(LazyLayoutPrefetchState arg1) {
        this.state = arg1;
    }
}

