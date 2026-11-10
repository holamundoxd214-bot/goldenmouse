package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001DB\u0019\bF\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0015\u001A\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0016\u001A\u00020\u00112\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u001B\u0010\f\u001A\u00020\u00038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\n¨\u0006\u001E"}, d2={"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ULongRange extends ULongProgression implements ClosedRange, OpenEndRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/ranges/ULongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }

    public static final Companion Companion;
    private static final ULongRange EMPTY;

    static {
        ULongRange.Companion = new Companion(null);
        ULongRange.EMPTY = new ULongRange(-1, 0, null);
    }

    public ULongRange(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    private ULongRange(long arg9, long arg11) {
        super(arg9, arg11, 1, null);
    }

    public static final ULongRange access$getEMPTY$cp() {
        return ULongRange.EMPTY;
    }

    public boolean contains(Comparable arg3) {
        return this.contains-VKZWuLQ(((ULong)arg3).unbox-impl());
    }

    public boolean contains-VKZWuLQ(long arg3) {
        if(Long.compareUnsigned(this.getFirst-s-VKNKU(), arg3) <= 0 && Long.compareUnsigned(arg3, this.getLast-s-VKNKU()) <= 0) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object arg5) {
        if((arg5 instanceof ULongRange)) {
            if(!this.isEmpty() || !arg5.isEmpty()) {
                if(this.getFirst-s-VKNKU() != ((ULongRange)arg5).getFirst-s-VKNKU()) {
                }
                else if(this.getLast-s-VKNKU() == ((ULongRange)arg5).getLast-s-VKNKU()) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public Comparable getEndExclusive() {
        return ULong.box-impl(this.getEndExclusive-s-VKNKU());
    }

    public long getEndExclusive-s-VKNKU() {
        if(this.getLast-s-VKNKU() != -1) {
            return ULong.constructor-impl(this.getLast-s-VKNKU() + ULong.constructor-impl(1));
        }

        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Deprecated(message="Can throw an exception when it\'s impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It\'s recommended to use \'endInclusive\' property that doesn\'t throw.") public static void getEndExclusive-s-VKNKU$annotations() {
    }

    public Comparable getEndInclusive() {
        return ULong.box-impl(this.getEndInclusive-s-VKNKU());
    }

    public long getEndInclusive-s-VKNKU() {
        return this.getLast-s-VKNKU();
    }

    public Comparable getStart() {
        return ULong.box-impl(this.getStart-s-VKNKU());
    }

    public long getStart-s-VKNKU() {
        return this.getFirst-s-VKNKU();
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return (((int)ULong.constructor-impl(this.getFirst-s-VKNKU() ^ ULong.constructor-impl(this.getFirst-s-VKNKU() >>> 0x20)))) * 0x1F + (((int)ULong.constructor-impl(this.getLast-s-VKNKU() ^ ULong.constructor-impl(this.getLast-s-VKNKU() >>> 0x20))));
    }

    public boolean isEmpty() {
        if(Long.compareUnsigned(this.getFirst-s-VKNKU(), this.getLast-s-VKNKU()) > 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return ULong.toString-impl(this.getFirst-s-VKNKU()) + ".." + ULong.toString-impl(this.getLast-s-VKNKU());
    }
}

