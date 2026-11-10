package androidx.compose.foundation.lazy;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/LazyListPrefetchResultScopeImpl;", "Landroidx/compose/foundation/lazy/LazyListPrefetchResultScope;", "index", "", "mainAxisSize", "<init>", "(II)V", "getIndex", "()I", "getMainAxisSize", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListPrefetchResultScopeImpl implements LazyListPrefetchResultScope {
    public static final int $stable;
    private final int index;
    private final int mainAxisSize;

    static {
    }

    public LazyListPrefetchResultScopeImpl(int arg1, int arg2) {
        super();
        this.index = arg1;
        this.mainAxisSize = arg2;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMainAxisSize() {
        return this.mainAxisSize;
    }
}

