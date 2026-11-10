package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "<init>", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "expectedSegment", "Lokio/Segment;", "expectedPos", "", "closed", "", "pos", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "close", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "upstream");
        super();
        this.upstream = arg2;
        Buffer v2 = arg2.getBuffer();
        this.buffer = v2;
        this.expectedSegment = v2.head;
        Segment v2_1 = v2.head;
        int v2_2 = v2_1 != null ? v2_1.pos : -1;
        this.expectedPos = v2_2;
    }

    public void close() {
        this.closed = true;
    }

    public long read(Buffer arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg9, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg10, v0);
        if(v2 >= 0) {
            if(!this.closed) {
                Segment v3 = this.expectedSegment;
                if(v3 != null) {
                    if(v3 == this.buffer.head) {
                        int v3_1 = this.expectedPos;
                        Segment v4 = this.buffer.head;
                        Intrinsics.checkNotNull(v4);
                        if(v3_1 == v4.pos) {
                            goto label_24;
                        }
                    }

                    throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                }

            label_24:
                if(v2 == 0) {
                    return v0;
                }

                if(!this.upstream.request(this.pos + 1)) {
                    return -1;
                }

                if(this.expectedSegment == null && this.buffer.head != null) {
                    this.expectedSegment = this.buffer.head;
                    Segment v0_1 = this.buffer.head;
                    Intrinsics.checkNotNull(v0_1);
                    this.expectedPos = v0_1.pos;
                }

                long v6 = Math.min(arg10, this.buffer.size() - this.pos);
                this.buffer.copyTo(arg9, this.pos, v6);
                this.pos += v6;
                return v6;
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg10.toString());
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}

