package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000D\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001AR\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u001AT\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000B\u001A\u00020\f2\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\n\u001AG\u0010\u000E\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0002\u0010\n\u001AI\u0010\u000E\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000B\u001A\u00020\f2\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0004\b\u000F\u0010\n\u001A\\\u0010\u0010\u001A\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0001*\u0002H\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00010\u00132\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u0014\u001A \u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u001AH\u0000¨\u0006\u001B"}, d2={"withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "setupTimeout", "U", "coroutine", "Lkotlinx/coroutines/TimeoutCoroutine;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "delay", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TimeoutKt {
    public static final TimeoutCancellationException TimeoutCancellationException(long arg2, Delay arg4, Job arg5) {
        String v4_1;
        DelayWithTimeoutDiagnostics v4;
        if((arg4 instanceof DelayWithTimeoutDiagnostics)) {
        }
        else {
            v4 = null;
        }

        if(0 != 0) {
            v4_1 = v4.timeoutMessage-LRDsOJo(DurationKt.toDuration(arg2, DurationUnit.MILLISECONDS));
            if(v4_1 == null) {
                goto label_10;
            }
        }
        else {
        label_10:
            v4_1 = "Timed out waiting for " + arg2 + " ms";
        }

        return new TimeoutCancellationException(v4_1, arg5);
    }

    private static final Object setupTimeout(TimeoutCoroutine arg6, Function2 arg7) {
        JobKt.disposeOnCompletion(arg6, DelayKt.getDelay(arg6.uCont.getContext()).invokeOnTimeout(arg6.time, arg6, arg6.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(arg6, arg6, arg7);
    }

    public static final Object withTimeout(long arg2, Function2 arg4, Continuation arg5) {
        if(arg2 > 0) {
            Object v2 = TimeoutKt.setupTimeout(new TimeoutCoroutine(arg2, arg5), arg4);
            if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg5);
            }

            return v2;
        }

        throw new TimeoutCancellationException("Timed out immediately");
    }

    public static final Object withTimeout-KLykuaI(long arg0, Function2 arg2, Continuation arg3) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(arg0), arg2, arg3);
    }

    public static final Object withTimeoutOrNull(long arg7, Function2 arg9, Continuation arg10) {
        Object v7;
        int v2;
        Continuation v0;
        if((arg10 instanceof TimeoutKt$withTimeoutOrNull$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((TimeoutKt$withTimeoutOrNull$1)v0).label & v2) != 0) {
                ((TimeoutKt$withTimeoutOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TimeoutKt$withTimeoutOrNull$1 v0_1 = new TimeoutKt$withTimeoutOrNull$1(arg10);
        }

        Object v10 = ((TimeoutKt$withTimeoutOrNull$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TimeoutKt$withTimeoutOrNull$1)v0).label;
        Object v3 = null;
        if(v2 != 0) {
            if(v2 == 1) {
                v7 = ((TimeoutKt$withTimeoutOrNull$1)v0).L$1;
                try {
                    ResultKt.throwOnFailure(v10);
                    return v10;
                }
                catch(TimeoutCancellationException v8) {
                    goto label_54;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v10);
        if(arg7 <= 0) {
            return v3;
        }

        ObjectRef v10_1 = new ObjectRef();
        try {
            ((TimeoutKt$withTimeoutOrNull$1)v0).L$0 = arg9;
            ((TimeoutKt$withTimeoutOrNull$1)v0).L$1 = v10_1;
            ((TimeoutKt$withTimeoutOrNull$1)v0).J$0 = arg7;
            ((TimeoutKt$withTimeoutOrNull$1)v0).label = 1;
            TimeoutCoroutine v4 = new TimeoutCoroutine(arg7, v0);
            v10_1.element = v4;
            v7 = TimeoutKt.setupTimeout(v4, arg9);
            if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(v0);
            }

            goto label_49;
        }
        catch(TimeoutCancellationException v8) {
            ObjectRef v7_1 = v10_1;
        }

    label_54:
        if(v8.coroutine == v7_1.element) {
            return v3;
        }
        else {
            throw v8;
        }

    label_49:
        if(v7 == v1) {
            return v1;
        }

        return v7;
    }

    public static final Object withTimeoutOrNull-KLykuaI(long arg0, Function2 arg2, Continuation arg3) {
        return TimeoutKt.withTimeoutOrNull(DelayKt.toDelayMillis-LRDsOJo(arg0), arg2, arg3);
    }
}

