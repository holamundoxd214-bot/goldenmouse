package kotlin.concurrent.atomics;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A\u0013\u0010\u0004\u001A\u00020\u0006*\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A\u0013\u0010\u0000\u001A\u00020\b*\u00020\tH\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001A\u0013\u0010\u0004\u001A\u00020\t*\u00020\bH\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001A%\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\rH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000E\u001A%\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\f0\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u000BH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000E\u001A7\u0010\u000F\u001A\u00020\u0010*\u00020\u00022\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0014\u001A7\u0010\u0015\u001A\u00020\u0013*\u00020\u00022\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0016\u001A7\u0010\u0017\u001A\u00020\u0013*\u00020\u00022\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0016\u001A7\u0010\u000F\u001A\u00020\u0010*\u00020\u00062\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0019\u001A7\u0010\u0015\u001A\u00020\u0018*\u00020\u00062\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001A\u001A7\u0010\u0017\u001A\u00020\u0018*\u00020\u00062\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001A\u001AC\u0010\u000F\u001A\u00020\u0010\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\f0\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001B\u001AC\u0010\u0015\u001A\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\f0\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001C\u001AC\u0010\u0017\u001A\u0002H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\f0\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001D"}, d2={"asJavaAtomic", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/concurrent/atomics/AtomicInt;", "(Ljava/util/concurrent/atomic/AtomicInteger;)Ljava/util/concurrent/atomic/AtomicInteger;", "asKotlinAtomic", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/concurrent/atomics/AtomicLong;", "(Ljava/util/concurrent/atomic/AtomicLong;)Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "(Ljava/util/concurrent/atomic/AtomicBoolean;)Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicReference;", "T", "Lkotlin/concurrent/atomics/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "update", "", "transform", "Lkotlin/Function1;", "", "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)V", "fetchAndUpdate", "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)I", "updateAndFetch", "", "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)J", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/concurrent/atomics/AtomicsKt") class AtomicsKt__Atomics_jvmKt extends AtomicsKt__Atomics_commonKt {
    public AtomicsKt__Atomics_jvmKt() {
        super();
    }

    public static final AtomicBoolean asJavaAtomic(AtomicBoolean arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicInteger asJavaAtomic(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicLong asJavaAtomic(AtomicLong arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicReference asJavaAtomic(AtomicReference arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicBoolean asKotlinAtomic(AtomicBoolean arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicInteger asKotlinAtomic(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicLong asKotlinAtomic(AtomicLong arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicReference asKotlinAtomic(AtomicReference arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    private static final int fetchAndUpdate(AtomicInteger arg2, Function1 arg3) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            v0 = arg2.get();
        }
        while(!arg2.compareAndSet(v0, arg3.invoke(Integer.valueOf(v0)).intValue()));

        return v0;
    }

    private static final long fetchAndUpdate(AtomicLong arg4, Function1 arg5) {
        long v0;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "transform");
        do {
            v0 = arg4.get();
        }
        while(!arg4.compareAndSet(v0, arg5.invoke(Long.valueOf(v0)).longValue()));

        return v0;
    }

    private static final Object fetchAndUpdate(AtomicReference arg2, Function1 arg3) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            v0 = arg2.get();
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg2, v0, arg3.invoke(v0)));

        return v0;
    }

    private static final void update(AtomicInteger arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            int v0 = arg2.get();
        }
        while(!arg2.compareAndSet(v0, arg3.invoke(Integer.valueOf(v0)).intValue()));
    }

    private static final void update(AtomicLong arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "transform");
        do {
            long v0 = arg4.get();
        }
        while(!arg4.compareAndSet(v0, arg5.invoke(Long.valueOf(v0)).longValue()));
    }

    private static final void update(AtomicReference arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            Object v0 = arg2.get();
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg2, v0, arg3.invoke(v0)));
    }

    private static final int updateAndFetch(AtomicInteger arg2, Function1 arg3) {
        int v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            int v0 = arg2.get();
            v1 = arg3.invoke(Integer.valueOf(v0)).intValue();
        }
        while(!arg2.compareAndSet(v0, v1));

        return v1;
    }

    private static final long updateAndFetch(AtomicLong arg4, Function1 arg5) {
        long v2;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "transform");
        do {
            long v0 = arg4.get();
            v2 = arg5.invoke(Long.valueOf(v0)).longValue();
        }
        while(!arg4.compareAndSet(v0, v2));

        return v2;
    }

    private static final Object updateAndFetch(AtomicReference arg2, Function1 arg3) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        do {
            Object v0 = arg2.get();
            v1 = arg3.invoke(v0);
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg2, v0, v1));

        return v1;
    }
}

