package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001BJ\u000E\u0010\u001C\u001A\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001BJ\u0016\u0010\u001A\u001A\u00020\u00162\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00160\u001EH\u0005Jb\u0010\u001A\u001A\u00020\u0016\"\u0004\b\u0000\u0010\u001F2\u0006\u0010\u001D\u001A\u0002H\u001F2!\u0010 \u001A\u001D\u0012\u0013\u0012\u0011H\u001F¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020\u00190!2!\u0010$\u001A\u001D\u0012\u0013\u0012\u0011H\u001F¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020\u00160!H\u0083\b¢\u0006\u0002\u0010%J\u001E\u0010&\u001A\u00020\u00162\n\u0010\'\u001A\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001A\u0004\u0018\u00010\u0001H\u0004J\b\u0010*\u001A\u00020\u0003H\u0002J\u0006\u0010+\u001A\u00020\u0016J\b\u0010,\u001A\u00020\u0016H\u0002J\u0010\u0010-\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020.H\u0002J\b\u0010/\u001A\u00020\u0019H\u0002J\f\u00100\u001A\u00020\u0019*\u00020\u0001H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\n\u001A\u00020\u000BX\u0082\u0004R\u000F\u0010\f\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\r\u001A\u00020\u000BX\u0082\u0004R\t\u0010\u000E\u001A\u00020\u000FX\u0082\u0004R\u0011\u0010\u0010\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001A\u001A\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "permits", "", "acquiredPermits", "<init>", "(II)V", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "tail", "enqIdx", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "onCancellationRelease", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/CoroutineContext;", "tryAcquire", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "waiter", "Lkotlinx/coroutines/CancellableContinuation;", "W", "suspend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "decPermits", "release", "coerceAvailablePermitsAtMaximum", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SemaphoreAndMutexImpl {
    private final Function3 onCancellationRelease;
    private final int permits;

    static {
        Class v0 = Object.class;
        Class v2 = SemaphoreAndMutexImpl.class;
        SemaphoreAndMutexImpl.head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "head$volatile");
        SemaphoreAndMutexImpl.deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(v2, "deqIdx$volatile");
        SemaphoreAndMutexImpl.tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "tail$volatile");
        SemaphoreAndMutexImpl.enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(v2, "enqIdx$volatile");
        SemaphoreAndMutexImpl._availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v2, "_availablePermits$volatile");
    }

    public SemaphoreAndMutexImpl(int arg6, int arg7) {
        super();
        this.permits = arg6;
        if(arg6 > 0) {
            if(arg7 >= 0 && arg7 <= arg6) {
                SemaphoreSegment v0 = new SemaphoreSegment(0, null, 2);
                this.head$volatile = v0;
                this.tail$volatile = v0;
                this._availablePermits$volatile = arg6 - arg7;
                this.onCancellationRelease = new SemaphoreAndMutexImpl$$ExternalSyntheticLambda0(this);
                return;
            }

            throw new IllegalArgumentException("The number of acquired permits should be in 0.." + arg6.toString());
        }

        throw new IllegalArgumentException("Semaphore should have at least 1 permit, but had " + arg6.toString());
    }

    public static final Object access$acquireSlowPath(SemaphoreAndMutexImpl arg0, Continuation arg1) {
        return arg0.acquireSlowPath(arg1);
    }

    public static final boolean access$addAcquireToQueue(SemaphoreAndMutexImpl arg0, Waiter arg1) {
        return arg0.addAcquireToQueue(arg1);
    }

    private final void acquire(Object arg2, Function1 arg3, Function1 arg4) {
        do {
            if(this.decPermits() > 0) {
                goto label_2;
            }
        }
        while(!arg3.invoke(arg2).booleanValue());

        return;
    label_2:
        arg4.invoke(arg2);
    }

    protected final void acquire(CancellableContinuation arg2) {
        do {
            if(this.decPermits() > 0) {
                goto label_2;
            }

            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        }
        while(!this.addAcquireToQueue(arg2));

        return;
    label_2:
        arg2.resume(Unit.INSTANCE, this.onCancellationRelease);
    }

    public final Object acquire(Continuation arg2) {
        if(this.decPermits() > 0) {
            return Unit.INSTANCE;
        }

        Object v1 = this.acquireSlowPath(arg2);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final Object acquireSlowPath(Continuation arg3) {
        CancellableContinuationImpl v0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg3));
        try {
            if(!this.addAcquireToQueue(v0)) {
                this.acquire(v0);
            }
        }
        catch(Throwable v2) {
            v0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw v2;
        }

        Object v2_1 = v0.getResult();
        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2_1;
        }

        return Unit.INSTANCE;
    }

    private final boolean addAcquireToQueue(Waiter arg15) {
        Object v9;
        Segment v8;
        Object v7;
        Object v0 = SemaphoreAndMutexImpl.getTail$volatile$FU().get(this);
        long v1 = SemaphoreAndMutexImpl.getEnqIdx$volatile$FU().getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 v3 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater v4 = SemaphoreAndMutexImpl.getTail$volatile$FU();
        long v5 = v1 / (((long)SemaphoreKt.access$getSEGMENT_SIZE$p()));
        while(true) {
        label_9:
            v7 = ConcurrentLinkedListKt.findSegmentInternal(v0, v5, v3);
            if(!SegmentOrClosed.isClosed-impl(v7)) {
                v8 = SegmentOrClosed.getSegment-impl(v7);
                while(true) {
                label_15:
                    v9 = v4.get(this);
                    if(((Segment)v9).id >= v8.id) {
                        goto label_19;
                    }
                    else if(!v8.tryIncPointers$kotlinx_coroutines_core()) {
                        goto label_9;
                    }
                    else {
                        goto label_23;
                    }
                }
            }

            goto label_33;
        }

    label_23:
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v4, this, v9, v8)) {
            if(!v8.decPointers$kotlinx_coroutines_core()) {
                goto label_15;
            }

            v8.remove();
            goto label_15;
        label_19:
        }
        else if(((Segment)v9).decPointers$kotlinx_coroutines_core()) {
            ((Segment)v9).remove();
        }

    label_33:
        Segment v0_1 = SegmentOrClosed.getSegment-impl(v7);
        int v1_1 = ((int)(v1 % (((long)SemaphoreKt.access$getSEGMENT_SIZE$p()))));
        if(AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(((SemaphoreSegment)v0_1).getAcquirers(), v1_1, null, arg15)) {
            arg15.invokeOnCancellation(v0_1, v1_1);
            return 1;
        }

        if(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(((SemaphoreSegment)v0_1).getAcquirers(), v1_1, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getTAKEN$p())) {
            goto label_72;
        }

        if((arg15 instanceof CancellableContinuation)) {
            Intrinsics.checkNotNull(arg15, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation)arg15).resume(Unit.INSTANCE, this.onCancellationRelease);
        }
        else if((arg15 instanceof SelectInstance)) {
            ((SelectInstance)arg15).selectInRegistrationPhase(Unit.INSTANCE);
        }
        else {
            goto label_63;
        }

        return 1;
    label_63:
        throw new IllegalStateException("unexpected: " + arg15.toString());
    label_72:
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(((SemaphoreSegment)v0_1).getAcquirers().get(v1_1) == SemaphoreKt.access$getBROKEN$p()) {
            }
            else {
                throw new AssertionError();
            }
        }

        return 0;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        do {
            int v0 = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().get(this);
            if(v0 <= this.permits) {
                return;
            }
        }
        while(!SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().compareAndSet(this, v0, this.permits));
    }

    private final int decPermits() {
        int v0;
        do {
            v0 = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().getAndDecrement(this);
        }
        while(v0 > this.permits);

        return v0;
    }

    public final int getAvailablePermits() {
        return Math.max(SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().get(this), 0);
    }

    private final long getDeqIdx$volatile() {
        return this.deqIdx$volatile;
    }

    private static final AtomicLongFieldUpdater getDeqIdx$volatile$FU() {
        return SemaphoreAndMutexImpl.deqIdx$volatile$FU;
    }

    private final long getEnqIdx$volatile() {
        return this.enqIdx$volatile;
    }

    private static final AtomicLongFieldUpdater getEnqIdx$volatile$FU() {
        return SemaphoreAndMutexImpl.enqIdx$volatile$FU;
    }

    private final Object getHead$volatile() {
        return this.head$volatile;
    }

    private static final AtomicReferenceFieldUpdater getHead$volatile$FU() {
        return SemaphoreAndMutexImpl.head$volatile$FU;
    }

    private final Object getTail$volatile() {
        return this.tail$volatile;
    }

    private static final AtomicReferenceFieldUpdater getTail$volatile$FU() {
        return SemaphoreAndMutexImpl.tail$volatile$FU;
    }

    private final int get_availablePermits$volatile() {
        return this._availablePermits$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_availablePermits$volatile$FU() {
        return SemaphoreAndMutexImpl._availablePermits$volatile$FU;
    }

    protected final void onAcquireRegFunction(SelectInstance arg1, Object arg2) {
        do {
            if(this.decPermits() > 0) {
                goto label_2;
            }

            Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        }
        while(!this.addAcquireToQueue(arg1));

        return;
    label_2:
        arg1.selectInRegistrationPhase(Unit.INSTANCE);
    }

    static final Unit onCancellationRelease$lambda$2(SemaphoreAndMutexImpl arg0, Throwable arg1, Unit arg2, CoroutineContext arg3) {
        arg0.release();
        return Unit.INSTANCE;
    }

    public final void release() {
        do {
            int v0 = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().getAndIncrement(this);
            if(v0 >= this.permits) {
                goto label_9;
            }

            if(v0 >= 0) {
            }
            else if(!this.tryResumeNextFromQueue()) {
                continue;
            }

            return;
        }
        while(true);

        return;
    label_9:
        this.coerceAvailablePermitsAtMaximum();
        throw new IllegalStateException("The number of released permits cannot be greater than " + this.permits.toString());
    }

    private final void setDeqIdx$volatile(long arg1) {
        this.deqIdx$volatile = arg1;
    }

    private final void setEnqIdx$volatile(long arg1) {
        this.enqIdx$volatile = arg1;
    }

    private final void setHead$volatile(Object arg1) {
        this.head$volatile = arg1;
    }

    private final void setTail$volatile(Object arg1) {
        this.tail$volatile = arg1;
    }

    private final void set_availablePermits$volatile(int arg1) {
        this._availablePermits$volatile = arg1;
    }

    public final boolean tryAcquire() {
        do {
        label_0:
            int v0 = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().get(this);
            if(v0 > this.permits) {
                this.coerceAvailablePermitsAtMaximum();
                goto label_0;
            }

            if(v0 <= 0) {
                return 0;
            }
        }
        while(!SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().compareAndSet(this, v0, v0 - 1));

        return 1;
    }

    private final boolean tryResumeAcquire(Object arg3) {
        if((arg3 instanceof CancellableContinuation)) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            Object v2 = ((CancellableContinuation)arg3).tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
            if(v2 != null) {
                ((CancellableContinuation)arg3).completeResume(v2);
                return 1;
            }

            return 0;
        }

        if((arg3 instanceof SelectInstance)) {
            return ((SelectInstance)arg3).trySelect(this, Unit.INSTANCE);
        }

        throw new IllegalStateException("unexpected: " + arg3.toString());
    }

    private final boolean tryResumeNextFromQueue() {
        Object v9;
        Segment v8;
        Object v7;
        Object v0 = SemaphoreAndMutexImpl.getHead$volatile$FU().get(this);
        long v1 = SemaphoreAndMutexImpl.getDeqIdx$volatile$FU().getAndIncrement(this);
        long v3 = v1 / (((long)SemaphoreKt.access$getSEGMENT_SIZE$p()));
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 v5 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater v6 = SemaphoreAndMutexImpl.getHead$volatile$FU();
        while(true) {
        label_9:
            v7 = ConcurrentLinkedListKt.findSegmentInternal(v0, v3, v5);
            if(!SegmentOrClosed.isClosed-impl(v7)) {
                v8 = SegmentOrClosed.getSegment-impl(v7);
                while(true) {
                label_15:
                    v9 = v6.get(this);
                    if(((Segment)v9).id >= v8.id) {
                        goto label_19;
                    }
                    else if(!v8.tryIncPointers$kotlinx_coroutines_core()) {
                        goto label_9;
                    }
                    else {
                        goto label_23;
                    }
                }
            }

            goto label_33;
        }

    label_23:
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v6, this, v9, v8)) {
            if(!v8.decPointers$kotlinx_coroutines_core()) {
                goto label_15;
            }

            v8.remove();
            goto label_15;
        label_19:
        }
        else if(((Segment)v9).decPointers$kotlinx_coroutines_core()) {
            ((Segment)v9).remove();
        }

    label_33:
        Segment v0_1 = SegmentOrClosed.getSegment-impl(v7);
        ((SemaphoreSegment)v0_1).cleanPrev();
        int v3_1 = Long.compare(((SemaphoreSegment)v0_1).id, v3);
        int v4 = 0;
        if(v3_1 > 0) {
            return 0;
        }

        int v1_1 = ((int)(v1 % (((long)SemaphoreKt.access$getSEGMENT_SIZE$p()))));
        Object v2 = ((SemaphoreSegment)v0_1).getAcquirers().getAndSet(v1_1, SemaphoreKt.access$getPERMIT$p());
        if(v2 == null) {
            int v14 = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
            while(v4 < v14) {
                if(((SemaphoreSegment)v0_1).getAcquirers().get(v1_1) == SemaphoreKt.access$getTAKEN$p()) {
                    return 1;
                }

                ++v4;
            }

            return AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(((SemaphoreSegment)v0_1).getAcquirers(), v1_1, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getBROKEN$p()) ^ 1;
        }

        if(v2 == SemaphoreKt.access$getCANCELLED$p()) {
            return 0;
        }

        return this.tryResumeAcquire(v2);
    }
}

