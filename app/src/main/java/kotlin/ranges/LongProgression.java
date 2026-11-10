package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B!\b@\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0082\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001A\u00020\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010\u0015\u001A\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004R\u0015\u0010\b\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0015\u0010\u000B\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001A\u00020\u0002X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001A"}, d2={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "<init>", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "iterator", "Lkotlin/collections/LongIterator;", "isEmpty", "", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class LongProgression implements Iterable, KMappedMarker {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0086\u0080\u0004¨\u0006\n"}, d2={"Lkotlin/ranges/LongProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final LongProgression fromClosedRange(long arg1, long arg3, long arg5) {
            return new LongProgression(arg1, arg3, arg5);
        }
    }

    public static final Companion Companion;
    private final long first;
    private final long last;
    private final long step;

    static {
        LongProgression.Companion = new Companion(null);
    }

    public LongProgression(long arg3, long arg5, long arg7) {
        super();
        if(arg7 != 0) {
            if(arg7 != -9223372036854775808L) {
                this.first = arg3;
                this.last = ProgressionUtilKt.getProgressionLastElement(arg3, arg5, arg7);
                this.step = arg7;
                return;
            }

            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }

        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object arg5) {
        if((arg5 instanceof LongProgression)) {
            if(!this.isEmpty() || !arg5.isEmpty()) {
                if(this.first != ((LongProgression)arg5).first) {
                }
                else if(this.last != ((LongProgression)arg5).last) {
                }
                else if(this.step == ((LongProgression)arg5).step) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return ((int)(0x1F * ((this.first ^ this.first >>> 0x20) * 0x1F + (this.last ^ this.last >>> 0x20)) + (this.step ^ this.step >>> 0x20)));
    }

    public boolean isEmpty() {
        int v0 = Long.compare(this.step, 0);
        int v7 = Long.compare(this.first, this.last);
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

    public Iterator iterator() {
        return this.iterator();
    }

    public LongIterator iterator() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        StringBuilder v0_1;
        int v0 = Long.compare(this.step, 0);
        long v1 = this.first;
        String v3 = " step ";
        if(v0 > 0) {
            v0_1 = new StringBuilder().append(v1).append("..").append(this.last).append(v3);
            v1 = this.step;
        }
        else {
            v0_1 = new StringBuilder().append(v1).append(" downTo ").append(this.last).append(v3);
            v1 = -this.step;
        }

        return v0_1.append(v1).toString();
    }
}

