package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0014\u0010\u0010\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0014\u0010\u0011\u001A\u00020\n*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J.\u0010\u0015\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000F2\u0017\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u0019H\u0082\bR\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridCacheWindowPrefetchStrategy;", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;)V", "cacheWindowScope", "Landroidx/compose/foundation/lazy/grid/LazyGridCacheWindowScope;", "onScroll", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "", "applyWindowScope", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridCacheWindowPrefetchStrategy extends CacheWindowLogic implements LazyGridPrefetchStrategy {
    public static final int $stable = 8;
    private final LazyGridCacheWindowScope cacheWindowScope;

    static {
    }

    public LazyGridCacheWindowPrefetchStrategy(LazyLayoutCacheWindow arg4) {
        super(arg4, false, 2, null);
        this.cacheWindowScope = new LazyGridCacheWindowScope();
    }

    private final void applyWindowScope(LazyGridPrefetchScope arg2, LazyGridLayoutInfo arg3, Function1 arg4) {
        this.cacheWindowScope.setLayoutInfo(arg3);
        this.cacheWindowScope.setPrefetchScope(arg2);
        arg4.invoke(this.cacheWindowScope);
    }

    public void onNestedPrefetch(NestedPrefetchScope arg3, int arg4) {
        int v2 = arg3.getNestedPrefetchItemCount();
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            arg3.schedulePrecomposition(arg4 + v0);
        }
    }

    public void onScroll(LazyGridPrefetchScope arg2, float arg3, LazyGridLayoutInfo arg4) {
        this.cacheWindowScope.setLayoutInfo(arg4);
        this.cacheWindowScope.setPrefetchScope(arg2);
        this.onScroll(this.cacheWindowScope, arg3);
    }

    public void onVisibleItemsUpdated(LazyGridPrefetchScope arg2, LazyGridLayoutInfo arg3) {
        this.cacheWindowScope.setLayoutInfo(arg3);
        this.cacheWindowScope.setPrefetchScope(arg2);
        this.onVisibleItemsUpdated(this.cacheWindowScope);
    }
}

