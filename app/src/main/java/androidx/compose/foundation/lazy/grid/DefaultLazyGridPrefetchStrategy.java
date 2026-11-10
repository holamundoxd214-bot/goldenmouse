package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u000F\u001A\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0014\u0010\u0015\u001A\u00020\u0010*\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0014\u0010\u0016\u001A\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0003H\u0016J\u001C\u0010\u0019\u001A\u00020\u0010*\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u000BH\u0002J\u0014\u0010\u001C\u001A\u00020\u0003*\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u000BH\u0002J\u0014\u0010\u001D\u001A\u00020\u0003*\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u000BH\u0002J\b\u0010\u001E\u001A\u00020\u0010H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "initialNestedPrefetchItemCount", "", "<init>", "(I)V", "lineToPrefetch", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasScrollingForward", "", "previousPassItemCount", "previousPassDelta", "", "onScroll", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "evaluatePrefetchForCancellation", "currentPrefetchingLineIndex", "scrollingForward", "calculateLineIndexToPrefetch", "calculateClosestNextItemToPrefetch", "resetPrefetchState", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final MutableVector currentLinePrefetchHandles;
    private final int initialNestedPrefetchItemCount;
    private int lineToPrefetch;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyGridPrefetchStrategy() {
        this(0, 1, null);
    }

    public DefaultLazyGridPrefetchStrategy(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 2;
        }

        this(arg1);
    }

    public DefaultLazyGridPrefetchStrategy(int arg4) {
        super();
        this.initialNestedPrefetchItemCount = arg4;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector(new PrefetchHandle[16], 0);
        this.previousPassItemCount = -1;
    }

    private final int calculateClosestNextItemToPrefetch(LazyGridLayoutInfo arg1, boolean arg2) {
        if(arg2) {
            return CollectionsKt.last(arg1.getVisibleItemsInfo()).getIndex() + 1;
        }

        return CollectionsKt.first(arg1.getVisibleItemsInfo()).getIndex() - 1;
    }

    private final int calculateLineIndexToPrefetch(LazyGridLayoutInfo arg1, boolean arg2) {
        int v0_1;
        Object v0;
        if(arg2) {
            v0 = CollectionsKt.last(arg1.getVisibleItemsInfo());
            v0_1 = arg1.getOrientation() == Orientation.Vertical ? ((LazyGridItemInfo)v0).getRow() : ((LazyGridItemInfo)v0).getColumn();
            return v0_1 + 1;
        }

        v0 = CollectionsKt.first(arg1.getVisibleItemsInfo());
        v0_1 = arg1.getOrientation() == Orientation.Vertical ? ((LazyGridItemInfo)v0).getRow() : ((LazyGridItemInfo)v0).getColumn();
        return v0_1 - 1;
    }

    private final void evaluatePrefetchForCancellation(LazyGridLayoutInfo arg2, int arg3, boolean arg4) {
        if(arg3 != -1 && !arg2.getVisibleItemsInfo().isEmpty() && arg3 != this.calculateLineIndexToPrefetch(arg2, arg4)) {
            this.resetPrefetchState();
        }
    }

    public void onNestedPrefetch(NestedPrefetchScope arg3, int arg4) {
        int v2 = arg3.getNestedPrefetchItemCount() == -1 ? this.initialNestedPrefetchItemCount : arg3.getNestedPrefetchItemCount();
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            arg3.schedulePrecomposition(arg4 + v0);
        }
    }

    public void onScroll(LazyGridPrefetchScope arg8, float arg9, LazyGridLayoutInfo arg10) {
        int v8_2;
        Object[] v10;
        MutableVector v8_1;
        if(!arg10.getVisibleItemsInfo().isEmpty()) {
            int v1 = 0;
            boolean v0 = Float.compare(arg9, 0f) < 0 ? true : false;
            int v2 = this.calculateLineIndexToPrefetch(arg10, v0);
            int v3 = this.calculateClosestNextItemToPrefetch(arg10, v0);
            if(v3 < 0) {
                goto label_76;
            }

            if(v3 >= arg10.getTotalItemsCount()) {
                goto label_76;
            }

            if(v2 != this.lineToPrefetch && v2 >= 0) {
                if(this.wasScrollingForward != v0) {
                    MutableVector v3_1 = this.currentLinePrefetchHandles;
                    Object[] v4 = v3_1.content;
                    v3 = v3_1.getSize();
                    int v5;
                    for(v5 = 0; v5 < v3; ++v5) {
                        v4[v5].cancel();
                    }
                }

                this.wasScrollingForward = v0;
                this.lineToPrefetch = v2;
                this.currentLinePrefetchHandles.clear();
                this.currentLinePrefetchHandles.addAll(this.currentLinePrefetchHandles.getSize(), arg8.scheduleLinePrefetch(v2));
            }

            if(v0) {
                Object v8 = CollectionsKt.last(arg10.getVisibleItemsInfo());
                if((((float)(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(((LazyGridItemInfo)v8), arg10.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(((LazyGridItemInfo)v8), arg10.getOrientation()) + arg10.getMainAxisItemSpacing() - arg10.getViewportEndOffset()))) >= -arg9) {
                    goto label_76;
                }

                v8_1 = this.currentLinePrefetchHandles;
                v10 = v8_1.content;
                v8_2 = v8_1.getSize();
                while(true) {
                    if(v1 >= v8_2) {
                        goto label_76;
                    }

                    v10[v1].markAsUrgent();
                    ++v1;
                }
            }

            if((((float)(arg10.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(CollectionsKt.first(arg10.getVisibleItemsInfo()), arg10.getOrientation())))) >= arg9) {
                goto label_76;
            }

            v8_1 = this.currentLinePrefetchHandles;
            v10 = v8_1.content;
            v8_2 = v8_1.getSize();
            while(v1 < v8_2) {
                v10[v1].markAsUrgent();
                ++v1;
            }
        }

    label_76:
        this.previousPassDelta = arg9;
    }

    public void onVisibleItemsUpdated(LazyGridPrefetchScope arg7, LazyGridLayoutInfo arg8) {
        this.evaluatePrefetchForCancellation(arg8, this.lineToPrefetch, this.wasScrollingForward);
        int v0 = arg8.getTotalItemsCount();
        int v1 = this.previousPassItemCount;
        if(v1 != -1) {
            if(this.previousPassDelta == 0f) {
            }
            else if(v1 != v0 && !arg8.getVisibleItemsInfo().isEmpty()) {
                boolean v2 = true;
                boolean v1_1 = Float.compare(this.previousPassDelta, 0f) < 0 ? true : false;
                v1 = this.calculateLineIndexToPrefetch(arg8, v1_1);
                if(this.previousPassDelta < 0f) {
                }
                else {
                    v2 = false;
                }

                int v2_1 = this.calculateClosestNextItemToPrefetch(arg8, v2);
                if(v2_1 < 0) {
                    goto label_42;
                }

                if(v2_1 >= arg8.getTotalItemsCount()) {
                    goto label_42;
                }

                if(v1 == this.lineToPrefetch) {
                    goto label_42;
                }

                if(v1 < 0) {
                    goto label_42;
                }

                this.lineToPrefetch = v1;
                this.currentLinePrefetchHandles.clear();
                this.currentLinePrefetchHandles.addAll(this.currentLinePrefetchHandles.getSize(), arg7.scheduleLinePrefetch(v1));
            }
        }

    label_42:
        this.previousPassItemCount = v0;
    }

    private final void resetPrefetchState() {
        this.lineToPrefetch = -1;
        MutableVector v0 = this.currentLinePrefetchHandles;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1[v2].cancel();
        }

        this.currentLinePrefetchHandles.clear();
    }
}

