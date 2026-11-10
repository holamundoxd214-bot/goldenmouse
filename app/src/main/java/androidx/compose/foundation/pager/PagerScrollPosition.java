package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#J\u0016\u0010$\u001A\u00020!2\u0006\u0010%\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u0005J\u0016\u0010\'\u001A\u00020\u00032\u0006\u0010(\u001A\u00020)2\u0006\u0010%\u001A\u00020\u0003J\u0018\u0010*\u001A\u00020!2\u0006\u0010+\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u0005H\u0002J\u000E\u0010,\u001A\u00020!2\u0006\u0010&\u001A\u00020\u0005J\u000E\u0010-\u001A\u00020!2\u0006\u0010.\u001A\u00020\u0003R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR+\u0010\u0002\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00038F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00058F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001C\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001F¨\u0006/"}, d2={"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "currentPage", "", "currentPageOffsetFraction", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "<set-?>", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hadFirstNotEmptyLayout", "", "lastKnownCurrentPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "requestPositionAndForgetLastKnownKey", "index", "offsetFraction", "matchPageWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "update", "page", "updateCurrentPageOffsetFraction", "applyScrollDelta", "delta", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerScrollPosition {
    public static final int $stable = 8;
    private final MutableIntState currentPage$delegate;
    private final MutableFloatState currentPageOffsetFraction$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final PagerState state;

    static {
    }

    public PagerScrollPosition(int arg2, float arg3, PagerState arg4) {
        super();
        this.state = arg4;
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(arg2);
        this.currentPageOffsetFraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg3);
        this.nearestRangeState = new LazyLayoutNearestRangeState(arg2, 30, 100);
    }

    public PagerScrollPosition(int arg1, float arg2, PagerState arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0f, arg3);
    }

    public final void applyScrollDelta(int arg2) {
        float v2 = this.state.getPageSizeWithSpacing$foundation() == 0 ? 0f : (((float)arg2)) / (((float)this.state.getPageSizeWithSpacing$foundation()));
        this.setCurrentPageOffsetFraction(this.getCurrentPageOffsetFraction() + v2);
    }

    public final int getCurrentPage() {
        return this.currentPage$delegate.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final PagerState getState() {
        return this.state;
    }

    public final int matchPageWithKey(PagerLazyLayoutItemProvider arg2, int arg3) {
        int v2 = LazyLayoutItemProviderKt.findIndexByKey(((LazyLayoutItemProvider)arg2), this.lastKnownCurrentPageKey, arg3);
        if(arg3 != v2) {
            this.setCurrentPage(v2);
            this.nearestRangeState.update(arg3);
        }

        return v2;
    }

    public final void requestPositionAndForgetLastKnownKey(int arg1, float arg2) {
        this.update(arg1, arg2);
        this.lastKnownCurrentPageKey = null;
    }

    private final void setCurrentPage(int arg1) {
        this.currentPage$delegate.setIntValue(arg1);
    }

    private final void setCurrentPageOffsetFraction(float arg1) {
        this.currentPageOffsetFraction$delegate.setFloatValue(arg1);
    }

    private final void update(int arg2, float arg3) {
        this.setCurrentPage(arg2);
        this.nearestRangeState.update(arg2);
        this.setCurrentPageOffsetFraction(arg3);
    }

    public final void updateCurrentPageOffsetFraction(float arg1) {
        this.setCurrentPageOffsetFraction(arg1);
    }

    public final void updateFromMeasureResult(PagerMeasureResult arg2) {
        MeasuredPage v0 = arg2.getCurrentPage();
        Object v0_1 = v0 != null ? v0.getKey() : null;
        this.lastKnownCurrentPageKey = v0_1;
        if(!this.hadFirstNotEmptyLayout) {
            if(!arg2.getVisiblePagesInfo().isEmpty()) {
            }
            else {
                return;
            }
        }

        this.hadFirstNotEmptyLayout = true;
        v0 = arg2.getCurrentPage();
        int v0_2 = v0 != null ? v0.getIndex() : 0;
        this.update(v0_2, arg2.getCurrentPageOffsetFraction());
    }
}

