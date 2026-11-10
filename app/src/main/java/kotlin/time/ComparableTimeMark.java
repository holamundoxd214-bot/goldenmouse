package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u0019\u0010\u0003\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005H¦\u0082\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005H\u0096\u0082\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\b\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0000H¦\u0082\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0012\u0010\r\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u0000H\u0096\u0082\u0004J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\n\u001A\u0004\u0018\u00010\u0011H¦\u0082\u0004J\n\u0010\u0012\u001A\u00020\u000EH¦\u0080\u0004¨\u0006\u0013"}, d2={"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "compareTo", "", "equals", "", "", "hashCode", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface ComparableTimeMark extends Comparable, TimeMark {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static int compareTo(ComparableTimeMark arg2, ComparableTimeMark arg3) {
            Intrinsics.checkNotNullParameter(arg3, "other");
            return Duration.compareTo-LRDsOJo(arg2.minus-UwyO8pc(arg3), Duration.Companion.getZERO-UwyO8pc());
        }

        public static boolean hasNotPassedNow(ComparableTimeMark arg0) {
            return kotlin.time.TimeMark$DefaultImpls.hasNotPassedNow(((TimeMark)arg0));
        }

        public static boolean hasPassedNow(ComparableTimeMark arg0) {
            return kotlin.time.TimeMark$DefaultImpls.hasPassedNow(((TimeMark)arg0));
        }

        public static ComparableTimeMark minus-LRDsOJo(ComparableTimeMark arg0, long arg1) {
            return arg0.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(arg1));
        }
    }

    int compareTo(ComparableTimeMark arg1);

    boolean equals(Object arg1);

    int hashCode();

    ComparableTimeMark minus-LRDsOJo(long arg1);

    long minus-UwyO8pc(ComparableTimeMark arg1);

    ComparableTimeMark plus-LRDsOJo(long arg1);
}

