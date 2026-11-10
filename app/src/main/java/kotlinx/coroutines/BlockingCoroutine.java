package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0014J\u000B\u0010\u0012\u001A\u00028\u0000¢\u0006\u0002\u0010\u0013R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\r¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class BlockingCoroutine extends AbstractCoroutine {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    public BlockingCoroutine(CoroutineContext arg2, Thread arg3, EventLoop arg4) {
        super(arg2, true, true);
        this.blockedThread = arg3;
        this.eventLoop = arg4;
    }

    protected void afterCompletion(Object arg2) {
        if(!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            Thread v1 = this.blockedThread;
            AbstractTimeSource v2 = AbstractTimeSourceKt.timeSource;
            if(v2 != null) {
                v2.unpark(v1);
                return;
            }
            else {
                LockSupport.unpark(v1);
            }
        }
    }

    protected boolean isScopedCoroutine() {
        return 1;
    }

    public final Object joinBlocking() {
        Object v3;
        EventLoop v0_1;
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.registerTimeLoopThread();
        }

        try {
            v0_1 = this.eventLoop;
            v3 = null;
            if(v0_1 != null) {
                EventLoop.incrementUseCount$default(v0_1, false, 1, v3);
            }
        }
        catch(Throwable v6) {
            goto label_48;
        }

        try {
            while(true) {
                v0_1 = this.eventLoop;
                long v4 = v0_1 != null ? v0_1.processNextEvent() : 0x7FFFFFFFFFFFFFFFL;
                if(this.isCompleted()) {
                    goto label_27;
                }

                v0 = AbstractTimeSourceKt.timeSource;
                if(v0 != null) {
                    v0.parkNanos(this, v4);
                }
                else {
                    LockSupport.parkNanos(this, v4);
                }

                if(!Thread.interrupted()) {
                    continue;
                }

                this.cancelCoroutine(new InterruptedException());
            }
        }
        catch(Throwable v0_2) {
            try {
                EventLoop v6_1 = this.eventLoop;
                if(v6_1 != null) {
                    EventLoop.decrementUseCount$default(v6_1, false, 1, v3);
                }

                throw v0_2;
            label_27:
                v0_1 = this.eventLoop;
                if(v0_1 != null) {
                    EventLoop.decrementUseCount$default(v0_1, false, 1, v3);
                }
            }
            catch(Throwable v6) {
                goto label_48;
            }
        }

        v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }

        Object v6_2 = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if((v6_2 instanceof CompletedExceptionally)) {
            v3 = v6_2;
        }

        if(v3 == null) {
            return v6_2;
        }

        throw ((CompletedExceptionally)v3).cause;
    label_48:
        v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }

        throw v6;
    }
}

