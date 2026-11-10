package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0004J\u0018\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0014R\u0012\u0010\u0004\u001A\u00020\u0005X¤\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "<init>", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "unpark", "", "reschedule", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class EventLoopImplPlatform extends EventLoop {
    public EventLoopImplPlatform() {
        super();
    }

    protected abstract Thread getThread();

    protected void reschedule(long arg1, DelayedTask arg3) {
        DefaultExecutor.INSTANCE.schedule(arg1, arg3);
    }

    protected final void unpark() {
        Thread v1 = this.getThread();
        if(Thread.currentThread() != v1) {
            AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
            if(v0 != null) {
                v0.unpark(v1);
                return;
            }
            else {
                LockSupport.unpark(v1);
            }
        }
    }
}

