package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u0003J\u0016\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003J\u0016\u0010 \u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"2\u0006\u0010\b\u001A\u00020\u0003J\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H\u0002R+\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR+\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000E\u001A\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2={"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "<init>", "(II)V", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "update", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    static {
    }

    public LazyListScrollPosition() {
        this(0, 0, 3, null);
    }

    public LazyListScrollPosition(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0);
    }

    public LazyListScrollPosition(int arg3, int arg4) {
        super();
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(arg3);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(arg4);
        this.nearestRangeState = new LazyLayoutNearestRangeState(arg3, 30, 100);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final void requestPositionAndForgetLastKnownKey(int arg1, int arg2) {
        this.update(arg1, arg2);
        this.lastKnownFirstItemKey = null;
    }

    public final void setIndex(int arg1) {
        this.index$delegate.setIntValue(arg1);
    }

    private final void setScrollOffset(int arg1) {
        this.scrollOffset$delegate.setIntValue(arg1);
    }

    private final void update(int arg3, int arg4) {
        int v0 = (((float)arg3)) >= 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative (" + arg3 + ')');
        }

        this.setIndex(arg3);
        this.nearestRangeState.update(arg3);
        this.setScrollOffset(arg4);
    }

    public final void updateFromMeasureResult(LazyListMeasureResult arg5) {
        LazyListMeasuredItem v0 = arg5.getFirstVisibleItem();
        Object v0_1 = v0 != null ? v0.getKey() : null;
        this.lastKnownFirstItemKey = v0_1;
        if(!this.hadFirstNotEmptyLayout) {
            if(arg5.getTotalItemsCount() > 0) {
            }
            else {
                return;
            }
        }

        int v0_2 = 1;
        this.hadFirstNotEmptyLayout = true;
        int v1 = arg5.getFirstVisibleItemScrollOffset();
        int v3 = 0;
        if(Float.compare(((float)v1), 0f) >= 0) {
        }
        else {
            v0_2 = 0;
        }

        if(v0_2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
        }

        LazyListMeasuredItem v5 = arg5.getFirstVisibleItem();
        if(v5 != null) {
            v3 = v5.getIndex();
        }

        this.update(v3, v1);
    }

    public final void updateScrollOffset(int arg3) {
        int v0 = (((float)arg3)) >= 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
        }

        this.setScrollOffset(arg3);
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider arg2, int arg3) {
        int v2 = LazyLayoutItemProviderKt.findIndexByKey(((LazyLayoutItemProvider)arg2), this.lastKnownFirstItemKey, arg3);
        if(arg3 != v2) {
            this.setIndex(v2);
            this.nearestRangeState.update(arg3);
        }

        return v2;
    }
}

