package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001A\u00020\n2\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A<\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A<\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A<\u0010\f\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A<\u0010\f\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A\u001C\u0010\r\u001A\u00020\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0081\u0080\u0004\u001AP\u0010\r\u001A\u00020\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001AN\u0010\r\u001A\u00020\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001AP\u0010\u0014\u001A\u00020\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001AN\u0010\u0014\u001A\u00020\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u001A(\u0010\u0015\u001A\u00020\u00012\u0019\b\u0004\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2={"schedule", "Ljava/util/TimerTask;", "Ljava/util/Timer;", "delay", "", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "time", "Ljava/util/Date;", "period", "scheduleAtFixedRate", "timer", "name", "", "daemon", "", "initialDelay", "startAt", "fixedRateTimer", "timerTask", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class TimersKt {
    private static final Timer fixedRateTimer(String arg1, boolean arg2, long arg3, long arg5, Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "action");
        Timer v1 = TimersKt.timer(arg1, arg2);
        v1.scheduleAtFixedRate(new TimersKt$timerTask$1(arg7), arg3, arg5);
        return v1;
    }

    private static final Timer fixedRateTimer(String arg1, boolean arg2, Date arg3, long arg4, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "startAt");
        Intrinsics.checkNotNullParameter(arg6, "action");
        Timer v1 = TimersKt.timer(arg1, arg2);
        v1.scheduleAtFixedRate(new TimersKt$timerTask$1(arg6), arg3, arg4);
        return v1;
    }

    static Timer fixedRateTimer$default(String arg6, boolean arg7, long arg8, long arg10, Function1 arg12, int arg13, Object arg14) {
        if((arg13 & 1) != 0) {
            arg6 = null;
        }

        if((arg13 & 4) != 0) {
            arg8 = 0;
        }

        Intrinsics.checkNotNullParameter(arg12, "action");
        Timer v0 = TimersKt.timer(arg6, false);
        v0.scheduleAtFixedRate(new TimersKt$timerTask$1(arg12), arg8, arg10);
        return v0;
    }

    static Timer fixedRateTimer$default(String arg0, boolean arg1, Date arg2, long arg3, Function1 arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg0 = null;
        }

        Intrinsics.checkNotNullParameter(arg2, "startAt");
        Intrinsics.checkNotNullParameter(arg5, "action");
        Timer v0 = TimersKt.timer(arg0, false);
        v0.scheduleAtFixedRate(new TimersKt$timerTask$1(arg5), arg2, arg3);
        return v0;
    }

    private static final TimerTask schedule(Timer arg1, long arg2, long arg4, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg6);
        arg1.schedule(v0, arg2, arg4);
        return v0;
    }

    private static final TimerTask schedule(Timer arg1, long arg2, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg4);
        arg1.schedule(((TimerTask)v0), arg2);
        return ((TimerTask)v0);
    }

    private static final TimerTask schedule(Timer arg1, Date arg2, long arg3, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "time");
        Intrinsics.checkNotNullParameter(arg5, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg5);
        arg1.schedule(((TimerTask)v0), arg2, arg3);
        return ((TimerTask)v0);
    }

    private static final TimerTask schedule(Timer arg1, Date arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "time");
        Intrinsics.checkNotNullParameter(arg3, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg3);
        arg1.schedule(((TimerTask)v0), arg2);
        return ((TimerTask)v0);
    }

    private static final TimerTask scheduleAtFixedRate(Timer arg1, long arg2, long arg4, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg6);
        arg1.scheduleAtFixedRate(v0, arg2, arg4);
        return v0;
    }

    private static final TimerTask scheduleAtFixedRate(Timer arg1, Date arg2, long arg3, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "time");
        Intrinsics.checkNotNullParameter(arg5, "action");
        TimersKt$timerTask$1 v0 = new TimersKt$timerTask$1(arg5);
        arg1.scheduleAtFixedRate(((TimerTask)v0), arg2, arg3);
        return ((TimerTask)v0);
    }

    public static final Timer timer(String arg1, boolean arg2) {
        if(arg1 == null) {
            return new Timer(arg2);
        }

        return new Timer(arg1, arg2);
    }

    private static final Timer timer(String arg1, boolean arg2, long arg3, long arg5, Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg7, "action");
        Timer v1 = TimersKt.timer(arg1, arg2);
        v1.schedule(new TimersKt$timerTask$1(arg7), arg3, arg5);
        return v1;
    }

    private static final Timer timer(String arg1, boolean arg2, Date arg3, long arg4, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "startAt");
        Intrinsics.checkNotNullParameter(arg6, "action");
        Timer v1 = TimersKt.timer(arg1, arg2);
        v1.schedule(new TimersKt$timerTask$1(arg6), arg3, arg4);
        return v1;
    }

    static Timer timer$default(String arg6, boolean arg7, long arg8, long arg10, Function1 arg12, int arg13, Object arg14) {
        if((arg13 & 1) != 0) {
            arg6 = null;
        }

        if((arg13 & 4) != 0) {
            arg8 = 0;
        }

        Intrinsics.checkNotNullParameter(arg12, "action");
        Timer v0 = TimersKt.timer(arg6, false);
        v0.schedule(new TimersKt$timerTask$1(arg12), arg8, arg10);
        return v0;
    }

    static Timer timer$default(String arg0, boolean arg1, Date arg2, long arg3, Function1 arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg0 = null;
        }

        Intrinsics.checkNotNullParameter(arg2, "startAt");
        Intrinsics.checkNotNullParameter(arg5, "action");
        Timer v0 = TimersKt.timer(arg0, false);
        v0.schedule(new TimersKt$timerTask$1(arg5), arg2, arg3);
        return v0;
    }

    private static final TimerTask timerTask(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "action");
        return new TimersKt$timerTask$1(arg1);
    }
}

