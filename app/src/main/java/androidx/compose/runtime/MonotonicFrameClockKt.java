package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A=\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086H¢\u0006\u0002\u0010\t\u001A7\u0010\n\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086@¢\u0006\u0002\u0010\f\u001A7\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086@¢\u0006\u0002\u0010\f\"\u001E\u0010\r\u001A\u00020\u0002*\u00020\u000E8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"withFrameMillis", "R", "Landroidx/compose/runtime/MonotonicFrameClock;", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeMillis", "(Landroidx/compose/runtime/MonotonicFrameClock;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withFrameNanos", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monotonicFrameClock", "Lkotlin/coroutines/CoroutineContext;", "getMonotonicFrameClock$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getMonotonicFrameClock", "(Lkotlin/coroutines/CoroutineContext;)Landroidx/compose/runtime/MonotonicFrameClock;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MonotonicFrameClockKt {
    public static final MonotonicFrameClock getMonotonicFrameClock(CoroutineContext arg1) {
        Element v1 = arg1.get(MonotonicFrameClock.Key);
        if(v1 != null) {
            return ((MonotonicFrameClock)v1);
        }

        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.".toString());
    }

    public static void getMonotonicFrameClock$annotations(CoroutineContext arg0) {
    }

    public static final Object withFrameMillis(MonotonicFrameClock arg1, Function1 arg2, Continuation arg3) {
        return arg1.withFrameNanos(new MonotonicFrameClockKt$withFrameMillis$2(arg2), arg3);
    }

    public static final Object withFrameMillis(Function1 arg2, Continuation arg3) {
        return MonotonicFrameClockKt.getMonotonicFrameClock(arg3.getContext()).withFrameNanos(new MonotonicFrameClockKt$withFrameMillis$2(arg2), arg3);
    }

    private static final Object withFrameMillis$$forInline(MonotonicFrameClock arg1, Function1 arg2, Continuation arg3) {
        return arg1.withFrameNanos(new MonotonicFrameClockKt$withFrameMillis$2(arg2), arg3);
    }

    public static final Object withFrameNanos(Function1 arg1, Continuation arg2) {
        return MonotonicFrameClockKt.getMonotonicFrameClock(arg2.getContext()).withFrameNanos(arg1, arg2);
    }
}

