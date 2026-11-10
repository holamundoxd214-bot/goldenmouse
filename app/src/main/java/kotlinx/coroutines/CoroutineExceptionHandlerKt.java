package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u0018\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005H\u0000\u001A%\u0010\t\u001A\u00020\n2\u001A\b\u0004\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fH\u0086\b¨\u0006\r"}, d2={"handleCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "handlerException", "originalException", "thrownException", "CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineExceptionHandlerKt {
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(Function2 arg2) {
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(arg2, CoroutineExceptionHandler.Key);
    }

    public static final void handleCoroutineException(CoroutineContext arg1, Throwable arg2) {
        if((arg2 instanceof DispatchException)) {
            arg2 = ((DispatchException)arg2).getCause();
        }

        try {
            Element v0_1 = arg1.get(CoroutineExceptionHandler.Key);
            if(v0_1 == null) {
                goto label_8;
            }

            ((CoroutineExceptionHandler)v0_1).handleException(arg1, arg2);
            return;
        }
        catch(Throwable v0) {
            CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(arg1, CoroutineExceptionHandlerKt.handlerException(arg2, v0));
            return;
        }

    label_8:
        CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(arg1, arg2);
    }

    public static final Throwable handlerException(Throwable arg2, Throwable arg3) {
        if(arg2 == arg3) {
            return arg2;
        }

        RuntimeException v0 = new RuntimeException("Exception while trying to handle coroutine exception", arg3);
        ExceptionsKt.addSuppressed(((Throwable)v0), arg2);
        return ((Throwable)v0);
    }
}

