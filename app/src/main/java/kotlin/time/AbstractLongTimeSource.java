package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001A\u00020\tH¤\u0080\u0004J\n\u0010\u000F\u001A\u00020\tH\u0082\u0080\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\n\u001A\u00020\t8BX\u0082\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000B\u0010\f¨\u0006\u0013"}, d2={"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractLongTimeSource implements WithComparableMarks {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000B\u001A\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001A\u00020\u00172\b\u0010\u0013\u001A\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001D"}, d2={"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public LongTimeMark(long arg1, AbstractLongTimeSource arg3, long arg4, DefaultConstructorMarker arg6) {
            this(arg1, arg3, arg4);
        }

        private LongTimeMark(long arg2, AbstractLongTimeSource arg4, long arg5) {
            Intrinsics.checkNotNullParameter(arg4, "timeSource");
            super();
            this.startedAt = arg2;
            this.timeSource = arg4;
            this.offset = arg5;
        }

        public int compareTo(Object arg1) {
            return this.compareTo(((ComparableTimeMark)arg1));
        }

        public int compareTo(ComparableTimeMark arg1) {
            return DefaultImpls.compareTo(((ComparableTimeMark)this), arg1);
        }

        public long elapsedNow-UwyO8pc() {
            return Duration.minus-LRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        public boolean equals(Object arg3) {
            if(((arg3 instanceof LongTimeMark)) && (Intrinsics.areEqual(this.timeSource, arg3.timeSource)) && (Duration.equals-impl0(this.minus-UwyO8pc(((ComparableTimeMark)arg3)), Duration.Companion.getZERO-UwyO8pc()))) {
                return 1;
            }

            return 0;
        }

        public boolean hasNotPassedNow() {
            return DefaultImpls.hasNotPassedNow(((ComparableTimeMark)this));
        }

        public boolean hasPassedNow() {
            return DefaultImpls.hasPassedNow(((ComparableTimeMark)this));
        }

        public int hashCode() {
            return Duration.hashCode-impl(this.offset) * 37 + Long.hashCode(this.startedAt);
        }

        public ComparableTimeMark minus-LRDsOJo(long arg1) {
            return DefaultImpls.minus-LRDsOJo(((ComparableTimeMark)this), arg1);
        }

        public TimeMark minus-LRDsOJo(long arg1) {
            return this.minus-LRDsOJo(arg1);
        }

        public long minus-UwyO8pc(ComparableTimeMark arg7) {
            Intrinsics.checkNotNullParameter(arg7, "other");
            if((arg7 instanceof LongTimeMark)) {
                ComparableTimeMark v1 = arg7;
                if(Intrinsics.areEqual(this.timeSource, ((LongTimeMark)v1).timeSource)) {
                    return Duration.plus-LRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, ((LongTimeMark)v1).startedAt, this.timeSource.getUnit()), Duration.minus-LRDsOJo(this.offset, ((LongTimeMark)v1).offset));
                }
            }

            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + arg7);
        }

        public ComparableTimeMark plus-LRDsOJo(long arg11) {
            DurationUnit v0 = this.timeSource.getUnit();
            if(Duration.isInfinite-impl(arg11)) {
                return new LongTimeMark(LongSaturatedMathKt.saturatingAdd-NuflL3o(this.startedAt, v0, arg11), this.timeSource, Duration.Companion.getZERO-UwyO8pc(), null);
            }

            long v1 = Duration.truncateTo-UwyO8pc$kotlin_stdlib(arg11, v0);
            arg11 = Duration.plus-LRDsOJo(Duration.minus-LRDsOJo(arg11, v1), this.offset);
            v1 = LongSaturatedMathKt.saturatingAdd-NuflL3o(this.startedAt, v0, v1);
            long v3 = Duration.truncateTo-UwyO8pc$kotlin_stdlib(arg11, v0);
            v1 = LongSaturatedMathKt.saturatingAdd-NuflL3o(v1, v0, v3);
            arg11 = Duration.minus-LRDsOJo(arg11, v3);
            v3 = Duration.getInWholeNanoseconds-impl(arg11);
            long v5 = 0;
            if(v1 != v5 && v3 != v5 && (v1 ^ v3) < v5) {
                v3 = DurationKt.toDuration(MathKt.getSign(v3), v0);
                v1 = LongSaturatedMathKt.saturatingAdd-NuflL3o(v1, v0, v3);
                arg11 = Duration.minus-LRDsOJo(arg11, v3);
            }

            if((1 | v1 - 1) == 0x7FFFFFFFFFFFFFFFL) {
                arg11 = Duration.Companion.getZERO-UwyO8pc();
            }

            return new LongTimeMark(v1, this.timeSource, arg11, null);
        }

        public TimeMark plus-LRDsOJo(long arg1) {
            return this.plus-LRDsOJo(arg1);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.toString-impl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    private final DurationUnit unit;
    private final Lazy zero$delegate;

    public AbstractLongTimeSource(DurationUnit arg2) {
        Intrinsics.checkNotNullParameter(arg2, "unit");
        super();
        this.unit = arg2;
        this.zero$delegate = LazyKt.lazy(new AbstractLongTimeSource$$ExternalSyntheticLambda0(this));
    }

    public static final long access$adjustedRead(AbstractLongTimeSource arg2) {
        return arg2.adjustedRead();
    }

    private final long adjustedRead() {
        return this.read() - this.getZero();
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return this.zero$delegate.getValue().longValue();
    }

    public ComparableTimeMark markNow() {
        return new LongTimeMark(this.adjustedRead(), this, Duration.Companion.getZERO-UwyO8pc(), null);
    }

    public TimeMark markNow() {
        return this.markNow();
    }

    protected abstract long read();

    static final long zero_delegate$lambda$0(AbstractLongTimeSource arg2) {
        return arg2.read();
    }
}

