package okio.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¨\u0006\u0004"}, d2={"setBitsOrZero", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "bits", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class _AtomicKt {
    public static final int setBitsOrZero(AtomicInteger arg2, int arg3) {
        int v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        do {
            int v0 = arg2.get();
            if((v0 & arg3) != 0) {
                return 0;
            }

            v1 = v0 | arg3;
        }
        while(!arg2.compareAndSet(v0, v1));

        return v1;
    }
}

