package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\tH\u0016J\b\u0010\u000F\u001A\u00020\tH\u0016J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "flush", "close", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream arg2, Timeout arg3) {
        Intrinsics.checkNotNullParameter(arg2, "out");
        Intrinsics.checkNotNullParameter(arg3, "timeout");
        super();
        this.out = arg2;
        this.timeout = arg3;
    }

    public void close() {
        this.out.close();
    }

    public void flush() {
        this.out.flush();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    public void write(Buffer arg8, long arg9) {
        Intrinsics.checkNotNullParameter(arg8, "source");
        -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, arg9);
        while(arg9 > 0) {
            this.timeout.throwIfReached();
            Segment v0 = arg8.head;
            Intrinsics.checkNotNull(v0);
            int v1 = ((int)Math.min(arg9, ((long)(v0.limit - v0.pos))));
            this.out.write(v0.data, v0.pos, v1);
            v0.pos += v1;
            long v1_1 = ((long)v1);
            arg9 -= v1_1;
            arg8.setSize$okio(arg8.size() - v1_1);
            if(v0.pos != v0.limit) {
                continue;
            }

            arg8.head = v0.pop();
            SegmentPool.recycle(v0);
        }
    }
}

