package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001A\u00020\u0005H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\n¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/pager/PagerBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondViewportPageCount", "", "<init>", "(Landroidx/compose/foundation/pager/PagerState;I)V", "itemCount", "getItemCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "firstPlacedIndex", "getFirstPlacedIndex", "lastPlacedIndex", "getLastPlacedIndex", "itemsPerViewport", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public static final int $stable;
    private final int beyondViewportPageCount;
    private final PagerState state;

    static {
    }

    public PagerBeyondBoundsState(PagerState arg1, int arg2) {
        super();
        this.state = arg1;
        this.beyondViewportPageCount = arg2;
    }

    public int getFirstPlacedIndex() {
        return Math.max(0, this.state.getFirstVisiblePage$foundation() - this.beyondViewportPageCount);
    }

    public boolean getHasVisibleItems() {
        return this.state.getLayoutInfo().getVisiblePagesInfo().isEmpty() ^ 1;
    }

    public int getItemCount() {
        return this.state.getPageCount();
    }

    public int getLastPlacedIndex() {
        return Math.min(this.getItemCount() - 1, CollectionsKt.last(this.state.getLayoutInfo().getVisiblePagesInfo()).getIndex() + this.beyondViewportPageCount);
    }

    public int itemsPerViewport() {
        if(this.state.getLayoutInfo().getVisiblePagesInfo().size() == 0) {
            return 0;
        }

        int v0 = PagerLayoutInfoKt.getMainAxisViewportSize(this.state.getLayoutInfo());
        int v1 = this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing();
        if(v1 == 0) {
            return 1;
        }

        return RangesKt.coerceAtLeast(v0 / v1, 1);
    }
}

