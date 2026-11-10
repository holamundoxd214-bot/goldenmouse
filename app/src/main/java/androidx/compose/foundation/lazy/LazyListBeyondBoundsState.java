package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001A\u00020\u0005H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000BR\u0014\u0010\u0014\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u000B¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsItemCount", "", "<init>", "(Landroidx/compose/foundation/lazy/LazyListState;I)V", "getState", "()Landroidx/compose/foundation/lazy/LazyListState;", "getBeyondBoundsItemCount", "()I", "itemCount", "getItemCount", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "firstPlacedIndex", "getFirstPlacedIndex", "lastPlacedIndex", "getLastPlacedIndex", "itemsPerViewport", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public static final int $stable;
    private final int beyondBoundsItemCount;
    private final LazyListState state;

    static {
    }

    public LazyListBeyondBoundsState(LazyListState arg1, int arg2) {
        super();
        this.state = arg1;
        this.beyondBoundsItemCount = arg2;
    }

    public final int getBeyondBoundsItemCount() {
        return this.beyondBoundsItemCount;
    }

    public int getFirstPlacedIndex() {
        return Math.max(0, this.state.getFirstVisibleItemIndex() - this.beyondBoundsItemCount);
    }

    public boolean getHasVisibleItems() {
        return this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty() ^ 1;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public int getLastPlacedIndex() {
        return Math.min(this.getItemCount() - 1, CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo()).getIndex() + this.beyondBoundsItemCount);
    }

    public final LazyListState getState() {
        return this.state;
    }

    public int itemsPerViewport() {
        if(this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            return 0;
        }

        int v0 = LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(this.state.getLayoutInfo());
        int v2 = LazyListLayoutInfoKt.visibleItemsAverageSize(this.state.getLayoutInfo());
        if(v2 == 0) {
            return 1;
        }

        return RangesKt.coerceAtLeast(v0 / v2, 1);
    }
}

