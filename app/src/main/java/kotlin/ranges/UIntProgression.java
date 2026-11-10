package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001AB!\b@\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0086\u0082\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001A\u00020\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004R\u0017\u0010\t\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\r\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u001B"}, d2={"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "iterator", "", "isEmpty", "", "equals", "other", "", "hashCode", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class UIntProgression implements Iterable, KMappedMarker {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Lkotlin/ranges/UIntProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final UIntProgression fromClosedRange-Nkh28Cs(int arg2, int arg3, int arg4) {
            return new UIntProgression(arg2, arg3, arg4, null);
        }
    }

    public static final Companion Companion;
    private final int first;
    private final int last;
    private final int step;

    static {
        UIntProgression.Companion = new Companion(null);
    }

    private UIntProgression(int arg2, int arg3, int arg4) {
        super();
        if(arg4 != 0) {
            if(arg4 != 0x80000000) {
                this.first = arg2;
                this.last = UProgressionUtilKt.getProgressionLastElement-Nkh28Cs(arg2, arg3, arg4);
                this.step = arg4;
                return;
            }

            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }

        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public UIntProgression(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public boolean equals(Object arg3) {
        if((arg3 instanceof UIntProgression)) {
            if(!this.isEmpty() || !arg3.isEmpty()) {
                if(this.first != ((UIntProgression)arg3).first) {
                }
                else if(this.last != ((UIntProgression)arg3).last) {
                }
                else if(this.step == ((UIntProgression)arg3).step) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final int getFirst-pVg5ArA() {
        return this.first;
    }

    public final int getLast-pVg5ArA() {
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
        int v4 = Integer.compareUnsigned(this.first, this.last);
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

    public final Iterator iterator() {
        return new UIntProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        int v3;
        StringBuilder v0_1;
        int v0 = this.step;
        int v1 = this.first;
        String v2 = " step ";
        if(v0 > 0) {
            v0_1 = new StringBuilder().append(UInt.toString-impl(v1)).append("..").append(UInt.toString-impl(this.last)).append(v2);
            v3 = this.step;
        }
        else {
            v0_1 = new StringBuilder().append(UInt.toString-impl(v1)).append(" downTo ").append(UInt.toString-impl(this.last)).append(v2);
            v3 = -this.step;
        }

        return v0_1.append(v3).toString();
    }
}

