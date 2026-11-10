package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b`\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J \u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0003H&JN\u0010\b\u001A\u00020\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "", "getStickingIndices", "Landroidx/collection/IntList;", "firstVisibleItemIndex", "", "lastVisibleItemIndex", "stickyItems", "calculateStickingItemOffset", "visibleStickyItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "itemIndex", "itemSize", "itemOffset", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface StickyItemsPlacement {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement$Companion;", "", "<init>", "()V", "StickToTopPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "getStickToTopPlacement", "()Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final StickyItemsPlacement StickToTopPlacement;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.StickToTopPlacement = new StickyItemsPlacement$Companion$StickToTopPlacement$1();
        }

        private Companion() {
            super();
        }

        public final StickyItemsPlacement getStickToTopPlacement() {
            return Companion.StickToTopPlacement;
        }
    }

    public static final Companion Companion;

    static {
        StickyItemsPlacement.Companion = Companion.$$INSTANCE;
    }

    int calculateStickingItemOffset(List arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8);

    IntList getStickingIndices(int arg1, int arg2, IntList arg3);
}

