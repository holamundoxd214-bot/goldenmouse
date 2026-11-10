package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001BB!\b@\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0086\u0082\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001A\u00020\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004R\u0017\u0010\t\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\r\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u001C"}, d2={"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "iterator", "", "isEmpty", "", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class ULongProgression implements Iterable, KMappedMarker {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Lkotlin/ranges/ULongProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ULongProgression fromClosedRange-7ftBX0g(long arg9, long arg11, long arg13) {
            return new ULongProgression(arg9, arg11, arg13, null);
        }
    }

    public static final Companion Companion;
    private final long first;
    private final long last;
    private final long step;

    static {
        ULongProgression.Companion = new Companion(null);
    }

    private ULongProgression(long arg3, long arg5, long arg7) {
        super();
        if(arg7 != 0) {
            if(arg7 != -9223372036854775808L) {
                this.first = arg3;
                this.last = UProgressionUtilKt.getProgressionLastElement-7ftBX0g(arg3, arg5, arg7);
                this.step = arg7;
                return;
            }

            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }

        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public ULongProgression(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    public boolean equals(Object arg5) {
        if((arg5 instanceof ULongProgression)) {
            if(!this.isEmpty() || !arg5.isEmpty()) {
                if(this.first != ((ULongProgression)arg5).first) {
                }
                else if(this.last != ((ULongProgression)arg5).last) {
                }
                else if(this.step == ((ULongProgression)arg5).step) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final long getFirst-s-VKNKU() {
        return this.first;
    }

    public final long getLast-s-VKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return ((((int)ULong.constructor-impl(this.first ^ ULong.constructor-impl(this.first >>> 0x20)))) * 0x1F + (((int)ULong.constructor-impl(this.last ^ ULong.constructor-impl(this.last >>> 0x20))))) * 0x1F + (((int)(this.step >>> 0x20 ^ this.step)));
    }

    public boolean isEmpty() {
        int v0 = Long.compare(this.step, 0);
        int v7 = Long.compareUnsigned(this.first, this.last);
        if(v0 > 0) {
            if(v7 > 0) {
                return 1;
            }

            return 0;
        }

        if(v7 < 0) {
            return 1;
        }

        return 0;
    }

    public final Iterator iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        StringBuilder v0_1;
        int v0 = Long.compare(this.step, 0);
        long v1 = this.first;
        String v3 = " step ";
        if(v0 > 0) {
            v0_1 = new StringBuilder().append(ULong.toString-impl(v1)).append("..").append(ULong.toString-impl(this.last)).append(v3);
            v1 = this.step;
        }
        else {
            v0_1 = new StringBuilder().append(ULong.toString-impl(v1)).append(" downTo ").append(ULong.toString-impl(this.last)).append(v3);
            v1 = -this.step;
        }

        return v0_1.append(v1).toString();
    }
}

