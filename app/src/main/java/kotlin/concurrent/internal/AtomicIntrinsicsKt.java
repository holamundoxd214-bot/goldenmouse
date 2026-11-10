package kotlin.concurrent.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0081\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005H\u0081\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0007H\u0081\u0080\u0004\u001A/\u0010\u0000\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u0003\u001A\u0002H\t2\u0006\u0010\u0004\u001A\u0002H\tH\u0081\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\f2\u0006\u0010\r\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0081\u0080\u0004\u001A&\u0010\u0000\u001A\u00020\u0005*\u00020\u000E2\u0006\u0010\r\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005H\u0081\u0080\u0004\u001A7\u0010\u0000\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u000F2\u0006\u0010\r\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u0002H\t2\u0006\u0010\u0004\u001A\u0002H\tH\u0081\u0080\u0004¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"compareAndExchange", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "expected", "newValue", "", "Ljava/util/concurrent/atomic/AtomicLong;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "index", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class AtomicIntrinsicsKt {
    public static final int compareAndExchange(AtomicInteger arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        do {
            int v0 = arg1.get();
            if(arg2 != v0) {
                return v0;
            }
        }
        while(!arg1.compareAndSet(arg2, arg3));

        return arg2;
    }

    public static final int compareAndExchange(AtomicIntegerArray arg1, int arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        do {
            int v0 = arg1.get(arg2);
            if(arg3 != v0) {
                return v0;
            }
        }
        while(!arg1.compareAndSet(arg2, arg3, arg4));

        return arg3;
    }

    public static final long compareAndExchange(AtomicLong arg3, long arg4, long arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        do {
            long v0 = arg3.get();
            if(arg4 != v0) {
                return v0;
            }
        }
        while(!arg3.compareAndSet(arg4, arg6));

        return arg4;
    }

    public static final long compareAndExchange(AtomicLongArray arg3, int arg4, long arg5, long arg7) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        do {
            long v0 = arg3.get(arg4);
            if(arg5 != v0) {
                return v0;
            }
        }
        while(!arg3.compareAndSet(arg4, arg5, arg7));

        return arg5;
    }

    public static final Object compareAndExchange(AtomicReference arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        do {
            Object v0 = arg1.get();
            if(arg2 != v0) {
                return v0;
            }
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg1, arg2, arg3));

        return arg2;
    }

    public static final Object compareAndExchange(AtomicReferenceArray arg1, int arg2, Object arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        do {
            Object v0 = arg1.get(arg2);
            if(arg3 != v0) {
                return v0;
            }
        }
        while(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg1, arg2, arg3, arg4));

        return arg3;
    }

    public static final boolean compareAndExchange(AtomicBoolean arg1, boolean arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        do {
            boolean v0 = arg1.get();
            if(arg2 != v0) {
                return v0;
            }
        }
        while(!arg1.compareAndSet(arg2, arg3));

        return arg2;
    }
}

