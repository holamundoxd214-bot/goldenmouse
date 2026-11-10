package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u001A3\u0010\u0005\u001A\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001A\u001A\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000BH\u0002\"\u000E\u0010\u000F\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0015\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "MAX_SPIN_CYCLES", "PERMIT", "Lkotlinx/coroutines/internal/Symbol;", "TAKEN", "BROKEN", "CANCELLED", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SemaphoreKt {
    private static final Symbol BROKEN;
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    private static final Symbol TAKEN;

    static {
        SemaphoreKt.MAX_SPIN_CYCLES = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        SemaphoreKt.PERMIT = new Symbol("PERMIT");
        SemaphoreKt.TAKEN = new Symbol("TAKEN");
        SemaphoreKt.BROKEN = new Symbol("BROKEN");
        SemaphoreKt.CANCELLED = new Symbol("CANCELLED");
        SemaphoreKt.SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    public static final Semaphore Semaphore(int arg1, int arg2) {
        return new SemaphoreImpl(arg1, arg2);
    }

    public static Semaphore Semaphore$default(int arg0, int arg1, int arg2, Object arg3) {
        return SemaphoreKt.Semaphore(arg0, 0);
    }

    public static final SemaphoreSegment access$createSegment(long arg0, SemaphoreSegment arg2) {
        return SemaphoreKt.createSegment(arg0, arg2);
    }

    public static final Symbol access$getBROKEN$p() {
        return SemaphoreKt.BROKEN;
    }

    public static final Symbol access$getCANCELLED$p() {
        return SemaphoreKt.CANCELLED;
    }

    public static final int access$getMAX_SPIN_CYCLES$p() {
        return SemaphoreKt.MAX_SPIN_CYCLES;
    }

    public static final Symbol access$getPERMIT$p() {
        return SemaphoreKt.PERMIT;
    }

    public static final int access$getSEGMENT_SIZE$p() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    public static final Symbol access$getTAKEN$p() {
        return SemaphoreKt.TAKEN;
    }

    private static final SemaphoreSegment createSegment(long arg2, SemaphoreSegment arg4) {
        return new SemaphoreSegment(arg2, arg4, 0);
    }

    public static final Object withPermit(Semaphore arg4, Function0 arg5, Continuation arg6) {
        Object v4;
        Object v5;
        SemaphoreKt$withPermit$1 v0_1;
        int v2;
        if((arg6 instanceof SemaphoreKt$withPermit$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((SemaphoreKt$withPermit$1)v0).label & v2) != 0) {
                ((SemaphoreKt$withPermit$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SemaphoreKt$withPermit$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            v0_1.L$0 = arg4;
            v0_1.L$1 = arg5;
            v0_1.label = 1;
            if(arg4.acquire(((Continuation)v0_1)) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v5 = v0_1.L$1;
            v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            v5 = ((Function0)v5).invoke();
        }
        catch(Throwable v5_1) {
            ((Semaphore)v4).release();
            throw v5_1;
        }

        ((Semaphore)v4).release();
        return v5;
    }

    private static final Object withPermit$$forInline(Semaphore arg0, Function0 arg1, Continuation arg2) {
        Object v1_1;
        arg0.acquire(arg2);
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            arg0.release();
            throw v1;
        }

        arg0.release();
        return v1_1;
    }
}

