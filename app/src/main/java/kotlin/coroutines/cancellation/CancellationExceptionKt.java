package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A\"\u0010\u0000\u001A\u00060\u0001j\u0002`\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0087\u0088\u0004\u001A\u0018\u0010\u0000\u001A\u00060\u0001j\u0002`\u00052\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0087\u0088\u0004*\u001A\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004¨\u0006\n"}, d2={"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlin/SinceKotlin;", "version", "1.4", "Lkotlin/coroutines/cancellation/CancellationException;", "message", "", "cause", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CancellationExceptionKt {
    private static final CancellationException CancellationException(String arg1, Throwable arg2) {
        CancellationException v0 = new CancellationException(arg1);
        v0.initCause(arg2);
        return v0;
    }

    private static final CancellationException CancellationException(Throwable arg2) {
        String v1 = arg2 != null ? String.valueOf(arg2) : null;
        CancellationException v0 = new CancellationException(v1);
        v0.initCause(arg2);
        return v0;
    }

    public static void CancellationException$annotations() {
    }
}

