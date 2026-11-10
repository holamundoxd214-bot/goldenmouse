package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001DB\u0019\bF\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0015\u001A\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0016\u001A\u00020\u00112\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u001B\u0010\f\u001A\u00020\u00038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\n¨\u0006\u001E"}, d2={"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class UIntRange extends UIntProgression implements ClosedRange, OpenEndRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/ranges/UIntRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }

    public static final Companion Companion;
    private static final UIntRange EMPTY;

    static {
        UIntRange.Companion = new Companion(null);
        UIntRange.EMPTY = new UIntRange(-1, 0, null);
    }

    public UIntRange(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private UIntRange(int arg3, int arg4) {
        super(arg3, arg4, 1, null);
    }

    public static final UIntRange access$getEMPTY$cp() {
        return UIntRange.EMPTY;
    }

    public boolean contains(Comparable arg1) {
        return this.contains-WZ4Q5Ns(((UInt)arg1).unbox-impl());
    }

    public boolean contains-WZ4Q5Ns(int arg2) {
        if(Integer.compareUnsigned(this.getFirst-pVg5ArA(), arg2) <= 0 && Integer.compareUnsigned(arg2, this.getLast-pVg5ArA()) <= 0) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object arg3) {
        if((arg3 instanceof UIntRange)) {
            if(!this.isEmpty() || !arg3.isEmpty()) {
                if(this.getFirst-pVg5ArA() != ((UIntRange)arg3).getFirst-pVg5ArA()) {
                }
                else if(this.getLast-pVg5ArA() == ((UIntRange)arg3).getLast-pVg5ArA()) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public Comparable getEndExclusive() {
        return UInt.box-impl(this.getEndExclusive-pVg5ArA());
    }

    public int getEndExclusive-pVg5ArA() {
        if(this.getLast-pVg5ArA() != -1) {
            return UInt.constructor-impl(this.getLast-pVg5ArA() + 1);
        }

        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Deprecated(message="Can throw an exception when it\'s impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It\'s recommended to use \'endInclusive\' property that doesn\'t throw.") public static void getEndExclusive-pVg5ArA$annotations() {
    }

    public Comparable getEndInclusive() {
        return UInt.box-impl(this.getEndInclusive-pVg5ArA());
    }

    public int getEndInclusive-pVg5ArA() {
        return this.getLast-pVg5ArA();
    }

    public Comparable getStart() {
        return UInt.box-impl(this.getStart-pVg5ArA());
    }

    public int getStart-pVg5ArA() {
        return this.getFirst-pVg5ArA();
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return this.getFirst-pVg5ArA() * 0x1F + this.getLast-pVg5ArA();
    }

    public boolean isEmpty() {
        if(Integer.compareUnsigned(this.getFirst-pVg5ArA(), this.getLast-pVg5ArA()) > 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return UInt.toString-impl(this.getFirst-pVg5ArA()) + ".." + UInt.toString-impl(this.getLast-pVg5ArA());
    }
}

