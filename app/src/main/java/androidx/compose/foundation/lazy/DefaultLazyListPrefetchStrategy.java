package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0014\u0010\u0014\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0014\u0010\u0015\u001A\u00020\u000F*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0003H\u0016J\b\u0010\u0018\u001A\u00020\u000FH\u0002J\u0014\u0010\u0019\u001A\u00020\u0003*\u00020\u00132\u0006\u0010\u001A\u001A\u00020\nH\u0002J\u001C\u0010\u001B\u001A\u00020\u000F*\u00020\u00132\u0006\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\nH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/lazy/DefaultLazyListPrefetchStrategy;", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "initialNestedPrefetchItemCount", "", "<init>", "(I)V", "indexToPrefetch", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasScrollingForward", "", "previousPassItemCount", "previousPassDelta", "", "onScroll", "", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "resetPrefetchState", "calculateIndexToPrefetch", "scrollingForward", "evaluatePrefetchForCancellation", "currentPrefetchingIndex", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultLazyListPrefetchStrategy implements LazyListPrefetchStrategy {
    private PrefetchHandle currentPrefetchHandle;
    private int indexToPrefetch;
    private final int initialNestedPrefetchItemCount;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyListPrefetchStrategy() {
        this(0, 1, null);
    }

    public DefaultLazyListPrefetchStrategy(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 2;
        }

        this(arg1);
    }

    public DefaultLazyListPrefetchStrategy(int arg1) {
        super();
        this.initialNestedPrefetchItemCount = arg1;
        this.indexToPrefetch = -1;
        this.previousPassItemCount = -1;
    }

    private final int calculateIndexToPrefetch(LazyListLayoutInfo arg1, boolean arg2) {
        if(arg2) {
            return CollectionsKt.last(arg1.getVisibleItemsInfo()).getIndex() + 1;
        }

        return CollectionsKt.first(arg1.getVisibleItemsInfo()).getIndex() - 1;
    }

    private final void evaluatePrefetchForCancellation(LazyListLayoutInfo arg2, int arg3, boolean arg4) {
        if(arg3 != -1 && !arg2.getVisibleItemsInfo().isEmpty() && arg3 != this.calculateIndexToPrefetch(arg2, arg4)) {
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

    public void onScroll(LazyListPrefetchScope arg5, float arg6, LazyListLayoutInfo arg7) {
        PrefetchHandle v5_1;
        if(!arg7.getVisibleItemsInfo().isEmpty()) {
            boolean v0 = arg6 < 0f ? true : false;
            int v1 = this.calculateIndexToPrefetch(arg7, v0);
            if(v1 < 0) {
                goto label_50;
            }

            if(v1 >= arg7.getTotalItemsCount()) {
                goto label_50;
            }

            if(v1 != this.indexToPrefetch) {
                if(this.wasScrollingForward != v0) {
                    this.resetPrefetchState();
                }

                this.wasScrollingForward = v0;
                this.indexToPrefetch = v1;
                this.currentPrefetchHandle = LazyListPrefetchScope.schedulePrefetch$default(arg5, v1, null, 2, null);
            }

            if(v0) {
                Object v5 = CollectionsKt.last(arg7.getVisibleItemsInfo());
                if((((float)(((LazyListItemInfo)v5).getOffset() + ((LazyListItemInfo)v5).getSize() + arg7.getMainAxisItemSpacing() - arg7.getViewportEndOffset()))) >= -arg6) {
                    goto label_50;
                }

                v5_1 = this.currentPrefetchHandle;
                if(v5_1 == null) {
                    goto label_50;
                }

                v5_1.markAsUrgent();
                goto label_50;
            }

            if((((float)(arg7.getViewportStartOffset() - CollectionsKt.first(arg7.getVisibleItemsInfo()).getOffset()))) >= arg6) {
                goto label_50;
            }

            v5_1 = this.currentPrefetchHandle;
            if(v5_1 == null) {
                goto label_50;
            }

            v5_1.markAsUrgent();
        }

    label_50:
        this.previousPassDelta = arg6;
    }

    public void onVisibleItemsUpdated(LazyListPrefetchScope arg5, LazyListLayoutInfo arg6) {
        this.evaluatePrefetchForCancellation(arg6, this.indexToPrefetch, this.wasScrollingForward);
        int v0 = arg6.getTotalItemsCount();
        int v1 = this.previousPassItemCount;
        if(v1 != -1) {
            if(this.previousPassDelta == 0f) {
            }
            else if(v1 != v0 && !arg6.getVisibleItemsInfo().isEmpty()) {
                boolean v1_1 = this.previousPassDelta < 0f ? true : false;
                int v6 = this.calculateIndexToPrefetch(arg6, v1_1);
                if(v6 < 0) {
                    goto label_28;
                }

                if(v6 >= v0) {
                    goto label_28;
                }

                this.indexToPrefetch = v6;
                this.currentPrefetchHandle = LazyListPrefetchScope.schedulePrefetch$default(arg5, v6, null, 2, null);
            }
        }

    label_28:
        this.previousPassItemCount = v0;
    }

    private final void resetPrefetchState() {
        this.indexToPrefetch = -1;
        PrefetchHandle v0 = this.currentPrefetchHandle;
        if(v0 != null) {
            v0.cancel();
        }

        this.currentPrefetchHandle = null;
    }
}

