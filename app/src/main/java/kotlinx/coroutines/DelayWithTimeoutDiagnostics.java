package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", "", "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface DelayWithTimeoutDiagnostics extends Delay {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public static Object delay(DelayWithTimeoutDiagnostics arg0, long arg1, Continuation arg3) {
            Object v0 = kotlinx.coroutines.Delay$DefaultImpls.delay(((Delay)arg0), arg1, arg3);
            if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v0;
            }

            return Unit.INSTANCE;
        }

        public static DisposableHandle invokeOnTimeout(DelayWithTimeoutDiagnostics arg0, long arg1, Runnable arg3, CoroutineContext arg4) {
            return kotlinx.coroutines.Delay$DefaultImpls.invokeOnTimeout(((Delay)arg0), arg1, arg3, arg4);
        }
    }

    String timeoutMessage-LRDsOJo(long arg1);
}

