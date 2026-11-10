package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \u001B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001BB\u0019\bF\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0003H\u0096\u0082\u0004J\n\u0010\u0013\u001A\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0014\u001A\u00020\u00112\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001A\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u001B\u0010\f\u001A\u00020\u00038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\n¨\u0006\u001C"}, d2={"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(CC)V", "getStart", "()Ljava/lang/Character;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "contains", "", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class CharRange extends CharProgression implements ClosedRange, OpenEndRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/ranges/CharRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CharRange getEMPTY() {
            return CharRange.EMPTY;
        }
    }

    public static final Companion Companion;
    private static final CharRange EMPTY;

    static {
        CharRange.Companion = new Companion(null);
        CharRange.EMPTY = new CharRange('\u0001', '\u0000');
    }

    public CharRange(char arg2, char arg3) {
        super(arg2, arg3, 1);
    }

    public static final CharRange access$getEMPTY$cp() {
        return CharRange.EMPTY;
    }

    public boolean contains(char arg2) {
        if(Intrinsics.compare(this.getFirst(), arg2) <= 0 && Intrinsics.compare(arg2, this.getLast()) <= 0) {
            return 1;
        }

        return 0;
    }

    public boolean contains(Comparable arg1) {
        return this.contains(((Character)arg1).charValue());
    }

    public boolean equals(Object arg3) {
        if((arg3 instanceof CharRange)) {
            if(!this.isEmpty() || !arg3.isEmpty()) {
                if(this.getFirst() != ((CharRange)arg3).getFirst()) {
                }
                else if(this.getLast() == ((CharRange)arg3).getLast()) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public Character getEndExclusive() {
        if(this.getLast() != 0xFFFF) {
            return Character.valueOf(((char)(this.getLast() + 1)));
        }

        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public Comparable getEndExclusive() {
        return this.getEndExclusive();
    }

    @Deprecated(message="Can throw an exception when it\'s impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It\'s recommended to use \'endInclusive\' property that doesn\'t throw.") public static void getEndExclusive$annotations() {
    }

    public Character getEndInclusive() {
        return Character.valueOf(this.getLast());
    }

    public Comparable getEndInclusive() {
        return this.getEndInclusive();
    }

    public Character getStart() {
        return Character.valueOf(this.getFirst());
    }

    public Comparable getStart() {
        return this.getStart();
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return this.getFirst() * 0x1F + this.getLast();
    }

    public boolean isEmpty() {
        if(Intrinsics.compare(this.getFirst(), this.getLast()) > 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this.getFirst() + ".." + this.getLast();
    }
}

