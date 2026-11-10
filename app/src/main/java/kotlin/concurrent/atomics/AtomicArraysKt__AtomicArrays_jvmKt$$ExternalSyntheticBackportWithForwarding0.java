package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final class AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0 {
    public static boolean m(AtomicReferenceArray arg1, int arg2, Object arg3, Object arg4) {
        do {
            if(arg1.compareAndSet(arg2, arg3, arg4)) {
                return 1;
            }
        }
        while(arg1.get(arg2) == arg3);

        return 0;
    }
}

