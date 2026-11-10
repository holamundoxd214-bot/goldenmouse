package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B!\bF\u0012\u0016\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u000EJ\u001F\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\bR\'\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2={"Lkotlin/comparisons/ReversedComparator;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "<init>", "(Ljava/util/Comparator;)V", "getComparator", "()Ljava/util/Comparator;", "Ljava/util/Comparator;", "compare", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReversedComparator implements Comparator {
    private final Comparator comparator;

    public ReversedComparator(Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        super();
        this.comparator = arg2;
    }

    public int compare(Object arg1, Object arg2) {
        return this.comparator.compare(arg2, arg1);
    }

    public final Comparator getComparator() {
        return this.comparator;
    }

    public final Comparator reversed() {
        return this.comparator;
    }
}

