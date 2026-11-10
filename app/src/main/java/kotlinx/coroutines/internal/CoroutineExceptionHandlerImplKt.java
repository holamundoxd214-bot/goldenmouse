package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u001A\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0002H\u0000\u001A\u0010\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\nH\u0000\"\u001A\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u000B"}, d2={"platformExceptionHandlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getPlatformExceptionHandlers", "()Ljava/util/Collection;", "ensurePlatformExceptionHandlerLoaded", "", "callback", "propagateExceptionFinalResort", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineExceptionHandlerImplKt {
    private static final Collection platformExceptionHandlers;

    static {
        CoroutineExceptionHandlerImplKt.platformExceptionHandlers = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    }

    public static final void ensurePlatformExceptionHandlerLoaded(CoroutineExceptionHandler arg1) {
        if(CoroutineExceptionHandlerImplKt.platformExceptionHandlers.contains(arg1)) {
            return;
        }

        throw new IllegalStateException("Exception handler was not found via a ServiceLoader".toString());
    }

    public static final Collection getPlatformExceptionHandlers() {
        return CoroutineExceptionHandlerImplKt.platformExceptionHandlers;
    }

    public static final void propagateExceptionFinalResort(Throwable arg2) {
        Thread v0 = Thread.currentThread();
        v0.getUncaughtExceptionHandler().uncaughtException(v0, arg2);
    }
}

