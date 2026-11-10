package androidx.concurrent.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0 {
    public static boolean m(AtomicReferenceFieldUpdater arg1, Object arg2, Object arg3, Object arg4) {
        do {
            if(arg1.compareAndSet(arg2, arg3, arg4)) {
                return 1;
            }
        }
        while(arg1.get(arg2) == arg3);

        return 0;
    }
}

