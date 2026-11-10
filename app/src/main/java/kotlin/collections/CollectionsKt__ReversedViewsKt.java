package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u001A\u001F\u0010\u0000\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0004\u001A\u001F\u0010\u0005\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0006\u001A\u001F\u0010\u0007\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\b\u001A \u0010\t\u001A\b\u0012\u0004\u0012\u0002H\n0\u0002\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0002H\u0086\u0080\u0004\u001A%\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\n0\u000B\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000BH\u0087\u0080\u0004¢\u0006\u0002\b\f¨\u0006\r"}, d2={"reverseElementIndex", "", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "asReversed", "T", "", "asReversedMutable", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public CollectionsKt__ReversedViewsKt() {
        super();
    }

    public static final int access$reverseElementIndex(List arg0, int arg1) {
        return CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(arg0, arg1);
    }

    public static final int access$reverseIteratorIndex(List arg0, int arg1) {
        return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(arg0, arg1);
    }

    public static final int access$reversePositionIndex(List arg0, int arg1) {
        return CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(arg0, arg1);
    }

    public static final List asReversed(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ReversedListReadOnly(arg1);
    }

    public static final List asReversedMutable(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ReversedList(arg1);
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List arg3, int arg4) {
        if(arg4 >= 0 && arg4 <= CollectionsKt.getLastIndex(arg3)) {
            return CollectionsKt.getLastIndex(arg3) - arg4;
        }

        throw new IndexOutOfBoundsException("Element index " + arg4 + " must be in range [" + new IntRange(0, CollectionsKt.getLastIndex(arg3)) + "].");
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List arg0, int arg1) {
        return CollectionsKt.getLastIndex(arg0) - arg1;
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List arg3, int arg4) {
        if(arg4 >= 0 && arg4 <= arg3.size()) {
            return arg3.size() - arg4;
        }

        throw new IndexOutOfBoundsException("Position index " + arg4 + " must be in range [" + new IntRange(0, arg3.size()) + "].");
    }
}

