package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AC\u0010\u0004\u001A\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0001*\u0018\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00062\u0006\u0010\u0007\u001A\u0002H\u00012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\t\u001A=\u0010\n\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0001*\u0018\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00062\u0006\u0010\u0007\u001A\u0002H\u00012\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0002\u0010\r**\b\u0000\u0010\u0000\u001A\u0004\b\u0000\u0010\u0001\"\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000E"}, d2={"OnUndeliveredElement", "E", "Lkotlin/Function1;", "", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "callUndeliveredElement", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OnUndeliveredElementKt {
    public static final void callUndeliveredElement(Function1 arg1, Object arg2, CoroutineContext arg3) {
        UndeliveredElementException v1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(arg1, arg2, null);
        if(v1 != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(arg3, ((Throwable)v1));
        }
    }

    public static final UndeliveredElementException callUndeliveredElementCatchingException(Function1 arg2, Object arg3, UndeliveredElementException arg4) {
        try {
            arg2.invoke(arg3);
            return arg4;
        }
        catch(Throwable v2) {
            if(arg4 != null && arg4.getCause() != v2) {
                ExceptionsKt.addSuppressed(arg4, v2);
                return arg4;
            }

            return new UndeliveredElementException("Exception in undelivered element handler for " + arg3, v2);
        }
    }

    public static UndeliveredElementException callUndeliveredElementCatchingException$default(Function1 arg0, Object arg1, UndeliveredElementException arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return OnUndeliveredElementKt.callUndeliveredElementCatchingException(arg0, arg1, arg2);
    }
}

