package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0012\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\bF\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0082\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004R\u0017\u0010\u0004\u001A\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001A\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0014"}, d2={"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getStart", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getEndInclusive", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) class ComparableRange implements ClosedRange {
    private final Comparable endInclusive;
    private final Comparable start;

    public ComparableRange(Comparable arg2, Comparable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "start");
        Intrinsics.checkNotNullParameter(arg3, "endInclusive");
        super();
        this.start = arg2;
        this.endInclusive = arg3;
    }

    public boolean contains(Comparable arg1) {
        return DefaultImpls.contains(((ClosedRange)this), arg1);
    }

    public boolean equals(Object arg3) {
        if((arg3 instanceof ComparableRange)) {
            if(!this.isEmpty() || !arg3.isEmpty()) {
                if(!Intrinsics.areEqual(this.getStart(), ((ComparableRange)arg3).getStart())) {
                }
                else if(Intrinsics.areEqual(this.getEndInclusive(), ((ComparableRange)arg3).getEndInclusive())) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public Comparable getEndInclusive() {
        return this.endInclusive;
    }

    public Comparable getStart() {
        return this.start;
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return this.getStart().hashCode() * 0x1F + this.getEndInclusive().hashCode();
    }

    public boolean isEmpty() {
        return DefaultImpls.isEmpty(((ClosedRange)this));
    }

    public String toString() {
        return this.getStart() + ".." + this.getEndInclusive();
    }
}

