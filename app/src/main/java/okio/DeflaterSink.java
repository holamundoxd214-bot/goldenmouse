package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._ZlibJvmKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\nH\u0002J\b\u0010\u0013\u001A\u00020\fH\u0016J\r\u0010\u0014\u001A\u00020\fH\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\fH\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "closed", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "deflate", "syncFlush", "flush", "finishDeflate", "finishDeflate$okio", "close", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink arg2, Deflater arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "deflater");
        this(Okio.buffer(arg2), arg3);
    }

    public DeflaterSink(BufferedSink arg2, Deflater arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "deflater");
        super();
        this.sink = arg2;
        this.deflater = arg3;
    }

    public void close() throws IOException {
        if(this.closed) {
            return;
        }

        try {
            this.finishDeflate$okio();
            v0 = null;
        }
        catch(Throwable v0) {
        }

        try {
            this.deflater.end();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_13;
            }

            v0 = v1;
        }

        try {
        label_13:
            this.sink.close();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_19;
            }

            v0 = v1;
        }

    label_19:
        this.closed = true;
        if(v0 == null) {
            return;
        }

        throw v0;
    }

    private final void deflate(boolean arg9) {
        int v2_1;
        Segment v1;
        Buffer v0 = this.sink.getBuffer();
        do {
        label_2:
            v1 = v0.writableSegment$okio(1);
            Deflater v2 = this.deflater;
            String v3 = "Deflater already closed";
            if(arg9) {
                try {
                    v2_1 = v2.deflate(v1.data, v1.limit, 0x2000 - v1.limit, 2);
                    goto label_19;
                label_14:
                    v2_1 = v2.deflate(v1.data, v1.limit, 0x2000 - v1.limit);
                }
                catch(NullPointerException v8) {
                    throw new IOException(v3, ((Throwable)v8));
                }
                catch(IllegalStateException v8_1) {
                    throw new IOException(v3, ((Throwable)v8_1));
                }
            }
            else {
                goto label_14;
            }

        label_19:
            if(v2_1 > 0) {
                v1.limit += v2_1;
                v0.setSize$okio(v0.size() + (((long)v2_1)));
                this.sink.emitCompleteSegments();
                goto label_2;
            }
        }
        while(!this.deflater.needsInput());

        if(v1.pos == v1.limit) {
            v0.head = v1.pop();
            SegmentPool.recycle(v1);
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        this.deflate(false);
    }

    public void flush() throws IOException {
        this.deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    public void write(Buffer arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "source");
        -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, arg9);
        while(Long.compare(arg9, 0) > 0) {
            Segment v0 = arg8.head;
            Intrinsics.checkNotNull(v0);
            int v2 = ((int)Math.min(arg9, ((long)(v0.limit - v0.pos))));
            this.deflater.setInput(v0.data, v0.pos, v2);
            this.deflate(false);
            long v5 = ((long)v2);
            arg8.setSize$okio(arg8.size() - v5);
            v0.pos += v2;
            if(v0.pos == v0.limit) {
                arg8.head = v0.pop();
                SegmentPool.recycle(v0);
            }

            arg9 -= v5;
        }

        this.deflater.setInput(_ZlibJvmKt.getEMPTY_BYTE_ARRAY(), 0, 0);
    }
}

