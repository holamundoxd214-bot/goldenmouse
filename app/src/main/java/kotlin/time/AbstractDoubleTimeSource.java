package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(level=DeprecationLevel.ERROR, message="Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.") @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001A\u00020\tH¤\u0080\u0004J\n\u0010\n\u001A\u00020\u000BH\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "markNow", "Lkotlin/time/ComparableTimeMark;", "DoubleTimeMark", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractDoubleTimeSource implements WithComparableMarks {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000B\u001A\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001A\u00020\u00172\b\u0010\u0013\u001A\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001D"}, d2={"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        public DoubleTimeMark(double arg1, AbstractDoubleTimeSource arg3, long arg4, DefaultConstructorMarker arg6) {
            this(arg1, arg3, arg4);
        }

        private DoubleTimeMark(double arg2, AbstractDoubleTimeSource arg4, long arg5) {
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
            return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        public boolean equals(Object arg3) {
            if(((arg3 instanceof DoubleTimeMark)) && (Intrinsics.areEqual(this.timeSource, arg3.timeSource)) && (Duration.equals-impl0(this.minus-UwyO8pc(((ComparableTimeMark)arg3)), Duration.Companion.getZERO-UwyO8pc()))) {
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
            return Duration.hashCode-impl(Duration.plus-LRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        public ComparableTimeMark minus-LRDsOJo(long arg1) {
            return DefaultImpls.minus-LRDsOJo(((ComparableTimeMark)this), arg1);
        }

        public TimeMark minus-LRDsOJo(long arg1) {
            return this.minus-LRDsOJo(arg1);
        }

        public long minus-UwyO8pc(ComparableTimeMark arg7) {
            Intrinsics.checkNotNullParameter(arg7, "other");
            if((arg7 instanceof DoubleTimeMark)) {
                ComparableTimeMark v1 = arg7;
                if(Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark)v1).timeSource)) {
                    if((Duration.equals-impl0(this.offset, ((DoubleTimeMark)v1).offset)) && (Duration.isInfinite-impl(this.offset))) {
                        return Duration.Companion.getZERO-UwyO8pc();
                    }

                    long v2 = Duration.minus-LRDsOJo(this.offset, ((DoubleTimeMark)v1).offset);
                    long v6 = DurationKt.toDuration(this.startedAt - ((DoubleTimeMark)v1).startedAt, this.timeSource.getUnit());
                    if(Duration.equals-impl0(v6, Duration.unaryMinus-UwyO8pc(v2))) {
                        return Duration.Companion.getZERO-UwyO8pc();
                    }

                    return Duration.plus-LRDsOJo(v6, v2);
                }
            }

            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + arg7);
        }

        public ComparableTimeMark plus-LRDsOJo(long arg8) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, arg8), null);
        }

        public TimeMark plus-LRDsOJo(long arg1) {
            return this.plus-LRDsOJo(arg1);
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.toString-impl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    private final DurationUnit unit;

    public AbstractDoubleTimeSource(DurationUnit arg2) {
        Intrinsics.checkNotNullParameter(arg2, "unit");
        super();
        this.unit = arg2;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    public ComparableTimeMark markNow() {
        return new DoubleTimeMark(this.read(), this, Duration.Companion.getZERO-UwyO8pc(), null);
    }

    public TimeMark markNow() {
        return this.markNow();
    }

    protected abstract double read();
}

