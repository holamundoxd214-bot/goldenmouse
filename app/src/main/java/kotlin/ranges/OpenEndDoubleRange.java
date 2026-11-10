package kotlin.ranges;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0082\u0080\u0004J\u0012\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0002H\u0096\u0082\u0004J\n\u0010\u0012\u001A\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u0013\u001A\u00020\r2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001A\u00020\u0017H\u0096\u0080\u0004J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004R\u000F\u0010\u0007\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001A\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001A\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\n¨\u0006\u001A"}, d2={"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "<init>", "(DD)V", "_start", "_endExclusive", "getStart", "()Ljava/lang/Double;", "getEndExclusive", "lessThanOrEquals", "", "a", "b", "contains", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class OpenEndDoubleRange implements OpenEndRange {
    private final double _endExclusive;
    private final double _start;

    public OpenEndDoubleRange(double arg1, double arg3) {
        super();
        this._start = arg1;
        this._endExclusive = arg3;
    }

    public boolean contains(double arg3) {
        if(arg3 >= this._start && arg3 < this._endExclusive) {
            return 1;
        }

        return 0;
    }

    public boolean contains(Comparable arg3) {
        return this.contains(((Number)arg3).doubleValue());
    }

    public boolean equals(Object arg5) {
        if((arg5 instanceof OpenEndDoubleRange)) {
            if(!this.isEmpty() || !arg5.isEmpty()) {
                if(this._start != ((OpenEndDoubleRange)arg5)._start) {
                }
                else if(this._endExclusive == ((OpenEndDoubleRange)arg5)._endExclusive) {
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

    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    public Comparable getStart() {
        return this.getStart();
    }

    public Double getStart() {
        return Double.valueOf(this._start);
    }

    public int hashCode() {
        if(this.isEmpty()) {
            return -1;
        }

        return Double.hashCode(this._start) * 0x1F + Double.hashCode(this._endExclusive);
    }

    public boolean isEmpty() {
        if(this._start >= this._endExclusive) {
            return 1;
        }

        return 0;
    }

    private final boolean lessThanOrEquals(double arg1, double arg3) {
        if(arg1 <= arg3) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}

