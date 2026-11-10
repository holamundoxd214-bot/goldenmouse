package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._JavaIoKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "read", "", "sink", "Lokio/Buffer;", "byteCount", "close", "", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream arg2, Timeout arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg3, "timeout");
        super();
        this.input = arg2;
        this.timeout = arg3;
    }

    public void close() {
        this.input.close();
    }

    public long read(Buffer arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg4, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg5, v0);
        if(v2 == 0) {
            return v0;
        }

        if(v2 >= 0) {
            try {
                this.timeout.throwIfReached();
                Segment v0_1 = arg4.writableSegment$okio(1);
                int v3_1 = this.input.read(v0_1.data, v0_1.limit, ((int)Math.min(arg5, ((long)(0x2000 - v0_1.limit)))));
                if(v3_1 == -1) {
                    if(v0_1.pos == v0_1.limit) {
                        arg4.head = v0_1.pop();
                        SegmentPool.recycle(v0_1);
                    }

                    return -1;
                }

                v0_1.limit += v3_1;
                v0 = ((long)v3_1);
                arg4.setSize$okio(arg4.size() + v0);
                return v0;
            }
            catch(AssertionError v3) {
                if(_JavaIoKt.isAndroidGetsocknameError(v3)) {
                    throw new IOException(((Throwable)v3));
                }

                throw v3;
            }
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg5.toString());
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}

