package androidx.compose.animation.core;

import java.util.concurrent.atomic.AtomicReference;

public final class MutatorMutex$$ExternalSyntheticBackportWithForwarding0 {
    public static boolean m(AtomicReference arg1, Object arg2, Object arg3) {
        do {
            if(arg1.compareAndSet(arg2, arg3)) {
                return 1;
            }
        }
        while(arg1.get() == arg2);

        return 0;
    }
}

