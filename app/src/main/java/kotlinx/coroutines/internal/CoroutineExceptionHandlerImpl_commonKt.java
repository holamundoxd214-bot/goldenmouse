package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"handleUncaughtCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(CoroutineContext arg2, Throwable arg3) {
        Iterator v0 = CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            try {
                ((CoroutineExceptionHandler)v1).handleException(arg2, arg3);
                continue;
            }
            catch(Throwable v1_1) {
                CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(CoroutineExceptionHandlerKt.handlerException(arg3, v1_1));
                continue;
            }
            catch(ExceptionSuccessfullyProcessed ) {
                return;
            }
        }

        try {
            ExceptionsKt.addSuppressed(arg3, new DiagnosticCoroutineContextException(arg2));
            goto label_15;
        }
        catch(Throwable ) {
        label_15:
            CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(arg3);
            return;
        }
    }
}

