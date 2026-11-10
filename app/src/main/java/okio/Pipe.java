package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010*\u001A\u00020+2\u0006\u0010&\u001A\u00020\u0019J&\u0010,\u001A\u00020+*\u00020\u00192\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b/H\u0082\bJ\r\u0010&\u001A\u00020\u0019H\u0007¢\u0006\u0002\b0J\r\u0010\'\u001A\u00020(H\u0007¢\u0006\u0002\b1J\u0006\u00102\u001A\u00020+R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u000F\"\u0004\b\u0014\u0010\u0011R\u001A\u0010\u0015\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011R\u001C\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\u001F¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\"\u001A\u00020#¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0013\u0010&\u001A\u00020\u00198\u0007¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u001BR\u0013\u0010\'\u001A\u00020(8\u0007¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010)¨\u00063"}, d2={"Lokio/Pipe;", "", "maxBufferSize", "", "<init>", "(J)V", "getMaxBufferSize$okio", "()J", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "sink", "source", "Lokio/Source;", "()Lokio/Source;", "fold", "", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "-deprecated_sink", "-deprecated_source", "cancel", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Pipe {
    private final Buffer buffer;
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final Sink -deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final Source -deprecated_source() {
        return this.source;
    }

    public Pipe(long arg3) {
        super();
        this.maxBufferSize = arg3;
        this.buffer = new Buffer();
        ReentrantLock v0 = new ReentrantLock();
        this.lock = v0;
        Condition v0_1 = v0.newCondition();
        Intrinsics.checkNotNullExpressionValue(v0_1, "newCondition(...)");
        this.condition = v0_1;
        if(arg3 >= 1) {
            this.sink = new Pipe$sink$1(this);
            this.source = new Pipe$source$1(this);
            return;
        }

        throw new IllegalArgumentException("maxBufferSize < 1: " + arg3.toString());
    }

    public final void cancel() {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public final void fold(Sink arg9) throws IOException {
        int v5;
        Buffer v2;
        Buffer v3;
        ReentrantLock v0;
        Intrinsics.checkNotNullParameter(arg9, "sink");
        while(true) {
            v0 = this.lock;
            ((Lock)v0).lock();
            try {
                if(this.foldedSink != null) {
                    goto label_59;
                }

                if(this.canceled) {
                    break;
                }

                boolean v1 = this.sinkClosed;
                v3 = null;
                if(this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = arg9;
                    v2 = v3;
                    v5 = 1;
                }
                else {
                    v2 = new Buffer();
                    v2.write(this.buffer, this.buffer.size());
                    this.condition.signalAll();
                    v5 = 0;
                }
            }
            catch(Throwable v8) {
                goto label_65;
            }

            ((Lock)v0).unlock();
            if(v5 != 0) {
                if(v1) {
                    arg9.close();
                }

                return;
            }

            if(v2 == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("sinkBuffer");
                    goto label_38;
                label_37:
                    v3 = v2;
                label_38:
                    arg9.write(v3, v2.size());
                    arg9.flush();
                    continue;
                }
                catch(Throwable v9) {
                    v0 = this.lock;
                    ((Lock)v0).lock();
                    try {
                        this.sourceClosed = true;
                        this.condition.signalAll();
                    }
                    catch(Throwable v8) {
                        ((Lock)v0).unlock();
                        throw v8;
                    }

                    ((Lock)v0).unlock();
                    throw v9;
                }
            }
            else {
                goto label_37;
            }

            goto label_38;
        }

        try {
            this.foldedSink = arg9;
            throw new IOException("canceled");
        label_59:
            throw new IllegalStateException("sink already folded".toString());
        }
        catch(Throwable v8) {
        label_65:
            ((Lock)v0).unlock();
            throw v8;
        }
    }

    private final void forward(Sink arg10, Function1 arg11) {
        Timeout v0 = arg10.timeout();
        Timeout v9 = this.sink().timeout();
        long v1 = v0.timeoutNanos();
        v0.timeout(Timeout.Companion.minTimeout(v9.timeoutNanos(), v0.timeoutNanos()), TimeUnit.NANOSECONDS);
        if(v0.hasDeadline()) {
            long v3 = v0.deadlineNanoTime();
            if(v9.hasDeadline()) {
                v0.deadlineNanoTime(Math.min(v0.deadlineNanoTime(), v9.deadlineNanoTime()));
            }

            try {
                arg11.invoke(arg10);
            }
            catch(Throwable v10) {
                v0.timeout(v1, TimeUnit.NANOSECONDS);
                if(v9.hasDeadline()) {
                    v0.deadlineNanoTime(v3);
                }

                throw v10;
            }

            v0.timeout(v1, TimeUnit.NANOSECONDS);
            if(v9.hasDeadline()) {
                v0.deadlineNanoTime(v3);
            }

            return;
        }

        if(v9.hasDeadline()) {
            v0.deadlineNanoTime(v9.deadlineNanoTime());
        }

        try {
            arg11.invoke(arg10);
        }
        catch(Throwable v10) {
            v0.timeout(v1, TimeUnit.NANOSECONDS);
            if(v9.hasDeadline()) {
                v0.clearDeadline();
            }

            throw v10;
        }

        v0.timeout(v1, TimeUnit.NANOSECONDS);
        if(v9.hasDeadline()) {
            v0.clearDeadline();
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean arg1) {
        this.canceled = arg1;
    }

    public final void setFoldedSink$okio(Sink arg1) {
        this.foldedSink = arg1;
    }

    public final void setSinkClosed$okio(boolean arg1) {
        this.sinkClosed = arg1;
    }

    public final void setSourceClosed$okio(boolean arg1) {
        this.sourceClosed = arg1;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}

