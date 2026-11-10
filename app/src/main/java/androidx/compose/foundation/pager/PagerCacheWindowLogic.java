package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0018J*\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0017\u0010\u001B\u001A\u0013\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020\u00140\u001C¢\u0006\u0002\b\u001EH\u0082\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/pager/PagerCacheWindowLogic;", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "itemCount", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function0;)V", "getCacheWindow", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getItemCount", "()Lkotlin/jvm/functions/Function0;", "cacheWindowScope", "Landroidx/compose/foundation/pager/PagerCacheWindowScope;", "onScroll", "", "delta", "", "layoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "onVisibleItemsChanged", "applyWindowScope", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerCacheWindowLogic extends CacheWindowLogic {
    public static final int $stable = 8;
    private final LazyLayoutCacheWindow cacheWindow;
    private final PagerCacheWindowScope cacheWindowScope;
    private final Function0 itemCount;
    private final LazyLayoutPrefetchState state;

    static {
    }

    public PagerCacheWindowLogic(LazyLayoutCacheWindow arg2, LazyLayoutPrefetchState arg3, Function0 arg4) {
        super(arg2, false);
        this.cacheWindow = arg2;
        this.state = arg3;
        this.itemCount = arg4;
        this.cacheWindowScope = new PagerCacheWindowScope(arg4);
    }

    private final void applyWindowScope(PagerMeasureResult arg2, Function1 arg3) {
        this.cacheWindowScope.setLayoutInfo(arg2);
        this.cacheWindowScope.setState(this.state);
        arg3.invoke(this.cacheWindowScope);
    }

    public final LazyLayoutCacheWindow getCacheWindow() {
        return this.cacheWindow;
    }

    public final Function0 getItemCount() {
        return this.itemCount;
    }

    public final LazyLayoutPrefetchState getState() {
        return this.state;
    }

    public final void onScroll(float arg2, PagerMeasureResult arg3) {
        this.cacheWindowScope.setLayoutInfo(arg3);
        this.cacheWindowScope.setState(this.state);
        this.onScroll(this.cacheWindowScope, -arg2);
    }

    public final void onVisibleItemsChanged(PagerMeasureResult arg2) {
        this.cacheWindowScope.setLayoutInfo(arg2);
        this.cacheWindowScope.setState(this.state);
        this.onVisibleItemsUpdated(this.cacheWindowScope);
    }
}

