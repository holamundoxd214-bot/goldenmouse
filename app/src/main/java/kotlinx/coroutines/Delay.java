package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006J\u001E\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\nH&J)\u0010\u000B\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\u00052\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2={"Lkotlinx/coroutines/Delay;", "", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Delay {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public static Object delay(Delay arg3, long arg4, Continuation arg6) {
            if(arg4 <= 0) {
                return Unit.INSTANCE;
            }

            CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
            v0.initCancellability();
            arg3.scheduleResumeAfterDelay(arg4, v0);
            Object v3 = v0.getResult();
            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg6);
            }

            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v3;
            }

            return Unit.INSTANCE;
        }

        public static DisposableHandle invokeOnTimeout(Delay arg0, long arg1, Runnable arg3, CoroutineContext arg4) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(arg1, arg3, arg4);
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") Object delay(long arg1, Continuation arg2);

    DisposableHandle invokeOnTimeout(long arg1, Runnable arg2, CoroutineContext arg3);

    void scheduleResumeAfterDelay(long arg1, CancellableContinuation arg2);
}

