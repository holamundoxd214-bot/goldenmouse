package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0013H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0002J\b\u0010\u0019\u001A\u00020\u0018H\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u0018H\u0016J \u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u00152\u0006\u0010\u001F\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0013H\u0002J \u0010 \u001A\u00020\u00182\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020$H\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00060\u000Fj\u0002`\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006&"}, d2={"Lokio/GzipSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "section", "", "Lokio/RealBufferedSource;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "crc", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "Ljava/util/zip/CRC32;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "consumeHeader", "", "consumeTrailer", "timeout", "Lokio/Timeout;", "close", "updateCrc", "buffer", "offset", "checkEqual", "name", "", "expected", "", "actual", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source arg3) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        super();
        RealBufferedSource v0 = new RealBufferedSource(arg3);
        this.source = v0;
        Inflater v3 = new Inflater(true);
        this.inflater = v3;
        this.inflaterSource = new InflaterSource(((BufferedSource)v0), v3);
        this.crc = new CRC32();
    }

    private final void checkEqual(String arg3, int arg4, int arg5) {
        if(arg5 == arg4) {
            return;
        }

        throw new IOException(arg3 + ": actual 0x" + StringsKt.padStart(-SegmentedByteString.toHexString(arg5), 8, '0') + " != expected 0x" + StringsKt.padStart(-SegmentedByteString.toHexString(arg4), 8, '0'));
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    private final void consumeHeader() throws IOException {
        GzipSource v0 = this;
        v0.source.require(10);
        int v6 = v0.source.bufferField.getByte(3);
        int v9 = (v6 >> 1 & 1) == 1 ? 1 : 0;
        if(v9 != 0) {
            v0.updateCrc(v0.source.bufferField, 0, 10);
        }

        v0.checkEqual("ID1ID2", 8075, v0.source.readShort());
        v0.source.skip(8);
        if((v6 >> 2 & 1) == 1) {
            v0.source.require(2);
            if(v9 != 0) {
                v0.updateCrc(v0.source.bufferField, 0, 2);
            }

            long v4 = ((long)(v0.source.bufferField.readShortLe() & 0xFFFF));
            v0.source.require(v4);
            if(v9 != 0) {
                v0.updateCrc(v0.source.bufferField, 0, v4);
            }

            v0.source.skip(v4);
        }

        long v10 = -1;
        long v12 = 1;
        if((v6 >> 3 & 1) == 1) {
            long v14 = v0.source.indexOf(0);
            if(v14 != v10) {
                if(v9 != 0) {
                    v0.updateCrc(v0.source.bufferField, 0, v14 + v12);
                }

                v0.source.skip(v14 + v12);
            }
            else {
                throw new EOFException();
            }
        }

        if((v6 >> 4 & 1) == 1) {
            long v6_1 = v0.source.indexOf(0);
            if(v6_1 != v10) {
                if(v9 != 0) {
                    v0.updateCrc(v0.source.bufferField, 0, v6_1 + v12);
                }

                v0.source.skip(v6_1 + v12);
            }
            else {
                throw new EOFException();
            }
        }

        if(v9 != 0) {
            v0.checkEqual("FHCRC", v0.source.readShortLe(), ((short)(((int)v0.crc.getValue()))));
            v0.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        this.checkEqual("CRC", this.source.readIntLe(), ((int)this.crc.getValue()));
        this.checkEqual("ISIZE", this.source.readIntLe(), ((int)this.inflater.getBytesWritten()));
    }

    public long read(Buffer arg12, long arg13) throws IOException {
        GzipSource v5;
        int v0_2;
        Intrinsics.checkNotNullParameter(arg12, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg13, v0);
        if(v2 >= 0) {
            if(v2 == 0) {
                return v0;
            }

            byte v0_1 = this.section;
            if(v0_1 == 0) {
                this.consumeHeader();
                this.section = 1;
                v0_2 = 1;
            }

            long v2_1 = -1;
            byte v4 = 2;
            if(v0_1 == 1) {
                long v7 = arg12.size();
                long v9 = this.inflaterSource.read(arg12, arg13);
                if(v9 != v2_1) {
                    this.updateCrc(arg12, v7, v9);
                    return v9;
                }
                else {
                    v5 = this;
                    v5.section = v4;
                    v0_2 = v4;
                }
            }
            else {
                v5 = this;
            }

            if(v0_1 == v4) {
                v5.consumeTrailer();
                v5.section = 3;
                if(v5.source.exhausted()) {
                }
                else {
                    throw new IOException("gzip finished without exhausting source");
                }
            }

            return v2_1;
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg13.toString());
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    private final void updateCrc(Buffer arg5, long arg6, long arg8) {
        Segment v5 = arg5.head;
        Intrinsics.checkNotNull(v5);
        while(arg6 >= (((long)(v5.limit - v5.pos)))) {
            arg6 -= ((long)(v5.limit - v5.pos));
            v5 = v5.next;
            Intrinsics.checkNotNull(v5);
        }

        while(true) {
            long v0 = 0;
            if(arg8 <= v0) {
                return;
            }

            int v6 = ((int)((((long)v5.pos)) + arg6));
            int v7 = ((int)Math.min(((long)(v5.limit - v6)), arg8));
            this.crc.update(v5.data, v6, v7);
            arg8 -= ((long)v7);
            v5 = v5.next;
            Intrinsics.checkNotNull(v5);
            arg6 = v0;
        }
    }
}

