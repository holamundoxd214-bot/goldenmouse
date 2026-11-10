package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000EH\u0016J\u0016\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000EJ\u0006\u0010\u0013\u001A\u00020\fJ\b\u0010\u0014\u001A\u00020\u0015H\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0015H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lokio/InflaterSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "inflater", "Ljava/util/zip/Inflater;", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readOrInflate", "refill", "releaseBytesAfterInflate", "", "timeout", "Lokio/Timeout;", "close", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source arg2, Inflater arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "inflater");
        this(Okio.buffer(arg2), arg3);
    }

    public InflaterSource(BufferedSource arg2, Inflater arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "inflater");
        super();
        this.source = arg2;
        this.inflater = arg3;
    }

    public void close() throws IOException {
        if(this.closed) {
            return;
        }

        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    public long read(Buffer arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        while(true) {
            long v0 = this.readOrInflate(arg5, arg6);
            if(v0 > 0) {
                return v0;
            }

            if(!this.inflater.finished()) {
                if(this.inflater.needsDictionary()) {
                }
                else if(!this.source.exhausted()) {
                    continue;
                }
                else {
                    break;
                }
            }

            return -1;
        }

        throw new EOFException("source exhausted prematurely");
        return -1;
    }

    public final long readOrInflate(Buffer arg6, long arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg6, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg7, v0);
        if(v2 >= 0) {
            if(!this.closed) {
                if(v2 == 0) {
                    return v0;
                }

                try {
                    Segment v2_1 = arg6.writableSegment$okio(1);
                    int v7 = ((int)Math.min(arg7, ((long)(0x2000 - v2_1.limit))));
                    this.refill();
                    v7 = this.inflater.inflate(v2_1.data, v2_1.limit, v7);
                    this.releaseBytesAfterInflate();
                    if(v7 > 0) {
                        v2_1.limit += v7;
                        arg7 = ((long)v7);
                        arg6.setSize$okio(arg6.size() + arg7);
                        return arg7;
                    }

                    if(v2_1.pos == v2_1.limit) {
                        arg6.head = v2_1.pop();
                        SegmentPool.recycle(v2_1);
                    }
                }
                catch(DataFormatException v5) {
                    throw new IOException(((Throwable)v5));
                }

                return v0;
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg7.toString());
    }

    public final boolean refill() throws IOException {
        if(!this.inflater.needsInput()) {
            return 0;
        }

        if(this.source.exhausted()) {
            return 1;
        }

        Segment v0 = this.source.getBuffer().head;
        Intrinsics.checkNotNull(v0);
        this.bufferBytesHeldByInflater = v0.limit - v0.pos;
        this.inflater.setInput(v0.data, v0.pos, this.bufferBytesHeldByInflater);
        return 0;
    }

    private final void releaseBytesAfterInflate() {
        int v0 = this.bufferBytesHeldByInflater;
        if(v0 == 0) {
            return;
        }

        v0 -= this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= v0;
        this.source.skip(((long)v0));
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}

