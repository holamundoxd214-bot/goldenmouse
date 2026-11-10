package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/pager/PagerSnapDistanceMaxPages;", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pagesLimit", "", "<init>", "(I)V", "calculateTargetPage", "startPage", "suggestedTargetPage", "velocity", "", "pageSize", "pageSpacing", "equals", "", "other", "", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    public static final int $stable;
    private final int pagesLimit;

    static {
    }

    public PagerSnapDistanceMaxPages(int arg1) {
        super();
        this.pagesLimit = arg1;
    }

    public int calculateTargetPage(int arg5, int arg6, float arg7, int arg8, int arg9) {
        long v7 = ((long)arg5);
        return RangesKt.coerceIn(arg6, ((int)RangesKt.coerceAtLeast(v7 - (((long)this.pagesLimit)), 0)), ((int)RangesKt.coerceAtMost(v7 + (((long)this.pagesLimit)), 0x7FFFFFFF)));
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof PagerSnapDistanceMaxPages)) && this.pagesLimit == ((PagerSnapDistanceMaxPages)arg3).pagesLimit) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Integer.hashCode(this.pagesLimit);
    }
}

