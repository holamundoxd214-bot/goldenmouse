package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.IntervalList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridInterval;", "<init>", "(Landroidx/compose/foundation/lazy/layout/IntervalList;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "isFullSpan", "", "itemIndex", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridSpanProvider {
    public static final int $stable = 8;
    private final IntervalList intervals;

    static {
    }

    public LazyStaggeredGridSpanProvider(IntervalList arg1) {
        super();
        this.intervals = arg1;
    }

    public final IntervalList getIntervals() {
        return this.intervals;
    }

    public final boolean isFullSpan(int arg3) {
        if(arg3 >= 0 && arg3 < this.intervals.getSize()) {
            Interval v2 = this.intervals.get(arg3);
            Function1 v1 = v2.getValue().getSpan();
            arg3 -= v2.getStartIndex();
            if(v1 != null && v1.invoke(Integer.valueOf(arg3)) == StaggeredGridItemSpan.Companion.getFullLine()) {
                return 1;
            }
        }

        return 0;
    }
}

