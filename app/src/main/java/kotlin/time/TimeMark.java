package kotlin.time;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001A\u00020\u0003H¦\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u000B\u0010\tJ\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\n\u0010\u000E\u001A\u00020\rH\u0096\u0080\u0004¨\u0006\u000F"}, d2={"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasNotPassedNow", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface TimeMark {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static boolean hasNotPassedNow(TimeMark arg2) {
            return Duration.isNegative-impl(arg2.elapsedNow-UwyO8pc());
        }

        public static boolean hasPassedNow(TimeMark arg2) {
            return Duration.isNegative-impl(arg2.elapsedNow-UwyO8pc()) ^ 1;
        }

        public static TimeMark minus-LRDsOJo(TimeMark arg0, long arg1) {
            return arg0.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(arg1));
        }

        public static TimeMark plus-LRDsOJo(TimeMark arg2, long arg3) {
            return new AdjustedTimeMark(arg2, arg3, null);
        }
    }

    long elapsedNow-UwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    TimeMark minus-LRDsOJo(long arg1);

    TimeMark plus-LRDsOJo(long arg1);
}

