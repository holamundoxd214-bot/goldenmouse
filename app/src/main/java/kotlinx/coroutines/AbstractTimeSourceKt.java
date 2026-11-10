package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u0013\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001H\u0080\b\u001A\t\u0010\u0005\u001A\u00020\u0006H\u0081\b\u001A\t\u0010\u0007\u001A\u00020\u0006H\u0081\b\u001A\u0019\u0010\b\u001A\u00060\tj\u0002`\n2\n\u0010\u000B\u001A\u00060\tj\u0002`\nH\u0081\b\u001A\t\u0010\f\u001A\u00020\u0003H\u0081\b\u001A\t\u0010\r\u001A\u00020\u0003H\u0081\b\u001A\t\u0010\u000E\u001A\u00020\u0003H\u0081\b\u001A\t\u0010\u000F\u001A\u00020\u0003H\u0081\b\u001A\u0019\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0006H\u0081\b\u001A\u0011\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0081\b\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "mockTimeSource", "", "source", "currentTimeMillis", "", "nanoTime", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "trackTask", "unTrackTask", "registerTimeLoopThread", "unregisterTimeLoopThread", "parkNanos", "blocker", "", "nanos", "unpark", "thread", "Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    static {
    }

    public static final AbstractTimeSource access$getTimeSource$p() {
        return AbstractTimeSourceKt.timeSource;
    }

    public static final void access$setTimeSource$p(AbstractTimeSource arg0) {
        AbstractTimeSourceKt.timeSource = arg0;
    }

    private static final long currentTimeMillis() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            return v0.currentTimeMillis();
        }

        return System.currentTimeMillis();
    }

    public static final void mockTimeSource(AbstractTimeSource arg0) {
        AbstractTimeSourceKt.timeSource = arg0;
    }

    private static final long nanoTime() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            return v0.nanoTime();
        }

        return System.nanoTime();
    }

    private static final void parkNanos(Object arg1, long arg2) {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.parkNanos(arg1, arg2);
            return;
        }

        LockSupport.parkNanos(arg1, arg2);
    }

    private static final void registerTimeLoopThread() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.registerTimeLoopThread();
        }
    }

    private static final void trackTask() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.trackTask();
        }
    }

    private static final void unTrackTask() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unTrackTask();
        }
    }

    private static final void unpark(Thread arg1) {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unpark(arg1);
            return;
        }

        LockSupport.unpark(arg1);
    }

    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }
    }

    private static final Runnable wrapTask(Runnable arg1) {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            Runnable v0_1 = v0.wrapTask(arg1);
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return arg1;
    }
}

