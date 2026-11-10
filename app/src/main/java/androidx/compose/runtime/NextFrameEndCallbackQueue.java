package androidx.compose.runtime;

import androidx.compose.runtime.internal.AtomicBoolean;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.runtime.internal.AwaiterQueue;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001AB\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u0014\u001A\u00020\u0004J\u0006\u0010\u0015\u001A\u00020\u0004J\u0014\u0010\u0016\u001A\u00020\u00042\f\b\u0002\u0010\u0017\u001A\u00060\u0018j\u0002`\u0019R\u0010\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/NextFrameEndCallbackQueue;", "", "onNewAwaiters", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "isFrameOngoing", "Landroidx/compose/runtime/internal/AtomicBoolean;", "Landroidx/compose/runtime/internal/AtomicInt;", "frameEndQueue", "Landroidx/compose/runtime/internal/AwaiterQueue;", "Landroidx/compose/runtime/NextFrameEndCallbackQueue$NextFrameEndAwaiter;", "hasAwaiters", "", "getHasAwaiters", "()Z", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "markFrameStarted", "markFrameComplete", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "NextFrameEndAwaiter", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NextFrameEndCallbackQueue {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0004H\u0016J\u0006\u0010\b\u001A\u00020\u0004J\u0010\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0016\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/runtime/NextFrameEndCallbackQueue$NextFrameEndAwaiter;", "Landroidx/compose/runtime/internal/AwaiterQueue$Awaiter;", "onNextFrameEnd", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "cancel", "resume", "resumeWithException", "exception", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class NextFrameEndAwaiter extends Awaiter {
        private Function0 onNextFrameEnd;

        public NextFrameEndAwaiter(Function0 arg1) {
            super();
            this.onNextFrameEnd = arg1;
        }

        public void cancel() {
            this.onNextFrameEnd = null;
        }

        public final void resume() {
            Function0 v0 = this.onNextFrameEnd;
            if(v0 != null) {
                v0.invoke();
            }
        }

        public void resumeWithException(Throwable arg1) {
            throw arg1;
        }
    }

    public static final int $stable = 8;
    private final AwaiterQueue frameEndQueue;
    private final AtomicInt isFrameOngoing;
    private final Function0 onNewAwaiters;

    static {
    }

    public NextFrameEndCallbackQueue(Function0 arg2) {
        super();
        this.isFrameOngoing = AtomicBoolean.constructor-impl(false);
        this.frameEndQueue = new AwaiterQueue();
        this.onNewAwaiters = new NextFrameEndCallbackQueue$$ExternalSyntheticLambda1(this, arg2);
    }

    public final void cancel(CancellationException arg1) {
        this.frameEndQueue.fail(((Throwable)arg1));
    }

    public static void cancel$default(NextFrameEndCallbackQueue arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new CancellationException("scheduler cancelled");
        }

        arg0.cancel(arg1);
    }

    public final boolean getHasAwaiters() {
        return this.frameEndQueue.getHasAwaiters();
    }

    public final void markFrameComplete() {
        AtomicBoolean.set-impl(this.isFrameOngoing, false);
        this.frameEndQueue.flushAndDispatchAwaiters(new NextFrameEndCallbackQueue$$ExternalSyntheticLambda0());
    }

    static final Unit markFrameComplete$lambda$0(NextFrameEndAwaiter arg0) {
        arg0.resume();
        return Unit.INSTANCE;
    }

    public final void markFrameStarted() {
        AtomicBoolean.set-impl(this.isFrameOngoing, true);
    }

    static final Unit onNewAwaiters$lambda$0(NextFrameEndCallbackQueue arg0, Function0 arg1) {
        if(!AtomicBoolean.get-impl(arg0.isFrameOngoing)) {
            arg1.invoke();
        }

        return Unit.INSTANCE;
    }

    public final CancellationHandle scheduleFrameEndCallback(Function0 arg3) {
        return this.frameEndQueue.addAwaiter(new NextFrameEndAwaiter(arg3), this.onNewAwaiters);
    }
}

