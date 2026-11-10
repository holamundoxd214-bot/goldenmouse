package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001AB!\b@\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0082\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001A\u00020\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004R\u0015\u0010\t\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\f\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "<init>", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "iterator", "Lkotlin/collections/CharIterator;", "isEmpty", "", "equals", "other", "", "hashCode", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class CharProgression implements Iterable, KMappedMarker {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0086\u0080\u0004¨\u0006\u000B"}, d2={"Lkotlin/ranges/CharProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CharProgression fromClosedRange(char arg1, char arg2, int arg3) {
            return new CharProgression(arg1, arg2, arg3);
        }
    }

    public static final Companion Companion;
    private final char first;
    private final char last;
    private final int step;

    static {
        CharProgression.Companion = new Companion(null);
    }

    public CharProgression(char arg2, char arg3, int arg4) {
        super();
        if(arg4 != 0) {
            if(arg4 != 0x80000000) {
                this.first = arg2;
                this.last = ((char)ProgressionUtilKt.getProgressionLastElement(arg2, arg3, arg4));
                this.step = arg4;
                return;
            }

            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }

        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object arg3) {
        if((arg3 instanceof CharProgression)) {
            if(!this.isEmpty() || !arg3.isEmpty()) {
                if(this.first != ((CharProgression)arg3).first) {
                }
                else if(this.last != ((CharProgression)arg3).last) {
                }
                else if(this.step == ((CharProgression)arg3).step) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return (this.first * 0x1F + this.last) * 0x1F + this.step;
    }

    public boolean isEmpty() {
        int v0 = this.step;
        int v4 = Intrinsics.compare(this.first, this.last);
        if(v0 > 0) {
            if(v4 > 0) {
                return 1;
            }

            return 0;
        }

        if(v4 < 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this.iterator();
    }

    public CharIterator iterator() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        int v3;
        StringBuilder v0_1;
        int v0 = this.step;
        char v1 = this.first;
        String v2 = " step ";
        if(v0 > 0) {
            v0_1 = new StringBuilder().append(v1).append("..").append(this.last).append(v2);
            v3 = this.step;
        }
        else {
            v0_1 = new StringBuilder().append(v1).append(" downTo ").append(this.last).append(v2);
            v3 = -this.step;
        }

        return v0_1.append(v3).toString();
    }
}

