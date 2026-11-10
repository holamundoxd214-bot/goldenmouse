package kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0082\u0004¢\u0006\u0002\u0010\u0005\u001A\u001B\u0010\u0006\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0082\u0004¢\u0006\u0002\u0010\u0005\u001A\u0013\u0010\u0007\u001A\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0013\u0010\t\u001A\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0013\u0010\n\u001A\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0013\u0010\u000B\u001A\u00020\u0004*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001A\u00020\rH\u0087\u0082\u0004¢\u0006\u0002\u0010\u000E\u001A\u001B\u0010\u0006\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001A\u00020\rH\u0087\u0082\u0004¢\u0006\u0002\u0010\u000E\u001A\u0013\u0010\u0007\u001A\u00020\r*\u00020\fH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A\u0013\u0010\t\u001A\u00020\r*\u00020\fH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A\u0013\u0010\n\u001A\u00020\r*\u00020\fH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A\u0013\u0010\u000B\u001A\u00020\r*\u00020\fH\u0087\u0080\u0004¢\u0006\u0002\u0010\u000F¨\u0006\u0010"}, d2={"plusAssign", "", "Lkotlin/concurrent/atomics/AtomicInt;", "delta", "", "(Ljava/util/concurrent/atomic/AtomicInteger;I)V", "minusAssign", "fetchAndIncrement", "(Ljava/util/concurrent/atomic/AtomicInteger;)I", "incrementAndFetch", "decrementAndFetch", "fetchAndDecrement", "Lkotlin/concurrent/atomics/AtomicLong;", "", "(Ljava/util/concurrent/atomic/AtomicLong;J)V", "(Ljava/util/concurrent/atomic/AtomicLong;)J", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/concurrent/atomics/AtomicsKt") class AtomicsKt__Atomics_commonKt {
    public AtomicsKt__Atomics_commonKt() {
        super();
    }

    public static final int decrementAndFetch(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.addAndGet(-1);
    }

    public static final long decrementAndFetch(AtomicLong arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.addAndGet(-1);
    }

    public static final int fetchAndDecrement(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getAndAdd(-1);
    }

    public static final long fetchAndDecrement(AtomicLong arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.getAndAdd(-1);
    }

    public static final int fetchAndIncrement(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getAndAdd(1);
    }

    public static final long fetchAndIncrement(AtomicLong arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.getAndAdd(1);
    }

    public static final int incrementAndFetch(AtomicInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.addAndGet(1);
    }

    public static final long incrementAndFetch(AtomicLong arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.addAndGet(1);
    }

    public static final void minusAssign(AtomicInteger arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.addAndGet(-arg2);
    }

    public static final void minusAssign(AtomicLong arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.addAndGet(-arg2);
    }

    public static final void plusAssign(AtomicInteger arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.addAndGet(arg2);
    }

    public static final void plusAssign(AtomicLong arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.addAndGet(arg2);
    }
}

