package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000F\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u0002H\u0086\f¢\u0006\u0002\u0010\u0005\u001A6\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0007\u001A\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\b\u001A7\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\n\u001A7\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\f\u001A&\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001A&\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f¨\u0006\u000E"}, d2={"rangeTo", "Landroid/util/Range;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "other", "and", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RangeKt {
    public static final Range and(Range arg1, Range arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.intersect(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "intersect(...)");
        return arg1;
    }

    public static final Range plus(Range arg1, Range arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.extend(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "extend(...)");
        return arg1;
    }

    public static final Range plus(Range arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = arg1.extend(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "extend(...)");
        return arg1;
    }

    public static final Range rangeTo(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "that");
        return new Range(arg1, arg2);
    }

    public static final ClosedRange toClosedRange(Range arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new RangeKt$toClosedRange$1(arg1);
    }

    public static final Range toRange(ClosedRange arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Range(arg2.getStart(), arg2.getEndInclusive());
    }
}

