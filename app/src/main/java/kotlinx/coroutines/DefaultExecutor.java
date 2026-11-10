package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001C\u001A\u00020\u001D2\n\u0010\u001E\u001A\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u001F\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00020\"H\u0014J\b\u0010#\u001A\u00020\u001DH\u0002J\b\u0010$\u001A\u00020\u001DH\u0016J$\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\t2\n\u0010(\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010)\u001A\u00020*H\u0016J\b\u0010+\u001A\u00020\u001DH\u0016J\b\u0010,\u001A\u00020\fH\u0002J\r\u0010-\u001A\u00020\u001DH\u0000¢\u0006\u0002\b.J\b\u0010/\u001A\u00020\u0019H\u0002J\u000E\u00100\u001A\u00020\u001D2\u0006\u00101\u001A\u00020\tJ\b\u00102\u001A\u00020\u001DH\u0002J\b\u00105\u001A\u00020\u0007H\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0005R\u0014\u0010\u000E\u001A\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001AR\u0014\u00103\u001A\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b4\u0010\u001A¨\u00066"}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "THREAD_NAME", "", "DEFAULT_KEEP_ALIVE_MS", "", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "thread", "getThread", "()Ljava/lang/Thread;", "FRESH", "", "ACTIVE", "SHUTDOWN_REQ", "SHUTDOWN_ACK", "SHUTDOWN", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "enqueue", "", "task", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "shutdownError", "shutdown", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "run", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "notifyStartup", "shutdownForTests", "timeout", "acknowledgeShutdownIfNeeded", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000;
    private static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE = null;
    private static final long KEEP_ALIVE_NANOS = 0;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long v1_1;
        DefaultExecutor v0 = new DefaultExecutor();
        DefaultExecutor.INSTANCE = v0;
        EventLoop.incrementUseCount$default(((EventLoop)v0), false, 1, null);
        TimeUnit v0_1 = TimeUnit.MILLISECONDS;
        long v1 = 1000;
        try {
            v1_1 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", v1);
        }
        catch(SecurityException ) {
            v1_1 = Long.valueOf(((long)v1_1));
        }

        DefaultExecutor.KEEP_ALIVE_NANOS = v0_1.toNanos(v1_1.longValue());
    }

    private DefaultExecutor() {
        super();
    }

    private final void acknowledgeShutdownIfNeeded() {
        __monitor_enter(this);
        try {
            if(this.isShutdownRequested()) {
                goto label_5;
            }
        }
        catch(Throwable v0) {
            goto label_15;
        }

        __monitor_exit(this);
        return;
    label_5:
        int v0_1 = 3;
        try {
            DefaultExecutor.debugStatus = v0_1;
            this.resetAll();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            this.notifyAll();
        }
        catch(Throwable v0) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_15;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    private final Thread createThreadSync() {
        Thread v0_1;
        __monitor_enter(this);
        try {
            v0_1 = DefaultExecutor._thread;
            if(v0_1 == null) {
                v0_1 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                DefaultExecutor v1 = DefaultExecutor.INSTANCE;
                DefaultExecutor._thread = v0_1;
                v0_1.setContextClassLoader(v1.getClass().getClassLoader());
                v0_1.setDaemon(true);
                v0_1.start();
            }
        }
        catch(Throwable v0) {
            try {
            label_18:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_18;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public void enqueue(Runnable arg2) {
        if(this.isShutDown()) {
            this.shutdownError();
        }

        super.enqueue(arg2);
    }

    public final void ensureStarted$kotlinx_coroutines_core() {
        __monitor_enter(this);
        try {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(DefaultExecutor._thread == null) {
                }
                else {
                    throw new AssertionError();
                }
            }

            if((DebugKt.getASSERTIONS_ENABLED()) && DefaultExecutor.debugStatus != 0) {
                if(DefaultExecutor.debugStatus == 3) {
                }
                else {
                    throw new AssertionError();
                }
            }

            DefaultExecutor.debugStatus = 0;
            this.createThreadSync();
            while(DefaultExecutor.debugStatus == 0) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                this.wait();
            }
        }
        catch(Throwable v0) {
            goto label_33;
        }

        __monitor_exit(this);
        return;
        try {
        label_33:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_33;
        }

        throw v0;
    }

    protected Thread getThread() {
        Thread v0 = DefaultExecutor._thread;
        if(v0 == null) {
            return this.createThreadSync();
        }

        return v0;
    }

    private static void get_thread$annotations() {
    }

    public DisposableHandle invokeOnTimeout(long arg1, Runnable arg3, CoroutineContext arg4) {
        return this.scheduleInvokeOnTimeout(arg1, arg3);
    }

    private final boolean isShutDown() {
        if(DefaultExecutor.debugStatus == 4) {
            return 1;
        }

        return 0;
    }

    private final boolean isShutdownRequested() {
        int v1 = DefaultExecutor.debugStatus;
        if(v1 != 2) {
            if(v1 == 3) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        if(DefaultExecutor._thread != null) {
            return 1;
        }

        return 0;
    }

    private final boolean notifyStartup() {
        __monitor_enter(this);
        try {
            if(!this.isShutdownRequested()) {
                goto label_7;
            }
        }
        catch(Throwable v0) {
            goto label_15;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_7:
            DefaultExecutor.debugStatus = 1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            this.notifyAll();
        }
        catch(Throwable v0) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_15;
            }

            throw v0;
        }

        __monitor_exit(this);
        return 1;
    }

    protected void reschedule(long arg1, DelayedTask arg3) {
        this.shutdownError();
    }

    public void run() {
        long v10;
        AbstractTimeSource v7;
        long v5;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.registerTimeLoopThread();
        }

        Thread v0_1 = null;
        try {
            if(!this.notifyStartup()) {
            }
            else {
                goto label_18;
            }
        }
        catch(Throwable v1) {
            goto label_66;
        }

        DefaultExecutor._thread = v0_1;
        this.acknowledgeShutdownIfNeeded();
        v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }

        if(this.isEmpty()) {
            return;
        }

        this.getThread();
        return;
    label_18:
        long v1_1 = 0x7FFFFFFFFFFFFFFFL;
        long v3 = v1_1;
        try {
            while(true) {
            label_20:
                Thread.interrupted();
                v5 = this.processNextEvent();
                long v8 = 0;
                if(Long.compare(v5, v1_1) == 0) {
                    v7 = AbstractTimeSourceKt.timeSource;
                    v10 = v7 != null ? v7.nanoTime() : System.nanoTime();
                    if(v3 == v1_1) {
                        v3 = DefaultExecutor.KEEP_ALIVE_NANOS + v10;
                    }

                    break;
                }
                else {
                    goto label_46;
                }
            }
        }
        catch(Throwable v1) {
            goto label_66;
        }

        v10 = v3 - v10;
        if(v10 <= v8) {
            DefaultExecutor._thread = v0_1;
            this.acknowledgeShutdownIfNeeded();
            v0 = AbstractTimeSourceKt.timeSource;
            if(v0 != null) {
                v0.unregisterTimeLoopThread();
            }

            if(this.isEmpty()) {
                return;
            }

            this.getThread();
            return;
        }

        try {
            v5 = RangesKt.coerceAtMost(v5, v10);
            goto label_47;
        label_46:
            v3 = v1_1;
        label_47:
            if(v5 <= v8) {
                goto label_20;
            }

            if(!this.isShutdownRequested()) {
                goto label_59;
            }
        }
        catch(Throwable v1) {
            goto label_66;
        }

        DefaultExecutor._thread = v0_1;
        this.acknowledgeShutdownIfNeeded();
        v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }

        if(this.isEmpty()) {
            return;
        }

        this.getThread();
        return;
        try {
        label_59:
            v7 = AbstractTimeSourceKt.timeSource;
            if(v7 != null) {
                v7.parkNanos(this, v5);
                goto label_20;
            }

            LockSupport.parkNanos(this, v5);
            goto label_20;
        }
        catch(Throwable v1) {
            goto label_66;
        }

        return;
    label_66:
        DefaultExecutor._thread = v0_1;
        this.acknowledgeShutdownIfNeeded();
        v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.unregisterTimeLoopThread();
        }

        if(!this.isEmpty()) {
            this.getThread();
        }

        throw v1;
    }

    public void shutdown() {
        DefaultExecutor.debugStatus = 4;
        super.shutdown();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final void shutdownForTests(long arg7) {
        __monitor_enter(this);
        try {
            long v0 = System.currentTimeMillis() + arg7;
            if(!this.isShutdownRequested()) {
                DefaultExecutor.debugStatus = 2;
            }

            while(DefaultExecutor.debugStatus != 3) {
                if(DefaultExecutor._thread == null) {
                    break;
                }

                Thread v2 = DefaultExecutor._thread;
                if(v2 != null) {
                    AbstractTimeSource v3 = AbstractTimeSourceKt.timeSource;
                    if(v3 != null) {
                        v3.unpark(v2);
                    }
                    else {
                        LockSupport.unpark(v2);
                    }
                }

                if(v0 - System.currentTimeMillis() <= 0) {
                    break;
                }

                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                this.wait(arg7);
            }

            DefaultExecutor.debugStatus = 0;
        }
        catch(Throwable v7) {
            goto label_33;
        }

        __monitor_exit(this);
        return;
        try {
        label_33:
            __monitor_exit(this);
        }
        catch(Throwable v7) {
            goto label_33;
        }

        throw v7;
    }

    public String toString() {
        return "DefaultExecutor";
    }
}

