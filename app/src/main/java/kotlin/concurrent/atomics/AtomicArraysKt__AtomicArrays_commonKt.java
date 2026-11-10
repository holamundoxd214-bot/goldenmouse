package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001A\u001B\u0010\u0007\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u001B\u0010\n\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u001B\u0010\u000B\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u001B\u0010\f\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A.\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000F0\u0005H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001A\u001B\u0010\u0007\u001A\u00020\u000F*\u00020\u000E2\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u001B\u0010\n\u001A\u00020\u000F*\u00020\u000E2\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u001B\u0010\u000B\u001A\u00020\u000F*\u00020\u000E2\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u001B\u0010\f\u001A\u00020\u000F*\u00020\u000E2\u0006\u0010\b\u001A\u00020\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A<\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00140\u0005H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001A\'\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"AtomicIntArray", "Lkotlin/concurrent/atomics/AtomicIntArray;", "size", "", "init", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "fetchAndIncrementAt", "index", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;I)I", "incrementAndFetchAt", "decrementAndFetchAt", "fetchAndDecrementAt", "AtomicLongArray", "Lkotlin/concurrent/atomics/AtomicLongArray;", "", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;I)J", "AtomicArray", "Lkotlin/concurrent/atomics/AtomicArray;", "T", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "atomicArrayOfNulls", "(I)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/concurrent/atomics/AtomicArraysKt") class AtomicArraysKt__AtomicArrays_commonKt {
    public AtomicArraysKt__AtomicArrays_commonKt() {
        super();
    }

    public static final AtomicReferenceArray AtomicArray(int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "init");
        int v1 = 0;
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] v0 = new Object[arg3];
        while(v1 < arg3) {
            v0[v1] = arg4.invoke(Integer.valueOf(v1));
            ++v1;
        }

        return new AtomicReferenceArray(v0);
    }

    public static final AtomicIntegerArray AtomicIntArray(int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "init");
        int[] v0 = new int[arg3];
        int v1;
        for(v1 = 0; v1 < arg3; ++v1) {
            v0[v1] = arg4.invoke(Integer.valueOf(v1)).intValue();
        }

        return new AtomicIntegerArray(v0);
    }

    public static final AtomicLongArray AtomicLongArray(int arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "init");
        long[] v0 = new long[arg4];
        int v1;
        for(v1 = 0; v1 < arg4; ++v1) {
            v0[v1] = arg5.invoke(Integer.valueOf(v1)).longValue();
        }

        return new AtomicLongArray(v0);
    }

    public static final AtomicReferenceArray atomicArrayOfNulls(int arg3) {
        int v1 = 0;
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] v0 = new Object[arg3];
        while(v1 < arg3) {
            v0[v1] = null;
            ++v1;
        }

        return new AtomicReferenceArray(v0);
    }

    public static final int decrementAndFetchAt(AtomicIntegerArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.addAndGet(arg2, -1);
    }

    public static final long decrementAndFetchAt(AtomicLongArray arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.addAndGet(arg3, -1);
    }

    public static final int fetchAndDecrementAt(AtomicIntegerArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getAndAdd(arg2, -1);
    }

    public static final long fetchAndDecrementAt(AtomicLongArray arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.getAndAdd(arg3, -1);
    }

    public static final int fetchAndIncrementAt(AtomicIntegerArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getAndAdd(arg2, 1);
    }

    public static final long fetchAndIncrementAt(AtomicLongArray arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.getAndAdd(arg3, 1);
    }

    public static final int incrementAndFetchAt(AtomicIntegerArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.addAndGet(arg2, 1);
    }

    public static final long incrementAndFetchAt(AtomicLongArray arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.addAndGet(arg3, 1);
    }
}

