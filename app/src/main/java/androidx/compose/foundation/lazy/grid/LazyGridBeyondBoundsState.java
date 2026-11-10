package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0014\u0010\u0012\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000B¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "getState", "()Landroidx/compose/foundation/lazy/grid/LazyGridState;", "itemCount", "", "getItemCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "firstPlacedIndex", "getFirstPlacedIndex", "lastPlacedIndex", "getLastPlacedIndex", "itemsPerViewport", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public static final int $stable;
    private final LazyGridState state;

    static {
    }

    public LazyGridBeyondBoundsState(LazyGridState arg1) {
        super();
        this.state = arg1;
    }

    public int getFirstPlacedIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public boolean getHasVisibleItems() {
        return this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty() ^ 1;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public int getLastPlacedIndex() {
        return CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo()).getIndex();
    }

    public final LazyGridState getState() {
        return this.state;
    }

    public int itemsPerViewport() {
        if(this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            return 0;
        }

        int v0 = LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(this.state.getLayoutInfo());
        int v2 = LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize(this.state.getLayoutInfo());
        if(v2 == 0) {
            return 1;
        }

        return RangesKt.coerceAtLeast(v0 / v2, 1);
    }
}

