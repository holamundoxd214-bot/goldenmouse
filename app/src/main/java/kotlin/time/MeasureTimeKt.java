package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A-\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001A1\u0010\u0000\u001A\u00020\u0001*\u00020\u00062\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001A1\u0010\u0000\u001A\u00020\u0001*\u00020\b2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001A4\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A8\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f*\u00020\u00062\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A8\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f*\u00020\b2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2={"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class MeasureTimeKt {
    public static final long measureTime(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        long v0 = Monotonic.INSTANCE.markNow-z9LOYto();
        arg2.invoke();
        return ValueTimeMark.elapsedNow-UwyO8pc(v0);
    }

    public static final long measureTime(Monotonic arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "block");
        long v0 = arg2.markNow-z9LOYto();
        arg3.invoke();
        return ValueTimeMark.elapsedNow-UwyO8pc(v0);
    }

    public static final long measureTime(TimeSource arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        TimeMark v1 = arg1.markNow();
        arg2.invoke();
        return v1.elapsedNow-UwyO8pc();
    }

    public static final TimedValue measureTimedValue(Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        return new TimedValue(arg4.invoke(), ValueTimeMark.elapsedNow-UwyO8pc(Monotonic.INSTANCE.markNow-z9LOYto()), null);
    }

    public static final TimedValue measureTimedValue(Monotonic arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        return new TimedValue(arg4.invoke(), ValueTimeMark.elapsedNow-UwyO8pc(arg3.markNow-z9LOYto()), null);
    }

    public static final TimedValue measureTimedValue(TimeSource arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        return new TimedValue(arg4.invoke(), arg3.markNow().elapsedNow-UwyO8pc(), null);
    }
}

