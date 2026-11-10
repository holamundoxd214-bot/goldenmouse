package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001A\u00020\rJ\u0006\u0010\u000E\u001A\u00020\u000FJ\b\u0010\u0010\u001A\u00020\rH\u0016J\u0015\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\bH\u0000¢\u0006\u0002\b\u0013J\u0017\u0010\u0014\u001A\u00020\r2\b\b\u0002\u0010\u0012\u001A\u00020\bH\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\rH\u0014J\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001AJ%\u0010\u001B\u001A\u0002H\u001C\"\u0004\b\u0000\u0010\u001C2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u001C0\u001EH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001FJ\u0012\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010!H\u0001J\u0012\u0010#\u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010!H\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "<init>", "()V", "state", "", "index", "value", "", "timeoutAt", "getTimeoutAt$okio", "()J", "enter", "", "exit", "", "cancel", "remainingNanos", "now", "remainingNanos$okio", "setTimeoutAt", "setTimeoutAt$okio", "timedOut", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "newTimeoutException", "Watchdog", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class AsyncTimeout extends Timeout {
    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\tH\u0002J\b\u0010\"\u001A\u0004\u0018\u00010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Lokio/AsyncTimeout$Companion;", "", "<init>", "()V", "queue", "Lokio/PriorityQueue;", "getQueue", "()Lokio/PriorityQueue;", "idleSentinel", "Lokio/AsyncTimeout;", "getIdleSentinel", "()Lokio/AsyncTimeout;", "setIdleSentinel", "(Lokio/AsyncTimeout;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "TIMEOUT_WRITE_SIZE", "", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "STATE_CANCELED", "insertIntoQueue", "", "node", "awaitTimeout", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final void access$insertIntoQueue(Companion arg0, AsyncTimeout arg1) {
            arg0.insertIntoQueue(arg1);
        }

        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            long v2;
            AsyncTimeout v0 = this.getQueue().first();
            AsyncTimeout v1 = null;
            if(v0 == null) {
                v2 = System.nanoTime();
                this.getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if(this.getQueue().first() == null && System.nanoTime() - v2 >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return this.getIdleSentinel();
                }

                return v1;
            }

            v2 = v0.remainingNanos$okio(System.nanoTime());
            if(v2 > 0) {
                this.getCondition().await(v2, TimeUnit.NANOSECONDS);
                return v1;
            }

            this.getQueue().remove(v0);
            v0.state = 2;
            return v0;
        }

        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        public final AsyncTimeout getIdleSentinel() {
            return AsyncTimeout.idleSentinel;
        }

        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        public final PriorityQueue getQueue() {
            return AsyncTimeout.queue;
        }

        private final void insertIntoQueue(AsyncTimeout arg5) {
            if(this.getIdleSentinel() == null) {
                this.setIdleSentinel(new AsyncTimeout());
                new Watchdog().start();
            }

            AsyncTimeout.setTimeoutAt$okio$default(arg5, 0, 1, null);
            this.getQueue().add(arg5);
            if(arg5.index == 1) {
                this.getCondition().signal();
            }
        }

        public final void setIdleSentinel(AsyncTimeout arg1) {
            AsyncTimeout.idleSentinel = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "<init>", "()V", "run", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            this.setDaemon(true);
        }

        public void run() {
            AsyncTimeout v0_1;
            ReentrantLock v2;
            try {
                while(true) {
                label_0:
                    v2 = AsyncTimeout.Companion.getLock();
                    ((Lock)v2).lock();
                    break;
                }
            }
            catch(InterruptedException ) {
                goto label_0;
            }

            try {
                v0_1 = AsyncTimeout.Companion.awaitTimeout();
                if(v0_1 != AsyncTimeout.Companion.getIdleSentinel()) {
                    goto label_13;
                }

                AsyncTimeout.Companion.setIdleSentinel(null);
            }
            catch(Throwable v0) {
                goto label_19;
            }

            try {
                ((Lock)v2).unlock();
                return;
            }
            catch(InterruptedException ) {
                goto label_0;
            }

        label_13:
            goto label_14;
            try {
            label_19:
                ((Lock)v2).unlock();
                throw v0;
            label_14:
                ((Lock)v2).unlock();
                if(v0_1 == null) {
                    goto label_0;
                }

                v0_1.timedOut();
            }
            catch(InterruptedException ) {
            }

            goto label_0;
        }
    }

    private static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 0x10000;
    private static final Condition condition;
    private static AsyncTimeout idleSentinel;
    public int index;
    private static final ReentrantLock lock;
    private static final PriorityQueue queue;
    private int state;
    private long timeoutAt;

    static {
        AsyncTimeout.Companion = new Companion(null);
        AsyncTimeout.queue = new PriorityQueue();
        ReentrantLock v0 = new ReentrantLock();
        AsyncTimeout.lock = v0;
        Condition v0_1 = v0.newCondition();
        Intrinsics.checkNotNullExpressionValue(v0_1, "newCondition(...)");
        AsyncTimeout.condition = v0_1;
        long v0_2 = TimeUnit.SECONDS.toMillis(60);
        AsyncTimeout.IDLE_TIMEOUT_MILLIS = v0_2;
        AsyncTimeout.IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(v0_2);
    }

    public AsyncTimeout() {
        super();
        this.index = -1;
    }

    public static final Companion access$getCompanion$p() {
        return AsyncTimeout.Companion;
    }

    public static final Condition access$getCondition$cp() {
        return AsyncTimeout.condition;
    }

    public static final long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return AsyncTimeout.IDLE_TIMEOUT_MILLIS;
    }

    public static final long access$getIDLE_TIMEOUT_NANOS$cp() {
        return AsyncTimeout.IDLE_TIMEOUT_NANOS;
    }

    public static final AsyncTimeout access$getIdleSentinel$cp() {
        return AsyncTimeout.idleSentinel;
    }

    public static final ReentrantLock access$getLock$cp() {
        return AsyncTimeout.lock;
    }

    public static final PriorityQueue access$getQueue$cp() {
        return AsyncTimeout.queue;
    }

    public final IOException access$newTimeoutException(IOException arg1) {
        return this.newTimeoutException(arg1);
    }

    public static final void access$setIdleSentinel$cp(AsyncTimeout arg0) {
        AsyncTimeout.idleSentinel = arg0;
    }

    public static final void access$setState$p(AsyncTimeout arg0, int arg1) {
        arg0.state = arg1;
    }

    public void cancel() {
        super.cancel();
        ReentrantLock v0 = AsyncTimeout.lock;
        ((Lock)v0).lock();
        try {
            if(this.state == 1) {
                AsyncTimeout.queue.remove(this);
                this.state = 3;
            }
        }
        catch(Throwable v3) {
            ((Lock)v0).unlock();
            throw v3;
        }

        ((Lock)v0).unlock();
    }

    public final void enter() {
        long v0 = this.timeoutNanos();
        boolean v2 = this.hasDeadline();
        if(v0 == 0 && !v2) {
            return;
        }

        ReentrantLock v0_1 = AsyncTimeout.lock;
        ((Lock)v0_1).lock();
        try {
            if(this.state != 0) {
                goto label_17;
            }

            this.state = 1;
            Companion.access$insertIntoQueue(AsyncTimeout.Companion, this);
        }
        catch(Throwable v5) {
            goto label_23;
        }

        ((Lock)v0_1).unlock();
        return;
        try {
        label_17:
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        catch(Throwable v5) {
        label_23:
            ((Lock)v0_1).unlock();
            throw v5;
        }
    }

    public final boolean exit() {
        boolean v2;
        ReentrantLock v0 = AsyncTimeout.lock;
        ((Lock)v0).lock();
        try {
            int v1 = this.state;
            v2 = false;
            this.state = 0;
            if(v1 != 1) {
                goto label_11;
            }

            AsyncTimeout.queue.remove(this);
        }
        catch(Throwable v4) {
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
        return 0;
    label_11:
        if(v1 == 2) {
            v2 = true;
        }

        ((Lock)v0).unlock();
        return v2;
    }

    public final long getTimeoutAt$okio() {
        return this.timeoutAt;
    }

    protected IOException newTimeoutException(IOException arg2) {
        InterruptedIOException v1 = new InterruptedIOException("timeout");
        if(arg2 != null) {
            v1.initCause(((Throwable)arg2));
        }

        return ((IOException)v1);
    }

    public final long remainingNanos$okio(long arg3) {
        return this.timeoutAt - arg3;
    }

    public final void setTimeoutAt$okio(long arg8) {
        long v0 = this.timeoutNanos();
        boolean v2 = this.hasDeadline();
        long v5 = 0;
        if(this.timeoutNanos() != v5 && (this.hasDeadline())) {
            this.timeoutAt = arg8 + Math.min(v0, this.deadlineNanoTime() - arg8);
            return;
        }

        if(v0 != v5) {
            this.timeoutAt = arg8 + v0;
            return;
        }

        if(v2) {
            this.timeoutAt = this.deadlineNanoTime();
            return;
        }

        throw new AssertionError();
    }

    public static void setTimeoutAt$okio$default(AsyncTimeout arg0, long arg1, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = System.nanoTime();
            }

            arg0.setTimeoutAt$okio(arg1);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTimeoutAt");
    }

    public final Sink sink(Sink arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        return new AsyncTimeout$sink$1(this, arg2);
    }

    public final Source source(Source arg2) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        return new AsyncTimeout$source$1(this, arg2);
    }

    protected void timedOut() {
    }

    public final Object withTimeout(Function0 arg2) {
        Object v2_2;
        Intrinsics.checkNotNullParameter(arg2, "block");
        this.enter();
        try {
            v2_2 = arg2.invoke();
        }
        catch(Throwable v2) {
        }
        catch(IOException v2_1) {
            try {
                if(this.exit()) {
                    v2_1 = this.access$newTimeoutException(v2_1);
                }

                throw v2_1;
            }
            catch(Throwable v2) {
                this.exit();
                throw v2;
            }
        }

        if(!this.exit()) {
            return v2_2;
        }

        throw this.access$newTimeoutException(null);
    }
}

