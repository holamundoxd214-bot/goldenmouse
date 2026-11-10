package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \u001B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001BB\u0019\bF\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0082\u0004J\n\u0010\u0013\u001A\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0014\u001A\u00020\u00112\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u001B\u0010\f\u001A\u00020\u00038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\n¨\u0006\u001C"}, d2={"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJ)V", "getStart", "()Ljava/lang/Long;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "contains", "", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class LongRange extends LongProgression implements ClosedRange, OpenEndRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/ranges/LongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final LongRange getEMPTY() {
            return LongRange.EMPTY;
        }
    }

    public static final Companion Companion;
    private static final LongRange EMPTY;

    static {
        LongRange.Companion = new Companion(null);
        LongRange.EMPTY = new LongRange(1, 0);
    }

    public LongRange(long arg8, long arg10) {
        super(arg8, arg10, 1);
    }

    public static final LongRange access$getEMPTY$cp() {
        return LongRange.EMPTY;
    }

    public boolean contains(long arg3) {
        if(this.getFirst() <= arg3 && arg3 <= this.getLast()) {
            return 1;
        }

        return 0;
    }

    public boolean contains(Comparable arg3) {
        return this.contains(((Number)arg3).longValue());
    }

    public boolean equals(Object arg5) {
        if((arg5 instanceof LongRange)) {
            if(!this.isEmpty() || !arg5.isEmpty()) {
                if(this.getFirst() != ((LongRange)arg5).getFirst()) {
                }
                else if(this.getLast() == ((LongRange)arg5).getLast()) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public Comparable getEndExclusive() {
        return this.getEndExclusive();
    }

    public Long getEndExclusive() {
        if(this.getLast() != 0x7FFFFFFFFFFFFFFFL) {
            return Long.valueOf(this.getLast() + 1);
        }

        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Deprecated(message="Can throw an exception when it\'s impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It\'s recommended to use \'endInclusive\' property that doesn\'t throw.") public static void getEndExclusive$annotations() {
    }

    public Comparable getEndInclusive() {
        return this.getEndInclusive();
    }

    public Long getEndInclusive() {
        return Long.valueOf(this.getLast());
    }

    public Comparable getStart() {
        return this.getStart();
    }

    public Long getStart() {
        return Long.valueOf(this.getFirst());
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return ((int)(0x1F * (this.getFirst() ^ this.getFirst() >>> 0x20) + (this.getLast() ^ this.getLast() >>> 0x20)));
    }

    public boolean isEmpty() {
        if(this.getFirst() > this.getLast()) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this.getFirst() + ".." + this.getLast();
    }
}

