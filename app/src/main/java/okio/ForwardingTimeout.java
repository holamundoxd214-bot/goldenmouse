package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000E\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001J\u0018\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\bH\u0016J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\bH\u0016J\u0010\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\bH\u0016J\b\u0010\u000F\u001A\u00020\u0001H\u0016J\b\u0010\u0010\u001A\u00020\u0001H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0012H\u0016J\u0010\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0019H\u0016R\u001C\u0010\u0002\u001A\u00020\u00018\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u001A"}, d2={"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "hasDeadline", "", "deadlineNanoTime", "clearTimeout", "clearDeadline", "throwIfReached", "", "cancel", "awaitSignal", "condition", "Ljava/util/concurrent/locks/Condition;", "waitUntilNotified", "monitor", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super();
        this.delegate = arg2;
    }

    public void awaitSignal(Condition arg2) {
        Intrinsics.checkNotNullParameter(arg2, "condition");
        this.delegate.awaitSignal(arg2);
    }

    public void cancel() {
        this.delegate.cancel();
    }

    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public Timeout deadlineNanoTime(long arg1) {
        return this.delegate.deadlineNanoTime(arg1);
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        this.delegate = arg2;
        return this;
    }

    public final void setDelegate(Timeout arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.delegate = arg2;
    }

    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    public Timeout timeout(long arg2, TimeUnit arg4) {
        Intrinsics.checkNotNullParameter(arg4, "unit");
        return this.delegate.timeout(arg2, arg4);
    }

    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    public void waitUntilNotified(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "monitor");
        this.delegate.waitUntilNotified(arg2);
    }
}

