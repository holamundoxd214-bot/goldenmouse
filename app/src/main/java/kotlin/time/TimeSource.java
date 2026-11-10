package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\n\u0010\u0002\u001A\u00020\u0003H¦\u0080\u0004¨\u0006\u0007"}, d2={"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface TimeSource {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Lkotlin/time/TimeSource$Companion;", "", "<init>", "()V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001A\u00020\tH\u0096\u0080\u0004¨\u0006\u000B"}, d2={"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Monotonic implements WithComparableMarks {
        @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b@\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001A\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\u000B\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u000EJ\u0011\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001A\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001A\u0010\u000EJ\u0019\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001D\u0010\u001EJ\u0014\u0010\u001F\u001A\u00020\u00122\b\u0010\u0017\u001A\u0004\u0018\u00010 HÖ\u0083\u0004J\n\u0010!\u001A\u00020\u001CHÖ\u0081\u0004J\n\u0010\"\u001A\u00020#HÖ\u0081\u0004R\u0015\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006$"}, d2={"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", "", "compareTo-6eNON_k", "(JJ)I", "equals", "", "hashCode", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            private ValueTimeMark(long arg1) {
                super();
                this.reading = arg1;
            }

            public static final ValueTimeMark box-impl(long arg1) {
                return new ValueTimeMark(arg1);
            }

            public int compareTo(ComparableTimeMark arg1) {
                return DefaultImpls.compareTo(((ComparableTimeMark)this), arg1);
            }

            public int compareTo(Object arg1) {
                return this.compareTo(((ComparableTimeMark)arg1));
            }

            public static final int compareTo-6eNON_k(long arg0, long arg2) {
                return Duration.compareTo-LRDsOJo(ValueTimeMark.minus-6eNON_k(arg0, arg2), Duration.Companion.getZERO-UwyO8pc());
            }

            public static int compareTo-impl(long arg1, ComparableTimeMark arg3) {
                Intrinsics.checkNotNullParameter(arg3, "other");
                return ValueTimeMark.box-impl(arg1).compareTo(arg3);
            }

            public static long constructor-impl(long arg0) {
                return arg0;
            }

            public static long elapsedNow-UwyO8pc(long arg1) {
                return MonotonicTimeSource.INSTANCE.elapsedFrom-6eNON_k(arg1);
            }

            public long elapsedNow-UwyO8pc() {
                return ValueTimeMark.elapsedNow-UwyO8pc(this.reading);
            }

            public boolean equals(Object arg3) {
                return ValueTimeMark.equals-impl(this.reading, arg3);
            }

            public static boolean equals-impl(long arg4, Object arg6) {
                if(!(arg6 instanceof ValueTimeMark)) {
                    return 0;
                }

                if(arg4 != ((ValueTimeMark)arg6).unbox-impl()) {
                    return 0;
                }

                return 1;
            }

            public static final boolean equals-impl0(long arg0, long arg2) {
                if(arg0 == arg2) {
                    return 1;
                }

                return 0;
            }

            public boolean hasNotPassedNow() {
                return ValueTimeMark.hasNotPassedNow-impl(this.reading);
            }

            public static boolean hasNotPassedNow-impl(long arg0) {
                return Duration.isNegative-impl(ValueTimeMark.elapsedNow-UwyO8pc(arg0));
            }

            public boolean hasPassedNow() {
                return ValueTimeMark.hasPassedNow-impl(this.reading);
            }

            public static boolean hasPassedNow-impl(long arg0) {
                return Duration.isNegative-impl(ValueTimeMark.elapsedNow-UwyO8pc(arg0)) ^ 1;
            }

            public int hashCode() {
                return ValueTimeMark.hashCode-impl(this.reading);
            }

            public static int hashCode-impl(long arg0) {
                return Long.hashCode(arg0);
            }

            public static final long minus-6eNON_k(long arg1, long arg3) {
                return MonotonicTimeSource.INSTANCE.differenceBetween-fRLX17w(arg1, arg3);
            }

            public static long minus-LRDsOJo(long arg1, long arg3) {
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(arg1, Duration.unaryMinus-UwyO8pc(arg3));
            }

            public long minus-LRDsOJo(long arg3) {
                return ValueTimeMark.minus-LRDsOJo(this.reading, arg3);
            }

            public ComparableTimeMark minus-LRDsOJo(long arg1) {
                return ValueTimeMark.box-impl(this.minus-LRDsOJo(arg1));
            }

            public TimeMark minus-LRDsOJo(long arg1) {
                return ValueTimeMark.box-impl(this.minus-LRDsOJo(arg1));
            }

            public static long minus-UwyO8pc(long arg3, ComparableTimeMark arg5) {
                Intrinsics.checkNotNullParameter(arg5, "other");
                if((arg5 instanceof ValueTimeMark)) {
                    return ValueTimeMark.minus-6eNON_k(arg3, ((ValueTimeMark)arg5).unbox-impl());
                }

                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ValueTimeMark.toString-impl(arg3) + " and " + arg5);
            }

            public long minus-UwyO8pc(ComparableTimeMark arg3) {
                Intrinsics.checkNotNullParameter(arg3, "other");
                return ValueTimeMark.minus-UwyO8pc(this.reading, arg3);
            }

            public static long plus-LRDsOJo(long arg1, long arg3) {
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(arg1, arg3);
            }

            public long plus-LRDsOJo(long arg3) {
                return ValueTimeMark.plus-LRDsOJo(this.reading, arg3);
            }

            public ComparableTimeMark plus-LRDsOJo(long arg1) {
                return ValueTimeMark.box-impl(this.plus-LRDsOJo(arg1));
            }

            public TimeMark plus-LRDsOJo(long arg1) {
                return ValueTimeMark.box-impl(this.plus-LRDsOJo(arg1));
            }

            public String toString() {
                return ValueTimeMark.toString-impl(this.reading);
            }

            public static String toString-impl(long arg2) {
                return "ValueTimeMark(reading=" + arg2 + ')';
            }

            public final long unbox-impl() {
                return this.reading;
            }
        }

        public static final Monotonic INSTANCE;

        static {
            Monotonic.INSTANCE = new Monotonic();
        }

        private Monotonic() {
            super();
        }

        public ComparableTimeMark markNow() {
            return ValueTimeMark.box-impl(this.markNow-z9LOYto());
        }

        public TimeMark markNow() {
            return ValueTimeMark.box-impl(this.markNow-z9LOYto());
        }

        public long markNow-z9LOYto() {
            return MonotonicTimeSource.INSTANCE.markNow-z9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001A\u00020\u0003H¦\u0080\u0004¨\u0006\u0004"}, d2={"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface WithComparableMarks extends TimeSource {
        ComparableTimeMark markNow();
    }

    public static final Companion Companion;

    static {
        TimeSource.Companion = Companion.$$INSTANCE;
    }

    TimeMark markNow();
}

