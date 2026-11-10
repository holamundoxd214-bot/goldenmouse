package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A\u001E\u0010\u0000\u001A\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2={"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ExceptionsKt {
    public static final CancellationException CancellationException(String arg1, Throwable arg2) {
        CancellationException v0 = new CancellationException(arg1);
        v0.initCause(arg2);
        return v0;
    }
}

