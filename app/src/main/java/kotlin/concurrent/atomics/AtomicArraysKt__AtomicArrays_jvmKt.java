package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A\u0013\u0010\u0004\u001A\u00020\u0006*\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A%\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\nH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A%\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\t0\n\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\bH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A?\u0010\f\u001A\u00020\r*\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0012\u001A?\u0010\u0013\u001A\u00020\u000F*\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0014\u001A?\u0010\u0015\u001A\u00020\u000F*\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0014\u001A?\u0010\f\u001A\u00020\r*\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0017\u001A?\u0010\u0013\u001A\u00020\u0016*\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0018\u001A?\u0010\u0015\u001A\u00020\u0016*\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0018\u001AK\u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0019\u001AK\u0010\u0013\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001A\u001AK\u0010\u0015\u001A\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\u0011H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001A\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001B"}, d2={"asJavaAtomicArray", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "Lkotlin/concurrent/atomics/AtomicIntArray;", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "asKotlinAtomicArray", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Lkotlin/concurrent/atomics/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;)Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "T", "Lkotlin/concurrent/atomics/AtomicArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "updateAt", "", "index", "", "transform", "Lkotlin/Function1;", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;ILkotlin/jvm/functions/Function1;)V", "updateAndFetchAt", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;ILkotlin/jvm/functions/Function1;)I", "fetchAndUpdateAt", "", "(Ljava/util/concurrent/atomic/AtomicLongArray;ILkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicLongArray;ILkotlin/jvm/functions/Function1;)J", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/concurrent/atomics/AtomicArraysKt") class AtomicArraysKt__AtomicArrays_jvmKt extends AtomicArraysKt__AtomicArrays_commonKt {
    public AtomicArraysKt__AtomicArrays_jvmKt() {
        super();
    }

    public static final AtomicIntegerArray asJavaAtomicArray(AtomicIntegerArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicLongArray asJavaAtomicArray(AtomicLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicReferenceArray asJavaAtomicArray(AtomicReferenceArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicIntegerArray asKotlinAtomicArray(AtomicIntegerArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicLongArray asKotlinAtomicArray(AtomicLongArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final AtomicReferenceArray asKotlinAtomicArray(AtomicReferenceArray arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    private static final int fetchAndUpdateAt(AtomicIntegerArray arg2, int arg3, Function1 arg4) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            v0 = arg2.get(arg3);
        }
        while(!arg2.compareAndSet(arg3, v0, arg4.invoke(Integer.valueOf(v0)).intValue()));

        return v0;
    }

    private static final long fetchAndUpdateAt(AtomicLongArray arg7, int arg8, Function1 arg9) {
        long v3;
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "transform");
        while(true) {
            v3 = arg7.get(arg8);
            AtomicLongArray v1 = arg7;
            int v2 = arg8;
            if(v1.compareAndSet(v2, v3, arg9.invoke(Long.valueOf(v3)).longValue())) {
                return v3;
            }

            arg7 = v1;
            arg8 = v2;
        }

        return v3;
    }

    private static final Object fetchAndUpdateAt(AtomicReferenceArray arg2, int arg3, Function1 arg4) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            v0 = arg2.get(arg3);
        }
        while(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v0, arg4.invoke(v0)));

        return v0;
    }

    private static final int updateAndFetchAt(AtomicIntegerArray arg2, int arg3, Function1 arg4) {
        int v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            int v0 = arg2.get(arg3);
            v1 = arg4.invoke(Integer.valueOf(v0)).intValue();
        }
        while(!arg2.compareAndSet(arg3, v0, v1));

        return v1;
    }

    private static final long updateAndFetchAt(AtomicLongArray arg7, int arg8, Function1 arg9) {
        long v5;
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "transform");
        while(true) {
            long v3 = arg7.get(arg8);
            v5 = arg9.invoke(Long.valueOf(v3)).longValue();
            AtomicLongArray v1 = arg7;
            int v2 = arg8;
            if(v1.compareAndSet(v2, v3, v5)) {
                return v5;
            }

            arg7 = v1;
            arg8 = v2;
        }

        return v5;
    }

    private static final Object updateAndFetchAt(AtomicReferenceArray arg2, int arg3, Function1 arg4) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            Object v0 = arg2.get(arg3);
            v1 = arg4.invoke(v0);
        }
        while(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v0, v1));

        return v1;
    }

    private static final void updateAt(AtomicIntegerArray arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            int v0 = arg2.get(arg3);
        }
        while(!arg2.compareAndSet(arg3, v0, arg4.invoke(Integer.valueOf(v0)).intValue()));
    }

    private static final void updateAt(AtomicLongArray arg7, int arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "transform");
        while(true) {
            long v3 = arg7.get(arg8);
            AtomicLongArray v1 = arg7;
            int v2 = arg8;
            if(v1.compareAndSet(v2, v3, arg9.invoke(Long.valueOf(v3)).longValue())) {
                return;
            }

            arg7 = v1;
            arg8 = v2;
        }
    }

    private static final void updateAt(AtomicReferenceArray arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        do {
            Object v0 = arg2.get(arg3);
        }
        while(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v0, arg4.invoke(v0)));
    }
}

