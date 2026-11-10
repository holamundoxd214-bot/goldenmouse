package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.DurationUnitKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\b\u001A\u00020\u0007H\u0016J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0016\u0010\r\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fJ\b\u0010\u000F\u001A\u00020\u0000H\u0016J\b\u0010\u0010\u001A\u00020\u0000H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0012H\u0016J\u0010\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0001H\u0016J-\u0010\u0019\u001A\u0002H\u001A\"\u0004\b\u0000\u0010\u001A2\u0006\u0010\u001B\u001A\u00020\u00002\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u001DH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2={"Lokio/Timeout;", "", "<init>", "()V", "hasDeadline", "", "deadlineNanoTime", "", "timeoutNanos", "cancelMark", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "deadline", "duration", "clearTimeout", "clearDeadline", "throwIfReached", "", "cancel", "awaitSignal", "condition", "Ljava/util/concurrent/locks/Condition;", "waitUntilNotified", "monitor", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class Timeout {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0006\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0019\u0010\u0006\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lokio/Timeout$Companion;", "", "<init>", "()V", "NONE", "Lokio/Timeout;", "timeout", "", "unit", "Lkotlin/time/DurationUnit;", "duration", "Lkotlin/time/Duration;", "timeout-HG0u8IE", "(Lokio/Timeout;J)Lokio/Timeout;", "minTimeout", "aNanos", "bNanos", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long minTimeout(long arg3, long arg5) {
            long v0 = 0;
            if(arg3 == v0) {
            }
            else {
                if(arg5 == v0) {
                }
                else {
                    if(arg3 < arg5) {
                        return arg3;
                    }

                    return arg5;
                }

                return arg3;
            }

            return arg5;
        }

        public final Timeout timeout(Timeout arg1, long arg2, DurationUnit arg4) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            Intrinsics.checkNotNullParameter(arg4, "unit");
            return arg1.timeout(arg2, DurationUnitKt.toTimeUnit(arg4));
        }

        public final Timeout timeout-HG0u8IE(Timeout arg1, long arg2) {
            Intrinsics.checkNotNullParameter(arg1, "$this$timeout");
            return arg1.timeout(Duration.getInWholeNanoseconds-impl(arg2), TimeUnit.NANOSECONDS);
        }
    }

    public static final Companion Companion;
    public static final Timeout NONE;
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static {
        Timeout.Companion = new Companion(null);
        Timeout.NONE = new Timeout$Companion$NONE$1();
    }

    public Timeout() {
        super();
    }

    public void awaitSignal(Condition arg10) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(arg10, "condition");
        try {
            boolean v0 = this.hasDeadline();
            long v1 = this.timeoutNanos();
            long v3 = 0;
            if(!v0 && v1 == v3) {
                arg10.await();
                return;
            }

            if((v0) && v1 != v3) {
                v1 = Math.min(v1, this.deadlineNanoTime() - System.nanoTime());
            }
            else if(v0) {
                v1 = this.deadlineNanoTime() - System.nanoTime();
            }
        }
        catch(InterruptedException ) {
            goto label_36;
        }

        String v5 = "timeout";
        if(Long.compare(v1, v3) <= 0) {
            goto label_33;
        }

        try {
            Object v0_1 = this.cancelMark;
            if(arg10.awaitNanos(v1) > v3) {
            }
            else {
                if(this.cancelMark != v0_1) {
                    return;
                }

                goto label_30;
            }

            return;
        label_30:
            throw new InterruptedIOException(v5);
        label_33:
            throw new InterruptedIOException(v5);
        }
        catch(InterruptedException ) {
        label_36:
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long arg3, TimeUnit arg5) {
        Intrinsics.checkNotNullParameter(arg5, "unit");
        if(arg3 > 0) {
            return this.deadlineNanoTime(System.nanoTime() + arg5.toNanos(arg3));
        }

        throw new IllegalArgumentException("duration <= 0: " + arg3.toString());
    }

    public long deadlineNanoTime() {
        if(this.hasDeadline) {
            return this.deadlineNanoTime;
        }

        throw new IllegalStateException("No deadline".toString());
    }

    public Timeout deadlineNanoTime(long arg2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = arg2;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final Object intersectWith(Timeout arg9, Function0 arg10) {
        Object v10_1;
        Intrinsics.checkNotNullParameter(arg9, "other");
        Intrinsics.checkNotNullParameter(arg10, "block");
        long v0 = this.timeoutNanos();
        this.timeout(Timeout.Companion.minTimeout(arg9.timeoutNanos(), this.timeoutNanos()), TimeUnit.NANOSECONDS);
        if(this.hasDeadline()) {
            long v2 = this.deadlineNanoTime();
            if(arg9.hasDeadline()) {
                this.deadlineNanoTime(Math.min(this.deadlineNanoTime(), arg9.deadlineNanoTime()));
            }

            try {
                v10_1 = arg10.invoke();
            }
            catch(Throwable v10) {
                this.timeout(v0, TimeUnit.NANOSECONDS);
                if(arg9.hasDeadline()) {
                    this.deadlineNanoTime(v2);
                }

                throw v10;
            }

            this.timeout(v0, TimeUnit.NANOSECONDS);
            if(arg9.hasDeadline()) {
                this.deadlineNanoTime(v2);
            }

            return v10_1;
        }

        if(arg9.hasDeadline()) {
            this.deadlineNanoTime(arg9.deadlineNanoTime());
        }

        try {
            v10_1 = arg10.invoke();
        }
        catch(Throwable v10) {
            this.timeout(v0, TimeUnit.NANOSECONDS);
            if(arg9.hasDeadline()) {
                this.clearDeadline();
            }

            throw v10;
        }

        this.timeout(v0, TimeUnit.NANOSECONDS);
        if(arg9.hasDeadline()) {
            this.clearDeadline();
        }

        return v10_1;
    }

    public void throwIfReached() throws IOException {
        if(!Thread.currentThread().isInterrupted()) {
            if(this.hasDeadline) {
                if(this.deadlineNanoTime - System.nanoTime() > 0) {
                }
                else {
                    throw new InterruptedIOException("deadline reached");
                }
            }

            return;
        }

        throw new InterruptedIOException("interrupted");
    }

    public Timeout timeout(long arg3, TimeUnit arg5) {
        Intrinsics.checkNotNullParameter(arg5, "unit");
        if(arg3 >= 0) {
            this.timeoutNanos = arg5.toNanos(arg3);
            return this;
        }

        throw new IllegalArgumentException("timeout < 0: " + arg3.toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object arg12) throws InterruptedIOException {
        long v3;
        long v1;
        Intrinsics.checkNotNullParameter(arg12, "monitor");
        try {
            boolean v0 = this.hasDeadline();
            v1 = this.timeoutNanos();
            v3 = 0;
            if(!v0 && v1 == v3) {
                arg12.wait();
                return;
            }

            long v5 = System.nanoTime();
            if((v0) && v1 != v3) {
                v1 = Math.min(v1, this.deadlineNanoTime() - v5);
            }
            else if(v0) {
                v1 = this.deadlineNanoTime() - v5;
            }
        }
        catch(InterruptedException ) {
            goto label_42;
        }

        int v0_1 = Long.compare(v1, v3);
        String v3_1 = "timeout";
        if(v0_1 <= 0) {
            goto label_39;
        }

        try {
            Object v0_2 = this.cancelMark;
            long v9 = v1 / 1000000;
            arg12.wait(v9, ((int)(v1 - 1000000 * v9)));
            if(System.nanoTime() - v5 < v1) {
            }
            else {
                if(this.cancelMark != v0_2) {
                    return;
                }

                goto label_36;
            }

            return;
        label_36:
            throw new InterruptedIOException(v3_1);
        label_39:
            throw new InterruptedIOException(v3_1);
        }
        catch(InterruptedException ) {
        label_42:
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

