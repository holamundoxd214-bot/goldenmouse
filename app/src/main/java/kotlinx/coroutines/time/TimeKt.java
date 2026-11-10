package kotlinx.coroutines.time;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001A\u0016\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001A&\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\b\u001A\u00020\u0003H\u0007\u001A&\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\n\u001A\u00020\u0003H\u0007\u001AA\u0010\u000B\u001A\u00020\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u0002\u001A\u00020\u00032\u001C\u0010\u000E\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000F¢\u0006\u0002\u0010\u0012\u001AR\u0010\u0013\u001A\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0002\u001A\u00020\u00032\'\u0010\u000E\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014¢\u0006\u0002\b\u0016H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0017\u001AG\u0010\u0018\u001A\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0002\u001A\u00020\u00032\'\u0010\u000E\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014¢\u0006\u0002\b\u0016H\u0086@¢\u0006\u0002\u0010\u0017\u001A\f\u0010\u0019\u001A\u00020\u001A*\u00020\u0003H\u0002¨\u0006\u001B"}, d2={"delay", "", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeout", "sample", "period", "onTimeout", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "withTimeout", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "coerceToMillis", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TimeKt {
    private static final long coerceToMillis(Duration arg4) {
        if(arg4.compareTo(Duration.ZERO) <= 0) {
            return 0;
        }

        if(arg4.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1;
        }

        long v2 = 0x20C49BA5E353F7L;
        if(arg4.getSeconds() >= v2 && (arg4.getSeconds() != v2 || arg4.getNano() >= 807000000)) {
            return 0x7FFFFFFFFFFFFFFFL;
        }

        return arg4.toMillis();
    }

    public static final Flow debounce(Flow arg2, Duration arg3) {
        return FlowKt.debounce(arg2, TimeKt.coerceToMillis(arg3));
    }

    public static final Object delay(Duration arg2, Continuation arg3) {
        Object v2 = DelayKt.delay(TimeKt.coerceToMillis(arg2), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static final void onTimeout(SelectBuilder arg2, Duration arg3, Function1 arg4) {
        OnTimeoutKt.onTimeout(arg2, TimeKt.coerceToMillis(arg3), arg4);
    }

    public static final Flow sample(Flow arg2, Duration arg3) {
        return FlowKt.sample(arg2, TimeKt.coerceToMillis(arg3));
    }

    public static final Object withTimeout(Duration arg2, Function2 arg3, Continuation arg4) {
        return TimeoutKt.withTimeout(TimeKt.coerceToMillis(arg2), arg3, arg4);
    }

    public static final Object withTimeoutOrNull(Duration arg2, Function2 arg3, Continuation arg4) {
        return TimeoutKt.withTimeoutOrNull(TimeKt.coerceToMillis(arg2), arg3, arg4);
    }
}

