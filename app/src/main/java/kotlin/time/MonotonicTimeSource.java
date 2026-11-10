package kotlin.time;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001A\u00020\u0005H\u0082\u0080\u0004J\n\u0010\u0007\u001A\u00020\bH\u0096\u0080\u0004J\u0011\u0010\t\u001A\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u000EH\u0086\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u0016R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "zero", "", "read", "toString", "", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "elapsedFrom", "Lkotlin/time/Duration;", "timeMark", "elapsedFrom-6eNON_k", "(J)J", "differenceBetween", "one", "another", "differenceBetween-fRLX17w", "(JJ)J", "adjustReading", "duration", "adjustReading-6QKq23U", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MonotonicTimeSource implements WithComparableMarks {
    public static final MonotonicTimeSource INSTANCE;
    private static final long zero;

    static {
        MonotonicTimeSource.INSTANCE = new MonotonicTimeSource();
        MonotonicTimeSource.zero = System.nanoTime();
    }

    private MonotonicTimeSource() {
        super();
    }

    public final long adjustReading-6QKq23U(long arg1, long arg3) {
        return ValueTimeMark.constructor-impl(LongSaturatedMathKt.saturatingAdd-NuflL3o(arg1, DurationUnit.NANOSECONDS, arg3));
    }

    public final long differenceBetween-fRLX17w(long arg1, long arg3) {
        return LongSaturatedMathKt.saturatingOriginsDiff(arg1, arg3, DurationUnit.NANOSECONDS);
    }

    public final long elapsedFrom-6eNON_k(long arg3) {
        return LongSaturatedMathKt.saturatingDiff(this.read(), arg3, DurationUnit.NANOSECONDS);
    }

    public ComparableTimeMark markNow() {
        return ValueTimeMark.box-impl(this.markNow-z9LOYto());
    }

    public TimeMark markNow() {
        return ValueTimeMark.box-impl(this.markNow-z9LOYto());
    }

    public long markNow-z9LOYto() {
        return ValueTimeMark.constructor-impl(this.read());
    }

    private final long read() {
        return System.nanoTime() - MonotonicTimeSource.zero;
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}

