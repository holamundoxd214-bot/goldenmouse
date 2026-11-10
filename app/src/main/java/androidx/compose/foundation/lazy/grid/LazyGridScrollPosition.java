package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u0003J\u0016\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003J\u0016\u0010 \u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"2\u0006\u0010\b\u001A\u00020\u0003J\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H\u0002R+\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR+\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000E\u001A\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "<init>", "(II)V", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "update", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    static {
    }

    public LazyGridScrollPosition() {
        this(0, 0, 3, null);
    }

    public LazyGridScrollPosition(int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, 0);
    }

    public LazyGridScrollPosition(int arg3, int arg4) {
        super();
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(arg3);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(arg4);
        this.nearestRangeState = new LazyLayoutNearestRangeState(arg3, 90, 200);
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

    private final void setIndex(int arg1) {
        this.index$delegate.setIntValue(arg1);
    }

    private final void setScrollOffset(int arg1) {
        this.scrollOffset$delegate.setIntValue(arg1);
    }

    private final void update(int arg3, int arg4) {
        int v0 = (((float)arg3)) >= 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
        }

        this.setIndex(arg3);
        this.nearestRangeState.update(arg3);
        this.setScrollOffset(arg4);
    }

    public final void updateFromMeasureResult(LazyGridMeasureResult arg5) {
        Object v0_2;
        LazyGridMeasuredLine v0 = arg5.getFirstVisibleLine();
        if(v0 != null) {
            LazyGridMeasuredItem[] v0_1 = v0.getItems();
            if(v0_1 != null) {
                v0_2 = ArraysKt.firstOrNull(((Object[])v0_1));
                if(v0_2 != null) {
                    v0_2 = ((LazyGridMeasuredItem)v0_2).getKey();
                }
                else {
                    goto label_8;
                }
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v0_2 = null;
        }

        this.lastKnownFirstItemKey = v0_2;
        if(!this.hadFirstNotEmptyLayout) {
            if(arg5.getTotalItemsCount() > 0) {
            }
            else {
                return;
            }
        }

        int v0_3 = 1;
        this.hadFirstNotEmptyLayout = true;
        int v1 = arg5.getFirstVisibleLineScrollOffset();
        int v3 = 0;
        if(Float.compare(((float)v1), 0f) >= 0) {
        }
        else {
            v0_3 = 0;
        }

        if(v0_3 == 0) {
            InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative (" + v1 + ')');
        }

        LazyGridMeasuredLine v5 = arg5.getFirstVisibleLine();
        if(v5 != null) {
            LazyGridMeasuredItem[] v5_1 = v5.getItems();
            if(v5_1 != null) {
                Object v5_2 = ArraysKt.firstOrNull(((Object[])v5_1));
                if(v5_2 != null) {
                    v3 = ((LazyGridMeasuredItem)v5_2).getIndex();
                }
            }
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

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider arg2, int arg3) {
        int v2 = LazyLayoutItemProviderKt.findIndexByKey(((LazyLayoutItemProvider)arg2), this.lastKnownFirstItemKey, arg3);
        if(arg3 != v2) {
            this.setIndex(v2);
            this.nearestRangeState.update(arg3);
        }

        return v2;
    }
}

