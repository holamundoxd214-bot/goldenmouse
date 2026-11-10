package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00126\u0010\u0005\u001A2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010 \u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\u0018\u0010!\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u0003H\u0002J\u000E\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-J\u000E\u0010.\u001A\u00020+2\u0006\u0010\u001A\u001A\u00020\u0003J\u0016\u0010/\u001A\u00020+2\u0006\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0007J\u0016\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u0002022\u0006\u0010\u000F\u001A\u00020\u0003J\u0018\u00103\u001A\u00020+2\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u0003H\u0002R>\u0010\u0005\u001A2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00078F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001E\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0011R+\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00078F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001F\u0010\u0019\u001A\u0004\b\u001D\u0010\u0015\"\u0004\b\u001E\u0010\u0017R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010&\u001A\u00020\'¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)¨\u00064"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "initialIndices", "", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetIndex", "laneCount", "<init>", "([I[ILkotlin/jvm/functions/Function2;)V", "value", "indices", "getIndices", "()[I", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffsets", "getScrollOffsets", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "calculateFirstVisibleIndex", "calculateFirstVisibleScrollOffset", "offsets", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "update", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridScrollPosition {
    public static final int $stable = 8;
    private final Function2 fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private int[] indices;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    private int[] scrollOffsets;

    static {
    }

    public LazyStaggeredGridScrollPosition(int[] arg2, int[] arg3, Function2 arg4) {
        super();
        this.fillIndices = arg4;
        this.indices = arg2;
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(this.calculateFirstVisibleIndex(arg2));
        this.scrollOffsets = arg3;
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(this.calculateFirstVisibleScrollOffset(arg2, arg3));
        Integer v2 = ArraysKt.minOrNull(arg2);
        int v2_1 = v2 != null ? v2.intValue() : 0;
        this.nearestRangeState = new LazyLayoutNearestRangeState(v2_1, 90, 200);
    }

    private final int calculateFirstVisibleIndex(int[] arg6) {
        int v5 = arg6.length;
        int v0 = 0x7FFFFFFF;
        int v3 = v0;
        int v2;
        for(v2 = 0; v2 < v5; ++v2) {
            int v4 = arg6[v2];
            if(v4 <= 0) {
                return 0;
            }

            if(v3 > v4) {
                v3 = v4;
            }
        }

        if(v3 == v0) {
            return 0;
        }

        return v3;
    }

    private final int calculateFirstVisibleScrollOffset(int[] arg7, int[] arg8) {
        int v6 = this.calculateFirstVisibleIndex(arg7);
        int v0 = arg8.length;
        int v1 = 0x7FFFFFFF;
        int v4 = v1;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            if(arg7[v3] == v6) {
                v4 = Math.min(v4, arg8[v3]);
            }
        }

        if(v4 == v1) {
            return 0;
        }

        return v4;
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final int[] getIndices() {
        return this.indices;
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final int[] getScrollOffsets() {
        return this.scrollOffsets;
    }

    public final void requestPositionAndForgetLastKnownKey(int arg5, int arg6) {
        Object v0 = this.fillIndices.invoke(Integer.valueOf(arg5), Integer.valueOf(this.indices.length));
        int v1 = v0.length;
        int[] v2 = new int[v1];
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v2[v3] = arg6;
        }

        this.update(((int[])v0), v2);
        this.nearestRangeState.update(arg5);
        this.lastKnownFirstItemKey = null;
    }

    private final void setIndex(int arg1) {
        this.index$delegate.setIntValue(arg1);
    }

    private final void setScrollOffset(int arg1) {
        this.scrollOffset$delegate.setIntValue(arg1);
    }

    private final void update(int[] arg2, int[] arg3) {
        this.indices = arg2;
        this.setIndex(this.calculateFirstVisibleIndex(arg2));
        this.scrollOffsets = arg3;
        this.setScrollOffset(this.calculateFirstVisibleScrollOffset(arg2, arg3));
    }

    public final void updateFromMeasureResult(LazyStaggeredGridMeasureResult arg8) {
        Object v5;
        Function1 v4;
        int v0 = this.calculateFirstVisibleIndex(arg8.getFirstVisibleItemIndices());
        List v1 = arg8.getVisibleItemsInfo();
        int v2 = v1.size();
        int v3 = 0;
        while(true) {
            v4 = null;
            if(v3 < v2) {
                v5 = v1.get(v3);
                if(v5.getIndex() == v0) {
                }
                else {
                    ++v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_16;
        }

        v5 = v4;
    label_16:
        Object v1_1 = v5 != null ? ((LazyStaggeredGridMeasuredItem)v5).getKey() : v4;
        this.lastKnownFirstItemKey = v1_1;
        this.nearestRangeState.update(v0);
        if(!this.hadFirstNotEmptyLayout) {
            if(arg8.getTotalItemsCount() > 0) {
            }
            else {
                return;
            }
        }

        this.hadFirstNotEmptyLayout = true;
        Companion v0_1 = Snapshot.Companion;
        Snapshot v1_2 = v0_1.getCurrentThreadSnapshot();
        if(v1_2 != null) {
            v4 = v1_2.getReadObserver();
        }

        Snapshot v2_1 = v0_1.makeCurrentNonObservable(v1_2);
        try {
            this.update(arg8.getFirstVisibleItemIndices(), arg8.getFirstVisibleItemScrollOffsets());
        }
        catch(Throwable v7) {
            v0_1.restoreNonObservable(v1_2, v2_1, v4);
            throw v7;
        }

        v0_1.restoreNonObservable(v1_2, v2_1, v4);
    }

    public final void updateScrollOffset(int[] arg2) {
        this.scrollOffsets = arg2;
        this.setScrollOffset(this.calculateFirstVisibleScrollOffset(this.indices, arg2));
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider arg6, int[] arg7) {
        Object v6_1;
        Object v0 = this.lastKnownFirstItemKey;
        int v1 = 0;
        Integer v2 = ArraysKt.getOrNull(arg7, 0);
        if(v2 != null) {
            v1 = v2.intValue();
        }

        int v6 = LazyLayoutItemProviderKt.findIndexByKey(arg6, v0, v1);
        if(!ArraysKt.contains(arg7, v6)) {
            this.nearestRangeState.update(v6);
            Companion v0_1 = Snapshot.Companion;
            Snapshot v1_1 = v0_1.getCurrentThreadSnapshot();
            Function1 v2_1 = v1_1 != null ? v1_1.getReadObserver() : null;
            Snapshot v3 = v0_1.makeCurrentNonObservable(v1_1);
            try {
                v6_1 = this.fillIndices.invoke(Integer.valueOf(v6), Integer.valueOf(arg7.length));
                v0_1.restoreNonObservable(v1_1, v3, v2_1);
            }
            catch(Throwable v5) {
                v0_1.restoreNonObservable(v1_1, v3, v2_1);
                throw v5;
            }

            this.indices = ((int[])v6_1);
            this.setIndex(this.calculateFirstVisibleIndex(((int[])v6_1)));
            return ((int[])v6_1);
        }

        return arg7;
    }
}

