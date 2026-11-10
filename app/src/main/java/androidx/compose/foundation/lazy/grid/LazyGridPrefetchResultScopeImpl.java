package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchResultScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchResultScope;", "lineIndex", "", "mainAxisSizes", "", "<init>", "(ILjava/util/List;)V", "getLineIndex", "()I", "lineItemCount", "getLineItemCount", "getMainAxisSize", "itemIndexInLine", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridPrefetchResultScopeImpl implements LazyGridPrefetchResultScope {
    public static final int $stable = 8;
    private final int lineIndex;
    private final List mainAxisSizes;

    static {
    }

    public LazyGridPrefetchResultScopeImpl(int arg1, List arg2) {
        super();
        this.lineIndex = arg1;
        this.mainAxisSizes = arg2;
    }

    public int getLineIndex() {
        return this.lineIndex;
    }

    public int getLineItemCount() {
        return this.mainAxisSizes.size();
    }

    public int getMainAxisSize(int arg1) {
        return this.mainAxisSizes.get(arg1).intValue();
    }
}

