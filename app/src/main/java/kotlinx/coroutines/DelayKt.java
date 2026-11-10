package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u000E\u0010\u0000\u001A\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002\u001A\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001A\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u0007\u001A\u0013\u0010\u000F\u001A\u00020\u0006*\u00020\tH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0003\u001A\u00020\u000B*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2={"awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delay", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DelayKt {
    public static final Object awaitCancellation(Continuation arg4) {
        int v2;
        Continuation v0;
        if((arg4 instanceof DelayKt$awaitCancellation$1)) {
            v0 = arg4;
            v2 = 0x80000000;
            if((((DelayKt$awaitCancellation$1)v0).label & v2) != 0) {
                ((DelayKt$awaitCancellation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            DelayKt$awaitCancellation$1 v0_1 = new DelayKt$awaitCancellation$1(arg4);
        }

        Object v4 = ((DelayKt$awaitCancellation$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((DelayKt$awaitCancellation$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v4);
            ((DelayKt$awaitCancellation$1)v0).label = 1;
            CancellableContinuationImpl v4_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(v0), 1);
            v4_1.initCancellability();
            v4 = v4_1.getResult();
            if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(v0);
            }

            if(v4 != v1) {
                goto label_38;
            }

            return v1;
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v4);
        }

    label_38:
        throw new KotlinNothingValueException();
    }

    public static final Object delay(long arg4, Continuation arg6) {
        if(arg4 <= 0) {
            return Unit.INSTANCE;
        }

        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        if(arg4 < 0x7FFFFFFFFFFFFFFFL) {
            DelayKt.getDelay(((CancellableContinuation)v1).getContext()).scheduleResumeAfterDelay(arg4, ((CancellableContinuation)v1));
        }

        Object v4 = v0.getResult();
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    public static final Object delay-VtjQ1oo(long arg0, Continuation arg2) {
        Object v0 = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(arg0), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public static final Delay getDelay(CoroutineContext arg1) {
        Delay v1_1;
        Element v1 = arg1.get(ContinuationInterceptor.Key);
        if((v1 instanceof Delay)) {
        }
        else {
            v1 = null;
        }

        if(v1 == null) {
            v1_1 = DefaultExecutorKt.getDefaultDelay();
        }

        return v1_1;
    }

    public static final long toDelayMillis-LRDsOJo(long arg3) {
        boolean v0 = Duration.isPositive-impl(arg3);
        if(v0) {
            return Duration.getInWholeMilliseconds-impl(Duration.plus-LRDsOJo(arg3, DurationKt.toDuration(0xF423F, DurationUnit.NANOSECONDS)));
        }

        if(!v0) {
            return 0;
        }

        throw new NoWhenBranchMatchedException();
    }
}

