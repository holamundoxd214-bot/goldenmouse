package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._ZlibJvmKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u0014H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u0014H\u0016J\b\u0010\u001D\u001A\u00020\u0014H\u0002J\u0018\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0002J\u0013\u0010\u0006\u001A\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b \u0010\tR\u000E\u0010\u0002\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001A\u00060\u0007j\u0002`\b8\u0007¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u0006\u0010\tR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/RealBufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/Deflater;", "()Ljava/util/zip/Deflater;", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "closed", "", "crc", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "Ljava/util/zip/CRC32;", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "flush", "timeout", "Lokio/Timeout;", "close", "writeFooter", "updateCrc", "buffer", "-deprecated_deflater", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final Deflater -deprecated_deflater() {
        return this.deflater;
    }

    public GzipSink(Sink arg4) {
        Intrinsics.checkNotNullParameter(arg4, "sink");
        super();
        RealBufferedSink v0 = new RealBufferedSink(arg4);
        this.sink = v0;
        Deflater v4 = new Deflater(_ZlibJvmKt.getDEFAULT_COMPRESSION(), true);
        this.deflater = v4;
        this.deflaterSink = new DeflaterSink(v0, v4);
        this.crc = new CRC32();
        Buffer v3 = v0.bufferField;
        v3.writeShort(8075);
        v3.writeByte(8);
        v3.writeByte(0);
        v3.writeInt(0);
        v3.writeByte(0);
        v3.writeByte(0);
    }

    public void close() throws IOException {
        if(this.closed) {
            return;
        }

        try {
            this.deflaterSink.finishDeflate$okio();
            this.writeFooter();
            v0 = null;
        }
        catch(Throwable v0) {
        }

        try {
            this.deflater.end();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_15;
            }

            v0 = v1;
        }

        try {
        label_15:
            this.sink.close();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_21;
            }

            v0 = v1;
        }

    label_21:
        this.closed = true;
        if(v0 == null) {
            return;
        }

        throw v0;
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    private final void updateCrc(Buffer arg5, long arg6) {
        Segment v5 = arg5.head;
        Intrinsics.checkNotNull(v5);
        while(arg6 > 0) {
            int v0 = ((int)Math.min(arg6, ((long)(v5.limit - v5.pos))));
            this.crc.update(v5.data, v5.pos, v0);
            arg6 -= ((long)v0);
            v5 = v5.next;
            Intrinsics.checkNotNull(v5);
        }
    }

    public void write(Buffer arg3, long arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "source");
        int v0 = Long.compare(arg4, 0);
        if(v0 >= 0) {
            if(v0 == 0) {
                return;
            }

            this.updateCrc(arg3, arg4);
            this.deflaterSink.write(arg3, arg4);
            return;
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg4.toString());
    }

    private final void writeFooter() {
        this.sink.writeIntLe(((int)this.crc.getValue()));
        this.sink.writeIntLe(((int)this.deflater.getBytesRead()));
    }
}

