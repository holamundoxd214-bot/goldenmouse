package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\t\bB¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0080\u0004J+\u0010\u000B\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004H\u0086\u0080\u0004¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "reversed", "()Ljava/util/Comparator;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReverseOrderComparator implements Comparator {
    public static final ReverseOrderComparator INSTANCE;

    static {
        ReverseOrderComparator.INSTANCE = new ReverseOrderComparator();
    }

    private ReverseOrderComparator() {
        super();
    }

    public int compare(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "a");
        Intrinsics.checkNotNullParameter(arg2, "b");
        return arg2.compareTo(arg1);
    }

    public int compare(Object arg1, Object arg2) {
        return this.compare(((Comparable)arg1), ((Comparable)arg2));
    }

    public final Comparator reversed() {
        return NaturalOrderComparator.INSTANCE;
    }
}

