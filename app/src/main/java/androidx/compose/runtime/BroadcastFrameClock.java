package androidx.compose.runtime;

import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.runtime.internal.AwaiterQueue;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001AB\u0019\u0012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0010J(\u0010\u0011\u001A\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u00120\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001A\u00020\u00042\f\b\u0002\u0010\u0017\u001A\u00060\u0018j\u0002`\u0019R\u0016\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "queue", "Landroidx/compose/runtime/internal/AwaiterQueue;", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "hasAwaiters", "", "getHasAwaiters", "()Z", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "FrameAwaiter", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BroadcastFrameClock implements MonotonicFrameClock {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u000E\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u0005R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "Landroidx/compose/runtime/internal/AwaiterQueue$Awaiter;", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CancellableContinuation;)V", "cancel", "", "resumeWithException", "exception", "", "resume", "timeNanos", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class FrameAwaiter extends Awaiter {
        private CancellableContinuation continuation;
        private Function1 onFrame;

        public FrameAwaiter(Function1 arg1, CancellableContinuation arg2) {
            super();
            this.continuation = arg2;
            this.onFrame = arg1;
        }

        public void cancel() {
            this.onFrame = null;
            this.continuation = null;
        }

        public final void resume(long arg4) {
            Object v3_1;
            Function1 v0 = this.onFrame;
            if(v0 != null) {
                CancellableContinuation v1 = this.continuation;
                if(v1 != null) {
                    try {
                        v3_1 = Result.constructor-impl(v0.invoke(Long.valueOf(arg4)));
                    }
                    catch(Throwable v3) {
                        v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
                    }

                    v1.resumeWith(v3_1);
                }
            }
        }

        public void resumeWithException(Throwable arg2) {
            CancellableContinuation v1 = this.continuation;
            if(v1 != null) {
                ((Continuation)v1).resumeWith(Result.constructor-impl(ResultKt.createFailure(arg2)));
            }
        }
    }

    public static final int $stable = 8;
    private final Function0 onNewAwaiters;
    private final AwaiterQueue queue;

    static {
    }

    public BroadcastFrameClock() {
        this(null, 1, null);
    }

    public BroadcastFrameClock(Function0 arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public BroadcastFrameClock(Function0 arg1) {
        super();
        this.onNewAwaiters = arg1;
        this.queue = new AwaiterQueue();
    }

    public static final Function0 access$getOnNewAwaiters$p(BroadcastFrameClock arg0) {
        return arg0.onNewAwaiters;
    }

    public static final AwaiterQueue access$getQueue$p(BroadcastFrameClock arg0) {
        return arg0.queue;
    }

    public final void cancel(CancellationException arg1) {
        this.queue.fail(((Throwable)arg1));
    }

    public static void cancel$default(BroadcastFrameClock arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new CancellationException("clock cancelled");
        }

        arg0.cancel(arg1);
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MonotonicFrameClock)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MonotonicFrameClock)this), arg1);
    }

    public final boolean getHasAwaiters() {
        return this.queue.getHasAwaiters();
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MonotonicFrameClock)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MonotonicFrameClock)this), arg1);
    }

    public final void sendFrame(long arg2) {
        this.queue.flushAndDispatchAwaiters(new BroadcastFrameClock$$ExternalSyntheticLambda0(arg2));
    }

    static final Unit sendFrame$lambda$0(long arg0, FrameAwaiter arg2) {
        arg2.resume(arg0);
        return Unit.INSTANCE;
    }

    public Object withFrameNanos(Function1 arg5, Continuation arg6) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v0.initCancellability();
        v0.invokeOnCancellation(new BroadcastFrameClock$withFrameNanos$2$1(this.queue.addAwaiter(new FrameAwaiter(arg5, v0), this.onNewAwaiters)));
        Object v4 = v0.getResult();
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        return v4;
    }
}

