package okio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J$\u0010\u0007\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u0003H\u0007J\u0015\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003H\u0000¢\u0006\u0002\b\u0015J\u001D\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003H\u0000¢\u0006\u0002\b\u0018J\f\u0010\u0019\u001A\u00020\u0003*\u00020\u0003H\u0002J\f\u0010\u001A\u001A\u00020\u0003*\u00020\u0003H\u0002J\u000E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u001CJ\u000E\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001ER\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001F"}, d2={"Lokio/Throttler;", "", "allocatedUntil", "", "<init>", "(J)V", "()V", "bytesPerSecond", "waitByteCount", "maxByteCount", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "", "take", "byteCount", "take$okio", "byteCountOrWaitNanos", "now", "byteCountOrWaitNanos$okio", "nanosToBytes", "bytesToNanos", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private final Condition condition;
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler() {
        this(System.nanoTime());
    }

    public Throttler(long arg1) {
        super();
        this.allocatedUntil = arg1;
        this.waitByteCount = 0x2000;
        this.maxByteCount = 0x40000;
        ReentrantLock v1 = new ReentrantLock();
        this.lock = v1;
        Condition v1_1 = v1.newCondition();
        Intrinsics.checkNotNullExpressionValue(v1_1, "newCondition(...)");
        this.condition = v1_1;
    }

    public final long byteCountOrWaitNanos$okio(long arg10, long arg12) {
        long v2 = 0;
        if(this.bytesPerSecond == v2) {
            return arg12;
        }

        long v0 = Math.max(this.allocatedUntil - arg10, v2);
        long v4 = this.maxByteCount - this.nanosToBytes(v0);
        if(v4 >= arg12) {
            this.allocatedUntil = arg10 + v0 + this.bytesToNanos(arg12);
            return arg12;
        }

        long v6 = this.waitByteCount;
        if(v4 >= v6) {
            this.allocatedUntil = arg10 + this.bytesToNanos(this.maxByteCount);
            return v4;
        }

        arg12 = Math.min(v6, arg12);
        v0 += this.bytesToNanos(arg12 - this.maxByteCount);
        if(v0 == v2) {
            this.allocatedUntil = arg10 + this.bytesToNanos(this.maxByteCount);
            return arg12;
        }

        return -v0;
    }

    public final void bytesPerSecond(long arg6, long arg8, long arg10) {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        long v1 = 0;
        String v4 = "Failed requirement.";
        if(Long.compare(arg6, v1) < 0) {
            goto label_24;
        }

        if(arg8 <= v1) {
            goto label_20;
        }

        if(arg10 >= arg8) {
            try {
                this.bytesPerSecond = arg6;
                this.waitByteCount = arg8;
                this.maxByteCount = arg10;
                this.condition.signalAll();
            }
            catch(Throwable v5) {
                goto label_29;
            }

            ((Lock)v0).unlock();
            return;
        }

        try {
            throw new IllegalArgumentException(v4.toString());
        label_20:
            throw new IllegalArgumentException(v4.toString());
        label_24:
            throw new IllegalArgumentException(v4.toString());
        }
        catch(Throwable v5) {
        label_29:
            ((Lock)v0).unlock();
            throw v5;
        }
    }

    public final void bytesPerSecond(long arg10) {
        Throttler.bytesPerSecond$default(this, arg10, 0, 0, 6, null);
    }

    public final void bytesPerSecond(long arg10, long arg12) {
        Throttler.bytesPerSecond$default(this, arg10, arg12, 0, 4, null);
    }

    public static void bytesPerSecond$default(Throttler arg7, long arg8, long arg10, long arg12, int arg14, Object arg15) {
        if((arg14 & 2) != 0) {
            arg10 = arg7.waitByteCount;
        }

        long v3 = arg10;
        if((arg14 & 4) != 0) {
            arg12 = arg7.maxByteCount;
        }

        arg7.bytesPerSecond(arg8, v3, arg12);
    }

    private final long bytesToNanos(long arg3) {
        return arg3 * 1000000000 / this.bytesPerSecond;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    private final long nanosToBytes(long arg3) {
        return arg3 * this.bytesPerSecond / 1000000000;
    }

    public final Sink sink(Sink arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        return new Throttler$sink$1(arg2, this);
    }

    public final Source source(Source arg2) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        return new Throttler$source$1(arg2, this);
    }

    public final long take$okio(long arg7) {
        long v3;
        long v0 = 0;
        if(arg7 <= v0) {
            goto label_16;
        }

        ReentrantLock v2 = this.lock;
        ((Lock)v2).lock();
        try {
            while(true) {
            label_4:
                v3 = this.byteCountOrWaitNanos$okio(System.nanoTime(), arg7);
                if(v3 < v0) {
                    goto label_9;
                }

                break;
            }
        }
        catch(Throwable v6) {
            goto label_14;
        }

        ((Lock)v2).unlock();
        return v3;
        try {
        label_9:
            this.condition.awaitNanos(-v3);
            goto label_4;
        }
        catch(Throwable v6) {
        label_14:
            ((Lock)v2).unlock();
            throw v6;
        }

    label_16:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

