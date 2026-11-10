package androidx.compose.foundation.lazy.layout;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H\u0017J\u0010\u0010\t\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H&J\u001F\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0017¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH&¢\u0006\u0004\b\u000F\u0010\rR\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "nestedPrefetchItemCount", "", "getNestedPrefetchItemCount", "()I", "schedulePrefetch", "", "index", "schedulePrecomposition", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)V", "schedulePrecompositionAndPremeasure", "schedulePrecompositionAndPremeasure-0kLqBqw", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface NestedPrefetchScope {
    default int getNestedPrefetchItemCount() {
        return -1;
    }

    void schedulePrecomposition(int arg1);

    void schedulePrecompositionAndPremeasure-0kLqBqw(int arg1, long arg2);

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use schedulePrecomposition(index) instead") default void schedulePrefetch(int arg1) {
        this.schedulePrecomposition(arg1);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use schedulePremeasure(index, constraints) instead") default void schedulePrefetch-0kLqBqw(int arg1, long arg2) {
        this.schedulePrecompositionAndPremeasure-0kLqBqw(arg1, arg2);
    }
}

